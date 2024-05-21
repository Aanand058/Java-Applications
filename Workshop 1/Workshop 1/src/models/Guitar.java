// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211




package models;

import abstracts.StringFamily;

public class Guitar extends StringFamily{
	private double price;

   public Guitar() {}

	public void setPrice(double price) {
		this.price = price;
	}

	public Guitar(double price) {
        this.price = price;
    }

    @Override
	public
    String makeSound() {
        return "vibrating strings";
    }

    @Override
	public
    double getPrice() {
        return price;
    }

    @Override
	public
    String getPitchType() {
        return "Low to high pitch";
    }
    
    @Override
    public String howToFix() {
        return "replace the strings";
    }

    @Override
    public String howToPlay() {
        return "by strumming the strings";
    }
}

