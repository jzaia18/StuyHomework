//Jake Zaia 
//APCS pd5
//HW #48: Halving the Halves
//2016-12-19

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
	    if (newVal.compareTo(_data.get(i)) < 0){
		_data.add(i,newVal);
		added = true;
	    }
	}
	if (! added)
	    _data.add(newVal);
    }


    public void addBinary( Comparable newVal){
	if (_data.size() == 0){ //Places the 1st element
	    _data.add(newVal);
	    return;  }
	int lb = 0; //lower bound (index)
	int ub = _data.size()-1; //upper bound (index)
	int mid = (lb + ub) / 2; //midpoint (index)
	while (lb < ub){
	    if (newVal.compareTo(_data.get(mid)) == 0){
		_data.add(mid,newVal);
		return;  }
	    else if (newVal.compareTo(_data.get(mid)) > 0)
		lb = mid + 1;
	    else
		ub = mid - 1;
	    mid = (lb + ub) / 2;
	}
	mid = (lb + ub) / 2;
	if (newVal.compareTo(_data.get(mid)) < 0)
	    _data.add(mid, newVal);
	else
	    _data.add(mid+1, newVal);
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {
	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println(valToAdd);
	    Franz.addBinary( valToAdd );
	}

	System.out.println("After population via addBinary() calls:");
	System.out.println( Franz );
	System.out.println();
    }

}//end class OrderedArrayList
 
