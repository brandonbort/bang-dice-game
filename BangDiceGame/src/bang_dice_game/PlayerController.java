/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author airishimamura
 */
class PlayerController implements PlayerObserver {
    
    private BangDiceGame game;
    private Scanner in;
    private Dice dice;
    
    public PlayerController (UserPlayer player, BangDiceGame game, Scanner in, Dice dice){
        this.game = game;
        this.in = in;
        this.dice = dice;
        player.register(this);
    
    }
    
      public void update(UserPlayer player, Dice dice){
        int countDynamite = 0;
        int countGatling = 0;
          
        dice.firstRoll();
         for (int i = 0; i <6; i++){
            if (Dice.Dice_Face.dice[i] == Dice.Dice_Face.Dynamite)
                countDynamite = countDynamite + 1;
        }
        dice.reRoll();
        
        ArrayList<Dice.Dice_Face> diceFace = new ArrayList<Dice.Dice_Face>();
        
        for (int i = 0; i < 6; i++){
            diceFace.add(Dice.Dice_Face.dice[i]);   
        }
        
        for (int i = 0; i <6; i++){
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
            for(int i = 0; i < 6; i++){
                if(null != diceFace.get(i))
                switch (diceFace.get(i)) {
                    case IndianArrow:
                        int arrowAdd = player.getArrows();
                        arrowAdd = arrowAdd + 1;
                        player.setArrows(arrowAdd);
                        break;
                    case BullsEye1:
                        player.takeAim1();
                        break;
                    case BullsEye2:
                        player.takeAim2();
                        break;
                    case Beer:
                        player.beerDice();
                        break;
                    default:
                        System.out.println("Does not exist");
                        break;
                }
            }
        }
     }
}