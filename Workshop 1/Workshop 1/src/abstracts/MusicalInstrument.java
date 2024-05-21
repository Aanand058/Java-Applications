// Workshop: 1 
// Name: Aananad Aman 
// Id: 166125211

//Learning about Comparable 
//https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
//https://www.youtube.com/watch?v=g0_pQCxfgKI&t=402s&ab_channel=NathanS


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
