package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ownercontroller implements Initializable {
    @FXML
    private Button btnShow;

    @FXML
    private Button btnserve;

    @FXML
    private ComboBox<?> cmbTime;

    @FXML
    private ComboBox<?> cmbreserveDay;

    @FXML
    private Label label;
    @FXML
    private TextField anim;

    @FXML
    private Button finalBack;

    public int loadcategory(){
        Connection con = connection2.con;
        String sql= "SELECT * FROM vet";
        try {
            PreparedStatement pr = con.prepareStatement(sql) ;


                ResultSet res = pr.executeQuery();
                ObservableList data = FXCollections.observableArrayList();
                while (res.next()) {
                    data.add(new String(res.getString(2)));
                }
            cmbreserveDay.setItems(data);
                } catch(SQLException e){
                    System.out.println(e.getMessage());
                }
                return 1;
            }

            public void com (ActionEvent e){
        String newday = (String) cmbreserveDay.getValue();
                Connection con = connection2.con;
                String sql="SELECT * FROM vet WHERE Day=?";
                try {
                PreparedStatement pr = con.prepareStatement(sql) ;
                pr.setString(1,newday);
                ResultSet res = pr.executeQuery();
                } catch(SQLException x){
                    System.out.println(x.getMessage());
                }

            }
    public int loadcategory1(){
        Connection con = connection2.con;
        String sql= "SELECT * FROM vet";
        try {
            PreparedStatement pr = con.prepareStatement(sql) ;


            ResultSet res = pr.executeQuery();
            ObservableList data = FXCollections.observableArrayList();
            while (res.next()) {
                data.add(new String(res.getString(2)));
            }
            cmbTime.setItems(data);
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 1;
    }
      public void yy(ActionEvent event) {
        String newdtime = (String) cmbTime.getValue();
        Connection con = connection2.con;
        String sql="SELECT * FROM vet WHERE Time=?";
        try {
            PreparedStatement pr = con.prepareStatement(sql) ;
            pr.setString(1,newdtime);
            ResultSet res = pr.executeQuery();
        } catch(SQLException x){
            System.out.println(x.getMessage());
        }
    }
    @FXML
    void inser(ActionEvent event) {
       int st= connection2.reserve(cmbreserveDay.getValue(),cmbTime.getValue(),anim.getText());
        switch (st) {

            case 1:
                JOptionPane.showMessageDialog(null, "reserve successfully");

                break;
        }
    }
    @FXML
    void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage =  (Stage) finalBack.getScene().getWindow();
        stage.setScene(new Scene(root));
    }




    @Override
            public void initialize (URL url, ResourceBundle resourceBundle){
                loadcategory();
                loadcategory1();
            }
        }