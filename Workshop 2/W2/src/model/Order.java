/**********************************************
Workshop 2
Course:APD545 - Semester
Last Name:Aman
First Name:Aanand
ID:166125211
Section:ZAA
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:2024/02/10
**********************************************/


package model;

import java.util.List;
import java.util.Random;

public class Order {

	private int orderId;
	private double subtotal;
	private double taxAmount;
	private double grandTotal;

	List<String> toppings;

	String size;
	String crust;
	private int quantity;
	public Customer customer;

	// Use Random to generate orderID
	int min = 10000;
	int max = 99999;

	// Constructor
	public Order(int qty, Customer cust, String piSize, String piCrust, double sub_total, double tax,
			double grand_total, List<String> toppings) {

		Random random = new Random();
		this.orderId = random.nextInt(max - min + 1) + min;

		this.quantity = qty;
		this.customer = cust;
		this.size = piSize;
		this.crust = piCrust;
		this.subtotal = sub_total;
		this.taxAmount = tax;
		this.grandTotal = grand_total;
		this.toppings = toppings;

	}

	// Getter Setter
	public int getOrderId() {
		return orderId;
	}

	public List<String> getToppings() {
		return toppings;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSize() {
		return size;
	}

	public String getCrust() {
		return crust;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

}
