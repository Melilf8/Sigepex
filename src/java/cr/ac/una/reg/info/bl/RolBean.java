/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class RolBean {
    private int idRol;
    private String nombreRol;
    private String descripcionRol;
    private String msg;
    private List list_ins_RolBean;

    private ArrayList<SelectItem> list_ins_SelectItem_roles;


    public RolBean()
    {
        this.idRol = 0;
        this.nombreRol = "";
        this.descripcionRol = "";
        this.msg = "LISTA DE ROLES DE USUARIO";
        this.list_ins_RolBean = new ArrayList();
        this.Inicializar_list_ins_RolBean();
    }

    public RolBean(int idRol, String nombreRol, String descripcionRol, String msg) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.descripcionRol = descripcionRol;
        this.msg = msg;
    }

    public String getMsg() {  return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public String getDescripcionRol() { return descripcionRol; }
    public void setDescripcionRol(String descripcionRol) { this.descripcionRol = descripcionRol; }

    public int getIdRol() { return idRol; }
    public void setIdRol(int idRol) {
        if(new ToolBean().ValidarEsNumero(Integer.toString(idRol)))
        {
            this.idRol = idRol;
        }
        else
        {
            this.setMsg("El ID del Rol debe ser un valor numérico.");
        }
    }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }


    //ATRIBUTO: list_ins_RolBean
    public List getList_ins_RolBean() { return list_ins_RolBean; }
    public void setList_ins_RolBean(List list_ins_RolBean) { this.list_ins_RolBean = list_ins_RolBean; }
    public void list_ins_RolBeanClear(){ this.list_ins_RolBean.clear(); }
    public void list_ins_RolBeanAdd(RolBean ins_RolBean) { this.list_ins_RolBean.add(ins_RolBean); }
    public void list_ins_RolBeanRemove(RolBean ins_RolBean)
    {
        int index = this.getIndexOfList(ins_RolBean);//this.list_ins_RolBean.indexOf(ins_RolBean);
        if(index != -1) this.list_ins_RolBean.remove(index);
    }
    public RolBean getRolBeanIndex(int index)
    {
        RolBean ins_RolBean = new RolBean();
       if(index != -1)
           ins_RolBean = (RolBean)this.list_ins_RolBean.get(index);
      return ins_RolBean;
    }
    private Integer getIndexOfList(RolBean ins_RolBean)
    {
        Integer indexOf = -1;
        RolBean ins_RolBeanTmp;
         for(int i = 0;i < this.list_ins_RolBean.size();i++)
         {
            ins_RolBeanTmp = (RolBean)this.list_ins_RolBean.get(i);
            if(ins_RolBeanTmp.getIdRol() == ins_RolBean.getIdRol())
                indexOf = i;
         }
        return indexOf;
    }

    public void list_ins_RolBeanUpdate(RolBean ins_RolBean)
    {
        Integer indexOf = this.getIndexOfList(ins_RolBean);
        if(indexOf != -1)
        {             
            this.list_ins_RolBean.remove(indexOf);
            this.list_ins_RolBean.add(indexOf, ins_RolBean);
            /*
            RolBean ins_RolBeanTmp = (RolBean)this.list_ins_RolBean.get(indexOf);
            ins_IUsPorRolBeanTmp.setChecked(true);
            this.list_ins_iusPorRolBean.remove(indexOf);
            this.list_ins_iusPorRolBean.add(indexOf, ins_IUsPorRolBeanTmp);
             */
        }
    }

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
            this.setMsg("Error al cargar el combo de roles de usuario.. "+ex.getMessage());
        }
        return this.list_ins_SelectItem_roles;
    }

    public String Inicializar_list_ins_RolBean()
    {
        String vst_mensaje = "";
        try {
             this.list_ins_RolBean = new ArrayList();

             Servicio.rolListarTodos(this);

            if(this.getList_ins_RolBean().isEmpty())
            {
                 RolBean ins_RolBeanTmp = new RolBean(1,"Administrador","Administrador del sistema","");
                 this.list_ins_RolBean.add(ins_RolBeanTmp);
                 ins_RolBeanTmp = new RolBean(2,"Funcionario","Usuario del sistema","");
                 this.list_ins_RolBean.add(ins_RolBeanTmp);
            }
        }
        catch (Exception ex) {
            this.setMsg("Error al tratar de listar los parametros.. "+ex.getMessage());
        }
        return vst_mensaje;
    }

    /// Para la navegacion desde el frm_admin_roles.jspx
    public String consultarRol() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        if(this.getIdRol() == 0)
            this.setMsg("Debe ingresar un número de rol mayor que cero.");
        else
             Servicio.rolConsultar(this);

        return vst_mensaje;
    }

    /// Para la navegacion desde el frm_admin_roles.jspx
    public String registrarRol() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        if(this.getIdRol() == 0)list_st_comentarios.add(" el número");
        if(this.getNombreRol().equals(""))list_st_comentarios.add(" el Nombre");
        if(this.getDescripcionRol().equals(""))list_st_comentarios.add(" la Descripción");

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
             vst_mensaje = "Para Registrar un rol debe ingresar "+ vst_mensaje;
        }

        if(!list_st_comentarios.isEmpty())
        {
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            if(new ToolBean().ValidarEsNumero(Integer.toString(this.getIdRol())))
            {
                if(!new ToolBean().ValidarEsPalabra(this.getNombreRol()))
                {
                    this.setMsg("El nombre del rol debe contener únicamente letras.");
                    return "";
                }
                else if(!new ToolBean().ValidarEsPalabra(this.getDescripcionRol()))
                {
                    this.setMsg("La descripción del rol debe contener únicamente letras.");
                    return "";
                }
                else
                {
                    Servicio.rolAgregar(this);
                    //this.list_ins_RolBeanAdd(this);// <== para el PROTOTIPO
                    Servicio.rolListarTodos(this);


                    if(this.getIdRol() == 0)
                        return "noestaregistrado";
                    else
                    {
                        if(this.getMsg().equals("El rol ya está registrado en el sistema."))
                            return "yaexiste";
                        else
                            return "registrado";
                    }
                }
            }
            else
            {
                this.setMsg("El ID del Rol debe ser un valor numérico.");
                return "";
            }
        }
    }

    /// Para la navegacion desde el frm_admin_roles.jspx
    public String actualizarRol() throws Exception
    {
        this.setMsg("");
        String vst_mensaje="";
        ArrayList list_st_comentarios = new ArrayList();
        /* Campos requeridos para registrar un funcionario */
        if(this.getIdRol() == 0)list_st_comentarios.add(" el número");
        if(this.getNombreRol().equals(""))list_st_comentarios.add(" el Nombre");
        if(this.getDescripcionRol().equals(""))list_st_comentarios.add(" la Descripción");

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
             vst_mensaje = "Para actualizar el rol debe ingresar "+ vst_mensaje;
            this.setMsg(vst_mensaje);
            return "faltandatos";
        }
        else
        {
            if(new ToolBean().ValidarEsNumero(Integer.toString(this.getIdRol())))
            {
                if(!new ToolBean().ValidarEsPalabra(this.getNombreRol()))
                {
                    this.setMsg("El nombre del rol debe contener únicamente letras.");
                    return "";
                }
                else if(!new ToolBean().ValidarEsPalabra(this.getDescripcionRol()))
                {
                    this.setMsg("La descripción del rol debe contener únicamente letras.");
                    return "";
                }
                else
                {
                    Servicio.rolModificar(this);
                    //this.list_ins_RolBeanUpdate(this);// <== para el PROTOTIPO
                    Servicio.rolListarTodos(this);

                    if(this.getIdRol() == 0)
                        return "noexiste";
                    else
                        return "actualizado";
                }
            }
            else
            {
                this.setMsg("El ID del Rol debe ser un valor numérico.");
                return "";
            }
        }
    }

    public String eliminarRol() throws Exception
    {
        this.setMsg("");

        if(this.getIdRol() == 0)
        {
            this.setMsg("Para eliminar el rol debe ingresar el ID Rol correspondiente.");
            return "faltandatos";
        }
        else
        {
            if(new ToolBean().ValidarEsNumero(Integer.toString(this.getIdRol())))
            {
                Servicio.rolEliminar(this);
                Servicio.rolListarTodos(this);

                if(this.getIdRol() == 0)
                    return "noexiste";
                else
                    return "eliminado";
            }
            else
            {
                this.setMsg("El ID del Rol debe ser un valor numérico.");
                return "";
            }
        }
    }

    
  
}
