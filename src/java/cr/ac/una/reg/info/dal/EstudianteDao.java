/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.EstudianteBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class EstudianteDao {
    private String vst_mensaje;
    public void buscarEstudiante(String id, EstudianteBean isn_estudianteBean) throws Exception
    {
        try
        {
            ResultSet rs=null;
            PreparedStatement stmt=null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_ESTUDIANTE_BUSCAR(?)");
            stmt.setString(1,id);
            /*stmt.setString(1,isn_estudianteBean.getIdentificacion());
            stmt.setString(2, isn_estudianteBean.getNombre());
            stmt.setString(3, isn_estudianteBean.getApellido1());
            stmt.setString(4, isn_estudianteBean.getApellido2());*/
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())
            {
                isn_estudianteBean.setIdentificacion(rs.getString("identificacion"));
                isn_estudianteBean.setNombre(rs.getString("nombre"));
//                isn_estudianteBean.setApellido1(rs.getString("apellido1"));
//                isn_estudianteBean.setApellido2(rs.getString("apellido2"));
//                isn_estudianteBean.setCarnet(rs.getString("carnet"));
//                isn_estudianteBean.setIdTipo(rs.getInt("idTipo"));
                isn_estudianteBean.setTipo(rs.getString("tipo"));
//                isn_estudianteBean.setIdSede(rs.getInt("idSede"));
                isn_estudianteBean.setSede(rs.getString("sede"));
//                isn_estudianteBean.setIdEstado(rs.getInt("idEstado"));
//                isn_estudianteBean.setEstado(rs.getString("estado"));
//                isn_estudianteBean.setIdFuenteDB(rs.getInt("idFuenteDB"));
//                isn_estudianteBean.setFuenteDB(rs.getString("fuenteDB"));
            }
            else
            {
                isn_estudianteBean.setIdentificacion("");
                isn_estudianteBean.setNombre("");
//                isn_estudianteBean.setApellido1("");
//                isn_estudianteBean.setApellido2("");
//                isn_estudianteBean.setCarnet("");
//                isn_estudianteBean.setIdTipo(0);
                isn_estudianteBean.setTipo("");
//                isn_estudianteBean.setIdSede(0);
                isn_estudianteBean.setSede("");
//                isn_estudianteBean.setIdEstado(0);
//                isn_estudianteBean.setEstado("");
//                isn_estudianteBean.setIdFuenteDB(0);
//                isn_estudianteBean.setFuenteDB("");
                
                vst_mensaje = "Estudiante no encontrado.";
//                isn_estudianteBean.setMsg(vst_mensaje);
            }
            rs.close();
            }
            catch(Exception e){
                vst_mensaje = "Estudiante no encontrado.";
//                isn_estudianteBean.setMsg(vst_mensaje);
            }
    }

    public boolean verificarExistenciaEstudiante(EstudianteBean isn_estudianteBean) throws Exception
    {
        try
        {
            ResultSet rs=null;
            PreparedStatement stmt=null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_ESTUDIANTE_VERIFICAR_EXISTENCIA(?,?,?,?)");
            stmt.setString(1,isn_estudianteBean.getIdentificacion());
            stmt.setString(2, isn_estudianteBean.getNombre());
//            stmt.setString(3, isn_estudianteBean.getApellido1());
//            stmt.setString(4, isn_estudianteBean.getApellido2());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())
                return true;
            else
                return false;
        }
        catch(Exception e){
            vst_mensaje = "Estudiante no encontrado.";
//            isn_estudianteBean.setMsg(vst_mensaje);
            return true;
        }
    }

    public void ListarEstudiantesCoincidencias(EstudianteBean isn_estudianteBean) throws Exception
    {
        /*
        try
        {
            ResultSet rs=null;
            List EntityCollectionEstudiantes = new ArrayList();
            EstudianteBean estudianteTmp;
            PreparedStatement  stmt=null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();

            // Lista las coincidencias: por identificacion o nombre completo
            stmt = cx.prepareStatement("call ST_ESTUDIANTE_LISTAR(?,?,?,?)");
            stmt.setString(1,isn_estudianteBean.getIdentificacion());
            stmt.setString(2, isn_estudianteBean.getNombre());
            stmt.setString(3, isn_estudianteBean.getApellido1());
            stmt.setString(4, isn_estudianteBean.getApellido2());

            rs = stmt.executeQuery();

            while(rs.next()){
                estudianteTmp = new EstudianteBean();
                estudianteTmp.setIdentificacion(rs.getString("identificacion"));
                estudianteTmp.setNombre(rs.getString("nombre"));
                estudianteTmp.setApellido1(rs.getString("apellido1"));
                estudianteTmp.setApellido2(rs.getString("apellido2"));
                estudianteTmp.setCarnet(rs.getString("carnet"));
                estudianteTmp.setIdTipo(rs.getInt("idTipo"));
                estudianteTmp.setTipo(rs.getString("tipo"));
                estudianteTmp.setIdSede(rs.getInt("idSede"));
                estudianteTmp.setSede(rs.getString("sede"));
                estudianteTmp.setIdEstado(rs.getInt("idEstado"));
                estudianteTmp.setEstado(rs.getString("estado"));
                estudianteTmp.setIdFuenteDB(rs.getInt("idFuenteDB"));
                estudianteTmp.setFuenteDB(rs.getString("fuenteDB"));
                EntityCollectionEstudiantes.add(estudianteTmp);
            }
            rs.close();
            isn_estudianteBean.setList_ins_estudiantes(EntityCollectionEstudiantes);
        }
        catch(Exception e){
            vst_mensaje = "Error al tratar de listar los estudiantes.";
            isn_estudianteBean.setMsg(vst_mensaje);
        }
         * 
         * EstudianteBean(String pIdentificacion, String pNombre, String pApellido1, String pApellido2,String pCarnet,
            Integer pIDTipo, String pTipo, Integer pIDSede, String pSede, Integer pIDEstado, String pEstado,
            Integer pIDFuenteDB, String pFuenteDB, String pMsg)
        */

        // PARA EL PROTOTIPO
        List EntityCollectionEstudiantes = new ArrayList();
        List list_estudiantesBean_Tmp = new ArrayList();
       EstudianteBean ins_estudianteBeanTmp;//= new EstudianteBean();
        
        ins_estudianteBeanTmp = new EstudianteBean("108110089","Luis Granados Lobo","Regular","Omar Dengo");
        EntityCollectionEstudiantes.add(ins_estudianteBeanTmp);
        ins_estudianteBeanTmp = new EstudianteBean("206420105","Melvin Sibaja Ramirez","Regular","Omar Dengo");
        EntityCollectionEstudiantes.add(ins_estudianteBeanTmp);
        ins_estudianteBeanTmp = new EstudianteBean("114060154","Ariel Rojas Brenes","Regular","Omar Dengo");
        EntityCollectionEstudiantes.add(ins_estudianteBeanTmp);
        ins_estudianteBeanTmp = new EstudianteBean("401890896","Melisa Loaiza Fonseca","Regular","Omar Dengo");
        EntityCollectionEstudiantes.add(ins_estudianteBeanTmp);

        if(!isn_estudianteBean.getIdentificacion().equals(""))
        {
            for(int i = 0;i < EntityCollectionEstudiantes.size();i++)
            {
                ins_estudianteBeanTmp = (EstudianteBean)EntityCollectionEstudiantes.get(i);
                if(ins_estudianteBeanTmp.getIdentificacion().trim().equals(isn_estudianteBean.getIdentificacion().trim()))
                    list_estudiantesBean_Tmp.add(ins_estudianteBeanTmp);
            }
            isn_estudianteBean.setList_ins_estudiantes(list_estudiantesBean_Tmp);
        }
        else
            isn_estudianteBean.setList_ins_estudiantes(EntityCollectionEstudiantes);
    }

}
