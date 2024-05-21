// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211



package controllers;

import java.util.Scanner;

import models.Drum;
import models.Flute;
import models.Guitar;
import models.Harp;
import models.Xylophone;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     InstrumentController controller = new InstrumentController();

     // Input for the price of instruments
     double drumPrice = getUserInput("Enter price for Drum: ", scanner);
     double flutePrice = getUserInput("Enter price for Flute: ", scanner);
     double guitarPrice = getUserInput("Enter price for Guitar: ", scanner);
     double harpPrice = getUserInput("Enter price for Harp: ", scanner);
     double xylophonePrice = getUserInput("Enter price for Xylophone: ", scanner);

       
     //make instruments 
     controller.makeInsturment(drumPrice,flutePrice,guitarPrice,harpPrice,xylophonePrice);

    
     // Display instruments
     controller.displayInstruments();
     
     
     //Requirement 4 input 
     Scanner scanner2 = new Scanner(System.in);
     System.out.print("Enter Family Name: ");
     String input = scanner2.nextLine();
     scanner2.close();
     
     //Display instruments of the input Family
     controller.displayFamily(input);
     
     
 }

 public static double getUserInput(String message, Scanner scanner) {
     System.out.print(message);
     return scanner.nextDouble();
 }
 
 
}