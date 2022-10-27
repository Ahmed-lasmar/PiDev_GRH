/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author khlif
 */
public class ProgressbarController implements Initializable {

    @FXML
    private ProgressBar progressbar;
    @FXML
    private ProgressIndicator progressindicaotr;
    @FXML
    private AnchorPane progressanchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // loading for 5 sec
        Task task = taskWorker(5);
        progressbar.progressProperty().unbind();
        progressindicaotr.progressProperty().unbind();
        progressbar.progressProperty().bind(task.progressProperty());
        progressindicaotr.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(e->{ Stage stage = (Stage) progressanchorpane.getScene().getWindow();
        stage.close();
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("CRUD.fxml"));
                Stage stage2 = new Stage();
                Scene scence = new Scene(root);
                stage2.setScene(scence);
                stage2.initStyle(StageStyle.UNDECORATED);
                stage2.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());;
            }
        });
        Thread thread = new Thread(task);
        thread.start();
    }    
    private Task taskWorker(int seconds){
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i=0;i<seconds;i++){
                    updateProgress(i+1, seconds);
                    Thread.sleep(1000);
                }
                return true;
                
            }
        }
        
    }
    
}
