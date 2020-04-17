/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

/**
 *
 * @author airishimamura
 * OwO
 */
import java.lang.Math;
import java.util.Random; 
import java.util.Scanner;

public class Dice {  
    enum Dice_Face
                 
    { 
        IndianArrow, Dynamite, BullsEye1, BullsEye2, Beer, Gatling;
        
        private static final Dice_Face [] dice = Dice_Face.values();
        private static final int SIZE = dice.length;
        private static final Random RANDOM = new Random((long)( Math.random() * (double)Long.SIZE));
        
        public static Dice_Face getRandomDice_Face(){      
            return dice[RANDOM.nextInt(SIZE)];

        }
     
    }  
      public static void firstRoll() //method to roll 6 dice
      {
        for ( int i = 0; i < Dice_Face.SIZE; i++){
            Dice_Face.dice [i] = Dice_Face.getRandomDice_Face();
            System.out.print("\t" + "Dice[" + i + "] = " + Dice_Face.dice[i] + "\n " );
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
   
   public static void reRoll (){
       
       Scanner scanner = new Scanner(System.in);
       System.out.println("\nChose number of dice you want to reroll: ");
       int num = scanner.nextInt();  
            
       if (0 <= num && num < 6){
           //when the dice was dynamite, print "you cannot reroll"
          if(Dice_Face.dice [num] == Dice.Dice_Face.Dynamite){
              System.out.println("You cannot reroll\n");
          }
          else{
             System.out.println("Dice Face after reroll:\n");
              for ( int j = 0; j < Dice_Face.SIZE; j++ ){
                  //get new dice face 
                if(j == num){
                 Dice_Face.dice[j] = Dice_Face.getRandomDice_Face();
                   }
             //displaying the dice after re-roll
            System.out.print("\t" + "Dice[" + j + "] = " + Dice_Face.dice[j] + "\n "); 
              }
          }
       }
       //when the given number is invalid dice number 
      else{
            System.out.println("Invalid Dice number \n");
       }   
   }
   
   
//   //just for testing
//   public static void main(String[] args) {
//
//    Dice roll = new Dice(Dice_Face.getRandomDice_Face());
//    roll.firstRoll();
//    
//    for(int z = 0; z < 3; z++){
//    roll.reRoll();
//    }
//
//    
//    }  
   
}