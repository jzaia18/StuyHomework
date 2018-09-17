//Jake Zaia 
//APCS pd5
//HW #54: Never Fear, Big O Is Here!
//2017-01-03

import java.util.ArrayList;

public class MySorts{

    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
            randomIndex = (int)( (i+1) * Math.random() );
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }


    //O(n²) Because Bubble Sort works by sorting p elements after p passes, it can be seen
    //that the first pass (assuming an array of size n in descending order) will make n-1 swaps.
    //Furthermore, after that pass there will be effectively an array of size n-1, and this will
    //recursively happen, once again giving n the exponent 2.
    public static void bubbleSort( ArrayList<Comparable> data ) 
    {
        for (int iters = 0; iters < data.size()-1; iters++){
	    for (int i = data.size()-1; i > 0; i--){
		if (data.get(i).compareTo(data.get(i-1)) < 0){
		    Comparable temp = data.get(i);
		    data.remove(i);
		    data.add(i-1,temp);
		}
	    }
	}
    }
    
    //O(n²) Insertion Sort running on a list in decrementing order will require more and more swaps
    //with each pass. Pass n requires n swaps, therefor an Array of size n will require n + the number
    //of swaps for a list of size (n-1). This recursive definition leads to n being raised to the power 2.
    public static void insertionSort( ArrayList<Comparable> data ){
	int stop = data.size();
	for (int ctr = 1; ctr < stop; ctr++){
	    for (int i = ctr; i>0; i--){
		if (data.get(i).compareTo(data.get(i-1))>=0)
		    break;
		else
		    data.set(i, data.set(i-1,data.get(i)));
	    }
	}
    }

    //O(n) Selection Sort makes exactly one swap per pass, each pass. Therefor, the number of swaps
    //is just the size of the array, therefor the order is 1, AKA O(n)
    public static void selectionSort( ArrayList<Comparable> data ){
	for (int ctr = 1; ctr <= data.size(); ctr++){
	    int maxPos = 0;
	    int currHigh = data.size() - ctr;
	    for (int i = 0; i <= currHigh; i++){
		if (data.get(i).compareTo(data.get(maxPos)) > 0)
		    maxPos = i;
	    }
	    data.set( maxPos, data.set(currHigh,data.get(maxPos)));
	}
    }


    public static void main(String [] args)
    {
	//sad main() is sad ;-;
    }
}
