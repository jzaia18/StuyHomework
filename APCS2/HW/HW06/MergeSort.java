//Jake Zaia
//APCS2 pd1
//HW #06: Step 1: Split, Step 2: ?, Step 3: Sorted!
//2016-02-10

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ){
	int [] retArr = new int[a.length + b.length];
	int x=0, y=0, al = a.length, bl = b.length;
	while (x < al || y < bl){
	    if (y >= bl || (x < al && a[x]<=b[y])){
		retArr[x+y]=a[x];
		x+=1;
		    }
	    else {
		retArr[x+y]=b[y];
		y+=1;
	    }
	}
	return retArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ){
	//System.out.println("Made new arr: ");
	//printArray(arr);
	int l = arr.length;
	if (l <= 1)
	    return arr;
	int [] a = new int[l / 2];
	int [] b = new int [l / 2 + (l % 2)];
	int minil = l/2;
	for (int i = 0; i < minil; i++){
	    a[i] = arr[i];
	}
	int minil2 = l/2 + l%2;
	for (int i = 0; i < minil2; i++){
	    b[i] = arr[i+minil];	    
	}
	return merge(sort(a), sort(b));
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	printArray(arr0);
	printArray(arr1);
	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr3 and arr4: ");
	printArray( merge(arr3,arr4) );
	
	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );

	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort

