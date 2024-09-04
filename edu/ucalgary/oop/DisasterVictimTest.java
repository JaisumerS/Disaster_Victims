/**
 * @author Jaisumer Sandhu <a href="mailto:jaisumer.sandhu@ucalgary.ca">
 * jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.12
 * @since 1.0
*/

package edu.ucalgary.oop;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DisasterVictimTest {

    private DisasterVictim victim;
    private DisasterVictim victim1;
    private DisasterVictim victim2;
    private HashSet<Supply> suppliesToSet = new HashSet<>(); 
    private HashSet<FamilyRelation> familyRelations = new HashSet<>();
    private Vector<MedicalRecord> medicalRecords = new Vector<>();
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female";
    private Location victimLocation;
    private static ArrayList<String> genderoptions = DisasterVictim.initializeGenderOptions();
    private String dateofbirth;
    private int age;
    private String expectedComments = "Needs medical attention and speaks 2 languages";
    enum DietMealTypes{
        AVML,
        DBML,
        GFML,
        KSML,
        LSML,
        MOML,
        PFML,
        VGML,
        VJML
    }
    
    /**
     * This sets up an example disaster victim to use before every test
     */
    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new HashSet<>();
        suppliesToSet.add(new Supply("Emergency Kit", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        victim.setVictimLocation(testLocation);
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
        medicalRecords.add(testRecord);

        victim1 = new DisasterVictim("Jane", "2024-01-20");
        victim2 = new DisasterVictim("John", "2024-01-22");

        Location testLocation1 = new Location("Shelter Z", "1234 Shelter Ave");
        victim1.setVictimLocation(testLocation1);
        MedicalRecord testRecord1 = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
        medicalRecords.add(testRecord1);

        victim1.getVictimLocation().setSupplies(suppliesToSet);
    }
    /**
     * This tests for an invalid entry date for a constructor
     */
    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }
    /**
     * This tests if an IllegalArgumentException is thrown due to an Invalid Entry Date
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }

    /**
     * Tests if setDateofBirth works
     */
    @Test
    public void testSetGetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    /**
     * tests if setting age works when birthdate is already set
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetAgeWithDateOfBirth() {
        victim.setDateOfBirth("1987-05-21");
        victim.setAge(38);
    }

    /**
     * tests if setAge works
     */
    @Test
    public void testSetGetAge() {
        DisasterVictim victim10 = new DisasterVictim("Alice", "2024-01-01");
        victim10.setAge(40);
        assertEquals("setAge should correctly update the age", 40, victim10.getAge());
    }

    /**
     * tests if setting birthdate works when age is already set
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithAge() {
        DisasterVictim victim4 = new DisasterVictim("Bob", "Doe", "2024-01-01");
        victim4.setAge(38);
        victim4.setDateOfBirth("1987-05-21");
    }


    /**
     * tests if IllegalArgumentException is thrown when there is invalid birthdate format
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
	
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidNegativeAge() {
        DisasterVictim victim10 = new DisasterVictim("Alice", "2024-01-01");
        int newage = -15;
        victim10.setAge(newage);
    }

    /**
     * tests set and get firstname
     */
	@Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    /**
     * tests set and get lastname
     */
    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    /**
     * tests if getComments works
     */
    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    /**
     * tests setcomments works
     */
    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    /**
     * tests if assigned social ID is one above the previously made disaster victim's ID
     */
    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    /**
     * tests if you can get entry date
     */
    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
    
    /**
     * tests set and get for a valid gender
     */
    @Test
    public void testSetAndGetValidGender() {
        String newGender = "man";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }

    /**
     * tests if IllegalArgumentException is thrown due to invalid gender option. (But many people do identify as helicopter)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidGender() {
        String newGender = "helicopter";
        victim.setGender(newGender);
    }

    /**
     * tests if you are able to add a family relation
     */
    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim12 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim13 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim12, "parent", victim13);

        victim12.addFamilyConnection(relation);
        
        assertTrue("addFamilyConnection should add a family relationship to victim1", victim12.containsconnection(relation));
        FamilyRelation fliprelation = new FamilyRelation(victim13, "child", victim12);
        assertTrue("addFamilyConnection should add the flip relationship to victim2", victim13.containsconnection(fliprelation));
    }

    /**
     * test if you can add a personal belonging
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddPersonalBelongingwithLowLocationSupplies() {
        Supply newSupply = new Supply("Emergency Kit", 11);
        victim.addPersonalBelonging(newSupply);
    }

    /**
     * test if you can add a personal belonging
     */
    @Test
    public void testAddPersonalBelonging() {
        suppliesToSet = new HashSet<>();
        suppliesToSet.add(new Supply("Emergency Kit", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        Location testLocation1 = new Location("Shelter Z", "1234 Shelter Ave");
        victim1.setVictimLocation(testLocation1);
        victim1.getVictimLocation().setSupplies(suppliesToSet);
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim1.addPersonalBelonging(newSupply);
        HashSet<Supply> testSupplies = victim1.getPersonalBelongings();
        boolean correct = testSupplies.contains(newSupply);
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

    /**
     * tests if you can remove a family connection
     */
    @Test
    public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);

        HashSet<FamilyRelation> originalRelations = new HashSet<>();
        originalRelations.add(relation1);
        originalRelations.add(relation2);
        victim.setFamilyConnections(originalRelations);

        DisasterVictim victim = new DisasterVictim("Freda", "2024-01-23");
        victim.addFamilyConnection(relation1);
        victim.addFamilyConnection(relation2);
        victim.removeFamilyConnection(relation1);

        HashSet<FamilyRelation> testFamily = victim.getFamilyConnections();
        boolean correct = true;

        if (testFamily.contains(relation1)) {
            correct = false;
        }
        assertTrue("removeFamilyConnection should remove the family member", correct);
    }

    /**
     * test if you can remove a personal belonging
     */
    @After
    public void testRemovePersonalBelonging() {
        Supply supplyToRemove = new Supply("Blanket", 2);
        victim1.addPersonalBelonging(supplyToRemove);
        victim1.removePersonalBelonging(supplyToRemove);
        HashSet<Supply> testSupplies = victim.getPersonalBelongings();
        assertFalse("removePersonalBelonging should remove the supply from personal belongings", testSupplies.contains(supplyToRemove));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingPersonalBelonging() {
        Supply nonExistingSupply = new Supply("Non-existing Supply", 1);
        victim.removePersonalBelonging(nonExistingSupply);
    }
    

    /**
     * tests if you can set family connection
     */
    @Test
    public void testSetFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        HashSet<FamilyRelation> expectedRelations = new HashSet<>();
        expectedRelations.add(relation);
        victim1.setFamilyConnections(expectedRelations);

       // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
       HashSet<FamilyRelation> actualRecords = victim1.getFamilyConnections();
       boolean correct = expectedRelations.equals(actualRecords);
       assertTrue("Family relation should be set", correct);
    }

    /**
     * tests if you can set medical records
     */
    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");

        Vector<MedicalRecord> newRecords = new Vector<>();
        newRecords.add(testRecord);
        victim.setMedicalRecords(newRecords);
        Vector<MedicalRecord> actualRecords = victim.getMedicalRecords();

        // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
        boolean correct = newRecords.equals(actualRecords);
        assertTrue("setMedicalRecords should correctly update medical records", correct);
    }

    /**
     * tests if you can set your personal belongings
     */
    @Test
    public void testSetPersonalBelongings() {
        DisasterVictim victim5 = new DisasterVictim("Tester", "2024-01-20");
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        victim5.setVictimLocation(testLocation);
        testLocation.setSupplies(suppliesToSet);
        Supply one = new Supply("Emergency Kit", 1);
        Supply two = new Supply("Blanket", 3);
        HashSet<Supply> newSupplies = new HashSet<>();
        newSupplies.add(one);
        newSupplies.add(two);

        victim5.setPersonalBelongings(newSupplies);
        HashSet<Supply> actualSupplies = victim5.getPersonalBelongings();

        // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
        boolean correct = newSupplies.equals(actualSupplies);
        assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
    }

    /**
     * tests if you can add medical records
     */
    @Test
    public void testAddMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord newRecord = new MedicalRecord(testLocation, "test for covid", "2024-01-09");
        victim.addMedicalRecord(newRecord);
        Vector<MedicalRecord> testRecords = victim.getMedicalRecords();
        boolean correct = testRecords.contains(newRecord);
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

    /**
     * tests if you can IllegalArgumentException is thrown if an illegal date is put in isValidDateFormat
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsValidDateFormat() {
        String invalidDate = "31-312025";
        DisasterVictim victim = new DisasterVictim("John", "Doe", "2024-03-21");
        victim.isValidDateFormat(invalidDate);
    }

    /**
     * tests get and set for dietary restrictions
     */
    @Test
    public void testSetandGetDietaryRestrictions(){
        DietMealTypes[] givendietaryRestrictions = {DietMealTypes.AVML, DietMealTypes.DBML};
        String[] expectedDietaryRestrictions = new String[givendietaryRestrictions.length];
        for (int i = 0; i < givendietaryRestrictions.length; i++) {
            expectedDietaryRestrictions[i] = givendietaryRestrictions[i].toString();
        }
        victim.setDietaryRestrictions(expectedDietaryRestrictions);
        String[] testDietaryRestrictions = victim.getDietaryRestrictions();

        assertEquals("Dietary restrictions should be set and retrieved correctly", expectedDietaryRestrictions, testDietaryRestrictions);
    }
}