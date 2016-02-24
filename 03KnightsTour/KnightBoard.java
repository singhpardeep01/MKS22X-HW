public class KnightBoard{

    private int[][] board;
    private int length, width, step = 1;

    public KnightBoard ( int cols, int rows ) {
	length = rows;
	width = cols;
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

    private boolean moveKnight( int row, int column ) {
	printSolution();
	System.out.println("");
	if ( row == 2 && column == 2 ) {
	    board[2][2] = 1;
	}
	if ( width * length > step ) {
	    if ( board[row-2][column+1] == 0 ) {
		board[row-2][column+1] = ++step;
		if ( ! moveKnight( row-2, column+1 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row-2][column-1] == 0 ) {
		board[row-2][column-1] = ++step;
		if ( ! moveKnight( row-2, column-1 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row+2][column+1] == 0 ) {
		board[row+2][column+1] = ++step;
		if ( ! moveKnight( row+2, column+1 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row+2][column-1] == 0 ) {
		board[row+2][column-1] = ++step;
		if ( ! moveKnight( row+2, column-1 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row+1][column+2] == 0 ) {
		board[row+1][column+2] = ++step;
		if ( ! moveKnight( row+1, column+2 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row+1][column-2] == 0 ) {
		board[row+1][column-2] = ++step;
		if ( ! moveKnight( row+1, column-2 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row-1][column+2] == 0 ) {
		board[row-1][column+2] = ++step;
		if ( ! moveKnight( row-1, column+2 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    if ( board[row-1][column-2] == 0 ) {
		board[row-1][column-2] = ++step;
		if ( ! moveKnight( row-1, column-2 ) ) {
		    board[row][column] = 0;
		}
		else {
		    return true;
		}
	    }
	    else {
		return false;		
	    }
	}

	return true;
       
    }
    
    public boolean solve() {
	return moveKnight(2,2);
    }
    /*
    public boolean solveH( int row, int column, int lastMove ) {
	boolean ret = false;
	if ( row == 2 && column == 2 ) {
	    board[2][2] = 1;
	}
	if ( board[row][column] == ( board.length - 4 ) * ( board[0].length - 4 ) ) {
	    return true;
	}
	else if ( 1 > lastMove && moveKnight( row, column, 1 ) ) {
	    ret = solveH( row-2, column+1, 0 );
	    if ( ret == false ) {
		board[row-2][column+1] = 0;
		//board[row][column] = 0;
		solveH( row, column, 1 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 2 > lastMove && moveKnight( row, column, 2 ) ) {
	    ret = solveH( row-2, column-1, 0 );
	    if ( ret == false ) {
		board[row-2][column-1] = 0;
		//board[row][column] = 0;
		solveH( row, column, 2 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 3 > lastMove && moveKnight( row, column, 3 ) ) {
	    ret = solveH( row+2, column+1, 0 );
	    if ( ret == false ) {
		board[row+2][column+1] = 0;
		//board[row][column] = 0;
		solveH( row, column, 3 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 4 > lastMove && moveKnight( row, column, 4 ) ) {
	    ret = solveH( row+2, column-1, 0 );
	    if ( ret == false ) {
		board[row+2][column-1] = 0;
		//board[row][column] = 0;
		solveH( row, column, 4 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 5 > lastMove && moveKnight( row, column, 5 ) ) {
	    ret = solveH( row+1, column+2, 0 );
	    if ( ret == false ) {
		board[row+1][column+2] = 0;
		//board[row][column] = 0;
		solveH( row, column, 5 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 6 > lastMove && moveKnight( row, column, 6 ) ) {
	    ret = solveH( row+1, column-2, 0 );
	    if ( ret == false ) {
		board[row+1][column-2] = 0;
		//board[row][column] = 0;
		solveH( row, column, 6 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 7 > lastMove && moveKnight( row, column, 7 ) ) {
	    ret = solveH( row-1, column+2, 0 );
	    if ( ret == false ) {
		board[row-1][column+2] = 0;
		//board[row][column] = 0;
		solveH( row, column, 7 );
	    }
	    else {
		return true;
	    }
	}
	else if ( 8 > lastMove && moveKnight( row, column, 8 ) ) {
	    ret = solveH( row-1, column-2, 0 );
	    if ( ret == false ) {
		board[row-1][column-2] = 0;
		//board[row][column] = 0;
		solveH( row, column, 8 );
	    }
	    else {
		return true;
	    }
	}
	return false;
    }
    */
    public void printSolution(){   
	for ( int x = 2; x < board.length-2; x++ ) {
	    for ( int y = 2; y < board[0].length-2; y++ ) {
		    System.out.print( board[x][y] + " " );
	    }
	    System.out.println( "" );
	}
    }

    public static void main( String[] args ) {
	KnightBoard pardeep = new KnightBoard(5,5);
	pardeep.solve();
	pardeep.printSolution();
    }

}
