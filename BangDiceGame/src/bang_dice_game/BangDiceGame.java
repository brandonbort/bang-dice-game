/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import User_Interface_Components.*;

/**
 *
 * @author Brandon
 */
public class BangDiceGame{

    
    public static void main(String[] args) {
        StartScreenUserInterface boardUI = new StartScreenUserInterface();
        boardUI.launchGame(args);
    }
    
}
