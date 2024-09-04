/**
 * @author Jaisumer Sandhu <a href="mailto:jaisumer.sandhu@ucalgary.ca">
 * jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.1
 * @since 1.0
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MedicalRecordTest {
    Location expectedLocation = new Location("ShelterA", "140 8 Ave NW ");
    private String expectedTreatmentDetails = "Broken arm treated";
    private String expectedDateOfTreatment = "2024-01-19";
    private String validDateOfTreatment = "2024-02-04";
    private String inValidDateOfTreatment = "2024/02/04";
    MedicalRecord medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);


    /**
     * tests if medical records is empty or not
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(medicalRecord);
    }	
	
    /**
     * tests if you can retrieve location
     */
    @Test
    public void testGetLocation() {
        assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    /**
     * tests if you can set location
     */
    @Test
    public void testSetLocation() {
	    Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
	    medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    /**
     * tests you can retrieve from treatment details
     */
    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
    }

    /**
     * tests if you can set treatment details
     */
    @Test
    public void testSetTreatmentDetails() {
	    String newExpectedTreatment = "No surgery required";
	    medicalRecord.setTreatmentDetails(newExpectedTreatment);
        assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }

    /**
     * tests if you can get the date of treatment
     */
    @Test
    public void testGetDateOfTreatment() {
        assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
	
    /**
     * tests if you can set date of treatment
     */
	@Test
    public void testSetDateOfTreatment() {
	    String newExpectedDateOfTreatment = "2024-02-05";
	    medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
        assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
    /**
     * tests if you can set date with valid date format
     */
	@Test
    public void testSetDateOfTreatmentWithValidFormat() {
        
        medicalRecord.setDateOfTreatment(validDateOfTreatment); // Should not throw an exception
    }

    /**
     * tests if you can set date of birth with invalid date format
     */
    @Test
    public void testSetDateOfBirthWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
           medicalRecord.setDateOfTreatment(inValidDateOfTreatment); // Should throw IllegalArgumentException
        }
        catch (IllegalArgumentException e) {
           correctValue = true;
        }
        catch (Exception e) {
           failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    /**
     * tests if you can set date of birth with empty date, must throw exception
     */
    @Test
    public void testSetDateOfBirthWithNotADate() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
           medicalRecord.setDateOfTreatment(expectedTreatmentDetails); // Should throw IllegalArgumentException
        }
        catch (IllegalArgumentException e) {
           correctValue = true;
        }
        catch (Exception e) {
           failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid non-date input '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    /**
     * checks if an IllegalArgumentException is thrown if an invalid date is used
     */
    @Test(expected = IllegalArgumentException.class)
    public void testisValidDateFormat() {
        String invaliddate = "20255-31-31";
        medicalRecord.isValidDateFormat(invaliddate);
    }
}
