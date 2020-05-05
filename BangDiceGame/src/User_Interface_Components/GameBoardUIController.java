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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Brandon
 */
public class GameBoardUIController implements Initializable {

    @FXML
    private Button rulesButton;
    @FXML
    private ImageView diOne;
    @FXML
    private ImageView diTwo;
    @FXML
    private ImageView diThree;
    @FXML
    private ImageView diFour;
    @FXML
    private ImageView diFive;
    @FXML
    private ImageView HeartIcon;
    @FXML
    private Label LifePointsLabel;
    @FXML
    private Label arrowLabel;
    @FXML
    private Label roleLabel;
    @FXML
    private ImageView currentPlayer;
    @FXML
    private Button rollButton;
    @FXML
    private CheckBox checkOne;
    @FXML
    private CheckBox checkTwo;
    @FXML
    private CheckBox checkThree;
    @FXML
    private CheckBox checkFour;
    @FXML
    private CheckBox checkFive;
    @FXML
    private Label sheriffLabel;
    @FXML
    private Label arrowLabel1;
    @FXML
    private Label arrowsToAttack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handle(InputMethodEvent event) throws IOException {
        if(event.getSource()==rulesButton){
            try{
                Parent root = (Parent) FXMLLoader.load(getClass().getResource("rulesDialogFXML.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Bang! Rules");
                FileInputStream iconStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/bang icon.jpg");
                Image icon = new Image(iconStream);
                stage.getIcons().add(icon);
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(Exception e){
                System.out.println("Could not load rules window.");
            }
        }
    }
    
}
