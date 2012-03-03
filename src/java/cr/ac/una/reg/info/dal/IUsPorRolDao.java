/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import cr.ac.una.reg.info.bl.IUsPorRolBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Luis Granados
 */
public class IUsPorRolDao {

    public void eliminarUIsPorRol(Integer pId_rol,String pMsg) throws Exception
    {
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_IUSXROL_ELIMINAR(?)");
            stmt.setInt(1,pId_rol);
            stmt.execute();
        }
        catch(Exception e){
            pMsg = "Error al tratar de eliminar las IUs por Rol.. "+e.getMessage();
        }
    }

    public void agregarIUsPorRol(IUsPorRolBean ins_uisPorRolBean) throws Exception
    {
        String vst_msg = "";
        String vst_error = "";
        Boolean vbo_ius_checked = false;
        try
        {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx= DatabaseUtil.getConnectionFactory().getConnection();

            if(!ins_uisPorRolBean.getList_ins_iusPorRolBean().isEmpty())
            {
                /* PRIMERO ELIMINO TODAS LAS IUS LIGADAS AL ROL DE USUARIO */
                this.eliminarUIsPorRol(ins_uisPorRolBean.getIdRol(), vst_msg);

                /* LUEGO AGREGO LAS NUEVAS IUS LIGADAS AL ROL */
                IUsPorRolBean ins_IUsPorRolBeanTmp;
                for(int i = 0; i < ins_uisPorRolBean.getList_ins_iusPorRolBean().size();i++)
                {
                    ins_IUsPorRolBeanTmp = (IUsPorRolBean)ins_uisPorRolBean.getList_ins_iusPorRolBean().get(i);
                    try {
                        /* AGREGO LAS IUS SELECCIONADAS */
                        if(ins_IUsPorRolBeanTmp.getChecked())
                        {
                            vbo_ius_checked = true;
                            stmt = cx.prepareStatement("call ST_UIXROL_AGREGAR(?,?)");
                            stmt.setInt(1,ins_uisPorRolBean.getIdRol());
                            stmt.setString(2,ins_IUsPorRolBeanTmp.getIdIU());
                            stmt.execute();
                        }
                    }
                    catch(Exception e){
                        vst_error = "Error al tratar de agregar la IU "+ins_IUsPorRolBeanTmp.getIdIU()+" al Rol "+Integer.toString(ins_IUsPorRolBeanTmp.getIdRol())+".. "+e.getMessage();
                        vst_msg += vst_error;
                    }
                }
                if(!vbo_ius_checked)
                    ins_uisPorRolBean.setMsg("No hay IUs seleccionadas para asignara al rol de usuario.");
                else if(vst_error.equals(""))
                    ins_uisPorRolBean.setMsg("Las IUs para el rol de usuario se registrarón con éxito.");
            }
            else
                ins_uisPorRolBean.setMsg("No hay IUs seleccionadas para asignara al rol de usuario.");
        }
        catch(Exception e){
            ins_uisPorRolBean.setMsg("Error al tratar de agregar IUs al rol de usuario.");
        }
    }

    public void listarIUsPorRol(IUsPorRolBean ins_uisPorRolBean) throws Exception
     {
        try {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_IUSXROL_LISTAR_POR_ROL(?)");
            stmt.setInt(1,ins_uisPorRolBean.getIdRol());
            rs = stmt.executeQuery();

            ArrayList list_uisPorRolBean = new ArrayList();
            IUsPorRolBean ins_uisPorRolBeanTmp;
            while(rs.next()){
                ins_uisPorRolBeanTmp = new IUsPorRolBean();
                ins_uisPorRolBeanTmp.setIdIU(rs.getString("ID_IU"));
                ins_uisPorRolBeanTmp.setIdRol(rs.getInt("ID_ROL"));
                ins_uisPorRolBeanTmp.setChecked(true);

                list_uisPorRolBean.add(ins_uisPorRolBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_uisPorRolBean.setList_ins_iusPorRolBeanChecked(list_uisPorRolBean);
        }
        catch(Exception e){
            ins_uisPorRolBean.setMsg("Error al intentar listar las IUs ligadas al Rol de usuario.. "+e.getMessage());
        }
    }

    public void listarIUsPorRol_Todas(IUsPorRolBean ins_uisPorRolBean) throws Exception
     {
        try {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_IUSXROL_LISTAR_TODAS()");
            rs = stmt.executeQuery();

            ArrayList list_uisPorRolBean = new ArrayList();
            IUsPorRolBean ins_uisPorRolBeanTmp;
            while(rs.next()){
                ins_uisPorRolBeanTmp = new IUsPorRolBean();
                ins_uisPorRolBeanTmp.setIdIU(rs.getString("ID_IU"));
                ins_uisPorRolBeanTmp.setIdRol(rs.getInt("ID_ROL"));

                list_uisPorRolBean.add(ins_uisPorRolBeanTmp);
            }
            rs.close();
            stmt.close();

            ins_uisPorRolBean.setList_ins_iusPorRolBean(list_uisPorRolBean);
        }
        catch(Exception e){
            ins_uisPorRolBean.setMsg("Error al intentar listar todas las IUs del siestema.. "+e.getMessage());
        }
    }

    public void listar_MisIUs_porRol(IUsPorRolBean ins_uisPorRolBean) throws Exception
     {
        try {
            ResultSet rs = null;
            PreparedStatement stmt = null;
            Connection cx = DatabaseUtil.getConnectionFactory().getConnection();
            stmt = cx.prepareStatement("call ST_IUSXROL_LISTAR_POR_ROL(?)");
            stmt.setInt(1,ins_uisPorRolBean.getIdRol());
            rs = stmt.executeQuery();

            ArrayList list_uisPorRolBean = new ArrayList();
            while(rs.next()){
                list_uisPorRolBean.add(rs.getString("ID_IU"));
            }
            rs.close();
            stmt.close();

            ins_uisPorRolBean.setList_ins_iusPorRolBean(list_uisPorRolBean);
        }
        catch(Exception e){
            ins_uisPorRolBean.setMsg("Error al intentar listar las IUs ligadas al Rol de usuario.. "+e.getMessage());
        }
    }
}
