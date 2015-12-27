/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikkelmoerch
 */
public class PlayerFactoryTest {
    
    public PlayerFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of register method, of class Factory.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        int age = 10;
        String name = "Karl";
        Club club = new Club("Aab", 1920);
        Factory instance = new Factory();
        instance.register(10, "Karl", new Club("Aab", 1920));
        
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateClubs method, of class Factory.
     */
    @Test
    public void testGenerateClubs() {
        System.out.println("generateClubs");
        Factory instance = new Factory();
        instance.generateClubs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePersons method, of class Factory.
     */
    @Test
    public void testGeneratePersons() {
        System.out.println("generatePlayers");
        Factory instance = new Factory();
        instance.generatePlayers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFNCount method, of class Factory.
     */
    @Test
    public void testGetFNCount() {
        System.out.println("getFNCount");
        Factory instance = new Factory();
        int expResult = 0;
        int result = instance.getFNCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSNCount method, of class Factory.
     */
    @Test
    public void testGetSNCount() {
        System.out.println("getSNCount");
        Factory instance = new Factory();
        int expResult = 0;
        int result = instance.getSNCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSortedPlayerList method, of class Factory.
     */
    @Test
    public void testGetSortedPlayerList() {
        System.out.println("getSortedPlayerList");
        Factory instance = new Factory();
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getSortedPlayerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
