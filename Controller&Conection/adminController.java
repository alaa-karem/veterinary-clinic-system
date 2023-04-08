package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    private TableColumn<viewAdmin, String> cc1;

    @FXML
    private TableColumn<viewAdmin, String> cc2;

    @FXML
    private TableColumn<viewAdmin, String> cc3;

    @FXML
    private TableColumn<viewAdmin, String> cc4;

    @FXML
    private TableColumn<viewAdmin, String> cc5;
    @FXML
    private TableView<viewAdmin> tab;
    @FXML
    private TextField tf11;

    @FXML
    private TextField tf12;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;
    @FXML
    private TextField tf1;
    @FXML
    private Button btn3;


    ObservableList<viewAdmin> list;
    @FXML
    void createAction(ActionEvent event) {


        int st = connection2.createUser(tf1.getText(), tf2.getText(), tf3.getText(), tf12.getText(), tf11.getText());

        switch (st) {

            case 1:
                JOptionPane.showMessageDialog(null, "created user success");

                break;
        }


    }
    @FXML
    void deleteUser(ActionEvent event) {


       int st= connection2.deleteUser(tf1.getText());
        switch (st) {

            case 1:
                JOptionPane.showMessageDialog(null, "deleted user success");

                break;
        }


//
//        String id=tf1.getText();
//
//
//        try
//        {
//            pst = con.prepareStatement("DELETE FROM `users` WHERE id=?");
//            pst.setString(1,id);
//
//            pst.executeUpdate();
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }


    }
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage =  (Stage) btn3.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    Connection con;
    PreparedStatement pst;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection con = connection2.con;
        cc1.setCellValueFactory(new PropertyValueFactory<viewAdmin,String>("id"));
        cc2.setCellValueFactory(new PropertyValueFactory<viewAdmin,String>("user"));
        cc3.setCellValueFactory(new PropertyValueFactory<viewAdmin,String>("password"));
        cc4.setCellValueFactory(new PropertyValueFactory<viewAdmin,String>("type"));
        cc5.setCellValueFactory(new PropertyValueFactory<viewAdmin,String>("email"));
        list = connection2.viewData();
        tab.setItems(list);
       // tab.isEditable();
    }
}
