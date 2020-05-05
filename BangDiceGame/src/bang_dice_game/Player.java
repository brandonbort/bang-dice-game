package bang_dice_game;

/**
 *
 * @author sloan
 */
public interface Player {
    public String getName();
    public void setName(String name);
    
    public int getHealth();
    public void setHealth(int health);
    
    public String getRole();
    public void setRole(String role);
    
    public String getDescription();
    public void setDescription(String descrip);
    
    public int getArrows();
    public void setArrows(int arrows);

    public void takeTurn();

    public int getSpot();
    public void setSpot(int spot);

    public int[] getKarma();
    public void setKarma(int [] karma);
}