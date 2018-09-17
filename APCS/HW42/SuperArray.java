//Team Planet Express Ship: Jasper Cheung, Jake Zaia 
//APCS pd5
//HW #42:_Array of Grade 316
//2016-12-07

/*==================================================
  class SuperArray version 1.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public class SuperArray 
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaningful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
         _data = new int[10]; 
	 _lastPos = -1;
	 _size = 0;
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() {
	_size = _lastPos + 1;
	if( _lastPos == -1){
	    return "[]";}
	String retStr = "[";
	for(int i = 0; i < _size; i++){
	    retStr +=_data[i] + ",";}
	return retStr.substring(0, retStr.length() -1 ) + "]";
	}

    //double capacity of this instance of SuperArray 
    private void expand() 
    {
	int[] b = new int[_data.length*2];
        for(int i = 0; i < _data.length; i++){
	    b[i] = _data[i];}
	_data = b;
	
    }

    //accessor method -- return value at specified index
    public int get( int index ) 
    {
	return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal )
    {
	if(index >= _data.length)
	    expand();
	if (index > _lastPos){
	    _lastPos = index;
	}
	int old = _data[index];
	_data[index] = newVal;
	_size = _lastPos + 1;
	return old;
    }
    
    //adds an item end
    public void add(int newVal){
	_lastPos++;
	_size = _lastPos + 1;
	if(_lastPos == _data.length)
	    expand();
	_data[_lastPos] = newVal;
    }

    public void add( int index, int newVal ){
	if(index < _lastPos)
	    _lastPos++;	
	else{
	    _lastPos = index;}
	_size = _lastPos + 1;
	while(_lastPos >= _data.length){
	    expand();}
	for(int i = _lastPos; i > index; i--){
		_data[i] = _data[i - 1];}
	_data[index] = newVal;
    } 
    public int size(){
	return _size;
	    }
     //shifts elements left to fill in newly-empted slot
    public void remove( int index ) 
    {
	if (_size == _data.length)
	    expand();
	if(index == _lastPos){
	    _data[index] = 0;
	    _lastPos -= 1;}
	else if(index < _lastPos){
	    for(int i = index; i < _size; i++){
		_data[i] = _data[i + 1];}
	    _lastPos -= 1;}
	_size = _lastPos + 1;
    }
    


    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++;
	}

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
    }//end main()

}//end class SuperArray
