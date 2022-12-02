package polling.treesheaps;

/**
 * BinaryTree that contains data in the root and has subtrees as its left and right
 * children. 
 * @author Leonardo Costa
 * @version April 01, 2020
 */
public class LinkedBinaryTree<E extends Comparable<E>> implements BinaryTree<E> {
	
	E data; // data contained in the root
	LinkedBinaryTree<E> left; // left subtree
	LinkedBinaryTree<E> right; // right subtree
	
	/**
	 * Constructor that takes user input for the data contained in the root
	 * @param argData the data to be contained in the root
	 */
	public LinkedBinaryTree(E argData) {
		data = argData;
		left = null;
		right = null;
	}
	
	/**
	 * Default constructor
	 */
	public LinkedBinaryTree() {
		data = null;
		left = null;
		right = null;
	}
	
	/**
	 * Adds an element to the tree based according to the binary search
	 * algorithm. If the element is already in the tree, it replaces it.
	 * @param element the element to be inserted
	 */
	public void insert(E element) {		
		
		// base case
		if (data == null) {
			data = element;
		} else if (data.compareTo(element) == 0) {
			data = element;
		} else if (left == null && (data.compareTo(element) > 0)) {
			left = new LinkedBinaryTree<E>(element);
		} else if (right == null && (data.compareTo(element)) < 0) {
			right = new LinkedBinaryTree<E>(element);
		}
		
		// recursive cases
		else if (data.compareTo(element) > 0) {
			left.insert(element);
		} else if (data.compareTo(element) < 0) {
			right.insert(element);
		}		
	} 

	/**
	 * Essentially a getter method for data held in the root. 
	 * @return the data in the current root
	 */
	public E getRootElement() {	
		return data;
	}
	
	/**
	 * Calculates and returns the number of elements in the tree
	 * @return the number of elements in the tree
	 */
	public int size() {
		int size = 1;
		
		// base: if the tree is a leaf
		if ((right == null) && (left == null)) {
		}
		
		// recursive cases (3): if the tree is not a leaf
		
		// if there is both a left and a right subtree
		else if ((right != null) && (left != null)) {
			size += right.size();
			size += left.size();
		}
		
		// if there is only a left subtree
		else if (right == null) {
			size += left.size();
		}
		
		// if there is only a right subtree
		else if (left == null) {
			size += right.size();
		}
		
		return size;
	}
	
	/**
	 * Determines whether the tree is empty.
	 * @return true if the tree is empty, false if it is not
	 */
	public boolean isEmpty() {
		return (data == null) && (left == null) && (right == null);
	}
	
	/**
	 * Uses an in-order traversal of the tree to create a String 
	 * representation of the object.
	 * @return in-order representation of the tree
	 */
	public String toStringInOrder() {	
		
		if (this.data == null) {
			return "null";
		}
		
		StringBuilder str = new StringBuilder();
		
		if (!(this.left == null)) {
			str.append(left.toStringInOrder() + " ");
		}
		str.append(data + " ");
		if (!(this.right == null)) {
			str.append(right.toStringInOrder() + " ");
		}
		
		return str.toString().trim();
	}
	
	/**
	 * Uses an pre-order traversal of the tree to create a String 
	 * representation of the object.
	 * @return pre-order representation of the tree
	 */
	public String toStringPreOrder() {
		StringBuilder str = new StringBuilder();
		
		str.append(data + " ");
		if (!(this.left == null)) {
			str.append(left.toStringPreOrder() + " ");
		}
		if (!(this.right == null)) {
			str.append(right.toStringPreOrder() + " ");
		}
		
		return str.toString().trim();
	}
	
	/**
	 * Uses an post-order traversal of the tree to create a String 
	 * representation of the object.
	 * @return post-order representation of the tree
	 */
	public String toStringPostOrder() {
		StringBuilder str = new StringBuilder();		
		
		if (!(this.left == null)) {
			str.append(left.toStringPostOrder() + " ");
		}
		if (!(this.right == null)) {
			str.append(right.toStringPostOrder() + " ");
		}
		str.append(data + " ");
		
		return str.toString().trim();
	}
	
	/**
	 * Overriden toString method for this class that returns a
	 * String representation of the object.
	 * @return a String representation of the tree
	 */
	@Override
	public String toString() {
		return "Tree:\nPre:\t" + this.toStringPreOrder()
				+ "\nIn:\t" + this.toStringInOrder()
				+ "\nPost:\t" + this.toStringPostOrder();
	}
	
}
