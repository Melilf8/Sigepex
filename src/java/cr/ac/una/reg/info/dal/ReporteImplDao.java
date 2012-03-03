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
 * @author vindasloiza
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

	/*public  ReporteImplDao ( usuarioBean)throws ExceptionConnection{
    this.inicializarDataSource(usuarioBean.getUsuario(), usuarioBean.getPassword());
    }


    ////Este método permite obtener el reporte correspondiente pasando los parámetros correspondientes
	////al reporte.
	public byte[] obtenerBytesForReporte(Map parametros, String path) throws ExceptionConnection{

        byte[] bytes = null;
        try {
            if( this.openConnection() ) {
               bytes = JasperRunManager.runReportToPdf(path, parametros,   this.getConexion());
            } else {
                throw new ExceptionConnection("problemas al conectar", "", 3, true, 3, "EstudianteImplDao");
            }
        }catch(Exception ex){
            throw new ExceptionConnection(ex.getMessage(), "Error producido al abrir conexion", 3, true, 3, "EstudianteImplDao");

        }
       // catch (Throwable ex2)
      //{System.out.println("*************MENSAJE ERROR = " + ex2.getMessage());
     // System.out.println("*************CAUSA ERROR = " + ex2.getMessage());
     // }

        finally{
            this.closeConnection();
        }

		return bytes;
	}//


*/

