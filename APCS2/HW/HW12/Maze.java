// Team Xissssss: Yedoh Khang, Michael Ruvinshteyn, Jake Zaia
// APCS2 pd1
// HW #12 -- Thinkers of the Corn
// 2017-03-02

/***
 * SKEELTON for class 
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 * 
 * ALGORITHM for finding exit from starting position:
 *  Start at a given point in the maze. If you aren't standing on
 *    a path, stop. Recursively try to move N, W, S, & E. Repeat 
 *    these steps making each of these spaces the next start.
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver {
    private char[][] maze;
    private int h, w; //height, width of maze
    private boolean solved;

    //initialize constants for map component symbols
    final private char HERO =         '@';
    final private char PATH =         '#';
    final private char WALL =         ' ';
    final private char EXIT =         '$';
    final private char VISITED_PATH = '.';


    public MazeSolver( String inputFile ) {
	// init 2D array to represent maze 
	// (25 rows x 80 columns is default terminal window size)
	maze = new char[25][80];
	
	//transcribe maze from file into memory
	try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

		String line = sc.nextLine();

		if ( w < line.length() ) 
		    w = line.length();
		
		for( int i=0; i<line.length(); i++ )
		    maze[row][i] = line.charAt( i );

		h++;
		row++;
	    } 
	    
	    for( int i=0; i<w; i++ )
	       	maze[row][i] = WALL;
	    row++;

	    h++;
	    row++;

	} catch( Exception e ) {
	    System.out.println( "Error reading file. Make sure maze is within limits of 25 rows and 80 columns");
	    System.exit(0);
	}
	
	//at init time, maze has not been solved:
	solved = false;
    }//end constructor
    
    
    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "[0;0H";
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC

	int row, col;
	for( row=0; row<h; row++ ) {
	    for( col=0; col<w; col++ )
		retStr = retStr + maze[row][col];
	    retStr = retStr + "\n";
	}
	return retStr;
    }


    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) {
	try {
	    Thread.sleep(n);
	} catch( InterruptedException e ) {
	    System.exit(0);
	}
    }


    /*********************************************
     * void solve(int x,int y) -- recursively finds maze exit (depth-first)
     * @param x starting x-coord, measured from left
     * @param y starting y-coord, measured from top
     *********************************************/
    public void solve( int row, int col) {

        delay(50); //slow it down enough to be followable

	if (row >= h || col >= w || row < 0 || col < 0){
	    return;
	}

	else if ( maze[row][col] == EXIT ) {
	    solved = true;
	    System.out.println(this);
	    System.exit(0);
	}
	else if ( !onPath(row,col) ) {
	    return;
	}
	//recursive reduction
	else {
	    System.out.println(this);
	    maze[row][col] = HERO;
	    
	    solve(row + 1, col); //right
	    solve(row - 1, col); //!right
	    solve(row, col + 1); //down
	    solve(row, col - 1); //!down

	    // if it gets this far, this area doesn't work
	    maze[row][col] = VISITED_PATH;

	    System.out.println(this);
	}
    }

    //accessor method to help with randomized drop-in location
    public boolean onPath( int row, int col) { return maze[row][col] == PATH; }

}//end class MazeSolver


public class Maze {
    public static void main( String[] args ) {

	try {
	    String mazeInputFile = args[0];

	    MazeSolver ms = new MazeSolver( mazeInputFile );

	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 
	    System.out.println( ms );

	    //drop hero into the maze (coords must be on path)
	    //comment next line out when ready to randomize startpos
	    //ms.solve( 3, 4 ); 

	    
	    //drop our hero into maze at random location on path
	    //the Tim Diep way:
	    Random r = new Random();
	    int startRow = r.nextInt( 25 );
	    int startCol = r.nextInt( 80 );
	    while ( !ms.onPath(startRow,startCol) ) {
		startRow = r.nextInt( 25 );
		startCol = r.nextInt( 80 );
		}
	    ms.solve( startRow, startCol );
	    
	} catch( Exception e ) { 
	    System.out.println( "Error reading input file." );
	    System.out.println( "Usage: java Maze <filename>" ); 
	}
    }
    
}//end class Maze
