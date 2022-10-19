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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class AfUserController implements Initializable {

    @FXML
    private TextField Anom;
    @FXML
    private TextField Aprenom;
    @FXML
    private TextField Aemail;
    @FXML
    private TextField Acin;
    @FXML
    private TextField Aurl;
    @FXML
    private TextField Anumtel;
    @FXML
    private TextField Agrade;
    @FXML
    private TextField Aequipe;
    @FXML
    private TextField Arole;
    @FXML
    private TextField ny;
    @FXML
    private TextField nm;
    @FXML
    private TextField nj;
    @FXML
    private TextField ey;
    @FXML
    private TextField em;
    @FXML
    private TextField ej;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setny(String message) {
        this.ny.setText(message);
    }
    public void setnm(String message) {
        this.nm.setText(message);
    }
    public void setnj(String message) {
        this.nj.setText(message);
    }
     public void setey(String message) {
        this.ey.setText(message);
    }
    public void setem(String message) {
        this.em.setText(message);
    }
    public void setej(String message) {
        this.ej.setText(message);
    }   
    
    
    public void setAnom(String message) {
        this.Anom.setText(message);
    }
    public void setAprenom(String message) {
        this.Aprenom.setText(message);
    }
    public void setAemail(String message) {
        this.Aemail.setText(message);
    }
    public void setcin(String message) {
        this.Acin.setText(message);
    }
    public void seturl(String message) {
        this.Aurl.setText(message);
    }
    public void setnumtel(String message) {
        this.Anumtel.setText(message);
    }
    public void setgrade(String message) {
        this.Agrade.setText(message);
    }
    public void setAequipe(String message) {
        this.Aequipe.setText(message);
    }
    public void setrole(String message) {
        this.Arole.setText(message);
    }

    
}
