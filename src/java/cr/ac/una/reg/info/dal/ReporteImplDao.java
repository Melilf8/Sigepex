/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;



import java.util.Map;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;


/**
 *
 * @author Melissa
 */
public class ReporteImplDao extends Connection  {


    ////Este método permite obtener el reporte correspondiente pasando los parámetros correspondientes
	////al reporte.
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



