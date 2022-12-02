package babynames.linkedlist;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

/**
 * This is where you will parse the given command line arguments indicating which
 * sex, name, and files to include.
 * 
 * @author Leonardo Costa
 * @version February 29, 2020
 */
public class Main {
    public static void main(String[] args) {
    	System.out.println("Arguments given when running Main:");    	
    	for (int i = 0; i < args.length; i++) {
    		System.out.print(args[i] + " ");
    	}
    	System.out.println("\n");
    	
    	try {
    		LinkedList maleNames = new LinkedList();
    		LinkedList femaleNames = new LinkedList();
    		
    		for (int i = 2; i < args.length; i++) {
        		String year = args[i].substring(5, 9);
    			
    			CSVReader reader = new CSVReader(new FileReader(args[i]));
    	        String[] line;
    	        while ((line = reader.readNext()) != null) {
    	           maleNames.insert(year, line[1], line[0], line[2]);
    	           femaleNames.insert(year, line[3], line[0], line[4]);
    	           
    	           // [0] rank
    	           // [1] male-name // [2] male-number
    	           // [3] female-name // [4] female-number
    	           
    	        } 
    	        reader.close();
        	}

    		
    		if (args[0].equals("-f")) {
    			System.out.println(femaleNames.lookup(args[1]));
    		} else if (args[0].equals("-m")) {
    			System.out.println(maleNames.lookup(args[1]));
    		} else {
    			throw new IllegalArgumentException("Invalid flag.");
    		}
    			        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
