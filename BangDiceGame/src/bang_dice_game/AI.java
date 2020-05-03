package bang_dice_game;
//LOOK AT BOTTOM OF CODE FOR EXPLANATION OF KARMA!!!

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos144green
 */
public class AI {
    /**
     * Beer             //  class to heal peeps 
     * @param karma     //  2D array
     * @param spot      //  position located on karma
     * @param role      //  sheriff=0, deputy=1, outlaw=2, renegade=3
     * @param hp        //  how many points he has
     */
    static public int Beer (char[][] karma,int spot,int role,int hp) {
        //System.out.print(karma.length+"Bang");
        //////////////////////////////////////////////////////////////////////////  Initialize variables
        int target=0;                                                           //  This chages as it finds better karma
        int targetSpot=spot;                                                    //  it works, dont fuc w it >:(
        int isDepDead=0;                                                        //  keep this here until ik how to add it
        ArrayList<Player> currentPlayers = new ArrayList<Player>();             //
        currentPlayers = Game.getPlayers();                                     //
        //////////////////////////////////////////////////////////////////////////  AI part
        switch (role) {                                                         //  
                case 0:                                                         //  Sheriff's decision making
                    if ((hp>6)&&(isDepDead!=0))                                 //  make sure ur not dying b4 healing other first
                        for (int j=0;j!=karma.length;++j)                       //  
                            if((Character.getNumericValue(karma[role][j])>target)&&(karma[role][j]!='x'))
                            {                                                   //  
                                target=Character.getNumericValue(karma[role][j]);// 
                                targetSpot=j;                                   //  
                            }                                                   //  
                    System.out.println("Player"+spot+" healed Player"+targetSpot);//  Heal target with good karma
                    break;                                                      //
                case 1:///////////////////////////////////////////////////////////  Deputy's decision making
                    if (hp<3)                                                   //  
                        System.out.println("Player"+spot+" healed Player"+targetSpot);//Heal himself
                    else                                                        //  
                    {                                                           //  
                        System.out.println("Player"+spot+" healed Player"+0);   //  Heal sheriff=0 
                        targetSpot=0;                                           //                
                    }                                                           //  
                    break;                                                      //  
                case 2:///////////////////////////////////////////////////////////  Outlaw's decision making
                    System.out.println("Player"+spot+" healed Player"+targetSpot);//  Heal himself             
                    break;                                                      //
                case 3:///////////////////////////////////////////////////////////  Renegade's decision making
                    if (hp<5)                                                   //  
                        System.out.println("Player"+spot+" healed Player"+targetSpot);//Heal himself
                    else if(isDepDead!=0)                                       //  
                    {                                                           //  
                        System.out.println("Player"+spot+" healed Player"+0);   //  Heal sheriff=0 
                        targetSpot=0;                                           //              
                    }                                                           //
                    else                                                        //  
                        System.out.println("Player"+spot+" healed Player"+targetSpot);//Heal himself nonetheless
                    break;                                                      //  
                default://////////////////////////////////////////////////////////  FuckyWucky's decision making
                    System.out.println("Player"+spot+" hurt itself in confusion");//     
                    break;                                                      //
            }                                                                   //
            try {                                                               //
                sleep(2000);                                                    //
            }                                                                   //
            catch (InterruptedException ex) {                                   //
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);//
            }                                                                   //
            
                    //    health = currentPlayers.get(targetSpot).getHealth();
                    //    health = health + 1;
                    //    currentPlayers.get(targetSpot).setHealth(health); 
            
        return targetSpot;////////////////////////////////////////////////////////  Return location to heal
    }
    /**
     * Bang             //  Shooting Method
     * @param karma     //  2D array
     * @param spot      //  Position located on karma
     * @param role      //  Sheriff=0, deputy=1, outlaw=2, renegade=3
     * @param range     //  Range of 1 or 2?
     */
    static public int Bang (char [][] karma,int spot,int role, int range) {
        //System.out.print(karma.length+"Bang");
        //////////////////////////////////////////////////////////////////////////  Initialize variables
        int target=9;                                                           //  0 for beer, 9 for bang
        int targetSpot=spot;                                                    //  it works, dont fuc w it >:(
        int spanR=spot+range;                                                   //  right bang range
        int spanL=spot-range;                                                   //  left bang range
        //////////////////////////////////////////////////////////////////////////  Lowest karma on the Right
        for (int j=spot+1;j!=(spanR+1);++j)                                     //  find the lowest number in the row
        {                                                                       //
            if(spanR>karma.length)                                              //  truncate span if passes array
                spanR=spanR-karma.length;                                       //
            if(j==karma.length)                                                 //  reset j to start if passes array
                j=0;                                                            //
            if(karma[role][j]=='x')                                             //  if x found, ignore and bump up span   
                ++spanR;                                                        //
            if (j==spanR)                                                       //  if both pointers touch, record
                if(Character.getNumericValue(karma[role][j])<target)            //  checks if target is better or not
                {                                                               //
                    target=Character.getNumericValue(karma[role][j]);           //  overwrites old target n stuff
                    targetSpot=j;                                               //
                }                                                               //
        }                                                                       //
        //////////////////////////////////////////////////////////////////////////  Lowest karma on the Left
        for (int j=spot-1;j!=(spanL-1);--j)                                     //  find the lowest number in the row  
        {                                                                       //
            if(spanL<0)                                                         //  truncate span if passes array
                spanL=spanL+karma.length;                                       //
            if(j==-1)                                                           //  reset j to start if passes array
                j=karma.length-1;                                               //
            if(karma[role][j]=='x')                                             //  if x found, ignore and bump up span
                --spanL;                                                        //
            if (j==(spanL))                                                     //  if both pointers touch, record
                if(Character.getNumericValue(karma[role][j])<target)            //  checks if target is better or not
                {                                                               //
                    target=Character.getNumericValue(karma[role][j]);           //  overwrites old target n stuff
                    targetSpot=j;                                               //
                }                                                               //
        }                                                                       //
        //////////////////////////////////////////////////////////////////////////  AI part with target in mind 
        switch (role) {                                                         //
                case 0:///////////////////////////////////////////////////////////  Sheriff's decision making
                    if (target>5)                                               //
                    {                                                           //  
                        System.out.println("Player"+spot+" rerolls");           //  dudes in range r good people
                        targetSpot=-1;                                          //  
                    }                                                           //  
                    else                                                        //
                        System.out.println("Player"+spot+" Bangs Player"+targetSpot+"!");//guns blazing
                    break;                                                      //
                case 1:///////////////////////////////////////////////////////////  Deputy's decision making
                    if (target>5)                                               //
                    {                                                           //  
                        System.out.println("Player"+spot+" rerolls");           //  dudes in range r good people
                        return -1;                                              //  
                    }                                                           //  
                    else                                                        //  
                        System.out.println("Player"+spot+" Bangs Player"+targetSpot+"!");//guns blazing
                    break;                                                      //  
                case 2:///////////////////////////////////////////////////////////  Outlaw's decision making
                        System.out.println("Player"+spot+" Bangs Player"+targetSpot+"!");//guns blazing
                    break;                                                      //  
                case 3:///////////////////////////////////////////////////////////  Renegade's decision making
                        System.out.println("Player"+spot+" Bangs Player"+targetSpot+"!");//guns blazing karma will be edited elsewhere         
                    break;                                                      //  
                default://////////////////////////////////////////////////////////  Whoops's decision making
                    System.out.println("Player"+spot+" hurt itself in confusion");//     
                    break;                                                      //  
            }                                                                   //
                        try {
                            sleep(2000);
                        }
                        catch (InterruptedException ex) {
                            Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
                        }        
        return targetSpot;////////////////////////////////////////////////////////  Returns position of target 
    }
}
//karma is a 2d array of all player's history for each player and depending on the 
// value in each position will determine who the player shoots. the sheriff will
// be at position 0 and all the players will fill in the array counter clockwise
// in the array. So if the sheriff gets shot by a person 2 distance away to his
// left from him the array will be as follows with 5 players. x
// karma_points:    x, 5, 4, 5, 5
//                  5, x, 5, 5, 5
//                  5, 5, x, 5, 5
//                  5, 5, 5, x, 5
//                  5, 5, 5, 5, x
    
//if the sheriff then gets shot by a person to his right but healed by a person
// from his left and the person 2 distance away from his right dies and reveals
// his roll it will look something like this. 
// karma_points:    x, 6, 4, x, 4
//                  5, x, 5, x, 5
//                  5, 5, x, x, 5
//                  x, x, x, x, x
//                  5, 5, 5, x, x
//
//Clearly this is only if the sheriff gets attacked and roles arent revealed yet
// because once roles start to get revealed karma will be used more or less
// depending on type of AI. So lets say a fresh game starts with 5 players. and 
// say all 5 players are AI. The players have their own rows and all start off
// with opinions about the sheriff because you want to kill or save him. Renagade
// will be a special case because his opinion of the sheriff will change once the 
// outlaws are dead.
// karma_points:    x, 5, 5, 5, 5   <Sheriff
//                  0, x, 5, 5, 5   <Outlaw1
//                  9, 5, x, 5, 5   <Renegade
//                  0, 5, 5, x, 5   <Outlaw2
//                  9, 5, 5, 5, x   <Deputy
    
//Lets say the Sheriff shoots deputy accidentally, outlaw1 shoots sheriff, renegade
// shoots outlaw to his right (outlaw1), outlaw2 shoots outlaw1, deputy heals
// sheriff.
// karma_points:    x, 4, 5, 5, 6   <Sheriff
//                  0, x, 4, 4, 5   <Outlaw1
//                  9, 5, x, 5, 5   <Renegade
//                  0, 5, 5, x, 5   <Outlaw2
//                  8, 5, 5, 5, x   <Deputy

//So now deputy has good karma in sheriff's eyes so when sheriff decides to shoot
// he wont shoot anyone with good karma. Thank you for coming to my ted talk.