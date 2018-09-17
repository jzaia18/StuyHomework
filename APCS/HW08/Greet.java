//Jake Zaia
//APCS1 pd5
//HW #08: On the Origins of a BigSib
//2016-09-23

public class Greet { 

    public static void main( String[] args ) { 

	String greeting;

	BigSib richard = new BigSib("Word up");    
	BigSib grizz = new BigSib("Hey ya");    
	BigSib dotCom = new BigSib("Sup");    
	BigSib tracy = new BigSib("Salutations");    

	greeting = richard.greet("freshman"); 
	System.out.println(greeting); 
	greeting = tracy.greet("Dr. Spaceman"); 
	System.out.println(greeting); 
	greeting = grizz.greet("Kong Fooey"); 
	System.out.println(greeting); 
	greeting = dotCom.greet("mom"); 
	System.out.println(greeting); 

    } //end main() 

} //end Greet
