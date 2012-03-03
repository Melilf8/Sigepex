/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.BoletaPrestamoBean;
import cr.ac.una.reg.info.bl.LineaPrestamoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Vector;

import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Melvin
 */
public class BoletaPrestamoDao {

    private String vst_mensaje;
    private java.util.Date fecha = new java.util.Date();
    private java.sql.Date fechaReal = new java.sql.Date(fecha.getTime());

    public void numBoleta(BoletaPrestamoBean boleta) throws Exception{
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection cx;
         try{

             cx= DatabaseUtil.getConnectionFactory().getConnection();
             stmt = cx.prepareStatement("call ST_OBTIENE_NUM_BOLETA()");
             rs = stmt.executeQuery();
             rs.next();
             boleta.setIdBoleta(rs.getInt(1));
             stmt.close();
             cx.close();

         }
         catch(Exception ex){
            this.vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
            throw ex;
         }
    }
    public void guardarBoleta(BoletaPrestamoBean boleta) throws Exception{
         PreparedStatement stmt = null;
         Connection cx;
        try{

             this.fecha = new java.util.Date(this.fechaReal.getTime());
             cx= DatabaseUtil.getConnectionFactory().getConnection();
             stmt = cx.prepareStatement("call ST_AGREGA_BOLETA(?,?,?)");
             stmt.setInt(1,boleta.getIdBoleta());
             stmt.setDate(1, fechaReal);
             stmt.setString(3,boleta.getFuncionario().getIdentificacion());
             stmt.execute();
             stmt.close();
             cx.close();
        }
        catch(Exception ex){
            this.vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
            throw ex;
        }
    }

    public void guardarLineas(ArrayList<LineaPrestamoBean> lista) throws Exception{
         PreparedStatement stmt = null;
         Connection cx;
         try{
             int index = lista.size();
             for(int i = 0; i < index;i++){
                cx= DatabaseUtil.getConnectionFactory().getConnection();
                stmt = cx.prepareStatement("call ST_LINEA_PRESTAMO_GUARDAR(?,?,?,?,?,?)");
                stmt.setString(1,lista.get(i).getIDEstudiante());
                stmt.setInt(2,lista.get(i).getNumeroBoleta());
                stmt.setString(5,lista.get(i).getFechaDevolucion());
                stmt.setString(6,"Pendiente");
                stmt.setInt(4,lista.get(i).getFoliosDevueltos());
                stmt.setInt(3,lista.get(i).getFoliosPrestados());
                stmt.execute();
             stmt.close();
             cx.close();
             }
         }
         catch(Exception ex){
            this.vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
            throw ex;
         }
    }

    public void cargarLineasBoleta(BoletaPrestamoBean boleta) throws Exception{
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Connection cx;
        ArrayList<LineaPrestamoBean> tmp = new ArrayList<LineaPrestamoBean>();
        try{
            cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_CARGAR_LINEAS(?)");
            stmt.setInt(1,boleta.getIdBoleta());
            rs = stmt.executeQuery();

            while(rs.next()){
                LineaPrestamoBean tmpL = new LineaPrestamoBean();
                tmpL.setEstado(rs.getString("estado"));
                tmpL.setFechaDevolucion(rs.getString("fecha_devolucion"));
                tmpL.setFoliosDevueltos(rs.getInt("folios_devueltos"));
                tmpL.setFoliosPrestados(rs.getInt("folios_prestados"));
                tmpL.setIDEstudiante(rs.getString("id_estudiante"));
                tmpL.setNumeroBoleta(rs.getInt("id_boleta"));
                tmp.add(tmpL);
            }
            stmt.close();
            cx.close();
            boleta.setLineaPrestamos(tmp);
        }
        catch(Exception ex){
            this.vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
            throw ex;
        }
    }

    public void buscarBoleta() throws Exception {
        try{
         PreparedStatement stmt = null;
         Connection cx;
        }
        catch(Exception ex){
            this.vst_mensaje = "Error al establecer la conexión con la base de datos SIGEPEX.\n"+ex;
            throw ex;
        }

    }
}
