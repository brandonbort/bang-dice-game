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
public interface Player {
    
    String name = "";
    String description = "";
    String role = "";
    int health = 0;
    int arrows = 0;
    
    
    public int getHealth();
    public void setHealth(int health);
    
    public String getRole();
    public void setRole(String role);
    
    public String getDescription();
    public void setDecription(String description);
    
    public int getArrow();
    public void setArrow(int arrows);
    
}
