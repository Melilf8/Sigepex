/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.Controllers;
import cr.ac.una.reg.info.dal.ReporteImplDao;



/**
 *
 * @author vindasloiza
 */
public class ReporteListenerController {

    String  URLReporte;
    String   sede;
    String   fecha;

    public String getURLReporte() {
        return URLReporte;
    }

    public void setURLReporte(String URLReporte) {
        this.URLReporte = URLReporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }


    public int ReportesInscritosControllers() {
    this.sede="TO";
    //this.fecha="2011-10-20";
    this.URLReporte ="/WebAppMAIRT/ReporteExpedientes";//+"&fecha="+this.fecha;
    // verificarUsuario();
   return 0;
 }
}