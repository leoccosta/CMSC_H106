package stacksqueues;

/**
 * Node will contain an element of type E and 
 * point to the next Node
 * @author Leonardo Costa
 * @version March 6, 2020
 */
public class Node<E> {
	
	private E data; // special data
	private Node<E> next; // reference to the next Node
	
	/**
	 * Constructor for Node
	 * @param initData the Node's data
	 */
	public Node(E initData) {
		data = initData;
		next = null; // does not have a "next" yet
	}
	
	/**
	 * Setter for next
	 * @param nextNode a new node
	 */
	public void setNext(Node<E> nextNode) {
		next = nextNode;
	}
	
	/**
	 * Getter for next
	 * @return next the next Node
	 */
	public Node<E> next() {
		return next;
	}
	
	/**
	 * Getter for data
	 * @return data held in the Node
	 */
	public E data() {
		return data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}