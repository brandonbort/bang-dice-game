/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import java.util.*;
import java.util.ArrayList;
import java.util.Random; 
//import java.security.SecureRandom;
import java.util.Collections;

/**
 *
 * @author airishimamura
 */
public class Characters{

//    static int playerSIZE = BangDiceGame.karma.length;
//    private static final Random RANDOM = new SecureRandom();
    public static int playerSIZE;
    public static ArrayList <String> players = new ArrayList<>();
    private static String elGringoDescrip = "When  a  player  makes  you  lose  one  or  more  life  points, he must take an arrow."
            + "Life points lost to Indians or Dynamite are not affected.";
    private static String journDonnDescrip = "You never lose more than one life point to Indians.";
    private static String paulRegretDescrip = "You never lose life points to the Gatling Gun.";
    private static String pedroRamirezDescrip = "Each  time  you  lose  a  life  point,  you  may  discard  one of your arrows.";
    private static String sidKetchumDescrip = "At  the  beginning  of  your  turn,  any  player  of  your  choice gains one life point.You may also choose yourself.";
    private static String vurltureSamDescrip = "Each  time  another  player  is  eliminated,  you  gain  two life points.";
    private static String suzyLafayetteDescrip = "If you didn’t roll any BANG1 or BANG2, you gain two life points.This only applies at the end of your turn, not during your re-rolls.";
    
    public enum BasicCharNames{

        BartCassidy, BlackJack, CalamityJanet, ElGringo, JesseJones,
        Jourdonnais, KitCarlson, LuckyDuke, PaulRegret, PedroRamirez,
        RoseDoolan, SidKetchum, SlabTheKiller,SuzyLafayette, VultureSam,
        WillyTheKid;

        public static BasicCharNames playerName[] = BasicCharNames.values();
    }    
    

    public void characterDescriptions(){
        
        
    }  
    
    public static LinkedList<String> getRandChars(int num){
        LinkedList<String> chars = new LinkedList<String>();
        for(int i = 0; i < BasicCharNames.values().length; i++){
            chars.push(BasicCharNames.playerName[i].toString());
        }
        Collections.shuffle(chars);
        int x = BasicCharNames.values().length;
        while(x > num){
            chars.pop();
            x--;
        }
        
        return chars;
    }

    public void getPlayers() {
        this.playerSIZE = BangDiceGame.karma.length;
        for(int i = 0; i< BasicCharNames.values().length; i++){
        players.add(BasicCharNames.playerName[i].toString());
                }
       Collections.shuffle(players); 
       
        //for testing
//       for(int z = 0; z< playerSIZE; z++){
//           System.out.println(players.get(z));
//       }  
    }
      
    public String elGringoDescrip(){
        return this.elGringoDescrip;
    }
    
    public String journDonnDescrip(){
        return this.journDonnDescrip;
    }
    
    public String paulRegretDescrip(){
        return this.paulRegretDescrip;
    }
    
    public String pedroRamirezDescrip(){
        return this.pedroRamirezDescrip;
    }
    
    public String sidKetchumDescrip(){
        return this.sidKetchumDescrip;
    }
    
    public String vurltureSamDescrip(){
        return this.vurltureSamDescrip;
    }
    
    public String suzyLafayetteDescrip(){
        return this.suzyLafayetteDescrip;
    }
}

