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
    public void SheriffTurn (char karma[][]) {
        //shoot1
        int spot=0;                                         //Sheriff position always
        int target=Character.getNumericValue(karma[0][1]);  //change 1 to 0 for any other roll
        for (int j=0; j<karma.length; j++)                  //find the lowest number in the row
        {
            if(karma[0][j]=='x')
                ;
            else if(Character.getNumericValue(karma[0][j])<target)
                target=Character.getNumericValue(karma[0][j]);
            else
                ;
        }
    }
    public void DeputyTurn () {
        
    }
    public void OutLawTurn () {
        
    }
    public void RenegadeTurn () {
        
    }
}