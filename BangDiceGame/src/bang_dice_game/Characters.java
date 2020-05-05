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

    static int playerSIZE = BangDiceGame.karma.length;
    private static final Random RANDOM = new SecureRandom();
    public ArrayList <String> players = new ArrayList<>();
    
    public enum BasicCharNames{
        BartCassidy, BlackJack, CalamityJanet, ElGringo, JesseJones,
        Jourdonnais, KitCarlson, LuckyDuke, PaulRegret, PedroRamirez,
        RoseDoolan, SidKetchum, SlabTheKiller,SuzyLafayette, VurltureSam,
        WillyTheKid;
        public static BasicCharNames playerName[] = BasicCharNames.values();
        public static BasicCharNames getRandomPlayers(){      
            return playerName[RANDOM.nextInt(playerSIZE)];
            }
    }    
    
    public void characterDescriptions(){
        
        
    }    
    
}
