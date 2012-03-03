/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.PopupBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Luis Granados
 */
public class PopupDao {
    public void buscarAyudaIU(PopupBean ins_popupIUBean) throws Exception{
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_AYUDAIU_BUSCAR(?)");
            try{
                stmt.setString(1,ins_popupIUBean.getId_IU().trim());
                rs = stmt.executeQuery();
            }
                catch(Exception e){
                String err = e.getMessage();
            }
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                ins_popupIUBean.setId_IU(rs.getString("ID_IU"));
                ins_popupIUBean.setTexto(rs.getString("IU_TEXTO_AYUDA"));
            }
            else
            {
                ins_popupIUBean.setTexto("");
            }
            rs.close();
        }
        catch(Exception e){
        }
    }
}
