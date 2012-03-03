/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.reg.info.dal;
import java.sql.Connection;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
/**

/**
 *
 * @author Luis Granados
 */
public class DatabaseUtil {

    private static DataSource connectionFactory=null;

    static {
        MysqlConnectionPoolDataSource connectionFactoryTmp = new MysqlConnectionPoolDataSource();
        connectionFactoryTmp.setServerName("localhost");
        connectionFactoryTmp.setDatabaseName("sigepex");
        connectionFactoryTmp.setUser( "root");
        connectionFactoryTmp.setPassword("root");
        //connectionFactoryTmp.setPortNumber(3307);
        connectionFactoryTmp.setPortNumber(3306);
        connectionFactory=connectionFactoryTmp;
    }

    public static DataSource getConnectionFactory() {
        return connectionFactory;
    }
    public Connection getConnection() throws Exception {
        Connection resultado;
        try{
            resultado = DatabaseUtil.getConnectionFactory().getConnection();
            resultado.setAutoCommit(false); // begin transaction
            return resultado;
        }
        catch(Exception e){
        throw new Exception ("Error de conexion a la base de datos.");
        }
    }
}


