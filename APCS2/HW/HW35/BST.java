// Jake Zaia
// APCS2 p1
// HW #35: BSTs is the Perfect Place for Shade
// 2017-05-03

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST {
    //instance variables / attributes of a BST:
    private TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) {
	root = null;
    }

    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {
     	if (root == null)
	    root = new TreeNode(newVal);
	else {
	    TreeNode currNode = root;
	    while (currNode != null) {
		if (newVal >= currNode.getValue()) {
		    if (currNode.getRight() == null) {
			currNode.setRight(new TreeNode(newVal));
			break;
		    }
		    else
			currNode = currNode.getRight();
		}
		else {
		    if (currNode.getLeft() == null) {
			currNode.setLeft(new TreeNode(newVal));
			break;
		    }
		    else
			currNode = currNode.getLeft();
		}
	    }
	}
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() {
	System.out.println(preOrderTrav(root));
    }

    public String preOrderTrav(TreeNode t) {
	if (t == null)
	    return "";
	String retStr = "";
	retStr += t.getValue();
	retStr += preOrderTrav(t.getLeft());
	retStr += preOrderTrav(t.getRight());
	return retStr;	
    }
 
    public void inOrderTrav() {
	System.out.println(inOrderTrav(root));
    }

    public String inOrderTrav(TreeNode t) {
	if (t == null)
	    return "";
	String retStr = "";
	retStr += inOrderTrav(t.getLeft());
	retStr += t.getValue();
	retStr += inOrderTrav(t.getRight());
	return retStr;	
    }
	
    public void postOrderTrav() {
	System.out.println(postOrderTrav(root));
    }

    public String postOrderTrav(TreeNode t) {
	if (t == null)
	    return "";
	String retStr = "";
	retStr += postOrderTrav(t.getLeft());
	retStr += postOrderTrav(t.getRight());
	retStr += t.getValue();
	return retStr;	
    }
    
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target ) {
	if (root == null)
	    return null;
    	return search(root, target);
    }

    TreeNode search(TreeNode t, int target){
	if (t.getValue() == target)
	    return t;
	if (t.getLeft() != null && target < t.getValue()){
	    return search(t.getLeft(), target);
	}
	if (t.getRight() != null && target > t.getValue())
	    return search(t.getRight(), target);
	return null;
    }
    

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height() {
	return height(root);
    }

    public int height (TreeNode t){
	if (t.getLeft() == null && t.getRight() == null)
	    return 1;
	else if (t.getLeft() == null)
	    return 1 + height(t.getRight());
	else if (t.getRight() == null)
	    return 1 + height(t.getLeft());
	else
	    return 1 + Math.max(height(t.getLeft()),height(t.getRight()));
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves() {
        return numLeaves(root);
    }

    public int numLeaves(TreeNode t) {
        if (t.getLeft() == null && t.getRight() == null)
	    return 1;
	else if (t.getLeft() == null)
	    return numLeaves(t.getRight());
	else if (t.getRight() == null)
	    return numLeaves(t.getLeft());
	else
	    return numLeaves(t.getLeft()) +  numLeaves(t.getRight());
    }




    //main method for testing
    public static void main( String[] args ) {
	
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();	


	  System.out.println("Expect 2: " + arbol.search(2).getValue());
	  System.out.println("Expect 3: " + arbol.search(3).getValue());
	  System.out.println("Expect 5: " + arbol.search(5).getValue());
	  try { System.out.println(arbol.search(7).getValue());}
	  catch (Exception e) {System.out.println("Caught expected exception");}

	  System.out.println("Height: " + arbol.height());
	  System.out.println("Number of leaves: " + arbol.numLeaves());
			     
	  //insert your new test calls here...
	  
    }

}//end class
