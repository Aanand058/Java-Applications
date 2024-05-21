

package model;

public class Customer {

	private String cusName;
	private long cusPhone;

	// Constructor
	public Customer(String customerName, long customerPhoneNumber) {
		this.cusName = customerName;
		this.cusPhone = customerPhoneNumber;
	}

	// Getter
	public String getCusName() {
		return cusName;
	}


	// Getter
	public long getCusPhone() {
		return cusPhone;
	}



}
