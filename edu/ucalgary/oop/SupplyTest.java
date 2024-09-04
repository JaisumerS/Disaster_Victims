package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    private Supply supply;
    private String expectedType = "Blanket";
    private int expectedQuantity = 5;
    
    /**
     * prepares Supply object to be used before every test
     */
    @Before
    public void setUp() {
        supply = new Supply(expectedType, expectedQuantity); // Initialize instance variable
    }

    /**
     * tests if constructor works
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(supply);
    }
	
    /**
     * tests if type can be retrieved
     */
    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", expectedType, supply.getType());
    }

    /**
     * tests if you can set type
     */
    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("setType should update the type", "Food", supply.getType());
    }

    /**
     * tests if you can retrieve quantity
     */
    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", expectedQuantity, supply.getQuantity());
    }

    /**
     * tests if you can set quantity 
     */
    @Test
    public void testSetQuantity() {
        supply.setQuantity(20);
        assertEquals("setQuantity should update the quantity", 20, supply.getQuantity());
    }

    /**
     * tests if you can add to quantity after every test
     */
    @Test
    public void testAddToQuantity() {
        supply.addtoQuantity(8);
        assertEquals("addtoQuantity should add to the quantity", 13, supply.getQuantity());
    }

    /**
     * tests if you can remove quantity after every test
     */
    @Test
    public void testRemoveQuantity() {
        supply.removeQuantity(2);
        assertEquals("removeQuantity should remove from the quantity", 3, supply.getQuantity());
    }
}