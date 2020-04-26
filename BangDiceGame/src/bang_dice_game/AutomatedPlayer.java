/**
 * AUTHOR: Carlos Cuartas
 * CONTRIBUTORS: Aaron Sloan
 *              - Added the basic setup for takeTurn Method
 * 
 */
package bang_dice_game;

/**
 *
 * @author carlos144green
 */

//TODO: finish takeTurn method
public class AutomatedPlayer implements Player {
    
    private String name = "";
    private String description = "";
    private String role = "";
    private int health;
    private int arrows;
    
    
    public AutomatedPlayer(String playerName, String playerRole, String playerDescription, int playerHealth, int playerArrows){
        this.name = playerName;
        this.role = playerRole;
        this.description = playerDescription;
        this.health = playerHealth;
        this.arrows = playerArrows;
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
