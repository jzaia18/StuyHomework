// Jake Zaia
// APCS2 p1
// HW #18a: On the DLL
// 2017-03-15

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode 
{

    private String _cargo;    //cargo may only be of type String
    private DLLNode _prevNode; //pointer to previous node 
    private DLLNode _nextNode; //pointer to next DLLNode

    // constructor -- initializes instance vars
    public DLLNode( DLLNode prev, String value, DLLNode next ) 
    {
	_cargo = value;
	_prevNode = prev;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getPrev() { return _prevNode; }

    public DLLNode getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ){
	String ret = _cargo;
	_cargo = newCargo;
	return ret;
    }

    public DLLNode setPrev( DLLNode newPrev ){
	DLLNode ret = _prevNode;
	_prevNode = newPrev;
	return ret;
    }

    public DLLNode setNext( DLLNode newNext ){
	DLLNode ret = _nextNode;
	_nextNode = newNext;
	return ret;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ){

	/*
	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null ) );
	

	// A naive list traversal:
	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	*/
    }

}
