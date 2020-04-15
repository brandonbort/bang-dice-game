/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

/**
 *
 * @author sloan
 */

class UserPlayer implements Player{  
    
    String name = "";
    String description = "";
    String role = "";
    int health;
    int arrows;
    
    
    public UserPlayer(String playerName, String playerRole, String playerDescription, int playerHealth, int playerArrows){
        name = playerName;
        role = playerRole;
        description = playerDescription;
        health = playerHealth;
        arrows = playerArrows;
    }
    
    public int getHealth() {
        return health;
    }

    
    public void setHealth(int health) {
        this.health = health;
    }

    
    public String getRole() {
        return role;
    }

    
    public void setRole(String role) {
        this.role = role;
    }

    
    public String getDescription() {
        return description;
    }

    
    public void setDecription(String descrip) {
        this.description = descrip;
    }

    
    public int getArrows() {
        return arrows;
    }

    
    public void setArrows(int arrows) { 
        this.arrows = arrows;
    }
}