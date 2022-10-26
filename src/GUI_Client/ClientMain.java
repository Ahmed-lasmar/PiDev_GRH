/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Client;

import GUI.ApplicationMain;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author radhw
 */
public class ClientMain extends Application {
    public static final String CURRENCY = "$";
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("Workvision.fxml"));
            Scene scene = new Scene(root, 1500, 900);
            primaryStage.setTitle("WorkVision");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
