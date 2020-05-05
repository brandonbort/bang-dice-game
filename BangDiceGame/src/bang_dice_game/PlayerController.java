/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author airishimamura
 */
class PlayerController implements PlayerObserver {
    
    private Game game;
    private Scanner in;
    private Dice dice;
    
    public PlayerController (UserPlayer player, Game game, Scanner in, Dice dice){
        this.game = game;
        this.in = in;
        this.dice = dice;
        player.register(this);
    
    }
    
      public void update(UserPlayer player){//, Dice dice){
        int countDynamite = 0;
        int countGatling = 0;
        ArrayList<Player> currentPlayers = new ArrayList<>();
        currentPlayers = Game.getPlayers();
        int health;
          
        dice.firstRoll();
         for (int i = 0; i < 5; i++){
           // if (Dice.Dice_Face.dice[i] == Dice.Dice_Face.Dynamite)
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
                            player.takeAim1();
                            break;

                        case "BullsEye2":
                            if (currentPlayers.size() <= 3){
                               player.takeAim1(); 
                            }
                            else
                                player.takeAim2();
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
}