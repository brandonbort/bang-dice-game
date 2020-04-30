/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

/**
 *
 * @author carlos144green
 */
interface PlayStrategy {
//karma is a 2d array of all player's history for each player and depending on the 
// value in each position will determine who the player shoots. the sheriff will
// be at position 0 and all the players will fill in the array counter clockwise
// in the array. So if the sheriff gets shot by a person 2 distance away to his
// left from him the array will be as follows with 5 players
// karma_points:    0, 0,-1, 0, 0
//                  0, 0, 0, 0, 0
//                  0, 0, 0, 0, 0
//                  0, 0, 0, 0, 0
//                  0, 0, 0, 0, 0
    
//if the sheriff then gets shot by a person to his right but healed by a person
// from his left and the person 2 distance away from his right dies and reveals
// his roll it will look something like this. x=null
// karma_points:    1, 0,-1, x,-1
//                  0, 0, 0, 0, 0
//                  0, 0, 0, 0, 0
//                  x, x, x, x, x
//                  0, 0, 0, 0, 0
//
//Clearly this is only if the sheriff gets attacked and roles arent revealed yet
// because once roles start to get revealed karma will be used more or less
// depending on type of AI. So lets say a fresh game starts with 5 players. and 
// say all 5 players are AI. The players have their own rows and all start off
// with opinions about the sheriff because you want to kill or save him. Renagade
// will be a special case because his opinion of the sheriff will change once the 
// outlaws are dead.
// karma_points:    0, 0, 0, 0, 0   <Sheriff
//               -100, 0, 0, 0, 0   <Outlaw1
//                100, 0, 0, 0, 0   <Renegade
//               -100, 0, 0, 0, 0   <Outlaw2
//                100, 0, 0, 0, 0   <Deputy
    
//Lets say the Sheriff shoots deputy accidentally, outlaw1 shoots sheriff, renegade
// shoots outlaw to his right (outlaw1), outlaw2 shoots outlaw1, deputy heals
// sheriff.
// karma_points:    0,-1, 0, 0, 1   <Sheriff
//               -100, 0,-1,-1, 0   <Outlaw1
//                100, 0, 0, 0, 0   <Renegade
//               -100, 0, 0, 0, 0   <Outlaw2
//                 99, 0, 0, 0, 0   <Deputy

//So now deputy has good karma in sheriff's eyes so when sheriff decides to shoot
// he wont shoot anyone with good karma. Thank you for coming to my ted talk.
    public int whoToShoot (int[][] karma_points, int[] role_revealed);     
    {
        
    }
    
    
    
}
