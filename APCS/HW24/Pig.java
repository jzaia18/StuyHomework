//Jake Zaia
//APCS1 pd5
//HW #24: Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
//2016-10-29

//class Pig
//a Pig Latin translator
//SKELETON

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           9
     ,--.-'-,--.
     \  /-~-\  /
    / )' a a `( \
   ( (  ,---.  ) )
    \ `(_o_o_)' /
     \   `-'   /
      | |---| |     
      [_]   [_]
      PROTIP: Make this class compilable first, 
      then develop and test one method at a time.
      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Pig 
{
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") → true  
      hasA("cat", "p") → false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	int i = 0;
	while (i < w.length()){
	    if (w.substring(i,i+1).equals(letter))
		return true;
	    i += 1;
	}
	return false;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
        int i = 0;
	while (i < VOWELS.length()){
	    if (VOWELS.substring(i,i+1).equals(letter))
		    return true;
	    i += 1;
	}
	return false;
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") → 3
      =====================================*/
    public static int countVowels( String w ) 
    {
        if (w.length() <= 1){
	    if (isAVowel(w))
		return 1;
	    else
		return 0;	    
	}
	else {
	    if (isAVowel(w.substring(0,1)))
		return 1 + countVowels(w.substring(1));
	    else
		return countVowels(w.substring(1));
	}
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") → true
      hasAVowel("zzz") → false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	return countVowels(w) > 0;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") → "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
        String retStr = "";
	int i = 0;
	while (i < w.length()){
	    String test = w.substring(i,i+1);
	    if (isAVowel(test))
		retStr += test;
	    i += 1;
	}
	return retStr;
    }


    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel( String w ) 
    {
	if (hasAVowel(w))
	    return allVowels(w).substring(0,1);
	return "";
    }


    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel( String w ) 
    {
        return w.substring(0,1).equals(firstVowel(w));
    }


    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =====================================*/
    public static String engToPig( String w ) 
    {
	String retStr = "";
	if (w.length() == 0)
	    return w;
	if (! hasAVowel(w))
	    return w + "ay";
        if (beginsWithVowel(w))
	    return w+"way";
	while (w.length() > 0){
	    if (w.substring(0,1).equals(firstVowel(w))){
		return w + retStr + "ay";
	    }
	    retStr += w.substring(0,1);
	    w = w.substring(1);
	}
	return "ERROR!";
    }

    public static String sentToPig(String w){
	String nextWord = "";
	String retStr = "";
	int i = 0;
	while (i < w.length()){
	    if (w.substring(i,i+1).equals(" ")){
		retStr += engToPig(nextWord) + " ";
		nextWord = "";
		}
	    else {
		nextWord += w.substring(i,i+1);
	    }
	    i += 1;
	}
	retStr += engToPig(nextWord);
	return retStr;
    }


    public static void main( String[] args ) {
	System.out.println(hasA("cat", "a")); //True 
	System.out.println(hasA("cat", "p")); //False
	System.out.println(isAVowel("a")); //True
	System.out.println(isAVowel("z")); //False
	System.out.println(countVowels("hello")); //2
	System.out.println(countVowels("lttrs")); //0
	System.out.println(hasAVowel("hello")); //True
	System.out.println(hasAVowel("lttrs")); //False
	System.out.println(allVowels("hello")); //"eo"
	System.out.println(allVowels("lttrs")); //""
	System.out.println(firstVowel("hello")); //"e"
	System.out.println(firstVowel("lttrs")); //""
	System.out.println(beginsWithVowel("hello")); //False
        System.out.println(beginsWithVowel("apple")); //True
	System.out.println(engToPig("apple")); //"appleway"
	System.out.println(engToPig("strong")); //"ongstray"
	System.out.println(engToPig("java")); //"avajay"
	System.out.println(sentToPig("hello my name is jake")); //"ellohay myay amenay isway akejay"
    }//end main()

}//end class Pig


