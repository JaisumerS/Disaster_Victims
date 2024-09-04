/**
 * @author Jaisumer Sandhu <a href = "mailto"; jaisumer.sandhu@ucalgary.ca>jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.oop;

public class MedicalRecord {

	private Location location;
	private String treatmentDetails;
	private String dateOfTreatment;

	/**
	 * 
	 * @param location where the disaster victim was treated
	 * @param treatmentDetails what the treatment was
	 * @param dateOfTreatment when the patient got treated
	 */
	public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
		if (location == null || treatmentDetails == null || dateOfTreatment == null) {
			throw new IllegalArgumentException("Invalid arguments provided");
		}
		//there should be proper date format for treatment date
		if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment date. Expected format: YYYY-MM-DD");
        }
		this.location = location;
		this.treatmentDetails = treatmentDetails;
		this.dateOfTreatment = dateOfTreatment;
	}

	/**
	 * 
	 * @return the location of the treatment
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param location sets up the location of the treatment
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * 
	 * @return the treatment details and what it was about
	 */
	public String getTreatmentDetails() {
		return this.treatmentDetails;
	}

	/**
	 * 
	 * @param treatmentDetails sets up the treatment details and what it was about
	 */
	public void setTreatmentDetails(String treatmentDetails) {
		this.treatmentDetails = treatmentDetails;
	}

	/**
	 * 
	 * @return gets the date of the treatment
	 */
	public String getDateOfTreatment() {
		return this.dateOfTreatment;
	}

	/**
	 * 
	 * @param dateOfTreatment sets up the date of the treatment
	 */
	public void setDateOfTreatment(String dateOfTreatment) {
		if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment date. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
	}

	/**
	 * 
	 * @param date gets a string date and it makes sure the value matches the regex
	 * @return a boolean of 1 if it does match the foramt, otherwise and exception is thrown
	 * @throws IllegalArgumentException just incase it does not match
	 */
	public boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
		if (!date.matches(dateFormatPattern)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        return date.matches(dateFormatPattern);
    }
}