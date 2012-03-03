/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;

/**
 *
 * @author Luis Granados
 */
public class ToolBean {
    public Boolean ValidarEsNumero(String number)
    {
        try{
            int numero = Integer.parseInt(number);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

}
