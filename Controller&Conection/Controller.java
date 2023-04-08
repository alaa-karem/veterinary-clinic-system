package sample;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable{
    ///////////////////////////////////////////////////////////////login
    @FXML
    private Pane bgPane;

    @FXML
    private Button btbsignup;

    @FXML
    private Button btnsignin;

    @FXML
    private ComboBox<?> compoboxLogin;

    @FXML
    private Label lblpassword;

    @FXML
    private Label lblusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;
    private String _id;

    @FXML
    void signin(ActionEvent event) throws SQLException, IOException {
       // String sql = "SELECT `email` ,`password`,`type` FROM `signup` ";

        if(compoboxLogin.getValue().equals("Owner"))
        {
            String sql2 = "SELECT * FROM `users` where type=? and username=? and pass=?";
            PreparedStatement ps = connection1.conn().prepareStatement(sql2);
            ps.setString(1, (String) compoboxLogin.getValue());
            ps.setString(2,txtusername.getText());
            ps.setString(3,txtpassword.getText());
            ResultSet r = ps.executeQuery();
            Parent root = FXMLLoader.load(getClass().getResource("owner.fxml"));
            Stage stage =  (Stage) btnsignin.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        else if(compoboxLogin.getValue().equals("Vet"))
        {
            String sql2 = "SELECT * FROM `users` where type=? and username=? and pass=?";
            PreparedStatement ps = connection1.conn().prepareStatement(sql2);
            ps.setString(1, (String) compoboxLogin.getValue());
            ps.setString(2,txtusername.getText());
            ps.setString(3,txtpassword.getText());
            ResultSet r = ps.executeQuery();
            Parent root = FXMLLoader.load(getClass().getResource("vet.fxml"));
            Stage stage =  (Stage) btnsignin.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
        else
        {
            String sql2 = "SELECT * FROM `admin` where username=? and password=?";
            PreparedStatement ps = connection1.conn().prepareStatement(sql2);
            ps.setString(1,txtusername.getText());
            ps.setString(2,txtpassword.getText());
            ResultSet r = ps.executeQuery();

            Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
            Stage stage =  (Stage) btnsignin.getScene().getWindow();
            stage.setScene(new Scene(root));

        }

    }

    @FXML
    void signup(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sign.fxml"));
        Stage stage =  (Stage) btbsignup.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Sign up ");
    }
//////////////////////////////////////////////////////////////////////////////////////////////// signup

        @FXML
        private Button btn1;

        @FXML
        //private ComboBox<?> c1;
        private ComboBox<String> c1 =  new ComboBox<String>();

        @FXML
        private String id1;

        @FXML
        private String id2;

        @FXML
        private String id3;

        @FXML
        private TextField t1;

        @FXML
        private TextField t2;

        @FXML
        private PasswordField t3;

        @FXML
        private PasswordField t4;

        @FXML
        void sign(ActionEvent event) throws IOException {

                String id;
                String typee1,user,email;
                String pass;
                typee1 = c1.getValue();
                user = t1.getText();
                email = t2.getText();
                pass = t3.getText();
                id= t4.getText();


                try
                {
                    pst = connection1.conn().prepareStatement("insert into users(type, username, email, pass,id)values(?,?,?,?,?)");
                    pst.setString(1,typee1);
                    pst.setString(2,user);
                    pst.setString(3,email);
                    pst.setString(4,pass);
                    pst.setString(5,id);
                    pst.executeUpdate();

            } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
            }

            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage =  (Stage) btn1.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(" login ");


        }


////////////////////////////////////////////////////////////////////////////////////////////// owner

    @FXML
    private Button btnShow;

    @FXML
    private Button btnserve;

    @FXML
    private ComboBox<?> cmbChooseAnimal;

    @FXML
    private ComboBox<?> cmbChooseTheAge;

    @FXML
    private ComboBox<?> cmbTime;

    @FXML
    private ComboBox<?> cmbreserveDay;

    @FXML
    private Label label;
/////////////////////////////////////////////////////// vet

        @FXML
        private Button btnAdd;

        @FXML
        private Button btnshow;

        @FXML
        private ComboBox<?> com1;

        @FXML
        private ComboBox<?> com2;

        @FXML
        private Label lblVet;

        @FXML
        private Label ll;

        @FXML
        private Label lll;

        @FXML
        void ShowTimes(ActionEvent event) {

        }

        @FXML
        void addDay(ActionEvent event) {

        }

///////////////////////////////////////////////////////////////////////////////////////////// admin

        @FXML
        private Button bt1;

        @FXML
        private Button btn2;

        @FXML
        private Button btn3;


    @FXML
    private Label la3;

    @FXML
    private Label lab4;

    @FXML
    private Label lab5;












    //////////////////////////////////////////////////////////////////////////

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    public void Connect()
    {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/vetProject", "root","");
            System.out.println("OK");

        } catch (ClassNotFoundException ex) {

        }  catch (SQLException ex)  {
            //ex.printStackTrace();
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connect();



    }

}

/*    @FXML
    void Add(ActionEvent event) {

        String day,time,animal;
        day = txtTime.getText();
        time = txtTime.getText();
        animal = txtAminal.getText();

        try
        {
            pst = con.prepareStatement("insert into test(DAY, TIME, ANIMAL)values(?,?,?)");
            pst.setString(1,day);
            pst.setString(2,time);
            pst.setString(3,animal);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("sdfas");
            alert.setContentText("added");
            alert.showAndWait();

          //  table();
            txtDay.setText("");
            txtTime.setText("");
            txtAminal.setText("");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  */





/*
    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
    public void Connect()
    {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/vetProject", "root","");
            System.out.println("OK");

        } catch (ClassNotFoundException ex) {

        }  catch (SQLException ex)  {
           //ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
*/
/*

    @FXML
    void Add(ActionEvent event) {

        String day,time,animal;
        day = txtTime.getText();
        time = txtTime.getText();
        animal = txtAminal.getText();

        try
        {
            pst = con.prepareStatement("insert into test(DAY, TIME, ANIMAL)values(?,?,?)");
            pst.setString(1,day);
            pst.setString(2,time);
            pst.setString(3,animal);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connection");
            alert.setHeaderText("sdfas");
            alert.setContentText("added");
            alert.showAndWait();

          //  table();
            txtDay.setText("");
            txtTime.setText("");
            txtAminal.setText("");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 */
