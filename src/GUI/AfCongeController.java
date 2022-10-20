/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class AfCongeController implements Initializable {

    @FXML
    private TextField idper;
    @FXML
    private TextField dy;
    @FXML
    private TextField typec;
    @FXML
    private TextField ed;
    @FXML
    private TextField dm;
    @FXML
    private TextField dj;
    @FXML
    private TextField ddy;
    @FXML
    private TextField ddm;
    @FXML
    private TextField ddj;
    @FXML
    private TextField dry;
    @FXML
    private TextField drm;
    @FXML
    private TextField drj;

    public void setidper(String message) {
        this.idper.setText(message);
    }

    public void setdy(String message) {
        this.dy.setText(message);
    }

    public void settypec(String message) {
        this.typec.setText(message);
    }
    public void setdm(String message) {
        this.dm.setText(message);
    }

    public void seted(String message) {
        this.ed.setText(message);
    }
    public void setdj(String message) {
        this.dj.setText(message);
    }
    public void setddy(String message) {
        this.ddy.setText(message);
    }
    public void setddm(String message) {
        this.ddm.setText(message);
    }
    public void setddj(String message) {
        this.ddj.setText(message);
    }
    public void setdry(String message) {
        this.dry.setText(message);
    }
    public void setdrm(String message) {
        this.drm.setText(message);
    }
    public void setdrj(String message) {
        this.drj.setText(message);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
