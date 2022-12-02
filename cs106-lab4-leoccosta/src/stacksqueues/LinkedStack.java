package stacksqueues;

import java.util.EmptyStackException;

/**
 * Linked-list stack implementation
 * @author Leonardo Costa
 * @version March 23, 2020
 */
public class LinkedStack<E> implements Stack<E> {
	
	private Node<E> top;
	private int size;
	
	/**
	 * Constructor for LinkedStack.
	 */
	public LinkedStack() {
		top = null;
		size = 0;
	}

	/**
	 * Adds an element to the top of the stack.
	 * @param element the element to be added to the stack
	 */
	public void push(E element) {
		Node<E> newNode = new Node<E>(element);
		newNode.setNext(top);
		top = newNode;
		
		// increase size
		size += 1;
	}
	
	/**
	 * Returns and removes the element at the top of the stack.
	 * @return the data contained in the Node at the top of the stack 
	 */
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		// reassign top of the stack
		Node<E> popped = top;
		top = popped.next();
		
		// decrease size
		size -= 1;
		
		return popped.data();
	}
	
	/**
	 * Allows the user to see what is on the top of the stack
	 * without changing the stack.
	 * @return the value contained in the Node at the top of 
	 * the stack
	 */
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data();
	}

	/**
	 * Getter method for size.
	 * @return the size of the stack
	 */
	public int size() {
		return size;
	}

	/**
	 * Determines whether the stack is empty.
	 * @return true if the stack is empty, false if it is not
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Overriden toString method for this class that returns a
	 * String representation of the object.
	 * @return a String representation of the stack
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("(");
		
		Stack<Object> reverse = new LinkedStack<Object>();
		
		if(!isEmpty()) {
			
			// copy stack to reverse [which reverses]
			Node<E> currNode = top;
			while (currNode.next() != null) {
				reverse.push(currNode);
				currNode = currNode.next();
			}
			reverse.push(currNode);
			
			// add each element to the StringBuilder
			while (reverse.size() > 1) {
				str.append(reverse.pop() + ", ");
			}
			str.append(reverse.pop());
		
		}
		return str.append(")").toString();
	}	
	
}
