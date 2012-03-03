/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.Map;

/**
 *
 * @author Luis Granados
 */
public class FuncionarioBean {

    /* TRIBUTOS */
    private String identificacion;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private Integer estado;
    private String contrasena;
    private Integer rol;
    private Integer idDependencia;
    private String msg;
    private List list_ins_funcionarios;
    private ArrayList<SelectItem> list_ins_SelectItem_roles;
    private ArrayList<SelectItem> list_ins_SelectItem_dependencias;
    private ArrayList<SelectItem> list_ins_SelectItem_estados;
    private boolean visible = false;
    private Boolean checked;

    // records the param value for the menu item which fired the event
    // Despues de las pruebas debo eliminar este atributo.
    private String param;

    /* CONSTRUCTORES */
    public FuncionarioBean()
    {
        this.identificacion = "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.email = "";
        this.estado = 0;
        this.contrasena = "UNA";
        this.rol = 0;
        this.idDependencia = 0;
        this.msg = "";
        this.list_ins_funcionarios = new ArrayList();

        this.getList_ins_SelectItem_roles();
        this.getList_ins_SelectItem_estados();
        this.getList_ins_SelectItem_dependencias();
    }

    public FuncionarioBean(String pIdentificacion, String pNombre, String pApellido1,
            String pApellido2, String pEmail, Integer pEstado, String pContrasena,
            Integer pRol, Integer pIdDependencia, String pMsg)
    {
        this.identificacion = pIdentificacion;
        this.nombre = pNombre;
        this.apellido1 = pApellido1;
        this.apellido2 = pApellido2;
        this.email = pEmail;
        this.estado = pEstado;
        this.contrasena = pContrasena;
        this.rol = pRol;
        this.idDependencia = pIdDependencia;
        this.msg = pMsg;
    }

    /* PROPIEDADES */

    // Atributos del popup funcionarios
    public Boolean getChecked() { return checked; }
    public void setChecked(Boolean checked) { this.checked = checked; }

    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public String closePopup() { visible = false; return "";}
    public void openPopup() { visible = true; }

    public List getList_ins_funcionarios() { return list_ins_funcionarios; }
    public void setList_ins_funcionarios(List list_ins_funcionarios) {
        this.list_ins_funcionarios = list_ins_funcionarios;
    }
    //----------------------------

     // ATRIBUTO: identificacion
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
     // ATRIBUTO: nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     // ATRIBUTO: apellido1
    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
     // ATRIBUTO: apellido2
    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
     // ATRIBUTO: email
    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }
     // ATRIBUTO: estado
    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
     // ATRIBUTO: contrasena
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
     // ATRIBUTO: rol
    public Integer getRol() { return rol; }
    public void setRol(Integer rol) {
        this.rol = rol;
    }
     // ATRIBUTO: idDependencia
    public Integer getIdDependencia() { return idDependencia; }
    public void setIdDependencia(Integer idDependencia) {
        this.idDependencia = idDependencia;
    }
     // ATRIBUTO: msg
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    /* LLENADO DE LOS COMBOS DEL FORMULARIO*/
    
    public ArrayList<SelectItem> getList_ins_SelectItem_roles() {
        try {
            this.list_ins_SelectItem_roles = new ArrayList<SelectItem>();
            this.list_ins_SelectItem_roles.add(new SelectItem("0", "Ninguno"));

            //Cargo los roles desde la base de datos
            RolBean ins_rolBean = new RolBean();
            Servicio.rolListarTodos(ins_rolBean);

            if(!ins_rolBean.getList_ins_RolBean().isEmpty())
            {
                RolBean ins_rolBeanTmp;
                for(int i = 0;i < ins_rolBean.getList_ins_RolBean().size();i++)
                {
                    ins_rolBeanTmp = new RolBean();
                    ins_rolBeanTmp = (RolBean)ins_rolBean.getList_ins_RolBean().get(i);
                    this.list_ins_SelectItem_roles.add(new SelectItem(Integer.toString(ins_rolBeanTmp.getIdRol()), ins_rolBeanTmp.getNombreRol()));               
                }
            }
            else
            {
                // si no hay roles en la base de datos, muestro los datos quemados.
                this.list_ins_SelectItem_roles.add(new SelectItem("1", "Administrador"));
                this.list_ins_SelectItem_roles.add(new SelectItem("2", "Funcionario"));
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list_ins_SelectItem_roles;
    }
    
    public ArrayList<SelectItem> getList_ins_SelectItem_dependencias() {
        try {
            this.list_ins_SelectItem_dependencias = new ArrayList<SelectItem>();
            this.list_ins_SelectItem_dependencias.add(new SelectItem("0", "Ninguno"));

            //Cargo las dependencias desde la base de datos
            DependenciaBean ins_dependenciaBean = new DependenciaBean();
            Servicio.dependenciaListarTodas(ins_dependenciaBean);

            if(!ins_dependenciaBean.getList_ins_dependencia().isEmpty())
            {
                DependenciaBean ins_dependenciaBeanTmp;
                for(int i = 0;i < ins_dependenciaBean.getList_ins_dependencia().size();i++)
                {
                    ins_dependenciaBeanTmp = new DependenciaBean();
                    ins_dependenciaBeanTmp = (DependenciaBean)ins_dependenciaBean.getList_ins_dependencia().get(i);
                    this.list_ins_SelectItem_dependencias.add(new SelectItem(Integer.toString(ins_dependenciaBeanTmp.getIdDependencia()), ins_dependenciaBeanTmp.getNombreDependencia()));
                }
            }
            else
            {   // si no hay datos en BD muestro los datos quemados
                this.list_ins_SelectItem_dependencias.add(new SelectItem("1", "Informática"));
                this.list_ins_SelectItem_dependencias.add(new SelectItem("2", "Letras"));
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list_ins_SelectItem_dependencias;
    }

    public ArrayList<SelectItem> getList_ins_SelectItem_estados() {
        this.list_ins_SelectItem_estados = new ArrayList<SelectItem>();
        this.list_ins_SelectItem_estados.add(new SelectItem("0", "IN"));
        this.list_ins_SelectItem_estados.add(new SelectItem("1", "AC"));

        return this.list_ins_SelectItem_estados;
    }
    
    // para la navegacion desde frm_listar_funcionarios.jspx
    public String verificarChecks(){

        String vst_msg_return = "ningunamarcada";
        Integer vin_cantidadChecks = 0;
        Integer vin_pos_chked = -1;
        FuncionarioBean ins_funcionarioBean_Tmp = new FuncionarioBean();

        for(int i = 0; i < this.getList_ins_funcionarios().size();i++)
        {
            ins_funcionarioBean_Tmp = (FuncionarioBean)this.getList_ins_funcionarios().get(i);

            /* obtengo el numero de registros checados y la pos del primer check */
            if(ins_funcionarioBean_Tmp.getChecked())
            {
                if(vin_pos_chked == -1)
                    vin_pos_chked = i;

                vin_cantidadChecks++;
            }
        }
        if(vin_cantidadChecks == 0)
        {
            if(this.getList_ins_funcionarios().size() > 0)
            {
                this.setMsg("Debe seleccionar al menos un funcionario.");
                vst_msg_return = "ningunamarcada";
            }
            else
                vst_msg_return = this.closePopup();
        }
        else if(vin_cantidadChecks == 1)
        {
            /* obtendo la instancia del estudiante checado */
            ins_funcionarioBean_Tmp = (FuncionarioBean)this.getList_ins_funcionarios().get(vin_pos_chked);

            if(ins_funcionarioBean_Tmp.getChecked())
            {
                cargar_this_ins_FuncionarioBean(ins_funcionarioBean_Tmp);
                vst_msg_return = this.closePopup();
            }
            vst_msg_return = "ningunamarcada";
        }
        else if(vin_cantidadChecks > 1)
        {
            this.setMsg("Debe seleccionar a lo sumo un estudiante.");
            vst_msg_return = "masdeunamarcada";
        }

        return vst_msg_return;
    }

    private void cargar_this_ins_FuncionarioBean(FuncionarioBean ins_funcionarioBean_Tmp)
    {
        this.setIdentificacion(ins_funcionarioBean_Tmp.getIdentificacion());
        this.setNombre(ins_funcionarioBean_Tmp.getNombre());
        this.setApellido1(ins_funcionarioBean_Tmp.getApellido1());
        this.setApellido2(ins_funcionarioBean_Tmp.getApellido2());
        this.setEmail(ins_funcionarioBean_Tmp.getEmail());
        this.setEstado(ins_funcionarioBean_Tmp.getEstado());
        this.setContrasena(ins_funcionarioBean_Tmp.getContrasena());
        this.setRol(ins_funcionarioBean_Tmp.getRol());
        this.setIdDependencia(ins_funcionarioBean_Tmp.getIdDependencia());
        this.setMsg(ins_funcionarioBean_Tmp.getMsg());
        this.setList_ins_funcionarios(ins_funcionarioBean_Tmp.getList_ins_funcionarios());
    }

    /**
     * Get the param value for the menu item which fired the event.
     *
     * @return the param value
     */
    // Despues de las pruebas debo eliminar las propiedades del param
    public String getParam() {
        return param;
    }

    /**
     * Set the param value.
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * Identify the ID of the element that fired the event and return it in a
     * form suitable for display.
     *
     * @param e the event that fired the listener
     */
    public void listener(ActionEvent e) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map params = facesContext.getExternalContext().getRequestParameterMap();
        String myParam = (String) params.get("myParam");
        if (myParam != null && myParam.length() > 0) {
            if(myParam.equals("txt_in_identificacion"))
                validarNumeros(myParam);

            setParam(myParam);
        } else {
            setParam("not defined");
        }
    }

    // Metodo en fase de prueba
    private Boolean validarNumeros(String param)
    {
        Boolean ok = false;

        return ok;
    }


     /*=================================================================
     * METODOS QUE DETERMINAN LA NAVEGACION DENTRO DEL faces-config.xml
     * A TRAVES DE LA PALABRA RETORNADA.
     * EL SERVICIO DETERMINA LA ACCION DEL SISTEMA.
     *=================================================================*/

    public String setear_ins_FuncionarioBean()
    {
         this.setIdentificacion("");
         this.setNombre("");
         this.setApellido1("");
         this.setApellido2("");
         this.setEmail("");
         this.setEstado(0);
         this.setContrasena("UNA");
         this.setRol(0);
         this.setIdDependencia(0);
         this.setMsg("");

         return "";
    }

    // para la navegacion desde el frm_mantenimiento_usuarios
    public String consultarFuncionario() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        /*
        if(this.getIdentificacion().equals(""))
            this.setMsg("Debe ingresar la identificación del funcionario.");
        else
        */
            if(this.getNombre().equals("") && this.getApellido1().equals("") && this.getApellido2().equals(""))
            {
                 Servicio.funcionarioConsultar(this);

                 // PARA ABRIR EL POPUP
                 if(this.getIdentificacion().equals("")|| this.getIdentificacion().length()< 9)
                 {
                    /* El popup se abre siempre y cuando la consulta haya arrojado mas de un registro
                     * si la consulta retorna solo un funcionario este se carga en el form de usuarios.
                     */
                    if(this.getList_ins_funcionarios().size()== 1)
                    {
                        FuncionarioBean ins_funcionarioBean_Tmp = (FuncionarioBean)this.getList_ins_funcionarios().get(0);
                        cargar_this_ins_FuncionarioBean(ins_funcionarioBean_Tmp);
                    }
                    else
                        this.setVisible(true);
                 }
            }
            else
            {
                Servicio.funcionarioConsultarPorNombre(this);
                /* El popup se abre siempre y cuando la consulta haya arrojado mas de un registro
                   si la consulta retorna solo un funcionario este se carga en el form de usuarios.
                */
                if(this.getList_ins_funcionarios().size()== 1)
                {
                    FuncionarioBean ins_funcionarioBean_Tmp = (FuncionarioBean)this.getList_ins_funcionarios().get(0);
                    cargar_this_ins_FuncionarioBean(ins_funcionarioBean_Tmp);
                }
                else
                    this.setVisible(true);
            }

        return vst_mensaje;
    }

    /// Para la navegacion desde el frm_registrar_usuario.jspx
    public String registrarFuncionario() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        if(this.getIdentificacion().equals(""))list_st_comentarios.add(" el Usuario");
        if(this.getNombre().equals(""))list_st_comentarios.add(" el Nombre");
        if(this.getApellido1().equals(""))list_st_comentarios.add(" el Apellido1");
        if(this.getApellido2().equals(""))list_st_comentarios.add(" el Apellido2");
        //if(this.ins_UsuarioBean.getEmail().equals(""))list_st_comentarios.add(" el Email");
        if(this.getContrasena().equals(""))list_st_comentarios.add(" la Contrase�a");
        if(this.getRol() == 0)list_st_comentarios.add(" el Rol");
        if(this.getIdDependencia() == 0)list_st_comentarios.add(" la Dependencia");

        if(!list_st_comentarios.isEmpty())
        {
            for(int i = 0; i < list_st_comentarios.size();i++)
            {
                if(list_st_comentarios.size() == 1)
                    vst_mensaje = (String)list_st_comentarios.get(i)+".";
                else if(i == 0)
                     vst_mensaje += (String)list_st_comentarios.get(i);
                else if(i == list_st_comentarios.size()-1 )
                    vst_mensaje += " y " + (String)list_st_comentarios.get(i)+".";
                else
                    vst_mensaje += ", " + (String)list_st_comentarios.get(i);
            }
             vst_mensaje = "Para Registrar el funcionario debe ingresar "+ vst_mensaje;
        }
        
        if(!list_st_comentarios.isEmpty())
        {
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            Servicio.funcionarioAgregar(this);

            if(this.getIdentificacion().equals(""))
                return "noestaregistrado";
            else
            {
                if(this.getMsg().equals("El funcionario ya está registrado en el sistema."))
                    return "yaexiste";
                else
                    return "registrado";
            }
        }
    }

    /// Para la navegacion desde el frm_actualizar_usuario.jspx
    public String actualizarFuncionario() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();

        /* Campos requeridos para actualizar el funcionario */
        if(this.getIdentificacion().equals(""))list_st_comentarios.add(" el Usuario");
        if(this.getNombre().equals(""))list_st_comentarios.add(" el Nombre");
        if(this.getApellido1().equals(""))list_st_comentarios.add(" el Apellido1");
        if(this.getApellido2().equals(""))list_st_comentarios.add(" el Apellido2");
        //if(this.ins_UsuarioBean.getEmail().equals(""))list_st_comentarios.add(" el Email");
        if(this.getContrasena().equals(""))list_st_comentarios.add(" la Contraseña");
        if(this.getRol() == 0)list_st_comentarios.add(" el Rol");
        if(this.getIdDependencia() == 0)list_st_comentarios.add(" la Dependencia");

         if(!list_st_comentarios.isEmpty())
        {
            for(int i = 0; i < list_st_comentarios.size();i++)
            {
                if(list_st_comentarios.size() == 1)
                    vst_mensaje = (String)list_st_comentarios.get(i)+".";
                 else if(i == 0)
                     vst_mensaje += (String)list_st_comentarios.get(i);
                else if(i == list_st_comentarios.size()-1 )
                    vst_mensaje += " y " + (String)list_st_comentarios.get(i)+".";
                else
                    vst_mensaje += ", " + (String)list_st_comentarios.get(i);
            }
        }
        
        if(!list_st_comentarios.isEmpty())
        {
             vst_mensaje = "Para actualizar el funcionario debe ingresar "+ vst_mensaje;
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            Servicio.funcionarioModificar(this);

            if(this.getIdentificacion().equals(""))
                return "noexiste";
            else
                return "actualizado";
        }
    }

    /// Para la navegacion desde el frm_suspender_usuario.jspx
    public String suspenderFuncionario() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";

        /* Campos requeridos para suspender el funcionario */
        if(this.getIdentificacion().equals("")&& this.getNombre().equals("")&& this.getApellido1().equals("")&& this.getApellido2().equals(""))
            vst_mensaje = "Para suspender o activar el funcionario debe ingresar la identificación o el nombre completo del funcionario.";

        if(!vst_mensaje.trim().equals(""))
        {
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            Servicio.funcionarioSuspender(this);

            if(this.getIdentificacion().equals(""))
                return "noexiste";
            else
                return "suspendido";
        }
    }

    public String generarReporte() throws Exception {
        try
        {
            this.setMsg("");
            String vst_mensaje="";
            if(this.getIdentificacion().equals(""))
            {
                vst_mensaje = "Debe ingresar la Identificaci�n.";
                this.setMsg(vst_mensaje);
                return "rptnogenedado";
            }
            else
            {
                this.setMsg("");
                return "rptgenerado";
            }
        }
        catch(Exception e){
            msg = "Error al gererar el reporte.\n"+e;
            return "rptnogenerado";
        }
    }

    public String Regresar() throws Exception
     {
         try{
             this.setMsg("");
             return "salir";
         }
         catch(Exception e){
             this.setMsg("");
             return "salir";
         }
     }
}
