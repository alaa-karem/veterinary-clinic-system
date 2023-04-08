package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class security {
    private final String user="root";
    private final String password="";
    private final String address="jdbc:mysql://localhost/vetproject";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(address,user,password);
    }
}
