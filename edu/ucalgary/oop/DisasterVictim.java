/**
 * @author Jaisumer Sandhu <a href = "mailto"; jaisumer.sandhu@ucalgary.ca>jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.8
 * @since 1.0
 */

package edu.ucalgary.oop;
import java.util.*;
import java.io.*;

public class DisasterVictim {

	private static int counter = 0;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private int age;
	private String comments;
	private Vector<MedicalRecord> medicalRecords = new Vector<>();
	private HashSet<FamilyRelation> familyConnections = new HashSet<>();
	private HashSet<Supply> personalBelongings = new HashSet<>();
	private String gender;
	private final int ASSIGNED_SOCIAL_ID;
	private final String ENTRY_DATE;
	private Location victimLocation;
	private static ArrayList<String> genderoptions = initializeGenderOptions();
	private String[] dietaryRestrictions;
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
	 * 
	 * @param firstName
	 * @param ENTRY_DATE
	 */
	public DisasterVictim(String firstName, String ENTRY_DATE) {
		//there should be proper date format for entry date
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
		//throws exception if firstname is empty
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException("First name cannot be null or empty");
		}
		//intializes main 
		this.firstName = firstName;
		this.ENTRY_DATE = ENTRY_DATE;
		this.ASSIGNED_SOCIAL_ID = generateSocialID();
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param ENTRY_DATE
	 */
	public DisasterVictim(String firstName, String lastName, String ENTRY_DATE) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    public DisasterVictim(String firstName, String lastName, String dateOfBirth, String ENTRY_DATE) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }

		this.ENTRY_DATE = ENTRY_DATE;
        this.dateOfBirth = dateOfBirth;
		this.age = 0;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

	public DisasterVictim(String firstName, String lastName, Location vicloc, String ENTRY_DATE) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
		this.ENTRY_DATE = ENTRY_DATE;
		this.victimLocation = vicloc;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

	public boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
		if (!date.matches(dateFormatPattern)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        return date.matches(dateFormatPattern);
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @param firstName firstname of disaster victim as a string
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @param lastName lastname of disaster victim as a string
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * 
	 * @param dateOfBirth date of birth of disaster victim as a string
	 */
	public void setDateOfBirth(String dateOfBirth) {
		if (this.age != 0) {
			throw new IllegalArgumentException("Age is already set. Cannot set date of birth.");
		}
		
		if (!isValidDateFormat(dateOfBirth)) {
			throw new IllegalArgumentException("Invalid date format for birthdate. Expected format: YYYY-MM-DD");
		}
		
		this.dateOfBirth = dateOfBirth;
		
		this.age = 0;
	}
	/**
	 * 
	 * @return the age of the person
	 */
	public int getAge(){
		return this.age;
	}

	/**
	 * 
	 * @param age that you will set if dateofbirth isnt set
	 */
	public void setAge(int age){
		if (this.dateOfBirth != null) {
			throw new IllegalArgumentException("Date of birth is already set. Cannot set age.");
		}

		if (age < 0) {
			throw new IllegalArgumentException("Age must be greater than 0.");
		}

		this.age = age;
		this.dateOfBirth = null;
	}

	/**
	 * 
	 * @return the comments
	 */
	public String getComments() {
		return this.comments;
	}

	/**
	 * 
	 * @param comments any additional comments of disaster victim as a string
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * 
	 * @param residenceLocation give a location to set the location to for the victim
	 */
	public void setVictimLocation(Location residenceLocation){
		this.victimLocation = residenceLocation;
	}

	/**
	 * 
	 * @return get the location of victim
	 */
	public Location getVictimLocation(){
		return this.victimLocation;
	}

	/**
	 * 
	 * @return medical records
	 */
	public Vector<MedicalRecord> getMedicalRecords() {
		return this.medicalRecords;
	}

	/**
	 * 
	 * @param medicalRecord medical record of disaster victim as a string
	 */
	public void setMedicalRecords(Vector<MedicalRecord> medicalRecord) {
		this.medicalRecords.clear();
		this.medicalRecords = medicalRecord;
		this.victimLocation = this.medicalRecords.get(0).getLocation();
	}

	/**
	 * 
	 * @return get the family connections
	 */
	public HashSet<FamilyRelation> getFamilyConnections() {
		return this.familyConnections;
	}


	/**
	 * 
	 * @param familyConnections family relatives of disaster victim as FamilyRelation objects
	 */
	public void setFamilyConnections(HashSet<FamilyRelation> familyconnections) {
		this.familyConnections.clear();
		for (FamilyRelation temp : familyconnections) {
            addFamilyConnection(temp);
        }
	}

	/**
	 * 
	 * @return get the personal belongings
	 */
	public HashSet<Supply> getPersonalBelongings() {
		return this.personalBelongings;
	}

	/**
	 * 
	 * @param personalBelongings any of the disaster victim's personal belongings as Supply object
	 */
	public void setPersonalBelongings(HashSet<Supply> personalbelongings) {
		this.personalBelongings.clear();
		for (Supply temp : personalbelongings) {
            addPersonalBelonging(temp);
        }
	}

	/**
	 * 
	 * @return the gender of the victim
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * 
	 * @param genders the gender of the vicitm, checks if it is part of one of the gender options
	 */
	public void setGender(String genders) {
		if (!genderoptions.contains(genders.toLowerCase())) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are: " + genderoptions);
        }
		this.gender = genders.toLowerCase();
	}

	/**
	 * 
	 * @param gender gender of disaster victim as a string
	 */
	public static ArrayList<String> initializeGenderOptions(){
		ArrayList<String> options = new ArrayList<>();
		if (genderoptions == null){
			Scanner scan = null;
			try {
				scan = new Scanner(new BufferedReader(new FileReader("edu/ucalgary/oop/GenderOptions.txt")));
				while (scan.hasNextLine()) {
					options.add(scan.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				e.printStackTrace();
			} finally {
				if (scan != null) {
					scan.close();
				}
			}
		}
		return options;
	}

	/**
	 * 
	 * @return the static list of gender options
	 */
	public ArrayList<String> getGenderOptions(){
		return genderoptions;
	}

	/**
	 * 
	 * @param supply adding supply to the supply list of disaster victim
	 */
	public void addPersonalBelonging(Supply supply) {
		boolean atlocation = false;
		boolean inBelongings = false;
		for (Supply temp: this.victimLocation.getSupplies()){
			if((temp.getType() == supply.getType()) && (temp.getQuantity() - supply.getQuantity() >= 0)){
				temp.removeQuantity(supply.getQuantity());
				atlocation = true;
				break;
			}
		}
		if (atlocation){
			for (Supply temp: this.getPersonalBelongings()){
				if (temp.getType() == supply.getType()){
					temp.addtoQuantity(supply.getQuantity());
					inBelongings = true;
					break;
				}
			}
			if (!inBelongings){
				this.personalBelongings.add(supply);
			}
		}
		else{
			throw new IllegalArgumentException("There are not enough supplies at victim's location to give out");
		}
	}

	/**
	 * 
	 * @param supply removing supply from the supply list of disaster victim if it is in previous array
	 */
	public void removePersonalBelonging(Supply supply) {
		boolean removedsupply = false;
		boolean updatedsupply = false;
		int amountchanged = 0;
		for (Supply temp: this.getPersonalBelongings()){
			if (temp.getType() == supply.getType()){
				if (temp.getQuantity() - supply.getQuantity() <= 0){
					amountchanged = temp.getQuantity();
					this.personalBelongings.remove(temp);
					supply.setQuantity(temp.getQuantity());
					removedsupply = true;
				}
				else{
					temp.removeQuantity(supply.getQuantity());
					updatedsupply = true;
				}
				break;
			}
		}
		boolean atlocation = false;
		if (updatedsupply){
			for (Supply temp : victimLocation.getSupplies()){
				if (temp.getType() == supply.getType())
					temp.addtoQuantity(supply.getQuantity());
					atlocation = true;
					break;
			}
			if (!atlocation){
				victimLocation.addSupply(supply);
			}
		}
		else if (removedsupply){
			for (Supply temp : victimLocation.getSupplies()){
				if (temp.getType() == supply.getType())
					temp.addtoQuantity(amountchanged);
					atlocation = true;
					break;
			}
			if (!atlocation){
				victimLocation.addSupply(supply);
			}
		}
		else{
			throw new IllegalArgumentException("The supply you want to remove is not in this person's belongings");
		}
	}


	/**
	 * 
	 * @param familyConnection adding another family connection as Family Relation Object
	 */
	public void addFamilyConnection(FamilyRelation familyConnection) {
		DisasterVictim temp1 = familyConnection.getPersonOne();
		DisasterVictim temp2 = familyConnection.getPersonTwo();
		FamilyRelation fliprelation = relationFlipper(familyConnection);
		if (temp1.containsconnection(familyConnection)){
			if(!temp2.containsconnection(fliprelation)){
				temp2.getFamilyConnections().add(fliprelation);
			}
		}
		else if(temp2.containsconnection(fliprelation)){
			temp1.getFamilyConnections().add(familyConnection);
		}
		else{
			temp1.getFamilyConnections().add(familyConnection);
			temp2.getFamilyConnections().add(fliprelation);
		}
		return;
	}

	/**
	 * 
	 * @param tempconnection is a temporary family connection that is being passed, to flip the relation
	 * @return the flipped relation: fliprelation
	 */
	public FamilyRelation relationFlipper(FamilyRelation tempconnection){
		DisasterVictim temp1 = tempconnection.getPersonOne();
		DisasterVictim temp2 = tempconnection.getPersonTwo();
		String temprelation = tempconnection.getRelationshipTo();
		String oppRel;
        if (temprelation == "parent") {
            oppRel = "child";
        }
        else if (temprelation == "child") {
            oppRel = "parent";
        }
        else {
            oppRel = temprelation;
        }
		FamilyRelation fliprelation = new FamilyRelation(temp2, oppRel, temp1);
		return fliprelation; //CHECK
	}

	/**
	 * 
	 * @param tempconnection is a temporary family connection that is being passed, to check if it is part of family connections HashSet
	 * @return boolean number which lets user know if tempconnection is in the HashSet of family connections
	 */
	public boolean containsconnection(FamilyRelation tempconnection){
		boolean check = false;
		for (FamilyRelation temp : this.familyConnections) {
            if (temp.getPersonOne().equals(tempconnection.getPersonOne()) && temp.getPersonTwo().equals(tempconnection.getPersonTwo()) && 
                temp.getRelationshipTo().equals(tempconnection.getRelationshipTo())) {
                    check = true;
            }
        }
		return check;
	}

	/**
	 * 
	 * @param familyConnection removing a family connection as Family Relation Object if it is in previous array
	 */
	public void removeFamilyConnection(FamilyRelation familyConnection) {
		DisasterVictim temp1 = familyConnection.getPersonOne();
		DisasterVictim temp2 = familyConnection.getPersonTwo();
		FamilyRelation fliprelation = relationFlipper(familyConnection);
		if (temp1.containsconnection(familyConnection)){
			temp1.getFamilyConnections().remove(familyConnection);
			if (temp2.containsconnection(fliprelation)){
				temp2.getFamilyConnections().remove(fliprelation);
				return;
			}
			else{
				return;
			}
		}
		else if(temp2.containsconnection(fliprelation)){
			temp2.getFamilyConnections().remove(fliprelation);
			return;
		}
		else{
			throw new IllegalArgumentException("Must be an accessbile/existing connection that you are removing");
		}
	}

	/**
	 * 
	 * @param medicalRecord adding to the list of medical records
	 */
	public void addMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecords.add(medicalRecord);
	}

	/**
	 * 
	 * @return the ID
	 */
	public int getAssignedSocialID() {
		return this.ASSIGNED_SOCIAL_ID;
	}

	/**
	 * 
	 * @return the entry date
	 */
	public String getEntryDate() {
		return this.ENTRY_DATE;
	}

	/**
	 * give the typed out version of the dietary restrictions
	 */
	public void RestrictionDescription(){
		for (String restriction : this.dietaryRestrictions) {
            typedout(DietMealTypes.valueOf(restriction));
        }
	}

	/**
	 * 
	 * @return the victim's dietary restrictions
	 */
	public String[] getDietaryRestrictions() {
		return this.dietaryRestrictions;
	}

	/**
	 * 
	 * @param mRestriction is the list of dietary restrictions based on
	 */
    public void setDietaryRestrictions(String[] mRestriction) {
        Set<String> allRestrictions = new HashSet<>();
        for (DietMealTypes restriction : DietMealTypes.values()) {
            allRestrictions.add(restriction.toString());
        }

        for (String type : mRestriction) {
            if (!allRestrictions.contains(type)) {
                throw new IllegalArgumentException("This dietary restriction does not exist: " + type);
            }
        }
        this.dietaryRestrictions = mRestriction;
    }

	/**
	 * 
	 * @param mtype each type of meal type in the DIETMEALTYPE Enumeration class, that is already implemented straight into the disastervictim
	 */
	public static void typedout(DietMealTypes mtype) {
        switch(mtype) {
            case AVML:
                System.out.println(mtype + ": Asian vegetarian meal.");
                break;
            case DBML:
                System.out.println(mtype + ": Diabetic meal.");
                break;
            case GFML:
                System.out.println(mtype + ": Gluten intolerant meal.");
                break;
            case KSML:
                System.out.println(mtype + ": Kosher meal.");
                break;
            case LSML:
                System.out.println(mtype + ": Low salt meal.");
                break;
            case MOML:
                System.out.println(mtype + ": Muslim meal.");
                break;
            case PFML:
                System.out.println(mtype + ": Peanut-free meal.");
                break;
            case VGML:
                System.out.println(mtype + ": Vegan meal.");
                break;
            case VJML:
                System.out.println(mtype + ": Vegetarian Jain meal.");
                break;
        }
    }
}