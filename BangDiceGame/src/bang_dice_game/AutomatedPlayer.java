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


public class AutomatedPlayer implements Player {
    
    private String name = "";
    private String description = "";
    private String role = "";
    private int health;
    private int arrows;
    private PlayerObserver controller; // Observer this Player reports to.
    
    
    public AutomatedPlayer(String playerName, String playerRole, String playerDescription, int playerHealth, int playerArrows){
        this.name = playerName;
        this.role = playerRole;
        this.description = playerDescription;
        this.health = playerHealth;
        this.arrows = playerArrows;
        this.controller = null;
    }
    
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String getRole() {
        return this.role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDecription(String descrip) {
        this.description = descrip;
    }

    @Override
    public int getArrows() {
        return this.arrows;
    }

    @Override
    public void setArrows(int arrows) {
        this.arrows = arrows;//UwU
    }
    
}
