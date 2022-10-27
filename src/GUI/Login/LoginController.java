/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login;

import GUI.Empl.EmpDBController;
import Model.user;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblErrors;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void btnSignin(ActionEvent event) {

        String Email = txtUsername.getText();
        String mdp = txtPassword.getText();
        //System.out.println("data t3abet");
        UserService us = new UserService();
        user ul = new user(Email, mdp);
        System.out.println(ul);

        user ug = new user();
        ug = us.login(ul);
        //System.out.println("CRUD t3abet");

        System.out.println(ug);
        if (ug.getId_user() > 0) {
            Notifications.create().title("Login avec Succes")
                    .text("Bonjour " + ug.getNom())
                    .showInformation();
            //System.out.println(ug.getRole());
            if (ug.getRole().equals("RRH")) {

                System.out.println("rrh t3adet");
                FXMLLoader loader
                        = new FXMLLoader(getClass().getResource("../BackOffice.fxml"));
                try {
                    Parent root = loader.load();
                    txtPassword.getScene().setRoot(root);
                    //.out.println("houni");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
            else if(ug.getRole().equals("client"))
            {
                System.out.println("client t3adet");
                FXMLLoader loader
                        = new FXMLLoader(getClass().getResource("../../GUI_Client/Workvision.fxml"));
                try {
                    Parent rootc = loader.load();
                    
                    txtPassword.getScene().setRoot(rootc);
                    
                    //.out.println("houni");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
            }
            else if(ug.getRole().equals("employe"))
            {
                System.out.println("client t3adet");
                FXMLLoader loader
                        = new FXMLLoader(getClass().getResource("../Empl/EmpDB.fxml"));
                try {
                    Parent rootc = loader.load();
                    EmpDBController edbc = loader.getController();
                    
                    edbc.setiduser(""+ug.getId_user());
                    txtPassword.getScene().setRoot(rootc);
                    
                    //.out.println("houni");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
            }
        } else {
            //errLogin.setText("mail ou mdp incorrect");
            System.out.println("user moch ma3rouf");

        }

    }

    @FXML
    private void btnSignup(ActionEvent event) {
        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("../SignUp/Sign.fxml"));
        try {
            Parent root = loader.load();
            txtPassword.getScene().setRoot(root);
            System.out.println("houni");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnForgot(MouseEvent event) {
        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("ObliMDP.fxml"));
        try {
            Parent root = loader.load();
            txtPassword.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
