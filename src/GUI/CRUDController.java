/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import service.FicheDePaieCRUD;
import Model.*;
import Service.PrimeCRUD;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author khlif
 */
public class CRUDController implements Initializable {

    @FXML
    private DatePicker date_textfield;
    @FXML
    private Label id_fp_label;
    @FXML
    private Label id_per_label;
    @FXML
    private Label salaire_init_label;
    @FXML
    private Label id_prime_label;
    @FXML
    private TextField total_textfield;
    @FXML
    private TextField etat_textfield;
    @FXML
    private TextField id_fp_textfield;
    @FXML
    private Label salaire_total_label;
    @FXML
    private Label date_paiement_label;
    @FXML
    private Label etat_paiement_label;
    @FXML
    private TextField id_per_textfield;
    @FXML
    private TextField init_textfield;
    @FXML
    private TextField prime_textfield;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TableView<fiche_de_paie> paiement_tableau;
    @FXML
    private TableColumn<fiche_de_paie, Integer> id_fp_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> id_per_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> salaire_init_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> id_prime_colonne;
    @FXML
    private TableColumn<fiche_de_paie, Integer> salaire_total_colonne;
    @FXML
    private TableColumn<fiche_de_paie, DatePicker> date_paiement_colonne;
    @FXML
    private TableColumn<fiche_de_paie, String> etat_paiement_colonne;
    @FXML
    private Button ajouter_prime_2;
    @FXML
    private Button supprimer_prime_2;
    @FXML
    private Button modifier_prime_2;
    @FXML
    private Label id_prime_label_2;
    @FXML
    private Label type_prime_label_2;
    @FXML
    private Label valeur_prime_label_2;
    @FXML
    private Label date_prime_label_2;
    @FXML
    private TextField id_prime_textfield_2;
    @FXML
    private TextField valeur_prime_textfield_2;
    @FXML
    private TextField type_prime_textfield_2;
    @FXML
    private TableView<prime> tableau_prime_2;
    @FXML
    private TableColumn<prime, Integer> id_prime_colonne_2;
    @FXML
    private TableColumn<prime, String> type_prime_colonne_2;
    @FXML
    private TableColumn<prime, Integer> valeur_prime_colonne_2;
    @FXML
    private TableColumn<prime, DatePicker> date_prime_colonne_2;
    @FXML
    private DatePicker date_prime_textfield_2;
    @FXML
    private Label nombre_heure_2;
    @FXML
    private TextField nombre_heure_textfield_2;
    @FXML
    private ComboBox<String> trie_combobox_1;
    @FXML
    private Button button_croissant;
    @FXML
    private Button button_decroissant;
    @FXML
    private Button Statistique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadTablefichedepaie();
        loadTableprime();
        trie_combobox_1.setItems(FXCollections.observableArrayList("Salaire_init","Salaire_total"));
    }    

    @FXML
    private void ajouter_fiche_de_paiement(ActionEvent event) {
       
        java.sql.Date date_paiement = Date.valueOf(date_textfield.getValue());
        int id_fp = Integer.parseInt(id_fp_textfield.getText());
        int id_per = Integer.parseInt(id_per_textfield.getText());
        int salaire_init = Integer.parseInt(init_textfield.getText());
        int prime = Integer.parseInt(prime_textfield.getText());
        int salaire_total = Integer.parseInt(total_textfield.getText());
        String etat_paiement = etat_textfield.getText();
        
        fiche_de_paie fp = new fiche_de_paie(id_per, salaire_init, prime, salaire_total, date_paiement, etat_paiement);
        if ((id_per == 0)||(salaire_init>salaire_total)){
            System.out.println("controle de saisie ajout!");
        }
        else{
                FicheDePaieCRUD fpcrud = new FicheDePaieCRUD();
        fpcrud.ajouterFicheDePaie(fp);   
        paiement_tableau.getItems().clear();
        loadTablefichedepaie();
                }
    }
    
    
    
        ObservableList<fiche_de_paie> oblist = FXCollections.observableArrayList();
        FicheDePaieCRUD fpcrud= new FicheDePaieCRUD();
        
        
       
        
        
        
    private void loadTablefichedepaie(){//affiche  
        
        List <fiche_de_paie> ls =fpcrud.afficherFicheDePaie();
        ls.forEach(e->oblist.add(e));
        System.out.println(oblist);
        id_fp_colonne.setCellValueFactory(new PropertyValueFactory<>("ID_FP"));
        id_per_colonne.setCellValueFactory(new PropertyValueFactory<>("ID_Per"));
        salaire_init_colonne.setCellValueFactory(new PropertyValueFactory<>("Salaire_init"));
        id_prime_colonne.setCellValueFactory(new PropertyValueFactory<>("ID_Prime"));
        salaire_total_colonne.setCellValueFactory(new PropertyValueFactory<>("Salaire_total"));
        date_paiement_colonne.setCellValueFactory(new PropertyValueFactory<>("Date_paiement"));
        etat_paiement_colonne.setCellValueFactory(new PropertyValueFactory<>("Etat_paiement"));
        
        paiement_tableau.setItems(oblist);
    }
        
        ObservableList<prime> oblist1 = FXCollections.observableArrayList();
        PrimeCRUD fpcrud1 = new PrimeCRUD();
    private void loadTableprime(){//affiche  
        
        List <prime> ls =fpcrud1.afficherPrime();
        ls.forEach(e->oblist1.add(e));
        System.out.println(oblist1);
        id_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("ID_Prime"));
        type_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("Type_Prime"));
        valeur_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("Valeur_Prime"));
        date_prime_colonne_2.setCellValueFactory(new PropertyValueFactory<>("Date_Prime"));
        
        
        tableau_prime_2.setItems(oblist1);
    }
    
    
    @FXML
    private void supprimer_fiche_de_paie(ActionEvent event) {
    fiche_de_paie fp = paiement_tableau.getSelectionModel().getSelectedItem();
    FicheDePaieCRUD fpcrud = new FicheDePaieCRUD();
    fpcrud.supprimerFicheDePaie(fp);
    paiement_tableau.getItems().clear();
     
    loadTablefichedepaie();
    
    }

    @FXML
    private void modifier_fiche_de_paie(ActionEvent event) {
        fiche_de_paie a = paiement_tableau.getSelectionModel().getSelectedItem();
        FicheDePaieCRUD fpcrud = new FicheDePaieCRUD();
        
        int nbr1=Integer.parseInt(id_fp_textfield.getText());
        int nbr2=Integer.parseInt(id_per_textfield.getText());  
        int nbr3=Integer.parseInt(init_textfield.getText());  
        int nbr4=Integer.parseInt(prime_textfield.getText());
        int nbr5=Integer.parseInt(total_textfield.getText());
         a.setID_FP(nbr1);
         a.setID_Per(nbr2);
         a.setSalaire_init(nbr3);
         a.setPrime(nbr4);
         a.setSalaire_total(nbr5);
         a.setEtat_paiement(etat_textfield.getText());
        
         if ((nbr2 == 0)||(nbr3>nbr5)){
          System.out.println("controlle de saisie modification !");   
         }
         else{
             
             fpcrud.modifierFicheDePaie(a);
             
       
         
         }
          paiement_tableau.getItems().clear();
        loadTablefichedepaie();
        
    }

    @FXML
    private void fiche_de_paie_selected(MouseEvent event) {
        int index = paiement_tableau.getSelectionModel().getSelectedIndex();
        fiche_de_paie h = paiement_tableau.getSelectionModel().getSelectedItem();
        id_fp_textfield.setText(id_fp_colonne.getCellData(index).toString());
        id_per_textfield.setText(id_per_colonne.getCellData(index).toString());
        init_textfield.setText(salaire_init_colonne.getCellData(index).toString());
        prime_textfield.setText(id_prime_colonne.getCellData(index).toString());
        total_textfield.setText(salaire_total_colonne.getCellData(index).toString());
        etat_textfield.setText(etat_paiement_colonne.getCellData(index));
        
    }

    @FXML
    private void ajouter_prime(ActionEvent event) {
        
        int nbrh = Integer.parseInt(nombre_heure_textfield_2.getText());
        java.sql.Date date_paiement = Date.valueOf(date_prime_textfield_2.getValue());
        int id_prime = Integer.parseInt(id_prime_textfield_2.getText());
        String type_prime = type_prime_textfield_2.getText();
        int valeur_prime = Integer.parseInt(valeur_prime_textfield_2.getText());
       if (nbrh>50){ valeur_prime = valeur_prime +(nbrh-50)*15;}
        
        prime fp = new prime(id_prime, type_prime, valeur_prime, date_paiement);
        
        if((type_prime=="")||(valeur_prime<0)){
            System.out.println("controle de saisie ajout prime !"); 
        }
        else{
            PrimeCRUD fpcrud = new PrimeCRUD();
            fpcrud.ajouterPrime(fp);
            tableau_prime_2.getItems().clear();
            loadTableprime();
        }
        
    }
     
    

    @FXML
    private void supprimer_prime(ActionEvent event) {
    prime fp = tableau_prime_2.getSelectionModel().getSelectedItem();
    PrimeCRUD fpcrud1 = new PrimeCRUD();    
    fpcrud1.supprimerPrime(fp);
    tableau_prime_2.getItems().clear();
    loadTableprime();
    }

    @FXML
    private void modifier_prime(ActionEvent event) {
        
        int nbrh = Integer.parseInt(nombre_heure_textfield_2.getText());
        prime a = tableau_prime_2.getSelectionModel().getSelectedItem();
        PrimeCRUD fpcrud = new PrimeCRUD();
        java.sql.Date date_paiement = Date.valueOf(date_prime_textfield_2.getValue());
        int nbr1=Integer.parseInt(id_prime_textfield_2.getText());
        String nbr2=type_prime_textfield_2.getText();  
        int nbr3=Integer.parseInt(valeur_prime_textfield_2.getText());  
        if (nbrh>50){ nbr3 = nbr3 +(nbrh-50)*15;}
         a.setID_Prime(nbr1);
         a.setType_Prime(type_prime_textfield_2.getText());
         a.setValeur_Prime(nbr3);
         a.setDate_Prime(date_paiement);
        
         if((nbr2=="")||(nbr3<0)){
             System.out.println("controle de saisie modification prime !");
         }
         else{
             fpcrud1.modifierPrime(a);
        
        tableau_prime_2.getItems().clear();
        loadTableprime();
         }
         
    
        
    }

    @FXML
    private void prime_selected(MouseEvent event) {
        
        int index = tableau_prime_2.getSelectionModel().getSelectedIndex();
        prime h = tableau_prime_2.getSelectionModel().getSelectedItem();
        id_prime_textfield_2.setText(id_prime_colonne_2.getCellData(index).toString());
        type_prime_textfield_2.setText(type_prime_colonne_2.getCellData(index));
        valeur_prime_textfield_2.setText(valeur_prime_colonne_2.getCellData(index).toString());
        
    }
    /*
    @FXML
    private void calcul_nombre_heure(){
        
        int nbrh = Integer.parseInt(nombre_heure_textfield_2.getText());
        FicheDePaieCRUD fp = new FicheDePaieCRUD();
        fp.calculer_Salaire(p, nbrh);
    }
    */
/*
    @FXML
    private void statistique(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("statistique1.fxml"));
            Parent root =loader.load();
            Statistique1Controller e = loader.getController();
            
        } catch (IOException ex) {
            System.out.println("echec statistique ");
        }
    }*/
    @FXML
    private void statistique(ActionEvent event) {
        try {
                   
            Parent parent =  FXMLLoader.load(getClass().getResource("statistique1.fxml"));
            Scene scene = new Scene(parent);
            
            Stage stage = new Stage();
            
          
            stage.setScene(scene);
          
            stage.initStyle(StageStyle.UTILITY);
          
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); 
        }
    }
}
