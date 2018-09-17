// Jake Zaia
// APCS2 P1
// HW #08 -- Luxembourg Beckons
// 2017-02-16

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;

    // I added this one myself, makes code more readable
    private int _size;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
	_size = size;
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * [Tries to fill every space in a given collumn, if this works, tries the same on the next collumn. Keeps repeating 
            this until either solved, or can place no moves. If it runs out of move, it recursively undoes its moves using
            the removeQueen() method.]
     */
    public boolean solve()
    {
	if (solveH(0)){
	    printSolution();
	    return true;
	}
	return false;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	if (col >= _size)
	    return true;
	for (int i = 0; i < _size; i++){
	    if (addQueen(i,col)){
		if (solveH(col + 1))
		    return true;
		else
		    removeQueen(i,col);
	    }
	}
	return false;
    }


    //print a valid placement of n queens
    public void printSolution()
    {
        String ans = "";
	for( int r = 0; r < _board.length; r++) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] <= 0)
		    ans+= "_";
		else
		    ans+= "Q";
		ans += " ";
		
	    }
	    ans += "\n";
	}
	System.out.println(ans);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Adds a Queen to the board, returns if it was successful
     * precondition: row < _board.length && col < _board.length
     * postcondition: Either returns false, or a Queen is added and returns true.
     */
    private boolean addQueen(int row, int col)
    {
	// If the space is illegal, the queen can't be added
	if(_board[row][col] != 0){
	    return false;
	}

	// Place the queen
	_board[row][col] = 1;

	// How many spaces to the right of the queen you are checking for legality.
	int offset = 1;

	// Declare illegal spaces to be illegal
	while(col+offset < _board[row].length) {
	    // Removes the row to the right of this Queen
	    _board[row][col+offset]--;

	    // Removes diagonals
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // Increments offset so the next collumn's squares can be removed
	    offset++;
	}
	return true;
    }


    /***
     * Removes a queen at the specified coordinates.
     * precondition: row < size && col < size
     * postcondition: False: no queen there, or True: found and removed queen.
     */
    private boolean removeQueen(int row, int col)
    {
	// Return false if there is not a queen at the specified coordinates
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// Reset space to be blank
	int offset = 1;	        // How far to the right of this space is beign checked

	// Systematically increment all previously endagered spaces up by 1 to negate the effects of the removed queen.
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Convers the board to a String
     * precondition: none
     * postcondition: Board is converted to a String
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	/*QueenBoard b = new QueenBoard(5);
        System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);*/

	QueenBoard b = new QueenBoard(8);
	b.solve();
    }//end main()
    
}//end class
