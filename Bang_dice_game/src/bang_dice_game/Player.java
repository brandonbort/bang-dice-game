/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

/**
 *
 * @author sloan
 */
public interface Player {
    
    /*String name = "";
    String description = "";
    String role = "";
    int health;
    int arrows;*/
    
    
    public int getHealth();
    public void setHealth(int healthP);
    
    public String getRole();
    public void setRole(String roleP);
    
    public String getDescription();
    public void setDecription(String descrip);
    
    public int getArrows();
    public void setArrows(int arrowsP);
    
}
