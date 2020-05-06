/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Interface_Components;

import bang_dice_game.BangDiceGame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import bang_dice_game.Dice;
import javafx.scene.control.TitledPane;
import bang_dice_game.Game;
import bang_dice_game.PlayerController;

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
    private ImageView currentPlayerCard;
    @FXML
    private Label currentPlayerArrowLabel;

    @FXML
    private Label arrowLabel;
    @FXML
    private Label roleLabel;
    @FXML
    private Label characterLabel;
    @FXML
    private ImageView HeartIcon11;

    public Label getRoleLabel() {
        return roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel.setText(roleLabel);
    }
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
    @FXML
    private ImageView HeartIcon1;

    public String getCharacterLabel() {
        return characterLabel.getText();
    }

    public void setCharacterLabel(String characterLabel) {
        this.characterLabel.setText(characterLabel);
    }

    @FXML
    private TitledPane GameInfoBox;
    @FXML
    private Button skipRerollBtn;
    @FXML
    private Label reRollLabel;
    private int reRolls = 3;
    @FXML
    private Label CurrentPlayerLifePointsLabel;
    private static Game game; 
    private static int playerNum;
    static FXMLLoader load;
    private static GameBoardUIController boardControl;
    private static PlayerController playerController;

    public static PlayerController getPlayerController() {
        return playerController;
    }

    public static void setPlayerController(PlayerController playerController) {
        GameBoardUIController.playerController = playerController;
    }



    /**
     * Initializes the controller class.
     */
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        CheckBox[] diceChecks = {checkOne, checkTwo, checkThree, checkFour, checkFive};
        for (int i = 0; i < 5; i++) {
            diceChecks[i].setSelected(true);
            diceChecks[i].setVisible(false);
        }
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        //opens the rules dialog, user cannot interact with main GUI until rules window is closed
        if (event.getSource() == rulesButton) {
            Stage parent = (Stage) rulesButton.getScene().getWindow();
            Stage rules = new Stage();

            rules.initOwner(parent);
            rules.initModality(Modality.WINDOW_MODAL);

            Parent root = FXMLLoader.load(getClass().getResource("rulesDialog.fxml"));
            Scene scene = new Scene(root);
            FileInputStream iconStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/bang icon.jpg");
            Image icon = new Image(iconStream);
            rules.getIcons().add(icon);
            rules.setScene(scene);
            rules.show();
        } else if (event.getSource() == rollButton) {
            //arrays to associate checkboxes with ImageViews
            reRolls--;
            
            reRollLabel.setText("" + reRolls);
//            ImageView[] dice = {diOne, diTwo, diThree, diFour, diFive};
            CheckBox[] diceChecks = {checkOne, checkTwo, checkThree, checkFour, checkFive};
            if(GameBoardUIController.getGame().nextPlayer() == GameBoardUIController.getGame().getUser())
                playerController.update(playerController.getPlayer());
            for (int x = 0; x < 5; x++) {
                diceChecks[x].setVisible(true);
            }
            //this happens after the images are changed based on the dice rolls
            //do player rolls
//            for (int x = 0; x < 5; x++) {
//                if (diceChecks[x].isSelected()) {
//                    dice[x].setImage(diceFace[Dice.Dice_Face.getRandomDice_Face().ordinal()]);
//                }
//                //user cannot reroll dynamite
//                if (dice[x].getImage() == diceFace[1]) {
//                    diceChecks[x].setDisable(true);
//                    diceChecks[x].setSelected(false);
//                }
//            }

            if (reRolls < 1) {
                rollButton.setDisable(true);
            }

        } else if (event.getSource() == skipRerollBtn) {
            reRolls = 3;
            if(!GameBoardUIController.getGame().gameOver()){
                GameBoardUIController.getGame().findNextPlayer();
                GameBoardUIController.update(GameBoardUIController.getBoardControl());
                if(GameBoardUIController.getGame().nextPlayer().getName().equals("LuckyDuke"))reRolls++;
            }
            CheckBox[] diceChecks = {checkOne, checkTwo, checkThree, checkFour, checkFive};
            for (int i = 0; i < diceChecks.length; i++) {
                diceChecks[i].setDisable(false);
                diceChecks[i].setSelected(true);
            }
            reRollLabel.setText("" + reRolls);
            rollButton.setDisable(false);
//            game.AIplayer
        }
    }

    public ImageView getDiOne() {
        return diOne;
    }

    public void setDiOne(ImageView diOne) {
        this.diOne = diOne;
    }

    public ImageView getDiTwo() {
        return diTwo;
    }

    public void setDiTwo(ImageView diTwo) {
        this.diTwo = diTwo;
    }

    public ImageView getDiThree() {
        return diThree;
    }

    public void setDiThree(ImageView diThree) {
        this.diThree = diThree;
    }

    public ImageView getDiFour() {
        return diFour;
    }

    public void setDiFour(ImageView diFour) {
        this.diFour = diFour;
    }

    public ImageView getDiFive() {
        return diFive;
    }

    public void setDiFive(ImageView diFive) {
        this.diFive = diFive;
    }

    public CheckBox getCheckOne() {
        return checkOne;
    }

    public void setCheckOne(CheckBox checkOne) {
        this.checkOne = checkOne;
    }

    public CheckBox getCheckTwo() {
        return checkTwo;
    }

    public void setCheckTwo(CheckBox checkTwo) {
        this.checkTwo = checkTwo;
    }

    public CheckBox getCheckThree() {
        return checkThree;
    }

    public void setCheckThree(CheckBox checkThree) {
        this.checkThree = checkThree;
    }

    public CheckBox getCheckFour() {
        return checkFour;
    }

    public void setCheckFour(CheckBox checkFour) {
        this.checkFour = checkFour;
    }

    public CheckBox getCheckFive() {
        return checkFive;
    }

    public void setCheckFive(CheckBox checkFive) {
        this.checkFive = checkFive;
    }

    public Image[] getImageArray() {
        Image[] diceFaces = new Image[6];
        try {
            // images are loaded into array in the order they are shown in the Dice class
            FileInputStream imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Dice Faces/DiArrow.png");
            diceFaces[0] = new Image(imgStream);
            imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Dice Faces/DiBeer.png");
            diceFaces[4] = new Image(imgStream);
            imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Dice Faces/DiDynamite.png");
            diceFaces[1] = new Image(imgStream);
            imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Dice Faces/DiGatling.png");
            diceFaces[5] = new Image(imgStream);
            imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Dice Faces/DiOne.png");
            diceFaces[2] = new Image(imgStream);
            imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Dice Faces/DiTwo.png");
            diceFaces[3] = new Image(imgStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameBoardUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diceFaces;
    }
    
    public static void update(GameBoardUIController boardControl) throws FileNotFoundException{
        GameBoardUIController.setBoardControl(boardControl);
        boardControl.setLifePointsLabel(GameBoardUIController.getGame().getUser().getHealth()+"");
        boardControl.setArrowLabel(GameBoardUIController.getGame().getUser().getArrows()+"");
        boardControl.setRoleLabel("Role:" + GameBoardUIController.getGame().getUser().getRole());
        boardControl.setCharacterLabel(GameBoardUIController.getGame().getUser().getName());
        
        boardControl.setSheriffLabel(GameBoardUIController.getGame().getSheriff().getName());
        boardControl.setArrowsToAttack(""+Game.getGameArrows());
        
        boardControl.setCurrentPlayerCard(GameBoardUIController.getGame().nextPlayer().getName());
        boardControl.setCurrentPlayerArrowLabel(""+GameBoardUIController.getGame().nextPlayer().getArrows());
        boardControl.setCurrentPlayerLifePointsLabel(""+GameBoardUIController.getGame().nextPlayer().getHealth());
    }

    public void setCurrentPlayerCard(String currentPlayerCard) throws FileNotFoundException {
        FileInputStream imgStream = new FileInputStream(System.getProperty("user.dir") + "/src/utility/Characters/" + currentPlayerCard+".jpg");
        this.currentPlayerCard.setImage(new Image(imgStream));
    }

    public void setCurrentPlayerArrowLabel(String label) {
        this.currentPlayerArrowLabel.setText(label);
    }

    public void setLifePointsLabel(String LifePointsLabel) {
        this.LifePointsLabel.setText(LifePointsLabel);
    }

    public void setArrowLabel(String arrowLabel) {
        this.arrowLabel.setText(arrowLabel);
    }

    public void setCurrentPlayer(ImageView currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setSheriffLabel(String sheriffLabel) {
        this.sheriffLabel.setText(sheriffLabel);
    }

    public void setArrowsToAttack(String arrowsToAttack) {
        this.arrowsToAttack.setText(arrowsToAttack);
    }

    public void setCurrentPlayerLifePointsLabel(String CurrentPlayerLifePointsLabel) {
        this.CurrentPlayerLifePointsLabel.setText(CurrentPlayerLifePointsLabel);
    }
    
    public static Game getGame() {
        return GameBoardUIController.game;
    }

    public static void setGame(Game game) {
        GameBoardUIController.game = game;
    }

    public static int getPlayerNum() {
        return GameBoardUIController.playerNum;
    }

    public static void setPlayerNum(int playerNum) {
        GameBoardUIController.playerNum = playerNum;
    }
    
    public static void setLoad(FXMLLoader load) {
        GameBoardUIController.load = load;
    }
    
    public static FXMLLoader getLoad(){
        return GameBoardUIController.load;
    }
    
    public static GameBoardUIController getBoardControl() {
        return boardControl;
    }

    public static void setBoardControl(GameBoardUIController boardControl) {
        GameBoardUIController.boardControl = boardControl;
    }
}
