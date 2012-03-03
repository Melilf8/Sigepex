/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.backbeans;

//import com.sun.rave.web.ui.appbase.AbstractPageBean;

/**
 *
 * @author estudiante
 */

public class NotaGastosBackBean {
     
    private double dietas;
    private double transporte;
    private double totalGastos;

    /** Creates a new instance of NotaGastosBackBean */
    public NotaGastosBackBean() {
    }

    public double getDietas() {
     return dietas;
    }

    public void setDietas(double dietas) {
     this.dietas = dietas;
     calcularTotalGastos();
    }

    public double getTransporte() {
     return transporte;
    }

    public void setTransporte(double transporte) {
     this.transporte = transporte;
     calcularTotalGastos();
    }

    public double getTotalGastos() {
     return totalGastos;
    }

    private void calcularTotalGastos(){
     totalGastos = dietas + transporte;
    }
}
