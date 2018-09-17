//Jake Zaia
//APCS1 PD5
//HW #18: Loopy
//2016-10-17


public class DriverCoin {

    public static void main( String[] args ) {

	//Creates the 2 Coins
	Coin yours = new Coin( "quarter" );
	Coin wayne = new Coin( "dollar", "heads" );

	//Flip a coin until you get 7 heads, (prints total heads up until it hits 7)
	int x = 7;
	while (yours.getHeadsCtr() < x){
	    System.out.print(yours.getHeadsCtr()+",");
	    yours.flip();
	}

	System.out.println();//For spacing

	//Count the number of matches, and stop when they hit 10 (also prints total up until point of stopping)
	int y = 10;
	int counter = 0;
	while (counter < y){
	    if (yours.flip() == wayne.flip()){
		counter += 1;
	    }
	    System.out.print(counter+",");
	}

	System.out.println();//For spacing

	//Same as the previous function, except only stops after being divisible by 2000 and greater than 13 (contrapositive in this case)
	counter = 0;
	while (counter < 13 || counter % 2000 != 0){
	    if (yours.flip() == wayne.flip()){
		counter += 1;
	    }
	    System.out.print(counter+",");//Just a warning, it prints A LOT
	}

	
    }//end main

}//end class
