/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI_Client.MailServiceImpl;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Congé;
import models.Application;
import models.OffreEmploi;
import service.CongeCrud;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author radhw
 */
public class BackOfficeController implements Initializable {

    @FXML
    private HBox searchbox;
    @FXML
    private TextField champ_recherche;
    @FXML
    private ImageView searchicon;
    @FXML
    private TableView<Application> table_view;
    @FXML
    private TableColumn<Application, Integer> col_ida;
    @FXML
    private TableColumn<Application, String> col_candidat;
    @FXML
    private TableColumn<Application, String> col_offre;
    @FXML
    private TableColumn<Application, String> col_cv;
    @FXML
    private TableColumn<Application, String> col_etat;
    @FXML
    private AnchorPane left_main;
    @FXML
    private TextField idlaba;
    @FXML
    private TextField candlab;
    @FXML
    private TextField offlab;
    @FXML
    private ComboBox<?> etat;
    @FXML
    private ImageView image_viewa;
    @FXML
    private Button insert_image;
    @FXML
    private Label file_path;
    @FXML
    private Button addbtn;
    @FXML
    private Button updatebtn;
    @FXML
    private Button deletebtn;

    /**
     * Initializes the controller class.
     */
    private String[] comboetat = {"Accepté(e)", "Refusé(e)"};
    @FXML
    private HBox gestionoffres;
    @FXML
    private HBox gestionapp;
    @FXML
    private TableView<OffreEmploi> table_view1;
    @FXML
    private TableColumn<OffreEmploi, Integer> col_id;
    @FXML
    private TableColumn<OffreEmploi, String> col_nom;
    @FXML
    private TableColumn<OffreEmploi, String> col_desc;
    @FXML
    private TableColumn<OffreEmploi, String> col_skills;
    @FXML
    private TableColumn<OffreEmploi, String> col_picture;
    @FXML
    private AnchorPane left_main1;
    @FXML
    private ComboBox<?> skills;
    @FXML
    private TextField idlab;
    @FXML
    private TextField nomlab;
    @FXML
    private TextField desclab;
    @FXML
    private ImageView image_view;
    @FXML
    private Button insert_image1;
    @FXML
    private Label file_path1;
    @FXML
    private Button butAjout;
    @FXML
    private Button butModif;
    @FXML
    private Button buttSupp;
    @FXML
    private AnchorPane appadmin;
    @FXML
    private AnchorPane offreadmin;
    private String[] comboSkills = {"Java", "Javascript", "Python", "PHP", "C"};
    @FXML
    private HBox GesCon;
    @FXML
    private HBox gestionapp1;
    @FXML
    private AnchorPane HomeC;
    @FXML
    private TableView<Congé> tab;
    @FXML
    private TableColumn<Congé, Integer> c1;
    @FXML
    private TableColumn<Congé, Integer> c2;
    @FXML
    private TableColumn<Congé, Date> c3;
    @FXML
    private TableColumn<Congé, String> c4;
    @FXML
    private TableColumn<Congé, String> c5;
    @FXML
    private TableColumn<Congé, Date> c6;
    @FXML
    private TableColumn<Congé, Date> c7;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxa();
        showData();
        comboBox();
        showDatao();
        loadTableConge();
    }    

    @FXML
    private void switchForm(MouseEvent event) {
        if (event.getSource() == gestionoffres) {
            offreadmin.setVisible(true);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#666666");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#fff");

            showData();

        } else if (event.getSource() == gestionapp) {
            offreadmin.setVisible(false);
            appadmin.setVisible(true);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(false);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#fff");
            gestionapp.setStyle("-fx-background-color:#666666");
            
        } else if (event.getSource() == GesCon) {
            offreadmin.setVisible(false);
            appadmin.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);
            HomeC.setVisible(true);

            gestionoffres.setStyle("-fx-background-color:#fff");
            GesCon.setStyle("-fx-background-color:#666666");
            gestionapp.setStyle("-fx-background-color:#fff");
        }
    }

 

    @FXML
     public void comboboxa() {
          List<String> list = new ArrayList<>();
        
        for(String data: comboetat){
            
            list.add(data);
            
        }
        
        ObservableList dataList = FXCollections.observableArrayList(list);
        
        etat.setItems(dataList);
    }

    @FXML
     private void insertimage(ActionEvent event) {
        FileChooser open = new FileChooser();
        
        Stage stage = (Stage)left_main.getScene().getWindow();
        
        File file = open.showOpenDialog(stage);
        
        if(file != null){
            
            String path = file.getAbsolutePath();
            
            path = path.replace("\\", "\\\\");
            
            file_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);
            
            image_viewa.setImage(image);
            
        }else{
            
            System.out.println("aucune image detectée!");
            
        }
    }
    Connection cnx2;
    public BackOfficeController() {
        cnx2=MyConnection.getInstance().getCnx();
    }

    @FXML
    private void ajouterApp(ActionEvent event) {
        String sql = "INSERT INTO application( `candidat`, `offre`, `cv`, `etat`) VALUES (?,?,?,?)";
        
        try{
            
            if( candlab.getText().isEmpty()
                    | offlab.getText().isEmpty() 
                    | etat.getSelectionModel().isEmpty()
                    | image_viewa.getImage() == null){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("entrer tous les données");
                alert.showAndWait();
                
            }else{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            pst.setString(1, candlab.getText());
            pst.setString(2, offlab.getText());
            pst.setString(3,(String)etat.getSelectionModel().getSelectedItem() );
            pst.setString(4, file_path.getText());
            pst.executeUpdate();
            System.out.println("item ajouté avec succés");
            
                showData();
                clear();
            }
        }catch(Exception e){}
    }

    @FXML
    private void modifierApp(ActionEvent event) {
        String path = file_path.getText();
        
        path = path.replace("\\", "\\\\");
        
        String sql = "UPDATE application SET `candidat` = '" 
                + candlab.getText() + "', `offre` = '" 
                + offlab.getText() 
                + "', `etat` = '" + etat.getSelectionModel().getSelectedItem()
                + "', `date` = '" + Date.valueOf(LocalDate.now())
                + "' WHERE id_app = '" + Integer.parseInt(idlaba.getText()) + "'";
        
        try{
            
            if(idlaba.getText().isEmpty() | offlab.getText().isEmpty()
                    | candlab.getText().isEmpty() 
                   ){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Entrer tous les champs!");
                alert.showAndWait();
                
            }else{
                MailServiceImpl.mailsent("radhwen.rmili@esprit.tn",candlab.getText(),etat.getSelectionModel().getSelectedItem().toString());
                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Succés");
                alert.setHeaderText(null);
                alert.setContentText("l'item est modifié avec succés");
                alert.showAndWait();

                showData();
                clear();
                
                
            }
        }catch(Exception e){}
     
    }

    @FXML
    private void supprimerApp(ActionEvent event) {
          String sql = "DELETE from application WHERE `id_app` = '" + Integer.parseInt(idlaba.getText()) + "'";
        try{
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("confirmer la suppression?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
            
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            pst.executeUpdate();
                
            }else{
                
                return;
                
            }
            
            showData();
            clear();
            
        }catch(Exception e){}
    }
    public ObservableList<Application> dataList(){
        
       
        ObservableList<Application> dataList = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM application";
 
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            Application data;
            
            while(rs.next()){
                
                data = new Application(rs.getInt("id_app"), rs.getString("candidat"),
                        rs.getString("offre"), rs.getString("cv"),
                        rs.getString("etat"));
                
                dataList.add(data);
                
            }
            
        }catch(Exception e){}
        return dataList;
        
    }
     public void clear(){
        
        idlaba.setText("");
        candlab.setText("");
        offlab.setText("");
        etat.getSelectionModel().clearSelection();
        image_viewa.setImage(null);
        
    }
     public void showData(){
        ObservableList<Application> showList = dataList();
        
        col_ida.setCellValueFactory(new PropertyValueFactory<>("id_app"));
        col_offre.setCellValueFactory(new PropertyValueFactory<>("offre"));
        col_candidat.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        col_cv.setCellValueFactory(new PropertyValueFactory<>("CV"));
       table_view.setItems(showList);
        
    }

    
    @FXML
     public void comboBox() {
         List<String> list = new ArrayList<>();
        
        for(String data: comboSkills){
            
            list.add(data);
            
        }
        
        ObservableList dataList = FXCollections.observableArrayList(list);
        
        skills.setItems(dataList);
    }

    @FXML
    private void insertImage(ActionEvent event) {
       FileChooser open = new FileChooser();
        
        Stage stage = (Stage)left_main1.getScene().getWindow();
        
        File file = open.showOpenDialog(stage);
        
        if(file != null){
            
            String path = file.getAbsolutePath();
            
            path = path.replace("\\", "\\\\");
            
            file_path1.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);
            
            image_view.setImage(image);
            
        }else{
            
            System.out.println("aucune image detectée!");
            
        }
    }

    @FXML
    private void ajouterOffre(ActionEvent event) {
        String sql = "INSERT INTO offreemploi VALUES (?,?,?,?)";
        
        try{
            
            if(nomlab.getText().isEmpty()
                    | desclab.getText().isEmpty() 
                    | skills.getSelectionModel().isEmpty()
                    | image_view.getImage() == null){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("entrer tous les données");
                alert.showAndWait();
                
            }else{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            
            pst.setString(1, nomlab.getText());
            pst.setString(2, desclab.getText());
            pst.setString(4,(String)skills.getSelectionModel().getSelectedItem() );
            pst.setString(3, file_path1.getText());
            pst.executeUpdate();
            System.out.println("item ajouté avec succés");
            
                showDatao();
                clearo();
            }
        }catch(Exception e){}
    }
     public void clearo(){
        
        idlab.setText("");
        nomlab.setText("");
        desclab.setText("");
        skills.getSelectionModel().clearSelection();
        image_view.setImage(null);
        
    }
    @FXML
    private void modifierOffre(ActionEvent event) {
        String path = file_path.getText();
        
        path = path.replace("\\", "\\\\");
        
        String sql = "UPDATE offreemploi SET `nomOffre` = '" 
                + nomlab.getText() + "', `description` = '" 
                + desclab.getText() + "', `skills` = '" 
                + skills.getSelectionModel().getSelectedItem() 
                + "', `picture` = '" + path 
                + "' WHERE id_offre = '" + Integer.parseInt(idlab.getText()) + "'";
        
        try{
            
            if(idlab.getText().isEmpty() | nomlab.getText().isEmpty()
                    | desclab.getText().isEmpty() 
                    | skills.getSelectionModel().isEmpty()
                    ){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Entrer tous les champs!");
                alert.showAndWait();
                
            }else{
            
                PreparedStatement pst;
                pst = cnx2.prepareStatement(sql);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Succés");
                alert.setHeaderText(null);
                alert.setContentText("l'item est modifié avec succés");
                alert.showAndWait();

                showDatao();
                clearo();
                
            }
        }catch(Exception e){}
        
    }
    ObservableList<Congé> oblist = FXCollections.observableArrayList();
    CongeCrud us= new CongeCrud();
    
    private void loadTableConge(){//affiche foramtion
        List <Congé> fs =us.afficherDemande();
        fs.forEach(e->oblist.add(e));
        System.out.println(oblist);
        c1.setCellValueFactory(new PropertyValueFactory<>("idCon"));
        c2.setCellValueFactory(new PropertyValueFactory<>("idPer"));
        c3.setCellValueFactory(new PropertyValueFactory<>("dDepot"));
        c4.setCellValueFactory(new PropertyValueFactory<>("typeDemande"));
        c5.setCellValueFactory(new PropertyValueFactory<>("etatDemande"));
        c6.setCellValueFactory(new PropertyValueFactory<>("dDepart"));
        c7.setCellValueFactory(new PropertyValueFactory<>("dRetour"));
        
     tab.setItems(oblist);
    } 
    public ObservableList<OffreEmploi> dataListo(){
        
       
        ObservableList<OffreEmploi> dataListo = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM offreemploi";
        
        try{
            
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            OffreEmploi data;
            
            while(rs.next()){
                
                data = new OffreEmploi(rs.getInt("id_offre"), rs.getString("nomOffre"),
                        rs.getString("description"), rs.getString("skills"),
                        rs.getString("picture"));
                
                dataListo.add(data);
                
            }
            
        }catch(Exception e){}
        
        return dataListo;
        
    }
    public void showDatao(){
        ObservableList<OffreEmploi> showList = dataListo();
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_offre"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nomOffre"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        col_picture.setCellValueFactory(new PropertyValueFactory<>("picture"));
        
        table_view1.setItems(showList);
        
    }
    @FXML
    private void supprimerOffre(ActionEvent event) {
        String sql = "DELETE from offreemploi WHERE `id_offre` = '" + Integer.parseInt(idlab.getText()) + "'";
        try{
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("confirmer la suppression?");
            
            Optional<ButtonType> buttonType = alert.showAndWait();
            
            if(buttonType.get() == ButtonType.OK){
            
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            pst.executeUpdate();
                
            }else{
                
                return;
                
            }
            
            showDatao();
            clearo();
            
        }catch(Exception e){}
    }
    @FXML
    private void selectItem(MouseEvent event) {
         int index = table_view1.getSelectionModel().getSelectedIndex();
        OffreEmploi offre = table_view1.getSelectionModel().getSelectedItem();
        idlab.setText(col_id.getCellData(index).toString());
        nomlab.setText(col_nom.getCellData(index).toString());
        desclab.setText(col_desc.getCellData(index).toString());
    }
    
    
    @FXML
     private void selectApp(MouseEvent event) {
         int index = table_view.getSelectionModel().getSelectedIndex();
        Application app = table_view.getSelectionModel().getSelectedItem();
        idlaba.setText(col_ida.getCellData(index).toString());
        candlab.setText(col_candidat.getCellData(index).toString());
        offlab.setText(col_offre.getCellData(index).toString());
        //file_path.setText(col_cv.getCellData(index).toString());
        //etat.get44444.setText(col_etat.getCellData(index).toString())     
    }
     
}
