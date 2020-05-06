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

    public static int playerSIZE = BangDiceGame.karma.length;
    public static ArrayList <String> players = new ArrayList<>();
    
    public enum BasicCharNames{
        ElGringo, JournDonn, PaulRegret, PedroRamirez,
        SidKetchum, VurltureSam, SuzyLafayette;
        public static BasicCharNames playerName[] = BasicCharNames.values();
       
    }    
    
    public void getplayers() {

        for(int i = 0; i< BasicCharNames.values().length; i++){
        players.add(BasicCharNames.playerName[i].toString());
                }
       Collections.shuffle(players); 
       
        //for testing
//       for(int z = 0; z< playerSIZE; z++){
//           System.out.println(players.get(z));
//       }  
    }
     
    public void characterDescriptions(){
        
        
    }    
    
}
