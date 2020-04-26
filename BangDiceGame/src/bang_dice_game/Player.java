  
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
    
    
    public int getHealth();
    public void setHealth(int health);
    
    public String getRole();
    public void setRole(String role);
    
    public String getDescription();
    public void setDecription(String descrip);
    
    public int getArrows();
    public void setArrows(int arrows);

    public void takeTurn();
    
}