/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import java.util.*;
import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner;
import java.security.SecureRandom;

/**
 *
 * @author airishimamura
 */
public class Characters{

//    static int playerSIZE = BangDiceGame.karma.length;
    private static final Random RANDOM = new SecureRandom();
    public ArrayList <String> players = new ArrayList<>();
    
    public enum BasicCharNames{
        BartCassidy, BlackJack, CalamityJanet, ElGringo, JesseJones,
        Jourdonnais, KitCarlson, LuckyDuke, PaulRegret, PedroRamirez,
        RoseDoolan, SidKetchum, SlabTheKiller,SuzyLafayette, VultureSam,
        WillyTheKid;
        public static BasicCharNames playerName[] = BasicCharNames.values();
//        public static BasicCharNames getRandomPlayers(){      
//            return playerName[RANDOM.nextInt(playerSIZE)];
//            }
    }    
    
    public void characterDescriptions(){
        
        
    }  
    
    public static LinkedList<String> getRandChars(int num){
        LinkedList<String> chars = new LinkedList<String>();
        for(int i = 0; i < BasicCharNames.values().length; i++){
            chars.add(BasicCharNames.playerName[i].toString());
        }
        Collections.shuffle(chars);
        int x = BasicCharNames.values().length;
        while(x > num){
            chars.pop();
            x--;
        }
        return chars;
    }

    
}
