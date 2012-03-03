/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.LineaPrestamoBean;
import cr.ac.una.reg.info.bl.EstudianteBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Vector;

import java.util.ArrayList;
/**
 *
 * @author Melvin
 */
public class LineaPrestamoDao {
    private String vst_mensaje;
    private boolean prestado;

    public void devolverExpediente(){

    }

    public void aprobarPrestamo(){

    }

    public void buscarPrestamo(LineaPrestamoBean pPrest) throws Exception{
        try
        {
            ResultSet rs=null;
            PreparedStatement stmt=null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_PRESTAMO_BUSCAR(?)");
            stmt.setString(1,pPrest.getIDEstudiante());
            rs = stmt.executeQuery();
             rs.next();

                if(rs.isFirst())//<== LOCALIZADO
                {
                pPrest.setEstado(rs.getString("ESTADO"));
                pPrest.setFechaDevolucion(rs.getDate("FECHA_DEVOLUCION").toString());
                pPrest.setFoliosDevueltos(rs.getInt("FOLIOS_DEVUELTOS"));
                pPrest.setFoliosPrestados(rs.getInt("FOLIOS_PRESTADOS"));
                pPrest.setIDEstudiante(rs.getString("ID_ESTUDIANTE"));
                pPrest.setNumeroBoleta(rs.getInt("ID_BOLETA_PRESTAMO"));
                }
                else
                {
                pPrest.setEstado(" ");
                pPrest.setFechaDevolucion(" ");
                pPrest.setFoliosDevueltos(0);
                pPrest.setFoliosPrestados(0);
                pPrest.setIDEstudiante(" ");
                pPrest.setNumeroBoleta(0);
                }
                rs.close();
                cx.close();
            }
            catch(Exception e){
                vst_mensaje = "El expediente no se encuentra prestado";
//                isn_estudianteBean.setMsg(vst_mensaje);
            }
    }

    public void asignarEstado(){
        
    }
}
