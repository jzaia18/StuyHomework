// Jake Zaia
// APCS2 p1
// HW #28 -- Now Let’s Consider You Lot at Fake Terry’s
// 2017-03-30

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/

// MR BROWN I DID IT!!! I USED CIRCLES!


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end; // _end is useless
    private int _size; // AKA circumference


    // default constructor creates an empty queue
    public RQueue() { 
	// Default vals are null, all is well
    }


    public void enqueue( T enQVal ) {
        if (_size == 0){ //Set the 1st element
	    _front = new LLNode<T>(enQVal, null);
	    _front.setNext(_front); // This isn't as confusing as it seems, it forms a circle with itself
	}
	else 
	    _front.setNext(new LLNode<T>(enQVal, _front.getNext())); // Insert an element after front, maintain circularity
	_size++;
    } // O(1)


    // remove and return thing at 'front' of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() {
	if (_size < 1) // Safety!
	    return null;
	LLNode<T> lastNode = _front.getNext(); // poorly named until 3 lines from now
	while (! lastNode.getNext().equals(_front)) // Goes until lastNode is the 'last node'
	    lastNode = lastNode.getNext();
	lastNode.setNext(lastNode.getNext().getNext()); // Effectively removes _front from the LL
	LLNode<T> retNode = _front;
        sample(); // Reset front
	_size --;
	return retNode.getValue();
    }// O(n)           if only this was doubly-linked ;-;


    //return next item to be dequeued
    public T peekFront() {
	return _front.getValue();
    } //O(1)


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo: Doesn't really shuffle the queue, but shuffles
     *    which element is the front, to the user this is 
     *    the same. Traverses the (circular) list until it 
     *    decides randomly upon a place to stop.
     ******************************************/
    public void sample () {
	LLNode<T> currNode = _front.getNext();
	while (true){
	    currNode = currNode.getNext();
	    if (Math.random() < (1.0 / _size))
		break;
	}
	_front = currNode;
    } //O(n)-ish -- depends on Math.random()


    public boolean isEmpty() { 
	return _size < 1;
    }//O(1)


    // print each node, separated by spaces
    public String toString() { 
	String retStr = "'Start' -> ";
	LLNode<T> currNode = _front;
	while (! currNode.getNext().equals(_front)){
	    retStr += currNode + " -> ";
	    currNode = currNode.getNext();
	}
	retStr += currNode + " -> Lap";
	return retStr;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) {
	
	Queue<String> PirateQueue = new RQueue<String>();
	
	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...
	
	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	
	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.dequeue() );
	
    }//end main

}//end class RQueue
