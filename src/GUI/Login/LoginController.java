/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login;

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
    private Label btnForgot;
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
        
        String mdp = txtUsername.getText();
        String Email = txtPassword.getText();
        UserService us = new UserService();
        user ul = new user(Email, mdp);
        user ug = new user();
        ug = us.login(ul);
        //System.err.println(ul);
        if (ug.getId_user() > 0) {
            FXMLLoader loader
                    = new FXMLLoader(getClass().getResource("../HomeU.fxml"));
            try {
                Parent root = loader.load();
                txtPassword.getScene().setRoot(root);
                System.out.println("houni");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            //errLogin.setText("mail ou mdp incorrect");
        }
    
    }

    @FXML
    private void btnSignup(ActionEvent event) {
    }
    
}
