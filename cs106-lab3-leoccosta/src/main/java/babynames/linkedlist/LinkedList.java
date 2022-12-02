package babynames.linkedlist;

import java.util.ArrayList;

/**
 * LinkedList is a doubly linked list with a header and a trailer that keeps
 * track of size, the number of babies listed accross all years, and the total
 * number of babies in all files read. New elements are inserted lexicographically.
 * 
 * @author Leonardo Costa
 * @version February 29, 2020
 */

public class LinkedList {
	
	private Node header; // a pointer to the first node
	private Node trailer; // a pointer to the last node 
	private int size;
	
	private int totalBabies; // the number of babies listed across all years
	
	private static final int YEARS = 29; // # years accounted for by files
	int[] totalsPerYear = new int[YEARS - 1]; 
	
	/**
	 * Constructor for the class.
	 */
	public LinkedList() {
		header = null;
		trailer = null;
		size = 0;
	}
	
	/**
	 * Add to the list; position is lexicographically determined by name.
	 * @param newData the input
	 */
	public void insert(String year, String name, String rank, String number) {
		
		Node newNode = new Node(year, name, rank, number);
		
		totalsPerYear[Integer.parseInt(year) - 1990] += Integer.parseInt(number);
		
		totalBabies += newNode.numberAllYears();
		
		// special case for an empty list
		if (size == 0) {
			header = newNode;
			trailer = newNode;
		}
		
		else {
			// find node that follows the insertion lexographically
			Node currNode = header;
			
			// special case: if the new node is the same as the header
			if (newNode.name().equals(currNode.name())) {
				currNode.addYearInfo(year, rank, number);
			} 
			
			// special case: if the new node comes before the header
			else if (newNode.name().compareTo(currNode.name()) <= 0) { 
				newNode.setNext(currNode);
				currNode.setPrev(newNode);
				header = newNode;			
			
			} else {
				
				// while newNode comes after currNode and currNode isn't the last node
				while (newNode.name().compareTo(currNode.name()) > 0 
						&& trailer != currNode) {
					currNode = currNode.next(); // walking action					
				}
				
				// if newNode comes before currNode, lexographically 
				// (only the case if currNode is the last element)
				if (newNode.name().compareTo(currNode.name()) > 0) {
					
					currNode.setNext(newNode);
					newNode.setPrev(currNode);
					trailer = newNode;
				
				// if currNode corresponds to the same name as newNode
				} else if (newNode.name().compareTo(currNode.name()) == 0) {
					currNode.addYearInfo(year, rank, number);
					
				// if currNode comes directly after newNode, lexographically
				} else {
					
					// insert the new node before currNode
					newNode.setNext(currNode);
					newNode.setPrev(currNode.prev());
					currNode.setPrev(newNode);
					newNode.prev().setNext(newNode);		
				}
			}
		}	
		
		// increase size
		size += 1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		int position = 0;
		
		StringBuilder s = new StringBuilder();
		Node currNode = header;
				
		while (currNode != null) {            
            // add position:
			s.append("Position of " + currNode + " in the Linked List: " + position + "\n\n");
			
			// add yearly info:
			ArrayList<int[]> yearlyInfo = currNode.yearlyInfo();
			for (int i = 0; i < yearlyInfo.size(); i++) {
				int[] yearInfo = yearlyInfo.get(i);
				
				// calculate % per year:
				double percent = (double) yearInfo[2] / totalsPerYear[yearInfo[0] - 1990];
				
				// add year's info:
				s.append(yearInfo[0] + "\n" + currNode + ": "
						+ yearInfo[1] + ", " + yearInfo[2] + ", " 
						+ String.format("%.6f", percent) + "\n\n"); 
			}
			
			// calculate total %: 
			double totalPercent = (double) currNode.numberAllYears() / this.totalBabies; 
			
			// add total info:
            s.append("Total\n" + currNode + ": Rank, " // TODO total rank
            		+ currNode.numberAllYears() + ", " 
            		+ String.format("%.6f", totalPercent) 
            		+ "\n\n\n");
			
			currNode = currNode.next();
            position++;
        } 
		
		return s.toString();
	}
	
	/**
	 * Searches for a name in the LinkedList.
	 * @param name the name being searched for
	 * @return a String containing the name's yearly and total 
	 * information (rank, number of babies, %) in the list
	 */
	public String lookup(String name) {
		
		StringBuilder s = new StringBuilder();
		int position = 0;
		
		Node currNode = header;
				
		while (currNode != null && name.compareTo(currNode.name()) != 0) {
			currNode = currNode.next(); // walking action
            position++; // keeping track of position
        } 
		
		if (currNode == null) {
			throw new IllegalArgumentException("Name not found in list.");
		}
		
		// add position:
		s.append("Position of " + currNode + " in the Linked List: " + position + "\n\n");
					
		// add yearly info:
		ArrayList<int[]> yearlyInfo = currNode.yearlyInfo();
		for (int i = 0; i < yearlyInfo.size(); i++) {
			int[] yearInfo = yearlyInfo.get(i);
						
			double percent = (double) yearInfo[2] / totalsPerYear[yearInfo[0] - 1990];
						
			s.append(yearInfo[0] + "\n" + currNode + ": "
					+ yearInfo[1] + ", " + yearInfo[2] + ", " 
					+ String.format("%.6f", percent) + "\n\n");
		}
					
		// calculate total %: 
		double totalPercent = (double) currNode.numberAllYears() / this.totalBabies; 
		
//		int totalRank = this.getTotalRank(currNode);
		
		// add total info:
		s.append("Total\n" + currNode + ": Rank, " 
				+ currNode.numberAllYears() + ", " 
				+ String.format("%.6f", totalPercent) 
				+ "\n");
		
		return s.toString();
	}
	
//	public int getTotalRank(Node node) {
//		
//		// TODO exception for empty list ???
//		
//		int position = 0;
//		
//		LinkedList ranked = this.rank();
//				
//		Node currNode = ranked.header();
//		while (currNode != null && 
//				node.name().compareTo(currNode.name()) != 0) {
//			currNode = currNode.next(); // walking action
//            position++; // keeping track of position
//        } 
//
//		return position;
//	}
//	
//	public LinkedList rank() {
//		LinkedList ranked = new LinkedList();
//		
//		Node newNode = this.header;
//		
//		System.out.println("Hello");
//		
//		while (newNode != null) {
//			// insert each node in "this" into ranked:
//			ranked.rankedInsert(newNode);
//			newNode = newNode.next(); // walking action
//		}
//		
//		System.out.println(ranked);
//
//		return ranked;
//	}
//	
//	private void rankedInsert(Node newNode) {		
//		// special case for an empty list
//		if (size == 0) {
//			header = newNode;
//			trailer = newNode;
//			
//		}
//		
//		else {
//			// find node that follows the insertion in ranking
//			Node currNode = header;
//
//			// special case: if the new node is the same as the header
//			if (newNode.numberAllYears() == currNode.numberAllYears()) {
//				// TODO
//				
//				
//			} // TODO see if this is redundant given first while in else
//			
//			// special case: if the new node comes before the header
//			else if (newNode.numberAllYears() > currNode.numberAllYears()) { 
//				newNode.setNext(currNode);
//				currNode.setPrev(newNode);
//				header = newNode;
//
//				
//			} else {
//
//				// while newNode comes after currNode and currNode isn't the last node
//				while (newNode.numberAllYears() < currNode.numberAllYears()
//						&& trailer != currNode) {
//					currNode = currNode.next(); // walking action
//				}
//				
//				// if newNode comes before currNode, lexographically 
//				// (only the case if currNode is the last element)
//				if (newNode.numberAllYears() >= currNode.numberAllYears()) {
//					
//					currNode.setNext(newNode);
//					newNode.setPrev(currNode);
//					trailer = newNode;
//				
//				// if currNode corresponds to the same name as newNode
////				} else if (newNode.numberAllYears() == currNode.numberAllYears()) {
//					
//					
//				// if currNode comes directly after newNode
//				} else {
//					
//					// insert the new node before currNode
//					newNode.setNext(currNode);
//					newNode.setPrev(currNode.prev());
//					currNode.setPrev(newNode);
//					newNode.prev().setNext(newNode);
//					
//					System.out.println(currNode);
//				}
//			} 
//		}
//		
//		size++;
//	}
	
	/**
	 * Getter for size
	 * @return the list's size
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Getter for header
	 * @return the list's header
	 */
	public Node header() {
		return header;
	}
	
	/**
	 * Getter for trailer
	 * @return the list's trailer
	 */
	public Node trailer() {
		return trailer;
	}
}