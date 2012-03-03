/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ValueChangeEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis Granados
 */
public class IUsPorRolBean {

    /* ATRIBUTOS */
    private int idRol;
    private String idIU;
    private String nombreIU;
    private Boolean checked;
    private String msg;
    private List list_ins_iusPorRolBean;
    private List list_ins_iusPorRolBeanChecked;
    private RolBean ins_rolBean;

    /* IDS IUS */
    private String vst_adminUsuarios = "frm_mantenimiento_usuarios";
    private String vst_aprobarPrestamo = "frm_aprobar_prestamo";
    private String vst_aprobarRemision = "frm_aprobar_remision";
    private String vst_consultarPrestamo = "frm_consultar_prestamo";
    private String vst_consultarRemision = "frm_consultar_remision";
    private String vst_llenarRemision = "frm_llenar_remision";
    private String vst_parametros = "frm_parametros";
    private String vst_solicitarPrestamo = "frm_solicitar_prestamo";
    private String vst_reportePrestamo = "frm_reporte_prestamo";
    private String vst_reporteRemision = "frm_reporte_remision";
    private String vst_adminRoles = "frm_admin_roles";
    private String vst_adminIUsPorRol = "frm_admin_ius_por_rol";
    private String vst_adminSerieDocumental = "frm_admin_serie_documental";
    private String vst_adminMensajesAyuda = "frm_admin_mensajes_ayuda";
    private String vst_inicioSigepex = "frm_inicio";

    /* NOMBRES DE LAS IUS COMO LAS CONCIBE EL ADMINISTRADOR*/
    private String vst_nombreIU_adminUsuarios = "Administración de Usuarios";
    private String vst_nombreIU_aprobarPrestamo = "Aprobar Préstamo";
    private String vst_nombreIU_aprobarRemision = "Aprobar Remisión";
    private String vst_nombreIU_consultarPrestamo = "Consultar Préstamo";
    private String vst_nombreIU_consultarRemision = "Consultar Remisión";
    private String vst_nombreIU_llenarRemision = "Llenar Remisión";
    private String vst_nombreIU_parametros = "Parámetros";
    private String vst_nombreIU_solicitarPrestamo = "Solicitar Préstamo";
    private String vst_nombreIU_reportePrestamo = "Reporte Préstamo";
    private String vst_nombreIU_reporteRemision = "Reporte Remisión";
    private String vst_nombreIU_adminRoles = "Administración de Roles";
    private String vst_nombreIU_adminIUsPorRol = "Administración de Pantallas por Rol";
    private String vst_nombreIU_adminSerieDocumental = "Administración de Series Documentales";
    private String vst_nombreIU_adminMensajesAyuda = "Administración de Mensajes de Ayuda";
    private String vst_nombreIU_inicioSigepex = "Pantalla de Inicio del Sistema";

    /* CONSTRUCTORES */
    public IUsPorRolBean()
    {
        this.idRol = 0;
        this.idIU = "";
        this.nombreIU = "";
        this.checked = false;
        this.msg = "";
        this.ins_rolBean = new RolBean();
        this.ins_rolBean.setMsg("LISTA DE PANTALLAS POR ROL");
        this.Inicializar_list_ins_iusPorRolBean();
    }

    /* Para cargar listas */
    public IUsPorRolBean(String idIU, String nombreIU, Boolean checked) {
        this.idIU = idIU;
        this.nombreIU = nombreIU;
        this.checked = checked;
    }

    /* PROPIEDADES */
    public Boolean getChecked() { return checked; }
    public void setChecked(Boolean checked) { this.checked = checked; }
    public String getIdIU() { return idIU; }
    public void setIdIU(String idIU) { this.idIU = idIU; }
    public String getNombreIU() { return nombreIU; }
    public void setNombreIU(String nombreIU) { this.nombreIU = nombreIU; }
    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) { this.idRol = idRol; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public RolBean getIns_rolBean() { return ins_rolBean; }
    public void setIns_rolBean(RolBean ins_rolBean) { this.ins_rolBean = ins_rolBean; }

    public List getList_ins_iusPorRolBeanChecked() { return list_ins_iusPorRolBeanChecked; }
    public void setList_ins_iusPorRolBeanChecked(List list_ins_iusPorRolBeanChecked) { this.list_ins_iusPorRolBeanChecked = list_ins_iusPorRolBeanChecked; }


    /* PROPIEDADES: ID_IUs PARA LA LISTA DE ACCESO */
    //-- Getter
    public String getVst_aprobarPrestamo() { return vst_aprobarPrestamo; }
    public String getVst_aprobarRemision() { return vst_aprobarRemision; }
    public String getVst_consultarPrestamo() { return vst_consultarPrestamo; }
    public String getVst_consultarRemision() { return vst_consultarRemision; }
    public String getVst_llenarRemision() { return vst_llenarRemision; }
    public String getVst_parametros() { return vst_parametros; }
    public String getVst_reportePrestamo() { return vst_reportePrestamo; }
    public String getVst_reporteRemision() { return vst_reporteRemision; }
    public String getVst_solicitarPrestamo() { return vst_solicitarPrestamo; }
    public String getVst_adminUsuarios() { return vst_adminUsuarios; }
    public String getVst_adminRoles() { return vst_adminRoles; }
    public String getVst_adminIUsPorRol() { return vst_adminIUsPorRol; }
    public String getVst_adminSerieDocumental() { return vst_adminSerieDocumental; }
    public String getVst_adminMensajesAyuda() { return vst_adminMensajesAyuda; }
    public String getVst_inicioSigepex() { return vst_inicioSigepex; }
    //-- Setter
    public void setVst_aprobarPrestamo(String vst_aprobarPrestamo) { this.vst_aprobarPrestamo = vst_aprobarPrestamo; }
    public void setVst_aprobarRemision(String vst_aprobarRemision) { this.vst_aprobarRemision = vst_aprobarRemision; }
    public void setVst_consultarPrestamo(String vst_consultarPrestamo) { this.vst_consultarPrestamo = vst_consultarPrestamo; }
    public void setVst_consultarRemision(String vst_consultarRemision) { this.vst_consultarRemision = vst_consultarRemision; }
    public void setVst_llenarRemision(String vst_llenarRemision) { this.vst_llenarRemision = vst_llenarRemision; }
    public void setVst_parametros(String vst_parametros) { this.vst_parametros = vst_parametros; }
    public void setVst_reportePrestamo(String vst_reportePrestamo) { this.vst_reportePrestamo = vst_reportePrestamo; }
    public void setVst_reporteRemision(String vst_reporteRemision) { this.vst_reporteRemision = vst_reporteRemision; }
    public void setVst_solicitarPrestamo(String vst_solicitarPrestamo) { this.vst_solicitarPrestamo = vst_solicitarPrestamo; }
    public void setVst_adminUsuarios(String vst_adminUsuarios) { this.vst_adminUsuarios = vst_adminUsuarios; }
    public void setVst_adminRoles(String vst_adminRoles) { this.vst_adminRoles = vst_adminRoles; }
    public void setVst_adminIUsPorRol(String vst_adminIUsPorRol) { this.vst_adminIUsPorRol = vst_adminIUsPorRol; }
    public void setVst_adminSerieDocumental(String vst_adminSerieDocumental) { this.vst_adminSerieDocumental = vst_adminSerieDocumental; }
    public void setVst_adminMensajesAyuda(String vst_adminMensajesAyuda) { this.vst_adminMensajesAyuda = vst_adminMensajesAyuda; }
    public void setVst_inicioSigepex(String vst_inicioSigepex) { this.vst_inicioSigepex = vst_inicioSigepex; }
    
     /* PROPIEDADES: NOMBRES DE LAS PANTALLAS PARA LA LISTA DE ACCESO*/
    //-- Getter
    public String getVst_nombreIU_aprobarPrestamo() { return vst_nombreIU_aprobarPrestamo; }
    public String getVst_nombreIU_aprobarRemision() { return vst_nombreIU_aprobarRemision; }
    public String getVst_nombreIU_consultarPrestamo() { return vst_nombreIU_consultarPrestamo; }
    public String getVst_nombreIU_consultarRemision() { return vst_nombreIU_consultarRemision; }
    public String getVst_nombreIU_llenarRemision() { return vst_nombreIU_llenarRemision; }
    public String getVst_nombreIU_parametros() { return vst_nombreIU_parametros; }
    public String getVst_nombreIU_reportePrestamo() { return vst_nombreIU_reportePrestamo; }
    public String getVst_nombreIU_reporteRemision() { return vst_nombreIU_reporteRemision; }
    public String getVst_nombreIU_solicitarPrestamo() { return vst_nombreIU_solicitarPrestamo; }
    public String getVst_nombreIU_adminUsuarios() { return vst_nombreIU_adminUsuarios; }
    public String getVst_nombreIU_adminRoles() { return vst_nombreIU_adminRoles; }
    public String getVst_nombreIU_adminIUsPorRol() { return vst_nombreIU_adminIUsPorRol; }
    public String getVst_nombreIU_adminSerieDocumental() { return vst_nombreIU_adminSerieDocumental; }
    public String getVst_nombreIU_adminMensajesAyuda() { return vst_nombreIU_adminMensajesAyuda; }
    public String getVst_nombreIU_inicioSigepex() { return vst_nombreIU_inicioSigepex; }
    //-- Setter
    public void setVst_nombreIU_adminIUsPorRol(String vst_nombreIU_adminIUsPorRol) { this.vst_nombreIU_adminIUsPorRol = vst_nombreIU_adminIUsPorRol; }
    public void setVst_nombreIU_adminMensajesAyuda(String vst_nombreIU_adminMensajesAyuda) { this.vst_nombreIU_adminMensajesAyuda = vst_nombreIU_adminMensajesAyuda; }
    public void setVst_nombreIU_adminRoles(String vst_nombreIU_adminRoles) { this.vst_nombreIU_adminRoles = vst_nombreIU_adminRoles; }
    public void setVst_nombreIU_adminSerieDocumental(String vst_nombreIU_adminSerieDocumental) { this.vst_nombreIU_adminSerieDocumental = vst_nombreIU_adminSerieDocumental; }
    public void setVst_nombreIU_adminUsuarios(String vst_nombreIU_adminUsuarios) { this.vst_nombreIU_adminUsuarios = vst_nombreIU_adminUsuarios; }
    public void setVst_nombreIU_aprobarPrestamo(String vst_nombreIU_aprobarPrestamo) { this.vst_nombreIU_aprobarPrestamo = vst_nombreIU_aprobarPrestamo; }
    public void setVst_nombreIU_aprobarRemision(String vst_nombreIU_aprobarRemision) { this.vst_nombreIU_aprobarRemision = vst_nombreIU_aprobarRemision; }
    public void setVst_nombreIU_consultarPrestamo(String vst_nombreIU_consultarPrestamo) { this.vst_nombreIU_consultarPrestamo = vst_nombreIU_consultarPrestamo; }
    public void setVst_nombreIU_consultarRemision(String vst_nombreIU_consultarRemision) { this.vst_nombreIU_consultarRemision = vst_nombreIU_consultarRemision; }
    public void setVst_nombreIU_inicioSigepex(String vst_nombreIU_inicioSigepex) { this.vst_nombreIU_inicioSigepex = vst_nombreIU_inicioSigepex; }
    public void setVst_nombreIU_llenarRemision(String vst_nombreIU_llenarRemision) { this.vst_nombreIU_llenarRemision = vst_nombreIU_llenarRemision; }
    public void setVst_nombreIU_parametros(String vst_nombreIU_parametros) { this.vst_nombreIU_parametros = vst_nombreIU_parametros; }
    public void setVst_nombreIU_reportePrestamo(String vst_nombreIU_reportePrestamo) { this.vst_nombreIU_reportePrestamo = vst_nombreIU_reportePrestamo; }
    public void setVst_nombreIU_reporteRemision(String vst_nombreIU_reporteRemision) { this.vst_nombreIU_reporteRemision = vst_nombreIU_reporteRemision; }
    public void setVst_nombreIU_solicitarPrestamo(String vst_nombreIU_solicitarPrestamo) { this.vst_nombreIU_solicitarPrestamo = vst_nombreIU_solicitarPrestamo; }

    private void CargarUIsSigepex()
    {
        try {
            IUSigepexBean ins_iuSigepexBean = new IUSigepexBean();
            Servicio.iuSigepexListarTodas(ins_iuSigepexBean);

            if(!ins_iuSigepexBean.getList_ins_iuSigepexBean().isEmpty())
            {
                this.list_ins_iusPorRolBean = new ArrayList();
                for(int i = 0; i < ins_iuSigepexBean.getList_ins_iuSigepexBean().size();i++)
                {
                    ins_iuSigepexBean = (IUSigepexBean)ins_iuSigepexBean.getList_ins_iuSigepexBean().get(i);

                    IUsPorRolBean ins_IUsPorRolBeanTmp = new IUsPorRolBean(ins_iuSigepexBean.getIdIU(),ins_iuSigepexBean.getAliasIU(),false);
                    this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(IUsPorRolBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CargarUIsPorRol(Integer pId_rol)
    {
        try
        {
            this.Inicializar_list_ins_iusPorRolBean();
            Servicio.IUsporRolListarPorRol(this);

            if(!this.getList_ins_iusPorRolBeanChecked().isEmpty())
            {
                ArrayList list_iusxrolBean_new = new ArrayList();
                IUsPorRolBean ins_IUsPorRolBean_marked;
                IUsPorRolBean ins_IUsPorRolBeanTmp;
                Integer indexOf = -1;

                /* Recorro los items de la lista de todas las ius */
                for(int i = 0; i < this.getList_ins_iusPorRolBean().size();i++)
                {
                    ins_IUsPorRolBeanTmp = (IUsPorRolBean)this.getList_ins_iusPorRolBean().get(i);
                    indexOf = -1;
                    /* Busco el item dentro de la lista de items marcados */
                    for(int j = 0;j < this.getList_ins_iusPorRolBeanChecked().size();j++)
                     {
                        ins_IUsPorRolBean_marked = (IUsPorRolBean)this.getList_ins_iusPorRolBeanChecked().get(j);

                        if(ins_IUsPorRolBeanTmp.getIdIU().trim().equals(ins_IUsPorRolBean_marked.getIdIU().trim()))
                        {
                            indexOf = i;
                            break;
                        }
                     }
                    if(indexOf == -1)
                        ins_IUsPorRolBeanTmp.setChecked(false);
                    else
                        ins_IUsPorRolBeanTmp.setChecked(true);

                    list_iusxrolBean_new.add(ins_IUsPorRolBeanTmp);
                }
                this.setList_ins_iusPorRolBean(list_iusxrolBean_new);
            }
         }
        catch (Exception ex) {
            Logger.getLogger(IUsPorRolBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Inicializar_list_ins_iusPorRolBean()
    {
         //this.CargarUIsSigepex();

        this.list_ins_iusPorRolBean = new ArrayList();
         IUsPorRolBean
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_aprobarPrestamo(),this.getVst_nombreIU_aprobarPrestamo(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_aprobarRemision(),this.getVst_nombreIU_aprobarRemision(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_consultarPrestamo(),this.getVst_nombreIU_consultarPrestamo(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_consultarRemision(),this.getVst_nombreIU_consultarRemision(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_llenarRemision(),this.getVst_nombreIU_llenarRemision(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_parametros(),this.getVst_nombreIU_parametros(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_reportePrestamo(),this.getVst_nombreIU_reportePrestamo(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_reporteRemision(),this.getVst_nombreIU_reporteRemision(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_solicitarPrestamo(),this.getVst_nombreIU_solicitarPrestamo(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_adminUsuarios(),this.getVst_nombreIU_adminUsuarios(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_adminRoles(),this.getVst_nombreIU_adminRoles(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_adminIUsPorRol(),this.getVst_nombreIU_adminIUsPorRol(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_adminSerieDocumental(),this.getVst_nombreIU_adminSerieDocumental(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_adminMensajesAyuda(),this.getVst_nombreIU_adminMensajesAyuda(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
         ins_IUsPorRolBeanTmp = new IUsPorRolBean(this.getVst_inicioSigepex(),this.getVst_nombreIU_inicioSigepex(),false);
         this.list_ins_iusPorRolBean.add(ins_IUsPorRolBeanTmp);
    }

    //ATRIBUTO: list_ins_iusPorRolBean
    public List getList_ins_iusPorRolBean() { return list_ins_iusPorRolBean; }
    public void setList_ins_iusPorRolBean(List list_ins_iusPorRolBean) { this.list_ins_iusPorRolBean = list_ins_iusPorRolBean; }
    public void list_ins_iusPorRolBeanClear(){ this.list_ins_iusPorRolBean.clear(); }
    public void list_ins_iusPorRolBeanAdd(IUsPorRolBean ins_IUsPorRolBean) { list_ins_iusPorRolBean.add(ins_IUsPorRolBean); }
    public void list_ins_iusPorRolBeanRemove(IUsPorRolBean ins_IUsPorRolBean)
    {
        int index = this.getIndexOfList(ins_IUsPorRolBean);
        if(index != -1) this.list_ins_iusPorRolBean.remove(index);
    }
    public IUsPorRolBean getIusPorRolBeanIndex(int index)
    {
        IUsPorRolBean ins_IUsPorRolBean = new IUsPorRolBean();
       if(index != -1)
           ins_IUsPorRolBean = (IUsPorRolBean)this.list_ins_iusPorRolBean.get(index);
      return ins_IUsPorRolBean;
    }
    private Integer getIndexOfList(IUsPorRolBean ins_UIsPorRolBean)
    {
        Integer indexOf = -1;
        IUsPorRolBean ins_IUsPorRolBeanTmp;
         for(int i = 0;i < this.list_ins_iusPorRolBean.size();i++)
         {
            ins_IUsPorRolBeanTmp = (IUsPorRolBean)this.list_ins_iusPorRolBean.get(i);
            if(ins_IUsPorRolBeanTmp.getIdIU().trim().equals(ins_UIsPorRolBean.getIdIU().trim()))
                indexOf = i;
         }
        return indexOf;
    }
    public void list_ins_RolBeanUpdate(IUsPorRolBean ins_IUsPorRolBean)
    {
        /* OJO: No usar porque esta duplicando los items de las lista */
        Integer indexOf = this.getIndexOfList(ins_IUsPorRolBean);
        if(indexOf != -1)
        {
            IUsPorRolBean ins_IUsPorRolBeanTmp = (IUsPorRolBean)this.list_ins_iusPorRolBean.get(indexOf);
            if(!ins_IUsPorRolBeanTmp.getChecked())
            {
                ins_IUsPorRolBeanTmp.setChecked(true);
                this.list_ins_iusPorRolBean.remove(indexOf);
                this.list_ins_iusPorRolBean.add(indexOf, ins_IUsPorRolBeanTmp);
            }
        }
    }

    // para la navegacion desde frm_admin_ius_por_rol.jspx
    public String verificarChecks(){

        String vst_msg_return = "ningunamarcada";
        Integer vin_cantidadChecks = 0;
        Integer vin_pos_chked = -1;
        IUsPorRolBean ins_IUsPorRolBean_Tmp = new IUsPorRolBean();

        for(int i = 0; i < this.getList_ins_iusPorRolBean().size();i++)
        {
            ins_IUsPorRolBean_Tmp = (IUsPorRolBean)this.getList_ins_iusPorRolBean().get(i);

            /* obtengo el numero de registros checados y la pos del primer check */
            if(ins_IUsPorRolBean_Tmp.getChecked())
            {
                if(vin_pos_chked == -1)
                    vin_pos_chked = i;

                vin_cantidadChecks++;
            }
        }
        if(vin_cantidadChecks == 0)
        {
            this.setMsg("Debe seleccionar al menos una pantalla de accesso para el rol del usuario.");
            vst_msg_return = "ningunamarcada";
        }
        else
        {
            try {
                Servicio.IUsporRolAgregar(this);
                //this.list_ins_iusPorRolBeanAdd(this);// <== para el PROTOTIPO
                vst_msg_return = "Pantallas asignadas al rol exitósamente.";
            } catch (Exception ex) {
                Logger.getLogger(IUsPorRolBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vst_msg_return;
    }

    public void cmbRolBean_onChange(ValueChangeEvent event){
        try {
            Integer vin_idRol = Integer.parseInt(event.getNewValue().toString().trim());
            this.setIdRol(vin_idRol);

            this.ins_rolBean.setMsg("LISTA DE PANTALLAS POR ROL");
            if(vin_idRol == 0)
            {
                this.Inicializar_list_ins_iusPorRolBean();
            }
            else
            {
                this.CargarUIsPorRol(vin_idRol);
            }
        }
        catch (Exception ex) {
            this.ins_rolBean.setMsg("Error al intentar inicializar la lista de IUs por Rol.. "+ex.getMessage());
            Logger.getLogger(IUsPorRolBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setMsg("");
    }
/*
    public void click(javax.faces.event.ActionEvent e) {
        this.setMsg("evento click");
    }

    public void onload(javax.faces.event.ActionEvent e) {
       this.setMsg("evento onload");
    }
*/
}
