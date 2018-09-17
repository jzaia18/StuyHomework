//Jake Zaia
//APCS1 pd5
//HW #07: On BigSib Individuality and the Elimination of Radio Fuzz
//2016-09-22

public class Greet { 

    public static void main( String[] args ) { 
 
	String greeting; //declare var of type String to store a greeting

	//instantiate BigSibs
	BigSib richard = new BigSib();    
	BigSib grizz = new BigSib();    
	BigSib dotCom = new BigSib();    
	BigSib tracy = new BigSib();    

	//assign each BigSib's introduction
	richard.setHelloMsg("Word up"); 
	grizz.setHelloMsg("Hey ya"); 
	tracy.setHelloMsg("Salutations"); 
	dotCom.setHelloMsg("Sup"); 

	//set text to be output, then flush to terminal
	greeting = richard.greet("freshman"); 
	System.out.println(greeting); 

	greeting = tracy.greet("Dr. Spaceman"); 
	System.out.println(greeting); 

	greeting = grizz.greet("Kong Fooey"); 
	System.out.println(greeting); 

	greeting = dotCom.greet("mom"); 
	System.out.println(greeting); 

	/**
	 * A: Public variables can be accessed by other files, priavte ones can not.
	 **/ 
	System.out.println( richard.helloMsg ); 

    } //end main() 

} //end Greet
