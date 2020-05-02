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
        System.out.println("How many players do you want?");
        System.out.println("You are limited to 4 to 8 players:");
        
        int playerAmount = in.nextInt();
        
            
            UserPlayer playerHuman = new UserPlayer("getto", "sheriff", "is good guy :D", 4, 0);
            players.add((Player) playerHuman);
            
            for (int i = 0; i < playerAmount - 1; i++){
                PlayerWithStrategy playerComp = new PlayerWithStrategy("name", "role", "description", 4, 0, i+1, playerAmount);
                players.add(playerComp);
            }
//            System.out.println(players.get(0).getName());
//            System.out.println(players);
//            System.out.println(players.get(0).getSpot());
//            System.out.println(players.get(1).getSpot());
//            System.out.println(players.get(2).getSpot());
//            System.out.println(players.get(3).getSpot());
        
            Game bangGame = new Game(players);
            bangGame.play();
            // currently have the game set to be over when game starts
            Player winner = bangGame.winner(); 
            System.out.println("The winner is: " + winner.getName());
            
    }
    
    
    
    
}
