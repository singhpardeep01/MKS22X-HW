public class KnightBoard{

    private int[][] board;

    public KnightBoard ( int cols, int rows ) {
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

    private boolean moveKnight( int row, int column, int move) {
	printSolution();
	System.out.println("row:" + row);
	System.out.println("column:" + column);
	System.out.println("move:" + move);
	if ( move == 1 && board[row-2][column+1] == 0 ) {
	    board[row-2][column+1] = board[row][column] + 1;
	}
	else if ( move == 2 && board[row-2][column-1] == 0 ) {
	    board[row-2][column-1] = board[row][column] + 1;
	}
	else if ( move == 3 && board[row+2][column+1] == 0 ) {
	    board[row+2][column+1] = board[row][column] + 1;
	}
	else if ( move == 4 && board[row+2][column-1] == 0 ) {
	    board[row+2][column-1] = board[row][column] + 1;
	}
	else if ( move == 5 && board[row+1][column+2] == 0 ) {
	    board[row+1][column+2] = board[row][column] + 1;
	}
	else if ( move == 6 && board[row+1][column-2] == 0 ) {
	    board[row+1][column-2] = board[row][column] + 1;
	}
	else if ( move == 7 && board[row-1][column+2] == 0 ) {
	    board[row-1][column+2] = board[row][column] + 1;
	}
	else if ( move == 8 && board[row-1][column-2] == 0 ) {
	    board[row-1][column-2] = board[row][column] + 1;
	}
	else {
	    return false;
	}
	return true;
    }
    
    private int[] undoKnight( int row, int column) {
	int num = 0;
	int maxX = 0;
	int maxY = 0;
	int[] ret = new int[3];
	if ( board[row][column] > 0 ) {
	    board[row][column] = 0;
	}
	for ( int x = 0; x < board.length; x++ ) {
	    for ( int y = 0; y < board[0].length; y++ ) {
		if ( board[x][y] > num ) {
		    num = board[x][y];
		    maxX = x;
		    maxY = y;
		}
	    }
	}
	ret[0] = maxX;
	ret[1] = maxY;
	if ( row - maxX == -2 && column - maxY == 1 ) {
	    ret[2] = 1;
	}
	else if ( row - maxX == -2 && column - maxY == -1 ) {
	    ret[2] = 2;
	}
	else if ( row - maxX == 2 && column - maxY == 1 ) {
	    ret[2] = 3;
	}
	else if ( row - maxX == 2 && column - maxY == -1 ) {
	    ret[2] = 4;
	}
	else if ( row - maxX == 1 && column - maxY == 2 ) {
	    ret[2] = 5;
	}
	else if ( row - maxX == 1 && column - maxY == -2 ) {
	    ret[2] = 6;
	}
	else if ( row - maxX == -1 && column - maxY == 2 ) {
	    ret[2] = 7;
	}
	else if ( row - maxX == -1 && column - maxY == -2 ) {
	    ret[2] = 8;
	}
	return ret;
    }

    public boolean solve() {
	return solveH(2,2,0);
    }

    public boolean solveH( int row, int column, int lastMove ) {
	if ( row == 2 && column == 2 ) {
	    board[2][2] = 1;
	}
	if ( board[row][column] == ( board.length - 4 ) * ( board[0].length - 4 ) ) {
	    return true;
	}
	else if ( 1 > lastMove && moveKnight( row, column, 1 ) ) {
	    return solveH( row-2, column+1, 0 );
	}
	else if ( 2 > lastMove && moveKnight( row, column, 2 ) ) {
	    return solveH( row-2, column-1, 0 );
	}
	else if ( 3 > lastMove && moveKnight( row, column, 3 ) ) {
	    return solveH( row+2, column+1, 0 );
	}
	else if ( 4 > lastMove && moveKnight( row, column, 4 ) ) {
	    return solveH( row+2, column-1, 0 );
	}
	else if ( 5 > lastMove && moveKnight( row, column, 5 ) ) {
	    return solveH( row+1, column+2, 0 );
	}
	else if ( 6 > lastMove && moveKnight( row, column, 6 ) ) {
	    return solveH( row+1, column-2, 0 );
	}
	else if ( 7 > lastMove && moveKnight( row, column, 7 ) ) {
	    return solveH( row-1, column+2, 0 );
	}
	else if ( 8 > lastMove && moveKnight( row, column, 8 ) ) {
	    return solveH( row-1, column-2, 0 );
	}
	else {
	    int[] loc = undoKnight( row, column );
	    System.out.println( "loc" + loc[0] + loc[1] + loc[2] );
	    solveH( loc[0], loc[1], loc[2]);			    
	}
	return false;
    }

    public void printSolution(){   
	for ( int x = 2; x < board.length-2; x++ ) {
	    for ( int y = 2; y < board[0].length-2; y++ ) {
		//	if ( board[x][y] != -1 ) {
		    System.out.print( board[x][y] + " " );
		    //}
	    }
	    System.out.println( "" );
	}
    }

    public static void main( String[] args ) {
	KnightBoard pardeep = new KnightBoard(6,6);
	pardeep.solve();
	pardeep.printSolution();
    }

}
