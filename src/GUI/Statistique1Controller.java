/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Util.MaConnexion;
import com.mysql.jdbc.MySQLConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author khlif
 */
public class Statistique1Controller implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private Button Retour_to_main_yessin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connexion= MaConnexion.getInstance().getCnx(); 
        System.out.println("aaa");
        stat();
    }    
    private Statement st;
    private ResultSet rs;
    private Connection  connexion;
    
    ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
     
     private void stat()
    {
          
           
      try {
           
          String query = "SELECT COUNT(*),Salaire_init FROM fiche_de_paie GROUP BY Salaire_init" ;
       
             PreparedStatement PreparedStatement =    connexion.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
            
                     
            while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("Salaire_init"),rs.getInt("COUNT(*)")));
            }     
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
        piechart.setTitle("Statistiques selon les Salaires");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);
    
    }
     
    @FXML
    private void Retour_to_main(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CRUD.fxml"));
            Parent root = loader.load();
            Retour_to_main_yessin.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("echec retour main");;
        }
        
    }
    
}


