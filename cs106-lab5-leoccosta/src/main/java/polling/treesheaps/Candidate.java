package polling.treesheaps;

/**
 * Class that represents a candidate, holding the candidate's name and polling information
 * @author Leonardo Costa
 * @version March 31, 2020
 */
public class Candidate implements Comparable<Candidate> {
	
	String lastName; // candidate's last name
	String fullName; // candidate's full name
	double pollingPercent; // candidate's polling percentage
	
	/**
	 * Constructor that takes user input for the candidate's information
	 * @param argLast input for the candidate's last name
	 * @param argFull input for the candidate's full name
	 * @param argPercent input for the candidate's polling percentage
	 */
	public Candidate(String argLast, String argFull, double argPercent) {
		lastName = argLast;
		fullName = argFull;
		pollingPercent = argPercent;
	}
	
	/**
	 * Constructor that takes all String user input for the candidate's information
	 * @param argLast input for the candidate's last name
	 * @param argFull input for the candidate's full name
	 * @param argPercent input for the candidate's polling percentage
	 */
	public Candidate(String argLast, String argFull, String argPercent) {
		lastName = argLast;
		fullName = argFull;
		pollingPercent = Double.parseDouble(argPercent);
	}
	
	/**
	 * Getter method for last name of the candidate.
	 * @return the last name of the candidate
	 */
	public String lastName() {
		return lastName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Candidate comparedTo) {
		return this.lastName.compareTo(comparedTo.lastName());
	}
	
	/**
	 * Overriden toString method for this class that returns a
	 * String representation of the object.
	 * @return a String representation of the candidate
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(fullName).append(":").append(pollingPercent);
		return str.toString();
	}

}
