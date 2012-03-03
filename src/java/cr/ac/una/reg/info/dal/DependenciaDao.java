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
        ResultSet rs = null;
        ArrayList list_ins_dependencias = new ArrayList();

        PreparedStatement stmt = null;
        Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
        stmt = cx.prepareStatement("call ST_DEPENDENCIA_LISTAR_TODAS()");
        rs = stmt.executeQuery();

        while(rs.next()){
            ins_dependenciaBean = new DependenciaBean();
            ins_dependenciaBean.setIdDependencia(rs.getInt("ID_DEPENDENCIA"));
            ins_dependenciaBean.setNombreDependencia(rs.getString("NOMBRE_DEPENDENCIA"));
            ins_dependenciaBean.setDescripcionDependencia(rs.getString("DESCRIPCION_DEPENDENCIA"));

            list_ins_dependencias.add(ins_dependenciaBean);
        }
        rs.close();
        stmt.close();

        ins_dependenciaBean = new DependenciaBean();
        ins_dependenciaBean.setList_ins_dependencia(list_ins_dependencias);
    }
}
