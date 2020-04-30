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
class PlayerWithStrategy {

    private int getHealth;
    private String getRole;
    private String getDescription;
    private int getArrows;
    private PlayStrategy strategy;
  
  /**
   * Create a new Player with the specified name and strategy.
   */
  public PlayerWithStrategy (String getDescription, PlayStrategy strategy) {
    this.name = name;
    this.strategy = strategy;
    this.sticksTaken = 0;
  }
  
  /**
   * This Player's name.
   */
  public String name () {
    return this.name;
  }
  
  /**
   * Number of sticks removed on this Player's most
   * recent turn. Returns 0 if this Player has not yet
   * taken a turn.
   * @ensure     this.sticksTaken() >= 0
   */
  public int sticksTaken () {
    return this.sticksTaken();
  }
  
  /**
   * Set the play strategy for this Player.
   */
  public void setStrategy (PlayStrategy strategy) {
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


