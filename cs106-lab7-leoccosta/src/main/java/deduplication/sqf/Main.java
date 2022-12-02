package deduplication.sqf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

/**
 * Makes a directory of and deduplicates the command-line file input.  
 * @author Leonardo Costa
 * @version May 06, 2020
 */
public class Main {
    public static void main(String[] args) {
		try {
			VoterDirectory directory = new VoterDirectory(args[0]);
			System.out.println("Records given:" + directory.size());
			CSVReader reader = new CSVReader(new FileReader(args[0])); 
			String[] line = reader.readNext();
			System.out.println("Attributes checked:" + line[3] + "," + line[4] + "," + line[7]);
	    	System.out.println("Duplicates found:" + (directory.size() - 
	    			directory.hashLinearDeduplication().size()));
	    	reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
