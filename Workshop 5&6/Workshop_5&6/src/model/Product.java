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

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product implements Serializable {
	private int id;
	private String name;
	private double price;
	private int stock;
	private int min;
	private int max;
	private ObservableList<Part> associatedParts;

	// Constructor
	public Product(int id, String name, double price, int stock, int min, int max) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.min = min;
		this.max = max;
		this.associatedParts = FXCollections.observableArrayList();
	}

	// Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	// Associated Parts methods
	public void addAssociatedPart(Part part) {
		associatedParts.add(part);
	}

	public boolean deleteAssociatedPart(Part selectedAssociatedPart) {
		return associatedParts.remove(selectedAssociatedPart);
	}

	public ObservableList<Part> getAllAssociatedParts() {
		return associatedParts;
	}
}