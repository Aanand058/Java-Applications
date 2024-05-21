// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211



package models;

import abstracts.PercussionFamily;

public class Xylophone extends PercussionFamily {
    private double price;

    
    public Xylophone() {}

    public void setPrice(double price) {
		this.price = price;
	}

	public Xylophone(double price) {
        this.price = price;
    }

    @Override
	public
    String makeSound() {
        return "through resonators";
    }

    @Override
	public
    double getPrice() {
        return price;
    }

    @Override
	public
    String getPitchType() {
        return "Each bar produces different pitch";
    }
    
    @Override
    public String howToFix() {
        return "replace bars";
    }

    @Override
    public String howToPlay() {
        return "with two mallets";
    }
}
