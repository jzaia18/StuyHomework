// Jake Zaia
// APCS2 p1
// HW #18b: On the DLL
// 2017-03-15

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ){
	_head = null;
	_size = 0;
    }

    //--------------v  List interface methods  v--------------

    //change to a while not null
    public boolean add( String x ){
	if (_size < 1) {
	    _head = new DLLNode(null, x, null);
	    _size++;
	    return true;
	}	
	DLLNode currNode = _head;
        while (currNode.getNext() != null)
	    currNode = currNode.getNext();
	currNode.setNext(new DLLNode(currNode.getPrev(), x, null));
	_size++;
	return true;
    }

    //insert a node containing newVal at position index
    public boolean add( int i, String newVal ){
	if (i >= _size || i < 0)
	    return false;
	if (i == 0) {
	    _head = new DLLNode(null, newVal, _head);
	    return true;
	    }
	DLLNode currNode = _head;
	for (int n = 0; n < i; n++){
	    currNode = currNode.getNext();
	}
	currNode.setNext(new DLLNode(currNode.getPrev(), newVal, currNode.getNext()));
	return true;
    }
    
    public String get( int i ){
	DLLNode currNode = _head;
	i++;
	for (int n = 0; n < i; n++){
	    currNode = currNode.getNext();
	}
	return currNode.getCargo();
    }
    
    public String set( int i, String x ){
	DLLNode currNode = _head;
	i++;
	for (int n = 0; n < i; n++){
	    currNode = currNode.getNext();
	}
	return currNode.setCargo(x);
    }

    //remove node at pos index, return its cargo
    public String remove( int i ){
	if (i >= _size || i < 0)
	    return null;
	if (i == 0){
	    DLLNode retNode = _head;
	    _head = _head.getNext();
	    return retNode.getCargo();
	}
	DLLNode currNode = _head;
	for (int n = 0; n < i; n++){
	    currNode = currNode.getNext();
	}
	DLLNode retNode = currNode.getNext();
	currNode.setNext(retNode.getNext());
	_size--;
	return retNode.getCargo();
    }

    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
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

	LList james = new LList();

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
	james.add("I");
	System.out.println( james );

    }

}//end class LList



