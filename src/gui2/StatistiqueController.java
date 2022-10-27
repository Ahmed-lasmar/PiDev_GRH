/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui2;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class StatistiqueController implements Initializable {

    @FXML
    private PieChart piechart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connexion= MyConnection.getInstance().getCnx(); 
        System.out.println("aaa");
        stat();
        // TODO
    }   
    private Statement st;
    private ResultSet rs;
    private Connection    connexion;

    /**
     * Initializes the controller class.
     */
     
    ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
     
     private void stat()
    {
          
           
      try {
           
          String query = "SELECT COUNT(*),Nom_For FROM formation GROUP BY Nom_For" ;
       
             PreparedStatement PreparedStatement =    connexion.prepareStatement(query);
             rs = PreparedStatement.executeQuery();
            
                     
            while (rs.next()){               
               data.add(new PieChart.Data(rs.getString("Nom_For"),rs.getInt("COUNT(*)")));
            }     
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      
        piechart.setTitle("Statistiques selon les Noms");
        piechart.setLegendSide(Side.LEFT);
        piechart.setData(data);
    
    }
    
}
