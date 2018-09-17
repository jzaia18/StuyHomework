public class StatsDriver {

    public static void main( String [] args){
	System.out.println(Stats.mean(0,10));//Expected:5
	System.out.println(Stats.mean(0.0,5.0));//Expected:2.5
	System.out.println(Stats.max(0,10));//Expected:10
	System.out.println(Stats.max(0.0,5.0));//Expected:5.0
	System.out.println(Stats.geoMean(1,4));//Expected:2
	System.out.println(Stats.geoMean(1.0,4.0));//Expected:2.0
    }
}
