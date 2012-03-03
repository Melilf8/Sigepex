/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luis Granados
 */
public class SerieDocumentalBean {
    /* ATRIBUTOS */
    private int idSerieDocumental;
    private String tipoDocumental;
    private String msg;
    private Boolean checked;
    private List list_ins_SerieDocBean;

    /* CONSTRUCTORES */
    public SerieDocumentalBean()
    {
        this.idSerieDocumental = 0;
        this.tipoDocumental = "";
        this.msg = "-";
        this.checked = false;
        this.Inicializar_list_ins_SerieDocBean();
    }

    public SerieDocumentalBean(int idSerieDocumental, String tipoDocumental, String msg, Boolean checked) {
        this.idSerieDocumental = idSerieDocumental;
        this.tipoDocumental = tipoDocumental;
        this.msg = msg;
        this.checked = checked;
    }

    /* PROPIEDADES */
    public int getIdSerieDocumental() { return idSerieDocumental; }
    public void setIdSerieDocumental(int idSerieDocumental) { this.idSerieDocumental = idSerieDocumental; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public String getTipoDocumental() { return tipoDocumental; }
    public void setTipoDocumental(String tipoDocumental) { this.tipoDocumental = tipoDocumental; }

    public Boolean getChecked() { return checked; }
    public void setChecked(Boolean checked) { this.checked = checked; }

     //ATRIBUTO: list_ins_RolBean
    public List getList_ins_SerieDocBean() { return list_ins_SerieDocBean; }
    public void setList_ins_SerieDocBean(List list_ins_SerieDocBean) { this.list_ins_SerieDocBean = list_ins_SerieDocBean; }
    public void list_ins_SerieDocBeanClear(){ this.list_ins_SerieDocBean.clear(); }
    public void list_ins_SerieDocBeanAdd(SerieDocumentalBean ins_SerieDocBean) { this.list_ins_SerieDocBean.add(ins_SerieDocBean); }
    public void list_ins_SerieDocBeanRemove(SerieDocumentalBean ins_SerieDocBean)
    {
        int index = this.getIndexOfList(ins_SerieDocBean);
        if(index != -1)
            this.list_ins_SerieDocBean.remove(index);
    }

    public void list_ins_SerieDocBeanRemoveMulti(SerieDocumentalBean ins_SerieDocBean)
    {
        Integer indexOf = -1;
        SerieDocumentalBean ins_SerieDocBeanTmp;
         for(int index = 0;index <ins_SerieDocBean.getList_ins_SerieDocBean().size();index++)
         {
            ins_SerieDocBeanTmp = (SerieDocumentalBean) ins_SerieDocBean.getList_ins_SerieDocBean().get(index);
            if(ins_SerieDocBeanTmp.getChecked())
                ins_SerieDocBean.list_ins_SerieDocBeanRemove(ins_SerieDocBeanTmp);
         }
    }
    
    public SerieDocumentalBean getSerieDocBeanIndex(int index)
    {
        SerieDocumentalBean ins_SerieDocBean = new SerieDocumentalBean();
       if(index != -1)
           ins_SerieDocBean = (SerieDocumentalBean)this.list_ins_SerieDocBean.get(index);
      return ins_SerieDocBean;
    }

    private Integer getIndexOfList(SerieDocumentalBean ins_serieDocBean)
    {
        Integer indexOf = -1;
        SerieDocumentalBean ins_SerieDocBeanTmp;
         for(int i = 0;i < this.list_ins_SerieDocBean.size();i++)
         {
            ins_SerieDocBeanTmp = (SerieDocumentalBean)this.list_ins_SerieDocBean.get(i);
            if(ins_SerieDocBeanTmp.getIdSerieDocumental() == ins_serieDocBean.getIdSerieDocumental())
                indexOf = i;
         }
        return indexOf;
    }
    
    public void list_ins_RolBeanUpdate(SerieDocumentalBean ins_SerieDocBean)
    {
        Integer indexOf = this.getIndexOfList(ins_SerieDocBean);
        if(indexOf != -1)
            this.list_ins_SerieDocBean.add(indexOf, ins_SerieDocBean);
    }

    private void Inicializar_list_ins_SerieDocBean()
    {
        try {

            /*
            SerieDocumentalBean ins_serieDocTmp = new SerieDocumentalBean();
            Servicio.serieDocumentalListarTodas(ins_serieDocTmp);

            if(!ins_serieDocTmp.getList_ins_SerieDocBean().isEmpty())
            {
                SerieDocumentalBean ins_serieDocTmp2;
                ArrayList list_ins_SerieDocBeanTmp = new ArrayList();
                for(int i = 0;i < ins_serieDocTmp.getList_ins_SerieDocBean().size();i++)
                {
                    ins_serieDocTmp2 = (SerieDocumentalBean)ins_serieDocTmp.getList_ins_SerieDocBean().get(i);
                }
            }
             */
             this.list_ins_SerieDocBean = new ArrayList();
            Servicio.serieDocumentalListarTodas(this);
            
            if(this.getList_ins_SerieDocBean().isEmpty())
            {
                /* para el PROTOTIPO */
                this.list_ins_SerieDocBean = new ArrayList();
                SerieDocumentalBean ins_SerieDocBeanTmp = new SerieDocumentalBean(1, "Cédulas", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(2, "Títulos Universitarios", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(3, "Equiparación de Títulos", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(4, "Retiros Justificados", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(5, "Empadronamientos", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(6, "Fotos", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(7, "Expedientes", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(8, "Títulos Universitarios", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(9, "Títulos Autentificados", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(10, "Títulos de Colegio", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(11, "Certificación de Títulos", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(12, "Resoluciones de la Universidad", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(13, "Retiros de Cursos", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(14, "Fotocopias de Títulos de Enseñanza Media", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
                ins_SerieDocBeanTmp = new SerieDocumentalBean(15, "Actas de Graduación", "", false);
                this.list_ins_SerieDocBean.add(ins_SerieDocBeanTmp);
            }
        } catch (Exception ex) {
            Logger.getLogger(SerieDocumentalBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /* Verifica si la serie documental ingresada existe en el grid */
    public Boolean verificarSerieDoc() throws Exception
    {
        this.setMsg("");
        Boolean vbo_existe = false;
        if(this.getIdSerieDocumental() == 0)
            this.setMsg("Debe ingresar un identificador de serie documental mayor que cero.");
        else
        {
            if(!this.getList_ins_SerieDocBean().isEmpty())
            {
                SerieDocumentalBean ins_serieDocBeanTmp;
                for(int i = 0;i < this.getList_ins_SerieDocBean().size();i++)
                {
                    ins_serieDocBeanTmp = (SerieDocumentalBean)this.getList_ins_SerieDocBean().get(i);
                    if(this.getIdSerieDocumental() == ins_serieDocBeanTmp.getIdSerieDocumental())
                    {
                        vbo_existe = true;
                        break;
                    }
                }
            }
        }
        return vbo_existe;
    }

    /// Para la navegacion desde el frm_admin_serie_documental.jspx
    public String registrarSerieDoc() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        try{
            Integer vin_serie = this.getIdSerieDocumental();
            if(vin_serie == null)
                list_st_comentarios.add("Debe ingresar un identificador válido para la serie documental.");
        }
        catch(Exception ex){
            list_st_comentarios.add("Debe ingresar un identificador válido para la serie documental.");
        }
        if(this.getIdSerieDocumental() == 0)
            list_st_comentarios.add("El identificador de la serie documental debe ser mayor que cero.");
        if(this.getTipoDocumental().equals(""))list_st_comentarios.add(" el tipo documental");

        if(!list_st_comentarios.isEmpty())
        {
            for(int i = 0; i < list_st_comentarios.size();i++)
            {
                if(i == 0)
                     vst_mensaje += (String)list_st_comentarios.get(i);
                else if(i == list_st_comentarios.size()-1 )
                    vst_mensaje += " y " + (String)list_st_comentarios.get(i)+".";
                else
                    vst_mensaje += ", " + (String)list_st_comentarios.get(i);
            }
            if(list_st_comentarios.size() == 1)
                    vst_mensaje = (String)list_st_comentarios.get(0);
             else
                vst_mensaje = "Para Registrar una serie documental debe ingresar "+ vst_mensaje;
        }

        if(!list_st_comentarios.isEmpty())
        {
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            if(!this.verificarSerieDoc())
            {
                Servicio.seriedocumentalAgregar(this);
                Servicio.serieDocumentalListarTodas(this);
                //this.list_ins_SerieDocBeanAdd(this);// <== para el PROTOTIPO
            }
            else
            {
                this.setMsg("No puede duplicar el ID de una serie documental.");
                return "serieduplicada";
            }
            if(this.getIdSerieDocumental() == 0)
                return "noestaregistrado";
            else
            {
                if(this.getMsg().equals("La serie documental ya está registrada en el sistema."))
                    return "yaexiste";
                else
                    return "registrado";
            }
        }
    }

    /// Para la navegacion desde el frm_admin_serie_documental.jspx
    public String actualizarSerieDoc() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        if(this.getIdSerieDocumental() == 0)list_st_comentarios.add(" el identificador");
        if(this.getTipoDocumental().equals(""))list_st_comentarios.add(" el tipo documental");

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
             vst_mensaje = "Para actualizar la serie documental debe ingresar "+ vst_mensaje;
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            if(this.verificarSerieDoc())
            {
                Servicio.seriedocumentalModificar(this);
                Servicio.serieDocumentalListarTodas(this);
                // this.list_ins_RolBeanUpdate(this);// <== para el PROTOTIPO
            }
            else
            {
                this.setMsg("Debe ingresar una serie documental válida del listado.");
                return "noexiste";
            }

            if(this.getIdSerieDocumental() == 0)
                return "noexiste";
            else
                return "actualizado";
        }
    }

    // para la navegacion desde frm_admin_serie_documental.jspx
    public String eliminarSerieDoc(){

        String vst_msg_return = "ningunamarcada";
        Integer vin_cantidadChecks = 0;
        Integer vin_pos_chked = -1;
        SerieDocumentalBean ins_serieDocumentalBean_Tmp = new SerieDocumentalBean();

        for(int i = 0; i < this.getList_ins_SerieDocBean().size();i++)
        {
            ins_serieDocumentalBean_Tmp = (SerieDocumentalBean)this.getList_ins_SerieDocBean().get(i);

            /* obtengo el numero de registros checados y la pos del primer check */
            if(ins_serieDocumentalBean_Tmp.getChecked())
            {
                if(vin_pos_chked == -1)
                    vin_pos_chked = i;

                vin_cantidadChecks++;
            }
        }
        if(vin_cantidadChecks == 0)
        {
            this.setMsg("Debe seleccionar al menos una pantalla para eliminar la serie documental.");
            vst_msg_return = "ningunamarcada";
        }
        else
        {
            try {
                Servicio.seriedocumentalEliminar(this);
                //this.list_ins_SerieDocBeanRemoveMulti(this);// <== para el PROTOTIPO
                vst_msg_return = "Series documentales eliminadas exitósamente.";
            } catch (Exception ex) {
                Logger.getLogger(SerieDocumentalBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vst_msg_return;
    }
}
