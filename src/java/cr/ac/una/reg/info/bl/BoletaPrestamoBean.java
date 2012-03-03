/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.Map;
import java.util.Date;
import java.util.Calendar;


/**
 *
 * @author Melvin
 */
public class BoletaPrestamoBean {

    private int iDBoleta;
    private FuncionarioBean funcionario;
    private LineaPrestamoBean linea;
    private EstudianteBean estudiante;
    private ArrayList<LineaPrestamoBean> lineaPrestamos;
    private ArrayList<EstudianteBean> estudiantes;
    private boolean visible = false;
    private Calendar calendario = Calendar.getInstance();
    private java.util.Date fecha = new java.util.Date();
    private java.sql.Date fechaReal = new java.sql.Date(fecha.getTime());



    /*Declaracion del constructor de la clase*/
    public BoletaPrestamoBean(){
        this.iDBoleta=0;
        this.fecha = new java.util.Date(this.fechaReal.getTime());
         try{
        this.funcionario = new FuncionarioBean();
        this.estudiante = new EstudianteBean();
        this.linea = new LineaPrestamoBean();
        this.lineaPrestamos= new ArrayList<LineaPrestamoBean>();
        this.estudiantes = new ArrayList<EstudianteBean>();

            this.obtieneNumBoleta();
            this.consultarEstadoPrestamo();
            this.agregarEstudiante();

        }
        catch(Exception ex){
             Logger.getLogger(EstudianteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /***************************************************************/
    /*Para el popup*/
    /***************************************************************/
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public String closePopup() { visible = false; return "";}
    public void openPopup() { visible = true; }
    /***************************************************************/
    /*Declaracion de los set y get de la clase*/
    /***************************************************************/
    public void setEstudiante(EstudianteBean pEstudiante){
        this.estudiante = pEstudiante;
    }
    public EstudianteBean getEstudiante(){
        return this.estudiante;
    }
    /***************************************************************/
    public void setLinea(LineaPrestamoBean lineaP){
        this.linea=lineaP;
    }
    public LineaPrestamoBean getLinea(){
        return this.linea;
    }
    /***************************************************************/
    public void setFechaPrestamo(Date fechaP){
        this.fecha=fechaP;
    }
    public Date getFechaPrestamo(){
        return this.fecha;
    }
    /***************************************************************/
    public void setIdBoleta(int idB){
        this.iDBoleta=idB;
    }
    public int getIdBoleta(){
        return this.iDBoleta;
    }
    /***************************************************************/
    public void setFuncionario(FuncionarioBean funcionarioP){
        this.funcionario=funcionarioP;
    }
    public FuncionarioBean getFuncionario(){
        return this.funcionario;
    }
    /***************************************************************/
    public void setLineaPrestamos(ArrayList<LineaPrestamoBean> lineaP){
        this.lineaPrestamos=lineaP;
    }
    public ArrayList<LineaPrestamoBean> getLineaPrestamos(){
        return this.lineaPrestamos;
    }
    /***************************************************************/
    public void setEstudiantes(ArrayList<EstudianteBean> estudianteL){
        this.estudiantes=estudianteL;
    }
    public ArrayList<EstudianteBean> getEstudiantes(){
        return this.estudiantes;
    }
    /***************************************************************/
    /*Manejo de la lista de lineas de prestamo: Agregar, Eliminar*/
    /***************************************************************/
    public void agregarLineaPrestamo(LineaPrestamoBean lineaP){
    this.lineaPrestamos.add(lineaP);
    }

    public void eliminarLineaPrestamo(String idE){
        int index = lineaPrestamos.size();
        LineaPrestamoBean tmpLinea = new LineaPrestamoBean();
        if(index > 0){
            for(int i = 0; i < index; i++){
                tmpLinea = lineaPrestamos.get(i+1);
                if(tmpLinea.getIDEstudiante().equals(idE)){
                    lineaPrestamos.remove(i+1);
                    i = index;
                }
            }
        }
    }
    /***************************************************************/
    /*Manejo de la lista de estudiantes: Agregar, Eliminar, Buscar*/
    /***************************************************************/
        /*Buscar Registro en Lista*/
    /***************************************************************/
    public boolean buscarEnLista(EstudianteBean pEst){
        if(this.estudiantes.isEmpty()){
            return false;
        }
        else{
            for(int i=0; i<this.estudiantes.size();i++){
                if(pEst.getIdentificacion().equals(estudiantes.get(i).getIdentificacion()))
                    return true;
            }
            return false;
        }
    }
    /***************************************************************/
    public String agregarEstudiante() throws Exception{
         EstudianteBean tmp = new EstudianteBean();
       //  tmp.setApellidoD(this.estudiante.getApellidoD());
       //  tmp.setApellidoU(this.estudiante.getApellidoU());
         tmp.setIdentificacion(this.estudiante.getIdentificacion());
         tmp.setNombre(this.estudiante.getNombre());
         tmp.setSede(this.estudiante.getSede());
         tmp.setTipo(this.estudiante.getTipo());
        try{
              if(tmp.getIdentificacion().equals("")){
                  return "no existe";
              }
              else{
                  if(this.buscarEnLista(tmp)==false)
                    this.estudiantes.add(tmp);
                  return "Ya ha sido agregado";
              }
        }
        catch(Exception ex){
            return "fallo agregar";
        }
    }

    public void estudiantesClear(){
        this.estudiantes.clear();
    }

    public String consultarEstadoPrestamo()throws Exception{
        try{
             this.linea.setIDEstudiante(this.estudiante.getIdentificacion());
           //  Servicio.prestamoConsultar(linea);
             if(this.linea.getEstado().equals("Prestado"))
             {
                this.setVisible(true);
                this.estudiante.setIdentificacion(this.linea.getIDEstudiante());
           //      Servicio.estudianteConsultar(estudiante);
            }
            else{
          //      Servicio.estudianteConsultar(estudiante);
            }
            return "Prestado";
        }
        catch(Exception ex){

            return "Disponible";
        }
    }
    public String enviarSolicitudPrestamo() throws Exception{
        try{
          //  Servicio.boletaGuardar(this);
          //  Servicio.lineasEnviar(this);
            return "Solicitud Enviada";
        }
        catch(Exception ex){
            return "Ha ocurrido un error al procesar su solicitud";
        }
    }

    public String obtieneNumBoleta()throws Exception{
        try{
     //   Servicio.boletaNumero(this);
        this.iDBoleta=this.iDBoleta + 1;
            return "Número asignado";
        }
        catch(Exception ex){
            return "Ha ocurrido un error al procesar su solicitud";
        }
    }
}
