//Jake Zaia
//APCS pd5
//HW #14: stAtistically sPeaking
//2016-10-06

public class Stats{

    //Mean methods
    public static int mean(int a,int b){
	return (a+b)/2;
    }
    public static double mean(double a, double b){
	return (a+b)/2;
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
	return max(max(a,b),c); //Yay recursion!
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
	return (int) Math.pow((a*b*c),(1.0/3.0));
    }
    public static double geoMean(double a,double  b,double c){
	return Math.pow((a*b*c),(1.0/3.0));
    }

    //Main for testing
    public static void main( String [] args){
	System.out.println(mean(0,10));//Expected:5
	System.out.println(mean(0.0,5.0));//Expected:2.5
	System.out.println(max(0,5,10));//Expected:10
	System.out.println(max(0.0,5.0,10.0));//Expected:10.0
	System.out.println(geoMean(2,4,8));//Expected:4
	System.out.println(geoMean(2.0,4.0,8.0));//Expected:4.0

	//Because of how Java calculates, what should be 4.0 is 3.99999996
	//This therefor makes the int version 3.
    }
}
