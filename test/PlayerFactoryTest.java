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
     * Test of register method, of class PersonFactory.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        int age = 10;
        String name = "Karl";
        Club club = new Club("Aab", 1920);
        PersonFactory instance = new PersonFactory();
        instance.register(10, "Karl", new Club("Aab", 1920));
        
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateClubs method, of class PersonFactory.
     */
    @Test
    public void testGenerateClubs() {
        System.out.println("generateClubs");
        PersonFactory instance = new PersonFactory();
        instance.generateClubs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generatePersons method, of class PersonFactory.
     */
    @Test
    public void testGeneratePersons() {
        System.out.println("generatePlayers");
        PersonFactory instance = new PersonFactory();
        instance.generatePlayers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFNCount method, of class PersonFactory.
     */
    @Test
    public void testGetFNCount() {
        System.out.println("getFNCount");
        PersonFactory instance = new PersonFactory();
        int expResult = 0;
        int result = instance.getFNCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSNCount method, of class PersonFactory.
     */
    @Test
    public void testGetSNCount() {
        System.out.println("getSNCount");
        PersonFactory instance = new PersonFactory();
        int expResult = 0;
        int result = instance.getSNCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSortedPlayerList method, of class PersonFactory.
     */
    @Test
    public void testGetSortedPlayerList() {
        System.out.println("getSortedPlayerList");
        PersonFactory instance = new PersonFactory();
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getSortedPlayerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
