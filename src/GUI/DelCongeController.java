/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.UserService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.CongeCrud;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class DelCongeController implements Initializable {

    @FXML
    private TextField textid;
    @FXML
    private Button delete;
    @FXML
    private Label valD;

    public void setvalD(String message) {
        this.valD.setText(message);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fasa8(ActionEvent event) {
        int id = Integer.parseInt(textid.getText());
        CongeCrud uc = new CongeCrud();
                uc.supprimerConge(id);
               setvalD(id+" tfasa5");
    }
    
}
