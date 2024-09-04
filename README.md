# Disaster Management System (Mandatory Read)
## To run the program, make sure you are outside the 'edu' folder and run this command:
    1. javac -cp ".;postgresql-42.7.3.jar" edu\ucalgary\oop\ReliefService.java
    2. java -cp ".;postgresql-42.7.3.jar" edu.ucalgary.oop.ReliefService

Then once you are in, input the number of the option you would like to be executed, and press enter.

Then, for any answers that require you to type out something, it will usually give you a format on how 
to execute whatever needs to be executed!

### **Functionality:**
1. **Location-based relief worker:**
    * Add a new disaster victim: Allows adding a new victim to a specific location.
    * Add a family connection: Enables establishing family connections between victims.
    * Add a medical record: Allows recording medical records for victims.
2. **Central-based relief worker:**
    * Search for a disaster victim: Enables searching for a victim based on their name.
    * Log inquiries: Allows logging inquiries from individuals seeking information.
### **Database Interaction:**
* **Database Connectivity:** The system interacts with a PostgreSQL database named ensf380project.
* **Logging Inquirer Queries:** All inquiries from individuals are logged in the database.
* **Adding New Inquirers:** New inquirers are added to the database, and their information is 
recorded.
* **Checking Existing Inquirers:** The system checks if an inquirer already exists in the database based on their first name and phone number.
### **Usage Instructions:**
1. **Location-based relief worker:**
    * Select the desired option from the menu.
    * Follow the prompts to add victims, family connections, or medical records.
    * Exit the system when done.
2. **Central-based relief worker:**
    * Choose an option to search for victims or log inquiries.
    * Follow the prompts to perform the selected task.
    * Exit the system when finished.
### **Notes:**
* Ensure to use valid date and phone number formats when entering information.
* Proper validation is implemented to handle invalid inputs.

## Additional Information about the DisasterVictim class itself (Optional Read)
### Class: DisasterVictim

### **Variables:**
1. **firstName** (String): Represents the first name of the victim. This variable is of type String to 
store textual data.
2. **lastName** (String): Represents the last name of the victim. Also of type String to store textual data.
3. **dateOfBirth** (String): Represents the date of birth of the victim. Stored as a String to accommodate various date formats and simplify data handling.
4. **age** (int): Represents the age of the victim. Derived from the date of birth. It is an integer to ensure numerical consistency and ease of calculations.
5. **comments** (String): Additional comments or notes about the victim. String type to store textual information.
6. **medicalRecords** (Vector&lt;MedicalRecord&gt;): Stores medical records of the victim. Utilizes a Vector to allow dynamic resizing and efficient storage of medical records.
7. **familyConnections** (HashSet&lt;FamilyRelation&gt;): Stores family connections of the victim. HashSet is used to ensure uniqueness and facilitate fast retrieval of family relations.
8. **personalBelongings** (HashSet&lt;Supply&gt;): Stores personal belongings of the victim. HashSet is employed to prevent duplicate entries and enable efficient management of 
personal belongings.
9. **gender** (String): Represents the gender of the victim. String type to store gender information.
10. **ASSIGNED_SOCIAL_ID** (int): Unique social ID assigned to the victim. Integer type for storing identification numbers.
11. **ENTRY_DATE** (String): Date when the victim was added to the system. Stored as a String to accommodate various date formats and simplify data handling.
12. **victimLocation** (Location): Represents the current location of the victim. Location type to encapsulate geographic information.
13. **dietaryRestrictions** (String[]): Represents dietary restrictions of the victim. Array of Strings to store multiple dietary restrictions.

### **Design Rationale:**
* Data Types: Variables are chosen to match the type of data they represent, ensuring clarity and consistency in data management.

* Data Integrity: String data types are used for variables such as firstName, lastName, and gender to prevent unexpected data types.

* Efficient Storage: Collections like Vector and HashSet are utilized for storing medical records, family connections, and personal belongings to optimize memory usage and enable efficient data retrieval.

* Flexibility: String arrays are used for dietary restrictions to accommodate multiple restrictions for each victim.

### File Input for Gender Options:

The **initializeGenderOptions()** method reads gender options from a text file (**GenderOptions.txt**) to populate the **genderoptions** ArrayList. This approach ensures that gender options can be easily updated or modified externally without altering the source code.

### Constraints:

* Age Calculation: Age is calculated from the date of birth, and if the date of birth is already 
set, setting the age is disallowed to maintain consistency.
* Supply Management: When a supply is removed from personal belongings, it is added back 
to the corresponding location if available, ensuring the integrity of supply management.
* Family Relation Consistency: Methods like **addFamilyConnection()** and **removeFamilyConnection()** maintain consistency in family relations by updating connections for both individuals involved in the relation