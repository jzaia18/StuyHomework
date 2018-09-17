//Jake Zaia 
//APCS pd5
//HW #46: Ascending
//2016-12-14

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList();
    }


    public String toString() {
	return _data.toString();
    }


    public Comparable remove( int index ) {
	Comparable retComp = _data.get(index);
	_data.remove(index);
	return retComp;
    }


    public int size() {
	return _data.size();
    }

    
    public Comparable get( int index ) {
	return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) {
	int size = _data.size();
	boolean added = false;
	for (int i = 0; i < size && ! added; i++){
	    if ((Integer) newVal < (Integer) _data.get(i)){
		_data.add(i,newVal);
		added = true;
	    }
	}
	if (! added)
	    _data.add(newVal);
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {
	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();
    }

}//end class OrderedArrayList
 
