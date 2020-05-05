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
static char [][] karma;
static int isDepDead;

    
    public static void main(String[] args) {
        StartScreenUserInterface start = new StartScreenUserInterface();
        start.launchGame(args);
        ArrayList<Player> players = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Dice dice = new Dice();
        
        System.out.println("How many players do you want?");
        System.out.print("You are limited to 4 to 8 players:");
        
        int playerAmount = in.nextInt();
        playerAmount=5;                             //hardcoded bec ik yall forgot my msg
        karma = new char[playerAmount][playerAmount];
        
        
//            UserPlayer playerHuman = new UserPlayer("getto", "sheriff", "is good guy :D", 4, 0);
//            players.add(playerHuman);
            
            //for (int i = 0; i < playerAmount; i++){
                //PlayerWithStrategy playerComp = new PlayerWithStrategy("name", "role", "description", 4, 0, i+1, playerAmount);
                //players.add(playerComp);
            //}
             if(playerAmount >=4 && playerAmount<= 8){

                UserPlayer playerHuman1 = new UserPlayer("ME", "Sheriff", "is good guy :D", 7, 0);
                players.add(playerHuman1);
                PlayerWithStrategy playerComp1 = new PlayerWithStrategy("Player1", "Renegade", "description", 4, 0, 1,karma);
                players.add(playerComp1);
                PlayerWithStrategy playerComp2 = new PlayerWithStrategy("Mario", "Outlaw", "description", 4, 0, 2, karma);
                players.add(playerComp2);
                PlayerWithStrategy playerComp3 = new PlayerWithStrategy("Brittney", "Outlaw", "description", 4, 0, 3, karma);
                players.add(playerComp3);
                PlayerWithStrategy playerComp4 = new PlayerWithStrategy("Player4", "Deputy", "noob", 4, 0, 4, karma);
                players.add(playerComp4);
                isDepDead=1;    //this needs to track how may deputy are alive <----important
        
            Game bangGame = new Game(players);
            new PlayerController(playerHuman1,bangGame,in,dice);
            while (!bangGame.gameOver()) {
                bangGame.play();
            }
            Player winner = bangGame.winner(); 
            System.out.println("The winner is: " + winner.getName());
            
               }
             else
                System.out.println("Wrong number!! Please do it again");

            
    }
    
}
