/**
 * @author Jaisumer Sandhu <a href="mailto:jaisumer.sandhu@ucalgary.ca">
 * jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.3
 * @since 1.0
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;

public class LocationTest {
    private Location location;
    private DisasterVictim victim1;
    private DisasterVictim victim2;
    private Supply supply1;
    private Supply supply2;
    private String name;
    private String address;

    /**
     * prepares a location object, before all the tests
     */
    @Before
    public void setUp() {
        name = "Shelter XYZ";
        address = "6969 420 Ave";
        location = new Location(name, address);
        victim1 = new DisasterVictim("John Doe", "2024-02-29");
        victim2 = new DisasterVictim("Jane Doe", "2022-02-17");
        supply1 = new Supply("Chug Jug", 10);
        supply2 = new Supply("Jackets", 2);
        HashSet<DisasterVictim> occupants = new HashSet<>();
        occupants.add(victim1);
        occupants.add(victim2);
        HashSet<Supply> supplies = new HashSet<>();
        supplies.add(supply1);
        supplies.add(supply2);
    }

    /** 
     * Helper method to check if a supply is in the list
    */
    private boolean containsSupply(HashSet<Supply> supplies, Supply supplyToCheck) {
        return supplies.contains(supplyToCheck);
    }

    /**
     * tests if constructor is empty or not
     */
    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter XYZ", location.getName());
        assertEquals("Constructor should set the address correctly", "6969 420 Ave", location.getAddress());
    }

    /**
     * tests if set name works
     */
    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    /**
     * tests if set address works
     */
    @Test
    public void testSetAddress() {
        String newAddress = "4321 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    /**
     * tests if you are able to add occupant 
     */
    @Test
    public void testAddOccupant() {
        DisasterVictim victim3 = new DisasterVictim("Doe Jane", "2022-01-12");
        location.addOccupant(victim3);
        assertTrue("addOccupant should add a disaster victim to the occupants list", location.getOccupants().contains(victim3));
    }

    /**
     * tests if you can remove an occupant
     */
    @Test
    public void testRemoveOccupant() {
        DisasterVictim victim4 = new DisasterVictim("Richard Jenkins", "2023-04-25");
        location.addOccupant(victim4); // Ensure the victim is added first
        location.removeOccupant(victim4);
        assertFalse("removeOccupant should remove the disaster victim from the occupants list", location.getOccupants().contains(victim4));
    }

    /**
     * tests if you can set and get all occupants
     */
    @Test
    public void testSetAndGetOccupants() {
        DisasterVictim victim5 = new DisasterVictim("Akinde Rich", "2023-06-05");
        HashSet<DisasterVictim> newOccupants = new HashSet<>();
        newOccupants.add(victim5);
        location.setOccupants(newOccupants);
        assertTrue("setOccupants should replace the occupants list with the new list", location.getOccupants().containsAll(newOccupants));
    }

    /**
     * tests if you can add supply
     */
    @Test
    public void testAddSupply() {
        Supply supply3 = new Supply("Bandages", 5);
        location.addSupply(supply3);
        assertTrue("addSupply should add a supply to the supplies list", containsSupply(location.getSupplies(), supply3));
    }

    /**
     * tests if you can remove a supply
     */
    @Test
    public void testRemoveSupply() {
        Supply supply4 = new Supply("medkit", 2);
        location.addSupply(supply4); // Ensure the supply is added first
        location.removeSupply(supply4);
        assertFalse("removeSupply should remove the supply from the supplies list", containsSupply(location.getSupplies(), supply4));
    }

    /**
     * tests and set and get supplies
     */
    @Test
    public void testSetAndGetSupplies() {
        Supply supply5 = new Supply("Socks", 8);
        HashSet<Supply> newSupplies = new HashSet<>();
        newSupplies.add(supply5);
        location.setSupplies(newSupplies);
        assertTrue("setSupplies should replace the supplies list with the new list", containsSupply(location.getSupplies(), supply5));
    }
}
