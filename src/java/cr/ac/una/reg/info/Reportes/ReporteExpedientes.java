/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.reg.info.Reportes;

import cr.ac.una.reg.info.bl.ReporteExpedienteBean;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vindasloiza
 */
public class ReporteExpedientes extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        try {
            //this.verificarUsuario();
            //captura error de lectura de archivo
            //fi=" + fechaini + "&ff=" + fechafin + "&de=&fu" + funcionario;
            String fechaIni = request.getParameter("fi").equals("")? "1900-01-01":request.getParameter("fi");
            String fechaFin = request.getParameter("ff").equals("")? "9999-01-01":request.getParameter("ff");
            String dependen = request.getParameter("de").equals("")? null:request.getParameter("de");
            String funciona = request.getParameter("fu").equals("")? null:request.getParameter("fu");
            response.setContentType("application/pdf");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            //get current date time with Calendar()
            Calendar cal = Calendar.getInstance();
            response.setHeader("Content-disposition", "inline; filename=Reporte_" + dateFormat.format(cal.getTime()).toString() + ".pdf");

            String rutaRelativaApp = getServletContext().getRealPath("/") + "Reportes\\prestamoExpedientes.jrxml";

            response.setHeader("Cache-Control", "max-age=30");
            ReporteExpedienteBean be = new ReporteExpedienteBean();
            byte[] bytes = be.getBytes(rutaRelativaApp,fechaIni,fechaFin,dependen,funciona);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            String a = "";
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
