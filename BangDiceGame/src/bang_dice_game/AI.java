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
     *
     */
    public void Beer (char karma[][],int spot,int role) {
        int target=0;   
        int targetplayer=spot;
        int isDepDead=0;    //keep this here until ik what to do
        
        for (int j=spot;j!=karma.length;++j)
            if((Character.getNumericValue(karma[role][j])>target)&&(karma[role][j]!='x'))
            {
                target=Character.getNumericValue(karma[role][j]);
                targetplayer=j;
            }
        
                for (int i=0; i<karma.length; i++)
        {
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+"   ");
            System.out.println("\n");
        }
        
        System.out.print("\nBeer Player"+targetplayer+" with "+target+" karma");
    }
    public void Bang1 (char karma[][],int spot,int role) {
        int range=1;
        int target=9;           //0 for beer, 9 for bang
        int targetplayer=spot;  //it works, dont fuc w it >:(
        
        for (int i=0; i<karma.length; i++)
            for (int j=0; j<karma.length; j++)
                if(i==j)                    
                    karma[i][j]='x';
                else
                    karma[i][j]='5';
                    
        for (int i=0; i<karma.length; i++)
            for (int j=0; j<karma.length; j++)
                System.out.print(karma[i][j]+"   ");
            System.out.println("\n");
        
        //R snipe
        int spanR=spot+range;
        for (int j=spot+1;j!=(spanR+1);++j)//find the lowest number in the row
        {
            if(spanR>karma.length)  //iffy if = should be there
                spanR=spanR-karma.length;
            if(j==karma.length)
                j=0;

            if(karma[role][j]=='x')
                ++spanR;
              
            if (j==spanR)
                if(Character.getNumericValue(karma[role][j])<target)
                {
                    target=Character.getNumericValue(karma[role][j]);
                    targetplayer=j;
                }
        }
        int spanL=spot-range;
        for (int j=spot-1;j!=(spanL-1);--j)//find the lowest number in the row
        {
            if(spanL<0)
                spanL=spanL+karma.length;
            if(j==-1)
                j=karma.length-1;

            if(karma[role][j]=='x')
                --spanL;
              
            if (j==(spanL))
            {
                if(Character.getNumericValue(karma[role][j])<target)
                {
                    target=Character.getNumericValue(karma[role][j]);
                    targetplayer=j;
                }
            }
        }
        
        System.out.print("\nLShoot Player"+targetplayer+" with "+target+" karma ");
    }
    public void Bang2 () {
        
    }
}