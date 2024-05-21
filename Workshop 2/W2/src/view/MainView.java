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


//Reference for using string builder:
 * https://www.youtube.com/watch?v=ZLDwskEhIFg&ab_channel=ApnaCollege
 * 
 * For Formatting Phone Number and Long
 * https://stackoverflow.com/questions/64136218/how-to-input-a-long-number-and-output-phone-numbers-in-java
**********************************************/


package view;

import model.Order;

public class MainView {

	public static String Data(Order o) {
		StringBuilder builder = new StringBuilder();
		builder.append("Order ID: " + o.getOrderId() + "\n");
		builder.append("Customer Name: " + o.customer.getCusName() + "\n");
		String formatted = ( ""  + o.customer.getCusPhone()).replaceAll("(...)(...)(....)", "($1) $2-$3");
		builder.append("Customer Phone: " +formatted + "\n");
		builder.append("Quantity: " + o.getQuantity() + "\n");
		builder.append("Pizza Size: " + o.getSize() + "\n");
		builder.append("Crust Type: " + o.getCrust() + "\n");
		builder.append("Toppings Added: " + o.getToppings() + "\n");
		builder.append("Subtotal: $" + String.format("%.2f", o.getSubtotal()) + "\n");
		builder.append("Tax Amount: $" + String.format("%.2f", o.getTaxAmount()) + "\n");
		builder.append("Grand Total: $" + String.format("%.2f", o.getGrandTotal()) + "\n");
		return builder.toString();
	}
}
