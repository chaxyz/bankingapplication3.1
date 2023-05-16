package bankingapplication3;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BankConnection {

    public static Connection connect() {
        String url = "jdbc:mysql://localhost:3306/mydb3";
        String username = "root";
        String password = "mysql@sit";
        Connection con = null;

        try {
            // load driver into project
            Class.forName("com.mysql.cj.jdbc.Driver");

            // build object connection
            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BankConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;

    }

}
