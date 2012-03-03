/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.DependenciaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Luis Granados
 */
public class DependenciaDao {

    public void listarDependencias(DependenciaBean ins_dependenciaBean) throws Exception
     {
        try
        {
            ResultSet rs = null;
            ArrayList list_ins_dependencias = new ArrayList();
            DependenciaBean ins_dependenciaBeanTmp;

            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_DEPENDENCIA_LISTAR_TODAS()");
            rs = stmt.executeQuery();

            while(rs.next()){
                ins_dependenciaBeanTmp = new DependenciaBean(
                        rs.getInt("ID_DEPENDENCIA"),
                        rs.getString("NOMBRE_DEPENDENCIA"),
                        rs.getString("DESCRIPCION_DEPENDENCIA")
                        );
                list_ins_dependencias.add(ins_dependenciaBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_dependenciaBean.setList_ins_dependencia(list_ins_dependencias);
        }
        catch(Exception e){
            throw new Exception("Error al intentar listar las dependencias. "+ e.getMessage());
        }
    }
}
