package basic;

/**
 * @author Leonardo Costa
 * @version January 28, 2020
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to CS 106!  Enjoy Lab 0, Leo!");
		
		System.out.println("Exponent test: " + power(2.2, 3));
		System.out.println("GCD test: " + GCD(36, 60));
		System.out.println("Prime test: " + isPrime(15));
		System.out.println("Rounding test: " + round(15.5));
		builtBefore1950(FordDorms.YARNALL_HOUSE);
	}
	
	/**
	 * Method takes a double and raises it to the power of inputed int.
	 * 
	 * @param x double base
	 * @param exp integer exponent
	 * @return x raised to the power of exp
	 */
	public static double power(double x, int exp) {
		double result = x;
		
		for (int i = 1; i < exp; i++) 
			result *= x;
		
		return result;
	}
	
	/**
	 * Takes two integers and returns their greatest common denominator.
	 * 
	 * @param larger first integer input
	 * @param smaller second integer input
	 * @return greatest common denominator of larger and smaller
	 */
	public static int GCD(int larger, int smaller) {
		
		// make it so larger > smaller
		if (smaller > larger) {
			int temp = larger;
			larger = smaller;
			smaller = temp;
		}
		
		while (smaller != 0) {
			larger = larger % smaller;
			if (smaller > larger) {
				int temp = larger;
				larger = smaller;
				smaller = temp;
			}
		}
		
		return larger;
	}
	
	/**
	 * Takes an integer and determines whether it is prime.
	 * 
	 * @param num integer input
	 * @return true if num is prime, false otherwise
	 */
	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) 
				return false;
		}
		return true;
	}
	
	/**
	 * Takes a double floating point number and returns the number rounded to the nearest integer.
	 * 
	 * @param num double input
	 * @return the nearest integer to num
	 */
	public static int round(double num) {
		int autoRound = (int)num;
		if (num - autoRound >= 0.5) {
			return autoRound + 1;
		}
		return autoRound;
	}
	
	public enum FordDorms {
		BARCLAY_HALL, CADBURY_HOUSE, COMFORT_HALL, HENRY_S_DRINKER_HOUSE,
		GUMMERE_HALL, JONES_HALL, KIM_AND_TRITTON_HALLS, HAVERFORD_COLLEGE_APARTMENTS,
		LA_CASA_HISPANICA, LEEDS_HALL, LLOYD_HALL, LUNT_HALL, IRA_DE_A_REID_HOUSE, YARNALL_HOUSE
	};
	
	/**
	 * Prints out the inputed dorm's name and the year it was built if built before 1950.
	 * 
	 * @param dorm FordDorms enum input
	 */
	public static void builtBefore1950(FordDorms dorm) {
		switch(dorm) {
			case IRA_DE_A_REID_HOUSE:
				System.out.println("Ira de A. Reid House: 1900");
				break;
			case YARNALL_HOUSE: 
				System.out.println("Yarnall House: 1900");
				break;
			case LLOYD_HALL: 
				System.out.println("Lloyd Hall: 1920");
				break;
			case LA_CASA_HISPANICA:
				System.out.println("La Casa Hispanica: 1911");
				break;
			case HAVERFORD_COLLEGE_APARTMENTS:
				System.out.println("Haverford College Apartments: 1949");
				break;
			default: 
		}
	}
}
