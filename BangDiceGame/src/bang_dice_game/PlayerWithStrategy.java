package bang_dice_game;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private char [][]karma;
    private PlayerObserver controller;  //I think this controls when its the NPC's turn
    
    
    //karma only needs one instance so idk if this will keep it like that
/**
 * 
 * @param name          //  Player Name
 * @param role          //  Sheriff, Deputy, Outlaw, or Renegade
 * @param description   //  Atm idk
 * @param health        //  Current HP
 * @param arrows        //  Current arrow count
 * @param spot          //  Location on karma array
 * @param playerSize    //  Atm its used to set up karma... for now
 */
  public PlayerWithStrategy(String name, String role, String description, int health, int arrows,int spot, char[][] karma){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.arrows = 0;                    //arrows should always start at 0 but ill include it here anyways
        this.spot = spot;
        this.controller = null;             //I think this controls when its the NPC's turn
        this.karma=karma;
        for (int i=0; i<karma.length; i++)  //this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                if(i==j)                    //if numbers match(diagonal number) dont set to 5
                    karma[i][j]='x';
                else
                    karma[i][j]='5';
        //System.out.print(karma.length);
    }
    
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
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
    public void setDescription(String descrip) {
        this.description = descrip;
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
    public int getArrows() {
        return this.arrows;
    }
    @Override
    public void setArrows(int arrows) { 
        this.arrows = arrows;
    }
    @Override
    public int getSpot() {
        return this.spot;
    }
    @Override
    public void setSpot(int spot) {
        this.spot = spot;
    }
    
    public char [][] getKarma() {
        return this.karma;
    }
    public void setKarma(char [][] karma) {
        this.karma = karma;
    }
    @Override
    public void takeTurn () {
        System.out.println("Roling Dice for " + this.name);
            try {
                sleep(1000);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
            }        
        int targetKarmaSpot;
        int points;
        
        
                for (int i=0; i<karma.length; i++)
        {//this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+" ");
            System.out.print("\n");
        }
        if (null != this.role)
            switch (this.role) {
                case "Sheriff":
                    
                    targetKarmaSpot=AI.Beer(karma,spot,0,health);  //these all return spot values so yea
                    if(targetKarmaSpot!=spot)
                    {
                        points=Character.getNumericValue(karma[targetKarmaSpot][spot])+1;
                        karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    }
                    
                    
                                    for (int i=0; i<karma.length; i++)
        {//this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+" ");
            System.out.print("\n");
        }
                    
                    
                    
                    targetKarmaSpot=AI.Bang(karma,spot,0,1);       //1=range of 1 and not range of 2
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    
                    
                                    for (int i=0; i<karma.length; i++)
        {//this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+" ");
            System.out.print("\n");
        }
                    
                    
                    targetKarmaSpot=AI.Bang(karma,spot,0,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    break;
                case "Deputy":
                    targetKarmaSpot=AI.Beer(karma,spot,1,health);  //these all return spot values so yea
                    if(targetKarmaSpot!=spot)
                    {
                        points=Character.getNumericValue(karma[targetKarmaSpot][spot])+1;
                        karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    }
                    
                    targetKarmaSpot=AI.Bang(karma,spot,1,1);       //1=range of 1 and not range of 2
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    
                    targetKarmaSpot=AI.Bang(karma,spot,1,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    break;
                case "Outlaw":
                    targetKarmaSpot=AI.Beer(karma,spot,2,health);  //these all return spot values so yea
                    if(targetKarmaSpot!=spot)
                    {
                        points=Character.getNumericValue(karma[targetKarmaSpot][spot])+1;
                        karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    }
                    
                                    for (int i=0; i<karma.length; i++)
        {//this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+" ");
            System.out.print("\n");
        }
                    
                    
                    targetKarmaSpot=AI.Bang(karma,spot,2,1);       //1=range of 1 and not range of 2
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    
                    
                    
                                    for (int i=0; i<karma.length; i++)
        {//this sets all non diagonal numbers to 5
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+" ");
            System.out.print("\n");
        }
                
                    targetKarmaSpot=AI.Bang(karma,spot,2,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    break;
                case "Renegade":
                    targetKarmaSpot=AI.Beer(karma,spot,3,health);  //these all return spot values so yea
                    if(targetKarmaSpot!=spot)
                    {
                        points=Character.getNumericValue(karma[targetKarmaSpot][spot])+1;
                        karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    }
                    
                    
                                for (int i=0; i<karma.length; i++)
                {//this sets all non diagonal numbers to 5
                    for (int j=0; j<karma.length; j++)
                        System.out.print(karma[i][j]+" ");
                    System.out.print("\n");
                }
        
                    
                    targetKarmaSpot=AI.Bang(karma,spot,3,1);       //1=range of 1 and not range of 2
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    
                    
                                for (int i=0; i<karma.length; i++)
                {//this sets all non diagonal numbers to 5
                    for (int j=0; j<karma.length; j++)
                        System.out.print(karma[i][j]+" ");
                    System.out.print("\n");
                }
        
                    
                    targetKarmaSpot=AI.Bang(karma,spot,3,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
                    points=Character.getNumericValue(karma[targetKarmaSpot][spot])-1;
                    System.out.print((char)points);
                    karma[targetKarmaSpot][spot]=Character.forDigit(points, 10);
                    break;
                default:
                    System.out.println("Something went wrong on " + this.name + "'s turn");
                    break;
            }
        else
            System.out.println("Invalid Role for" + this.name);
        
                    for (int i=0; i<karma.length; i++)
                {//this sets all non diagonal numbers to 5
                    for (int j=0; j<karma.length; j++)
                        System.out.print(karma[i][j]+" ");
                    System.out.print("\n");
                }
        
  }
}


