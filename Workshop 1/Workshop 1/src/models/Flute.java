// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211




package models;

import abstracts.WoodwindFamily;

public class Flute extends WoodwindFamily {
 private double price;

 
 
 public Flute() {}

 public Flute(double price) {
     this.price = price;
 }

 public void setPrice(double price) {
	this.price = price;
} 
 
 
 @Override
public
 double getPrice() {
     return price;
 }


@Override
public
 String makeSound() {
     return "guiding a stream of air";
 }


 @Override
public
 String getPitchType() {
     return "Funadamental pitch of middle C";
 }
 
 
 @Override
 public String howToPlay() {
     return "by blowing the into the flute";
 }
}
