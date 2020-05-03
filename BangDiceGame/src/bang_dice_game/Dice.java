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

import java.util.ArrayList;
import java.util.Random; 
import java.util.Scanner;
import java.security.SecureRandom;

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

    /**
     *
     */
    
        public int numOfDices = 5;
        private static final int SIZE = 6;
       
        //private static final Random RANDOM = new Random((long)( Math.random() * (double)Long.SIZE));
        private static final Random RANDOM = new SecureRandom();

        public String yes = "Yes";
        public String no = "No";
        
        //ArrayList <String> BasicResult  = new ArrayList<>();
        //ArrayList <String> Option = new ArrayList<>();
        public ArrayList <String> Result = new ArrayList<>();

    /**
     *To store basic dice faces and generate them randomly
     */
    public enum Dice_Face
                 
    { 
            IndianArrow, Dynamite, BullsEye1, BullsEye2, Beer, Gatling;
        public static Dice_Face dice[] = Dice_Face.values();
         /**
         *To get basic dice face randomly 
         * @return basic dice faces 
          */ 
        public static Dice_Face getRandomDice_Face(){      
            return dice[RANDOM.nextInt(SIZE)];
            }
        }
        
    /**
     *To store loudmouth dice faces and generate them randomly 
     */
     public enum Loudmouth
        {
            IndianArrow, Dynamite, DoubleBullsEye1, DoubleBullesEye2, DoubleGatling, Bullet; 
            public static Loudmouth dice1 [] = Loudmouth.values();
           
            /**
             *To get loudmouth dice face randomly
             * @return loudmouth dice faces 
             */ 
            public static Loudmouth getRandomLoudmouth_Face(){      
            return dice1[RANDOM.nextInt(SIZE)];
            }
        }
   
    /**
     *To store coward dice faces and generate them randomly 
     */     
      public enum Coward
        {
            IndianArrow, Dynamite, BullsEye1, Beer, DoubleBeers, BrokenArrow; 
            public static Coward dice2 [] = Coward.values();
            
            /**
             *To get coward dice face randomly
             * @return coward dice faces 
             */ 
            public static Coward getRandomCoward_Face(){      
            return dice2[RANDOM.nextInt(SIZE)];
            }
        }
     /**
     *To store duel dice faces and generate them randomly 
     */  
       public enum DuelDices
        {
            IndianArrow, Gatling, Dynamite, Duel1, Duel2, Whiskey; 
            public static DuelDices dice3 [] = DuelDices.values();
            
            /**
             *To get duel dices' dice face randomly 
             * @return duel dice faces 
             */ 
            public static DuelDices getRandomDuel_Face(){      
            return dice3[RANDOM.nextInt(SIZE)];
             }
        }
     
    /**To get 5 basic dice faces randomly and store them as arrayList 
     *
     */
       
      public void BasicDice(){
            // get 5 dice faces from basic dices
            for ( int i = 0; i < numOfDices; i++){
             Dice_Face.dice[i] = Dice_Face.getRandomDice_Face();
             Result.add(Dice_Face.dice[i].toString());
            System.out.print("\t" + "Dice[" + i + "] = "  + Result.get(i) + " (Basic Dice)"+"\n" );
        }  
      } 
      
     /**
     *To get one loudmouth or coward dice face and four basic dice faces and store them in arraylist 
     */ 
      
      public void Saloon(){
       System.out.print("Choose 1(Loudmouth) or 2(Coward): ");
       Scanner scr = new Scanner(System.in);
       String response = scr.nextLine();
       String loudmouth = "1";
       String coward = "2";
       // get one loudmouth and 4 basic dice faces 
       if(response.equals(loudmouth)){
           Loudmouth.dice1[0] = Loudmouth.getRandomLoudmouth_Face();
             Result.add(Loudmouth.dice1[0].toString());
             System.out.print("\t" + "Dice[" + 0 + "] = " + Result.get(0) + " (Loudmouth Dice)" +"\n" );
            for(int j = 1; j < numOfDices ; j++){
                Dice_Face.dice[j] = Dice_Face.getRandomDice_Face();
                Result.add(Dice_Face.dice[j].toString());
                System.out.print("\t" + "Dice[" + j + "] = "  + Result.get(j) + "\n" );
            }
           
         //* when player is Jose Delcado,  add one dice (numOfDices = 6)
           //if(Player = Jose Delcado){
//           Loudmouth.dice1[0] = Loudmouth.getRandomSaloon1_Face();
//           Result.add(Loudmouth.dice1[0].toString());
//          System.out.print("\t" + "Dice[" + 0 + "] = " + Result.get(0) + " (Loudmouth Dice)" +"\n" );
//           for(int z = 1; z < numOfDices + 1; z++){
//                Dice_Face.dice[z] = Dice_Face.getRandomDice_Face();
//                Result.add(Dice_Face.dice[z].toString());
//                System.out.print("\t" + "Dice[" + z + "] = "  + Result.get(z) + "\n" );
//            }
//           
           
       }
       // when choose coward, get one coward and 4 basic dice faces 
       else {
           Coward.dice2[0] = Coward.getRandomCoward_Face();
           Result.add(Coward.dice2[0].toString());
           System.out.print("\t" + "Dice[" + 0 + "] = " + Result.get(0) + " (Coward Dice)" +"\n" );
           for(int j = 1; j < numOfDices ; j++){
                Dice_Face.dice[j] = Dice_Face.getRandomDice_Face();
                Result.add(Dice_Face.dice[j].toString());
                System.out.print("\t" + "Dice[" + j + "] = "  + Result.get(j) + " (Basic Dice)" + "\n" );
            }
         // * when player is Tequila joe, add one dice(numOfDices s= 6) 
           //if(player = Tequila joe){
           //Coward.dice2[0] = Coward.getRandomCoward_Face();
           // Result.add(Coward.dice2[0].toString());
           //System.out.print("\t" + "Dice[" + 0 + "] = " + Result.get(0) + " (Coward Dice)" +"\n" );
           // for(int z = 1; z < numOfDices + 1; z++){
//                Dice_Face.dice[z] = Dice_Face.getRandomDice_Face();
//                Result.add(Dice_Face.dice[z].toString());
//                System.out.print("\t" + "Dice[" + z + "] = "  + Result.get(z) + "\n" );
//            }
            }
      }
      
     /**
     *To get duel dice faces and three basic dice faces and store them in arraylist 
     */ 
      // roll 2 duel dices and 3 basic dices 
      public void undeadOrAlive() {
          DuelDices.dice3[0] = DuelDices.getRandomDuel_Face();
          Result.add(DuelDices.dice3[0].toString());
          DuelDices.dice3[1] = DuelDices.getRandomDuel_Face();
          Result.add(DuelDices.dice3[1].toString());
             System.out.print("\t" + "Dice["+ 0 +"] = " + Result.get(0) + " (Duel Dice)" +"\n" );
             System.out.print("\t" + "Dice["+ 1 +"] = " + Result.get(1) + " (Duel Dice)" +"\n" );

            for(int j = 2; j < numOfDices ; j++){
                Dice_Face.dice[j] = Dice_Face.getRandomDice_Face();
                Result.add(Dice_Face.dice[j].toString());
                System.out.print("\t" + "Dice[" + j + "] = "  + Result.get(j) + " (Basic Dice)" + "\n" );
            }
//        * when player is ghost   
//         if(player= ghost){
//    for(int j = 0; j < 2 ; j++){
//                DuelDices.dice3[j] = DuelDices.getRandomDuel_Face();
//                Result.add(DuelDices.dice3[j].toString());
//                System.out.print("\t" + "Dice["+ j +"] = " + Result.get(j) + " (Duel Dice)" +"\n" );
//            }
//   
    }
       
     /**
     *To get first dice faces 
     */ 
      
    public void firstRoll() //method to roll dices
      {
        System.out.print("Take an option?(Yes/No): ");
       Scanner scanner = new Scanner(System.in);
       String option = scanner.nextLine();
       if(option.equals(no)){
           BasicDice();
       }
       else{
           System.out.print("Saloon Dice or Duel Dice (Saloon/Duel): ");
           String option2 = scanner.nextLine();
           String saloon = "Saloon";
           if(option2.equals(saloon)){
               Saloon();
           }
           else{
               undeadOrAlive();
           }
       }
       
      }
       
//    private final Dice_Face dice_face;
//    //setter
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
//    }

    /**
     * To get decision of re roll from the user then get new dice faces
     *
     */
    public void reRoll (){
       Scanner scanner = new Scanner(System.in);
       boolean rollDecision = true; 
       //while the input is "Yes"
       while (rollDecision){
           System.out.print("Do you want to reroll? (Yes/No): ");
           String response = scanner.next();
    //When you want to reroll dices 
    if(response.equals(yes))
    {
          // get a dice number you want to reroll 
           System.out.print("\nChose number of dice you want to reroll");
           System.out.print("(eg: 2,3,0): ");
           String input = scanner.next();
           String params[] = input.split(",");
           int num [] = new int[params.length];
           for(int i = 0; i < params.length; i++){
               num[i] = Integer.parseInt(params[i]);
           }
//             int size = 0;
//		boolean isPrevCharANumber = false;
//		for ( char c : input.toCharArray() ) 
//			if ( c >= '0' && c <= '9' ) 
//				if ( !isPrevCharANumber ) {
//                                    isPrevCharANumber = true;
//                                    size++;
//				}
//			else
//                            isPrevCharANumber = false;
//                int[] num = new int[size];
//                String[] strArray = input.split(",");
//                for (int i = 0; i < size; ++i)
//                {
//                    num[i]=Integer.parseInt(strArray[i]);
//                }
               // for(int i=0;i<size;++i ){    
               // loop number of input 
                for(int i = 0; i < num.length; i++){
                    //when the inpup is valid number
                  if (0 <= num[i] && num[i] < numOfDices)
       {
           //when the dice was dynamite, print "you cannot reroll"
         
              if(Result.get(num[i]).equals("Dynamite")){
              System.out.println("You cannot reroll");
                }
          else{
             System.out.println("\nDice Face after reroll: ");
              for ( int j = 0; j < numOfDices; j++ )
                {
                  //get new dice face 
                if(j == num[i])
                 {
                    //when dice is basic dice 
                    if(Result.get(j).equals(Dice_Face.dice[j].toString())){
                    Dice_Face.dice[j] = Dice_Face.getRandomDice_Face();
                     Result.set(j,Dice_Face.dice[j].toString());
                        }
                    //when dice is loudmouth
                    else if(Result.get(j).equals(Loudmouth.dice1[j].toString())){
                        Loudmouth.dice1[j] = Loudmouth.getRandomLoudmouth_Face();
                        Result.set(j,Loudmouth.dice1[j].toString());
                        }
                    //when dice is coward
                    else if(Result.get(j).equals(Coward.dice2[j].toString())){
                        Coward.dice2[j] = Coward.getRandomCoward_Face();
                        Result.set(j,Coward.dice2[j].toString());
                        }
                    //when dice is duel dice 
                    else if (Result.get(j).equals(DuelDices.dice3[j].toString())){
                        DuelDices.dice3[j] = DuelDices.getRandomDuel_Face();
                        Result.set(j, DuelDices.dice3[j].toString());
                        }
                    }
                   //displaying the dice face after re-roll
                    System.out.print("\tDice[" + j + "] = " + Result.get(j) + "\n"); 
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
    else {
        System.out.println("Invalid >"+response+"<");     
        }
       }
    } 
   
 }
       
