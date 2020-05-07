/**
 * Public
 * 
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
       Scanner in = new Scanner(System.in);
       System.out.println("Please enter the amount of players you want (3-7 players): ");
       int playerAmount = in.nextInt();
       if(playerAmount >= 3 && playerAmount <=7)
           newGame(playerAmount);
    }
    
    public static void newGame(int numOfPlayers) throws FileNotFoundException{
        ArrayList<Player> players = new ArrayList<>();
        LinkedList<String> chars;

        Dice dice = new Dice();

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

        Game bangGame = new Game(players);
        
        new PlayerController(playerHuman1,bangGame,dice);
        
        while(!bangGame.gameOver()){
            bangGame.play();
        }

        Player winner = bangGame.winner(); 
        System.out.println("The winner is: " + winner.getName());
        
        
    }
    
}