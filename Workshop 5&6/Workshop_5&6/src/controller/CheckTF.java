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


package controller;

public class CheckTF {

	public static boolean isEmpty(String input) {
		boolean isValid = false;
		if (input.isEmpty() || input.isBlank() || input == null) {
			isValid = true;

		}
		return isValid;
	}

	public static boolean isInteger(String input) {
		boolean isValid = false;
		try {
			Integer i = Integer.parseInt(input);
			isValid = true;
		} catch (Exception ex) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isDouble(String input) {
		boolean isValid = false;
		try {
			double d = Double.parseDouble(input);
			isValid = true;
		} catch (Exception ex) {
			isValid = false;
		}
		return isValid;
	}
	
}
