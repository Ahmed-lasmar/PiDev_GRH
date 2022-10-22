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

/**
 * FXML Controller class
 *
 * @author MSI Si Ahmed
 */
public class HomeUController implements Initializable {

    @FXML
    private TableView<user> tab;
    @FXML
    private TableColumn<user, Integer> id;
    @FXML
    private TableColumn<user, String> c2;
    @FXML
    private TableColumn<user, String> c3;
    @FXML
    private TableColumn<user, String> c4;
    @FXML
    private TableColumn<user, String> c5;
    @FXML
    private TableColumn<user, String> c6;
    @FXML
    private TableColumn<user, Date> c7;
    @FXML
    private TableColumn<user, String> c8;
    @FXML
    private TableColumn<user, Date> c9;
    @FXML
    private TableColumn<user, String> c10;
    @FXML
    private TableColumn<user, String> c11;
    @FXML
    private TableColumn<user, String> c12;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTableUser();
    }    
    ObservableList<user> oblist = FXCollections.observableArrayList();
    
    UserService us= new UserService();
    
    private void loadTableUser(){//affiche foramtion
        List <user> fs =us.afficherUser();
        fs.forEach(e->oblist.add(e));
        System.out.println(oblist);
        id.setCellValueFactory(new PropertyValueFactory<>("Id_user"));
        c2.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        c3.setCellValueFactory(new PropertyValueFactory<>("Pernom"));
        c4.setCellValueFactory(new PropertyValueFactory<>("Email"));
        c5.setCellValueFactory(new PropertyValueFactory<>("Cin"));
        c6.setCellValueFactory(new PropertyValueFactory<>("URL_Photo"));
        c7.setCellValueFactory(new PropertyValueFactory<>("Date_de_naissance"));
        c8.setCellValueFactory(new PropertyValueFactory<>("Num_Tel"));
        c9.setCellValueFactory(new PropertyValueFactory<>("Date_embauche"));
        c10.setCellValueFactory(new PropertyValueFactory<>("Grade"));
        c11.setCellValueFactory(new PropertyValueFactory<>("Equipe"));
        c12.setCellValueFactory(new PropertyValueFactory<>("Role"));
     tab.setItems(oblist);
    }
}
