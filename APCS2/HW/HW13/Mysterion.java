// Jake Zaia
// APCS2 pd1
// HW #13 -- We Be Dem
// 2017-03-06

public class Mysterion{

    // I decided to make instances to make this whole process easier.
    // These values are the ones used inside 'mysterion()'
    private int [] statArr, arr;
    private int pass, s, a, b, c;

    // Create a Mysterion with the example array from class
    public Mysterion(){
	int [] n = {8, 21, 17, 69, 343};
	statArr = n;
	arr = new int[5];
	resetArr();
    }

    // Create a Mysterion with your own specified array
    public Mysterion(int [] a){
	arr = new int[a.length];
	statArr = a;
	resetArr();
    }


    // Reset the array
    public void resetArr(){
	int al = statArr.length;
	for (int i = 0; i < al; i++)
	    arr[i] = statArr[i];
    }

    // Prints the array (and some other useful info
    public void printArray(){
	String toPrint = pass + " {";
	for (int i: arr)
	    toPrint += i + ", ";
	System.out.print(toPrint.substring(0, toPrint.length()-2) + "}");
	System.out.print("   s: " + s);
	System.out.print("   a: " + a);
	System.out.print("   b: " + b);
	System.out.println("   c: " + c);
    }

    // Swaps 2 items within arr
    public void swap(int x, int y){
	int z = arr[x];
	arr[x] = arr[y];
	arr[y] = z;
    }



    //Formerly mysterion:
    
    //Puts all numbers < c on the left and all numbers > c on the right for each element in the interval a to b
    public int splitOnC(int lb, int ub, int partition){
	// lb = lower bound, ub = upper bound
	
	c = partition; b = ub; a = lb; s = a; //sets instance vars
	pass = 0;
	printArray(); //prints array at start
	pass++;
	int v = arr[c];
	swap(b, c);
	printArray();
	for (int i = a; i < b; i++){
	    if (arr[i] < v) {
		swap(s, i);
		s++;
	    }
	    pass++;
	    printArray(); //print the array once per pass
	}
	swap(b, s);
	pass++;
	printArray();
	System.out.println("Returns: "+ s +"\n"); //prints final value of s
	//resetArr(); //Don't reset it plz
	return s;
    }

    public static void main(String [] args){
	Mysterion test = new Mysterion();
	
	/*  When a>=b, array is not modified, a is returned.
	  test.splitOnC(0, 0, 0);
	  test.splitOnC(1, 1, 1);
	  test.splitOnC(2, 2, 2);
	  test.splitOnC(3, 3, 3);
	*/

	/*  When a=0, and b>c, Produces a sorted array, and returns the number of values less than c
	test.splitOnC(0, 4, 0);
	test.splitOnC(0, 4, 1);
	test.splitOnC(0, 4, 2);
	test.splitOnC(0, 3, 1);
	test.splitOnC(0, 2, 1);
	test.splitOnC(0, 1, 0);
	*/
	
	/*  When a=0 and b<c, swaps b & c and returns b
	test.splitOnC(0, 0, 4);
	test.splitOnC(0, 1, 4);
	test.splitOnC(0, 2, 4);
	test.splitOnC(0, 1, 3);
	*/

	//Sorting using a for loop
	int [] t = {2,4,1,5,3};
	Mysterion test2 = new Mysterion(t);
	for (int x = 0; x < 4; x++){
	    test2.splitOnC(0,4,x);
	    
	}
	
    }
}
