/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

/**
 *
 * @author airishimamura
 * 
 */ 
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner;

//*

/**
 *
 * @author airishimamura
 */

public class Dice {  
//    enum Dice_Face
//                 
//    { 
//        IndianArrow, Dynamite, BullsEye1, BullsEye2, Beer, Gatling;
//        
//        public static final Dice_Face [] dice = Dice_Face.values();
//        private static final int SIZE = dice.length;
//        private static final Random RANDOM = new Random((long)( Math.random() * (double)Long.SIZE));
//        
//        public static Dice_Face getRandomDice_Face(){      
//            return dice[RANDOM.nextInt(SIZE)];
//
//        }
    
        public int numOfDices = 5;
        private static int SIZE = 6;
        private static final Random RANDOM = new Random((long)( Math.random() * (double)Long.SIZE));
        
        String yes = new String("Yes");
        String no = new String("No");
        
        ArrayList <Dice.Dice_Face> BasicResult  = new ArrayList<>();
        ArrayList <Dice.Loudmouth> Option1 = new ArrayList<>();
     public enum Dice_Face
                 
    { 
        IndianArrow, Dynamite, BullsEye1, BullsEye2, Beer, Gatling;
        public static Dice_Face dice[] = Dice_Face.values();
        private static Dice_Face getRandomDice_Face(){      
            return dice[RANDOM.nextInt(SIZE)];
            }
        
        }
     
        
     public enum Loudmouth
        {
            IndianArrow, Dynamite, DoubleBullsEye1, DoubleBullesEye2, DoubleGatling, Bullet; 
            public static Loudmouth dice1 [] = Loudmouth.values();
            public static Loudmouth getRandomSaloon1_Face(){      
            return dice1[RANDOM.nextInt(SIZE)];
            }
        }
        
      public enum Coward
        {
            IndianArrow, Dynamite, BullsEye1, Beer, DoubleBeers, BrokenArrow; 
            public static Coward dice2 [] = Coward.values();
            public static Coward getRandomSaloon2_Face(){      
            return dice2[RANDOM.nextInt(SIZE)];
            }
        }
        
       enum DuelDices
        {
            IndianArrow, Gatling, Dynamite, Duel1, Duel2, Whiskey; 
            public static DuelDices dice3 [] = DuelDices.values();
            public static DuelDices getRandomDuel_Face(){      
            return dice3[RANDOM.nextInt(SIZE)];
             }
        }
     

    /**
     *
     */
       
      public void BasicDice(){
 
            for ( int i = 0; i < numOfDices; i++){
             Dice_Face.dice[i] = Dice_Face.getRandomDice_Face();
             BasicResult.add(Dice.Dice_Face.dice[i]);
         
            System.out.print("\t" + "Dice[" + i + "] = " + Dice_Face.dice[i] + "\n" );
        }  
      } 
      
      public void Saloon(){
       System.out.print("Choose 'Loudmouth' or 'Coward': ");
       Scanner scr = new Scanner(System.in);
       String response = scr.nextLine();
       String loudmouth = new String("Loudmouth");
       String coward = new String("Coward");
       if(response.equals(loudmouth)){
           Loudmouth.dice1[0] = Loudmouth.getRandomSaloon1_Face();
            System.out.print("\t" + "Loudmouth Dice[" + 0 + "] = " + Dice_Face.dice[0] + "\n" );
            for(int j = 1; j < numOfDices; j++){
                
            }
           
           //when player is Jose Delcado,  add one dice (numOfDices = 6)
       }
       else {
           
           
           
           // when player is Tequila joe, add one dice(numOfDices s= 6) 
           
       }
       
       
          
      }
       
      public void undeadOrAlive() {
        
        
    }
   
      
       
    public void firstRoll() //method to roll dices
      {
        System.out.print("Take an option?(Yes/No): ");
       Scanner scanner = new Scanner(System.in);
       String option = scanner.nextLine();
       if(option.equals(no)){
           BasicDice();
           reRoll();
       }
       else{
           System.out.print("Saloon Dice or Duel Dice (Saloon/Duel): ");
           String option2 = scanner.nextLine();
           String saloon = "Saloon";
//           String duel = "Duel";
           if(option2.equals(saloon)){
               Saloon();
                
           }
//           else{
//               undeadOrAlive();
//               
//               
//           }
       }
       
      }
       
   // private final Dice_Face dice_face;
    
    //setter 

//    /**
//     *
//     * @param dice_face
//     */
//    public Dice(Dice_Face dice_face)
//    {
//        this.dice_face = dice_face;
//    }    
//    //getter 
//
//    /**
//     *
//     * @return
//     */
//   public Dice_Face getDice_Face () 
//   {  
//    return this.dice_face;
//    
//    }

    /**
     *
     */
    public void reRoll (){
       Scanner scanner = new Scanner(System.in);
      
       boolean rollDecision = true; 
       while (rollDecision){
           System.out.print("Do you want to reroll? (Yes/No): ");
           
           String response = scanner.nextLine();
    //When you want to reroll dices 
    if(response.equals(yes))
    {
           // get a dice number you want to reroll 
            System.out.print("\nChose number of dice you want to reroll: ");
            System.out.println("eg: 2,3,0");
             String input = scanner.nextLine();  
             int size = 0;
		
		boolean isPrevCharANumber = false;
		for ( char c : input.toCharArray() ) 
			if ( c >= '0' && c <= '9' ) 
				if ( !isPrevCharANumber ) {
                                    isPrevCharANumber = true;
                                    size++;
				}
			else
                            isPrevCharANumber = false;
                int[] num = new int[size];
                String[] strArray = input.split(",");
                for (int i=0; i<size;++i)
                {
                    num[i]=Integer.parseInt(strArray[i]);
                }
                for(int i=0;i<size;++i ){         
                  if (0 <= num[i] && num[i] < numOfDices)
       {
           //when the dice was dynamite, print "you cannot reroll"
          if(Dice_Face.dice [num[i]] == Dice.Dice_Face.Dynamite){
              System.out.println("You cannot reroll");
               
                }
          else{
             System.out.println("Dice Face after reroll:\n");
              for ( int j = 0; j < numOfDices; j++ )
                {
                  //get new dice face 
                if(j == num[i]){
                     Dice_Face.dice[j] = Dice_Face.getRandomDice_Face();
                   }
                   //displaying the dice face after re-roll
                    System.out.print("\t" + "Dice[" + j + "] = " + Dice_Face.dice[j] + "\n"); 
                 }
                }
       }
            //when the given number is invalid 
            else{
                  System.out.println("Invalid Dice number \n");
                }  
     }
    }
    //when you don't want to reroll 
    else if(response.equals(no)){
           rollDecision = false;
           System.out.println("Finish rolling dice");
            }
     //when response is not yes or no 
    else
           System.out.println("Invalid >"+response+"<");       
       }
    } 
   
   
   }
       


   
 
   
//   //just for testing
//   public static void main(String[] args) {
//
//    Dice roll = new Dice(Dice_Face.getRandomDice_Face());
//    roll.firstRoll();
//    roll.reRoll();
//
//    
//    }  
   
 
 
