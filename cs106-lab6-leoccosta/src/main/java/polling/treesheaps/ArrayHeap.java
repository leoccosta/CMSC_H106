package polling.treesheaps;

import java.util.ArrayList;

/**
 * Array implementation of a max-heap
 * @author Leonardo Costa
 * @version April 15, 2020
 */
public class ArrayHeap<E extends Comparable<E>> implements PriorityQueue<E> {
	ArrayList<E> heap; 			/* the array that represents the heap */
	
	/**
	 * Default constructor
	 */
	public ArrayHeap() {
		heap = new ArrayList<>();
	}
	
	/**
	 * Constructor that takes in an unsorted array and makes the data into a
	 * heap.
	 * @param array the array containing the data contents of the heap  
	 */
	public ArrayHeap(ArrayList<E> array) {
	    // phase I heap sort
		heap = array;
		for (int i = 0; i < heap.size(); i++) {
			// bubble up element at index i until arr[0...i] forms a heap
			bubbleUp(i);
		}
	}
	
	/**
	 * Inserts an element into the heap in compliance with the heap condition.
	 * @param element the element to be inserted
	 */
	public void insert(E element) {		
		// first add the element to the end of the array
		heap.add(element);
		
		// “bubble up” the element until we have “re-heapified” our data structure
		bubbleUp(heap.size() - 1);
	}

	/**
	 * Return the root of the heap (i.e. the max given that this is a max heap). 
	 * If the heap is empty, throws an exception.
	 * @return the root of the heap
	 */
	public E max() {
		if (isEmpty()) {
			throw new EmptyHeapException();
		}
		return heap.get(0);
	}
	
	/**
	 * Removes and returns the root element, sets the last element in the heap as 
	 * the new root and bubbles it down to preserve the heap condition.
	 * @return the element removed from the (root of the) heap
	 */
	public E removeMax() {		
		// save the root element to return later
		E originalRoot = max(); 
		
		// special case: only one element
		if (size() == 1) {
			heap.remove(0);
		}
		
		else {
			// put the last element in the heap at the root
			heap.set(0, heap.remove(heap.size() - 1));
			
			// “bubble down” until the heap is re-heapified
			bubbleDown();
		}
		
		return originalRoot;
	}
	
	/**
	 * Sorts the array that represents the heap using phase II of the heap sort
	 * algorithm. The heap is destroyed in the process.
	 */
	public void sort() {
		for (int i = heap.size() - 1; i > 0; i--) {
			swap(0, i);
			bubbleDown(i);
		}
		if (heap.size() > 1) {
			swap(0, 1);
		}
	}
	
	/**
	 * Gets the number of elements in the heap
	 * @return the number of elements in the heap
	 */
	public int size() {
		return heap.size();
	}

	/**
	 * Determines whether the heap is empty.
	 * @return true if the heap is empty, false if it is not
	 */
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	/**
	 * Creates and returns a String representation of the heap that puts elements on a 
	 * new line for each level of the tree.
	 * @return the String representation of the tree
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		int currPowerOf2 = 1;
		
		// add each element to the output
		for (int i = 0; i < heap.size(); i++) {
			
			// add a new line whenever you reach a new power of 2
			if (i == currPowerOf2 - 1) {
				if (i == 0) {
					str.append(heap.get(i));
				} else {
					str.append("\n" + heap.get(i));
				}
				currPowerOf2 *= 2;
			} else {
				str.append(" " + heap.get(i));
			}
			
		}
		
		return str.toString();
	}
	
	
	/*** Helper Methods ***/ 
	
	/**
	 * Bubbles up the element at the given index to maintain the heap condition.
	 * @param index the initial index of the element to be bubbled up
	 */
	private void bubbleUp(int index) {		
		
		// while child > parent:
		while (index > 0 && (heap.get(index).compareTo(heap.get(parent(index))) > 0)) {
			// swap parent and child
			swap(index, parent(index));
			
			// update index of the element
			index = parent(index);
		}
		
	}
	
	/**
	 * Bubbles down the element at the top of the heap to maintain the heap condition.
	 */
	private void bubbleDown() {
		int index = 0;
		
		// while parent < both children:
		boolean finished = false;
		while (!finished) {
			int lastIndex = heap.size() - 1;
			int leftIndex = 2 * index + 1;
			int rightIndex = 2 * index + 2;
			
			// there is a left child and a right child
			if ( lastIndex >= rightIndex ) {
				E right = heap.get(rightIndex);
				E left = heap.get(leftIndex);
				
				// parent > left and parent > right
				if (heap.get(index).compareTo(right) > 0
						&& heap.get(index).compareTo(left) > 0) {
					finished = true;
				}
				
				// right > left
				else if (right.compareTo(left) > 0) {
					swap(index, rightIndex);
					index = rightIndex;
				}
				
				// right <= left
				else {
					swap(index, leftIndex);
					index = leftIndex;
				}
			}
			
			// there is a left child but no right child 
			else if ( lastIndex == leftIndex ) {
				E left = heap.get(leftIndex);
				if (heap.get(index).compareTo(left) > 0) {
					finished = true;
				} else { 
					swap(index, leftIndex);
					index = leftIndex;
				}
			}
			
			// no left or right 
			else {
				finished = true;
			}			
		}		
	}
	
	/**
	 * Bubbles down the element at the top of the heap to maintain the heap condition, 
	 * ignoring elements at or beyond the index inputted by the user. 
	 * @param end the index where the bubbling down terminates
	 */
	private void bubbleDown(int end) {
		int index = 0;
		
		// while parent < both children:
		boolean finished = false;
		while (!finished && (2 * index + 2) < end) {
			int lastIndex = heap.size() - 1;
			int leftIndex = 2 * index + 1;
			int rightIndex = 2 * index + 2;
			
			// if there is a left and a right
			if ( lastIndex >= rightIndex ) {
				E right = heap.get(rightIndex);
				E left = heap.get(leftIndex);
				
				// if parent > left and parent > right
				if (heap.get(index).compareTo(right) > 0
						&& heap.get(index).compareTo(left) > 0) {
					finished = true;
				}
				
				// right > left
				else if (right.compareTo(left) > 0) {
					swap(index, rightIndex);
					index = rightIndex;
				}
				
				// right <= left and left is before the end
				else if ((2 * index + 1) < end) {
					swap(index, leftIndex);
					index = leftIndex;
				}
				
				// if left is or is past the end
				else {
					finished = true;
				}
			}
			
			// if there is a left (before the end) but no right 
			else if ( lastIndex == leftIndex && (2 * index + 1) < end) {
				E left = heap.get(leftIndex);
				
				if (heap.get(index).compareTo(left) > 0) {
					finished = true;
				} else { 
					swap(index, leftIndex);
					index = leftIndex;
				}
			}
			
			// if there is no left or right, or left is or is past the end
			else {
				finished = true;
			}			
		}		
	}
	
	/**
	 * Takes in 2 indices and swaps the data/elements in these two positions.
	 * @param index1 the index of the first element
	 * @param index2 the index of the second element
	 */
	private void swap(int index1, int index2) {
		E element1 = heap.get(index1);
		heap.set(index1, heap.get(index2));
		heap.set(index2, element1);
	}
	
	/**
	 * Takes in a child index and returns the index of the parent.
	 * @param indexChild the index of the child whose parent is being searched for 
	 * @return the index of the child's parent
	 */
	private int parent(int indexChild) {
		if (indexChild == 0) {
			throw new IndexOutOfBoundsException("No parent – element is the root.");
		}
		return (indexChild - 1) / 2;
	}
}
