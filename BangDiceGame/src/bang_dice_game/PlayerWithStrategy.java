/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

/**
 *
 * @author carlos144green
 */

//I have no idea what im doing so edit to ur content
class PlayerWithStrategy {

    private String name = "";
    private String role = "";
    private String description = "";
    private int health = 0;
    private int arrows = 0;
    private PlayStrategy strategy;
    private PlayerObserver controller;  //I think this controls when its the NPC's turn
  /**
   * Create a NPC with the specified name, role, description, health, arrows, and strategy.
   */
  public PlayerWithStrategy(String name, String role, String description, int health, int arrows, PlayStrategy strategy){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.arrows = arrows;       //arrows should always start at 0 but ill include it here anyways
        this.strategy= strategy;    //assign a strategy to the NPC
        this.controller = null;     //I think this controls when its the NPC's turn
    }
  
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
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
 
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getArrows() {
        return this.arrows;
    }
    public void setArrows(int arrows) { 
        this.arrows = arrows;
    }
    
    public PlayStrategy getStrategy() {
        return this.strategy;
    }
    public void setStrategy(PlayStrategy strategy) { 
        this.strategy = strategy;
    }
    public void takeTurn () {
        
        System.out.println("Roling Dice for " + this.name);
        
        if (null != this.role) switch (this.role) {
            case "Sheriff":
                // go to certain method in AI class
                break;
            case "Renegade":
                // go to certain method in AI class
                break;
            case "Outlaw":
                // go to certain method in AI class
                break;
            case "Deputy":
                // go to certain method in AI class
                break;
            default:
                // go to certain method in AI class
                break;
        }
        else
            System.out.println("Invalid Role for" + this.name);
  }
}


