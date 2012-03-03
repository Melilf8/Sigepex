/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.faces.event.ActionEvent;
/**
 *
 * @author Luis Granados
 */
public class EstudianteBean {

    /* ATRIBUTOS */
    private String identificacion;
    private String nombre;
//    private String apellido1;
//    private String apellido2;
//    private String carnet;
//    private Integer idTipo;
    private String tipo;
//    private Integer idSede;
    private String sede;
//    private Integer idEstado;
//    private String estado;
//    private Integer idFuenteDB;
//    private String fuenteDB;
//    private String msg;
    private List list_ins_estudiantes;
    private List list_ins_estudiantesBoleta;

    /* para IUs*/

    private Boolean checked;
    private Boolean verPopup;
    private Boolean cerrarPopup;
    private String msjPopup;
    private String tipoMsg;


    /*este atributo debe de ir en PrestamoBean
     la implemento aqui para efectos del prototipo*/
    private java.util.Date fecha;


     /* CONSTRUCTORES */
    public EstudianteBean()
    {
        try {
            this.identificacion = "";
            this.nombre = "";
//        this.apellido1 = "";
//        this.apellido2 = "";
//        this.carnet = "";
//        this.idTipo = 0;
            this.tipo = "";
//        this.idSede = 0;
            this.sede = "";
//        this.idEstado = 0;
//        this.estado = "";
//        this.idFuenteDB = 0;
//        this.fuenteDB = "";
//        this.msg = "";
            this.list_ins_estudiantes = new ArrayList();
            this.list_ins_estudiantesBoleta = new ArrayList();
            this.checked = false;
            this.verPopup = true;
            this.cerrarPopup = false;
            this.msjPopup = "";
            this.tipoMsg = "";
            /*este atributo debe de ir en PrestamoBean
            la implemento aqui para efectos del prototipo*/
            this.fecha = new Date();
            this.listarEstudiantesCoincidencias();
        } catch (Exception ex) {
            Logger.getLogger(EstudianteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public EstudianteBean(String pIdentificacion, String pNombre, String pApellido1, String pApellido2,String pCarnet,
//            Integer pIDTipo, String pTipo, Integer pIDSede, String pSede, Integer pIDEstado, String pEstado,
//            Integer pIDFuenteDB, String pFuenteDB, String pMsg) {
    public EstudianteBean(String pIdentificacion, String pNombre, String pTipo, String pSede) {
        this.identificacion = pIdentificacion;
        this.nombre = pNombre;
//        this.apellido1 = pApellido1;
//        this.apellido2 = pApellido2;
//        this.carnet = pCarnet;
//        this.idTipo = pIDTipo;
        this.tipo = pTipo;
//        this.idSede = pIDSede;
        this.sede = pSede;
//        this.idEstado = pIDEstado;
//        this.estado = pEstado;
//        this.idFuenteDB = pIDFuenteDB;
//        this.fuenteDB = pFuenteDB;
//        this.msg = pMsg;
    }

    /* PROPIEDADES */

     // ATRIBUTO: checked
    public Boolean getChecked() { return checked; }
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
     // ATRIBUTO: verpopup
    public Boolean getVerPopup() { return verPopup; }
    public void setVerPopup(Boolean verPopup) {
        this.verPopup = verPopup;
    }
    // ATRIBUTO; cerrarPopup
    public Boolean getCerrarPopup() { return cerrarPopup; }
    public void setCerrarPopup(Boolean cerrarPopup) {
        this.cerrarPopup = cerrarPopup;
    }
    // ATRIBUTO: identificacion
    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    // ATRIBUTO: nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//    // ATRIBUTO: apellido1
//    public String getApellido1() { return apellido1; }
//
//    public void setApellido1(String apellido1) {
//        this.apellido1 = apellido1;
//    }
//    // ATRIBUTO: apellido2
//    public String getApellido2() { return apellido2; }
//    public void setApellido2(String apellido2) {
//        this.apellido2 = apellido2;
//    }
//    //ATRIBUTO: carnet
//    public String getCarnet() { return carnet;}
//    public void setCarnet(String carnet) {
//        this.carnet = carnet;
//    }
//    // ATRIBUTO: idTipo
//    public Integer getIdTipo() { return idTipo; }
//    public void setIdTipo(Integer idTipo) {
//        this.idTipo = idTipo;
//    }
    // ATRIBUTO: tipo
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    // ATRIBUTO: idSede
//    public Integer getIdSede() { return idSede; }
//    public void setIdSede(Integer idSede) {
//        this.idSede = idSede;
//    }
    // ATRIBUTO: sede
    public String getSede() { return sede; }
    public void setSede(String sede) {
        this.sede = sede;
    }
     // ATRIBUTO: idEstado
//    public Integer getIdEstado() { return idEstado; }
//    public void setIdEstado(Integer idEstado) {
//        this.idEstado = idEstado;
//    }
//    // ATRIBUTO: estado
//    public String getEstado() { return estado; }
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//    //ATRIBUTO: idFuenteDB
//    public Integer getIdFuenteDB() { return idFuenteDB; }
//    public void setIdFuenteDB(Integer idFuenteDB) {
//        this.idFuenteDB = idFuenteDB;
//    }
//    // ATRIBUTO: fuenteDB
//    public String getFuenteDB() { return fuenteDB; }
//    public void setFuenteDB(String fuenteDB) {
//        this.fuenteDB = fuenteDB;
//    }
//    // ATRIBUTO: msg
//    public String getMsg() { return msg; }
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }

    /*----------------------------------------------------------------------*/

    //public String getMsjPopup() { return msjPopup; }
    //public void setMsjPopup(String msjPopup) { this.msjPopup = msjPopup; }

    //public String getTipoMsg() { return tipoMsg;}
    //public void setTipoMsg(String tipoMsg) { this.tipoMsg = tipoMsg; }


    /*
     este atributo debe de ir en PrestamoBean
     la implemento aqui para efectos del prototipo
     */
    public Date getFecha() {
        java.util.Date Dia = new java.util.Date();
        Dia.setDate(this.fecha.getDate());
        return Dia;
    }
    public void setFecha(Date Dia) { this.fecha.setDate(Dia.getDate()); }

    /*----------------------------------------------------------------------*/


    //ATRIBUTO: list_ins_estudiantes
    public List getList_ins_estudiantes() { return list_ins_estudiantes; }
    public void setList_ins_estudiantes(List pList_ins_estudiantes) { this.list_ins_estudiantes = pList_ins_estudiantes; }
    public void list_ins_estudiantesClear(){ this.list_ins_estudiantes.clear(); }
    public void list_ins_estudiantesAdd(EstudianteBean ins_estudianteBean) { list_ins_estudiantes.add(ins_estudianteBean); }
    public void list_ins_estudiantesRemove(EstudianteBean ins_estudianteBean)
    {
        int index = this.getIndexOfList(ins_estudianteBean);//this.list_ins_estudiantes.indexOf(ins_estudianteBean);
        if(index != -1) this.list_ins_estudiantes.remove(index);
    }
    public EstudianteBean getEstudianteIndex(int index)
    {
        EstudianteBean ins_estudianteBean = new EstudianteBean();
       if(index != -1)
           ins_estudianteBean = (EstudianteBean)this.list_ins_estudiantes.get(index);
      return ins_estudianteBean;
    }

    //ATRIBUTO: list_ins_estudiantesBoleta
    public List getList_ins_estudiantesBoleta() { return list_ins_estudiantesBoleta; }
    public void setList_ins_estudiantesBoleta(List list_ins_estudiantesBoleta) { this.list_ins_estudiantesBoleta = list_ins_estudiantesBoleta; }
    public void list_ins_estudiantesBoletaClear(){ this.list_ins_estudiantesBoleta.clear(); }
    public void list_ins_estudiantesBoletaAdd(EstudianteBean ins_estudianteBean) { list_ins_estudiantesBoleta.add(ins_estudianteBean); }
    public void list_ins_estudiantesBoletaRemove(EstudianteBean ins_estudianteBean)
    {
        int index = this.list_ins_estudiantesBoleta.indexOf(ins_estudianteBean);
        if(index != -1) this.list_ins_estudiantesBoleta.remove(index);
    }
    public EstudianteBean getEstudianteBoletaIndex(int index)
    {
        EstudianteBean ins_estudianteBean = new EstudianteBean();
       if(index != -1)
           ins_estudianteBean = (EstudianteBean)this.list_ins_estudiantesBoleta.get(index);
      return ins_estudianteBean;
    }

    private Integer getIndexOfList(EstudianteBean ins_estudianteBean)
    {
        Integer indexOf = -1;
        EstudianteBean ins_estudianteBeanTmp;
         for(int i = 0;i < this.list_ins_estudiantesBoleta.size();i++)
         {
            ins_estudianteBeanTmp = (EstudianteBean)this.list_ins_estudiantesBoleta.get(i);
            if(ins_estudianteBeanTmp.getIdentificacion().trim().equals(ins_estudianteBean.getIdentificacion().trim()))
                indexOf = i;
         }
        return indexOf;
    }
    public void list_ins_EstudianteBeanUpdate(EstudianteBean ins_estudianteBean)
    {
        Integer indexOf = this.getIndexOfList(ins_estudianteBean);
        if(indexOf != -1)
            this.list_ins_estudiantesBoleta.add(indexOf, ins_estudianteBean);
    }
    
    /*
    public String getMsjPopup() {
        return msjPopup;
    }

    public void setMsjPopup(String msjPopup) {
        this.msjPopup = msjPopup;
    }
    */
    private void cargar_this_ins_EstudianteBean(EstudianteBean ins_estudianteBean_Tmp)
    {
        this.setIdentificacion(ins_estudianteBean_Tmp.getIdentificacion());
        this.setNombre(ins_estudianteBean_Tmp.getNombre());
//        this.setApellido1(ins_estudianteBean_Tmp.getApellido1());
//        this.setApellido2(ins_estudianteBean_Tmp.getApellido2());
//        this.setCarnet(ins_estudianteBean_Tmp.getCarnet());
//        this.setIdFuenteDB(ins_estudianteBean_Tmp.getIdFuenteDB());
//        this.setFuenteDB(ins_estudianteBean_Tmp.getFuenteDB());
//        this.setIdEstado(ins_estudianteBean_Tmp.getIdEstado());
//        this.setEstado(ins_estudianteBean_Tmp.getEstado());
//        this.setIdSede(ins_estudianteBean_Tmp.getIdSede());
        this.setSede(ins_estudianteBean_Tmp.getSede());
//        this.setIdTipo(ins_estudianteBean_Tmp.getIdTipo());
        this.setTipo(ins_estudianteBean_Tmp.getTipo());
        this.setList_ins_estudiantes(ins_estudianteBean_Tmp.getList_ins_estudiantes());
//        this.setMsg(ins_estudianteBean_Tmp.getMsg());
    }

     // METODOS QUE DETERMINAN LA NAVEGACION

     public String MostrarPopup() {
         this.setVerPopup(true);
         this.setCerrarPopup(false);
         //this.ins_mensajeBean.setVerPopup(true);
         //this.ins_mensajeBean.setCerrarPopup(false);
         //System.out.println("entro en metodo Mostrar Popup: verPopup = " + this.getVerPopup());
         return "mostrarpopup";
     }
    public String CerrarPopup(){

        this.setVerPopup(false);
        this.setCerrarPopup(true);
        //this.ins_mensajeBean.setVerPopup(false);
        //this.ins_mensajeBean.setCerrarPopup(true);
        //System.out.println("entro en metodo CerrarPopup Popup");
        return "cerrarpopup";
    }

    // para la navegacion desde frm_listar_estudiantes2.jspx
//    public String verificarChecks(){
//
//        String vst_msg_return = "ningunamarcada";
//        Integer vin_cantidadChecks = 0;
//        Integer vin_pos_chked = -1;
//        EstudianteBean ins_estudianteBean_Tmp = new EstudianteBean();
//
//        for(int i = 0; i < this.getList_ins_estudiantes().size();i++)
//        {
//            ins_estudianteBean_Tmp = (EstudianteBean)this.getList_ins_estudiantes().get(i);
//
//            /* obtengo el numero de registros checados y la pos del primer check */
//            if(ins_estudianteBean_Tmp.getChecked())
//            {
//                if(vin_pos_chked == -1)
//                    vin_pos_chked = i;
//
//                vin_cantidadChecks++;
//            }
//        }
//        if(vin_cantidadChecks == 0)
//        {
//            this.setMsg("Debe seleccionar al menos un estudiante.");
//            //*********
//            //vst_msg_return = MostrarPopup();
//
//            vst_msg_return = "ningunamarcada";
//        }
//        else if(vin_cantidadChecks == 1)
//        {
//            /* obtendo la instancia del estudiante checado */
//            ins_estudianteBean_Tmp = (EstudianteBean)this.getList_ins_estudiantes().get(vin_pos_chked);
//
//            if(ins_estudianteBean_Tmp.getChecked())
//                cargar_this_ins_EstudianteBean(ins_estudianteBean_Tmp);
//            vst_msg_return = "unamarcada";
//        }
//        else if(vin_cantidadChecks > 1)
//        {
//            this.setMsg("Debe seleccionar a lo sumo un estudiante.");
//            //********
//            //vst_msg_return = MostrarPopup();
//
//            vst_msg_return = "masdeunamarcada";
//        }
//
//        return vst_msg_return;
//    }
//
//    // METODOS QUE IMPLICAN UN SERVICIO
//
    public String listarEstudiantesCoincidencias() throws Exception
    {
        try
        {
            Servicio.estudianteListarCoincidencias(this);
            return "coincidencias";
        }
        catch(Exception e){
//            this.setMsg("Error al listar las coincidencias de estudiantes.");
            return "coincidencias";
        }
    }

    public String agregarEstudianteEnBoleta()
    {
        String vst_agregado = "agregado";

        this.list_ins_estudiantesBoletaAdd(this);

        return vst_agregado;
    }

    public String eliminarEstudianteDeBoleta()
    {
        String vst_eliminado = "eliminado";

        this.list_ins_estudiantesBoletaRemove(this);

        return vst_eliminado;
    }
}
