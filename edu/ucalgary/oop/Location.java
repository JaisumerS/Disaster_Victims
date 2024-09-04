/**
 * @author Jaisumer Sandhu <a href = "mailto"; jaisumer.sandhu@ucalgary.ca>jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.oop;

import java.util.*;

public class Location {

	private String name;
	private String address;
	private HashSet<DisasterVictim> occupants;
	private HashSet<Supply> supplies;

	/**
	 * 
	 * @param name name of the location
	 * @param address address of the location
	 */
	public Location(String name, String address) {
		this.name = name;
		this.address = address;
        this.occupants = new HashSet<>();
        this.supplies = new HashSet<>();
	}

	/**
	 * 
	 * @return the name of the location
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name set the name of the location to name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the address of the location
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address set the address of the location
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return all the occupants in the residing location are returned in a hashset
	 */
	public HashSet<DisasterVictim> getOccupants() {
		return this.occupants;
	}

	/**
	 * 
	 * @param occupants set the HashSet of occupants for the location
	 */
	public void setOccupants(HashSet<DisasterVictim> occupants) {
		this.occupants = occupants;
	}

	/**
	 * 
	 * @return return the supplies at the location
	 */
	public HashSet<Supply> getSupplies() {
		return this.supplies;
	}

	/**
	 * 
	 * @param supplies set the supplies at the location
	 */
	public void setSupplies(HashSet<Supply> supplies) {
		this.supplies = supplies;
	}

	/**
	 * 
	 * @param occupant add any disastervictim to the location
	 */
	public void addOccupant(DisasterVictim occupant) {
        this.occupants.add(occupant);
	}

	/**
	 * 
	 * @param occupant remove any disastervictim from location
	 */
	public void removeOccupant(DisasterVictim occupant) {
        this.occupants.remove(occupant);
	}

	/**
	 * 
	 * @param supply add any supply to the location
	 */
	public void addSupply(Supply supply) {
        this.supplies.add(supply);
	}

	/**
	 * 
	 * @param supply remove any supply from the location
	 */
	public void removeSupply(Supply supply) {
        this.supplies.remove(supply);
	}
}
