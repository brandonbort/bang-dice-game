/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import java.util.*;

/**
 *
 * @author carlos144green
 */
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
public class AI {
    /**
     * Beer             class to heal peeps 
     * @param karma     2D array
     * @param spot      position located on karma
     * @param role      sheriff=0, deputy=1, outlaw=2, renegade=3
     * @param hp        how many points he has
     *
     */
    public void Beer (char karma[][],int spot,int role,int hp) {
        int target=0;   
        int targetplayer=spot;
        int isDepDead=0;    //keep this here until ik how to add it
        
        switch (role) {
                case 0:     //sheriff
                    if ((hp<7)||(isDepDead==0))
                        System.out.print("Player"+spot+" healed Player"+spot);          //Heal himself
                    else
                        for (int j=spot;j!=karma.length;++j)
                            if((Character.getNumericValue(karma[role][j])>target)&&(karma[role][j]!='x'))
                            {
                                target=Character.getNumericValue(karma[role][j]);
                                targetplayer=j;
                            }
                    System.out.print("Player"+spot+" healed Player"+targetplayer);      //Heal target with good karma
                    break;
                case 1:     //deputy
                    if (hp<3)
                        System.out.print("Player"+spot+" healed Player"+spot);          //Heal himself
                    else
                        System.out.print("Player"+spot+" healed Player"+0);             //Heal sheriff=0 
                    break;
                case 2:     //outlaw
                    System.out.print("Player"+spot+" healed Player"+spot);              //Heal himself
                    break;
                case 3:     //renegade
                    if (hp<5)
                        System.out.print("Player"+spot+" healed Player"+spot);          //Heal himself
                    else if(isDepDead!=0)
                        System.out.print("Player"+spot+" healed Player"+0);             //Heal sheriff=0 
                    else
                        System.out.print("Player"+spot+" healed Player"+spot);          //Heal himself nonetheless
                    break;
                default:    //whoops
                    System.out.print("Player"+spot+" hurt himself in confusion!?!?!");
                    break;
            }

        
    }
    public void Bang (char karma[][],int spot,int role, int range) {
        //////////////////////////////////////////////////////////////////////////  initializers
        int target=9;                                                           //  0 for beer, 9 for bang
        int targetplayer=spot;                                                  //  it works, dont fuc w it >:(
        int spanR=spot+range;                                                   //  right bang range
        int spanL=spot-range;                                                   //  left bang range
        //////////////////////////////////////////////////////////////////////////  right bang finder
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
                    targetplayer=j;                                             //
                }                                                               //
        }                                                                       //
        //////////////////////////////////////////////////////////////////////////  right bang finder
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
                    targetplayer=j;                                             //
                }                                                               //
        }                                                                       //
        //System.out.print("Bang"+targetplayer+" with "+target+" karma ");      //  publish results
        //////////////////////////////////////////////////////////////////////////
        switch (role) {                                                         //
                case 0:                                                         //  sheriff
                    if (target>5)                                               //
                        System.out.print("Player"+spot+" rerolls");             //  dudes in range r good people
                    else                                                        //
                        System.out.print("Player"+spot+" Bangs Player"+targetplayer+"!");//guns blazing
                    break;                                                      //
                case 1:                                                         //  deputy
                    if (targetplayer==0)                                        //
                        System.out.print("Player"+spot+" rerolls");             //  dudes in range r good people
                    else                                                        //  
                        System.out.print("Player"+spot+" Bangs Player"+targetplayer+"!");//guns blazing
                    break;                                                      //  
                case 2:                                                         //  outlaw
                        System.out.print("Player"+spot+" Bangs Player"+targetplayer+"!");//guns blazing                    
                    break;                                                      //  
                case 3:                                                         //  renegade
                        System.out.print("Player"+spot+" Bangs Player"+targetplayer+"!");//guns blazing karma will be edited elsewhere                    
                    break;                                                      //  
                default:                                                        //  whoops
                    System.out.print("Player"+spot+" hurt himself in confusion!?!?!");
                    break;                                                      //  
            }                                                                   //
        //////////////////////////////////////////////////////////////////////////
    }
}