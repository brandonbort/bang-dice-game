/**
 * Aaron Developed Code
 * Carlos & Brandon assisted
 */
package bang_dice_game;

import User_Interface_Components.GameBoardUIController;
import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sloan
 */

public class Game {
  
  private static ArrayList<Player> players = new ArrayList<Player>();
  private Player nextPlayer;                   // The Player whose turn is next.
  private Player previousPlayer;               // The Player who last played
  private static int gameArrows = 9;                      // total arrows in game
  private GameBoardUIController gameControl;
  private Player userPlayer;
  private Player sheriff;



 
  public Game (ArrayList<Player> players, GameBoardUIController gameControl, Player userPlayer, Player sheriff) { 
    this.players = players;
    this.nextPlayer = players.get(0);
    this.previousPlayer = null;
    this.gameControl = gameControl;
    this.userPlayer = userPlayer;
    this.sheriff = sheriff;
  }
  
  /**
   * The Player whose turn is next.
   */
  public Player nextPlayer () {
    return nextPlayer;
  }
  
  public Player getSheriff() {
      return sheriff;
  }
  
  public Player getUser(){
      return userPlayer;
  }
  
  /**
   * The Player who last played; returns null if no play has been made yet.
   */
  public Player previousPlayer () {
    return previousPlayer;
  }
  
  public static ArrayList<Player> getPlayers(){
      return Game.players;
  }
  public static void setPlayers(ArrayList<Player> players){
      Game.players = players;
  }
  
  public static int getGameArrows(){
      return Game.gameArrows;
  }
  public static void setGameArrows(int gameArrows){
      Game.gameArrows = gameArrows;
  }
  
      
  
  
  
  public Player winner () {
    if (gameOver()){
        
        return players.get(0);
//        for(int i = 0; i < players.size(); i++)
//        {
//            Player temp = players.get(i);
//            if (temp.getHealth() != 0)
//            {
//                return temp; 
//            }
//        }
    }
    
    return null;
  }
    
  /**
   * The game is over.
   */
  public boolean gameOver () {
      return players.size() == 1;
  }
  
  /**
   * Conduct a single move in the game, allowing the appropriate Player to
   * take a turn. Has no effect if the game is over.
   */
  public void play () throws FileNotFoundException {
    if (!gameOver()) { 
      System.out.println(nextPlayer.getName() + "'s TURN!!");
      nextPlayer.takeTurn();
      
      if (gameArrows == 0)
        {
             ArrayList<Player> attack = new ArrayList<Player>();
            for (int i = 0; i < players.size(); i++)
            {
                if (players.get(i).getArrows() >= 1)
                    attack.add(players.get(i));
            }
            for (int i = 0; i < attack.size(); i++)
            {
                int amount = attack.get(i).getArrows();
                if("Jourdonnais".equals(attack.get(0).getName()))
                    amount = 0;
                for (int j = 0; j < amount; j++)
                {
                    int health = attack.get(i).getHealth();
                    health = health - 1;
                    attack.get(i).setHealth(health);
                }
                attack.get(i).setArrows(0);
                System.out.println(attack.get(i).getName() + " has lost " + amount + " health!");
                System.out.println(attack.get(i).getName() + " has " + attack.get(i).getArrows() +" arrows!");
            }
            gameArrows = 9;
            try {
                    sleep(3000);
                }catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        for(int i = 0; i < players.size(); i++){
            System.out.println(players.get(i).getName() + "  " + players.get(i).getHealth());
        }
        System.out.println();

        ArrayList<Player> died = new ArrayList<Player>();
        Player temp = players.get(0);
        
        for (int i = 0; i < players.size(); i++)
            if("VultureSam".equals(players.get(i).getName()))
                temp = players.get(i);
        
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getHealth() <= 0){
                System.out.println(players.get(i).getName() + " has died!");
                died.add(players.get(i));
                if("VultureSam".equals(temp.getName())){
                    if(temp.getHealth() != temp.getMaxHealth()){
                        int health = temp.getHealth();
                        health = health + 1;
                        temp.setHealth(health);
                        System.out.println(players.get(i).getName() + " has gained 1 health!");
                    }
                }
            }
        }
        for (int i = 0; i < died.size(); i++)
            players.remove(died.get(i));

        System.out.println();

          previousPlayer = nextPlayer;
          nextPlayer = otherPlayer(nextPlayer);
        }
        System.out.println();
    
        
  }
  
  /**
   * The Player who is not the one specified.
   */
  public Player otherPlayer (Player player) {
      
      Player temp = player;
      int size = players.size() - 1;
    
    for (int i = 0; i < players.size(); i++)
    {
        if (temp == players.get(i)){
            if (temp == (players.get(size)))
                temp = players.get(0);
            else 
                temp = players.get(i+1);
            break; // breaks for loop
        }
    }
      return temp;
  }
  
}