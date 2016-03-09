import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Silver{

    private int[][] field;
    private int rows, cols, moves = 0;

    public Silver( int r, int c, int n ) {
	rows = r;
	cols = c;
	moves = n;
	field = new int[rows][cols];
    }

    
    public int travel( Scanner info, Scanner line ) {
	String str = "";
	for ( int x = 0; x < rows; x++ ) {
	    str = info.nextLine();
	    for ( int y = 0; y < cols; y++ ) {
		if (str.substring(y,y+1).equals("*") ) {
		    field[x][y] = -1;
		}
	    }
	}
	printField();
	line = new Scanner (info.nextLine());
	int startx = line.nextInt();
	int starty = line.nextInt();
	field[startx-1][starty-1] = 1;
	while ( moves > 0 ) {
	    for ( int x = 0; x < rows; x++ ) {
		for ( int y = 0; y < cols; y++ ) {
		    if ( (x + 1 < rows ) && field[x][y] > -1 && field[x+1][y] > -1 ) {
			field[x+1][y] = field[x][y] + field[x+1][y];
		    }
		    if ( (x - 1 > 0 ) && field[x][y] > -1 && field[x-1][y] > -1 ) {
			field[x-1][y] = field[x][y] + field[x-1][y];
		    }
		    if ( (y + 1 < cols ) && field[x][y] > -1 && field[x][y+1] > -1 ) {
			field[x][y+1] = field[x][y] + field[x][y+1];
		    }
		    if ( ( y -1 > 0 ) && field[x][y] > -1 && field[x][y-1] > -1 ) {
			field[x][y-1] = field[x][y] + field[x][y-1];
		    }
		    if ( field[x][y] > 0 ) {
			field[x][y] = 0;
		    }
		}
	    }
	printField();
	moves--;
	}
	return field[line.nextInt()-1][line.nextInt()-1];
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
	File file = new File("ctravel.in");
	Scanner info = new Scanner(file);
	Scanner line = new Scanner( info.nextLine() );
        Silver g = new Silver( line.nextInt(), line.nextInt(), line.nextInt() );
	System.out.println( g.travel( info, line ) + ",7,Singh,Pardeep" );
    }
    
}
