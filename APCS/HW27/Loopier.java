public class Loopier {

    public static void main(String [] args){
	int [] arr ={0,5,10,15,20,20,20};
	System.out.println(linSearch(arr,10));  //returns 2
	System.out.println(linSearch(arr,6));   //returns -1
	System.out.println(linSearchR(arr,10)); //returns 2
	System.out.println(linSearchR(arr,6));	//returns -1
	System.out.println(freq(arr,20));    //Returns 3
	System.out.println(freq(arr,7));     //Returns 0
	System.out.println(freqRec(arr,20)); //Returns 3
	System.out.println(freqRec(arr,7));  //Returns 0
    }

    public static int linSearch(int [] a, int target){
	for (int x=0; x<a.length;x+=1){
	    if (a[x]==target)
		return x; //Returns the index as soon as its found
	}
	return -1; //Return -1 if target is never found
    }

    public static int linSearchR(int [] a, int target){
        return linSearchR(a,target,0); //Divert work to helper method
    }

    public static int linSearchR(int [] a, int target, int count){
	//Overloaded helper method to make this significantly easier
	                  //Yay tail recursion! :D
        if (count >= a.length)
	    return -1; //Return -1 if every index has been checked and nothing is returned.
	else if(a[count]==target)
	    return count;
	else
	    return linSearchR(a,target,count+1);
    }

    public static int freq(int [] a, int target){
	int ctr = 0; //Keeps track of how often a number is found
	for (int x = 0; x<a.length; x+=1){
	    if (a[x]==target)
		ctr+=1;
	}
	return ctr;
    }

    public static int freqRec(int [] a, int target){
	return freqRec(a,target,0,0); //Divert work to helper method
    }

    public static int freqRec(int [] a, int target, int ctr, int i){
	//Overloaded helper method (has ctr to count frequency, and i to keep track of current index
	if (i >= a.length)
	    return ctr;
	if (a[i]==target)
	    ctr+=1;
	return freqRec(a,target,ctr,i+1);//increments index by 1
    }
}
