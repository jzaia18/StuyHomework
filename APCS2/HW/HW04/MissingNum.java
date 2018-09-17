/*
Datian Zhang
APCS2 pd1
HW04 Where In the Array Is Carmen San Numero?
2017-02-05
Team MagicSort - Datian Zhang, Jake Zaia, Joshel Xiedong
*/
/* 
description of algorithm 
 */ 
public class MissingNum {
    public static int magicFind(int[] oneMissing){
	int element;
	for( int i=0; i < oneMissing.length; i++ ) {
	    // store index element for clarity
	    element = oneMissing[oneMissing[i] - 1 ];
	    oneMissing[oneMissing[i] - 1 ] = oneMissing[i];
	    oneMissing[i] = element;
	}
	for( int j=0; j < oneMissing.length; j++ ) {
	    // System.out.println(oneMissing[j]);
	    if ( oneMissing[j] != ( j + 1 ) ) {
		return j + 1;
	    }
	}
	return 0; // if there is no missing number
	
    }
    public static void main(String[] args){
	// Thanks to QA forum
	int[] carmen = {2,1,2,4};
	int[] TomatoCale={6,3,5,4,5,2};
	int[] peanutButter={4,1,4,3,2};

	int arrSize = 1000000; //max int value minus a couple items

	int[] superTest = new int[arrSize];
	for (int i = 0; i < arrSize;i++ ) {
             superTest[i] = i+1;
	}
	//random number, can be changed. THe missing number should correspond to the index number + 1
	superTest[23233] = 123333;
	int[] twoEle = { 2, 2 };
	System.out.println(magicFind(carmen) + " Expects 3");
	System.out.println(magicFind(TomatoCale) + " Expects 1"); 
	System.out.println(magicFind(peanutButter) + " Expects 5"); 
	System.out.println(magicFind(superTest) + " Expects 23234"); 
	System.out.println(magicFind(twoEle) + " Expects 1");
    }
}
    
