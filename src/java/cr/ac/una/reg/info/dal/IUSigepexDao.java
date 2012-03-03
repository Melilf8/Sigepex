/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.IUSigepexBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class IUSigepexDao {
       
    public void listarIUsSigepex(IUSigepexBean ins_uiSigepexBean) throws Exception
     {
        try {
            ins_uiSigepexBean.setMsg("");

            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_IUS_LISTAR_TODAS()");
            rs = stmt.executeQuery();

            ArrayList list_uiSigepexBean = new ArrayList();
            IUSigepexBean ins_uiSigepexBeanTmp;
            while(rs.next()){
                ins_uiSigepexBeanTmp = new IUSigepexBean();
                ins_uiSigepexBeanTmp.setIdIU(rs.getString("ID_IU"));
                ins_uiSigepexBeanTmp.setAliasIU(rs.getString("ALIAS_IU"));

                list_uiSigepexBean.add(ins_uiSigepexBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_uiSigepexBean.setList_ins_iuSigepexBean(list_uiSigepexBean);
        }
        catch(Exception e){
            ins_uiSigepexBean.setMsg("Error al intentar listar las IUs del sistema.. "+e.getMessage());
        }
    }
}
