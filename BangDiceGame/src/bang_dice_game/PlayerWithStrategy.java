package bang_dice_game;
/**
 *
 * @author carlos144green
 */
class PlayerWithStrategy implements Player{

    private String name = "";
    private String role = "";
    private String description = "";
    private int health = 0;
    private int arrows = 0;
    private int spot = 0;
    private int playerSize;
    private PlayerObserver controller;  //I think this controls when its the NPC's turn
    char[][] karma = new char[playerSize][playerSize];
    

  public PlayerWithStrategy(String name, String role, String description, int health, int arrows,int spot, int playerSize){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.arrows = 0;                    //arrows should always start at 0 but ill include it here anyways
        this.spot = spot;
        this.controller = null;             //I think this controls when its the NPC's turn
        this.playerSize = playerSize;
        for (int i=0; i<karma.length; i++)  //this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                if(i==j)                    //if numbers match(diagonal number) dont set to 5
                    karma[i][j]='x';
                else
                    karma[i][j]='5';
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
    
    public int getSpot() {
        return this.spot;
    }
    public void setSpot(int spot) {
        this.spot = spot;
    }

    public void takeTurn () {
        
        System.out.println("Roling Dice for " + this.name);
        AI NPC = new AI();
        if (null != this.role) switch (this.role) {
            case "Sheriff":
                NPC.Beer(karma,spot,0);
                NPC.Bang(karma,spot,0,1);       //1=range of 1
                NPC.Bang(karma,spot,0,2);       //2=range of 2
                break;
            case "Deputy":
                NPC.Beer(karma,spot,1);
                NPC.Bang(karma,spot,1,1);       //1=range of 1
                NPC.Bang(karma,spot,1,2);       //2=range of 2
                break;
            case "Outlaw":
                NPC.Beer(karma,spot,2);
                NPC.Bang(karma,spot,2,1);       //1=range of 1
                NPC.Bang(karma,spot,2,2);       //2=range of 2
                break;
            case "Renegade":
                NPC.Beer(karma,spot,3);
                NPC.Bang(karma,spot,3,1);       //1=range of 1
                NPC.Bang(karma,spot,3,2);       //2=range of 2
                break;
            default:
                System.out.println("Something went wrong on " + this.name + "'s turn");
                break;
        }
        else
            System.out.println("Invalid Role for" + this.name);
  }
}


