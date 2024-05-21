// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211




package models;

import abstracts.PercussionFamily;

public class Drum extends PercussionFamily {
    private double price;

    
    public Drum() {}

    public void setPrice(double price) {
		this.price = price;
	}


	public Drum(double price) {
        this.price = price;
    }

  
    @Override
	public
    String makeSound() {
        return "vibrating stretched membrane";
        		
    }

    @Override
   public double getPrice() {
        return price;
    }

    @Override
	public
    String getPitchType() {
        return "Sonic pitch";
    }
    
    @Override
    public String howToPlay() {
        return "by hitting the membrane";
    }

    @Override
    public String howToFix() {
        return "replace the membrane";
    }
}
