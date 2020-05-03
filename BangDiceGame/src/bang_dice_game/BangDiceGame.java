/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import java.util.*;
import User_Interface_Components.*;

/**
 *
 * @author Brandon
 */
public class BangDiceGame{

    
    public static void main(String[] args) {
       // StartScreenUI start = new StartScreenUI();
        //start.launchGame(args);
        ArrayList<Player> players = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Dice dice = new Dice();
        
        System.out.println("How many players do you want?");
        System.out.print("You are limited to 4 to 8 players:");
        
        int playerAmount = in.nextInt();
        char[][] karma = new char[playerAmount][playerAmount];
            
      
        
//            UserPlayer playerHuman = new UserPlayer("getto", "sheriff", "is good guy :D", 4, 0);
//            players.add(playerHuman);
            
            //for (int i = 0; i < playerAmount; i++){
                //PlayerWithStrategy playerComp = new PlayerWithStrategy("name", "role", "description", 4, 0, i+1, playerAmount);
                //players.add(playerComp);
            //}
                UserPlayer playerHuman1 = new UserPlayer("getto", "Sheriff", "is good guy :D", 4, 0);
                players.add(playerHuman1);
                PlayerWithStrategy playerComp1 = new PlayerWithStrategy("bro", "Renegade", "description", 4, 0, 1,karma);
                players.add(playerComp1);
                PlayerWithStrategy playerComp2 = new PlayerWithStrategy("yo", "Outlaw", "description", 4, 0, 2, karma);
                players.add(playerComp2);
                PlayerWithStrategy playerComp3 = new PlayerWithStrategy("low", "Outlaw", "description", 4, 0, 3, karma);
                players.add(playerComp3);

         

        
            Game bangGame = new Game(players);
            new PlayerController(playerHuman1,bangGame,in,dice);
            while (!bangGame.gameOver()) {
                bangGame.play();
            }
            
            // currently have the game set to be over when game starts :)
            Player winner = bangGame.winner(); 
            //System.out.println("The winner is: " + winner.getName());
    }
    
    
    
    
}
