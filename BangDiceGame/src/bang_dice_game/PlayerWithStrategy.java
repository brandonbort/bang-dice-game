/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import java.util.Arrays;

/**
 *
 * @author carlos144green
 */

//I have no idea what im doing so edit to ur content
class PlayerWithStrategy implements Player{

    private String name = "";
    private String role = "";
    private String description = "";
    private int health = 0;
    private int arrows = 0;
    private int spot = 0;
    //private PlayStrategy strategy;
    private int playerSize;
    private PlayerObserver controller;  //I think this controls when its the NPC's turn
    char[][] karma = new char[playerSize][playerSize];
    
  /**
   * Create a NPC with the specified name, role, description, health, arrows, and strategy.
   */
  public PlayerWithStrategy(String name, String role, String description, int health, int arrows,int spot, int playerSize){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.arrows = 0;                //arrows should always start at 0 but ill include it here anyways
        //this.strategy= strategy;        //assign a strategy to the NPC
        this.controller = null;         //I think this controls when its the NPC's turn
        this.playerSize = playerSize;
        for (int i=0; i<karma.length; i++)//this sets all non diagonal numbers to 5
        {
            for (int j=0; j<karma.length; j++)
            {
                if(i==j)    //if numbers match(diagonal number) dont set to 5
                    karma[i][j]='x';
                else
                    karma[i][j]='5';
            }
        }
        for (int i=0; i<karma.length; i++)//this sets all non diagonal numbers to 5
        {
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]);
            System.out.print("\n");
        }
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
    public void setDescription(String descrip) {
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
    /*
    public PlayStrategy getStrategy() {
        return this.strategy;
    }
    public void setStrategy(PlayStrategy strategy) { 
        this.strategy = strategy;
    }

*/
    public void takeTurn () {
        
        System.out.println("Roling Dice for " + this.name);
        AI NPC = new AI();
        if (null != this.role) switch (this.role) {
            case "Sheriff":
                NPC.Beer(karma,spot,0);
                break;
            case "Deputy":
                NPC.Beer(karma,spot,1);
                break;
            case "Outlaw":
                NPC.Beer(karma,spot,2);
                break;
            case "Renegade":
                NPC.Beer(karma,spot,3);
                break;
            default:
                System.out.println("Something went wrong on " + this.name + "'s turn");
                break;
        }
        else
            System.out.println("Invalid Role for" + this.name);
  }
}


