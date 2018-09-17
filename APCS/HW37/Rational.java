//Jake Zaia
//APCS1 pd5
//HW #37: Be More Rational
//2016-11-30

public class Rational{
    private int numerator;
    private int denominator;

    public Rational(){
	numerator = 0;
	denominator = 1;
    }

    public Rational(int num,int denom){
	if (denom == 0){
	    System.out.println("Denominator cannot be 0");
	    numerator = 0;
	    denominator = 1;
	}
	else{
	    numerator = num;
	    denominator = denom;
	}
    }

    public String toString(){
	reduce();
	if (denominator == 1)
	    return "" + numerator;
	else
	    return numerator + "/" + denominator;
    }

    public double floatValue(){
	return numerator*1.0 / denominator;
    }

    public void multiply(Rational r){
	numerator *= r.numerator;
	denominator *= r.denominator;
    }

    public void divide(Rational r){
        denominator *= r.numerator;
        numerator *= r.denominator;
    }

    public void add(Rational r){
	numerator *= r.denominator;
	numerator += r.numerator * denominator;
	denominator *= r.denominator;
    }

    public void subtract(Rational r){
	numerator *= r.denominator;
	numerator -= r.numerator * denominator;
	denominator *= r.denominator;
    }

    public void reduce(){
	int i = gcd();
	numerator/=i;
	denominator/=i;
    }

    public int gcd(){
	int a, b;	
	if (numerator < denominator) {
	    a = numerator;
	    b = denominator;
	}
	else{
	    a = denominator;
	    b = numerator;
	}
	if (a == 0) {
	    return b;
	}
	else {
	    if (b % a == 0) {
		return a;
	    }
	    return gcd((b - a), a);
	}
    }
    
    public static int gcd(int a, int b) {
	if (b < a) {
	    return gcd(b,a);
	}
	if (a == 0) {
	    return b;
	}
	else {
	    if (b % a == 0) {
		return a;
	    }
	    return gcd((b - a), a);
	}
    }

    public int compareTo(Rational r){
	//Easiest to use cross multiplying
	int thisnum = numerator * r.denominator;
	int thatnum = r.numerator * denominator;
	if (thisnum == thatnum)
	    return 0;
	else if (thisnum > thatnum)
	    return 1;
	else
	    return -1;
    }
    
    public static void main(String [] args){
	Rational r = new Rational(1,2);
	Rational s = new Rational(1,2);
	System.out.println("Unmodified Numbers:");
	System.out.println(r);
	System.out.println(s);
	System.out.println();
	System.out.println("Compared:");
	System.out.println(r.compareTo(s));
	r.multiply(s);
	System.out.println("Multiplied:");
	System.out.println(r);
	System.out.println("Compared again:");
	System.out.println(r.compareTo(s));
	r.divide(s);
	System.out.println("Then divided back:");
	System.out.println(r);
	r.add(s);
	System.out.println("Added:");
	System.out.println(r);
	r.subtract(s);
	System.out.println("Then subtracted back:");
	System.out.println(r);
    }
}
