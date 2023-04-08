package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class connection2 {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String NAME = "vetproject";
    public static Connection con ;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+NAME,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<viewAdmin> viewData()
    {
        Connection con = connection2.con;
        ObservableList<viewAdmin>list= FXCollections.observableArrayList();
        try {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM users");
            ResultSet res = pr.executeQuery();
            while (res.next())
            {
                list.add(new viewAdmin(res.getString("id"),res.getString("type"),res.getString("username"), res.getString("email"), res.getString("pass")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static  int  createUser (String id,String user,String password,String type,String email){
        Connection con = connection2.con;
        try {
            PreparedStatement pr = con.prepareStatement("insert into users(type, username, email, pass,id)values(?,?,?,?,?)");


            pr.setString(1,type);
            pr.setString(2,user);
            pr.setString(3,email);
            pr.setString(4,password);
            pr.setString(5,id);
            pr.executeUpdate();

            return 1;

         } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
      return 1;
    }
    public static  int deleteUser(String id){
        try {
        PreparedStatement pr = con.prepareStatement("DELETE FROM `users` WHERE id=?");

        pr.setString(1,id);
        pr.executeUpdate();

        return 1;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
      return 1;
    }
    public static  int add(String day,String time,String id){
        Connection con = connection2.con;
        try {
            PreparedStatement pr = con.prepareStatement("insert into vet(id,Day,Time)values(?,?,?)");


            pr.setString(1,id);
            pr.setString(2,day);
            pr.setString(3,time);
            pr.executeUpdate();

            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    public static  int update(String day,String time,String id){
        Connection con = connection2.con;
        try {
        PreparedStatement pr = con.prepareStatement("UPDATE vet SET Day=?,Time=? WHERE id=?");
            pr.setString(3,id);
            pr.setString(1,day);
            pr.setString(2,time);
            pr.executeUpdate();
            ResultSet res= pr.executeQuery();

            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    public static  int reserve(Object day, Object time, String animal){
        Connection con = connection2.con;
        try {
            PreparedStatement pr = con.prepareStatement("insert into owner(day,time,animalType)values(?,?,?)");


            pr.setString(1, (String) day);
            pr.setString(2, (String) time);
            pr.setString(3,animal);
            pr.executeUpdate();

            return 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }




}
