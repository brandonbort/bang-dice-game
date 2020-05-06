/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Interface_Components;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;
import java.util.*;
import bang_dice_game.BangDiceGame;

/**
 *
 * @author Brandon
 */
public class StartScreenUIController implements Initializable, EventHandler<ActionEvent> {

    
    @FXML
    private Button startButton;
    @FXML
    public ChoiceBox<String> numOfPlayers;
    
    static GameBoardUIController boardControl;
    
    static int [] karma;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==startButton){
            LinkedList<String> chars;
            
            int playerAmount = (int) Integer.parseInt(numOfPlayers.getValue());
            
            //opens main game window after creating game
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameBoardUI.fxml"));
            //sets the game Controller so the AI and users cant interact
            GameBoardUIController.setLoad(fxmlLoader);
            GameBoardUIController.setPlayerNum(playerAmount);
            Parent root = fxmlLoader.load();
            boardControl = (GameBoardUIController)fxmlLoader.getController();
            Scene scene = new Scene(root);
            
            FileInputStream iconStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/bang icon.jpg");
            Image icon = new Image(iconStream);
            stage.getIcons().add(icon);
            stage.setScene(scene);            
            stage.show();
            
            GameBoardUIController.setPlayerNum(playerAmount);
            BangDiceGame.newGame(GameBoardUIController.getPlayerNum(), GameBoardUIController.getLoad().getController());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        startButton.setDisable(true);
        
        //add items to the FXML choice box and create an event listener for when the value is changed
        String nums[] = {"4", "5", "6", "7", "8"};
        numOfPlayers.setItems(FXCollections.observableArrayList(nums));
        numOfPlayers.setOnAction(this);
        // TODO
    }    

    //handles anything that is not a button click
    @FXML
    private void handle(InputMethodEvent event) {
        if(event.getSource()==numOfPlayers){
            //enables the start button once the choices are correctly filled out
            startButton.setDisable(false);
        }
    }

    @Override
    public void handle(ActionEvent event) {
           if(event.getSource()==numOfPlayers){
            //enables the start button once the choices are correctly filled out
            startButton.setDisable(false);
        }
    }
    
}
