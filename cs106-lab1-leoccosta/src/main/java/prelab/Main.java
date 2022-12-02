package prelab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReaderHeaderAware;

public class Main {

	public static void main(String[] args) {
		
		CSVReaderHeaderAware dataReadIn;
		try {
			
			dataReadIn = new CSVReaderHeaderAware(new FileReader("StudentProfile.csv"));
			ArrayList<String[]> myEntries = new ArrayList<String[]>(dataReadIn.readAll());
			dataReadIn.close();
			
			EntireDataset students = new EntireDataset(myEntries);
			System.out.println(students);
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
