package stacksqueues;

/**
 * Double-ended queue implemented using a circular array with a pointer 
 * for the front and where insertion and removal can happen at both ends
 * @author Leonardo Costa
 * @version March 22, 2020
 */
public class ArrayDeque<E> implements Deque<E> {

	public static final int CAPACITY = 1000;
	
	private int f;
	private int size;
	private E[] data;
	
	/**
	 * Default constructor
	 */
	public ArrayDeque() {
		this(CAPACITY);
	}
	
	/**
	 * Constructor that takes user input for capacity
	 * @param capacity user input for the queue's capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayDeque(int capacity) {
		f = 0;
		size = 0;
		data = (E[]) new Object[capacity];
	}
	
	/**
	 * Getter method for size.
	 * @return the size of the queue
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Determines whether the queue is empty.
	 * @return true if the queue is empty, false if it is not
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Getter method for first element in the queue.
	 * @return the first element in the queue
	 */
	public E first() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return data[f];
	}
	
	/**
	 * Getter method for last element in the queue.
	 * @return the last element in the queue
	 */
	public E last() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
				
		return data[((f + size - 1) % data.length)];
	}
	
	/**
	 * Adds an element to the end of the queue.
	 * @param element the element to be added
	 */
	public void addLast(E element) throws FullQueueException {
		// equivalent to a regular queue's enqueue()
		
		if (size == data.length) { // or ((f + size) % length) == f ?
			throw new FullQueueException();
		}
		
		int end = (f + size) % data.length;
		data[end] = element;
		size++;
	}
	
	/**
	 * Adds an element to the front of the queue.
	 * @param element the element to be added
	 */
	public void addFirst(E element) throws FullQueueException {
		if (size == data.length) {
			throw new FullQueueException();
		}
		
		int beforeFirst = (f - 1 + data.length) % data.length;
		data[beforeFirst] = element;
		f = beforeFirst;
		size++;
	}

	/**
	 * Returns and removes the element at the front of the queue.
	 * @return the data contained at the first index of the queue 
	 */
	public E removeFirst() throws EmptyQueueException {
		// equivalent to a regular queue's dequeue()
		
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		E result = data[f];
		f = (f + 1) % data.length;
		size--;
		return result;
	}
	
	/**
	 * Returns and removes the element at the end of the queue.
	 * @return the data contained at the last index of the queue 
	 */
	public E removeLast() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		E result = data[((f + size) % data.length) - 1];
		
		size--;
		return result;
	}
	
	/**
	 * Overriden toString method for this class that returns a
	 * String representation of the object.
	 * @return a String representation of the queue
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("(");
		
		if(!isEmpty()) {
			for (int i = 0; i < size - 1; i++) {
				int index = (f + i) % data.length;
				str.append(data[index] + ", ");
			}
			str.append(data[(f + size - 1) % data.length]);
		}
		
		return str.append(")").toString();
	}
	
	public String toStringNoCommas() {
		StringBuilder str = new StringBuilder("\"");
		
		if(!isEmpty()) {
			for (int i = 0; i < size - 1; i++) {
				int index = (f + i) % data.length;
				str.append(data[index] + " ");
			}
			str.append(data[(f + size - 1) % data.length]);
		}
		
		return str.append("\"").toString();
	}

}