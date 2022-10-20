/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Congé;
import service.CongeCrud;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class AjCongeController implements Initializable {

    @FXML
    private TextField idper;
    @FXML
    private TextField dy;
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
    @FXML
    private TextField typec;
    @FXML
    private Label derr;
    @FXML
    private Label dderr;
    @FXML
    private Label drerr;

    public void setderr(String message) {
        this.derr.setText(message);
    }

    public void setdderr(String message) {
        this.dderr.setText(message);
    }

    public void setdrerr(String message) {
        this.drerr.setText(message);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void setConge(ActionEvent event) {
        int id = Integer.parseInt(idper.getText());
        String tc = typec.getText();
        String etatd = ed.getText();
        int dny = Integer.parseInt(dy.getText());
        int dnm = Integer.parseInt(dm.getText());
        int dnj = Integer.parseInt(dj.getText());
        int rny = Integer.parseInt(dry.getText());
        int rnm = Integer.parseInt(drm.getText());
        int rnj = Integer.parseInt(drj.getText());
        int rdy = Integer.parseInt(ddy.getText());
        int rdm = Integer.parseInt(ddm.getText());
        int rdj = Integer.parseInt(ddj.getText());
        if (1900 < dny && dny < 2022 && 0 < dnm && dnm < 12 && 0 < dnj && dnj < 31) {
            setderr("");
            if (1900 < rny && rny < 2022 && 0 < rnm && rnm < 12 && 0 < rnj && rnj < 31) {
                setdrerr("");
                if (1900 < rdy && rdy < 2022 && 0 < rdm && rdm < 12 && 0 < rdj && rdj < 31) {
                    setdderr("");

                    dny = dny - 1900;
                    dnm = dnm - 1;
                    rny = rny - 1900;
                    rnm = rnm - 1;
                    rdy = rdy - 1900;
                    rdm = rdm - 1;

                    Congé c = new Congé(id, new Date(dny, dnm, dnj), tc, etatd, new Date(rdy, rdm, rdj), new Date(rny, rnm, rnj));

                    CongeCrud cc = new CongeCrud();
                    cc.ajouterConge(c);
                    
                    FXMLLoader loader
                        = new FXMLLoader(getClass().getResource("AfConge.fxml"));
                try {
                    Parent root = loader.load();
                    AfCongeController auc = loader.getController();
                    auc.setidper(""+c.getIdPer());
                    auc.seted(c.getEtatDemande());
                    auc.settypec(c.getTypeDemande());
                    
                    DateFormat dfdny = new SimpleDateFormat("yyyy");
                    String Sny = dfdny.format(c.getdDepart());
                    DateFormat dfdnm = new SimpleDateFormat("MM");
                    String Snm = dfdnm.format(c.getdDepart());
                    DateFormat dfdnj = new SimpleDateFormat("dd");
                    String Snj = dfdnj.format(c.getdDepart());
                    auc.setdy(Sny);
                    auc.setdm(Snm);
                    auc.setdj(Snj);

                    DateFormat dfdey = new SimpleDateFormat("yyyy");
                    String Sey = dfdey.format(c.getdDepot());
                    DateFormat dfdem = new SimpleDateFormat("MM");
                    String Sem = dfdem.format(c.getdDepot());
                    DateFormat dfdej = new SimpleDateFormat("dd");
                    String Sej = dfdej.format(c.getdDepot());
                    auc.setddy(Sey);
                    auc.setddm(Sem);
                    auc.setddj(Sej);
                    
                    DateFormat drfdey = new SimpleDateFormat("yyyy");
                    String Srey = drfdey.format(c.getdRetour());
                    DateFormat drfdem = new SimpleDateFormat("MM");
                    String Srem = drfdem.format(c.getdRetour());
                    DateFormat drfdej = new SimpleDateFormat("dd");
                    String Srej = drfdej.format(c.getdRetour());
                    auc.setdry(Srey);
                    auc.setdrm(Srem);
                    auc.setdrj(Srej);

                    idper.getScene().setRoot(root);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                } else {
                    //rd
                    setdderr("format date 8alta");
                }

            } else {
                //rn
                setdrerr("format date 8alta");
            }

        } else {
            //dn
            setderr("format date 8alta");
        }
    }

}
