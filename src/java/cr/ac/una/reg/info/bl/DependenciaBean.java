/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;

import java.util.ArrayList;

/**
 *
 * @author Luis Granados
 */
public class DependenciaBean {
    Integer idDependencia;
    String nombreDependencia;
    String descripcionDependencia;

    ArrayList list_ins_dependencia;

    /* CONSTRUCTORES */
    public DependenciaBean() {
        this.idDependencia = 0;
        this.nombreDependencia = "";
        this.descripcionDependencia = "";
        this.list_ins_dependencia = new ArrayList();
    }

    public DependenciaBean(Integer pIdDependencia, String pNombreDependencia, String pDescripcionDependencia) {
        this.idDependencia = pIdDependencia;
        this.nombreDependencia = pNombreDependencia;
        this.descripcionDependencia = pDescripcionDependencia;
    }

    /* PROPIEDADES */
    public String getDescripcionDependencia() { return descripcionDependencia; }
    public void setDescripcionDependencia(String descripcionDependencia) {
        this.descripcionDependencia = descripcionDependencia; }
    public Integer getIdDependencia() { return idDependencia; }
    public void setIdDependencia(Integer idDependencia) { this.idDependencia = idDependencia; }

    public String getNombreDependencia() { return nombreDependencia; }
    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia; }
    
    public ArrayList getList_ins_dependencia() { return list_ins_dependencia; }
    public void setList_ins_dependencia(ArrayList list_ins_dependencia) { this.list_ins_dependencia = list_ins_dependencia;
    }

}
