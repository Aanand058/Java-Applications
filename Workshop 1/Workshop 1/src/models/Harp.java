
package models;

import abstracts.StringFamily;

public class Harp extends StringFamily {
    private double price;
    
    
    public Harp() {}

    public void setPrice(double price) {
		this.price = price;
	}

	public Harp(double price) {
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
        return "Has seven levels of pitch";
    }
    
    @Override
    public String howToFix() {
        return "replace the strings";
    }

    @Override
    public String howToPlay() {
        return "with the thumb and first three fingers";
    }
}
