/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Empl;

import GUI.AfCongeController;
import Model.user;
import Service.UserService;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Congé;
import service.CongeCrud;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class EmpDBController implements Initializable {

    @FXML
    private HBox searchbox;
    @FXML
    private TextField champ_recherche;
    @FXML
    private ImageView searchicon;
    @FXML
    private HBox appinspect;
    @FXML
    private HBox appinspect1;
    @FXML
    private AnchorPane DemandeConge;
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
    @FXML
    private Label derr;
    @FXML
    private Label dderr;
    @FXML
    private Label drerr;
    @FXML
    private HBox ButDemCon;
    @FXML
    private TextField idUser;
    @FXML
    private Label ValCon;
    @FXML
    private Label Nom;

    public void setiduser(String message) {
        this.idUser.setText(message);
    }
    /**
     * Initializes the controller class.
     */
    UserService us = new UserService();

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void switchForm(MouseEvent event) {
        if (event.getSource() == ButDemCon) {
            DemandeConge.setVisible(true);
            //appapp.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);

            ButDemCon.setStyle("-fx-background-color:#666666");
            appinspect.setStyle("-fx-background-color:#fff");

            //showData();
        } else if (event.getSource() == appinspect) {
            DemandeConge.setVisible(false);
            //appapp.setVisible(true);
            searchbox.setVisible(false);
            searchicon.setVisible(false);

            ButDemCon.setStyle("-fx-background-color:#fff");
            appinspect.setStyle("-fx-background-color:#666666");

        }
    }
    private void setNomInHome(){
    int uuu = Integer.parseInt(idUser.getText());
        user uo = new user();
        uo = us.CherById(uuu);
        Nom.setText(uo.getNom());
    }
    
    @FXML
    private void setConge(ActionEvent event) {
        
        String tc = typec.getText();
        String etatd = ed.getText();
        int id = Integer.parseInt(idUser.getText());
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
            derr.setText("");
            if (1900 < rny && rny < 2022 && 0 < rnm && rnm < 12 && 0 < rnj && rnj < 31) {
                drerr.setText("");
                if (1900 < rdy && rdy < 2022 && 0 < rdm && rdm < 12 && 0 < rdj && rdj < 31) {
                    dderr.setText("");

                    dny = dny - 1900;
                    dnm = dnm - 1;
                    rny = rny - 1900;
                    rnm = rnm - 1;
                    rdy = rdy - 1900;
                    rdm = rdm - 1;

                    Congé c = new Congé(id, new Date(dny, dnm, dnj), tc, etatd, new Date(rdy, rdm, rdj), new Date(rny, rnm, rnj));

                    CongeCrud cc = new CongeCrud();
                    cc.ajouterConge(c);
                    ValCon.setText("Demande de congé a été ajouté avec succès.");
                    /*FXMLLoader loader
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
                }*/
                } else {
                    //rd
                    dderr.setText("format date 8alta");
                }

            } else {
                //rn
                drerr.setText("format date 8alta");
            }

        } else {
            //dn
            derr.setText("format date 8alta");
        }
    }

    @FXML
    private void Setnomintop(MouseEvent event) {
        int uuu = Integer.parseInt(idUser.getText());
        user uo = new user();
        uo = us.CherById(uuu);
        Nom.setText(uo.getNom());
    }

}
