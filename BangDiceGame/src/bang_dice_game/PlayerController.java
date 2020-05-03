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
          
        dice.firstRoll();
         for (int i = 0; i < 5; i++){
            if (Dice.Dice_Face.dice[i] == Dice.Dice_Face.Dynamite)
                countDynamite = countDynamite + 1;
        }
        dice.reRoll();
        
        ArrayList<Dice.Dice_Face> diceFace = new ArrayList<Dice.Dice_Face>();
        
        for (int i = 0; i < 5; i++){
            diceFace.add(Dice.Dice_Face.dice[i]);   
        }
        
        for (int i = 0; i < 5; i++){
            if (diceFace.get(i) == Dice.Dice_Face.Dynamite)
                countDynamite = countDynamite + 1;
            if (diceFace.get(i) == Dice.Dice_Face.Gatling)
                countGatling = countGatling + 1;
        }
        
        if (countDynamite >= 3){
            System.out.println("You have lost your turn.");
        }
        else{
            
            if(countGatling >= 3)
            {
                player.gatlingDice();
            }
            for(int i = 0; i < 5; i++){
                if(null != diceFace.get(i))
                switch (diceFace.get(i)) {
                    case IndianArrow:
                        int arrowAdd = player.getArrows();
                        arrowAdd = arrowAdd + 1;
                        player.setArrows(arrowAdd);
                        System.out.println(player.getName() + " now has " + player.getArrows() + " arrow(s)!");
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                        
                    case BullsEye1:
                        player.takeAim1();
                        break;
                        
                    case BullsEye2:
                        if (currentPlayers.size() <= 3){
                           player.takeAim1(); 
                        }
                        else
                            player.takeAim2();
                        break;
                        
                    case Beer:
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