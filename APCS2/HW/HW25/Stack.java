// Jake Zaia
// APCS2 p1
// HW #25 -- What a Racket
// 2017-03-27

/*****************************************************
 * interface Stack
 * Specifies actions a stack must be able to perform.
 * Allows for generic typing.
 *****************************************************/

public interface Stack<P> 
{
    //Return true if this stack is empty, otherwise false.
    public boolean isEmpty();

    //Return top element of stack without popping it.
    public P peek();

    //Pop and return top element of stack.
    public P pop();

    //Push an element onto top of this stack.
    public void	push( P x );

}//end interface
