/**********************************************
Workshop 4&5
Course:APD545 -5th Semester
Last Name:Aman
First Name:Aanand
ID:166125211
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2024/03/26
**********************************************/

package model;

public class Outsourced extends Part {
	private String companyName;

	// Constructor
	public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
		super(id, name, price, stock, min, max);
		this.companyName = companyName;
	}

	// Setter method for companyName
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	// Getter method for companyName
	public String getCompanyName() {
		return companyName;
	}
}
