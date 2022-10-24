/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class ModUserController implements Initializable {

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
    private Button Avalider;
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
    @FXML
    private Label errdate;
    @FXML
    private Label errdatee;
    private TextField id;
    @FXML
    private PasswordField Mmdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setErrdate(String message) {
        this.errdate.setText(message);
    }

    public void setErrdatee(String message) {
        this.errdatee.setText(message);
    }

    @FXML
    private void modUser(ActionEvent event) {
        int idm = Integer.parseInt(id.getText());
        String Nom = Anom.getText();
        String Prenom = Aprenom.getText();
        String mdp = Mmdp.getText();
        String Email = Aemail.getText();
        String Cin = Acin.getText();
        String url = Aurl.getText();
        String numtel = Anumtel.getText();
        String Grade = Agrade.getText();
        String Equipe = Aequipe.getText();
        String Role = Arole.getText();
        int dny = Integer.parseInt(ny.getText());
        int dnm = Integer.parseInt(nm.getText());
        int dnj = Integer.parseInt(nj.getText());
        int eny = Integer.parseInt(ey.getText());
        int enm = Integer.parseInt(em.getText());
        int enj = Integer.parseInt(ej.getText());
        if (1900 < dny && dny < 2022 && 0 < dnm && dnm < 12 && 0 < dnj && dnj < 31) { //ddn
            if (1900 < eny && eny < 2022 && 0 < enm && enm < 12 && 0 < enj && enj < 31) { //dde
                dny = dny - 1900;
                dnm = dnm - 1;
                eny = eny - 1900;
                enm = enm - 1;
                user u = new user(Nom, Prenom, Email, Cin, url, new Date(dny, dnm, dnj), numtel, new Date(eny, enm, enj), Grade, Equipe, Role, mdp);
                //user u1 = new user("a","a"    ,"mail@email.com","12345678","www",new Date(120,8,23),"24330330",new Date(120,8,23),"admin","Dev" ,"admin");
                UserService uc = new UserService();
                uc.updateUser(u, idm);
                FXMLLoader loader
                        = new FXMLLoader(getClass().getResource("AfUser.fxml"));
                try {
                    Parent root = loader.load();
                    AfUserController auc = loader.getController();
                    auc.setAnom(u.getNom());
                    auc.setAprenom(u.getPernom());
                    auc.setAemail(u.getEmail());
                    auc.setcin(u.getCin());
                    auc.seturl(u.getURL_Photo());
                    auc.setnumtel(u.getNum_Tel());
                    auc.setgrade(u.getGrade());
                    auc.setAequipe(u.getEquipe());
                    auc.setrole(u.getRole());

                    DateFormat dfdny = new SimpleDateFormat("yyyy");
                    String Sny = dfdny.format(u.getDate_de_naissance());
                    DateFormat dfdnm = new SimpleDateFormat("MM");
                    String Snm = dfdnm.format(u.getDate_de_naissance());
                    DateFormat dfdnj = new SimpleDateFormat("dd");
                    String Snj = dfdnj.format(u.getDate_de_naissance());
                    auc.setny(Sny);
                    auc.setnm(Snm);
                    auc.setnj(Snj);

                    DateFormat dfdey = new SimpleDateFormat("yyyy");
                    String Sey = dfdey.format(u.getDate_embauche());
                    DateFormat dfdem = new SimpleDateFormat("MM");
                    String Sem = dfdem.format(u.getDate_embauche());
                    DateFormat dfdej = new SimpleDateFormat("dd");
                    String Sej = dfdej.format(u.getDate_embauche());
                    auc.setey(Sey);
                    auc.setem(Sem);
                    auc.setej(Sej);

                    Anom.getScene().setRoot(root);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                setErrdatee("format date 8alta");
            }
        } else {
            setErrdate("format date 8alta");
        }
    }

}
