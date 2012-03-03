/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
//import cr.ac.una.reg.info.bl.IUsPorRolBean;
//import javax.jws.WebMethod;
//import javax.jws.WebService;

/**
 *
 * @author Luis Granados
 */
public class PopupBean
{
    /* ATRIBUTOS PARA VISIBILIDAD DEL POPPOP*/
    private boolean visible = false;
    private String id_IU = "";
    private String texto = "";
    /* ATRIBUTOS ESTATICOS USADOS EL ESTILO DEL POPUP */
    private static String estiloForm = "width: 45%;";
    private static String estiloPanelPopup = "z-index: 1000; top: 30%; left: 10%; position: absolute; width: 300px; height: 150px;";
    private static String estiloPanelGrid = "text-align: center;";
    private static String estiloOutputText ="color: #FFFFFF;";
    private static String estiloBotonCerrar = "formatoazul";
    private static String urlImagenCerrar = "./imagenes/close.gif";
    private static String margenIzqBtnAyuda = "margin-left:24px";
    private static String rutaPagina = "font-weight:bold;margin-left:25px;text-align:left;color:blue;";

    /* ESTA INSTANCIA CONTIENE LOS IDS DE LAS IUS QUE SE UTILIZAN
       EN CADA POPUP PARA LOS MSJ DE AYUDA Y ASI COMO LAS ID_UIs DE CONSULTA A LA BD.
     */
    IUsPorRolBean ins_IUsPorRolBean = new IUsPorRolBean();


    /* PROPIEDADES */
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public void closePopup() { visible = false; }
    public void openPopup() { visible = true; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public String getId_IU() { return id_IU; }
    public void setId_IU(String id_IU) { this.id_IU = id_IU; }

    /* PROPIEDADES: ESTILOS PARA EL PANEL POPUP */
    public String getEstiloForm() { return estiloForm; }
    public String getEstiloPanelPopup() { return estiloPanelPopup; }
    public String getEstiloPanelGrid() { return estiloPanelGrid; }
    public String getEstiloOutputText() { return estiloOutputText; }
    public String getEstiloBotonCerrar() { return estiloBotonCerrar; }
    public String getUrlImagenCerrar() { return urlImagenCerrar; }

    /* PROPIEDAD PARA EL BOTON AYUDA QUE ABRE EL POPUP DE CADA FORM */
    public String getMargenIzqBtnAyuda() {return margenIzqBtnAyuda;}

    /* PROPIEDAD PARA LA RUTA DE LA PAGINA */
    public String getRutaPagina() {
        return rutaPagina;
    }

    /* METODOS QUE OBTIENEN EL TEXTO DE AYUDA CORRESPONDIENTE A CADA POPUP DE CADA IU */
    //@WebMethod(operationName="openPopup_InformacionSigepex")
    public String openPopup_InformacionSigepex() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_inicioSigepex());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_AprobarPrestamo")
    public String openPopup_AprobarPrestamo() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_aprobarPrestamo());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_AprobarRemision")
    public String openPopup_AprobarRemision() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_aprobarRemision());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_ConsultarPrestamo")
    public String openPopup_ConsultarPrestamo() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_consultarPrestamo());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_ConsultarRemision")
    public String openPopup_ConsultarRemision() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_consultarRemision());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_LlenarRemision")
    public String openPopup_LlenarRemision() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_llenarRemision());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_Parametros")
    public String openPopup_Parametros() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_parametros());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_ReportePrestamo")
    public String openPopup_ReportePrestamo() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_reportePrestamo());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_ReportePrestamo")
    public String openPopup_ReporteRemision() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_reporteRemision());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_SolicitarPrestamo")
    public String openPopup_SolicitarPrestamo() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_solicitarPrestamo());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_MantenimientoUsuarios")
    public String openPopup_MantenimientoUsuarios() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_adminUsuarios());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_AdminRoles")
    public String openPopup_AdminRoles() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_adminRoles());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_AdminIUsPorRol")
    public String openPopup_AdminIUsPorRol() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_adminIUsPorRol());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_ReportePrestamo")
    public String openPopup_AdminSerieDocumental() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_adminSerieDocumental());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }
    //@WebMethod(operationName="openPopup_ReportePrestamo")
    public String openPopup_AdminMensajesAyuda() throws Exception {
        this.setId_IU(this.ins_IUsPorRolBean.getVst_adminMensajesAyuda());
        this.consultarAyuda();
        this.setVisible(true);
        return "";
    }

    /*
    * <funcionalidad>
    * SE ENCARGA DE INVOCAR AL SERVICIO QUE OBTIENE EL TEXTO DE AYUDA DE BD CORRESPONDIENTE A CADA IU.
    * </funcionalidad>
    * <parametro="">No tiene parametros</parametro>
    * <retorna>No retorna nada. Se tuvo que agregar un return tipo String para que el UI pudiera ver la funcion.</retorna>
    */
    public String consultarAyuda() throws Exception
    {
        this.setTexto("");
        Servicio.ayudaIUConsultar(this);
        if(this.getTexto().equals(""))
            this.setTexto("La ayuda para esta pantalla aun no esta disponible.");

        return "";
    }
}