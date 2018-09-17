//Jake Zaia 
//APCS pd5
//HW #49: Dat Bubbly Tho
//2016-12-20

/*======================================
  class BubbleSort -- implements bubblesort algorithm (vanilla version)

                      ..------..                          
               /~~-.-~__-'`-__  ~-.  .-~-.                
              |   /~~~\     / ~~---\|     |               
              |  ||| * |   | | |  * |     |               
              /_-|\ \ /     \ \ \__.|\.  |                
              ~   \~~   |_|   ~~~~ /   ~-.\               
                   ~-.._      _.-~~                       
                     .--~~~~~~--.                         
                    |  |______|  |                        
                     ~-|______|-~                         
                       |      |                           
                       |______|                           
                       |  |   |                           
                       |__|___|                           
                       |_|| _||                        
                       `--'`--'                           
  ======================================*/

import java.util.ArrayList;

public class BubbleSort 
{

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) 
    {
        for (int iters = 0; iters < data.size()-1; iters++){
	    for (int i = data.size()-1; i > 0; i--){
		if (data.get(i).compareTo(data.get(i-1)) < 0){
		    Comparable temp = data.get(i);
		    data.remove(i);
		    data.add(i-1,temp);
		}
	    }
	}
    }


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> data = input; //I was too lazy to rename my variables... I'm the best student I swear
        for (int iters = 0; iters < data.size()-1; iters++){
	    for (int i = data.size()-1; i > 0; i--){
		if (data.get(i).compareTo(data.get(i-1)) < 0){
		    Comparable temp = data.get(i);
		    data.remove(i);
		    data.add(i-1,temp);
		}
	    }
	}
	return data;
    }


    public static void main(String [] args)
    {
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  bubbleSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	  //Im in love with the
	  ArrayList coco = populate( 10, 1, 1000 ); 
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );

	  System.out.println("\n");
	  
	  ArrayList glen2 = new ArrayList<Integer>();
	  glen2.add(7);
	  glen2.add(1);
	  glen2.add(5);
	  glen2.add(12);
	  glen2.add(3);
	  System.out.println( "ArrayList glen2 before sorting:\n" + glen );
	  ArrayList glen2Sorted = bubbleSort( glen2 );
	  System.out.println( "sorted version of ArrayList glen2:\n" 
	  + glen2Sorted );
	  System.out.println( "ArrayList glen2 after sorting:\n" + glen );
	  //Im in love with the
	  ArrayList coco2 = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco2 before sorting:\n" + coco2 );
	  ArrayList coco2Sorted = bubbleSort( coco2 );
	  System.out.println( "sorted version of ArrayList coco2:\n" 
	  + coco2Sorted );
	  System.out.println( "ArrayList coco2 after sorting:\n" + coco2 );
	  System.out.println( coco2 );
    }

}
/***
Bulbasaur by Maija Haavisto
                                           /
                        _,.------....___,.' ',.-.
                     ,-'          _,.--"        |
                   ,'         _.-'              .
                  /   ,     ,'                   `
                 .   /     /                     ``.
                 |  |     .                       \.\
       ____      |___._.  |       __               \ `.
     .'    `---""       ``"-.--"'`  \               .  \
    .  ,            __               `              |   .
    `,'         ,-"'  .               \             |    L
   ,'          '    _.'                -._          /    |
  ,`-.    ,".   `--'                      >.      ,'     |
 . .'\'   `-'       __    ,  ,-.         /  `.__.-      ,'
 ||:, .           ,'  ;  /  / \ `        `.    .      .'/
 j|:D  \          `--'  ' ,'_  . .         `.__, \   , /
/ L:_  |                 .  "' :_;                `.'.'
.    ""'                  """""'                    V
 `.                                 .    `.   _,..  `
   `,_   .    .                _,-'/    .. `,'   __  `
    ) \`._        ___....----"'  ,'   .'  \ |   '  \  .
   /   `. "`-.--"'         _,' ,'     `---' |    `./  |
  .   _  `""'--.._____..--"   ,             '         |
  | ." `. `-.                /-.           /          ,
  | `._.'    `,_            ;  /         ,'          .
 .'          /| `-.        . ,'         ,           ,
 '-.__ __ _,','    '`-..___;-...__   ,.'\ ____.___.'
 `"^--'..'   '-`-^-'"--    `-^-'`.''"""""`.,^.`.--' mh

***/
