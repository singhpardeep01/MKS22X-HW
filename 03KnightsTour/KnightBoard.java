public class KnightBoard{

    private int[][] board;
    private int step = 1;

    public KnightBoard ( int rows, int cols ) {
	board = new int[rows+4][cols+4];
	for ( int x = 0; x < rows+4; x++ ) {
	    for ( int y = 0; y < cols+4; y++ ) {
		if ( x == 0 || x == 1 || x == rows+2 || x == rows+3 ||
		     y == 0 || y == 1 || y == cols+2 || y == cols+3 ) {
		    board[x][y] = -1;
		}
	    }
	}
    }

    private boolean move( int row, int column ) {
	if ( board[row][column] != 0 ) {
	    return false;
	}
	else{
	    board[row][column] = step;
	    step++;
	}
	if ( board[row][column] == ( board.length - 4 ) * ( board[0].length - 4) ) {
	    return true;
	}
	if ( move( row+2, column+1 ) ||
	     move( row+2, column-1 ) ||
	     move( row-2, column+1 ) ||
	     move( row-2, column-1 ) ||
	     move( row+1, column+2 ) ||
	     move( row+1, column-2 ) ||
	     move( row-1, column+2 ) ||
	     move( row-1, column-2 ) ) {
	    return true;
	}
	step--;
	board[row][column] = 0;
	return false;
    }

    public boolean solve() {
	return move(2,2);
    }


    public void printSolution(){   
	for ( int x = 2; x < board.length-2; x++ ) {
	    for ( int y = 2; y < board[0].length-2; y++ ) {
		if ( board[x][y] < 10 ) {
		    System.out.print( " " + board[x][y] + " " );
		}
		else {
		    System.out.print(board[x][y] + " " );
		}
	    }
	    System.out.println( "" );
	}
    }

    public static void main( String[] args ) {
	KnightBoard pardeep = new KnightBoard(3,7);
	pardeep.solve();
	pardeep.printSolution();
    }

}
