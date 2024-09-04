package edu.ucalgary.oop;

import java.util.Scanner;
import java.util.*;
import java.sql.*;


public class GeneralMain implements LocationReliefMain, CentralReliefMain{
    private Connection dbConnect;
    private ResultSet results;
    private static Scanner scanner = new Scanner(System.in);

    public GeneralMain(){}
    public void locationMain() {
        System.out.println("Welcome to the Disaster Management System, as a central-based relief worker!");

        while (true) {
            System.out.println("\nChoose an option (type the number):");
            System.out.println("1. Add a new Disaster Victim");
            System.out.println("2. Add a Family Connection");
            System.out.println("3. Add a Medical Record");
            System.out.println("4. Exit");
            System.out.println("!*More Functions will be added later!*");
            System.out.println("!*More functions related to DisasterVictim are under Maintenance, ");
            System.out.println("feel free to browse through the upcoming updates in the DisasterVictim.java file!*");
            System.out.println("Enter the number below-");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    addDisasterVictim();
                    break;
                case 2:
                    addfamilyconnection();
                    break;
                case 3:
                    addMedicalRecord();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public void centralMain(){
        HashSet<Location> locationList = new HashSet<>();
        Location sparkIndustries = new Location("Spark Industries", "69 Spark Ave");
        Location foothillsHospital = new Location("Foothill's Hospital", "Centre Street");
        DisasterVictim Dave = new DisasterVictim("Dave", "2023-01-05");
        DisasterVictim Billy = new DisasterVictim("Billy", "2023-01-06");
        DisasterVictim Biller = new DisasterVictim("Biller", "2023-01-07");
        DisasterVictim Cheesebob = new DisasterVictim("Cheesebob", "2023-01-08");
        sparkIndustries.addOccupant(Dave);
        sparkIndustries.addOccupant(Billy);
        foothillsHospital.addOccupant(Biller);
        foothillsHospital.addOccupant(Cheesebob);
        locationList.add(sparkIndustries);
        locationList.add(foothillsHospital);

        System.out.println("Welcome to the Disaster Management System, as a central-based relief worker!");

        while (true) {
            System.out.println("\nChoose an option (type the number):");
            System.out.println("1. Search a Disaster Victim");
            System.out.println("2. Log any Inquirer's Query");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    SearchDisasterVictim(locationList);
                    break;
                case 2:
                    inquirerSQLInteracter();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void addDisasterVictim() {
        System.out.println("Enter victim's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter victim's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the location's name:");
        String location= scanner.nextLine();
        System.out.println("Enter the address of the location:");
        String locationaddress = scanner.nextLine();
        Location victimloc = new Location(location, locationaddress);
        DisasterVictim victim = new DisasterVictim(firstName, lastName, "2024-03-21");

        victimloc.addOccupant(victim);
        System.out.println("Disaster Victim added successfully!");
    }

    private static void addfamilyconnection() {
        System.out.println("Enter victim's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter victim's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the location's name:");
        String locationName = scanner.nextLine();
        System.out.println("Enter the address of the location:");
        String locationAddress = scanner.nextLine();
    
        Location victimLocation = new Location(locationName, locationAddress);
    
        System.out.println("Enter victim's date of birth (YYYY-MM-DD):");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter victim's entry date (YYYY-MM-DD):");
        String entryDate = scanner.nextLine();
    
        DisasterVictim victim = null; 
    
        boolean victimExists = false;
        for (DisasterVictim occupant : victimLocation.getOccupants()) {
            if (occupant.getFirstName().equals(firstName) && occupant.getLastName().equals(lastName)) {
                victim = occupant;
                victimExists = true;
                break;
            }
        }
    
        if (!victimExists) {
            victim = new DisasterVictim(firstName, lastName, dateOfBirth, entryDate);
            victimLocation.addOccupant(victim);
        }
    
        System.out.println("Enter the first name of the person you want to relate to:");
        String relatedFirstName = scanner.nextLine();
        System.out.println("Enter the last name of the person you want to relate to:");
        String relatedLastName = scanner.nextLine();
        System.out.println("Enter the relationship between the victim and the related person out of the following options:");
        System.out.println("child");
        System.out.println("parent");
        System.out.println("spouse");
        System.out.println("sibling");
        System.out.println("Type the relationship from victim to the related person:");
        String relation = scanner.nextLine();
    
        DisasterVictim relatedPerson = null;
    
        boolean relatedPersonExists = false;
        for (DisasterVictim occupant : victimLocation.getOccupants()) {
            if (occupant.getFirstName().equals(relatedFirstName) && occupant.getLastName().equals(relatedLastName)) {
                relatedPerson = occupant;
                relatedPersonExists = true;
                break;
            }
        }
    
        if (!relatedPersonExists) {
            relatedPerson = new DisasterVictim(relatedFirstName, relatedLastName, "2024-03-21");
            victimLocation.addOccupant(relatedPerson);
        }
    
        if (victim != null) {
            victim.addFamilyConnection(new FamilyRelation(victim, relation, relatedPerson));
            System.out.println("Disaster Victim added successfully!");
        } else {
            System.out.println("Failed to add family connection: Victim not found.");
        }
    }

    private static void addMedicalRecord() {
        System.out.println("Enter victim's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter victim's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter the location's name:");
        String locationName = scanner.nextLine();
        System.out.println("Enter the address of the location:");
        String locationAddress = scanner.nextLine();
    
        Location victimLocation = new Location(locationName, locationAddress);
    
        System.out.println("Enter victim's date of birth (YYYY-MM-DD):");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter victim's entry date (YYYY-MM-DD):");
        String entryDate = scanner.nextLine();
    
        DisasterVictim victim = null;
    
        boolean victimExists = false;
        for (DisasterVictim occupant : victimLocation.getOccupants()) {
            if (occupant.getFirstName().equals(firstName) && occupant.getLastName().equals(lastName)) {
                victim = occupant;
                victimExists = true;
                break;
            }
        }
    
        if (!victimExists) {
            victim = new DisasterVictim(firstName, lastName, dateOfBirth, entryDate);
            victimLocation.addOccupant(victim);
        }
    
        System.out.println("Enter location of treatment:");
        String treatmentLocationName = scanner.nextLine();
        System.out.println("Enter address of the location of treatment:");
        String treatmentLocaddress = scanner.nextLine();
        System.out.println("Enter treatment details:");
        String treatmentDetails = scanner.nextLine();
        System.out.println("Enter date of treatment (YYYY-MM-DD):");
        String dateOfTreatment = scanner.nextLine();
    
        Location treatmentLocation = new Location(treatmentLocationName, treatmentLocaddress);
        MedicalRecord medicalRecord = new MedicalRecord(treatmentLocation, treatmentDetails, dateOfTreatment);

        victim.addMedicalRecord(medicalRecord);
        System.out.println("Medical record added successfully!");
    }


    private static void SearchDisasterVictim(HashSet<Location> locations){
        System.out.println("Enter the name of the disaster victim you are looking for.");
        System.out.println("(You may search up part of the name, if the full spelling is unknown):");
        String victimName = scanner.nextLine();
        for (String name: findDisasterVictims(locations, victimName)){
            System.out.println(name);
        }
    }

    private static ArrayList<String> findDisasterVictims(HashSet<Location> locations, String name) {
        String partialName = name.toLowerCase();
        ArrayList<String> names = new ArrayList<>();
        for (Location place : locations) {
            for (DisasterVictim occupant : place.getOccupants()) {
                String occName = occupant.getFirstName().toLowerCase();

                if (occName.contains(partialName)) {
                    names.add(occupant.getFirstName());
                }
            }
        }
        return names;
    }

    private void inquirerSQLInteracter() {
        System.out.println("Do you want to interact with the database? (yes/no)");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            createConnection();
    
            String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
            String phoneFormatPattern = "^\\d{3}-\\d{3}-\\d{4}$";
    
            String fName, lName, inquirerInfo;
            String phoneNum = "999-999-9999";
            String dateofInquiry = "9999-99-99";
            System.out.println("Give me the firstname, lastname (if known), phonenumber(XXX-XXX-XXXX), the date of inquiry(YYYY-MM-DD),");
            System.out.println("and the information given of the inquirer you wish to search for:");
            System.out.println("Firstname:");
            fName = scanner.nextLine();
            System.out.println("Lastname (optional):");
            lName = scanner.nextLine();
            
            boolean validDate = false;
            while (!validDate) {
                System.out.println("Date of Inquiry:");
                dateofInquiry = scanner.nextLine();
                if (dateofInquiry.matches(dateFormatPattern)) {
                    validDate = true;
                } else {
                    System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
                }
            }
    
            boolean validPhone = false;
            while (!validPhone) {
                System.out.println("Phone-number:");
                phoneNum = scanner.nextLine();
                if (phoneNum.matches(phoneFormatPattern)) {
                    validPhone = true;
                } else {
                    System.out.println("Invalid phone number format. Please use XXX-XXX-XXXX format.");
                }
            }
    
            System.out.println("Inquirer Info:");
            inquirerInfo = scanner.nextLine();
    
            Inquirer tempinq = new Inquirer(fName, lName, phoneNum, inquirerInfo);
            logInquirerQuery(tempinq, dateofInquiry, inquirerInfo);
            System.out.println("Inquirer successfully added!!!!");
            close();
        }
    }

    public void logInquirerQuery(Inquirer newInquirer, String dateofinq, String inqinfo) {
        int inquirerID = checkexistinginquirer(newInquirer);
        if (inquirerID != 0) {
            addtoInquiryLog(inquirerID, dateofinq, inqinfo); //switch
        }
        else {
            addNewInquirer(newInquirer);
            int newID = checkexistinginquirer(newInquirer);
            addtoInquiryLog(newID, dateofinq, inqinfo);
        }
    }


    private void addNewInquirer(Inquirer newInquirer) {
		try {
			Statement maxIdStmt = dbConnect.createStatement();
			ResultSet maxIdResult = maxIdStmt.executeQuery("SELECT MAX(id) FROM inquirer");
			int maxId = 0;
			if (maxIdResult.next()) {
				maxId = maxIdResult.getInt(1);
			}
			maxIdResult.close();
			maxIdStmt.close();
	
			int newInquirerID = maxId + 1;
	
			String query;
			if (newInquirer.getLastName() == null) {
				query = "INSERT INTO inquirer (id, firstName, phoneNumber) VALUES (?,?,?)";
			} else {
				query = "INSERT INTO inquirer (id, firstName, lastName, phoneNumber) VALUES (?,?,?,?)";
			}
	
			// Create and execute the prepared statement
			PreparedStatement insertStmt = dbConnect.prepareStatement(query);
			insertStmt.setInt(1, newInquirerID);
			insertStmt.setString(2, newInquirer.getFirstName());
			if (newInquirer.getLastName() != null) {
				insertStmt.setString(3, newInquirer.getLastName());
			}
			insertStmt.setString(newInquirer.getLastName() == null ? 3 : 4, newInquirer.getServicesPhoneNum());
	
			int rowCount = insertStmt.executeUpdate();
			insertStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private void addtoInquiryLog(int inquirerID, String date, String info) {
		try {
			Statement maxIdStmt = dbConnect.createStatement();
			ResultSet maxIdResult = maxIdStmt.executeQuery("SELECT MAX(id) FROM inquiry_log");
			int maxInquiryLogID = 0;
			if (maxIdResult.next()) {
				maxInquiryLogID = maxIdResult.getInt(1);
			}
			maxIdResult.close();
			maxIdStmt.close();

			int newLogID = maxInquiryLogID + 1;

			java.sql.Date dateOfInquiry = java.sql.Date.valueOf(date);

			String query = "INSERT INTO inquiry_log (id, inquirer, callDate, details) VALUES (?,?,?,?)";
			PreparedStatement insertStmt = dbConnect.prepareStatement(query);
			insertStmt.setInt(1, newLogID);
			insertStmt.setInt(2, inquirerID);
			insertStmt.setDate(3, dateOfInquiry);
			insertStmt.setString(4, info);
	
			int rowCount = insertStmt.executeUpdate();
			insertStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private int checkexistinginquirer(Inquirer person) {
        int id = 0;
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM inquirer");
            while (results.next()) {
                if ((results.getString("firstname").equals(person.getFirstName())) && 
                    (results.getString("phonenumber").equals(person.getServicesPhoneNum()))) {
                    id = results.getInt("id");
                    break;
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

}