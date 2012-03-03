/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import cr.ac.una.reg.info.dal.FuncionarioDao;
import cr.ac.una.reg.info.dal.EstudianteDao;
import cr.ac.una.reg.info.dal.PopupDao;
import cr.ac.una.reg.info.dal.MensajeAyudaDao;
import cr.ac.una.reg.info.dal.ParametroDao;
import cr.ac.una.reg.info.dal.RolDao;
import cr.ac.una.reg.info.dal.DependenciaDao;
import cr.ac.una.reg.info.dal.IUSigepexDao;
import cr.ac.una.reg.info.dal.IUsPorRolDao;
import cr.ac.una.reg.info.dal.SerieDocumentalDao;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Vector;
//import java.util.ArrayList;
//import java.util.List;
/**
 *
 * @author Luis Granados
 */
public class Servicio {

    String identificacion;
    EstudianteBean estudiante=new EstudianteBean();

    public String getIdentificacion(){
        return this.identificacion;
    }

    public void setIdentificacion(String id){
    this.identificacion=id;
    }
    public String validaEstudiante()throws Exception
    {
        try{
            estudianteConsultar(identificacion, estudiante);
            return "encontrado";
        }
             catch(Exception e){
             return "invalido";
        }
    }
    /*------------------------ LOGING ------------------------------------*/
    public static void loginConsultar(LoginBean ins_loginBean) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.buscarLogin(ins_loginBean);
    }
    /*------------------------ FUNCIONARIOS -----------------------------*/
    public static void funcionarioConsultar(FuncionarioBean funcionario) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.buscarFuncionario(funcionario);
    }
    public static void funcionarioConsultarPorNombre(FuncionarioBean funcionario) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.buscarFuncionarioPorNombre(funcionario);
    }
    public static ArrayList funcionarioListarTodos() throws Exception{
        ArrayList list_ins_funcionarios = new ArrayList();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        return list_ins_funcionarios = (ArrayList)funcionarioDao.listarFuncionarios();
    }
    public static void funcionarioModificar(FuncionarioBean funcionario) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.modificarFuncionario(funcionario);
    }
    public static void funcionarioActualizarEstado(FuncionarioBean funcionario) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.actualizarEstadoFuncionario(funcionario);
    }
    public static void funcionarioSuspender(FuncionarioBean funcionario) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.suspenderFuncionario(funcionario);
    }
    public static void funcionarioAgregar(FuncionarioBean funcionario) throws Exception{
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.agregarFuncionario(funcionario);
    }

     /*---------------------------- ESTUDIANTES ------------------------------*/
    /*public static void estudianteConsultar(EstudianteBean estudiante) throws Exception{
        EstudianteDao estudianteDao = new EstudianteDao();
        estudianteDao.buscarEstudiante(estudiante);
    }*/

    public static void estudianteConsultar(String id, EstudianteBean estudianteBean) throws Exception{
        EstudianteDao estudianteDao=new EstudianteDao();
        estudianteDao.buscarEstudiante(id, estudianteBean);
    }
    public static boolean estudianteVerificarExistencia(EstudianteBean estudiante) throws Exception{
        EstudianteDao estudianteDao = new EstudianteDao();
        boolean existe = estudianteDao.verificarExistenciaEstudiante(estudiante);
        return existe;
    }
    public static void estudianteListarCoincidencias(EstudianteBean estudiante) throws Exception{
        EstudianteDao estudianteDao = new EstudianteDao();
        estudianteDao.ListarEstudiantesCoincidencias(estudiante);
    }

    /*----------------------- MOSTRAR AYUDA_POPUP ----------------------------*/
    public static void ayudaIUConsultar(PopupBean ins_popupBean) throws Exception{
        PopupDao ayudaIUDao = new PopupDao();
        ayudaIUDao.buscarAyudaIU(ins_popupBean);
    }

    /*------------------------ ADMIN MENSAJE AYUDA ---------------------------*/
     public static void msgayudaIUConsultar(MensajeAyudaBean ins_mensajeAyudaBean) throws Exception{
        MensajeAyudaDao ins_mensajeAyudaDao = new MensajeAyudaDao();
        ins_mensajeAyudaDao.buscarMsgAyudaIU(ins_mensajeAyudaBean);
    }
     public static void msgayudaIUAgregar(MensajeAyudaBean ins_mensajeAyudaBean) throws Exception{
        MensajeAyudaDao ins_mensajeAyudaDao = new MensajeAyudaDao();
        ins_mensajeAyudaDao.agregarMsgAyudaIU(ins_mensajeAyudaBean);
    }
     public static void msgayudaIUModificar(MensajeAyudaBean ins_mensajeAyudaBean) throws Exception{
        MensajeAyudaDao ins_mensajeAyudaDao = new MensajeAyudaDao();
        ins_mensajeAyudaDao.modificarMsgAyudaIU(ins_mensajeAyudaBean);
    }
    /*---------------------------- PARAMETROS ------------------------------*/
    public static void parametroModificar(ParametroBean ins_parametro_Bean) throws Exception{
        ParametroDao ins_parametroDao = new ParametroDao();
        ins_parametroDao.modificarParametro(ins_parametro_Bean);
    }
    public static void parametroListarTodos(ParametroBean ins_parametro_Bean) throws Exception{
        ParametroDao ins_parametroDao = new ParametroDao();
        ins_parametroDao.listarParametros(ins_parametro_Bean);
    }

    /*------------------------------- ROLES ----------------------------------*/
    public static void rolConsultar(RolBean ins_rolBean) throws Exception{
        RolDao rolDao = new RolDao();
        rolDao.buscarRol(ins_rolBean);
    }
    public static void rolAgregar(RolBean ins_rolBean) throws Exception{
        RolDao rolDao = new RolDao();
        rolDao.agregarRol(ins_rolBean);
    }
    public static void rolModificar(RolBean ins_rolBean) throws Exception{
        RolDao rolDao = new RolDao();
        rolDao.modificarRol(ins_rolBean);
    }
    public static void rolEliminar(RolBean ins_rolBean) throws Exception{
        RolDao rolDao = new RolDao();
        rolDao.eliminarRol(ins_rolBean);
    }
    public static void rolListarTodos(RolBean ins_rolBean) throws Exception{
        RolDao rolDao = new RolDao();
        rolDao.listarRoles(ins_rolBean);
    }

    /*--------------------------- DEPENDENCIAS ------------------------------*/
    public static void dependenciaListarTodas(DependenciaBean ins_dependenciaBean) throws Exception{
        DependenciaDao dependenciaDao = new DependenciaDao();
        dependenciaDao.listarDependencias(ins_dependenciaBean);
    }

    /*--------------------------- IUS SIGEPEX ------------------------------*/
    public static void iuSigepexListarTodas(IUSigepexBean ins_iuSigepexBean) throws Exception{
        IUSigepexDao iuSigepexDao = new IUSigepexDao();
        iuSigepexDao.listarIUsSigepex(ins_iuSigepexBean);
    }

    /*--------------------------- IUS POR ROL ------------------------------*/
    public static void IUsporRolAgregar(IUsPorRolBean ins_iusPorRolBean) throws Exception{
        IUsPorRolDao iusPorRolDao = new IUsPorRolDao();
        iusPorRolDao.agregarIUsPorRol(ins_iusPorRolBean);
    }
    public static void IUsporRolListarTodas(IUsPorRolBean ins_iusPorRolBean) throws Exception{
        IUsPorRolDao iusPorRolDao = new IUsPorRolDao();
        iusPorRolDao.listarIUsPorRol_Todas(ins_iusPorRolBean);
    }
    public static void IUsporRolListarPorRol(IUsPorRolBean ins_iusPorRolBean) throws Exception{
        IUsPorRolDao iusPorRolDao = new IUsPorRolDao();
        iusPorRolDao.listarIUsPorRol(ins_iusPorRolBean);
    }
    public static void IUsporRolListar_MisIUs_PorRol(IUsPorRolBean ins_iusPorRolBean) throws Exception{
        IUsPorRolDao iusPorRolDao = new IUsPorRolDao();
        iusPorRolDao.listar_MisIUs_porRol(ins_iusPorRolBean);
    }

    /*------------------------- SERIE DOCUMENTAL ----------------------------*/
    public static void seriedocumentalAgregar(SerieDocumentalBean ins_serieDocBean) throws Exception{
        SerieDocumentalDao serieDocDao = new SerieDocumentalDao();
        serieDocDao.agregarSerieDocumental(ins_serieDocBean);
    }
    public static void seriedocumentalModificar(SerieDocumentalBean ins_serieDocBean) throws Exception{
        SerieDocumentalDao serieDocDao = new SerieDocumentalDao();
        serieDocDao.modificarSerieDocumental(ins_serieDocBean);
    }
    public static void serieDocumentalListarTodas(SerieDocumentalBean ins_serieDocBean) throws Exception{
        SerieDocumentalDao serieDocDao = new SerieDocumentalDao();
        serieDocDao.listarSeriesDocumentales(ins_serieDocBean);
    }
    public static void seriedocumentalEliminar(SerieDocumentalBean ins_serieDocBean) throws Exception{
        SerieDocumentalDao serieDocDao = new SerieDocumentalDao();
        serieDocDao.eliminarSerieDocumental(ins_serieDocBean);
    }
}
