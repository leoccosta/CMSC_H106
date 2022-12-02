package polling.treesheaps;

/**
 * Class that represents a candidate, holding the candidate's name and polling information
 * @author Leonardo Costa
 * @version April 11, 2020
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
	 * Getter method for the last name of the candidate.
	 * @return the last name of the candidate
	 */
	public String lastName() {
		return lastName;
	}
	
	/**
	 * Getter method for the polling percent of the candidate.
	 * @return the polling percent of the candidate
	 */
	public double pollingPercent() {
		return pollingPercent;
	}
	
	/**
	 * Compares candidates based on their polling percents. If their polling
	 * percents are equal, it compares them based on their last names.
	 * @param comparedTo the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object 
	 * is less than, equal to, or greater than the specified object.
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Candidate comparedTo) {
		if (this.pollingPercent == comparedTo.pollingPercent()) {
			return this.lastName.compareTo(comparedTo.lastName());
		} else if (this.pollingPercent < comparedTo.pollingPercent()) {
			return -1;
		} else {
			return 1;
		}
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
