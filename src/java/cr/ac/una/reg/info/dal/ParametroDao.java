/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.ParametroBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Luis Granados
 */
public class ParametroDao {
    public void modificarParametro(ParametroBean ins_parametroBean) throws Exception
    {
        try
        {
            ins_parametroBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_PARAMETRO_BUSCAR(?)");
            stmt.setInt(1,ins_parametroBean.getIdParametro());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_PARAMETRO_MODIFICAR(?,?)");
                stmt.setInt(1,ins_parametroBean.getIdParametro());
                stmt.setInt(2,ins_parametroBean.getValor());
                stmt.execute();

                ins_parametroBean.setMsg("Parámetro Actualizado con éxito.");
            }
            else
                ins_parametroBean.setMsg("No se encontró el parámetro.");
        }
        catch(Exception e){
            ins_parametroBean.setMsg("Error al tratar de actualizar el parámetro.");
        }
    }

    public void listarParametros(ParametroBean ins_parametroBean) throws Exception
     {
        try
        {
            ins_parametroBean.setMsg("");

            ResultSet rs = null;
            ArrayList list_ins_parametros = new ArrayList();

            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_PARAMETRO_LISTAR_TODOS()");
            rs = stmt.executeQuery();

            ParametroBean ins_parametroBeanTmp;
            while(rs.next()){
                ins_parametroBeanTmp = new ParametroBean(rs.getInt("ID_PARAMETRO"),rs.getString("NOMBRE_PARAMETRO"),rs.getInt("VALOR_PARAMETRO"),"");

                list_ins_parametros.add(ins_parametroBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_parametroBean.setList_ins_ParametroBean(list_ins_parametros);
        }
        catch(Exception e){
            ins_parametroBean.setMsg("Error al tratar de listar los parámetros.");
        }
    }
}
