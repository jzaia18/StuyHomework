// Jake Zaia
// APCS2 p1
// HW #32: Getting Past the Velvet Rope
// 2017-04-19

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
    ArrayList<Comparable> _data;

    public ArrayPriorityQueue(){
	_data = new ArrayList<Comparable>();
    }

    //Adds an item to this priority queue.
    public void add(Comparable x){
	if (isEmpty())
	    _data.add(x);
	else {
	    int i = 0;
	    while (i < _data.size()){
		if (_data.get(i).compareTo(x) >= 0){
		    _data.add(i,x);
		    return;
		}
		i++;
	    }
	    _data.add(x);
	} 
    }
    
    //Returns true if this stack is empty, otherwise returns false.
    public boolean isEmpty(){
	return _data.size() == 0;
    }
    
    //Returns the smallest item stored in this priority queue without removing it.
    public Comparable peekMin(){
	return _data.get(_data.size() - 1);
    }
 
    //Removes and returns the smallest item stored in this priority queue.
    public Comparable removeMin(){
	return _data.remove(_data.size() - 1);
    }
    
    public static void main(String [] args){
	ArrayPriorityQueue printer = new ArrayPriorityQueue();
	printer.add(1);
	printer.add(2);
	printer.add(3);
	printer.add(2);
	printer.add(1);
	while (! printer.isEmpty()) {
	    System.out.println(printer.removeMin());
	}
    }

}
