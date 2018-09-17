//Jake Zaia 
//APCS pd5
//HW #44: In America, the Driver Sits on the Left
//2016-12-09

public class SuperArray implements List{
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray(){ 
	_data = new Object[10];
	_lastPos = -1;
	_size = 0;	
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString(){ 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand(){ 
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

    //Append (adds) the argument to the end of this SuperArray
    public boolean add(Object o){ 
	if ( _size >= _data.length )
	    expand(); 
	_data[_lastPos+1] = o;
	_lastPos++;
	_size++;
	return true;
    }


    //Inserts the argument at the specified position in this list. Shifts the elements at the
    //specified position and higher to the right (adds one to their indices).
    public void add(int index, int newVal){
        if (index < 0 || index >= _size)
	    throw new IndexOutOfBoundsException ("404 index not found. (half cringe, half useful errormsg)");
	if ( _size >= _data.length )
	    expand();
	else {
	    for( int i = _size; i > index; i-- ) {
		_data[i] = _data[i-1]; 
	    } 
	    _data[index] = newVal;
	    _lastPos++;
	    _size++;
	}
    }

    

    //Returns the number of elements in this list.
    public int size(){ 
	return _size;
    }

    //Returns the element at the specified position in this list.
    public Object get(int index){
	if (index < 0 || index >= _size)
	    throw new IndexOutOfBoundsException ("404 index not found. (half cringe, half useful errormsg)");
	return _data[index];
    }


    //Replaces the element at the specified position in this list with the specified object.
    public Object set(int index, Object o){
	if (index < 0 || index >= _size)
	    throw new IndexOutOfBoundsException ("404 index not found. (half cringe, half useful errormsg)");
 	Object temp = _data[index];
	_data[index] = o;
	return temp;
    }


    //Removes the element at the specified position from this list. All elements to the right of
    //the specified position are shifted left (1 is subtracted from their indices) and the size of
    //this list is one less than before the method is called.
    public Object remove(int index){
	if (index < 0 || index >= _size)
	    throw new IndexOutOfBoundsException ("404 index not found. (half cringe, half useful errormsg)");
	Object retO = _data[index];
	for( int i=index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_data[_size-1] = 0; //unnecessary
	_size--;
	_lastPos--;
	return retO;
    }

    //main method for testing
    public static void main(String[] args){
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

        mayfield.add("h");
	mayfield.add("e");
	mayfield.add("l");
	mayfield.add("l");
	mayfield.add("o");

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	System.out.println("Should catch exception:");
	try{
	    mayfield.add(3,99);
	    System.out.println("Exception not thrown.");}
	catch (Exception e){
	    System.out.println("Exception caught.");}
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
    }//end main()

}//end class SuperArray
