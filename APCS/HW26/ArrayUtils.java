//Jake Zaia
//APCS1 pd05
//HW25 I Demand Arrays!
//2016-11-02

public class ArrayUtils{
    
    //I is descriptive comment!
    
    public static void populate(int [] arr){
	for (int x = 0; x<arr.length; x+=1){
	    arr[x] = (int) (100.0 * Math.random());
	}
    }

    public static String arrToString(int [] arr){
	String retStr = "";
	for (int x=0; x<arr.length; x+=1){
	    retStr += arr[x] + ", ";
	}
	return retStr.substring(0,retStr.length()-2);
    }
    

    public static void main(String [] args){
	int [] avector = new int [5];
	populate(avector);
	System.out.println(arrToString(avector));
    }
}
