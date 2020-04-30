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
    private String description = "";
    private String role = "";
    private int health = 0;
    private int arrows = 0;
    private PlayStrategy strategy;
  
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
    
    public PlayStrategy getStrategy() {
        return this.strategy;
    }
    public void setStrategy(PlayStrategy strategy) { 
        this.strategy = strategy;
    }
  
  /**
   * Take a turn: remove sticks from the specified
   * Pile. maxOnATurn is the maximum number of sticks
   * a Player can remove on a turn. A Player will
   * remove at least one stick.
   * @require    pile.sticks() > 0
   *             maxOnATurn > 0
   * @ensure     1 <= this.sticksTaken() &&
   *             this.sticksTaken() <= maxOnATurn &&
   *             pile.sticks() == old.pile.sticks() -
   *             this.sticksTaken()
   */
  public void takeTurn (Pile pile, int maxOnATurn) {
    int number = strategy.numberToTake(pile, maxOnATurn);
    pile.remove(number);
    this.sticksTaken = number;
  }
}


