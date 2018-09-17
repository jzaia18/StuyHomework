//Jake Zaia
//APCS1 PD5
//HW #17: Do I repeat myself? Very well, then I repeat myself
//2016-10-14

public class Repeater{
    public static String fenceW(int posts){
	String retStr = "|";
	while (posts>1){
	    retStr+="--|";
	    posts-=1;
	}
	return retStr;
    }
    public static String fenceR(int posts){
	if (posts == 0){
	    return ""; }
	else if (posts == 1){
	    return "|"; }
	else {
	    return fenceR(posts-1)+"--|";}
    }

    public static void main(String [] args){

	System.out.println("Using a loop:");
	System.out.println(fenceW(1));
	System.out.println(fenceW(2));
        System.out.println(fenceW(3));

	System.out.println("\nRecursive:");
	System.out.println(fenceR(1));
	System.out.println(fenceR(2));
	System.out.println(fenceR(3));
    }
}
