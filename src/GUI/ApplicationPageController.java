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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Application;
import models.OffreEmploi;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author radhw
 */
public class ApplicationPageController implements Initializable {

    @FXML
    private TableView<Application> table_view;
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
    private TextField candlab;
    @FXML
    private TextField offlab;
    @FXML
    private ComboBox<?> etat;
    @FXML
    private Button insert_image;
    @FXML
    private Button addbtn;
    @FXML
    private Button updatebtn;
    @FXML
    private Button deletebtn;

  
    
    Connection cnx2;
    @FXML
    private TableColumn<Application, Integer> col_ida;
    @FXML
    private TextField idlaba;
    @FXML
    private ImageView image_viewa;
    @FXML
    private Label file_path;
    
      public ApplicationPageController() {
          cnx2=MyConnection.getInstance().getCnx();
    }
      private String[] comboetat = {"Accepté(e)", "Refusé(e)"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxa();
        showData();
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
    

    @FXML
    private void ajouterApp(ActionEvent event) {
        String sql = "INSERT INTO application(`id_app`, `candidat`, `offre`, `cv`, `etat`) VALUES (?,?,?,?,?)";
        
        try{
            
            if(idlaba.getText().isEmpty() | candlab.getText().isEmpty()
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
            pst.setInt(1, Integer.parseInt(idlaba.getText()));
            pst.setString(2, candlab.getText());
            pst.setString(3, offlab.getText());
            pst.setString(5,(String)etat.getSelectionModel().getSelectedItem() );
            pst.setString(4, file_path.getText());
            pst.executeUpdate();
            System.out.println("item ajouté avec succés");
            
                showData();
                clear();
            }
        }catch(Exception e){}
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
    private void selectApp(MouseEvent event) {
         int index = table_view.getSelectionModel().getSelectedIndex();
        Application app = table_view.getSelectionModel().getSelectedItem();
        idlaba.setText(col_ida.getCellData(index).toString());
        candlab.setText(col_candidat.getCellData(index).toString());
        offlab.setText(col_offre.getCellData(index).toString());
        //file_path.setText(col_cv.getCellData(index).toString());
        //etat.get44444.setText(col_etat.getCellData(index).toString());

        
    }
    
}
