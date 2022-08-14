package Service.UserService.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private static Connection con;
//    private Dao() {};
    public Connection getConnection() throws SQLException {
        if (con == null) {
            Connection con_create = DriverManager.getConnection("jdbc:postgresql://localhost:5433/itijdbc", "iti", "iti123");
            return con_create;
        }
        return con;
    }
}
