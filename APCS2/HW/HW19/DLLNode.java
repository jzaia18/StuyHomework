// Jake Zaia
// APCS2 p1
// HW #18a: On the DLL
// 2017-03-15

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T>{

    private T _cargo;    //cargo may only be of type String
    private DLLNode<T> _prevNode; //pointer to previous node 
    private DLLNode<T> _nextNode; //pointer to next DLLNode

    // constructor -- initializes instance vars
    public DLLNode( DLLNode<T> prev, T value, DLLNode<T> next ) 
    {
	_cargo = value;
	_prevNode = prev;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode<T> getPrev() { return _prevNode; }

    public DLLNode<T> getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ){
	T ret = _cargo;
	_cargo = newCargo;
	return ret;
    }

    public DLLNode<T> setPrev( DLLNode<T> newPrev ){
	DLLNode ret = _prevNode;
	_prevNode = newPrev;
	return ret;
    }

    public DLLNode<T> setNext( DLLNode<T> newNext ){
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
