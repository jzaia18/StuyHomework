// Jake Zaia
// APCS2 p1
// HW #29: Stress is the Best
// 2017-04-04

public class DequeTester {
    public static void main(String [] args){
	DLLDeque<Integer> cards = new DLLDeque<>();
	
	for (int i = 0; i < 100; i++){
	    cards.add(i);
	}
	System.out.println(cards);
	System.out.println("Size: " + cards.size());
	System.out.println("Empty: " + cards.isEmpty());
	
	//testing the different kinds of remove
	System.out.println("element: " + cards.element());
	System.out.println("getFirst: " + cards.getFirst());
	System.out.println("remove: " + cards.remove());
	System.out.println("pop: " + cards.pop());
	System.out.println("poll: " + cards.poll());
	System.out.println("Removing 50: " + cards.removeFirstOccurence(50));
	System.out.println(cards);
	System.out.println("Clearing Deque...");
	cards.clear();
	System.out.println(cards);
	
    }
}
