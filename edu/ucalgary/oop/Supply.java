/**
 * @author Jaisumer Sandhu <a href = "mailto"; jaisumer.sandhu@ucalgary.ca>jaisumer.sandhu@ucalgary.ca</a>
 * @version 1.2
 * @since 1.0
 */

package edu.ucalgary.oop;


public class Supply {

	private String type;
	private int quantity;

	/**
	 * 
	 * @param type what the supply's name is
	 * @param quantity how much of the supply there is
	 */
	public Supply(String type, int quantity) {
		this.type = type;
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return the name of the supply
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type set the name of the supply
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return the quantity of the given supply
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * 
	 * @param quantity set the quantity of the supply
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @param supplyAdd how much you want to add to the quantity of the supply
	 */
	public void addtoQuantity(int supplyAdd){
		this.quantity = this.quantity + supplyAdd;
	}

	/**
	 * 
	 * @param supplyRemove how much you want to remove from the quantity of the supply
	 */
	public void removeQuantity(int supplyRemove){
		this.quantity = this.quantity - supplyRemove;
	}
}