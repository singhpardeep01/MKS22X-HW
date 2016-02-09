public class Recursion implements hw01{

    public String name() {
	return "Singh,Pardeep";
    }

    public double sqrt( double n ) {
	if ( n < 0 ) {
	    throw new IllegalArgumentException( "n must be greater than or equal to 0" );
	}
	    return sqrtHelper( n, 1, 0 );
    }

    public double sqrtHelper( double n, double guess, double oldGuess ) {
	if ( n == 0 ) {
	    return 0;
	}
	if ( Math.abs( guess - oldGuess ) / guess  < .000000001 ) {
	    return guess;
	}
	return sqrtHelper( n, ( n / guess + guess ) / 2, guess );
    }
    
    public static void main( String[] args ) {
        Recursion pardeep = new Recursion();
	System.out.println( pardeep.sqrt(1.0) );
	System.out.println( pardeep.sqrt(2.0) );
	System.out.println( pardeep.sqrt(4.0) );
	System.out.println( pardeep.sqrt(100.0) );
	System.out.println( pardeep.sqrt(1.0E-7) );
	//System.out.println( pardeep.sqrt(-1.0) );
	//System.out.println( pardeep.sqrt(-100.0) );
	System.out.println( pardeep.sqrt(0.0) );
    }
}
