/* File: SwingMVCDemo.java
 * Author: Stanley Pieda
 * Date: 2015
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * References:
 * Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import transferobjects.CredentialsDTO;

/**
 * a class for Database connection
 * @author steph
 */
public class DataSource {

    private Connection connection = null;
    private final String url;
    private final String username;
    private final String password;

    /**
     * a method to get user name and password
     * @param creds
     */
    public DataSource(CredentialsDTO creds) {
        this.url = "jdbc:mysql://localhost:3306/tutoring?useSSL=false&allowPublicKeyRetrieval=true";
        username=creds.getUsername();
        password=creds.getPassword();
    }

    /*
 * Only use one connection for this application, prevent memory leaks.
     */

    /**
     * a method to create a connection
     * @return a connection
     */

    public Connection createConnection() {
        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
