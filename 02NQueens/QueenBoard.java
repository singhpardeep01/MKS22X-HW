public class QueenBoard{

    private int[][] board;
    private int size;
    private int queens;

    public QueenBoard( int n ) {
	board = new int[n][n];
	size = n;
	queens = 0;
    }

    public String toString() {
	String retStr = "";
	for ( int[] x : board ) {
	    for ( int y : x ) {
		retStr += y + " ";
	    }
	    retStr += "\n";
	}
	return retStr;
    }

    public void horizontal( int row, int column, boolean add ) {
	for ( int y = column + 1; y < size; y++ ) {
	    if ( add ) {
		board[row][y] -= 1;
	    }
	    else {
		board[row][y] += 1;
	    }	
	}
    }

    public void diagonal( int row, int column, boolean add ) {
	for ( int x = 0; x < size; x++ ) {
	    for ( int y = column + 1; y < size; y++ ) {
		if ( (y - column) == ( Math.abs(x - row) ) ) {
		    if ( add ) {
			board[x][y] -= 1;
		    }
		    else {
			board[x][y] += 1;
		    }			
		}
	    }
	}
    }

    public boolean addQueen( int row, int column ){
	for ( int x = row; x < size; x++) {
	    if ( board[x][column] == 0 ) {
		board[x][column] = 1;
	        horizontal( x, column, true );
		diagonal( x, column, true );
		queens++;
		return true;
	    }
	}
	return false;
    }
    
    public int removeQueen( int column ) { 
	int row = 0;
	for ( int x = 0; x < size; x++) {
	    if ( board[x][column] == 1 ) {
		row = x;
		break;
	    }
	}
	board[row][column] = 0;
	horizontal( row, column, false );
	diagonal( row, column, false );
	queens--;
	return row;
    }
	
    public boolean solve() {
	return helpSolve(0,0);
    }

    public boolean helpSolve( int row, int column ) {
	if ( column >= size ) {
	    return true;
	}
	if ( column == 0 && row >= size ) {
	    return false;
	}
	if ( row >= size ) {
	    return helpSolve( removeQueen(column - 1) + 1, column - 1 );
	}
	else if ( ! addQueen( row, column ) ) {
	    return helpSolve( removeQueen(column - 1) + 1 , column - 1 );
	}
	else {
	    return helpSolve( 0, ++column );
	}
    }

    public void printSolution() {
	for ( int x = 0; x < size; x++ ) {
	    for ( int y = 0; y < size; y++ ) {
		if ( board[x][y] == 1 ) {
		    System.out.print( "Q " );
		}
		else {
		    System.out.print( "_ " );
		}
	    }
	    System.out.println( "\n" );
	}
    }

    public static void main( String[] args ) {
	QueenBoard pardeep;
	if ( args.length > 0 ) {
	    pardeep = new QueenBoard( Integer.parseInt( args[0] ) );
	}
	else {
	    pardeep = new QueenBoard( 4 );
	}
	pardeep.solve();
     	pardeep.printSolution();
    }

}
