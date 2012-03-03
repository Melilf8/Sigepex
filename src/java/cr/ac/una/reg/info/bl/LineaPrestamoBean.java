/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author Melvin
 */
public class LineaPrestamoBean {
    private int numero_boleta;
    private int folios_prestados;
    private int folios_devueltos;
    private String fecha_devolucion;
    private String estado;
    private String idEstudiante;
    /*Deficion del constructor de la clase*/
    public LineaPrestamoBean(){
        try{
        this.folios_devueltos=0;
        this.folios_prestados=0;
        this.fecha_devolucion=" ";
        this.estado=" ";
        this.numero_boleta=0;
        this.idEstudiante=" ";
        //this.consultarPrestamo();
        }
        catch(Exception ex){
            Logger.getLogger(EstudianteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*Definicion de los metodos set y get de la clase*/
    /*********************************************************/
    public void setIDEstudiante(String id){
        this.idEstudiante=id;
    }
    public String getIDEstudiante(){
        return this.idEstudiante;
    }
    /*********************************************************/
    public void setNumeroBoleta(int numero){
        this.numero_boleta=numero;
    }
    public int getNumeroBoleta(){
        return this.numero_boleta;
    }
    /*********************************************************/
    public void setFoliosPrestados(int foliosPrestados){
        this.folios_prestados=foliosPrestados;
    }
    public int getFoliosPrestados(){
        return this.folios_prestados;
    }
    /*********************************************************/
    public void setFoliosDevueltos(int foliosDevueltos){
        this.folios_devueltos=foliosDevueltos;
    }
    public int getFoliosDevueltos(){
        return this.folios_devueltos;
    }
    /*********************************************************/
    public void setFechaDevolucion(String fecha){
        this.fecha_devolucion=fecha;
    }
    public String getFechaDevolucion(){
        return this.fecha_devolucion;
    }
    /*********************************************************/
    public void setEstado(String estado_exp){
        this.estado=estado_exp;
    }
    public String getEstado(){
        return this.estado;
    }
    /*********************************************************/
        public String consultarPrestamo()throws Exception{
        try{
        Servicio.prestamoConsultar(this);
        return "encontrado";
        }
        catch(Exception ex){
            return "no encontrado";
        }
    }
}
