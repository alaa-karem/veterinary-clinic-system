package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class vetcontroller implements Initializable {
    @FXML
    private TextField a1;

    @FXML
    private TextField a2;

    @FXML
    private TextField a3;



    @FXML
    private Button bc;

    @FXML
    void add1(ActionEvent event) {
        int st = connection2.add(a2.getText(), a3.getText(), a1.getText());
        switch (st) {

            case 1:
                JOptionPane.showMessageDialog(null, "insert successfully");

                break;

        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage =  (Stage) bc.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    @FXML
    void update(ActionEvent event) {

      int st=  connection2.update(a2.getText(), a3.getText(), a1.getText());
        switch (st) {

            case 1:
                JOptionPane.showMessageDialog(null, "update successfully");

                break;

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
