package babynames.linkedlist;

import java.util.ArrayList;

/**
 * Node class that keeps track of the Node before and after
 * it in a list. It also contains information about a certain 
 * baby name, including the name's rank and number for each relevant
 * year as well as the total number of babies for all years.
 * @author Leonardo Costa
 * @version February 29, 2020
 */
public class Node {
	private final String name; // the name that the Node represents
	private Node next; // reference to the next Node
	private Node prev; // reference to the previous Node
	
	private int numberAllYears; // total # of babies for all years
	
	// ArrayList containing the Node's yearly info
	private ArrayList<int[]> yearlyInfo = new ArrayList<int[]>();
	
	/**
	 * Constructor for Node
	 * @param year the first year with information being added
	 * @param name the name being added to the list
	 * @param rank the rank of that name for that year
	 * @param number the amount of babies with that name for that year
	 */
	public Node(String year, String name, String rank, String number) {
		this.name = name;
		numberAllYears = Integer.parseInt(number);
		next = null; // does not have a "next" yet
		prev = null; // does not have a "previous" yet
		
		int[] arr = {Integer.parseInt(year), Integer.parseInt(rank), Integer.parseInt(number)};
		yearlyInfo.add(arr);
	}
	
	/**
	 * Setter for next
	 * @param nextNode a new node
	 */
	public void setNext(Node nextNode) {
		next = nextNode;
	}

	/**
	 * Setter for prev
	 * @param nextNode a new node
	 */
	public void setPrev(Node prevNode) {
		prev = prevNode;
	}
	
	/**
	 * Getter for name
	 * @return the Node's associated name
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Getter for next
	 * @return the next Node in the list
	 */
	public Node next() {
		return next;
	}
	
	/**
	 * Getter for next
	 * @return the previous Node in the list
	 */
	public Node prev() {
		return prev;
	}
	
	/**
	 * Getter for yearlyInfo
	 * @return the Node's yearly info (in an ArrayList)
	 */
	public ArrayList<int[]> yearlyInfo() {
		return yearlyInfo;
	}
	
	/**
	 * Getter for numberAllYears
	 * @return the total number of babies by the Node's name
	 */
	public int numberAllYears() {
		return numberAllYears;
	}
	
	/**
	 * Adds information for an additional year associated with
	 * the Node's name (to yearlyInfo) 
	 * @param year the year with information being added
	 * @param rank the rank of that name for that year
	 * @param number the amount of babies with that name for that year
	 */
	public void addYearInfo(String year, String rank, String number) {
		numberAllYears += Integer.parseInt(number);
		int[] arr = {Integer.parseInt(year), Integer.parseInt(rank), Integer.parseInt(number)};
		yearlyInfo.add(arr);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
}
