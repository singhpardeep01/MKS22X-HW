import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze{

    private int[][] field;
    private int rows, cols, elevation, moves = 0;

    public Bronze( int r, int c, int e, int n ) {
	rows = r;
	cols = c;
	elevation = e;
	moves = n;
	field = new int[rows][cols];
    }

    public void stomp( int r, int c, int stomps ) {
	while ( stomps > 0 ) {
	    int max = 0;
	    for ( int x = r - 1; x < r+2; x++ ) {
		for ( int y = c - 1; y < c+2; y++ ) {
		    if ( field[x][y] > max ) {
			max = field[x][y];
		    }
		}
	    }
	    for ( int x = r - 1; x < r+2; x++ ) {
		for ( int y = c - 1; y < c+2; y++ ) {
		    if ( field[x][y] == max ) {
			field[x][y] = field[x][y] - 1;
		    }
		}
	    }
	    stomps--;
	}
    }
    
    public int fieldWork( Scanner info, Scanner line ) {
	int sum = 0;
	for ( int x = 0; x < rows; x++ ) {
	    line = new Scanner( info.nextLine() );
	    for ( int y = 0; y < cols; y++ ) {
		field[x][y] = line.nextInt();
	    }
	}
	while (moves > 0) {
	    line = new Scanner ( info.nextLine() );
	    stomp( line.nextInt(), line.nextInt(), line.nextInt() );
	    moves--;
	}
	for ( int x = 0; x < rows; x++ ) {
	    for ( int y = 0; y < cols; y++ ) {
		if ( elevation - field[x][y] > 0 ) {
		    field[x][y] = elevation - field[x][y];
		}
		else {
		    field[x][y] = 0;
		}
	    }
	}
	for ( int x = 0; x < rows; x++ ) {
	    for ( int y = 0; y < cols; y++ ) {
		sum += field[x][y];
	    }
	}
	return sum * 72 * 72;
    }
    
    public void printField() {
	for ( int x = 0; x < rows; x++ ) {
	    for ( int y = 0; y < cols; y++ ) {
		System.out.print( field[x][y] + " " );
	    }
	    System.out.println("");
	}
    }
    
    public static void main( String[] args ) throws FileNotFoundException {
	File file = new File("makelake.in");
	Scanner info = new Scanner(file);
	Scanner line = new Scanner( info.nextLine() );
	Bronze g = new Bronze( line.nextInt(), line.nextInt(), line.nextInt(), line.nextInt() );
	System.out.println( g.fieldWork( info, line ) + ",7,Singh,Pardeep" );
    }
    
}
