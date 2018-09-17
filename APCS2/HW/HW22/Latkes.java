// Jake Zaia
// APCS2 p1
// HW #22: Stacks on Stacks on Stacks on Stacks…
// 2017-03-22

/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
	if (!isFull()){
	    _stack[_stackSize] = s;
	    _stackSize ++;
	}
	else
	    throw new StackOverflowError("TOO MANY LATKES!");
    }

    //means of removal
    public String pop( ) 
    {
	if (! isEmpty()){
	    _stackSize--;
	    return _stack[_stackSize];
	}
	throw new NullPointerException("NEED MOAR LATKES");
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull() 
    {
	return _stackSize == _stack.length;
    }

    public static void main(String [] args){
	Latkes pancakes = new Latkes(3);

	System.out.println("Added 1");
	pancakes.push("1");
	System.out.println("Added 2");
	pancakes.push("2");
	System.out.println("Added 3");
	pancakes.push("3");

	try { pancakes.push("4"); }
	catch(StackOverflowError e) { System.out.println("Latkes full!"); }
		
	System.out.println(pancakes.pop());
	System.out.println(pancakes.pop());
	System.out.println(pancakes.pop());

	try { pancakes.pop(); }
	catch(NullPointerException e) { System.out.println("Latkes empty!"); }
	
    }

}//end class Latkes

