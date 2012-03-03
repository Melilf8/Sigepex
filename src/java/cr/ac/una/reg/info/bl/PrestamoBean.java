/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;

/**
 *
 * @author Melvin
 */
public class PrestamoBean {
/*Atributos de la Clase*/
    private boolean visible;
    private int folios_prestados;
    private int folios_devueltos;

/*Constructor sin parametros de la clase*/
    public PrestamoBean(){
        this.visible=false;
    }
     // Atributos del popup prestado

    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }

    public String closePopup() { visible = false; return "";}
    public void openPopup() { visible = true; }

    /*Buscar un expediente prestado*/

    public void buscarPrestamo(){
        this.openPopup();
     
    }



}
