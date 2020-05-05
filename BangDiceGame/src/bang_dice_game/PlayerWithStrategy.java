package bang_dice_game;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;
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
    private int health;
    private int arrows = 0;
    private int spot;
    private int [] karma;
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
  public PlayerWithStrategy(String name, String role, String description, int health, int arrows,int spot, int [] karma){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.arrows = 0;                    //arrows should always start at 0 but ill include it here anyways
        this.spot = spot;
        this.controller = null;             //I think this controls when its the NPC's turn
        this.karma=karma;
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
    
    public int[] getKarma() {
        return this.karma;
    }
    
    public void setKarma(int[] karma) {
        this.karma = karma;
    }
    
    public void takeTurn(){
        
    AI NPC = new AI();
    
    if (null != this.role)
            switch (this.role) {
                case "Sheriff":
                     NPC.update(this);
                    break;
                case "Deputy":
                    NPC.update(this);
                    break;
                case "Renegade":
                    NPC.update(this);
                    break;
                case "Outlaw":
                    NPC.update(this);    
                    break;    
                default:
                    System.out.println("Something went wrong on " + this.name + "'s turn");
                    break;
            }
        else
            System.out.println("Invalid Role for" + this.name);
    }
    
    
    public void takeAim1(PlayerWithStrategy player) {
        Scanner in = new Scanner(System.in);
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        int amount = currentPlayers.size() - 1;
        int health = 0;
        int placement = 0;
        int [] karmaAdjust;
        
        ArrayList<Player> attack = new ArrayList<Player>();
        
        for (int i = 0; i < amount + 1; i++)
            if (this == currentPlayers.get(i))
                placement = i;
        
       
        if (placement == amount)
        {
           attack.add(currentPlayers.get(amount-1));
           attack.add(currentPlayers.get(0)); 
        }
        else if (placement == 0){
           attack.add(currentPlayers.get(amount));
           attack.add(currentPlayers.get(1));
        }
        else{
           attack.add(currentPlayers.get(placement - 1));
           attack.add(currentPlayers.get(placement + 1));
        }
        
        if (currentPlayers.size() == 2){
            attack.remove(0);
            health = attack.get(0).getHealth();
            health = health - 1;
            attack.get(0).setHealth(health);
            System.out.println(attack.get(0).getName() + " has lost 1 health!");
            karmaAdjust = attack.get(0).getKarma();
            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1;
            attack.get(0).setKarma(karmaAdjust);            
        }
        else{
            if (karma[attack.get(0).getSpot()] == karma[attack.get(1).getSpot()]){
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(0).getKarma();
                karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1;
                attack.get(0).setKarma(karmaAdjust);                
            }
            else if (karma[attack.get(0).getSpot()] > karma[attack.get(1).getSpot()]){
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(0).getKarma();
                karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                attack.get(0).setKarma(karmaAdjust);                
            }
            else{
                health = attack.get(1).getHealth();
                health = health - 1;
                attack.get(1).setHealth(health);
                System.out.println(attack.get(1).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(1).getKarma();
                karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                attack.get(1).setKarma(karmaAdjust);
            }        
        }
        try {
            sleep(1000);
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void takeAim2(PlayerWithStrategy player) {   
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        int amount = currentPlayers.size() - 1;
        int health = 0;
        int placement = 0;
        int [] karmaAdjust;
        
        ArrayList<Player> attack = new ArrayList<Player>();
        
        for (int i = 0; i < amount + 1; i++)
            if (this == currentPlayers.get(i))
                placement = i;
        
        if (placement == amount)
        {
           attack.add(currentPlayers.get(amount-2));
           attack.add(currentPlayers.get(1)); 
        }
        else if (placement == amount-1){
           attack.add(currentPlayers.get(amount-3));
           attack.add(currentPlayers.get(0)); 
        }
        else if (placement == 0){
           attack.add(currentPlayers.get(amount-1));
           attack.add(currentPlayers.get(2)); 
        }
        else if (placement == 1){ 
           attack.add(currentPlayers.get(amount));
           attack.add(currentPlayers.get(3));  
        }
        else{
           attack.add(currentPlayers.get(placement - 1));
           attack.add(currentPlayers.get(placement + 1));
        }
        

        if(currentPlayers.size() == 4){
            attack.remove(1);
            health = attack.get(0).getHealth();
            health = health - 1;
            attack.get(0).setHealth(health);
            System.out.println(attack.get(0).getName() + " has lost 1 health!");
            karmaAdjust = attack.get(0).getKarma();
            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
            attack.get(0).setKarma(karmaAdjust);            
        }
        else{
        
            if (karma[attack.get(0).getSpot()] == karma[attack.get(1).getSpot()]){
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(0).getKarma();
                karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                attack.get(0).setKarma(karmaAdjust);                
            }
            else if (karma[attack.get(0).getSpot()] > karma[attack.get(1).getSpot()]){
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(0).getKarma();
                karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1;
                attack.get(0).setKarma(karmaAdjust);                
            }
            else{
                health = attack.get(1).getHealth();
                health = health - 1;
                attack.get(1).setHealth(health);
                System.out.println(attack.get(1).getName() + " has lost 1 health!");
                karmaAdjust = attack.get(1).getKarma();
                karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                attack.get(1).setKarma(karmaAdjust);                
            }
        }
        try {
            sleep(1000);
        } 
        catch (InterruptedException ex) {
            Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
    
    public void beerDice(PlayerWithStrategy player) {
        ArrayList<Player> heal = new ArrayList<Player>();
        heal = Game.getPlayers();
        int health = 0;
        int karmaSpot = 0;
        int karmaAdjust[];
        
        if (this.getHealth() != 9){ //full health
            health = this.getHealth();
            health = health + 1;
            this.setHealth(health);
            System.out.println(this.getName() + " has heal him/herself!");
        }
        else{
            for (int i = 0; i < heal.size()-1; i++)
                if (karma[heal.get(i).getSpot()] <= karma[heal.get(i+1).getSpot()])
                    karmaSpot = i;
            
            health = heal.get(karmaSpot).getHealth();
            health = health + 1;
            heal.get(karmaSpot).setHealth(health);
            System.out.println(heal.get(karmaSpot).getName() + " has gained 1 health!");
            karmaAdjust = heal.get(karmaSpot).getKarma();
            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] - 1;
            heal.get(karmaSpot).setKarma(karmaAdjust);
        }
            
        
                try {
                    sleep(1000);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
                }           
            
        
    }
        
  
//    
//    public char [][] getKarma() {
//        return this.karma;
//    }
//    public void setKarma(char [][] karma) {
//        this.karma = karma;
//    }
//    @Override
//    public void takeTurn () {
//        System.out.println("Roling Dice for " + this.name);
//            try {
//                sleep(1000);
//            }
//            catch (InterruptedException ex) {
//                Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
//            }        
//        int targetSpot;
//        int points;
//        
//        
//                for (int i=0; i<karma.length; i++)
//        {//this sets all non diagonal numbers to 5
//            for (int j=0; j<karma.length; j++)
//                System.out.print(karma[i][j]+" ");
//            System.out.print("\n");
//        }
//        if (null != this.role)
//            switch (this.role) {
//                case "Sheriff":///////////////////////////////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                    targetSpot=AI.Beer(karma,spot,0,health);                    //  Beer returns target's spot 
//                    if(targetSpot!=spot)                                        //  if its not a self heal
//                        if(Character.getNumericValue(karma[targetSpot][spot])!=9)// if its not max karma already
//                            {
//                                points=Character.getNumericValue(karma[targetSpot][spot])+1;    //  update karma
//                                karma[targetSpot][spot]=Character.forDigit(points, 10);         //  convert to char and update
//                            }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,0,1);                         //  range1 returns target's spot 
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,0,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//                    break;
//                case "Deputy"://////////////////////////////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                    karma[spot][0]='9';
//                    targetSpot=AI.Beer(karma,spot,1,health);  //these all return spot values so yea
//                    if(targetSpot!=spot)
//                        if(Character.getNumericValue(karma[targetSpot][spot])!=9)// if its not max karma already
//                            {
//                                points=Character.getNumericValue(karma[targetSpot][spot])+1;    //  update karma
//                                karma[targetSpot][spot]=Character.forDigit(points, 10);         //  convert to char and update
//                            }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,1,1);       //1=range of 1 and not range of 2
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,1,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//                    break;
//                case "Outlaw"://////////////////////////////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                    karma[spot][0]='0';
//                    targetSpot=AI.Beer(karma,spot,2,health);  //these all return spot values so yea
//                    if(targetSpot!=spot)
//                        if(Character.getNumericValue(karma[targetSpot][spot])!=9)// if its not max karma already
//                            {
//                                points=Character.getNumericValue(karma[targetSpot][spot])+1;    //  update karma
//                                karma[targetSpot][spot]=Character.forDigit(points, 10);         //  convert to char and update
//                            }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,2,1);       //1=range of 1 and not range of 2
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,2,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//                    break;
//                case "Renegade"://////////////////////////////////////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//                    if (BangDiceGame.isDepDead==0)
//                        karma[spot][0]='0';
//                    else
//                        karma[spot][0]='9';
//                    targetSpot=AI.Beer(karma,spot,3,health);  //these all return spot values so yea
//                    if(targetSpot!=spot)
//                        if(Character.getNumericValue(karma[targetSpot][spot])!=9)// if its not max karma already
//                            {
//                                points=Character.getNumericValue(karma[targetSpot][spot])+1;    //  update karma
//                                karma[targetSpot][spot]=Character.forDigit(points, 10);         //  convert to char and update
//                            }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,3,1);       //1=range of 1 and not range of 2
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//for (int i=0; i<karma.length; i++)          //  D
//{//this sets all non diagonal numbers to 5  //  E
//    for (int j=0; j<karma.length; j++)      //  L
//    System.out.print(karma[i][j]+" ");      //  E
//    System.out.print("\n");                 //  T
//}                                           //  E
//                    targetSpot=AI.Bang(karma,spot,3,2);       //Bang will return -1 if people in range dont deserve to get shot so re roll if it happens
//                    if(Character.getNumericValue(karma[targetSpot][spot])!=0)   //  if its at 0 already, dont
//                    {
//                        points=Character.getNumericValue(karma[targetSpot][spot])-1;    //  deduct karma
//                        karma[targetSpot][spot]=Character.forDigit(points, 10); //  convert to char and update
//                    }
//                    break;
//                default:
//                    System.out.println("Something went wrong on " + this.name + "'s turn");
//                    break;
//            }
//        else
//            System.out.println("Invalid Role for" + this.name);
//        
//for (int i=0; i<karma.length; i++)
//{//this sets all non diagonal numbers to 5
//    for (int j=0; j<karma.length; j++)
//        System.out.print(karma[i][j]+" ");
//    System.out.print("\n");
//}
//        
//  }
}


