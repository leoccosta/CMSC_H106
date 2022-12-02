package deduplication.sqf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.opencsv.CSVReaderHeaderAware;


/**
 * A directory of registered voters. 
 * @author Leonardo Costa
 * @version May 07, 2020
 */
public class VoterDirectory {
	ArrayList<Voter> directory;
	
	/**
	 * Constructor that takes in a whole file and processes it into the directory
	 * @param fileName the name of the file
	 */
	public VoterDirectory(String fileName) {
		directory = new ArrayList<Voter>();
		try {
			CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(fileName));   
			String[] line;
	        while ((line = reader.readNext()) != null) {    	        	
	        	Voter newVoter = new Voter(line);
	        	directory.add(newVoter);
	        } 
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor that takes in a file and processes it into the directory up until the 
	 * directory has met its (user-inputted) capacity.
	 * @param fileName the name of the file
	 * @param capacity the maximum amount of entries to take in from the file
	 */
	public VoterDirectory(String fileName, int capacity) {
		directory = new ArrayList<Voter>();
		try {
			CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(fileName));   
			String[] line;
	        while ((line = reader.readNext()) != null && directory.size() < capacity) {    	        	
	        	Voter newVoter = new Voter(line);
	        	directory.add(newVoter);
	        } 
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Getter for the number of elements in the directory
	 * @return the number of elements in the directory
	 */
	public int size() {
		return directory.size();
	}
	
	/**
	 * Overriden toString method for this class that returns a
	 * String representation of the directory composed of a list
	 * of the voters in the directory.
	 * @return a String representation of the directory
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < directory.size(); i++) {
			str.append(directory.get(i).toString() + "; ");
		}
		return str.toString();
	}
	
	/* Deduplication Methods */
	
	/**
	 * Deduplicates the data in the directory by comparing each entry to 
	 * the other entries in the directory. 
	 * @return the deduplicated directory in the form of an ArrayList
	 */
	public ArrayList<Voter> allPairsDeduplication() {
		// make a duplicate of directory
		ArrayList<Voter> deduplicated = new ArrayList<Voter>();
		for (Voter i : directory) {
			deduplicated.add(i);
		} 
		
		// compare each item to each other item in the data set
		for (int i = 0; i < deduplicated.size() - 1; i++) {
			for (int j = i + 1; j < deduplicated.size(); j++) {
				Voter v1 = deduplicated.get(i);
				Voter v2 = deduplicated.get(j);
				
				// if the items are equal, remove the duplicate 
				if (v1.compareTo(v2) == 0) {
					deduplicated.remove(j);
				}
			}
		} // could make in-place by replacing deduplicated for directory
		
		return deduplicated;
	}
	
	/**
	 * Deduplicates the data in the directory using a hash table.
	 * @return the deduplicated directory in the form of an ArrayList
	 */
	public ArrayList<Voter> hashLinearDeduplication() {
		
		// create a ProbeHashMap with the capacity N = 1,000,003
		ProbeHashMap<String, Voter> hashmap = new ProbeHashMap<>(1000003);

		// insert the items into this hash table
		for (Voter voter : directory) 
			hashmap.put(voter.toString(), voter);
		
//		System.out.println(
//				"Average number of probes:"
//				+ (double) hashmap.totalProbes / directory.size()
//				+ "\nMax number of probes:" + hashmap.maxProbes
//				+ "\nLoad factor:" + (double) hashmap.n / hashmap.capacity);
		
		ArrayList<Voter> deduplicated = new ArrayList<Voter>();
		for (String key : hashmap.keySet()) {
			deduplicated.add(hashmap.get(key));
		}

		return deduplicated;
	}
	
	/**
	 * Sorts the directory using Java's Collections.sort() and deduplicates 
	 * the directory.
	 * @return the deduplicated directory in the form of an ArrayList
	 */
	public ArrayList<Voter> builtinSortDeduplication() {
		// sorts the directory (in-place)
		Collections.sort(directory);

		ArrayList<Voter> deduplicated = new ArrayList<Voter>();
		for (int i = 0; i < directory.size() - 1; i++) {
			Voter v1 = directory.get(i);		// Voter at i
			Voter v2 = directory.get(i + 1);	// Voter just after i
			if (v1.compareTo(v2) != 0) 
				deduplicated.add(v1);
		}
	
		if (directory.size() > 0) 
			deduplicated.add(directory.get(directory.size() - 1));
		
		return deduplicated;
	}
	
	/**
	 * Sorts the directory using quicksort and deduplicates the directory.
	 * @return the deduplicated directory in the form of an ArrayList
	 */
	public ArrayList<Voter> quicksortDeduplication() {
		// sorts the directory (in-place)
		if (directory.size() > 0) 
			quicksort(directory, 0, directory.size() - 1);

		ArrayList<Voter> deduplicated = new ArrayList<Voter>();
		for (int i = 0; i < directory.size() - 1; i++) {
			Voter v1 = directory.get(i);		// Voter at i
			Voter v2 = directory.get(i + 1);	// Voter after i
			if (v1.compareTo(v2) != 0) {
				deduplicated.add(v1);
			}
		}
	
		if (directory.size() > 0)
			deduplicated.add(directory.get(directory.size() - 1));
		
		return deduplicated;
	}
	
	/**
	 * Sorts the data using the quicksort algorithm.
	 * @param A the array being sorted
	 * @param low the lower bound of the subarray
	 * @param high the upper bound of the subarray
	 */
	private void quicksort(ArrayList<Voter> A, int low, int high) {
		if (low != high) {
			int p = partition(A, low, high);
			if (p > low) quicksort(A, low, p - 1);
			if (p < high) quicksort(A, p + 1, high);
		}
	}
	
	/**
	 * Puts the data in the subarray in order. Helper method for the quicksort 
	 * @param A the array being sorted
	 * @param i the lower bound of the subarray
	 * @param j the upper bound of the subarray
	 * @return
	 */
	private int partition(ArrayList<Voter> A, int i, int j) {
		boolean pivotAtI = true;	// keeps track pivot (true @i, false @j)
		while (i != j) {
			Voter v1 = A.get(i);	// Voter at i
			Voter v2 = A.get(j);	// Voter at j
			
			// if the voters are out of order, swap them
			if (v1.compareTo(v2) > 0) {
				swap(i, j);
				pivotAtI = !pivotAtI;
			}
			
			// if pivot is at the lower index (i)
			if (pivotAtI) j--; 
			
			// if pivot is at the higher index (j)
			else i++; 
		}
		return i;
	}
	
	/**
	 * Swaps the data in two positions in the directory.
	 * @param index1 the index of the first element
	 * @param index2 the index of the second element
	 */
	private void swap(int index1, int index2) {
		Voter temp = directory.get(index1);
		directory.set(index1, directory.get(index2));
		directory.set(index2, temp);
	}
}
