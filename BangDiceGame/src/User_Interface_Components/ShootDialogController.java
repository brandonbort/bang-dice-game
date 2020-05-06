/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Interface_Components;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Brandon
 */
public class ShootDialogController implements Initializable {

    @FXML
    private Button targetOne;
    @FXML
    private Button targetTwo;
    @FXML
    private Button targetThree;
    @FXML
    private Button targetFour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //targetOne.setText("characterInRangeOneName");
    }

    @FXML
    public void handle(ActionEvent event){
//        if(event.getSource()==targetOne) shoot(playerOne);
    }
    
}
