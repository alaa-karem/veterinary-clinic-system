package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

//    static Connection c;
//    static String query;
//    static String query2;
//    static PreparedStatement ss;
//
//    static {
//
//        query = "create table Owner(name varchar(30) not null, email varchar(30) not null, id int not null, dayReserved varchar(10) not null, timeReserved varchar(10) not null, animal varchar(20) not null, animalAge int not null)";
//    }
//    static {
//
//        query2 = "create table Animal(animalType varchar(20), )";
//    }




    static security c1 = new sample.security();
    public static void main(String[] args) throws SQLException {
        launch(args);
        System.out.println("OK");

//        try {
//            Connection c = c1.connect();
//            Statement ss = c.createStatement();
//
//            ss.execute(query);
//            ss.execute(query2);
//            System.out.println("OK");
//         }catch (SQLException ee){
//                System.out.println(ee.getMessage());
//         }

    }

}
