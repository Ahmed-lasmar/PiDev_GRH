/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.user;
import Service.UserService;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Congé;
import service.CongeCrud;

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class HomeCController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableConge();
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
    
}
