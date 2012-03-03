/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.FuncionarioBean;
import cr.ac.una.reg.info.bl.LoginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Vector;

import java.util.ArrayList;
//import java.util.List;

/**
 *
 * @author Luis Granados
 */
public class FuncionarioDao {

    private String vst_mensaje;
    //private List EntityCollectionFuncionarios;

    public void buscarLogin(LoginBean ins_loginBean) throws Exception{
        try
        {
            ins_loginBean.setMsg("");

            vst_mensaje = "";
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCAR(?)");
            stmt.setString(1,ins_loginBean.getIdentificacion());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                String vst_nombreLoging = "";
                ins_loginBean.setIdentificacion(rs.getString("ID_FUNCIONARIO"));
                vst_nombreLoging = rs.getString("NOMBRE");
                vst_nombreLoging += " ";
                vst_nombreLoging += rs.getString("APELLIDO1");
                vst_nombreLoging += " ";
                vst_nombreLoging += rs.getString("APELLIDO2");
                ins_loginBean.setNombre(vst_nombreLoging.trim());
                ins_loginBean.setEstado(rs.getInt("ID_ESTADO"));
                //ins_loginBean.getString(rs.getInt("ESTADO"));
                ins_loginBean.setContrasena(rs.getString("CONTRASENA"));
                ins_loginBean.setRol(rs.getInt("ID_ROL"));
                ins_loginBean.setMsg("");
            }
            else
            {
                ins_loginBean.setIdentificacion("");
                ins_loginBean.setNombre("");
                //ins_loginBean.setIdEstado(0);
                //ins_loginBean.setEstado("");
                ins_loginBean.setEstado(0);
                ins_loginBean.setContrasena("");
                //ins_funcionarioBean.setIdRol(0);
                //ins_funcionarioBean.setRol("");
                ins_loginBean.setRol(0);

                vst_mensaje = "Usted no está autorizado para ingresar en el sistema. Por favor comuníquese con el administrador.";
                ins_loginBean.setMsg(vst_mensaje);
            }
            rs.close();
        }
        catch(Exception e){
            vst_mensaje = "Funcionario no existe.. \n";
            ins_loginBean.setMsg(vst_mensaje+e);
        }
    }

    public void buscarFuncionarioPorNombre(FuncionarioBean ins_funcionarioBean) throws Exception{
        try{
            ins_funcionarioBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            FuncionarioBean ins_funcionarioBeanTmp;
            ArrayList list_ins_funcionarios = new ArrayList();
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCARXNOMBRE(?,?,?,?)");
            stmt.setString(1,ins_funcionarioBean.getIdentificacion());
            stmt.setString(2,ins_funcionarioBean.getNombre());
            stmt.setString(3,ins_funcionarioBean.getApellido1());
            stmt.setString(4,ins_funcionarioBean.getApellido2());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                ins_funcionarioBeanTmp = new FuncionarioBean(
                rs.getString("ID_FUNCIONARIO"),
                rs.getString("NOMBRE"),
                rs.getString("APELLIDO1"),
                rs.getString("APELLIDO2"),
                rs.getString("EMAIL"),
                rs.getInt("ID_ESTADO"),
                rs.getString("CONTRASENA"),
                rs.getInt("ID_ROL"),
                rs.getInt("ID_DEPENDENCIA"),"");

                list_ins_funcionarios.add(ins_funcionarioBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_funcionarioBean.setList_ins_funcionarios(list_ins_funcionarios);

        }catch(Exception e){
            vst_mensaje = "Funcionario no encontrado.. \n";
            ins_funcionarioBean.setMsg(vst_mensaje+e);
        }
    }

    public void buscarFuncionario(FuncionarioBean ins_funcionarioBean) throws Exception{
        try
        {
           ins_funcionarioBean.setMsg("");

           if(!ins_funcionarioBean.getIdentificacion().equals("")
                && ins_funcionarioBean.getIdentificacion().length()== 9)
           {
                vst_mensaje = "";
                ResultSet rs = null;
                PreparedStatement stmt = null;
                Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
                stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCAR(?)");
                stmt.setString(1,ins_funcionarioBean.getIdentificacion());
                rs = stmt.executeQuery();
                rs.next();

                if(rs.isFirst())//<== LOCALIZADO
                {
                    ins_funcionarioBean.setIdentificacion(rs.getString("ID_FUNCIONARIO"));
                    ins_funcionarioBean.setNombre(rs.getString("NOMBRE"));
                    ins_funcionarioBean.setApellido1(rs.getString("APELLIDO1"));
                    ins_funcionarioBean.setApellido2(rs.getString("APELLIDO2"));
                    ins_funcionarioBean.setEmail(rs.getString("EMAIL"));
                    ins_funcionarioBean.setEstado(rs.getInt("ID_ESTADO"));
                    //ins_funcionarioBean.getString(rs.getInt("ESTADO"));
                    ins_funcionarioBean.setContrasena(rs.getString("CONTRASENA"));
                    ins_funcionarioBean.setRol(rs.getInt("ID_ROL"));
                    //ins_funcionarioBean.setRol(rs.getString("ROL"));
                    ins_funcionarioBean.setIdDependencia(rs.getInt("ID_DEPENDENCIA"));
                    //ins_funcionarioBean.setRol(rs.getString("DEPENDENCIA"));
                    ins_funcionarioBean.setMsg("");
                }
                else
                {
                    //ins_funcionarioBean.setIdentificacion("");
                    ins_funcionarioBean.setNombre("");
                    ins_funcionarioBean.setApellido1("");
                    ins_funcionarioBean.setApellido2("");
                    ins_funcionarioBean.setEmail("");
                    //ins_funcionarioBean.setIdEstado(0);
                    //ins_funcionarioBean.setEstado("");
                    ins_funcionarioBean.setEstado(0);
                    //ins_funcionarioBean.setContrasena("");
                    //ins_funcionarioBean.setIdRol(0);
                    //ins_funcionarioBean.setRol("");
                    ins_funcionarioBean.setRol(0);
                    ins_funcionarioBean.setIdDependencia(0);
                    //ins_funcionarioBean.setDependencia("");

                    vst_mensaje = "No se encontró en funcionario.";
                    ins_funcionarioBean.setMsg(vst_mensaje);
                }
                rs.close();
           }
           else if(ins_funcionarioBean.getIdentificacion().equals(""))
           {
                ArrayList list_ins_funcionarioBean = (ArrayList)this.listarFuncionarios();
                //ins_funcionarioBean = new FuncionarioBean();
                ins_funcionarioBean.setList_ins_funcionarios(list_ins_funcionarioBean);
           }
           else
           {
                //ST_FUNCIONARIO_LIKE_ID
                ResultSet rs = null;
                ArrayList list_ins_funcionarios = new ArrayList();
                FuncionarioBean ins_funcionarioBeanTmp;
                PreparedStatement stmt = null;
                Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
                stmt = cx.prepareStatement("call ST_FUNCIONARIO_LIKE_ID(?)");
                stmt.setString(1,ins_funcionarioBean.getIdentificacion());
                rs = stmt.executeQuery();

                while(rs.next()){

                    ins_funcionarioBeanTmp = new FuncionarioBean(
                    rs.getString("ID_FUNCIONARIO"),
                    rs.getString("NOMBRE"),
                    rs.getString("APELLIDO1"),
                    rs.getString("APELLIDO2"),
                    rs.getString("EMAIL"),
                    rs.getInt("ID_ESTADO"),
                    rs.getString("CONTRASENA"),
                    rs.getInt("ID_ROL"),
                    rs.getInt("ID_DEPENDENCIA"),"");
                    /*
                    ins_funcionarioBeanTmp = new FuncionarioBean();
                    ins_funcionarioBeanTmp.setIdentificacion(rs.getString("ID_FUNCIONARIO"));
                    ins_funcionarioBeanTmp.setNombre(rs.getString("NOMBRE"));
                    ins_funcionarioBeanTmp.setApellido1(rs.getString("APELLIDO1"));
                    ins_funcionarioBeanTmp.setApellido2(rs.getString("APELLIDO2"));
                    ins_funcionarioBeanTmp.setEmail(rs.getString("EMAIL"));
                    ins_funcionarioBeanTmp.setEstado(rs.getInt("ID_ESTADO"));
                    //ins_funcionarioBeanTmp.getString(rs.getInt("ESTADO"));
                    ins_funcionarioBeanTmp.setContrasena(rs.getString("CONTRASENA"));
                    ins_funcionarioBeanTmp.setRol(rs.getInt("ID_ROL"));
                    //ins_funcionarioBeanTmp.setRol(rs.getString("ROL"));
                    ins_funcionarioBeanTmp.setIdDependencia(rs.getInt("ID_DEPENDENCIA"));
                    //ins_funcionarioBeanTmp.setRol(rs.getString("DEPENDENCIA"));
                    */
                    list_ins_funcionarios.add(ins_funcionarioBeanTmp);
                }
                rs.close();
                stmt.close();

                ins_funcionarioBean.setList_ins_funcionarios(list_ins_funcionarios);

           }
        }
        catch(Exception e){
            vst_mensaje = "Funcionario no encontrado.. \n";
            ins_funcionarioBean.setMsg(vst_mensaje+e);
        }
    }

    public void agregarFuncionario(FuncionarioBean ins_funcionarioBean) throws Exception{       
        try
        {
            ins_funcionarioBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx;
            try
            {
                cx= DatabaseUtil.getConnectionFactory().getConnection();
            }
            catch(Exception ex){
                ins_funcionarioBean.setMsg("Error al establecer la conexión con la base de datos SIGEPEX.");
                vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
                throw ex;
            }
            cx= DatabaseUtil.getConnectionFactory().getConnection();
            try{
                stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCAR(?)");
            }
            catch(Exception ex){
                ins_funcionarioBean.setMsg("Error al ejecutar procedimiento almacenado ST_FUNCIONARIO_BUSCAR en BD SIGEPEX.");
                vst_mensaje = "Error al ejecutar procedimiento almacenado ST_FUNCIONARIO_BUSCAR en BD SIGEPEX.\n"+ex;
                throw ex;
            }
            stmt.setString(1,ins_funcionarioBean.getIdentificacion());
            rs = stmt.executeQuery();
            rs.next();

            if(!rs.isFirst())//<== SI NO EXISTE SE AGREGA
            {
                stmt = null;
                try{
                    cx= DatabaseUtil.getConnectionFactory().getConnection();
                }
                catch(Exception ex){
                    ins_funcionarioBean.setMsg("Error al intentar establecer la conexión con la base de datos SIGEPEX.");
                    vst_mensaje = "Error al intentar establecer la conexión con la base de datos SIGEPEX.\n"+ex;
                }
                try{
                    stmt = cx.prepareStatement("call ST_FUNCIONARIO_AGREGAR(?,?,?,?,?,?,?,?,?)");
                    stmt.setString(1,ins_funcionarioBean.getIdentificacion());
                    stmt.setString(2,ins_funcionarioBean.getNombre());
                    stmt.setString(3,ins_funcionarioBean.getApellido1());
                    stmt.setString(4,ins_funcionarioBean.getApellido2());
                    stmt.setString(5,ins_funcionarioBean.getEmail());
                    stmt.setInt(6,ins_funcionarioBean.getEstado());
                    stmt.setString(7,ins_funcionarioBean.getContrasena());
                    stmt.setInt(8,ins_funcionarioBean.getRol());
                    stmt.setInt(9,ins_funcionarioBean.getIdDependencia());
                    stmt.execute();

                    ins_funcionarioBean.setMsg("Funcionario Registrado con éxito.");
                }
                catch(Exception e){
                    ins_funcionarioBean.setMsg("Error al ejecutar procedimiento almacenado ST_FUNCIONARIO_AGREGAR en BD SIGEPEX.\n"+e);
                    vst_mensaje = "Error al ejecutar procedimiento almacenado ST_FUNCIONARIO_AGREGAR en BD SIGEPEX.\n"+e;
                }
            }
            else
                ins_funcionarioBean.setMsg("El funcionario ya está registrado en el sistema.");

            /*
            // PARA EL PROTOTIPO
            Integer indexOf = this.call_ST_FUNCIONARIO_BUSCAR(ins_funcionarioBean,this.EntityCollectionFuncionarios);
            if(indexOf == -1)
            {
                this.EntityCollectionFuncionarios.add(ins_funcionarioBean);
                ins_funcionarioBean.setMsg("Funcionario Registrado con éxito.");
            }
            else
                ins_funcionarioBean.setMsg("El funcionario ya está registrado en el sistema.");
            // FIN PROTOTIPO
            */
        }
        catch(Exception e){
            //ins_funcionarioBean.setMsg("El funcionario ya está registrado en el sistema.");
            //vst_mensaje = "El funcionario ya está registrado en el sistema.\n"+e;
        }        
    }

    public void modificarFuncionario(FuncionarioBean ins_funcionarioBean) throws Exception
    {
        try
        {
            ins_funcionarioBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCAR(?)");
            stmt.setString(1,ins_funcionarioBean.getIdentificacion());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_FUNCIONARIO_MODIFICAR(?,?,?,?,?,?,?,?,?)");
                stmt.setString(1,ins_funcionarioBean.getIdentificacion());
                stmt.setString(2,ins_funcionarioBean.getNombre());
                stmt.setString(3,ins_funcionarioBean.getApellido1());
                stmt.setString(4,ins_funcionarioBean.getApellido2());
                stmt.setString(5,ins_funcionarioBean.getEmail());
                stmt.setInt(6,ins_funcionarioBean.getEstado());
                stmt.setString(7,ins_funcionarioBean.getContrasena());
                stmt.setInt(8,ins_funcionarioBean.getRol());
                stmt.setInt(9,ins_funcionarioBean.getIdDependencia());
                stmt.execute();

                ins_funcionarioBean.setMsg("Funcionario Actualizado con éxito.");
            }
            else
                ins_funcionarioBean.setMsg("El funcionario no está registrado en el sistema.");
         

             /*
             // PARA EL PROTOTIPO
            Integer indexOf = this.call_ST_FUNCIONARIO_BUSCAR(ins_funcionarioBean,this.EntityCollectionFuncionarios);

            if(indexOf == -1)
            if(this.EntityCollectionFuncionarios.indexOf(ins_funcionarioBean) == -1)
                ins_funcionarioBean.setMsg("El funcionario no está registrado en el sistema.");
            else
            {
                this.EntityCollectionFuncionarios.remove(indexOf);
                this.EntityCollectionFuncionarios.add(ins_funcionarioBean);
                ins_funcionarioBean.setMsg("Funcionario Actualizado con éxito.");
            }
            // FIN PROTOTIPO
            */
        }
        catch(Exception e){
            ins_funcionarioBean.setMsg("Error al tratar de actualizar el funcionario.");
            vst_mensaje = "error al tratar de actualizar el funcionario.\n"+e;
        }
    }

    public void suspenderFuncionario(FuncionarioBean ins_funcionarioBean)throws Exception
    {
         try
         {
             ins_funcionarioBean.setMsg("");

             ResultSet rs = null;
             PreparedStatement stmt = null;
             Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
             stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCAR(?)");
             stmt.setString(1,ins_funcionarioBean.getIdentificacion());
             rs = stmt.executeQuery();
             rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_FUNCIONARIO_SUSPENDER(?,?)");
                stmt.setString(1,ins_funcionarioBean.getIdentificacion());
                stmt.setInt(2,ins_funcionarioBean.getEstado());
                stmt.execute();
                stmt.close();
            }
            else
                ins_funcionarioBean.setMsg("El funcionario no está registrado en el sistema.");

                /*
                // PARA EL PROTOTIPO
                Integer indexOf = this.call_ST_FUNCIONARIO_BUSCAR(ins_funcionarioBean,this.EntityCollectionFuncionarios);

                if(indexOf == -1)
                if(this.EntityCollectionFuncionarios.indexOf(ins_funcionarioBean) == -1)
                    ins_funcionarioBean.setMsg("El funcionario no está registrado en el sistema.");
                else
                {
                    this.EntityCollectionFuncionarios.remove(indexOf);
                    this.EntityCollectionFuncionarios.add(ins_funcionarioBean);
                    if(ins_funcionarioBean.getEstado()==0)
                        ins_funcionarioBean.setMsg("Funcionario suspendido con éxito.");
                    else
                        ins_funcionarioBean.setMsg("Funcionario autenticado con éxito.");
                }
                // FIN PROTOTIPO
                */
         }
         catch(Exception e){
             ins_funcionarioBean.setMsg("Error al tratar de suspender el funcionario.\n"+e);
             vst_mensaje = "error al tratar de suspender el funcionario.\n"+e;
        }
    }

    public void actualizarEstadoFuncionario(FuncionarioBean ins_funcionarioBean) throws Exception{
        try
        {
            ins_funcionarioBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_FUNCIONARIO_BUSCAR(?)");
            stmt.setString(1,ins_funcionarioBean.getIdentificacion());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_FUNCIONARIO_ACTUALIZAR_ESTADO(?,?)");
                stmt.setString(1,ins_funcionarioBean.getIdentificacion());
                stmt.setInt(2,ins_funcionarioBean.getEstado());
                stmt.execute();
                stmt.close();
            }
             else
                ins_funcionarioBean.setMsg("El funcionario no está registrado en el sistema.");
         
         /*
         // PARA EL PROTOTIPO
        Integer indexOf = this.call_ST_FUNCIONARIO_BUSCAR(ins_funcionarioBean,this.EntityCollectionFuncionarios);
        
        if(indexOf == -1)
        if(this.EntityCollectionFuncionarios.indexOf(ins_funcionarioBean) == -1)
            ins_funcionarioBean.setMsg("El funcionario no está registrado en el sistema.");
        else
        {
            this.EntityCollectionFuncionarios.remove(indexOf);
            this.EntityCollectionFuncionarios.add(ins_funcionarioBean);
            if(ins_funcionarioBean.getEstado()==0)
                ins_funcionarioBean.setMsg("Funcionario suspendido con éxito.");
            else
                ins_funcionarioBean.setMsg("Funcionario autenticado con éxito.");
        }
        // FIN PROTOTIPO
        */
        }
        catch(Exception e){
             ins_funcionarioBean.setMsg("Error al tratar de actualizar el estado el funcionario.\n"+e);
             vst_mensaje = "error al tratar de actualizar el estado el funcionario.\n"+e;
        }
    }

     public ArrayList listarFuncionarios() throws Exception
     {
        ResultSet rs = null;
        ArrayList list_ins_funcionarios = new ArrayList();
        FuncionarioBean ins_funcionarioBean;
        PreparedStatement stmt = null;
        Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
        stmt = cx.prepareStatement("call ST_FUNCIONARIO_LISTAR_TODOS()");
        rs = stmt.executeQuery();

         while(rs.next()){
            ins_funcionarioBean = new FuncionarioBean(
                    rs.getString("ID_FUNCIONARIO"),
                    rs.getString("NOMBRE"),
                    rs.getString("APELLIDO1"),
                    rs.getString("APELLIDO2"),
                    rs.getString("EMAIL"),
                    rs.getInt("ID_ESTADO"),
                    rs.getString("CONTRASENA"),
                    rs.getInt("ID_ROL"),
                    rs.getInt("ID_DEPENDENCIA"),"");
            /*
            ins_funcionarioBean.setIdentificacion(rs.getString("ID_FUNCIONARIO"));
            ins_funcionarioBean.setNombre(rs.getString("NOMBRE"));
            ins_funcionarioBean.setApellido1(rs.getString("APELLIDO1"));
            ins_funcionarioBean.setApellido2(rs.getString("APELLIDO2"));
            ins_funcionarioBean.setEmail(rs.getString("EMAIL"));
            ins_funcionarioBean.setEstado(rs.getInt("ID_ESTADO"));
            //ins_funcionarioBean.getString(rs.getInt("ESTADO"));
            ins_funcionarioBean.setContrasena(rs.getString("CONTRASENA"));
            ins_funcionarioBean.setRol(rs.getInt("ID_ROL"));
            //ins_funcionarioBean.setRol(rs.getString("ROL"));
            ins_funcionarioBean.setIdDependencia(rs.getInt("ID_DEPENDENCIA"));
            //ins_funcionarioBean.setRol(rs.getString("DEPENDENCIA"));
            */

            list_ins_funcionarios.add(ins_funcionarioBean);
        }
        rs.close();
        stmt.close();
            
        return list_ins_funcionarios;
    }
  
}
