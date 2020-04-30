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
        int numArrows = player.getArrows();
        player.setArrows(numArrows);
        
        int numHealth = player.getHealth();
        player.setHealth(numHealth);
        
        String description = player.getDescription();
        player.setDecription(description);
        
        String role = player.getRole();
        player.setRole(role);
        dice.firstRoll();
        dice.reRoll();
        }
         
}