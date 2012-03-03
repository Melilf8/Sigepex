/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class ParametroBean {
    /* ATRIBUTOS */
    //private Boolean listarParametros;
    private int idParametro;
    private String nombre;
    private int valor;
    private String msg;
    private List list_ins_ParametroBean;

    /* CONSTRUCTORES*/
    public ParametroBean()
    {
        this.idParametro = 0;
        this.nombre = "";
        this.valor = 0;
        this.msg = "";
        this.list_ins_ParametroBean = new ArrayList();
        this.Inicializar_list_ins_ParametroBean();
    }
    public ParametroBean(int idParametro, String nombre, int valor, String msg) {
        this.idParametro = idParametro;
        this.nombre = nombre;
        this.valor = valor;
        this.msg = msg;
    }

     /* PROPIEDADES */
    public int getIdParametro() { return idParametro; }
    public void setIdParametro(int idParametro) { this.idParametro = idParametro; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public List getList_ins_ParametroBean() { return list_ins_ParametroBean; }
    public void setList_ins_ParametroBean(List list_ins_ParametroBean) { this.list_ins_ParametroBean = list_ins_ParametroBean; }

    public String Inicializar_list_ins_ParametroBean()
    {
        String vst_mensaje = "";
        try{
             this.list_ins_ParametroBean = new ArrayList();
             Servicio.parametroListarTodos(this);

             if(this.getList_ins_ParametroBean().isEmpty())
             {
                 ParametroBean ins_ParametroBeanTmp = new ParametroBean(1,"MAX_DIAS_PRESTAMO_EXP",15,"");
                 this.list_ins_ParametroBean.add(ins_ParametroBeanTmp);
                 ins_ParametroBeanTmp = new ParametroBean(2,"DIAS_PREV_TO_SEND_MAIL",3,"");
                 this.list_ins_ParametroBean.add(ins_ParametroBeanTmp);
             }
             //else
                 //this.list_ins_ParametroBean = (ArrayList)this.getList_ins_ParametroBean();
        }
        catch (Exception ex) {
            this.setMsg("Error al tratar de listar los parametros.. "+ex.getMessage());
        }
        return vst_mensaje;
    }

    /// Para la navegacion desde el frm_actualizar_usuario.jspx
    public String actualizarParametro() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        if(this.getIdParametro() == 0)list_st_comentarios.add(" el número");
        if(this.getValor() == 0)list_st_comentarios.add(" el valor");

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
             vst_mensaje = "Para actualizar el parámetro debe ingresar "+ vst_mensaje;
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            Servicio.parametroModificar(this);
            Servicio.parametroListarTodos(this);

            if(this.getIdParametro() == 0)
                return "noexiste";
            else
            {
                return "actualizado";

            }
        }
    }

}
