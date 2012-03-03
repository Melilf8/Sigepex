/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.reg.info.bl;

import java.util.ArrayList;
import javax.faces.model.SelectItem;

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
    private ArrayList<SelectItem> dependencias = null;
    private ArrayList<ReporteExpedienteBean> tabledata;

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
    }


    public ReporteExpedienteBean(int id, String fechaInicio, String dependencia, String funcionario) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.dependencia = dependencia;
        this.funcionario = funcionario;
    }

    public ReporteExpedienteBean() {
        getDependencias();
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
        for(int i=0;i<20;i++)
        {
            this.tabledata.add( new ReporteExpedienteBean(i,
                    (this.fechaInicio.equals("")?"11/11/11":this.fechaInicio.toString()),
                    (this.dependencia.equals("")?"dependecia"+i:this.dependencia.toString()),
                    (this.fechaInicio.equals("")?"Funcionario"+i:this.funcionario.toString())));
        }

    }
}
