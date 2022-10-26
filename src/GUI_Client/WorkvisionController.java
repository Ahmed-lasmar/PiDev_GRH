/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Client;

import Controller.ItemController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import model.Fruit;
import models.Application;
import models.OffreEmploi;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author radhw
 */
public class WorkvisionController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label fruitNameLable;
  
    @FXML
    private ImageView fruitImg;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Fruit> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private TableView<OffreEmploi> offre_client;
    @FXML
    private TableColumn<OffreEmploi, String> nom_offre_client;
    @FXML
    private TableColumn<OffreEmploi, String> decription_offre_client;
    @FXML
    private TableColumn<OffreEmploi, String> skills_offre_client;
    @FXML
    private Button topoffre;
    @FXML
    private HBox offreinspect;
    @FXML
    private HBox appinspect;
    @FXML
    private AnchorPane offreoffre;
    @FXML
    private AnchorPane appapp;
    @FXML
    private Button test;
    @FXML
    private Label top_offre;
    @FXML
    private HBox appinspect1;
    @FXML
    private BarChart<?, ?> acceptedchart;
    @FXML
    private BarChart<?, ?> refusedchart;
    @FXML
    private TableView<Application> college_table_view;
    @FXML
    private TableColumn<Application, String> collegue_app;
    @FXML
    private TableColumn<Application, String> spec_app;
    @FXML
    private Label dateApp;
    @FXML
    private HBox searchbox;
    @FXML
    private ImageView searchicon;
    @FXML
    private TextField champ_recherche;

    private List<Fruit> getData() {
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit;

        fruit = new Fruit();
        fruit.setName("c-sharp");
    
        fruit.setImgSrc("/img/c-sharp.png");
        fruit.setColor("6A7324");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("Flutter");
        
        fruit.setImgSrc("/img/flutter.png");
        fruit.setColor("A7745B");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("java");
       
        fruit.setImgSrc("/img/java.png");
        fruit.setColor("F16C31");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("javascript");
     
        fruit.setImgSrc("/img/javascript.jpg");
        fruit.setColor("291D36");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("php");
    
        fruit.setImgSrc("/img/php.png");
        fruit.setColor("22371D");
        fruits.add(fruit);

        fruit = new Fruit();
        fruit.setName("python");
        
        fruit.setImgSrc("/img/python.png");
        fruit.setColor("FB5D03");
        fruits.add(fruit);

        return fruits;
    }
    Connection cnx2;

    private void setChosenFruit(Fruit fruit) {
        fruitNameLable.setText(fruit.getName());
        
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showDatacol();
        homeDisplayTotalEnrolledChart();
        homeDisplayFemaleEnrolledChart();
        showData();
        fruits.addAll(getData());
        if (fruits.size() > 0) {
            setChosenFruit(fruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Fruit fruit) {
                    setChosenFruit(fruit);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }  

    public WorkvisionController() {
        cnx2=MyConnection.getInstance().getCnx();
    }
    public void showData(){
        ObservableList<OffreEmploi> showList = dataList();
        nom_offre_client.setCellValueFactory(new PropertyValueFactory<>("nomOffre"));
        decription_offre_client.setCellValueFactory(new PropertyValueFactory<>("description"));
        skills_offre_client.setCellValueFactory(new PropertyValueFactory<>("skills"));
        offre_client.setItems(showList);
        
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
                
                data = new OffreEmploi(rs.getString("nomOffre"),
                        rs.getString("description"),
                        rs.getString("skills"));
                
                dataList.add(data);
                
            }
            
        }catch(Exception e){}
        return dataList;
        
    }
     private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    
    public void showbestoffre(){
    try{
            
             String countNum = "SELECT COUNT(id_offre) FROM offreemploi";
            statement = cnx2.createStatement();
            result = statement.executeQuery(countNum);
            
            while(result.next()){
                int countRow = result.getInt("COUNT(id)");
                System.out.println(countRow);
             }
            
        }catch(Exception e){}
    }
   

    @FXML
    private void showtopoffre(ActionEvent event) {
        String sql = "INSERT INTO application(`candidat`, `offre`, `cv`, `etat`) VALUES (?,?,?,?)";
        
        try{
          int index = offre_client.getSelectionModel().getSelectedIndex();
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);

            pst.setString(1, "Radhwen Rmili");
            pst.setString(2, nom_offre_client.getCellObservableValue(index).getValue());
            pst.setString(3,"Pending CV" );
            pst.setString(4, "Pending");
            pst.executeUpdate();
            System.out.println("item ajouté avec succés");
            
        }catch(Exception e){}
    }

    @FXML
    private void switchForm(MouseEvent event) {
        if (event.getSource() == offreinspect) {
            offreoffre.setVisible(true);
            appapp.setVisible(false);
            searchbox.setVisible(true);
            searchicon.setVisible(true);

            offreinspect.setStyle("-fx-background-color:#666666");
            appinspect.setStyle("-fx-background-color:#fff");
             
            showData();
            
        } else if (event.getSource() == appinspect) {
           offreoffre.setVisible(false);
            appapp.setVisible(true);
            searchbox.setVisible(false);
            searchicon.setVisible(false);

           offreinspect.setStyle("-fx-background-color:#fff");
            appinspect.setStyle("-fx-background-color:#666666");
          


        }
    }

    @FXML
       private void test(ActionEvent event) {
        try{
             String countNum = "select offre, count(*) as offres from application group by offre order by count(*) desc limit 1";
            statement = cnx2.createStatement();
            result = statement.executeQuery(countNum);
            
            while(result.next()){
                String countRow = result.getString("offre");
                System.out.println(countRow);
                top_offre.setText(countRow);
             }
            
        }catch(Exception e){}
    }
        public void homeDisplayTotalEnrolledChart() {

        acceptedchart.getData().clear();

        String sql = "SELECT date, COUNT(id_app) FROM application WHERE etat = 'Accepté(e)' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = cnx2.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            acceptedchart.getData().add(chart);

        } catch (Exception e) {
           // e.printStackTrace();
        }

    }
       public void homeDisplayFemaleEnrolledChart() {

        refusedchart.getData().clear();

        String sql = "SELECT date, COUNT(id_app) FROM application WHERE etat = 'Refusé(e)' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";

        

        try {
            XYChart.Series chart = new XYChart.Series();

            prepare = cnx2.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }

            refusedchart.getData().add(chart);

        } catch (Exception e) {
            //e.printStackTrace();
        }

    }
         public void showDatacol(){
        ObservableList<Application> showList = dataListcol();
        collegue_app.setCellValueFactory(new PropertyValueFactory<>("candidat"));
        spec_app.setCellValueFactory(new PropertyValueFactory<>("offre"));
        college_table_view.setItems(showList);
        
    }
    public ObservableList<Application> dataListcol(){
        
       
        ObservableList<Application> dataListcol = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM application WHERE etat='Accepté(e)'";
           
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            Application data;
            
            while(rs.next()){
                 
                data = new Application(rs.getString("candidat"),
                        rs.getString("offre"),
                        rs.getString("etat"));
                          
                dataListcol.add(data);
                
            }
            
        }catch(Exception e){}
        return dataListcol;
        
    }
    
 
                
         
         
    
}
