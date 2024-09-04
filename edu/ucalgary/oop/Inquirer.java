/**
 * @author Jaisumer Sandhu <a href = "mailto"; jaisumer.sandhu@ucalgary.ca>jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.4
 * @since 1.0
 */
package edu.ucalgary.oop;


import java.util.*;

public class Inquirer {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;
    private String[] logList;
    private int logCount;

	/**
	 * 
	 * @param FIRST_NAME FINAL FIRSTNAME VALUE
	 * @param LAST_NAME FINAL LASTNAME VALUE
	 * @param SERVICES_PHONE FINAL PHONENUMBER VALUE
	 * @param INFO FINAL "INQUIRER INFORMATION GIVEN" VALUE
	 */
    public Inquirer(String FIRST_NAME, String LAST_NAME, String SERVICES_PHONE, String INFO) {
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.SERVICES_PHONE = SERVICES_PHONE;
        this.INFO = INFO;
        this.logList = new String[10];
    }

	/**
	 * 
	 * @return firstname of the inquirer
	 */
    public String getFirstName() {
        return FIRST_NAME;
    }

	/**
	 * 
	 * @return lastname of the inquirer
	 */
    public String getLastName() {
        return LAST_NAME;
    }

	/**
	 * 
	 * @return information provided from the inquirer
	 */
    public String getInfo() {
        return INFO;
    }

	/**
	 * 
	 * @return phone number of the inquirer
	 */
    public String getServicesPhoneNum() {
        return SERVICES_PHONE;
    }

	/**
	 * 
	 * @param log, whatever the inquirer wanted to talk about, is all listed here, and this is to add it to the loglist, if needed.
	 */
    public void addtoLogList(String log) {
        if (logCount == logList.length) {
            logList = Arrays.copyOf(logList, logList.length * 2);
        }
        logList[logCount++] = log;
    }

	/**
	 * 
	 * @return the log list
	 */
    public String[] getLogList() {
        return Arrays.copyOf(logList, logCount);
    }
}