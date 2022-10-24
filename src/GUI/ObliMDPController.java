/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML
    private void envmail(ActionEvent event) {
        String Email = obmail.getText();
        byte[] array = new byte[10]; // length is bounded by 7
        new Random().nextBytes(array);
        String mdpt = new String(array, Charset.forName("UTF-8"));
    }
    
}
