/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import java.sql.*;
/**
 *
 * @author Melissa
 */
public class Connection {

   static String bd = "Sigepex";
   static String login = "root";
   static String password = "root";
   static String url = "jdbc:mysql://localhost/"+bd;

   public Connection conn = null;

   /** Constructor de DbConnection */
   public boolean openConecction(){
 
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = (Connection) DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos "+bd+" OK");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
      return false;
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void closeConnection(){
      conn = null;
   }

  




}
