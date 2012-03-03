/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;

import javax.faces.context.FacesContext;
import com.icesoft.faces.context.effects.Effect;
import com.icesoft.faces.context.effects.Highlight;
import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;


/**
 *
 * @author Luis Granados
 */
public class LoginBean {
    private String identificacion;
    private String nombre;
    private Integer estado;
    private String contrasena;
    private Integer rol;
    private Integer nIntentosLogin;
    private String msg;
    private Boolean disableComponent=true;
    RolBean ins_RolBean;
    private String vst_ius_por_rol;

    /* CONSTRUCTORES */
    public LoginBean()
    {
        this.identificacion = "";
        this.nombre = "";
        this.estado = 0;
        this.contrasena = "";
        this.rol = 0;
        this.nIntentosLogin = 0;
        this.msg = "";
        this.ins_RolBean = new RolBean(0,"","","");
        this.disableComponent = true;
    }

    public LoginBean(String pIidentificacion, String pNombre, Integer pEstado, String pContrasena, Integer pRol, Integer pIntentosLoging, String pMsg) {
        this.identificacion = pIidentificacion;
        this.nombre = pNombre;
        this.estado = pEstado;
        this.contrasena = pContrasena;
        this.rol = pRol;
        this.nIntentosLogin = pIntentosLoging;
        this.msg = pMsg;
    }

    /* PROPIEDADES */
    
    // ATRIBUTO: contrasena
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    // ATRIBUTO: estado
    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
    // ATRIBUTO: identificacion
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    // ATRIBUTO: nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    // ATRIBUTO: rol
    public Integer getRol() { return rol; }
    public void setRol(Integer rol) { this.rol = rol; }
    // ATRIBUTO: nIntentosLogin
    public Integer getNIntentosLogin() { return nIntentosLogin; }
    public void setNIntentosLogin(Integer nIntentosLogin) { this.nIntentosLogin = nIntentosLogin; }
    // ATRIBUTO: msg
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public Boolean getDisableComponent() { return disableComponent; }
    public void setDisableComponent(Boolean disableComponent) { this.disableComponent = disableComponent; }

    public String getVst_f() { return vst_ius_por_rol; }
    public void setVst_f(String vst_ius_por_rol) { this.vst_ius_por_rol = vst_ius_por_rol; }


    /* METODOS QUE VALIDAN EL ACCESO AL SISTEMA Y A COMPONENTES */

    /*
     * Verifiva si un usuario esta autentificado en el sistema:
     * un usuario no esta autentifivado en el sistema hasta que este no se haya activdo.
     */
    public String verificarAutentificacion() throws Exception
    {
        // se valida que el usuario y el password ingresados tengan datos
        this.setMsg("");
        String vst_mensaje="";
        if(this.getIdentificacion().equals(""))vst_mensaje+= vst_mensaje.equals("")?" el Usuario":" y el Usuario";
        if(this.getContrasena().equals(""))vst_mensaje+= vst_mensaje.equals("")?" la Contraseña":" y la Contraseña";
        if(!vst_mensaje.equals(""))vst_mensaje = "Debe ingresar "+ vst_mensaje;

        if(!vst_mensaje.equals(""))
        {
            this.setMsg(vst_mensaje);
            return "logout";
        }
        else
        {
            vst_mensaje = "";

            // VALIDA MAXIMO 3 INTENTOS PARA ACCESAR AL SISTEMA
            this.setNIntentosLogin(this.getNIntentosLogin()+1);
            if(this.getNIntentosLogin()>= 3)
            {
                this.setMsg("Usted excedió el número de intentos permitido.");
                this.setIdentificacion("");
                this.setContrasena("");
                vst_mensaje = "logout";
            }
            else
            {
                //=========================================================
                //     USUARIO Y CONTRASEÑA POR DEFAULT PARA ACCESAR
                //=========================================================
                //     USUARIO = admin         CONTRASEÑA: UNA

                if(this.getIdentificacion().toLowerCase().equals("admin") &&
                   this.getContrasena().toLowerCase().equals("una"))
                {
                    this.setRol(1);
                    this.setEstado(1);
                    this.setNombre("Admin");
                }
                else
                    Servicio.loginConsultar(this);

                // valida autentificacion de usuario
                if(!this.getIdentificacion().equals(""))
                {
                    if(this.getEstado() == 0)
                    {
                        this.setMsg("Usted no se encuentra autentificado. Comuníquese con el administrador del sistema.");
                        vst_mensaje = "logout";
                    }
                    else if(!this.getContrasena().equals(""))
                    {
                        this.setNIntentosLogin(0);
                        vst_mensaje = "autenticado";
                        this.setMsg("");

                        // se valida el rol para el acceso a los componentes
                        this.ins_RolBean.setIdRol(this.getRol());
                        Servicio.rolConsultar(this.ins_RolBean);

                        // se valida el acceso a los botones Registrar y Actualizar del mant.usuarios
                        this.validarAcceso();

                        // se valida el acceso a las pantallas de usuario de acuerdo al rol
                        IUsPorRolBean ins_iusxrolBean = new IUsPorRolBean("","",false);
                        ins_iusxrolBean.setIdRol(this.getRol());
                        Servicio.IUsporRolListar_MisIUs_PorRol(ins_iusxrolBean);
                        this.setVst_f(this.validarIUsPermitidas(ins_iusxrolBean));
                    }
                }
                else
                    vst_mensaje = "logout";
            }
            if(vst_mensaje.equals("logout"))
            {
                if(this.getNIntentosLogin() < 3)
                    this.setear_this_ins_LoginBean(this, "", this.getMsg());
                else
                    this.setear_this_ins_LoginBean(new LoginBean(), "", this.getMsg());
            }
            return vst_mensaje;
        }
    }

    /* 
     * valida el acceso a componentes (botones Registrar y Actualizar)
     * del frm_mantenimiento_usuarios de acuerdo al rol de usuario.
     */
    private void validarAcceso()
    {
        if(this.ins_RolBean != null && 
           (this.ins_RolBean.getNombreRol().substring(0, 5).toLowerCase().equals("admin") ||
            this.ins_RolBean != null && this.ins_RolBean.getNombreRol().toLowerCase().equals("adm")))
        {
            this.setDisableComponent(false);
        }
    }

    /* valida las pantallas a las que tiene acceso un usuario de acuerdo al rol.*/
    private String validarIUsPermitidas(IUsPorRolBean ins_iusxRolBean)
    {
        String vst_iusPermitidas = "";
        if(!ins_iusxRolBean.getList_ins_iusPorRolBean().isEmpty())
        {
            for(int i = 0; i < ins_iusxRolBean.getList_ins_iusPorRolBean().size();i++)
            {
                if(i < ins_iusxRolBean.getList_ins_iusPorRolBean().size()-1)
                    vst_iusPermitidas += ins_iusxRolBean.getList_ins_iusPorRolBean().get(i)+",";
                else
                    vst_iusPermitidas += ins_iusxRolBean.getList_ins_iusPorRolBean().get(i);
            }
        }
        return vst_iusPermitidas;
    }

    /* Inicializa el objeto loginBean */
    public String Logout() throws Exception
    {
        this.setear_this_ins_LoginBean(this, "", this.getMsg());

        return  "logout";
    }

    /* Setea el objeto loginBean */
    private void setear_this_ins_LoginBean(LoginBean ins_loginBean, String p_vst_contrasena, String p_vst_msg)
    {
        this.setIdentificacion(ins_loginBean.getIdentificacion());
        this.setNombre(ins_loginBean.getNombre());
        this.setEstado(ins_loginBean.getEstado());
        this.setRol(ins_loginBean.getRol());
        this.setContrasena(p_vst_contrasena.trim());
        this.setMsg(p_vst_msg);
    }

    /* METODOS DE UTILIZADOS PARA PRUEBAS */

    /* Metodo de prueba para crear el menu en el form desde el el Bean
     * Debo eliminarlo en la fase final
     */
    public String cargarMenu_innerHTML(String losforms)
    {
		//var losforms = 'frm_mantenimiento_usuarios,frm_aprobar_prestamo,frm_aprobar_remision,frm_consultar_prestamo,frm_consultar_remision,frm_llenar_remision,frm_parametros,frm_solicitar_prestamo,frm_reporte_prestamo,frm_reporte_remision,frm_admin_roles,frm_admin_ius_por_rol,frm_admin_serie_documental,frm_admin_mensajes_ayuda,frm_inicio';
		//var losforms = 'frm_mantenimiento_usuarios,frm_consultar_prestamo,frm_consultar_remision,frm_llenar_remision,frm_solicitar_prestamo,frm_inicio';

        String vst_codigoHtml = "";
		//vst_codigoHtml += "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"855\">";
		vst_codigoHtml += "                    <tr>";
		vst_codigoHtml += "              	      <td  align=\"left\">";
		vst_codigoHtml += "              	      	<img src=\"imagenes/logoSIA.jpg\" height=\"100\" width=\"100\"/>";
		vst_codigoHtml += "              	      </td>";
		vst_codigoHtml += "                        <td>";
		vst_codigoHtml += "                            <div id=\"menu\" align=\"center\">";
		vst_codigoHtml += "                                <ul class=\"menu\">";
		vst_codigoHtml += "                                    <li><a href=\"#\" class=\"parent\"><span>Expedientes</span></a>";
        if(losforms.indexOf("frm_consultar_prestamo") != -1 || losforms.indexOf("frm_solicitar_prestamo") != -1 || losforms.indexOf("frm_aprobar_prestamo") != -1)
        {
            vst_codigoHtml += "                                        <div><ul>";
            if(losforms.indexOf("frm_consultar_prestamo") != -1)
                vst_codigoHtml += "                                               <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_consultar_prestamo.jspx\')\"><span>Consultar Prestamo Expediente</span></a></li>";
            if(losforms.indexOf("frm_solicitar_prestamo") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_solicitar_prestamo.jspx\')\"><span>Solicitar Prestamo Expediente</span></a></li>";
            if(losforms.indexOf("frm_aprobar_prestamo") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_aprobar_prestamo.jspx\')\"><span>Aprobar Prestamo Expediente</span></a></li>";
            vst_codigoHtml += "                                        </ul></div>";
        }
		vst_codigoHtml += "                                    </li>";
		vst_codigoHtml += "                                    <li><a href=\"#\" class=\"parent\"><span>Lista Remision</span></a>";
        if(losforms.indexOf("frm_consultar_remision") != -1 || losforms.indexOf("frm_llenar_remision") != -1 || losforms.indexOf("frm_aprobar_remision") != -1)
        {
            vst_codigoHtml += "                                        <div><ul>";
            if(losforms.indexOf("frm_consultar_remision") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_consultar_remision.jspx\')\"><span>Consultar Lista Remision</span></a></li>";
            if(losforms.indexOf("frm_llenar_remision") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_llenar_remision.jspx\')\"><span>Llenar Lista Remision</span></a></li>";
            if(losforms.indexOf("frm_aprobar_remision") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_aprobar_remision.jspx\')\"><span>Aprobar Lista Remision</span></a></li>";
            vst_codigoHtml += "                                        </ul></div>";
        }
        vst_codigoHtml += "                                    </li>";
        vst_codigoHtml += "                                    <li><a href=\"#\" class=\"parent\"><span>Funcionarios</span></a>";
        if(losforms.indexOf("frm_mantenimiento_usuarios") != -1)
        {
            vst_codigoHtml += "                                        <div><ul>";
            vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_mantenimiento_usuarios.jspx\')\"><span>Administrar Usuarios</span></a></li>";
            vst_codigoHtml += "                                        </ul></div>";
        }
		vst_codigoHtml += "                                    </li>";
		vst_codigoHtml += "                                    <li><a href=\"#\" class=\"parent\"><span>Reportes</span></a>";
        if(losforms.indexOf("frm_reporte_prestamo") != -1 || losforms.indexOf("frm_reporte_remision") != -1)
        {
            vst_codigoHtml += "                                        <div><ul>";
            if(losforms.indexOf("frm_reporte_prestamo") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_reporte_prestamo.jspx\')\"><span>Reportes Prestamo Expedientes</span></a></li>";
            if(losforms.indexOf("frm_reporte_remision") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_reporte_remision.jspx\')\"><span>Reportes Lista de Remision</span></a></li>";
            vst_codigoHtml += "                                        </ul></div>";
        }
		vst_codigoHtml += "                                    </li>";
		vst_codigoHtml += "                                    <li class=\"last\"><a href=\"#\" class=\"parent\"><span>Administracion</span></a>";
        if(losforms.indexOf("frm_parametros") != -1 || losforms.indexOf("frm_admin_roles") != -1 || losforms.indexOf("frm_admin_roles") != -1 || losforms.indexOf("frm_admin_ius_por_rol") != -1 || losforms.indexOf("frm_admin_serie_documental") != -1 || losforms.indexOf("frm_admin_mensajes_ayuda") != -1)
        {
            vst_codigoHtml += "                                        <div><ul>";
            if(losforms.indexOf("frm_parametros") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_parametros.jspx\')\"><span>Parametros SIGEPEX</span></a></li>";
            if(losforms.indexOf("frm_admin_roles") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_roles.jspx\')\"><span>Roles de Usuario</span></a></li>";
            if(losforms.indexOf("frm_admin_ius_por_rol") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_ius_por_rol.jspx\')\"><span>Pantallas por Rol</span></a></li>";
            if(losforms.indexOf("frm_admin_serie_documental") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_serie_documental.jspx\')\"><span>Series Documentales</span></a></li>";
            if(losforms.indexOf("frm_admin_mensajes_ayuda") != -1)
                vst_codigoHtml += "                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_mensajes_ayuda.jspx\')\"><span>Mensajes de Ayuda</span></a></li>";
            vst_codigoHtml += "                                        </ul></div>";
        }
		vst_codigoHtml += "                                    </li>";
		vst_codigoHtml += "                                </ul>";
		vst_codigoHtml += "                            </div>";
		vst_codigoHtml += "                        </td>";
		vst_codigoHtml += "                    </tr>";
		//vst_codigoHtml += "                </table>";

        return vst_codigoHtml;
    }

    // METODOS UTILIZADOS EN PRUEBAS

    /*Eliminar este metodo*/
     // effect that shows a value binding chance on there server
    protected Effect valueChangeEffect;
    private List menuModel;
    public List getMenuModel() {
        return menuModel;
    }
    /*Eliminar este metodo*/
    public void MenuBean() {

        menuModel = new ArrayList();

        MenuItem topLevel1 = new MenuItem();
        //topLevel1.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //topLevel1.setValue("topLevel1");

        MenuItem topLevel2 = new MenuItem();
        //topLevel2.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //topLevel2.setValue("topLevel2");

        MenuItem topLevel3 = new MenuItem();
        //topLevel3.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //topLevel3.setValue("topLevel3");

        menuModel.add(topLevel1);
        menuModel.add(topLevel2);
        menuModel.add(topLevel3);

        MenuItem sub1_1 = new MenuItem();
        //sub1_1.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //sub1_1.setValue("sub1_1");
        MenuItem sub1_2 = new MenuItem();
        //sub1_2.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //sub1_2.setValue("sub1_2");
        MenuItem sub1_3 = new MenuItem();
        //sub1_3.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //sub1_3.setValue("sub1_3");

        //topLevel1.getChildren().add(sub1_1);
        //topLevel1.getChildren().add(sub1_2);
        //topLevel1.getChildren().add(sub1_3);

        MenuItem sub1_1_1 = new MenuItem();
        //sub1_1_1.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //sub1_1_1.setValue("sub1_1_1");
        MenuItem sub1_1_2 = new MenuItem();
        //sub1_1_2.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //sub1_1_2.setValue("sub1_1_2");
        MenuItem sub1_1_3 = new MenuItem();
        //sub1_1_3.setIcon("xmlhttp/css/xp/css-images/menuitem.gif");
        //sub1_1_3.setValue("sub1_1_3");

        //sub1_1.getChildren().add(sub1_1_1);
        //sub1_1.getChildren().add(sub1_1_2);
        //sub1_1.getChildren().add(sub1_1_3);
    }
    /*Eliminar este metodo*/
    private Effect textEffect;
    public Effect getTextEffect(){return textEffect;}
    public void setTextEffect(Effect effect){textEffect = effect;}
    public String invokeEffect(){textEffect = new Highlight();return null;}





    /*
       <ice:form>
            <ice:commandButton value="Invoke" action="#{rolBean.invokeEffect}"/>
            <ice:outputText value="Effect Test" effect="#{rolBean.textEffect}"/>
        </ice:form>
     */

/*
    @ManagedBean
    @SessionScoped
    public class Controler implements Serializable {

        public void irPagina1(ActionEvent actionEvent) {
            contenido=pagina1;
        }

        public void irPagina2(ActionEvent actionEvent) {
                    contenido=pagina2;
        }

            //Setters y Getters

            private String menu="menu.xhtml";
            private String contenido="contenido_inicial.xhtml";
            private String pagina1="pagina1.xhtml";
            private String pagina2="pagina2.xhtml";
    }
*/


/*Eliminar este metodo*/
    // records which menu item fired the event
    private String actionFired;
/*Eliminar este metodo*/
    // records the param value for the menu item which fired the event
    private String param;
/*Eliminar este metodo*/
    // orientation of the menubar ("Horizontal" or "Vertical")
    private String orientation = "Horizontal";

    /**
     * Get the param value for the menu item which fired the event.
     *
     * @return the param value
     */
/*Eliminar este metodo*/
    public String getParam() {
        return param;
    }

    /**
     * Set the param value.
     */
/*Eliminar este metodo*/
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * Get the modified ID of the fired action.
     *
     * @return the modified ID
     */
/*Eliminar este metodo*/
    public String getActionFired() {
        return actionFired;
    }

    /**
     * Identify the ID of the element that fired the event and return it in a
     * form suitable for display.
     *
     * @param e the event that fired the listener
     */
/*Eliminar este metodo*/
    public void primaryListener(ActionEvent e) {

        actionFired = ((UIComponent) e.getSource())
                .getClientId(FacesContext.getCurrentInstance());
        param = getRequestParameter("myParam");

        // highlight server side backing bean values.
        valueChangeEffect.setFired(false);

    }

    /**
     * Get the orientation of the menu ("horizontal" or "vertical")
     *
     * @return the orientation of the menu
     */
/*Eliminar este metodo*/
    public String getOrientation() {
        return orientation;
    }

    /**
     * Set the orientation of the menu ("horizontal" or "vertical").
     *
     * @param orientation the new orientation of the menu
     */
/*Eliminar este metodo*/
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /**
  * Get parameter value from request scope.
  *
  * @param name the name of the parameter
  * @return the parameter value
  */
/*Eliminar este metodo*/
  public static String getRequestParameter(String name) {
          return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
  }
}
