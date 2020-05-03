/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import java.util.*;

/**
 *
 * @author sloan
 */

class Game {
  
  private static ArrayList<Player> players = new ArrayList<Player>();
  private Player nextPlayer;                   // The Player whose turn is next.
  private Player previousPlayer;               // The Player who last played
  
  
 
  public Game (ArrayList<Player> players) { 
    this.players = players;
    this.nextPlayer = players.get(0);
    this.previousPlayer = null;
  }
  
  /**
   * The Player whose turn is next.
   */
  public Player nextPlayer () {
    return nextPlayer;
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
  
  /*// maybe idk
  public void setAlive(int alive){
      this.alive = alive;
  }
  // maybe idk
  public int getAlive(){
      return alive;
  }*/
  
      
  
  
  
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
  public void play () {
    if (!gameOver()) { 
      nextPlayer.takeTurn();
      //System.out.println(players);
      previousPlayer = nextPlayer;
      nextPlayer = otherPlayer(nextPlayer);
    }
    System.out.println();
    for(int i = 0; i < players.size(); i++){
        System.out.println(players.get(i).getName() + "  " + players.get(i).getHealth());
    }
    System.out.println();
    ArrayList<Player> died = new ArrayList<Player>();
    for (int i = 0; i < players.size(); i++){
        if (players.get(i).getHealth() <= 0){
            System.out.println(players.get(i).getName() + " has died!");
            died.add(players.get(i));
        }
    }
    for (int i = 0; i < died.size(); i++){
        players.remove(died.get(i));
    }
    System.out.println();
        
  }
  
  /**
   * The Player who is not the one specified.
   */
  private Player otherPlayer (Player player) {
      
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