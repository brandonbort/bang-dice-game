/**
 * Carlos Developed Code
 * Aaron assisted
 */
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
    private int maxHealth;
    private int arrows = 0;
    private int spot;
    private int [] karma = new int[5];
    
    
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
  public PlayerWithStrategy(String name, String role, String description, int health,int spot, int karma[]){
        this.name = name;
        this.role = role;
        this.description = description;
        this.health = health;
        this.maxHealth = health;
        this.arrows = 0;                    //arrows should always start at 0 but ill include it here anyways
        this.spot = spot;
        for (int i = 0; i < karma.length; i++)
            this.karma[i] = karma[i];
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
    public int getMaxHealth() {
        return maxHealth;
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
    
    public void setKarma(int karma[]) {
        for (int i = 0; i < karma.length; i++)
            this.karma[i] = karma[i];
    }
    
    public void takeTurn(){
        
    AI NPC = new AI();
    
    if (null != this.role)
            switch (this.role) {
                case "Sheriff":
                     NPC.play(this,0);
                    break;
                case "Deputy":
                    NPC.play(this,1);
                    break;
                case "Renegade":
                    if(Game.getPlayers().size() != 2)
                        NPC.play(this,1);
                    else 
                        NPC.play(this,-1);
                    break;
                case "Outlaw":
                    NPC.play(this,-1);    
                    break;    
                default:
                    System.out.println("Something went wrong on " + this.name + "'s turn");
                    break;
            }
        else
            System.out.println("Invalid Role for" + this.name);
    }
    
    
    public void takeAim1(Player player, int morale) {
        Scanner in = new Scanner(System.in);
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        int amount = currentPlayers.size() - 1;
        int health = 0;
        int placement = 0;
        int [] karmaAdjust = new int[5];
        int gringoCount = 0;
        
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
            if (morale == 1){
                if ("Sheriff".equals(attack.get(0).getRole()))
                    System.out.println(player.getName() + " has skipped their bang.");
            }
            else{
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                    if (attack.get(0).getSpot() != 0){
                        karmaAdjust = attack.get(0).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(0).setKarma(karmaAdjust);       
                    }
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
            }
        }
        else{
            if (karma[attack.get(0).getSpot()] == karma[attack.get(1).getSpot()]){
                if (morale == 1){
                    if ("Sheriff".equals(attack.get(0).getRole())){
                        health = attack.get(1).getHealth();
                        health = health - 1;
                        attack.get(1).setHealth(health);
                        System.out.println(attack.get(1).getName() + " has lost 1 health!");
                        if (attack.get(1).getSpot() != 0){
                            karmaAdjust = attack.get(1).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(1).setKarma(karmaAdjust);       
                        }
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
                    }
                    else{
                        health = attack.get(0).getHealth();
                        health = health - 1;
                        attack.get(0).setHealth(health);
                        System.out.println(attack.get(0).getName() + " has lost 1 health!");
                        if (attack.get(0).getSpot() != 0){
                            karmaAdjust = attack.get(0).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(0).setKarma(karmaAdjust);       
                        }
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
                    }
                }
                else{    
                    health = attack.get(0).getHealth();
                    health = health - 1;
                    attack.get(0).setHealth(health);
                    System.out.println(attack.get(0).getName() + " has lost 1 health!");
                    if (attack.get(0).getSpot() != 0){
                        karmaAdjust = attack.get(0).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(0).setKarma(karmaAdjust);       
                    }
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
                }
            }
            else if (karma[attack.get(0).getSpot()] > karma[attack.get(1).getSpot()]){
                if (morale == 1){
                    if ("Sheriff".equals(attack.get(0).getRole())){
                        health = attack.get(1).getHealth();
                        health = health - 1;
                        attack.get(1).setHealth(health);
                        System.out.println(attack.get(1).getName() + " has lost 1 health!");
                        if (attack.get(1).getSpot() != 0){
                            karmaAdjust = attack.get(1).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(1).setKarma(karmaAdjust);       
                        }
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
                    }
                    else{
                        health = attack.get(0).getHealth();
                        health = health - 1;
                        attack.get(0).setHealth(health);
                        System.out.println(attack.get(0).getName() + " has lost 1 health!");
                        if (attack.get(0).getSpot() != 0){
                            karmaAdjust = attack.get(0).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(0).setKarma(karmaAdjust);       
                        }
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
                    }
                }
                else{    
                    health = attack.get(0).getHealth();
                    health = health - 1;
                    attack.get(0).setHealth(health);
                    System.out.println(attack.get(0).getName() + " has lost 1 health!");
                    if (attack.get(0).getSpot() != 0){
                        karmaAdjust = attack.get(0).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(0).setKarma(karmaAdjust);       
                    }
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
                }
            }
            else{
                if (morale == 1){
                    if ("Sheriff".equals(attack.get(1).getRole())){
                        health = attack.get(0).getHealth();
                        health = health - 1;
                        attack.get(0).setHealth(health);
                        System.out.println(attack.get(0).getName() + " has lost 1 health!");
                        if (attack.get(0).getSpot() != 0){
                            karmaAdjust = attack.get(0).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(0).setKarma(karmaAdjust);       
                        }
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
                    }
                    else{
                        health = attack.get(1).getHealth();
                        health = health - 1;
                        attack.get(1).setHealth(health);
                        System.out.println(attack.get(1).getName() + " has lost 1 health!");
                        if (attack.get(1).getSpot() != 0){
                            karmaAdjust = attack.get(1).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(1).setKarma(karmaAdjust);       
                        }
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
                    }
                }
                else{    
                    health = attack.get(1).getHealth();
                    health = health - 1;
                    attack.get(1).setHealth(health);
                    System.out.println(attack.get(1).getName() + " has lost 1 health!");
                    if (attack.get(1).getSpot() != 0){
                        karmaAdjust = attack.get(1).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(1).setKarma(karmaAdjust);       
                    }
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
                }
            }            
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
            Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void takeAim2(PlayerWithStrategy player, int morale) {   
        ArrayList<Player> currentPlayers = new ArrayList<Player>();
        currentPlayers = Game.getPlayers();
        int amount = currentPlayers.size() - 1;
        int health = 0;
        int placement = 0;
        int [] karmaAdjust = new int[5];
        int gringoCount = 0;
        
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
            if (morale == 1){
                if ("Sheriff".equals(attack.get(0).getRole()))
                    System.out.println(player.getName() + " has skipped their bang.");
            }
            else{
                health = attack.get(0).getHealth();
                health = health - 1;
                attack.get(0).setHealth(health);
                System.out.println(attack.get(0).getName() + " has lost 1 health!");
                    if (attack.get(0).getSpot() != 0){
                        karmaAdjust = attack.get(0).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(0).setKarma(karmaAdjust);       
                    }
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
            }
        }
        else{
            if (karma[attack.get(0).getSpot()] == karma[attack.get(1).getSpot()]){
                if (morale == 1){
                    if ("Sheriff".equals(attack.get(0).getRole())){
                        health = attack.get(1).getHealth();
                        health = health - 1;
                        attack.get(1).setHealth(health);
                        System.out.println(attack.get(1).getName() + " has lost 1 health!");
                        if (attack.get(1).getSpot() != 0){
                            karmaAdjust = attack.get(1).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(1).setKarma(karmaAdjust);       
                        }
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
                    }
                    else{
                        health = attack.get(0).getHealth();
                        health = health - 1;
                        attack.get(0).setHealth(health);
                        System.out.println(attack.get(0).getName() + " has lost 1 health!");
                        if (attack.get(0).getSpot() != 0){
                            karmaAdjust = attack.get(0).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(0).setKarma(karmaAdjust);       
                        }
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
                    }
                }
                else{    
                    health = attack.get(0).getHealth();
                    health = health - 1;
                    attack.get(0).setHealth(health);
                    System.out.println(attack.get(0).getName() + " has lost 1 health!");
                    if (attack.get(0).getSpot() != 0){
                        karmaAdjust = attack.get(0).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(0).setKarma(karmaAdjust);       
                    }
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
                }
            }
            else if (karma[attack.get(0).getSpot()] > karma[attack.get(1).getSpot()]){
                if (morale == 1){
                    if ("Sheriff".equals(attack.get(0).getRole())){
                        health = attack.get(1).getHealth();
                        health = health - 1;
                        attack.get(1).setHealth(health);
                        System.out.println(attack.get(1).getName() + " has lost 1 health!");
                        if (attack.get(1).getSpot() != 0){
                            karmaAdjust = attack.get(1).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(1).setKarma(karmaAdjust);       
                        }
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
                    }
                    else{
                        health = attack.get(0).getHealth();
                        health = health - 1;
                        attack.get(0).setHealth(health);
                        System.out.println(attack.get(0).getName() + " has lost 1 health!");
                        if (attack.get(0).getSpot() != 0){
                            karmaAdjust = attack.get(0).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(0).setKarma(karmaAdjust);       
                        }
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
                    }
                }
                else{    
                    health = attack.get(0).getHealth();
                    health = health - 1;
                    attack.get(0).setHealth(health);
                    System.out.println(attack.get(0).getName() + " has lost 1 health!");
                    if (attack.get(0).getSpot() != 0){
                        karmaAdjust = attack.get(0).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(0).setKarma(karmaAdjust);       
                    }
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
                }
            }
            else{
                if (morale == 1){
                    if ("Sheriff".equals(attack.get(1).getRole())){
                        health = attack.get(0).getHealth();
                        health = health - 1;
                        attack.get(0).setHealth(health);
                        System.out.println(attack.get(0).getName() + " has lost 1 health!");
                        if (attack.get(0).getSpot() != 0){
                            karmaAdjust = attack.get(0).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(0).setKarma(karmaAdjust);       
                        }
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
                    }
                    else{
                        health = attack.get(1).getHealth();
                        health = health - 1;
                        attack.get(1).setHealth(health);
                        System.out.println(attack.get(1).getName() + " has lost 1 health!");
                        if (attack.get(1).getSpot() != 0){
                            karmaAdjust = attack.get(1).getKarma();
                            karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                            attack.get(1).setKarma(karmaAdjust);       
                        }
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
                    }
                }
                else{    
                    health = attack.get(1).getHealth();
                    health = health - 1;
                    attack.get(1).setHealth(health);
                    System.out.println(attack.get(1).getName() + " has lost 1 health!");
                    if (attack.get(1).getSpot() != 0){
                        karmaAdjust = attack.get(1).getKarma();
                        karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] + 1; 
                        attack.get(1).setKarma(karmaAdjust);       
                    }
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
                }
            }           
        }
        if(gringoCount >= 1){
            int arrows = this.getArrows();
            arrows = arrows + 1;
            this.setArrows(arrows);
            System.out.println(this.getName() + " has gained 1 arrow! From PedroRamirez >-<");
            int gameArrows = Game.getGameArrows();
            gameArrows = gameArrows - 1;
            Game.setGameArrows(gameArrows);
            System.out.println("There are only " + gameArrows + " arrow(s) left!");
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
    
    public void beerDice(PlayerWithStrategy player, int morale) {
        ArrayList<Player> heal = new ArrayList<Player>();
        heal = Game.getPlayers();
        int health = 0;
        int karmaSpot = 0;
        int [] karmaAdjust = new int[5];
        
        for (int i = 0; i < heal.size(); i++)
            if (heal.get(i).getHealth() == 0)
                heal.remove(i);        
        
        if (this.getHealth() != this.getMaxHealth()){ //full health
            health = this.getHealth();
            health = health + 1;
            this.setHealth(health);
            System.out.println(this.getName() + " has heal him/herself!");
        }
        else{
            for (int i = 0; i < heal.size()-1; i++)
                if (karma[heal.get(i).getSpot()] <= karma[heal.get(i+1).getSpot()])
                    karmaSpot = i;
            if (heal.get(karmaSpot).getMaxHealth() != heal.get(karmaSpot).getHealth()){
                health = heal.get(karmaSpot).getHealth();
                health = health + 1;
                heal.get(karmaSpot).setHealth(health);
                System.out.println(heal.get(karmaSpot).getName() + " has gained 1 health!");
            }
            else{
                System.out.println(heal.get(karmaSpot).getName() + "'s health is already full!!");
            }
                if (heal.get(karmaSpot).getSpot() != 0){
                    karmaAdjust = heal.get(karmaSpot).getKarma();
                    karmaAdjust [player.getSpot()] = karmaAdjust [player.getSpot()] - 1; 
                    heal.get(karmaSpot).setKarma(karmaAdjust);       
                }            
        }
            
        
                try {
                    sleep(1000);
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(PlayerWithStrategy.class.getName()).log(Level.SEVERE, null, ex);
                }           
            
        
    }
}



