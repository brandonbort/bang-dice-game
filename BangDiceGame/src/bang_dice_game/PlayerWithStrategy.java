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
class PlayerWithStrategy {

    private String name = "";
    private String role = "";
    private String description = "";
    private int health = 0;
    private int arrows = 0;
    private PlayStrategy strategy;
    private int karma[][];
    private int playerSize;
    private PlayerObserver controller;  //I think this controls when its the NPC's turn
  /**
   * Create a NPC with the specified name, role, description, health, arrows, and strategy.
   */
  public PlayerWithStrategy(String name, String role, String description, int health, int arrows, PlayStrategy strategy, int playerSize){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.arrows = 0;                //arrows should always start at 0 but ill include it here anyways
        this.strategy= strategy;        //assign a strategy to the NPC
        this.controller = null;         //I think this controls when its the NPC's turn
        this.playerSize = playerSize;
        Arrays.fill(karma,null) ;  //this sets all to null *arrayList.set(0, null);* saving this 4 l8er
        for (int i=0; i<playerSize; i++)//this sets all non diagonal numbers to 0
        {
            for (int j=0; j<playerSize; j++)
            {
                if(i==j)    //if numbers match(diagonal number) dont set to 0
                    ;
                else
                    karma[i][j]=0;
            }
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
    
    public PlayStrategy getStrategy() {
        return this.strategy;
    }
    public void setStrategy(PlayStrategy strategy) { 
        this.strategy = strategy;
    }
    public void takeTurn () {
        
        System.out.println("Roling Dice for " + this.name);
        AI NPC = new AI();
        if (null != this.role) switch (this.role) {
            case "Sheriff":
                NPC.SheriffTurn();
                break;
            case "Renegade":
                NPC.RenegadeTurn();
                break;
            case "Outlaw":
                NPC.OutLawTurn();
                break;
            case "Deputy":
                NPC.DeputyTurn();
                break;
            default:
                System.out.println("Something went wrong on " + this.name + "'s turn");
                break;
        }
        else
            System.out.println("Invalid Role for" + this.name);
  }
}


