/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import User_Interface_Components.GameBoardUIController;
import User_Interface_Components.StartScreenUserInterface;
import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Brandon
 */
public class BangDiceGame{
static int [] karma;
static final Object lock = new Object();
//static int isDepDead;

    
    public static void main(String[] args) throws FileNotFoundException {
        //lock object so the game will not continue without the user selecting options
       
//        Object lock = new Object();
        StartScreenUserInterface start = new StartScreenUserInterface();
        start.launchGame(args);
//        GameBoardUIController.setLock(lock);
//        newGame(GameBoardUIController.getPlayerNum(), GameBoardUIController.getLoad().getController());
          
    }
    
    public static void newGame(int numOfPlayers, GameBoardUIController boardControl) throws FileNotFoundException{
        ArrayList<Player> players = new ArrayList<>();
        LinkedList<String> chars;
//        Scanner in = new Scanner(System.in);
        Dice dice = new Dice();
//        GameBoardUIController boardControl = (GameBoardUIController)loader.getController();
        int playerAmount = numOfPlayers;
        chars = Characters.getRandChars(numOfPlayers);
        karma = new int[playerAmount];

        for (int i = 0; i < playerAmount; i++)
            karma[i] = 0;
        

        UserPlayer playerHuman1 = new UserPlayer(chars.pop(), "Sheriff", "is good guy :D", 7, 0);
        players.add(playerHuman1);
        PlayerWithStrategy playerComp1 = new PlayerWithStrategy(chars.pop(), "Renegade", "description", 4, 1,karma);
        players.add(playerComp1);
        PlayerWithStrategy playerComp2 = new PlayerWithStrategy(chars.pop(), "Outlaw", "description", 4, 2, karma);
        players.add(playerComp2);
        PlayerWithStrategy playerComp3 = new PlayerWithStrategy(chars.pop(), "Outlaw", "description", 4, 3, karma);
        players.add(playerComp3);
        PlayerWithStrategy playerComp4 = new PlayerWithStrategy(chars.pop(), "Deputy", "noob", 4, 4, karma);
        players.add(playerComp4);
        //isDepDead=1;    //this needs to track how may deputy are alive <----important
        //TODO-- change final argument to whichever player is the sheriff
        Game bangGame = new Game(players, boardControl, playerHuman1,playerHuman1);
        GameBoardUIController.setGame(bangGame);
        PlayerController playerController = new PlayerController(playerHuman1,bangGame,boardControl,dice);
        
//        boardControl.setSheriffLabel(bangGame);
        GameBoardUIController.setPlayerController(playerController);
        GameBoardUIController.update(boardControl);

        GameBoardUIController.setGame(bangGame);
//        Player winner = bangGame.winner(); 
//        System.out.println("The winner is: " + winner.getName());
//        }
//        else
//           System.out.println("Wrong number!! Please do it again");
    }
    
}
