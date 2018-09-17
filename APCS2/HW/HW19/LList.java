// Jake Zaia
// APCS2 p1
// HW #18b: On the DLL
// 2017-03-15

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNodes.
 *****************************************************/

public class LList<T> implements List<T>{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private DLLNode<T> _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ){
	_head = null;
	_tail = null;
	_size = 0;
    }

    //--------------v  List interface methods  v--------------

    //change to a while not null
    public boolean add( T x ){
	if (_size < 1) {
	    _head = new DLLNode<T>(null, x, null);
	    _tail = _head;
	    _size++;
	    return true;
	}	
	DLLNode<T> currNode = _head;
        while (currNode.getNext() != null)
	    currNode = currNode.getNext();
	currNode.setNext(new DLLNode<T>(currNode, x, null));
	_tail = currNode.getNext();
	_size++;
	return true;
    }

    //insert a node containing newVal at position index
    public boolean add( int i, T newVal ){
	if (i >= _size || i < 0)
	    return false;
	if (i == 0) {
	    DLLNode<T> newNode = new DLLNode<T>(null, newVal, _head);
	    _head.setPrev(newNode);
	    _head = newNode;
	    _size++;
	    return true;
	    }
	if (i <= _size/2){ //start from front
	    DLLNode<T> currNode = _head;
	    for (int n = 1; n < i; n++){
		currNode = currNode.getNext();
	    }
	    DLLNode<T> newNode = new DLLNode<T>(currNode, newVal, currNode.getNext());
	    currNode.getNext().setPrev(newNode);
	    currNode.setNext(newNode);
	    _size++;
	    return true;
	}
	else {
	    DLLNode<T> currNode = _tail;
	    for (int n = 1; n < (_size - i); n++){
		currNode = currNode.getPrev();
	    }
	    DLLNode<T> newNode = new DLLNode<T>(currNode.getPrev(), newVal, currNode);
	    currNode.getPrev().setNext(newNode);
	    currNode.setPrev(newNode);
	    _size++;
	    return true;
	}
    }
    
    public T get( int i ){
	if (i >= _size || i < 0)
	    return null;
	if (i < _size/2){
	    DLLNode<T> currNode = _head;
	    i++;
	    for (int n = 0; n < i; n++){
		currNode = currNode.getNext();
	    }
	    return currNode.getCargo();
	}
	DLLNode<T> currNode = _tail;
	i++;
	for (int n = 0; n < (_size - i); n++){
	    currNode = currNode.getPrev();
	}
	return currNode.getCargo();
    }
    
    public T set( int i, T x ){
	if (i >= _size || i < 0)
	    return null;
	if (i < _size/2){
	    DLLNode<T> currNode = _head;
	    i++;
	    for (int n = 0; n < i; n++){
		currNode = currNode.getNext();
	    }
	    return currNode.setCargo(x);
	}
	DLLNode<T> currNode = _tail;
	i++;
	for (int n = 0; n < (_size - i); n++){
	    currNode = currNode.getPrev();
	}
	return currNode.setCargo(x);
    }

    //remove node at pos index, return its cargo
    public T remove( int i ){
	if (i >= _size || i < 0)
	    return null;
	if (i == 0){
	    DLLNode<T> retNode = _head;
	    _head.getNext().setPrev(null);
	    _head = _head.getNext();
	    _size--;
	    return retNode.getCargo();
	}
	if (i == _size - 1){
	    DLLNode<T> retNode = _tail;
	    _tail.getPrev().setNext(null);
	    _tail = _tail.getPrev();
	    _size--;
	    return retNode.getCargo();
	}
	DLLNode<T> currNode = _head;
	for (int n = 0; n < i; n++){
	    currNode = currNode.getNext();
	}
	DLLNode<T> retNode = currNode.getNext();
	currNode.setNext(retNode.getNext());
	if (retNode != _tail)
	    retNode.getNext().setPrev(currNode);
	else
	    _tail = currNode;
	_size--;
	return retNode.getCargo();
    }

    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    //main method for testing
    public static void main( String[] args ) 
    {

	LList<String> james = new LList<String>();

	System.out.println( james );
		
	james.add("beat");
	System.out.println( james );
	
	james.add("a");
	System.out.println( james );
	
	james.add("need");
	System.out.println( james );
	
	james.add("I");
	System.out.println( james );
	
	System.out.println( "2nd item is: " + james.get(1));
	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );	
	System.out.println( james + "\n");

	james.remove(0);
	System.out.println( james );
	james.remove(1);
	System.out.println( james );
	System.out.println( james._size );

	james.add(0, "beat");
	System.out.println( james );
	james.add(2, "I");
	System.out.println( james );

    }

}//end class LList



