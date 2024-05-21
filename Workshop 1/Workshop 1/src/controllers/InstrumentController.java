

package controllers;

import java.util.ArrayList;
import java.util.Collections;

import abstracts.MusicalInstrument;
import models.Drum;
import models.Flute;
import models.Guitar;
import models.Harp;
import models.Xylophone;
import views.InstrumentView;



//Controller
public class InstrumentController {
 private ArrayList<MusicalInstrument> instruments = new ArrayList<>();

 public void addInstrument(MusicalInstrument instrument) {
     instruments.add(instrument);
 }


     public void displayInstruments() { 
    	 //Sorting based on price in descending order
    	 Collections.sort(instruments); 
    	 
         InstrumentView.displayInstruments(instruments);       
     }

     
    public void makeInsturment(double drumPrice,double flutePrice, double guitarPrice, double harpPrice,double xylophonePrice ) {
    	 Drum drum = new Drum(drumPrice);    
         addInstrument(drum);
          
         Flute flute = new Flute(flutePrice);   
         addInstrument(flute);

         Guitar guitar = new Guitar(guitarPrice);    
         addInstrument(guitar);
         
         Harp harp = new Harp(harpPrice);
         addInstrument(harp);

         Xylophone xylophone = new Xylophone(xylophonePrice);
         addInstrument(xylophone);
    }
         
    public void displayFamily(String in) {
    	InstrumentView instrumentView = new InstrumentView();
		instrumentView.familyDisplay(instruments, in);
    }
  
     
 
}
