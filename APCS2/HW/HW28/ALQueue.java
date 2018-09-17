// Jake Zaia
// APCS2 p1
// HW #28 -- Now Let’s Consider You Lot at Fake Terry’s
// 2017-03-30

/*****************************************************
 * class ALQueue
 * uses an ArrayList to implement abstract data type QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

import java.util.ArrayList;

public class RQueue<T> implements Queue<T> 
{
    private ArrayList<T> _queue;
    private LLNode<T> _front; // Really not a front but w/e

    // default constructor
    public ALQueue() { 
	_queue = new ArrayList<T>();
        // Default vals are null
    }


    // means of adding an item to collection 
    public void enqueue( T x ) {
	if (_queue.size() == 0){
	    _front = new LLNode<T>(x, null);
	    _front.setNext(_front); // This isn't as confusing as it seems, it forms a circle with itself
	}
	else
	    _front.setNext(new LLNode<T>(x, _front.getNext()));   
    }//O(1)

		
    // means of removing an item from collection 
    public T dequeue() {
	LLNode<T> currNode = _front.getNext();
	while (! currNode.getNext().equals(_front))
	    currNode = currNode.getNext();
	currNode.setNext(currNode.getNext().getNext());
	LLNode<T> retNode = _front;
	_front = _front.getNext();
	return retNode;
    }//O(n) if only this was doubly-linked ;-;


    // means of "peeking" at the front item
    public T peekFront() {
	return _front();
    }//O(1)


    // means of checking to see if collection is empty
    public boolean isEmpty() {
	return _front == null;
    }//O(1)

    public T front()

    public String toString() {
	String retStr = "'Start' -> "
	currNode = _front;
	while (! currNode.nextNode().equals(_front))
	    retStr += currNode + " -> ";
	retStr += currNode " -> Lap";
	return retStr;
    }//O(n)

    //main method for testing
    public static void main( String[] args ) 
    {
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  Queue<String> ALBSure = new RQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  ALBSure.enqueue("Al");
	  ALBSure.enqueue("B.");
	  ALBSure.enqueue("Sure!");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( ALBSure ); //for testing toString()...

	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( ALBSure.dequeue() );
	  System.out.println( ALBSure.dequeue() );
	  System.out.println( ALBSure.dequeue() );

	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( ALBSure.dequeue() );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main


}//end class ALQueue
