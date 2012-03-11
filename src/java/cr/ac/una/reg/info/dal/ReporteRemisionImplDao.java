/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import java.util.Map;

/**
 *
 * @author Melissa
 */
public class ReporteRemisionImplDao extends Connection {
    public byte[] obtenerBytesForReporte(Map parametros, String path) {

        byte[] bytes = null;
        try {

            if( openConecction()) {


            }

           }catch(Exception ex){   }


          finally{
            this.closeConnection();
        }

		return bytes;
    }

}
