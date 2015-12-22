/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.UUID;
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
public class ClubTest {
    
    public ClubTest() {
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
     * Test of addPlayerToClub method, of class Club.
     */
    @Test
    public void testAddPlayerToClub() {
        System.out.println("addPlayerToClub");
        Player p = null;
        Club instance = null;
        instance.addPlayerToClub(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Club.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Club instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Club.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Club instance = null;
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Club.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Club instance = null;
        UUID expResult = null;
        UUID result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class Club.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Club instance = null;
        ArrayList<UUID> expResult = null;
        ArrayList<UUID> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
