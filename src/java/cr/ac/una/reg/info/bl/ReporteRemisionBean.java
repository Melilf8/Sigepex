/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.reg.info.bl;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class ReporteRemisionBean {

    private int ordenId;
    private String fechaInicio;
    private String fechaFinal;
    private String dependencia;
    private String funcionario;
    private String idEstudiante;
    private String nombre;
    private String Documental;
    private String folios;
    private ArrayList<ReporteRemisionBean> tabledata;

    public ArrayList<ReporteRemisionBean> getTabledata() {
        return tabledata;
    }

    public void setTabledata(ArrayList<ReporteRemisionBean> tabledata) {
        this.tabledata = tabledata;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getFolios() {
        return folios;
    }

    public void setFolios(String folios) {
        this.folios = folios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(int ordenId) {
        this.ordenId = ordenId;
    }

    public String getDocumental() {
        return Documental;
    }

    public void setDocumental(String Documental) {
        this.Documental = Documental;
    }

    public ReporteRemisionBean(int ordenId, String fechaInicio, String fechaFinal, String dependencia, String funcionario, String idEstudiante, String nombre, String tDocumental, String folios, ArrayList<ReporteRemisionBean> tabledata) {
        this.ordenId = ordenId;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.dependencia = dependencia;
        this.funcionario = funcionario;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.Documental = tDocumental;
        this.folios = folios;
        this.tabledata = tabledata;
    }

    public ReporteRemisionBean() {
    }

    public ReporteRemisionBean(int ordenId, String dependencia, String funcionario,
            String idEstudiante, String nombre, String tDocumental, String folios) {
        this.ordenId = ordenId;
        this.dependencia = dependencia;
        this.funcionario = funcionario;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.Documental = tDocumental;
        this.folios = folios;
    }

    public void Buscar() {
        this.tabledata = new ArrayList<ReporteRemisionBean>();

        for (int i = 0; i < 20; i++) {
            this.tabledata.add(new ReporteRemisionBean(i,
                    (this.dependencia.equals("") ? "dependecia" + i : this.dependencia.toString()),
                    (this.fechaInicio.equals("") ? "Funcionario" + i : this.funcionario.toString()),
                    (this.idEstudiante.equals("") ? "IdEstudiante" + i : this.idEstudiante.toString()),
                    "Nombre" + i,
                    "Documental" + i,
                    "folio" + i));
        }

    }

    public byte[] getBytes(String valor, String fechaIni, String fechaFin, String dependen, String funcionario, String IdEstudia) throws JRException, SQLException {
        String bd = "Sigepex";
        String login = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost/" + bd;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection(url, login, password);
            if (!con.isClosed()) {
                System.out.println("Successfully connected to " +
                        "MySQL server using TCP/IP...");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }


        HashMap jasperParameter = new HashMap();
        jasperParameter.put("FECHAINICIO", fechaIni);
        jasperParameter.put("FECHAFIN", fechaFin);
        jasperParameter.put("DEPENDENCIA", dependen);
        jasperParameter.put("FUNCIONARIO", funcionario);
        jasperParameter.put("IDESTUDIANTE", IdEstudia);
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(valor);
        } catch (Exception t) {
            String h = "";
        }

        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(report, jasperParameter, con);
        } catch (Exception eeee) {
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
        } catch (SQLException e) {
        }

        return pdfByteArray;
    }
}








