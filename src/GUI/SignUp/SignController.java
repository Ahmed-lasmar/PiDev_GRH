/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.SignUp;

import GUI.AfUserController;
import GUI.LoginController;
import Model.user;
import Service.MailService;
import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class SignController implements Initializable {

    @FXML
    private TextField txtFirstname;
    @FXML
    private TextField txtLastname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCin;
    @FXML
    private TextField txtNumTel;
    @FXML
    private TextField dY;
    @FXML
    private TextField dM;
    @FXML
    private TextField dJ;
    @FXML
    private Label setErrdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void HandleEvents(MouseEvent event) {
    }

    @FXML
    private void btnSave(ActionEvent event) {
        String Nom = txtFirstname.getText();
        String Prenom = txtLastname.getText();
        String mdp = "";
        String Email = txtEmail.getText();
        String Cin = txtCin.getText();
        String url = "";
        String numtel = txtNumTel.getText();
        String Grade = "";
        String Equipe = "";
        String Role = "";
        int dny = Integer.parseInt(dY.getText());
        int dnm = Integer.parseInt(dM.getText());
        int dnj = Integer.parseInt(dJ.getText());
        System.out.println("DATA TSABET");
        if (1900 < dny && dny < 2022 && 0 < dnm && dnm < 12 && 0 < dnj && dnj < 31) { //ddn

            dny = dny - 1900;
            dnm = dnm - 1;

            user u = new user(Nom, Prenom, Email, Cin, url, new Date(dny, dnm, dnj), numtel, new Date(0, 0, 1), Grade, Equipe, Role, mdp);
            //user u1 = new user("a","a"    ,"mail@email.com","12345678","www",new Date(120,8,23),"24330330",new Date(120,8,23),"admin","Dev" ,"admin");
            UserService uc = new UserService();
            uc.ajouterUser(u);

            System.out.println("user tzed");
            
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String mdpt = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            UserService us = new UserService();
            MailService ms = new MailService();
            System.out.println("MEZELteb3adh");

            us.updateUserMdp(Email, mdpt);
            ms.SendMailSignIn(Email, mdpt);
            System.out.println("teb3adh");

            Notifications.create().title("Bienvenue !")
                    .text("S'il vous plaît vérifier votre adresse email pour recevoir le mot de passe.")
                    .showInformation();
            FXMLLoader loader
                    = new FXMLLoader(getClass().getResource("../Login/Login.fxml"));
            try {
                Parent root = loader.load();
                /*LoginController auc = loader.getController();
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
                    auc.setej(Sej);*/

                txtCin.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            setErrdate.setText("le format de la date n'est pas correct.");
        }
    }

}
