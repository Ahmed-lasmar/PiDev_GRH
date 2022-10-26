/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login;

import Service.MailService;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class ObliMDPController implements Initializable {

    @FXML
    private TextField txtUsername;

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
UserService us = new UserService();
    MailService ms = new MailService();
    @FXML
    private void btOBL(ActionEvent event) {
        String Email = txtUsername.getText();

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String mdpt = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        us.updateUserMdp(Email, mdpt);
        ms.SendMail(Email, mdpt);
        Notifications.create().title("Reset Mot de passe")
                    .text("vérifiez votre mail pour le nouveau mot de passe.")
                    .showInformation();

        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("Login.fxml"));
        try {
            Parent root = loader.load();
            txtUsername.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
