package deduplication.sqf;

/**
 * Holds information relevant for deduplication purposes about a 
 * registed voter. 
 * @author Leonardo Costa
 * @version May 06, 2020
 */
public class Voter implements Comparable<Voter> {
	
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	
	/**
	 * Constructor; takes in relevant information and stores it.
	 * @param row array containing all the information about the voter
	 */
	public Voter(String[] row) {
		lastName = row[3];
		firstName = row[4];
		dateOfBirth = row[7];
	}
	
	/**
	 * Getter for the voter's last name
	 * @return the voter's last name
	 */
	public String lastName() {
		return lastName;
	}
	
	/**
	 * Getter for the voter's first name
	 * @return the voter's first name
	 */
	public String firstName() {
		return firstName;
	}
	
	/**
	 * Getter for the voter's date of birth
	 * @return the voter's date of birth
	 */
	public String dateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Compares voters alphabetically based on their names and date of 
	 * birth, first by last name, then by first name, then by date of birth.
	 * @param comparedTo the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object 
	 * is less than, equal to, or greater than the specified object.
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Voter comparedTo) {
		// first alphabetize by last name, and then by first name
		if (!this.lastName.equals(comparedTo.lastName())) {
			return lastName.compareTo(comparedTo.lastName());
		} else if (!this.firstName.equals(comparedTo.firstName())) {
			return firstName.compareTo(comparedTo.firstName());
		}
		else if (!this.dateOfBirth.equals(comparedTo.dateOfBirth())) {
			return dateOfBirth.compareTo(comparedTo.dateOfBirth());
		} 
		return 0;
	}
	
	/**
	 * Overriden toString method for this class that returns a
	 * String representation of the voter composed of their name 
	 * and date of birth.
	 * @return a String representation of the voter
	 */
	@Override
	public String toString() {
		return firstName + " " + lastName + " " + dateOfBirth;
	}
	
	public String getKey() {
		return firstName.concat(lastName).concat(dateOfBirth);
	}
	
}
