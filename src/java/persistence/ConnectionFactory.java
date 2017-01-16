package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Objective: To make exercises from Connection Factory page 9 fj21
 * @author marcella
 */
public class ConnectionFactory 
{
    private String url = "jdbc:mysql://localhost/fj21";
    private String user = "root";
    private String password = "";
    
    public Connection getConnection()
    {
        try {
            //in a web project, the connection factory only works with this line below
            //http://www.guj.com.br/t/java-sql-sqlexception-no-suitable-driver-found-for-jdbc-mysql-localhost-fj21-resolvido/191736/4
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());//here is the magic
            
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
