//Jake Zaia
//APCS1 pd5
//HW #39: Put it together
//2016-12-3


/*
Requires user to type in co-ordinates in the EXACT syntax (x1,y1)(x2,y2).
This is zero indexed, and does not work for 2 digit numbers.
This is horribly unrobustified.
This uses Integer.parseInt as well as String.substring to convert user input
   into a useable form
*/

import cs1.Keyboard;
public class Swapper{

    public static void populate(String [][] arr){
	final String alpha = "qwertyuiopasdfghjklzxcvbnm";
	int maxrows = arr.length;
	int maxcols = arr[0].length;
	for(int i = 0; i < maxrows; i++){
	    for(int x = 0; x < maxcols; x++){
		String tempstr = "";
		for(int j=0;j<4;j++){
		    int tempint = (int)(Math.random()*26);
		    tempstr += alpha.substring(tempint, tempint+1);
		}
		arr[i][x] = tempstr;
	    }
	}
	printArr(arr);
    }

    public static void printArr(String [][] arr){
	for(String [] i: arr){
	    for(String x: i){
	        System.out.print(x+"  ");
	    }
	    System.out.println("\n"); //Double skip!
	}
    }

    public static void swap(String[][]arr,int row1,int col1,int row2,int col2){
	String tempStr = arr[row1][col1];
	arr[row1][col1] = arr[row2][col2];
	arr[row2][col2] = tempStr;
	System.out.println("\n\n");
	printArr(arr);
    }

    public static void main(String [] args){
	String [] [] arr = new String [10][10];
	populate(arr);
	swap(arr,0,0,1,1);

	for(int i = 0; i < 5; i++){//to be replaced with "while true"
	    System.out.println("Type in 2 sets of co-ords to swap. Ex:(0,0)(7,5)");
	    String input = Keyboard.readString();
	    int row1 = Integer.parseInt(input.substring(1,2));
	    int col1 = Integer.parseInt(input.substring(3,4));
	    int row2 = Integer.parseInt(input.substring(6,7));
	    int col2 = Integer.parseInt(input.substring(8,9));
	    swap(arr,row1,col1,row2,col2);
	}
    }

    
}
