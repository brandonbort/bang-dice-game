/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;
import java.util.*;
/**
 *
 * @author sloan
 */

//TODO: Fix issues with getting dice

class UserPlayer implements Player{  
    private String name = "";
    private String description = "";
    private String role = "";
    private int health;
    private int arrows;
    private int spot;
    private PlayerObserver controller; // Observer this Player reports to.
    
    
    public UserPlayer(String playerName, String playerRole, String playerDescription, int playerHealth, int spot){
        this.name = playerName;
        this.role = playerRole;
        this.description = playerDescription;
        this.health = playerHealth;
        this.spot = spot;
        this.arrows = 0;
        this.controller = null;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getHealth() {
        return health;
    }

    
    public void setHealth(int health) {
        this.health = health;
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
    System.out.println("Rolling Dice for " + this.name);
    Dice dice = new Dice(Dice.Dice_Face.getRandomDice_Face());
    if (controller != null)
        controller.update(this, dice);    // numberToTake set here
    }
    
    public void takeAim1() {
        
        Scanner in = new Scanner(System.in);
        ArrayList<Player> currentPlayers = new ArrayList<>();
        currentPlayers = Game.getPlayers();
        int placement = 0;
        int amount = currentPlayers.size() - 1;
        
        
        for (int i = 0; i < currentPlayers.size(); i++)
        {
            Player temp = currentPlayers.get(i);
            if (this == temp)
            {
                placement = i;
            }
        }
        
        ArrayList<Player> attack = new ArrayList<>();
        
        if((placement - 1) < 0){
            attack.add(currentPlayers.get(amount));
            attack.add(currentPlayers.get(1));
        }
        else if ((placement + 1) >= currentPlayers.size()){
            attack.add(currentPlayers.get(amount-1));
            attack.add(currentPlayers.get(0));
        }
        else{
            attack.add(currentPlayers.get(placement + 1));
            attack.add(currentPlayers.get(placement - 1));
        }
        System.out.println("Who would you like to attack?");
        System.out.println("Option 1: " + attack.get(0));
        System.out.println("Option 2: " + attack.get(1));
        
        int who = in.nextInt();
        int health = 0;
        switch (who) {
            case 1:
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                break;
            case 2:
                health = attack.get(1).getHealth();
                health = health - 1;
                attack.get(1).setHealth(health);
                System.out.println(attack.get(1).getName() + " has lost 1 health!");
                break;
            default:
                System.out.println("Did not enter a valid option... Try again.");
                this.takeAim1();
                break;
        }
        
    }
    
    public void takeAim2() {
        
        Scanner in = new Scanner(System.in);
        ArrayList<Player> currentPlayers = new ArrayList<>();
        currentPlayers = Game.getPlayers();
        int placement = 0;
        int amount = 0;
        
        
        for (int i = 0; i < currentPlayers.size(); i++)
        {
            amount = amount + 1;
            Player temp = currentPlayers.get(i);
            if (this == temp)
            {
                placement = i;
            }
        }
        
        ArrayList<Player> attack = new ArrayList<>();
        
        if(((placement - 2) < 0) && ((placement - 1) < 0))
        {
            attack.add(currentPlayers.get(amount));
            attack.add(currentPlayers.get(amount-1));
            attack.add(currentPlayers.get(1));
            attack.add(currentPlayers.get(2));
        }
        else if (((placement - 2) < 0) && ((placement - 1) == 0))
        {
            attack.add(currentPlayers.get(amount));
            attack.add(currentPlayers.get(0));
            attack.add(currentPlayers.get(2));
            attack.add(currentPlayers.get(3));
        }
        else if (((placement + 2) >= currentPlayers.size()) && ((placement + 1) >= currentPlayers.size())){
            attack.add(currentPlayers.get(amount-1));
            attack.add(currentPlayers.get(amount-2));
            attack.add(currentPlayers.get(0));
            attack.add(currentPlayers.get(1));
        }
        else if (((placement + 2) >= currentPlayers.size()) && ((placement + 1) == (currentPlayers.size()- 2))){
            attack.add(currentPlayers.get(amount-2));
            attack.add(currentPlayers.get(amount-3));
            attack.add(currentPlayers.get(amount));
            attack.add(currentPlayers.get(0));
        }
        else
        {
            attack.add(currentPlayers.get(placement + 1));
            attack.add(currentPlayers.get(placement + 2));
            attack.add(currentPlayers.get(placement - 1));
            attack.add(currentPlayers.get(placement - 2));
        }
        System.out.println("Who would you like to attack?");
        System.out.println("Option 1: " + attack.get(0));
        System.out.println("Option 2: " + attack.get(1));
        System.out.println("Option 3: " + attack.get(2));
        System.out.println("Option 4: " + attack.get(3));
        
        int who = in.nextInt();
        int health = 0;
       
        switch (who) {
            case 1:
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                break;
            case 2:
                health = attack.get(1).getHealth();
                health = health - 1;
                attack.get(1).setHealth(health);
                System.out.println(attack.get(1).getName() + " has lost 1 health!");
                break;
            case 3:
                health = attack.get(2).getHealth();
                health = health - 1;
                attack.get(2).setHealth(health);
                System.out.println(attack.get(2).getName() + " has lost 1 health!");
                break;
            case 4:
                health = attack.get(3).getHealth();
                health = health - 1;
                attack.get(3).setHealth(health);
                System.out.println(attack.get(3).getName() + " has lost 1 health!");
                break;
            default:
                System.out.println("Did not enter a valid option... Try again.");
                this.takeAim2();
                break;
        } 
    }
    
    public void gatlingDice(){
        ArrayList<Player> attack = new ArrayList<>();
        attack = Game.getPlayers();
        
        int health;
        
        for (int i = 0; i < attack.size(); i++){
            if (this == attack.get(i))
            {
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
        }
        
        this.setArrows(0);
        System.out.println(this.getName() + " no longer has any arrows!");
    }
    
    public void beerDice() {
       Scanner in = new Scanner(System.in);
       ArrayList<Player> heal = new ArrayList<>();
       heal = Game.getPlayers();
       int health;
       
       System.out.println("Who would you like to heal?");
       for (int i = 0; i < heal.size(); i++){
          System.out.println("Option " + (i + 1) + ": " + heal.get(i).getName()); 
       }
       
       int who = in.nextInt();
       
       for (int i = 0; i < heal.size(); i++){
           if (who == i){
               health = 0;
               health = heal.get(i).getHealth();
               health = health - 1;
               heal.get(i).setHealth(health);
               System.out.println(heal.get(i).getName() + " has gained 1 health!");
           }
       }
       if ((who > heal.size()) || (who <= 0)){
           System.out.println("Did not enter a valid option... Try again.");
           this.beerDice();
       }
    }
    
    
    // Set the PlayerObserver this InteractivePlayer is to report to.
    public void register (PlayerObserver controller){
        this.controller = controller;
    }
    
    
}