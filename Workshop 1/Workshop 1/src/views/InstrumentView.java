// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211



package views;

import java.util.ArrayList;

import abstracts.MusicalInstrument;
import abstracts.PercussionFamily;
import abstracts.StringFamily;
import abstracts.WoodwindFamily;
import interfaces.IFixable;
import interfaces.IPlayable;

public class InstrumentView {
    public static void displayInstruments(ArrayList<MusicalInstrument> instruments) {
    	   
        System.out.println("\n");
        
        
        //Requirement 2
        if (!instruments.isEmpty()) {
            System.out.printf("The most expensive instrument is: %s \n",
            		instruments.get(0).toString());
        } else {
            System.out.println("No instruments entered.");
        }
        for (MusicalInstrument instrument : instruments) {
            System.out.printf("%s’s cost is: $%.2f\n", instrument, instrument.getPrice());
            if (instrument instanceof IPlayable) {
                System.out.printf("%s is played: %s\n", instrument, ((IPlayable) instrument).howToPlay());
            }
            if (instrument instanceof IFixable) {
                System.out.printf("%s fixing: %s\n", instrument, ((IFixable) instrument).howToFix());
            }
            System.out.printf("%s pitch type: %s\n\n", instrument, instrument.getPitchType());
        }
        
        
        System.out.println("\n");
        
        
        //Requirement 3
        System.out.println("Instruments in price descending order:");
        for(MusicalInstrument instrument: instruments) {
        	System.out.printf("%s’s price is: $%.2f\n", instrument.toString(), instrument.getPrice());
        }
        
        
        System.out.println("\n");
          
    }
    
    //Requirement 4
    public void familyDisplay(ArrayList<MusicalInstrument> instruments, String in) {
    	for (MusicalInstrument instrument : instruments) {
            if (in.equals("PercussionFamily")) {
                if (instrument instanceof PercussionFamily) {
                    System.out.printf("%s makes sound %s.\n", instrument.toString(), instrument.makeSound());
                }
            } else if (in.equals("StringFamily")) {
                if (instrument instanceof StringFamily) {
                	System.out.printf("%s makes sound %s.\n", instrument.toString(), instrument.makeSound());                }
            } else if (in.equals("WoodwindFamily")) {
                if (instrument instanceof WoodwindFamily) {
                	System.out.printf("%s makes sound %s.\n", instrument.toString(), instrument.makeSound());                }
            }
        }
    }

   
}
