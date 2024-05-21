

package abstracts;


public abstract class MusicalInstrument implements Comparable<MusicalInstrument>{
	public abstract String makeSound();
    public abstract double getPrice();
    public abstract String getPitchType();
	    
	    @Override
	    public String toString() {
	        return getClass().getSimpleName();
	    }
	    
	    @Override
	    public int compareTo(MusicalInstrument other) {
	       
	        if(this.getPrice()<other.getPrice()) return 1;
	       
	        else if(this.getPrice()> other.getPrice()) return -1;
	        else 
	        	return 0;
	         
	    }
	    
}
