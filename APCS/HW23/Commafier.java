//Team .titanic {float: none;}: Federico Tondolo, Jake Zaia
//APCS1 pd5
//HW #23: Karmacomma
//2016-10-26




public class Commafier{
	public static void main(String[]args){
	    System.out.println("Using a For loop:");
	    for (String s: args){
		System.out.println(commafyF(Integer.parseInt(s)));
	    }
	    System.out.println(commafyF(1));
	    System.out.println(commafyF(10));
	    System.out.println(commafyF(101));
	    System.out.println(commafyF(1000));
	    System.out.println(commafyF(31416));
      System.out.println(commafyF(123456));
	    System.out.println("Using Recursion:");
	    for (String s: args){
		System.out.println(commafyR(Integer.parseInt(s)));
	    }
	    System.out.println(commafyR(1));
	    System.out.println(commafyR(10));
	    System.out.println(commafyR(101));
	    System.out.println(commafyR(1000));
	    System.out.println(commafyR(31416));
      System.out.println(commafyR(123456));
	}


	public static String commafyF(int args){
		String num =Integer.toString(args);
		String answ="";
		int first= num.length()%3;
		String fin=num.substring(0,first);
		 if (args<1000){
		     return num;
		}
		 for (int count=0; count <num.length()-3; count+=3){
				 answ+=",";
				 answ+=num.substring (first, first+3);
		     }
			if (first==0){
				first=2;
				fin=num.substring(0,first+1);
				answ="";
				for (int count=0; count <num.length()-3; count+=3){
	 				 answ+=",";
	 				 answ+=num.substring (first+1, first+4);
	 		     }
			}
			fin+=answ;
			return fin;
		 }


    public static String commafyHelper(String args){
	if (args.length()<=3){
	    return args;
	}
	else {
	    return commafyHelper(args.substring(0,args.length()-3))+","+args.substring(args.length()-3);
	}
    }


    public static String commafyR(int num){
        return commafyHelper(num + "");
    }
}
