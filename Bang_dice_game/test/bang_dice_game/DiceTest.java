/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang_dice_game;

import static org.hamcrest.CoreMatchers.*;
import java.io.ByteArrayOutputStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.PrintStream;

/**
 *
 * @author airishimamura
 */
public class DiceTest {
    
    public DiceTest() {
    }
    private static PrintStream defaultPrintStream;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeClass
    public static void setUpClass() {
        defaultPrintStream = System.out;
        System.setOut(new PrintStream(outContent));
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        System.setOut(System.out);
    }

    /**
     * Test of firstRoll method, of class Dice.
     */
    @Test
    public void testFirstRoll() {
        
        System.out.println("firstRoll");
        // TODO review the generated test code and remove the default call to fail.
       
        assertNotNull(Dice.Dice_Face.dice[0]);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getrandNum method, of class Dice.
     */
    @Test
    public void testGetrandNum() {
        System.out.println("getrandNum");
        int expResult = 0;
        int result = Dice.getrandNum();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of BasicDice method, of class Dice.
     */
    @Test
    public void testBasicDice() {
        System.out.println("BasicDice");
        Dice instance = new Dice();
        instance.BasicDice();
        assertNotNull(instance.Result.get(0));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Saloon method, of class Dice.
     */
//    @Test
//    public void testSaloon() {
//        System.out.println("Saloon");
//        Dice instance = new Dice();
//        instance.Saloon();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of undeadOrAlive method, of class Dice.
     */
//    @Test
//    public void testUndeadOrAlive() {
//        System.out.println("undeadOrAlive");
//        Dice instance = new Dice();
//        instance.undeadOrAlive();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of reRoll method, of class Dice.
//     */
//    @Test
//    public void testReRoll() {
//        System.out.println("reRoll");
//        Dice instance = new Dice();
//        instance.reRoll();
//        assertNotNull(instance.Result.get(2));
//        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
 //   }

    /**
     * Test of getDice_Face method, of class Dice.
     */
//    @Test
//    public void testGetDice_Face() {
//        System.out.println("getDice_Face");
//        Dice instance = null;
//        Dice.Dice_Face expResult = null;
//        Dice.Dice_Face result = instance.getDice_Face();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       // fail("The test case is a prototype.");
//    }

    /**
     * Test of reRoll method, of class Dice.
     */
//    @Test
//    public void testReRoll() {
//        System.out.println("reRoll");
//        Dice.reRoll();
//        // TODO review the generated test code and remove the default call to fail.
//        
//        assertNotNull(Dice.Dice_Face.getRandomDice_Face());
//
//        //fail("The test case is a prototype.");
//    }
//    
}
