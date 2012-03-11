/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.reg.info.bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author vindasloiza
 */
public class ReporteExpedienteBean {

    private int id;
    private String fechaInicio;
    private String fechaFinal;
    private String dependencia;
    private String funcionario;
    private String URLReporte;
    private ArrayList<SelectItem> dependencias = null;
    private ArrayList<ReporteExpedienteBean> tabledata;

    public String getURLReporte() {
        return URLReporte;
    }

    public void setURLReporte(String URLReporte) {
        this.URLReporte = URLReporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ReporteExpedienteBean> getTabledata() {
        return tabledata;
    }

    public void setTabledata(ArrayList<ReporteExpedienteBean> tabledata) {
        this.tabledata = tabledata;
    }

    public ArrayList<SelectItem> getDependencias() {
        //deberia ir llamado  a la base de datos
        dependencias = new ArrayList<SelectItem>();
        dependencias.add(new SelectItem("", "Seleccione Unidad..."));
        dependencias.add(new SelectItem("1", "Atencion Estudiantes"));
        dependencias.add(new SelectItem("2", "Expedientes"));
        dependencias.add(new SelectItem("3", "Soporte"));
        return dependencias;
    }

    public ReporteExpedienteBean(int id, String fechaInicio, String fechaFinal, String dependencia, String funcionario, ArrayList<ReporteExpedienteBean> tabledata) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.dependencia = dependencia;
        this.funcionario = funcionario;
        this.tabledata = tabledata;
        this.URLReporte = "/Sigepex/ReporteExpedientes?fi=" + this.fechaInicio + "&ff=" + this.fechaFinal + "&de=" + this.dependencia + "&fu" + this.funcionario;


    }

    public ReporteExpedienteBean(int id, String fechaInicio, String dependencia, String funcionario) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.dependencia = dependencia;
        this.funcionario = funcionario;
        this.URLReporte = "/Sigepex/ReporteExpedientes?fi=" + this.fechaInicio + "&ff=" + this.fechaFinal + "&de=" + this.dependencia + "&fu" + this.funcionario;
    }

    public ReporteExpedienteBean() {
        getDependencias();
        this.URLReporte = "/Sigepex/ReporteExpedientes?fi=" + this.fechaInicio + "&ff=" + this.fechaFinal + "&de=" + this.dependencia + "&fu" + this.funcionario;
    }

    public void setDependencias(ArrayList<SelectItem> dependencias) {
        this.dependencias = dependencias;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public void BuscarReporteExpediente() {
        this.tabledata = new ArrayList<ReporteExpedienteBean>();
        String a = this.dependencia;
        for (int i = 0; i < 20; i++) {
            this.tabledata.add(new ReporteExpedienteBean(i,
                    (this.fechaInicio.equals("") ? "11/11/11" : this.fechaInicio.toString()),
                    (this.dependencia.equals("") ? "dependecia" + i : this.dependencia.toString()),
                    (this.fechaInicio.equals("") ? "Funcionario" + i : this.funcionario.toString())));
        }

    }

   public byte[] getBytes(String valor,String fechaIni,String fechaFin,String dependen,String funcionario) throws JRException, SQLException {
        String bd = "Sigepex";
        String login = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost/" + bd;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, login, password);
            if (!con.isClosed()) {
                System.out.println("Successfully connected to " +
                        "MySQL server using TCP/IP...");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }


        HashMap jasperParameter = new HashMap();
        jasperParameter.put("FECHAINICIO",fechaIni );
        jasperParameter.put("FECHAFIN", fechaFin);
        jasperParameter.put("DEPENDENCIA", dependen);
        jasperParameter.put("FUNCIONARIO", funcionario);

        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(valor);
        } catch (Exception t) {
            String h = "";
        }

        JasperPrint print = null;
        try{
           print = JasperFillManager.fillReport(report, jasperParameter, con);
        }catch(Exception eeee) {
            String ee = "";
        }

        

        //Exporta el informe a PDF
        String destFileNamePdf = "C:\\reporte1.pdf";
        //Creación del PDF
        JasperExportManager.exportReportToPdfFile(print, destFileNamePdf);

        byte[] pdfByteArray = JasperExportManager.exportReportToPdf(print);

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) 
        {


        }

        return pdfByteArray;
    }
}

