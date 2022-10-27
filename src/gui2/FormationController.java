/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

import Mailing.Mailing;
import entities.formateur;
import entities.formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import services.formateurCRUD;
import services.formationCRUD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FormationController implements Initializable {

    @FXML
    private TextField tfID;
    @FXML
    private TextField tfIDF;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfNum;
    @FXML
    private Button btnAjouter;
    @FXML
    private DatePicker dpDate;
    @FXML
    private Button btnSup;
    @FXML
    private TableView<formation> Table_Formations;
    @FXML
    private TableColumn<formation, Integer> a_ID;
    @FXML
    private TableColumn<formation, Integer> a_IDF;
    @FXML
    private TableColumn<formation, String> a_Nom;
    @FXML
    private TableColumn<formation, DatePicker> a_Date;
    @FXML
    private TableColumn<formation, Integer> a_NC;
    @FXML
    private Button btnModif;
    
    
    @FXML
    private TableView<formateur> Table_Formateur;
    @FXML
    private TextField nomA;
    @FXML
    private TextField prenomA;
    @FXML
    private TextField adresseA;
    @FXML
    private TextField emailA;
    @FXML
    private TextField telA;
    @FXML
    private TextField CPA;
    @FXML
    private TextField VilleA;
    @FXML
    private TextField payA;
    @FXML
    private TextField statusA;
    @FXML
    private TextField tarifA;
    @FXML
    private TextField tvaA;
    @FXML
    private TextField bioA;
    @FXML
    private TextField diplomeA;
    @FXML
    private TableColumn<formateur, Integer> idCA;
    @FXML
    private TableColumn<formateur, String> nomCA;
    @FXML
    private TableColumn<formateur, String> prenomCA;
    @FXML
    private TableColumn<formateur, String> adresseCA;
    @FXML
    private TableColumn<formateur, String> emailCA;
    @FXML
    private TableColumn<formateur, Integer> telCA;
    @FXML
    private TableColumn<formateur, Integer> codePCA;
    @FXML
    private TableColumn<formateur, String> villeCA;
    @FXML
    private TableColumn<formateur, String> payCA;
    @FXML
    private TableColumn<formateur, String> statusCA;
    @FXML
    private TableColumn<formateur, Integer> terifCA;
    @FXML
    private TableColumn<formateur, Integer> tvaCA;
    @FXML
    private TableColumn<formateur, String> bioCA;
    @FXML
    private TableColumn<formateur, String> diplomeCA;
    @FXML
    private Button btn_stat;
    @FXML
    private TextField Id_Recherchetf;
    @FXML
    private Button btn_RechercheID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO
    loadTableFormation();//formation
   // loadTableFormation();// formation affiche all 
   loadTableFormateur();
    
    }  
      ObservableList<formation> oblist = FXCollections.observableArrayList();
      ObservableList<formateur> oblist1 = FXCollections.observableArrayList();
     formationCRUD fcd= new formationCRUD();
     formateurCRUD ffcd = new formateurCRUD();
     
     
     
   
     private void loadTableFormation(){//affiche foramtion
        List <formation> fs =fcd.afficherForamtion();
        fs.forEach(e->oblist.add(e));
        System.out.println(oblist);
        a_ID.setCellValueFactory(new PropertyValueFactory<>("Id_For"));
        a_IDF.setCellValueFactory(new PropertyValueFactory<>("Id_Formateur"));
        a_Nom.setCellValueFactory(new PropertyValueFactory<>("Nom_For"));
        a_Date.setCellValueFactory(new PropertyValueFactory<>("Date_For"));
        a_NC.setCellValueFactory(new PropertyValueFactory<>("Numbr_Max_Per"));
     Table_Formations.setItems(oblist);
    }
    
     private void loadTableFormateur(){//affiche foramtion
        List <formateur> fs =ffcd.afficherFormateur();
        fs.forEach(e->oblist1.add(e));
        System.out.println(oblist1);
        idCA.setCellValueFactory(new PropertyValueFactory<>("Id_formateur"));
        nomCA.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCA.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresseCA.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        emailCA.setCellValueFactory(new PropertyValueFactory<>("email"));
        telCA.setCellValueFactory(new PropertyValueFactory<>("tel"));
        codePCA.setCellValueFactory(new PropertyValueFactory<>("codeP"));
        villeCA.setCellValueFactory(new PropertyValueFactory<>("ville"));
        payCA.setCellValueFactory(new PropertyValueFactory<>("pays"));
        statusCA.setCellValueFactory(new PropertyValueFactory<>("status"));
        terifCA.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        tvaCA.setCellValueFactory(new PropertyValueFactory<>("tva"));
        bioCA.setCellValueFactory(new PropertyValueFactory<>("bio"));
        diplomeCA.setCellValueFactory(new PropertyValueFactory<>("diplome"));
        
     Table_Formateur.setItems(oblist1);
    }
         @FXML
    private void addFormation(ActionEvent event) {
        java.sql.Date date =Date.valueOf(dpDate.getValue());
        int id;
        id = Integer.parseInt(tfID.getText());
         int idF;
        idF = Integer.parseInt(tfIDF.getText());
         int tfNu;
        tfNu = Integer.parseInt(tfNum.getText());
        
  if((tfID.getText().equals("")) ||
                (tfIDF.getText().equals(""))||
                (tfNom.getText().equals(""))||
                (tfNum.getText().equals(""))||
                (date.equals(""))
                ){ 
            JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs ");
        }
        else {
     formation f= new formation(idF, idF, date, tfNom.getText(), tfNu); 
     formationCRUD fcd= new formationCRUD();
     String path =fcd.QR(tfNom.getText()+" , ET DE numero "+tfNum.getText());
     
        fcd.ajouterFormation(f);
            try {
                fcd.sendEmail(path);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        JOptionPane.showMessageDialog(null, "Formation Crée");
        loadTableFormation();
        
    }
    }
        @FXML
    private void addFormateur(ActionEvent event) {
        
        int N1 ;
        N1 =  Integer.parseInt(telA.getText());
        int N2;
        N2 = Integer.parseInt(CPA.getText());
        int N3;
        N3 =Integer.parseInt(tarifA.getText());
        int N4;
        N4 =Integer.parseInt(tvaA.getText());
        
        
        
        
        
  if( (nomA.getText().equals("")) || (prenomA.getText().equals("")) || (adresseA.getText().equals("")) || (emailA.getText().equals("")) || (telA.getText().equals("")) || (CPA.getText().equals("")) ||(VilleA.getText().equals("")) ||(payA.getText().equals("")) ||(statusA.getText().equals("")) ||(tarifA.getText().equals("")) ||(tvaCA.getText().equals("")) ||(bioCA.getText().equals("")) ||(diplomeCA.getText().equals("")) ){ 
            JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs ");
        }
        else {
     formateur f= new formateur(nomA.getText(),prenomA.getText(),adresseA.getText(),emailCA.getText(),N1,N2,VilleA.getText(),payA.getText(),statusA.getText(),N3,N4,bioCA.getText(),diplomeCA.getText());
              
     
        ffcd.ajouterFormateur(f);
        JOptionPane.showMessageDialog(null, "Formateur Créée");
        loadTableFormateur();
    }
    }  

    @FXML
    private void formation_select(MouseEvent event) {
       
        int index = Table_Formations.getSelectionModel().getSelectedIndex();
        formation f = Table_Formations.getSelectionModel().getSelectedItem();
        tfID.setText(a_ID.getCellData(index).toString());
        tfIDF.setText(a_IDF.getCellData(index).toString());
        tfNum.setText(a_NC.getCellData(index).toString());
        tfNom.setText(a_Nom.getCellData(index));
    }
        @FXML
    private void select_formateur(MouseEvent event) {
        int index = Table_Formateur.getSelectionModel().getSelectedIndex();
        formateur f = Table_Formateur.getSelectionModel().getSelectedItem();
        nomA.setText(nomCA.getCellData(index));
        prenomA.setText(prenomCA.getCellData(index));
        adresseA.setText(adresseCA.getCellData(index));
        emailA.setText(emailCA.getCellData(index));
        telA.setText(telCA.getCellData(index).toString());
        CPA.setText(codePCA.getCellData(index).toString());
        VilleA.setText(villeCA.getCellData(index));
        payA.setText(payCA.getCellData(index));
        statusA.setText(statusCA.getCellData(index));
        tarifA.setText(terifCA.getCellData(index).toString());
        tvaA.setText(tvaCA.getCellData(index).toString());
        bioA.setText(bioCA.getCellData(index));
        diplomeA.setText(diplomeCA.getCellData(index));
    }
        @FXML
    private void deleteFormation(MouseEvent event) {
        formation f=  Table_Formations.getSelectionModel().getSelectedItem();
        fcd.supprimer(f);
        Table_Formations.getItems().clear();
        loadTableFormation();
    }
        @FXML
    private void deleteFormateur(MouseEvent event) {
        formateur f=  Table_Formateur.getSelectionModel().getSelectedItem();
        ffcd.supprimer(f);
        Table_Formateur.getItems().clear();
        loadTableFormateur();
    }
    
        @FXML
    private void updateFormation(MouseEvent event) {
        formation f =  Table_Formations.getSelectionModel().getSelectedItem();
        int nbr1=Integer.parseInt(tfID.getText());
            int nbr2=Integer.parseInt(tfIDF.getText());  
            int nbr3=Integer.parseInt(tfNum.getText());  
            f.setId_For(nbr1);
            f.setId_Formateur(nbr2);
            f.setNumbr_Max_Per(nbr3);
            
        f.setNom_For(tfNom.getText());
        fcd.modifier(f);
        Table_Formations.getItems().clear();
        loadTableFormation();
    }
        @FXML
    private void updateFormateur(MouseEvent event) {
      formateur f =  Table_Formateur.getSelectionModel().getSelectedItem();
       
      
      f.setNom(nomA.getText());
      f.setPrenom(prenomA.getText());
      f.setAdresse(adresseA.getText());
      f.setEmail(emailA.getText());
      int nb=Integer.parseInt(telA.getText());
      int nb1=Integer.parseInt(CPA.getText());
      f.setVille(VilleA.getText());
      f.setPays(payA.getText());
      f.setStatus(statusA.getText());
      int nb2=Integer.parseInt(tarifA.getText());
      int nb3=Integer.parseInt(tvaA.getText());
      f.setBio(bioA.getText());
      f.setDiplome(diplomeA.getText());
      ffcd.modifier(f);
      Table_Formateur.getItems().clear();
      loadTableFormateur();
    }
    
        @FXML
    private void Statistique(MouseEvent event) {
        try {
                   
            Parent parent =  FXMLLoader.load(getClass().getResource("/gui2/statistique.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            
          
            stage.setScene(scene);
          
            stage.initStyle(StageStyle.UTILITY);
          
            stage.show();
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void ChercherIDAM(MouseEvent event) {
        int id ;
        id = Integer.parseInt(Id_Recherchetf.getText());
        List <formation> fs =fcd.rechercherForamtion(id);
        fs.forEach(e->oblist.add(e));
        System.out.println(oblist);
        a_ID.setCellValueFactory(new PropertyValueFactory<>("Id_For"));
        a_IDF.setCellValueFactory(new PropertyValueFactory<>("Id_Formateur"));
        a_Nom.setCellValueFactory(new PropertyValueFactory<>("Nom_For"));
        a_Date.setCellValueFactory(new PropertyValueFactory<>("Date_For"));
        a_NC.setCellValueFactory(new PropertyValueFactory<>("Numbr_Max_Per")); 
        Table_Formations.setItems(oblist);  
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    private void loadTableFormateur(){//affiche foramtion
//        List <formateur> fs =ffcd.afficherFormateur();
//        fs.forEach(e->oblist1.add(e));
//        System.out.println(oblist1);
//        C1.setCellValueFactory(new PropertyValueFactory<>("Id_formateur"));
//        C2.setCellValueFactory(new PropertyValueFactory<>("specialite"));
//        C3.setCellValueFactory(new PropertyValueFactory<>("horaire"));
//        C4.setCellValueFactory(new PropertyValueFactory<>("num_membres"));
//        
//     Table_Formateur.setItems(oblist1);
//    }

//    @FXML
//    private void deleteFormateur(MouseEvent event) {
//        formateur f=  Table_Formateur.getSelectionModel().getSelectedItem();
//        ffcd.supprimer(f);
//        Table_Formateur.getItems().clear();
//        loadTableFormateur();
//    }



//    @FXML
//    private void updateFormateur(MouseEvent event) {
//        formateur f =  Table_Formateur.getSelectionModel().getSelectedItem();
//        
//        int nbr1=Integer.parseInt(tfM.getText());
//            f.setSpecialite(tfS.getText());
//            f.setNum_membres(nbr1);
//        ffcd.modifier(f);
//        Table_Formateur.getItems().clear();
//        loadTableFormateur();
//        
//    }



   


    
    
    
    






    
}
    

