/**
 * Aaron Developed Code
 * Brandon assisted
 */
package bang_dice_game;
import static java.lang.Thread.sleep;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserPlayer implements Player{  
    private String name = "";
    private String description = "";
    private String role = "";
    private int health;
    private int maxHealth;
    private int arrows;
    private int spot;
    private PlayerObserver controller; // Observer this Player reports to.
    
    public UserPlayer(String name, String role, String description, int health, int spot){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.maxHealth = health;
        this.spot = spot;
        this.arrows = 0;
        this.controller = null;
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
    public int getHealth() {
        return health;
    }
    @Override
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public int getMaxHealth() {
        return maxHealth;
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
    
    @Override
    public int[] getKarma() {
       return null;
    }

    @Override
    public void setKarma(int[] karma) {
    }
    @Override
    public void takeTurn () {
        System.out.println("Rolling Dice for " + this.name);
        //Dice dice;
        //dice = new Dice(Dice.Dice_Face.getRandomDice_Face());
        if (controller != null)
            controller.update(this);//, dice);    // numberToTake set here    
    }
    
    public void takeAim1() {
        Scanner in = new Scanner(System.in);
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        int amount = currentPlayers.size() - 1;
        int[] karmaAdjust;
        int gringoCount = 0;
        
        ArrayList<Player> attack = new ArrayList<Player>();
        
        attack.add(currentPlayers.get(amount));
        attack.add(currentPlayers.get(1));
        
        if (currentPlayers.size() == 2)
            attack.remove(1);
        
        System.out.println("Who would you like to attack?");
        for (int i = 0; i < attack.size(); i++)
            System.out.println((i+1) + ":   " +attack.get(i).getName() + "  " + attack.get(i).getHealth());
        
        System.out.print("Please enter one of the options: "); 
        
        for (int i = 0; i < attack.size(); i++)
            System.out.print(i+1 + " ");
        
        int who = in.nextInt();
        int health = 0;
        switch (who) {
            case 1:
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(0).getKarma();
                karmaAdjust [this.getSpot()] = karmaAdjust [this.getSpot()] + 1;
                attack.get(0).setKarma(karmaAdjust);
                if("ElGringo".equals(attack.get(0).getName())){
                    gringoCount =gringoCount + 1;
                }
                if("PedroRamirez".equals(attack.get(0).getName())){
                    if(attack.get(0).getArrows() != 0){
                            int arrows = attack.get(0).getArrows();
                            arrows = arrows - 1;
                            attack.get(0).setArrows(arrows);
                            System.out.println(this.getName() + " has lost 1 arrow! From: PedroRamirez >-<");
                            int gameArrows = Game.getGameArrows();
                            gameArrows = gameArrows + 1;
                            Game.setGameArrows(gameArrows);
                            System.out.println("There are only " + gameArrows + " arrow(s) left!");
                    }
                }                
                break;
            case 2:
                health = attack.get(1).getHealth();
                health = health - 1;
                attack.get(1).setHealth(health);
                System.out.println(attack.get(1).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(1).getKarma();
                karmaAdjust [this.getSpot()] = karmaAdjust [this.getSpot()] + 1;
                attack.get(1).setKarma(karmaAdjust);
                if("ElGringo".equals(attack.get(0).getName())){
                    gringoCount =gringoCount + 1;
                }
                if("PedroRamirez".equals(attack.get(1).getName())){
                    if(attack.get(1).getArrows() != 0){
                            int arrows = attack.get(1).getArrows();
                            arrows = arrows - 1;
                            attack.get(1).setArrows(arrows);
                            System.out.println(this.getName() + " has lost 1 arrow! From: PedroRamirez >-<");
                            int gameArrows = Game.getGameArrows();
                            gameArrows = gameArrows + 1;
                            Game.setGameArrows(gameArrows);
                            System.out.println("There are only " + gameArrows + " arrow(s) left!");
                    }
                }                
                break;
            default:
                System.out.println("Did not enter a valid option... Try again.");
                try {
                    sleep(1000);
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }                
                this.takeAim1();
                break;
        }
        if(gringoCount >= 1){
            int arrows = this.getArrows();
            arrows = arrows + 1;
            this.setArrows(arrows);
            System.out.println(this.getName() + " has gained 1 arrow! From ElGringo >_<");
            int gameArrows = Game.getGameArrows();
            gameArrows = gameArrows - 1;
            Game.setGameArrows(gameArrows);
            System.out.println("There are only " + gameArrows + " arrow(s) left!");
        }
        try {
            sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void takeAim2() {   
        Scanner in = new Scanner(System.in);
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        int amount = currentPlayers.size() - 1;
        int[] karmaAdjust; 
        int gringoCount = 0;
        int pedroCount = 0;
        
        ArrayList<Player> attack = new ArrayList<Player>();
        
        attack.add(currentPlayers.get(amount-1));
        attack.add(currentPlayers.get(2));
        
        if(currentPlayers.size() == 4)
        {
            attack.remove(1);
        }
        
        System.out.println("Who would you like to attack?");
        for (int i = 0; i < attack.size(); i++)
            System.out.println((i+1) + ":   " + attack.get(i).getName() + "  " + attack.get(i).getHealth());
        
        System.out.print("Please enter one of the options: "); 
        for (int i = 0; i < attack.size(); i++)
            System.out.print(i+1 + " ");
        
        System.out.println();
        
        int who = in.nextInt();
        int health = 0;
       
        switch (who) {
            case 1:
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(0).getKarma();
                karmaAdjust [this.getSpot()] = karmaAdjust [this.getSpot()] + 1;
                attack.get(0).setKarma(karmaAdjust);
                if("ElGringo".equals(attack.get(0).getName()))
                    gringoCount = gringoCount + 1;
                if("PedroRamirez".equals(attack.get(0).getName())){
                    if(attack.get(0).getArrows() != 0){
                            int arrows = attack.get(0).getArrows();
                            arrows = arrows - 1;
                            attack.get(0).setArrows(arrows);
                            System.out.println(this.getName() + " has lost 1 arrow! From: PedroRamirez >-<");
                            int gameArrows = Game.getGameArrows();
                            gameArrows = gameArrows + 1;
                            Game.setGameArrows(gameArrows);
                            System.out.println("There are only " + gameArrows + " arrow(s) left!");
                    }
                }
                break;
            case 2:
                health = attack.get(1).getHealth();
                health = health - 1;
                attack.get(1).setHealth(health);
                System.out.println(attack.get(1).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(1).getKarma();
                karmaAdjust [this.getSpot()] = karmaAdjust [this.getSpot()] + 1;
                attack.get(1).setKarma(karmaAdjust);
                if("ElGringo".equals(attack.get(1).getName()))
                    gringoCount = gringoCount + 1;
                if("PedroRamirez".equals(attack.get(1).getName())){
                    if(attack.get(1).getArrows() != 0){
                            int arrows = attack.get(1).getArrows();
                            arrows = arrows - 1;
                            attack.get(1).setArrows(arrows);
                            System.out.println(this.getName() + " has lost 1 arrow! From: PedroRamirez >-<");
                            int gameArrows = Game.getGameArrows();
                            gameArrows = gameArrows + 1;
                            Game.setGameArrows(gameArrows);
                            System.out.println("There are only " + gameArrows + " arrow(s) left!");
                    }
                }
                break;
            default:
                System.out.println("Did not enter a valid option... Try again.");
                try {
                    sleep(1000);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }                
                this.takeAim2();
                break;
        }
        if(gringoCount >= 1){
            int arrows = this.getArrows();
            arrows = arrows + 1;
            this.setArrows(arrows);
            System.out.println(this.getName() + " has gained 1 arrow! From ElGringo >_<");
            int gameArrows = Game.getGameArrows();
            gameArrows = gameArrows - 1;
            Game.setGameArrows(gameArrows);
            System.out.println("There are only " + gameArrows + " arrow(s) left!");
        }
        try {
            sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void gatlingDice(){
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        ArrayList<Player> attack = new ArrayList<Player>();
        
        int health;
        
        for (int i = 0; i < currentPlayers.size(); i++)
            if (this != currentPlayers.get(i))
                attack.add(currentPlayers.get(i));  
        for(int i = 0; i < attack.size(); i++){
            if("PaulRegret".equals(attack.get(i).getName())){
                attack.remove(i);
                break;
            }
        }

        for (int i = 0; i < attack.size(); i++){
            health = 0;
            health = attack.get(i).getHealth();
            health = health - 1;
            attack.get(i).setHealth(health);
            System.out.println(attack.get(i).getName() + " has lost 1 health!");
            try {
                sleep(1000);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        int gameArrows = Game.getGameArrows();
        int userArrows = this.getArrows();
        gameArrows = gameArrows + userArrows;
        Game.setGameArrows(gameArrows);
        this.setArrows(0);
        System.out.println(this.getName() + " no longer has any arrows!");
        System.out.println("There are now " + gameArrows + " arrows left!");
        try {
            sleep(1000);
        }
        catch (InterruptedException ex) {
            Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
    
    public void beerDice() {
        Scanner in = new Scanner(System.in);
        ArrayList<Player> heal = new ArrayList<Player>();
        heal = Game.getPlayers();
        int health;
        int[] karmaAdjust; 
        
        for (int i = 0; i < heal.size(); i++)
            if (heal.get(i).getHealth() == 0)
                heal.remove(i);
       
        System.out.println("Who would you like to heal?");
        for (int i = 0; i < heal.size(); i++){
            System.out.println((i + 1) + ":  " + heal.get(i).getName() + "  " + heal.get(i).getHealth()); 
        }
       
        int who = in.nextInt();
       
        for (int i = 0; i < heal.size(); i++){
            if (who == (i+1)){ 
                if (heal.get(i).getMaxHealth() != heal.get(i).getHealth()){
                    health = 0;
                    health = heal.get(i).getHealth();
                    health = health + 1;
                    heal.get(i).setHealth(health);
                    System.out.println(heal.get(i).getName() + " has gained 1 health!");
                }
                else{
                    System.out.println(heal.get(i).getName() + "'s health is already full!!");
                }
                if (this != heal.get(i)){
                    karmaAdjust = heal.get(i).getKarma();
                    karmaAdjust [this.getSpot()] = karmaAdjust [this.getSpot()] - 1;
                    heal.get(i).setKarma(karmaAdjust); 
                }
                try {
                    sleep(1000);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if ((who > heal.size()) || (who <= 0)){
            System.out.println("Did not enter a valid option... Try again.");
                try {
                    sleep(1000);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(UserPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }           
            this.beerDice();
        }
    }
    // Set the PlayerObserver this InteractivePlayer is to report to.
    public void register (PlayerObserver controller){
        this.controller = controller;
    }
}
