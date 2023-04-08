package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class connection1 {


    public static Connection conn(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vetproject" , "root", "");
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




}
