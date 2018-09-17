// Jake Zaia
// APCS2 p1
// HW #22: Stacks on Stacks on Stacks on Stacks…
// 2017-03-23

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	String retStr = "";
        Latkes pancakes = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++)
	    pancakes.push(s.substring(i,i+1));
	while (!pancakes.isEmpty())
	    retStr += pancakes.pop();
	return retStr;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    { 
	if (s.length() == 0)
	    return true;
	Latkes pancakes = new Latkes(s.length());
	while (s.length() > 0){
	    String checking = s.substring(0,1);
	    if (isOpeningParens(checking))
		pancakes.push(checking);
	    else if (isClosingParens(checking))
		if (pancakes.isEmpty() || !matching(pancakes.pop(), checking))
		    return false;
	    s = s.substring(1);
	}
	return pancakes.isEmpty();
    }//end allMatched()

	public static boolean isOpeningParens(String s){
	    return s.equals("(") || s.equals("{") || s.equals("[");
	}
	
	public static boolean isClosingParens(String s){
	    return s.equals(")") || s.equals("}") || s.equals("]");
	}

	public static boolean matching(String p, String q){
	    return (p.equals("(") && q.equals(")")) || (p.equals("{") && q.equals("}")) || (p.equals("[") && q.equals("]"));
	}


    //main method to test
    public static void main( String[] args ) { 

	
	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
        
    }

}//end class LatKtS
