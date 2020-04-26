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

//TODO: Fix issues with getting dice

class UserPlayer implements Player{  
    // HI
    private String name = "";
    private String description = "";
    private String role = "";
    private int health;
    private int arrows;
    private PlayerObserver controller; // Observer this Player reports to.
    
    
    public UserPlayer(String playerName, String playerRole, String playerDescription, int playerHealth, int playerArrows){
        this.name = playerName;
        this.role = playerRole;
        this.description = playerDescription;
        this.health = playerHealth;
        this.arrows = playerArrows;
        this.controller = null;
    }
    
    public int getHealth() {
        return health;
    }

    
    public void setHealth(int health) {
        this.health = health;
    }

    
    public String getRole() {
        return this.role;
    }

    
    public void setRole(String role) {
        this.role = role;
    }

    
    public String getDescription() {
        return this.description;
    }

    
    public void setDecription(String descrip) {
        this.description = descrip;
    }

    
    public int getArrows() {
        return this.arrows;
    }

    
    public void setArrows(int arrows) { 
        this.arrows = arrows;
    }
    
    
    public void takeTurn () {
        System.out.println("Rolling Dice for " + this.name);
        Dice.firstRoll();
        
        
    if (controller != null)
        //controller.update(this, dice);    // numberToTake set here
        System.out.println("oof"); // having issues with getting dice
  }
    
    
    
    // Set the PlayerObserver this InteractivePlayer is to report to.
    public void register (PlayerObserver controller){
        this.controller = controller;
    }
    
    
}