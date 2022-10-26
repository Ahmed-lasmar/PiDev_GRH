/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.OffreEmploi;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author radhw
 */
public class OfrrePageController implements Initializable {

    @FXML
    private TableView<OffreEmploi> table_view;
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
    private Button insert_image;
    @FXML
    private Button butAjout;
    @FXML
    private Button buttSupp;
    @FXML
    private Button butModif;
    
    
    Connection cnx2;
    @FXML
    private AnchorPane left_main;
    @FXML
    private Label file_path;

    public OfrrePageController() {
        cnx2=MyConnection.getInstance().getCnx();
    }
    private String[] comboSkills = {"Java", "Javascript", "Python", "PHP", "C"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       comboBox();
        showData();
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
        
        Stage stage = (Stage)left_main.getScene().getWindow();
        
        File file = open.showOpenDialog(stage);
        
        if(file != null){
            
            String path = file.getAbsolutePath();
            
            path = path.replace("\\", "\\\\");
            
            file_path.setText(path);

            Image image = new Image(file.toURI().toString(), 110, 110, false, true);
            
            image_view.setImage(image);
            
        }else{
            
            System.out.println("aucune image detectée!");
            
        }
    }

    @FXML
    private void ajouterOffre(ActionEvent event) {
        String sql = "INSERT INTO offreemploi VALUES (?,?,?,?,?)";
        
        try{
            
            if(idlab.getText().isEmpty() | nomlab.getText().isEmpty()
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
            pst.setInt(1, Integer.parseInt(idlab.getText()));
            pst.setString(2, nomlab.getText());
            pst.setString(3, desclab.getText());
            pst.setString(4,(String)skills.getSelectionModel().getSelectedItem() );
            pst.setString(5, file_path.getText());
            pst.executeUpdate();
            System.out.println("item ajouté avec succés");
            
                showData();
                //clear();
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
    public ObservableList<OffreEmploi> dataList(){
        
       
        ObservableList<OffreEmploi> dataList = FXCollections.observableArrayList();
        
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
                
                dataList.add(data);
                
            }
            
        }catch(Exception e){}
        
        return dataList;
        
    }
    public void showData(){
        ObservableList<OffreEmploi> showList = dataList();
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_offre"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nomOffre"));
        col_desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_skills.setCellValueFactory(new PropertyValueFactory<>("skills"));
        col_picture.setCellValueFactory(new PropertyValueFactory<>("picture"));
        
        table_view.setItems(showList);
        
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
            
            showData();
            //clear();
            
        }catch(Exception e){}
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
                    | image_view.getImage() == null){
                
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

                showData();
                //clear();
                
            }
        }catch(Exception e){}
        
    }

    @FXML
    private void selectItemo(MouseEvent event) {
         int index = table_view.getSelectionModel().getSelectedIndex();
        OffreEmploi offre = table_view.getSelectionModel().getSelectedItem();
        idlab.setText(col_id.getCellData(index).toString());
        nomlab.setText(col_nom.getCellData(index).toString());
        desclab.setText(col_desc.getCellData(index).toString());
    }
    
}
