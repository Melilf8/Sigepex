/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.bl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luis Granados
 */
public class ToolBean {
    // metodo para validar si el numero es correcto
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

    // metodo para validar si la palabra ccontiene unicamente letras
    public Boolean ValidarEsPalabra(String world)
    {
        Boolean isWorld = true;
        try{
            char c;
            for(int i = 0; i < world.length(); i++)
            {
                c = world.charAt(i);
                if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6'
                   || c == '7' || c == '8' || c == '9' || c == '.' || c == ',' || c == ';')
                {
                    isWorld = false;
                    break;
                }
            }

            return isWorld;
        }
        catch (Exception e) {
            return false;
        }
    }

    //metodo para validar si la fecha es correcta
    public boolean ValidarEsDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(fechax);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    //metodo para validar correo electronio
    public boolean ValidarEsEmail(String correo) {
        try{
            StringBuilder strRegex = new StringBuilder();
            strRegex.append("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}");
            strRegex.append("\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\");
            strRegex.append(".)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

            Pattern pat = null;
            Matcher mat = null;
            //pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
            pat = Pattern.compile(strRegex.toString());
            mat = pat.matcher(correo.trim());
            if (mat.find()) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
