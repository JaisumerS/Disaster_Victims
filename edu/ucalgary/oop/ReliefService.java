/**
 * @author Jaisumer Sandhu <a href = "mailto"; jaisumer.sandhu@ucalgary.ca>jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.oop;

import java.util.Scanner;

public class ReliefService {

	private static Scanner scanner = new Scanner(System.in);
	private Inquirer inquirer;
	private DisasterVictim missingPerson;
	private String dateOfInquiry;
	private String infoProvided;
	private Location lastKnownLocation;

	/**
	 * 
	 * @param inquirer who is the person who is asking (of type Inquirer)
	 * @param missingPerson disaster victim that the inquirer is looking for
	 * @param dateOfInquiry date the call was made
	 * @param infoProvided the information that was provided
	 * @param lastKnownLocation last known location of the disaster victim
	 */
	public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
		//there should be proper date format for Inquiry date
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for inquiry date. Expected format: YYYY-MM-DD");
        }
		this.inquirer = inquirer;
		this.missingPerson = missingPerson;
		this.dateOfInquiry = dateOfInquiry;
		this.infoProvided = infoProvided;
		this.lastKnownLocation = lastKnownLocation;
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

	/**
	 * 
	 * @return returns the inquirer object
	 */
	public Inquirer getInquirer() {
		return this.inquirer;
	}

	/**
	 * 
	 * @param inquirer sets the inquirer
	 */
	public void setInquirer(Inquirer inquirer) {
		this.inquirer = inquirer;
	}

	/**
	 * 
	 * @return gets the diaster victim aka the missing person
	 */
	public DisasterVictim getMissingPerson() {
		return this.missingPerson;
	}

	/**
	 * 
	 * @param missingPerson sets the missing person up as a disaster victim
	 */
	public void setMissingPerson(DisasterVictim missingPerson) {
		this.missingPerson = missingPerson;
	}

	/**
	 * 
	 * @return the date of the inquiry
	 */
	public String getDateOfInquiry() {
		return this.dateOfInquiry;
	}

	/**
	 * 
	 * @param dateOfInquiry sets up the date of the inquiry
	 */
	public void setDateOfInquiry(String dateOfInquiry) {
		//there should be proper date format for Inquiry date
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for inquiry date. Expected format: YYYY-MM-DD");
        }
		this.dateOfInquiry = dateOfInquiry;
	}

	/**
	 * 
	 * @return the info that was provided by the inquirer
	 */
	public String getInfoProvided() {
		return this.infoProvided;
	}

	/**
	 * 
	 * @param infoProvided sets up the info that was provided by the inquirer
	 */
	public void setInfoProvided(String infoProvided) {
		this.infoProvided = infoProvided;
	}

	/**
	 * 
	 * @return the last known location of the disaster victim
	 */
	public Location getLastKnownLocation() {
		return this.lastKnownLocation;
	}

	/**
	 * 
	 * @param lastKnownLocation sets up the last known location of the disaster victim
	 */
	public void setLastKnownLocation(Location lastKnownLocation) {
		this.lastKnownLocation = lastKnownLocation;
	}

	/**
	 * 
	 * @return a nice fromatted string, which includes all deatils of the call, including who it was, what it was for, and other call details
	 */
	public String getLogDetails() {
		Location lastKnownLocation = getLastKnownLocation();
		StringBuilder logDetails = new StringBuilder();
		logDetails.append("Inquirer: ").append(inquirer.getFirstName()).append(", ");
		logDetails.append("Missing Person: ").append(missingPerson.getFirstName()).append(", ");
		logDetails.append("Date of Inquiry: ").append(dateOfInquiry).append(", ");
		logDetails.append("Info Provided: ").append(infoProvided).append(", ");
		logDetails.append("Last Known Location: ").append(lastKnownLocation.getName());
		return logDetails.toString();
	}

	public static void main(String[] args){
		GeneralMain generalMain = new GeneralMain();
    
        boolean exit = false;
    
        while (!exit) {
            System.out.println("Welcome to the Disaster Management System!");
    
            System.out.println("Choose the mode of operation:");
            System.out.println("1. Location-based relief worker");
            System.out.println("2. Central-based relief worker");
            System.out.println("3. Exit");
    
            int mode = scanner.nextInt();
            scanner.nextLine();
    
            switch (mode) {
                case 1:
                    generalMain.locationMain();
                    break;
                case 2:
                    generalMain.centralMain();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    
        scanner.close();
    }

}