/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.SerieDocumentalBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Luis Granados
 */
public class SerieDocumentalDao {

    public void buscarSerieDocumental(SerieDocumentalBean ins_serieDocumentalBean) throws Exception{
        try
        {
            ins_serieDocumentalBean.setMsg("");
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_BUSCAR(?)");
            stmt.setInt(1,ins_serieDocumentalBean.getIdSerieDocumental());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                ins_serieDocumentalBean.setIdSerieDocumental(rs.getInt("ID_SERIE_DOCUMENTAL"));
                //ins_serieDocumentalBean.setTipoDocumental(rs.getString("NOMBRE_SERIE_DOCUMENTAL"));
                ins_serieDocumentalBean.setTipoDocumental(rs.getString("TIPO_SERIE_DOCUMENTAL"));
                ins_serieDocumentalBean.setMsg("");
            }
            else
            {
                ins_serieDocumentalBean.setIdSerieDocumental(0);
                ins_serieDocumentalBean.setTipoDocumental("");
                ins_serieDocumentalBean.setMsg("No se encontró la serie documental dentro de la base de datos de SIGEPEX.");
            }
            rs.close();
        }
        catch(Exception e){
            ins_serieDocumentalBean.setMsg("Error al tratar de buscar la serie documental.. "+e);
        }
    }

    public void agregarSerieDocumental(SerieDocumentalBean ins_serieDocumentalBean) throws Exception{
       try
       {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx;
            try
            {
                cx= DatabaseUtil.getConnectionFactory().getConnection();
            }
            catch(Exception ex){
                ins_serieDocumentalBean.setMsg("Error al establecer la conexión con la base de datos SIGEPEX.");
                throw ex;
            }
            cx= DatabaseUtil.getConnectionFactory().getConnection();
            try{
                stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_BUSCAR(?)");
            }
            catch(Exception ex){
                ins_serieDocumentalBean.setMsg("Error al ejecutar procedimiento almacenado ST_SERIE_DOCUMENTAL_BUSCAR en BD SIGEPEX.");
                throw ex;
            }
            stmt.setInt(1,ins_serieDocumentalBean.getIdSerieDocumental());
            rs = stmt.executeQuery();
            rs.next();

            if(!rs.isFirst())//<== SI NO EXISTE SE AGREGA
            {
                stmt = null;
                try{
                    cx= DatabaseUtil.getConnectionFactory().getConnection();
                }
                catch(Exception ex){
                    ins_serieDocumentalBean.setMsg("Error al intentar establecer la conexión con la base de datos SIGEPEX.");
                }
                try{
                    stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_AGREGAR(?,?)");
                    stmt.setInt(1,ins_serieDocumentalBean.getIdSerieDocumental());
                    stmt.setString(2,ins_serieDocumentalBean.getTipoDocumental());
                    stmt.execute();

                    ins_serieDocumentalBean.setMsg("La serie documental se registró con éxito.");
                }
                catch(Exception e){
                    ins_serieDocumentalBean.setMsg("Error al ejecutar procedimiento almacenado ST_SERIE_DOCUMENTAL_AGREGAR en BD SIGEPEX.\n"+e);
                }
            }
            else
                ins_serieDocumentalBean.setMsg("La serie documental ya está registrada en el sistema.");

        }
        catch(Exception e){
            ins_serieDocumentalBean.setMsg("Error al tratar de agregar la serie documental.. "+e);
        }
    }

    public void modificarSerieDocumental(SerieDocumentalBean ins_serieDocumentalBean) throws Exception
    {
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_BUSCAR(?)");
            stmt.setInt(1,ins_serieDocumentalBean.getIdSerieDocumental());
            rs = stmt.executeQuery();
            rs.next();

            if(rs.isFirst())//<== LOCALIZADO
            {
                stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_MODIFICAR(?,?)");
                stmt.setInt(1,ins_serieDocumentalBean.getIdSerieDocumental());
                stmt.setString(2,ins_serieDocumentalBean.getTipoDocumental());
                stmt.execute();

                ins_serieDocumentalBean.setMsg("La serie documental se actualizó con éxito.");
            }
            else
                ins_serieDocumentalBean.setMsg("La serie documental no está registrada en el sistema.");

        }
        catch(Exception e){
            ins_serieDocumentalBean.setMsg("Error al tratar de actualizar la serie documental.. "+e.getMessage());
        }
    }

    public void eliminarSerieDocumental(SerieDocumentalBean ins_serieDocumentalBean) throws Exception
    {
        String vst_error = "";
        Integer vint_count = 0;
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();

            if(!ins_serieDocumentalBean.getList_ins_SerieDocBean().isEmpty())
            {
                SerieDocumentalBean ins_serieDocumentalBeanTmp;
                for(int i = 0; i < ins_serieDocumentalBean.getList_ins_SerieDocBean().size();i++)
                {
                    ins_serieDocumentalBeanTmp = (SerieDocumentalBean)ins_serieDocumentalBean.getList_ins_SerieDocBean().get(i);
                    try {
                        if(ins_serieDocumentalBeanTmp.getChecked())
                        {
                            stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_ELIMINAR(?)");
                            stmt.setInt(1,ins_serieDocumentalBeanTmp.getIdSerieDocumental());
                            stmt.execute();
                            vint_count++;
                        }
                    }
                    catch(Exception e){
                        vst_error += ins_serieDocumentalBeanTmp.getTipoDocumental()+"... "+e.getMessage();
                    }
                }
                if(vint_count == 0)
                    ins_serieDocumentalBean.setMsg("No hay series documentales seleccionadas para eliminar.");
                else if(vint_count == 1)
                    ins_serieDocumentalBean.setMsg("La serie documental se registraró con éxito.");
                else if(vint_count > 1)
                    ins_serieDocumentalBean.setMsg("Las series documentales se registrarón con éxito.");
            }
            else
                ins_serieDocumentalBean.setMsg("No hay series documentales seleccionadas para eliminar.");
        }
        catch(Exception e){
            ins_serieDocumentalBean.setMsg("Error al intentar eliminar series documentales.. "+vst_error+" ... "+e.getMessage());
        }
    }

    public void listarSeriesDocumentales(SerieDocumentalBean ins_serieDocumentalBean) throws Exception
     {
        try{
            //ins_serieDocumentalBean.setMsg("");

            ResultSet rs = null;
            ArrayList list_ins_seriesDoc = new ArrayList();
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_SERIE_DOCUMENTAL_LISTAR_TODAS()");
            rs = stmt.executeQuery();

            SerieDocumentalBean ins_serieDocumentalBeanTmp;
            while(rs.next()){
                ins_serieDocumentalBeanTmp = new SerieDocumentalBean(
                        rs.getInt("ID_SERIE_DOCUMENTAL"),
                        //rs.getString("NOMBRE_SERIE_DOCUMENTAL"),
                        rs.getString("TIPO_SERIE_DOCUMENTAL"),
                        "",
                        false
                 );

                list_ins_seriesDoc.add(ins_serieDocumentalBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_serieDocumentalBean.setList_ins_SerieDocBean(list_ins_seriesDoc);
        }
        catch(Exception e){
            ins_serieDocumentalBean.setMsg("Error al intentar listar las series documentales.... "+e.getMessage());
        }
    }

}
