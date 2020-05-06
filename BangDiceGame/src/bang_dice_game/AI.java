/**
 * Carlos Developed Code
 * Arron assisted
 */
package bang_dice_game;
//LOOK AT BOTTOM OF CODE FOR EXPLANATION OF KARMA!!!

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos144green
 */
public class AI {
    /**
     * Beer             //  class to heal peeps 
     * @param karma     //  2D array
     * @param spot      //  position located on karma
     * @param role      //  sheriff=0, deputy=1, outlaw=2, renegade=3
     * @param hp        //  how many points he has
     */
    
    Dice dice = new Dice();
    
    
    public void play(PlayerWithStrategy player, int morale){
        int countDynamite = 0;
        int countGatling = 0;
        ArrayList<Player> currentPlayers = new ArrayList<>();
        currentPlayers = Game.getPlayers();
        int health;
        
        if ("SidKetchum".equals(player.getName()))
            player.beerDice(player, morale);
        
          
        dice.firstRoll();
         for (int i = 0; i < 5; i++){
            if (dice.Result.get(i).equals("Dynamite"))
                countDynamite = countDynamite + 1;
        }
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else{
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
                    Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }   
            else{        
                if(countGatling >= 3)
                {
                    player.gatlingDice();
                }
                for(int i = 0; i < 5; i++){
                       if(null != dice.Result.get(i)) 
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
                                    Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            break;

                        case "BullsEye1":
                            player.takeAim1(player, morale);
                            break;

                        case "BullsEye2":
                            if (currentPlayers.size() <= 3){
                               player.takeAim1(player, morale); 
                            }
                            else
                                player.takeAim2(player, morale);
                            break;

                        case "Beer":
                            player.beerDice(player, morale);
                            break;

                        default:
                            System.out.println("Checking next dice...");
                            try {
                                sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                    }
                }
            }
        }  
    }
}
