package stacksqueues;

/**
 * Tests for LinkedStack and ArrayDeque
 * @author Leonardo Costa
 * @version March 23, 2020
 */
public class Main {

	public static void main(String[] args) {
		testLinkedStack();
		System.out.println();
		testArrayDeque();
	}
	
	/**
	 * Tests LinkedStack methods
	 */
	public static void testLinkedStack() {
		System.out.println("Testing LinkedStack:");
		Stack<Object> myStack = new LinkedStack<Object>();
		System.out.println("myStack is empty? " + myStack.isEmpty());
		myStack.push("a");
		System.out.println("myStack is empty? " + myStack.isEmpty());
		myStack.push('b');
		myStack.push('c');
		System.out.println(myStack.peek());
		myStack.pop();
		System.out.println(myStack);
	}
	
	/**
	 * Tests ArrayDeque methods
	 */
	public static void testArrayDeque() {
		System.out.println("Testing ArrayDeque:");
		ArrayDeque<String> dequeStr = new ArrayDeque<String>();
		dequeStr.addLast("fox");
		dequeStr.addFirst("quick");
		dequeStr.addFirst("the");
		dequeStr.addLast("jumps");
		
		System.out.println(dequeStr.last());
		System.out.println(dequeStr.toString());
		
		dequeStr.removeFirst();
		dequeStr.removeLast();
		System.out.println(dequeStr.toString());		
	}
}
