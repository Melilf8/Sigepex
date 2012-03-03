/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import javax.faces.model.SelectItem;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis Granados
 */
public class MensajeAyudaBean {
    String id_IU;
    String pantalla;
    String msgAyuda;
    String msg;
    private List list_ins_MensajeAyudaBean;
    private ArrayList<SelectItem> list_ins_SelectItem_ius;

    /* ESTA INSTANCIA CONTIENE LOS IDS DE LAS IUS Y LOS NOMBRES DE LAS PANTALLAS. */
    IUsPorRolBean ins_IUsPorRolBean = new IUsPorRolBean();


    /* CONSTRUCTORES */
    public MensajeAyudaBean()
    {
        this.id_IU = "";
        this.pantalla = "";
        this.msgAyuda = "";
        this.msg = "";
        this.Inicializar_list_ins_MensajeAyudaBean();
        this.getList_ins_SelectItem_ius();
    }
    public MensajeAyudaBean(String id_IU, String pantalla, String msgAyuda, String msg) {
        this.id_IU = id_IU;
        this.pantalla = pantalla;
        this.msgAyuda = msgAyuda;
        this.msg = msg;
    }

     /* PROPIEDADES */
    public String getId_IU() { return id_IU; }
    public void setId_IU(String id_IU) { this.id_IU = id_IU; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public String getMsgAyuda() { return msgAyuda; }
    public void setMsgAyuda(String msgAyuda) { this.msgAyuda = msgAyuda; }

    public String getPantalla() { return pantalla; }
    public void setPantalla(String pantalla) { this.pantalla = pantalla; }

    public List getList_ins_MensajeAyudaBean() { return list_ins_MensajeAyudaBean; }
    public void setList_ins_MensajeAyudaBean(List list_ins_MensajeAyudaBean) { this.list_ins_MensajeAyudaBean = list_ins_MensajeAyudaBean; }


    private void Inicializar_list_ins_MensajeAyudaBean()
    {
         this.list_ins_MensajeAyudaBean = new ArrayList();
         MensajeAyudaBean
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_aprobarPrestamo(),this.ins_IUsPorRolBean.getVst_nombreIU_aprobarPrestamo(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_aprobarRemision(),this.ins_IUsPorRolBean.getVst_nombreIU_aprobarRemision(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_consultarPrestamo(),this.ins_IUsPorRolBean.getVst_nombreIU_consultarPrestamo(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_consultarRemision(),this.ins_IUsPorRolBean.getVst_nombreIU_consultarRemision(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_llenarRemision(),this.ins_IUsPorRolBean.getVst_nombreIU_llenarRemision(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_parametros(),this.ins_IUsPorRolBean.getVst_nombreIU_parametros(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_reportePrestamo(),this.ins_IUsPorRolBean.getVst_nombreIU_reportePrestamo(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_reporteRemision(),this.ins_IUsPorRolBean.getVst_nombreIU_reporteRemision(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_solicitarPrestamo(),this.ins_IUsPorRolBean.getVst_nombreIU_solicitarPrestamo(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_adminUsuarios(),this.ins_IUsPorRolBean.getVst_nombreIU_adminUsuarios(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_adminRoles(),this.ins_IUsPorRolBean.getVst_nombreIU_adminRoles(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_adminIUsPorRol(),this.ins_IUsPorRolBean.getVst_nombreIU_adminIUsPorRol(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_adminSerieDocumental(),this.ins_IUsPorRolBean.getVst_nombreIU_adminSerieDocumental(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_adminMensajesAyuda(),this.ins_IUsPorRolBean.getVst_nombreIU_adminMensajesAyuda(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
         ins_MensajeAyudaBeanTmp = new MensajeAyudaBean(this.ins_IUsPorRolBean.getVst_inicioSigepex(),this.ins_IUsPorRolBean.getVst_nombreIU_inicioSigepex(),"","");
         this.list_ins_MensajeAyudaBean.add(ins_MensajeAyudaBeanTmp);
    }

    public ArrayList<SelectItem> getList_ins_SelectItem_ius() {
        
        this.list_ins_SelectItem_ius = new ArrayList<SelectItem>();
        this.list_ins_SelectItem_ius.add(new SelectItem("", "Seleccione una opción"));

        /* NOMBRES DE LAS IUS DEL SISTEMA */
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_aprobarPrestamo(), this.ins_IUsPorRolBean.getVst_aprobarPrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_aprobarRemision(), this.ins_IUsPorRolBean.getVst_aprobarRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_consultarPrestamo(), this.ins_IUsPorRolBean.getVst_consultarPrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_consultarRemision(), this.ins_IUsPorRolBean.getVst_consultarRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_llenarRemision(), this.ins_IUsPorRolBean.getVst_llenarRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_parametros(), this.ins_IUsPorRolBean.getVst_parametros()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_reportePrestamo(), this.ins_IUsPorRolBean.getVst_reportePrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_reporteRemision(), this.ins_IUsPorRolBean.getVst_reporteRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_solicitarPrestamo(), this.ins_IUsPorRolBean.getVst_solicitarPrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminUsuarios(), this.ins_IUsPorRolBean.getVst_adminUsuarios()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminRoles(), this.ins_IUsPorRolBean.getVst_adminRoles()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminIUsPorRol(), this.ins_IUsPorRolBean.getVst_adminIUsPorRol()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminSerieDocumental(), this.ins_IUsPorRolBean.getVst_adminSerieDocumental()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminMensajesAyuda(), this.ins_IUsPorRolBean.getVst_adminMensajesAyuda()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_inicioSigepex(), this.ins_IUsPorRolBean.getVst_inicioSigepex()));

        return list_ins_SelectItem_ius;

        // ALIAS DE LAS PANTALLAS
        /*
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_aprobarPrestamo(), this.ins_IUsPorRolBean.getVst_nombreIU_aprobarPrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_aprobarRemision(), this.ins_IUsPorRolBean.getVst_nombreIU_aprobarRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_consultarPrestamo(), this.ins_IUsPorRolBean.getVst_nombreIU_consultarPrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_consultarRemision(), this.ins_IUsPorRolBean.getVst_nombreIU_consultarRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_llenarRemision(), this.ins_IUsPorRolBean.getVst_nombreIU_llenarRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_parametros(), this.ins_IUsPorRolBean.getVst_nombreIU_parametros()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_reportePrestamo(), this.ins_IUsPorRolBean.getVst_nombreIU_reportePrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_reporteRemision(), this.ins_IUsPorRolBean.getVst_nombreIU_reporteRemision()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_solicitarPrestamo(), this.ins_IUsPorRolBean.getVst_nombreIU_solicitarPrestamo()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminUsuarios(), this.ins_IUsPorRolBean.getVst_nombreIU_adminUsuarios()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminRoles(), this.ins_IUsPorRolBean.getVst_nombreIU_adminRoles()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminIUsPorRol(), this.ins_IUsPorRolBean.getVst_nombreIU_adminIUsPorRol()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminSerieDocumental(), this.ins_IUsPorRolBean.getVst_nombreIU_adminSerieDocumental()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_adminMensajesAyuda(), this.ins_IUsPorRolBean.getVst_nombreIU_adminMensajesAyuda()));
        this.list_ins_SelectItem_ius.add(new SelectItem(this.ins_IUsPorRolBean.getVst_inicioSigepex(), this.ins_IUsPorRolBean.getVst_nombreIU_inicioSigepex()));
        return list_ins_SelectItem_ius;
        */

    }

    public void cmbMsgBean_onChange(ValueChangeEvent event){
        try {
            // se comento porque el combo asigna automaticamente el elemento seleccionado
            String vst_idIU = event.getNewValue().toString().trim();
            //this.setId_IU(vst_idIU);
            this.setMsgAyuda("");
        }
        catch (Exception ex) {
            this.setMsg("Error al intentar cambiar el elemento del combo.. "+ex.getMessage());
            Logger.getLogger(IUsPorRolBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setMsg("");
    }


    /// Para la navegacion desde el frm_admin_mensajes_ayuda.jspx
    public String consultarMsgAyuda() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        if(this.getId_IU().equals(""))
            this.setMsg("Debe ingresar el identificador de la interface.");
        else
             Servicio.msgayudaIUConsultar(this);

        return vst_mensaje;
    }

    /// Para la navegacion desde el frm_admin_mensajes_ayuda.jspx
    public String registrarMsgAyuda() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un mensaje de ayuda */
        if(this.getId_IU().equals(""))list_st_comentarios.add(" el ID INTERFAZ");
        if(this.getMsgAyuda().equals(""))list_st_comentarios.add(" el Mensaje de Ayuda");

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
             vst_mensaje = "Para Registrar un mensaje de ayuda debe ingresar "+ vst_mensaje;
        }

        if(!list_st_comentarios.isEmpty())
        {
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            Servicio.msgayudaIUAgregar(this);

            if(this.getId_IU().equals(""))
                return "noestaregistrado";
            else
            {
                if(this.getMsg().equals("La pantalla ya tiene registrado un mensaje de ayuda en el sistema. Para atualizar el mensaje presione el botón Actualizar."))
                    return "yaexiste";
                else
                    return "registrado";
            }
        }
    }

    /// Para la navegacion desde el frm_admin_mensajes_ayuda.jspx
    public String actualizarMsgAyuda() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        if(this.getId_IU().equals(""))list_st_comentarios.add(" el ID INTERFAZ");
        //if(this.getPantalla().equals(""))list_st_comentarios.add(" la PANTALLA");
        if(this.getMsgAyuda().equals(""))list_st_comentarios.add(" el Mensaje de Ayuda");

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
             vst_mensaje = "Para actualizar el mensaje de ayuda debe ingresar "+ vst_mensaje;
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            Servicio.msgayudaIUModificar(this);

            if(this.getId_IU().equals(""))
                return "noexiste";
            else
                return "actualizado";
        }
    }

}
