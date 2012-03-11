/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.RolBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.Vector;

//import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class RolDao {
    private String vst_mensaje;

    public void buscarRol(RolBean ins_rolBean) throws Exception{
        try
        {
            ins_rolBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_ROL_BUSCAR(?)");
            stmt.setInt(1,ins_rolBean.getIdRol());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                ins_rolBean.setIdRol(rs.getInt("ID_ROL"));
                ins_rolBean.setDescripcionRol(rs.getString("DESCRIPCION_ROL"));
                ins_rolBean.setNombreRol(rs.getString("NOMBRE_ROL"));
                ins_rolBean.setMsg("");
            }
            else
            {
                ins_rolBean.setIdRol(0);
                ins_rolBean.setDescripcionRol("");
                ins_rolBean.setNombreRol("");
                ins_rolBean.setMsg("No se encontró el rol dentro de la base de datos de SIGEPEX.");
            }
            rs.close();
        }
        catch(Exception e){
            ins_rolBean.setMsg("Error al tratar de buscar el rol de usuario.. "+e);
        }
    }

    public void agregarRol(RolBean ins_rolBean) throws Exception{
        try
       {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx;
            try
            {
                cx= DatabaseUtil.getConnectionFactory().getConnection();
            }
            catch(Exception ex){
                ins_rolBean.setMsg("Error al establecer la conexión con la base de datos SIGEPEX.");
                vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
                throw ex;
            }
            cx= DatabaseUtil.getConnectionFactory().getConnection();
            try{
                stmt = cx.prepareStatement("call ST_ROL_BUSCAR(?)");
            }
            catch(Exception ex){
                ins_rolBean.setMsg("Error al ejecutar procedimiento almacenado ST_ROL_BUSCAR en BD SIGEPEX.");
                vst_mensaje = "Error al ejecutar procedimiento almacenado ST_ROL_BUSCAR en BD SIGEPEX.\n"+ex;
                throw ex;
            }
            stmt.setInt(1,ins_rolBean.getIdRol());
            rs = stmt.executeQuery();
            rs.next();

            if(!rs.isFirst())//<== SI NO EXISTE SE AGREGA
            {
                stmt = null;
                try{
                    cx= DatabaseUtil.getConnectionFactory().getConnection();
                }
                catch(Exception ex){
                    ins_rolBean.setMsg("Error al intentar establecer la conexión con la base de datos SIGEPEX.");
                    vst_mensaje = "Error al intentar establecer la conexión con la base de datos SIGEPEX.\n"+ex;
                }
                try{
                    stmt = cx.prepareStatement("call ST_ROL_AGREGAR(?,?,?)");
                    stmt.setInt(1,ins_rolBean.getIdRol());
                    stmt.setString(2,ins_rolBean.getDescripcionRol());
                    stmt.setString(3,ins_rolBean.getNombreRol());
                    stmt.execute();

                    ins_rolBean.setMsg("El rol de usuario se registró con éxito.");
                }
                catch(Exception e){
                    ins_rolBean.setMsg("Error al ejecutar procedimiento almacenado ST_ROL_AGREGAR en BD SIGEPEX.\n"+e);
                    vst_mensaje = "Error al ejecutar procedimiento almacenado ST_ROL_AGREGAR en BD SIGEPEX.\n"+e;
                }
            }
            else
                ins_rolBean.setMsg("El rol de usuario ya está registrado en el sistema.");

        }
        catch(Exception e){
            vst_mensaje = "Error al tratar de agregar el rol de usuario.\n";
            ins_rolBean.setMsg(vst_mensaje+e);
        }
    }

    public void modificarRol(RolBean ins_rolBean) throws Exception
    {
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_ROL_BUSCAR(?)");
            stmt.setInt(1,ins_rolBean.getIdRol());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_ROL_MODIFICAR(?,?,?)");
                stmt.setInt(1,ins_rolBean.getIdRol());
                stmt.setString(2,ins_rolBean.getDescripcionRol());
                stmt.setString(3,ins_rolBean.getNombreRol());
                stmt.execute();
                
                ins_rolBean.setMsg("El rol de usuario se actualizó con éxito.");
            }
            else
                ins_rolBean.setMsg("El rol de usuario no está registrado en el sistema.");

        }
        catch(Exception e){
            ins_rolBean.setMsg("Error al tratar de actualizar el rol de usuario.");
        }
    }

    public void eliminarRol(RolBean ins_rolBean) throws Exception
    {
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_ROL_BUSCAR(?)");
            stmt.setInt(1,ins_rolBean.getIdRol());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                ResultSet resultset = null;
                stmt = cx.prepareStatement("call ST_ROL_CANTIDAD_FUNCIONARIOSXROL(?)");
                stmt.setInt(1,ins_rolBean.getIdRol());
                resultset = stmt.executeQuery();
                resultset.next();
                if(!resultset.isFirst())// <== NO HAY USUARIOS RELACIONADOS AL ROL
                {
                    stmt = cx.prepareStatement("call ST_ROL_ELIMINAR(?)");
                    stmt.setInt(1,ins_rolBean.getIdRol());
                    stmt.execute();

                    ins_rolBean.setMsg("El rol de usuario se eliminó con éxito.");
                }
                else
                {
                    ins_rolBean.setMsg("No se puede eliminar el rol, hay usuarios que lo están usando.");
                }
            }
            else
                ins_rolBean.setMsg("El rol de usuario no existe en el sistema.");
        }
        catch(Exception e){
            ins_rolBean.setMsg("Error al tratar de eliminar el rol de usuario.. "+e.getMessage());
        }
    }

    public void listarRoles(RolBean ins_rolBean) throws Exception
     {
        ResultSet rs = null;
        ArrayList list_ins_roles = new ArrayList();
        PreparedStatement stmt = null;
        Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
        stmt = cx.prepareStatement("call ST_ROL_LISTAR_TODOS()");
        rs = stmt.executeQuery();

        RolBean ins_rolBeanTmp;
        while(rs.next()){
            ins_rolBeanTmp = new RolBean(rs.getInt("ID_ROL"),rs.getString("NOMBRE_ROL"),rs.getString("DESCRIPCION_ROL"),"");

            list_ins_roles.add(ins_rolBeanTmp);
        }
        rs.close();
        stmt.close();

        ins_rolBean.setList_ins_RolBean(list_ins_roles);
    }
}
