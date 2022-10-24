/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.MailService;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class ObliMDPController implements Initializable {

    @FXML
    private TextField obmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    UserService us = new UserService();
    MailService ms = new MailService();

    @FXML
    private void envmail(ActionEvent event) {

        String Email = obmail.getText();

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

        FXMLLoader loader
                = new FXMLLoader(getClass().getResource("Login.fxml"));
        try {
            Parent root = loader.load();
            obmail.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
