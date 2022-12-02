package propublica.datadesign;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;


/**
 * Class to test CriminalDefendent class
 * @author Leonardo Costa
 * @version February 19, 2020
 */
public class Main {
    public static void main( String[] args ) {
        
        
		try {
			CSVReaderHeaderAware reader;
			reader = new CSVReaderHeaderAware(new FileReader("compas-scores.csv"));
			ArrayList<String[]> myEntries = new ArrayList<String[]>(reader.readAll());
	        reader.close();
	        
	        AllDefendants defendants = new AllDefendants(myEntries);
//			System.out.println(defendants);
			
			
			PropublicaDataTable table = new PropublicaDataTable(defendants.whiteFP(), 
					defendants.blackFP(), defendants.whiteFN(), defendants.blackFN());
			
			System.out.println(table);	
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
