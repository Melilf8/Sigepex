/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.MensajeAyudaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Vector;
//import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class MensajeAyudaDao {

    public void buscarMsgAyudaIU(MensajeAyudaBean ins_msgAyudaBean) throws Exception{
        try
        {
            ins_msgAyudaBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_MENSAJE_AYUDA_IU_BUSCAR(?)");
            stmt.setString(1,ins_msgAyudaBean.getId_IU().trim());
                rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                ins_msgAyudaBean.setId_IU(rs.getString("ID_IU"));
                ins_msgAyudaBean.setMsgAyuda(rs.getString("IU_TEXTO_AYUDA"));
                ins_msgAyudaBean.setMsg("");
            }
            else
            {
                ins_msgAyudaBean.setId_IU("");
                ins_msgAyudaBean.setMsgAyuda("");
                ins_msgAyudaBean.setMsg("No se encontró el identificador de la pantalla.");
            }
            rs.close();
        }
        catch(Exception e){
            ins_msgAyudaBean.setMsg("No se encontró la el identificador de la pantalla. "+e.getMessage());
        }
    }

    public void agregarMsgAyudaIU(MensajeAyudaBean ins_msgAyudaBean) throws Exception{
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
                ins_msgAyudaBean.setMsg("Error al establecer la conexión con la base de datos SIGEPEX.");
                throw ex;
            }
            cx= DatabaseUtil.getConnectionFactory().getConnection();
            try{
                 stmt = cx.prepareStatement("call ST_MENSAJE_AYUDA_IU_BUSCAR(?)");

            }
            catch(Exception ex){
                ins_msgAyudaBean.setMsg("Error al ejecutar procedimiento almacenado ST_MENSAJE_AYUDA_BUSCAR en BD SIGEPEX.");
                throw ex;
            }
            stmt.setString(1,ins_msgAyudaBean.getId_IU());
            rs = stmt.executeQuery();
            rs.next();

            if(!rs.isFirst())//<== SI NO EXISTE SE AGREGA
            {
                stmt = null;
                try{
                    cx= DatabaseUtil.getConnectionFactory().getConnection();
                }
                catch(Exception ex){
                    ins_msgAyudaBean.setMsg("Error al intentar establecer la conexión con la base de datos SIGEPEX.");
                }
                try{
                    stmt = cx.prepareStatement("call ST_MENSAJE_AYUDA_IU_AGREGAR(?,?)");
                    stmt.setString(1,ins_msgAyudaBean.getId_IU().trim());
                    stmt.setString(2,ins_msgAyudaBean.getMsgAyuda().trim());
                    stmt.execute();

                    ins_msgAyudaBean.setMsg("El mensaje de ayuda para la pantalla se registró con éxito.");
                }
                catch(Exception e){
                    ins_msgAyudaBean.setMsg("Error al ejecutar procedimiento almacenado ST_MENSAJE_AYUDA_AGREGAR en BD SIGEPEX.\n"+e);
                }
            }
            else
                ins_msgAyudaBean.setMsg("La pantalla ya tiene registrado un mensaje de ayuda en el sistema. Para atualizar el mensaje presione el botón Actualizar.");
        }
        catch(Exception e){
            ins_msgAyudaBean.setMsg("Error: " + e.getMessage());
        }
    }

    public void modificarMsgAyudaIU(MensajeAyudaBean ins_msgAyudaBean) throws Exception
    {
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_MENSAJE_AYUDA_IU_BUSCAR(?)");
            stmt.setString(1,ins_msgAyudaBean.getId_IU().trim());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_MENSAJE_AYUDA_IU_MODIFICAR(?,?)");
                stmt.setString(1,ins_msgAyudaBean.getId_IU());
                stmt.setString(2,ins_msgAyudaBean.getMsgAyuda());
                stmt.execute();

                ins_msgAyudaBean.setMsg("Mensaje de ayuda Actualizado con éxito.");
            }
            else
                ins_msgAyudaBean.setMsg("La pantalla no tiene registrado un mensaje de ayuda en el sistema.");
        }
        catch(Exception e){
            ins_msgAyudaBean.setMsg("Error al tratar de actualizar el mensaje de ayuda para la pantalla.");
        }
    }
}
