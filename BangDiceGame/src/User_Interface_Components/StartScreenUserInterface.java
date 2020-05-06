/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Interface_Components;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Brandon
 */



public class StartScreenUserInterface extends Application {
    
    static GameBoardUIController gameControl;
    
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../User_Interface_Components/StartScreenUI.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        FileInputStream iconStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/bang icon.jpg");
        Image icon = new Image(iconStream);
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public void launchGame(String[] args){
        launch(args);
    }
    
    public GameBoardUIController getGameControl() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("GameBoardUI.fxml").openStream());
        GameBoardUIController gameControl = (GameBoardUIController) fxmlLoader.getController();
        return gameControl;
    }
    
}
