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
interface PlayStratagy {
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
//                  0, 0, 0, 0, 0
//                  0, 0, 0, 0, 0
                    
    public int whoToShoot (int[][] karma_points, int[] role_revealed);     
    {
        
    }
    
    
    
}
