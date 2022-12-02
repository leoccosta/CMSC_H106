package babynames.linkedlist;

import java.util.ArrayList;

/**
 * Class that holds a name and its rank, number,
 * and percentage for a year, and its total rank,
 * number, and percentage
 * @author Leonardo Costa
 * @version February 25, 2020
 */
public class Name {
	//rank,male-name,male-number,female-name,female-number
	
	private final String name; // the name
	
	
	private int totalNumber; // the amount of people with that name during this year
	private int totalRank; // rank of this name during that year
	
	private ArrayList<String[]> yearlyInfo;
		// each array has 
	
	public Name(String argName) {
		name = argName;
	}
	
	public Name(int argRank, String argName, int argNumber) {
		name = argName;
		
		totalNumber = argNumber;
		
		String[] s = { Integer.toString(argRank), Integer.toString(argRank) };
		yearlyInfo.add(s);
	}
	
	// for total rank maybe take advantage of insert()  
	
	/**
	 * Getter for name
	 * @return the Node's associated name
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Adds the information of a new year for the name
	 */
	public void addNewYear(String year, String rank, String number) {
		totalNumber += Integer.parseInt(number);
		
		String[] s = {year, rank, number};
		yearlyInfo.add(s);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
//		for (int i = 0; i < yearlyInfo.size(); i++) {
//			String[] yearsInfo = yearlyInfo.get(i);
//			System.out.print("s \n");
//			s.append(yearsInfo[0] + "\nName : " + yearsInfo[1] + ", "
//					+ yearsInfo[2] + ", ");
//		}
		
//		System.out.println(s.toString());
		
		return name;
		
		// TODO for each index of yearlyInfo, s.append(...)
		
		/* FORMAT:
		 * 
		 * 		Position of Name in the Linked List: integer
		 * 		(One empty line)
		 * 		Year
		 * 		Name : Rank, Number, Percent
		 * 		(One empty line) 
		 *	 	Year
		 *		Name : Rank, Number, Percent
		 * 		(One empty line)
//		 * 		...
//		 * 		(One empty line)
//		 * 		Total
//		 * 		Name : Rank, Number, Percent
		 * 
		 */
	}	
}
