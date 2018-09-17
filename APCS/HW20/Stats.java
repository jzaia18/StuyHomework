//Team Skull: Yedoh Kang, Jake Zaia
//APCS PD5
//HW #20: GCD Three Ways
//2016-10-19

public class Stats{

    //Mean methods
    public static int mean(int a,int b){
	return a+b/2;
    }
    public static double mean(double a, double b){
	return a+b/2;
    }

    //Max methods
    public static int max(int a, int b){
	if (a>b){
	    return a; }
	else{
	    return b; }
    }
    public static double max(double a, double b){
	if (a>b){
	    return a; }
	else{
	    return b; }
    }
    public static int max(int a, int b, int c){
	return max(max(a,b),c);
    }
    public static double max(double a, double b, double c){
	return max(max(a,b),c);
    }

    //Geometric Mean Methods
    public static int geoMean(int a, int b){
	return (int) Math.sqrt(a*b);
    }
    public static double geoMean(double a, double b){
	return Math.sqrt(a*b);
    }
    public static int geoMean(int a, int b, int c){
	return (int) Math.pow(a*b,1.0/3);
    }
    public static double geoMean(double a, double b, double c){
	return Math.pow(a*b,1.0/3);
    }


    public static int gcd(int a, int b){
	int count = 1;
	int currGCD = 1;
	if (b < a) {
	    gcd(b,a);
	}
       	while (count < a) {
	    if (a % count == 0 && b % count == 0){
		currGCD = count;
	    }
	    count += 1;
	}
	return currGCD;
    }

    // Euclid's Algorithm
    //- if the bigger number is divisible by the smaller number, then return the smaller number
    //- if it isn't divisible, then keep on subtracting the smaller number from the larger number until one number becomes 0, which then it becomes the GCD
    public static int gcdER(int a, int b) {
	/*System.out.print(a); //Debug statements
	System.out.print(",");
	System.out.println(b);*/
	if (b < a) {
	    return gcdER(b,a);
	}
	if (a == 0) {
	    return b;
	}
	else {
	    if (b % a == 0) {
		return a;
	    }
	    return gcdER((b - a), a);
	}
    }

    // Euclid's Algorithm
    //- if the bigger number is divisible by the smaller number, then return the smaller number
    //- if it isn't divisible, then keep on subtracting the smaller number from the larger number until one number becomes 0, which then it becomes the GCD
    public static int gcdEW (int a, int b) {
	if (b < a) {
	    return gcdEW(b,a);
		}
	if (a == 0)
	    return b;
	while (a != 0 && b != 0){
	    if (b % a == 0) {
		return a;
	    }
	    else {
		int c = b - a;
		b = a;
		a = c;
		}	    
	    }
	return -1; //To avoid syntax errors
	}

    
    //Main for testing
    public static void main( String [] args){
	System.out.println(gcd(15,20)); //Expected: 5
	System.out.println(gcd(20,15)); //Expected: 5
	System.out.println(gcdER(15,20)); //Expected: 5
	System.out.println(gcdER(20,15)); //Expected: 5
	System.out.println(gcdEW(15,20)); //Expected: 5
	System.out.println(gcdEW(20,15)); //Expected: 5
 }
}
