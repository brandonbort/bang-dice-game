/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;
import User_Interface_Components.GameBoardUIController;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author airishimamura
 */
public class PlayerController implements PlayerObserver {
    
    private Game game;
//    private Scanner in;
    private Dice dice;
    private GameBoardUIController gameControl;
    private UserPlayer player;
    CheckBox[] diceChecks = {gameControl.getCheckOne(), gameControl.getCheckTwo(), gameControl.getCheckThree(), gameControl.getCheckFour(), gameControl.getCheckFive()};
    
    public UserPlayer getPlayer() {
        return player;
    }
    
    public PlayerController (UserPlayer player, Game game, GameBoardUIController gameControl, Dice dice){
        this.game = game;
        this.gameControl = gameControl;
        this.dice = dice;
        player.register(this);  
        this.player = player;
    }
    
      public void update(UserPlayer player){//, Dice dice){
        int countDynamite = 0;
        int countGatling = 0;
        ArrayList<Player> currentPlayers = new ArrayList<>();
        currentPlayers = Game.getPlayers();
        
        int health;
        
        dice.BasicDice();
          updateDice();
//        for(String i: dice.Result) System.out.println(i);
        
        for (int i = 0; i < 5; i++){
            if (dice.Result.get(i).equals("Dynamite"))
                countDynamite = countDynamite + 1;
        }
        

        if (countDynamite >= 3){
            System.out.println("You have lost your turn and 1 health!");
            health = 0;
            health = currentPlayers.get(0).getHealth();
            health = health - 1;
            currentPlayers.get(0).setHealth(health);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
            dice.reRoll();
            updateDice();
            countDynamite = 0;
            for (int i = 0; i < 5; i++){
                if(dice.Result.get(i).equals("Dynamite"))
                    countDynamite = countDynamite + 1;
                if(dice.Result.get(i).equals("Gatling"))
                    countGatling = countGatling + 1;
            }
            if (countDynamite >= 3){
                System.out.println("You have lost your turn and 1 health!");
                health = 0;
                health = currentPlayers.get(0).getHealth();
                health = health - 1;
                currentPlayers.get(0).setHealth(health);
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }   
            else{        
                if(countGatling >= 3)
                {
                    player.gatlingDice();
                }
//                updateDice();
                for(int i = 0; i < 5; i++){
                   // if(null != diceFace.get(i))
                       if(null != dice.Result.get(i)) 
                    //switch (diceFace.get(i)) {
                     switch (dice.Result.get(i)) {
                        case "IndianArrow":
                            if (Game.getGameArrows() != 0){
                                int arrowAdd = player.getArrows();
                                arrowAdd = arrowAdd + 1;
                                player.setArrows(arrowAdd);
                                int gameArrows = Game.getGameArrows();
                                gameArrows = gameArrows - 1;
                                Game.setGameArrows(gameArrows);
                                System.out.println(player.getName() + " now has " + player.getArrows() + " arrow(s)!");
                                System.out.println("There are only " + gameArrows + " arrow(s) left!");
                                try {
                                    sleep(1000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;

                        case "BullsEye1":
//                            player.takeAim1();
                            break;

                        case "BullsEye2":
//                            if (currentPlayers.size() <= 3){
//                               player.takeAim1(); 
//                            }
//                            else
//                                player.takeAim2();
                            break;

                        case "Beer":
                            player.beerDice();
                            break;

                        default:
                            System.out.println("Checking next dice...");
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                    }
                }
            }
        }  
     }
      public void updateDice(){
        ImageView[] diceImg = {gameControl.getDiOne(), gameControl.getDiTwo(), gameControl.getDiThree(), gameControl.getDiFour(), gameControl.getDiFive()};
        Image[] diceFace = gameControl.getImageArray();
          System.out.println("called updateDice()");
        for(int i = 0; i < 5; i++){;
                System.out.println("Dice: " + dice.Result.get(i));
                 int di = Dice.Dice_Face.valueOf(dice.Result.get(i)).ordinal();
                 diceImg[i].setImage(diceFace[di]);
        }
        for (int x = 0; x < 5; x++) {
            
             if (diceChecks[x].isSelected()) {
                 int di = Dice.Dice_Face.valueOf(dice.Result.get(x)).ordinal();
                 diceImg[x].setImage(diceFace[di]);
             }
             //user cannot reroll dynamite
             if (diceImg[x].getImage() == diceFace[1]) {
                 diceChecks[x].setDisable(true);
                 diceChecks[x].setSelected(false);
             }
        }
      }
}