/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

/**
 *
 * @author airishimamura
 */

import java.util.Random; 


public class Dice {

  
    enum Dice_Face
                 
    {
        IndianArrow, Dynamite, BullsEye1, BullsEye2, Beer, Gatling;
        
        private static final Dice_Face [] dice = Dice_Face.values();
        private static final int SIZE = dice.length;
        private static final Random RANDOM = new Random();
        
        public static Dice_Face getRandomDiceFace()
        {
            return dice[RANDOM.nextInt(SIZE)];
        }       
    }
  
   
    private final Dice_Face dice_face;
    
    //setter 
    public Dice(Dice_Face dice_face)
    {
        this.dice_face = dice_face;
    }
    
    //getter 
   public Dice_Face getDice_Face () 
   {  
    return this.dice_face;
    
    }
  
}