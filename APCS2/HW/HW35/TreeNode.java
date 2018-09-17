// Jake Zaia
// APCS2 p1
// HW #34: TBA
// 2017-05-03

/*****************************************************
 * class TreeNode
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode {
    //instance variables / attributes of a TreeNode:
    private int cargo;
    private TreeNode left;
    private TreeNode right;

    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( int initValue ) {
	cargo = initValue;
    }      

    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified
     * value, left, and right subtrees.
     *****************************************************/
    TreeNode( int initValue, TreeNode initLeft, TreeNode initRight ) {
	this(initValue);
	left = initLeft;
	right = initRight;
    }

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() {
	return left;
    }

    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() {
	return right;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getValue() {
	return cargo;
    }

    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode newLeft ) {
	left = newLeft;
    }

    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode newRight ) {
	right = newRight;
    }

    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( int newValue ) {
	cargo = newValue;
    }
 
}//end class
