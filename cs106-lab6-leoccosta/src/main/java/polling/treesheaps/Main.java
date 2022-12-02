package polling.treesheaps;

import java.util.Arrays;

import com.opencsv.CSVReaderHeaderAware;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Tests the ArrayHeap class and reads in the polling data to create a heap of candidates, 
 * sorted by their polling numbers
 * @author Leonardo Costa
 * @version April 15, 2020
 */
public class Main {

    public static void main(String[] args) {
    	testArrayHeap();
    	System.out.println("\n");
    	
    	// print out runtime arguments
    	System.out.println("Arguments given when running Main:");    	
    	for (int i = 0; i < args.length; i++) {
    		System.out.print(args[i] + " ");
    	}
    	System.out.println("\n");
    	
    	// read in file (only one this time) and insert contents into a heap
    	ArrayHeap<Candidate> heap = new ArrayHeap<>();
    	try {
    		for (int i = 0; i < args.length; i++) {
        		CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(args[i]));    			
        		String[] line;
    	        while ((line = reader.readNext()) != null) {    	        	
    	        	// line[0] ––> last name of the candidate
    	        	// line[1] ––> candidate’s full name
    	        	// line[2] ––> percent the candidate is polling at in this poll
    	        	Candidate c = new Candidate(line[0], line[1], line[2]);
    	        	heap.insert(c);
    	        } 
    	        reader.close();
        	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	while (!heap.isEmpty()) {
    		System.out.println(heap.removeMax());
    	}
    }
    
    /**
     * Tests the ArrayHeap class
     */
    public static void testArrayHeap() {
    	/*** Test 1 ***/
    	System.out.println("Test 1: ");
    	Integer[] intArr = {-2, 3, 9, -7, 1, 2, 6, -3};
    	ArrayHeap<Integer> heap1 = new ArrayHeap<Integer>();
    	for (int i = 0; i < intArr.length; i++) {
    		heap1.insert(intArr[i]);
    	}
    	System.out.println(heap1);
    	
    	System.out.println("\nRoot: " + heap1.removeMax());
    	System.out.println(heap1);
    	
    	System.out.println();
    	
    	/*** Test 2 ***/
    	System.out.println("Test 2: ");
    	ArrayHeap<Character> letterHeap = new ArrayHeap<Character>();
    	letterHeap.insert('A');
    	letterHeap.insert('C');
    	letterHeap.insert('G');
    	letterHeap.insert('B');
    	letterHeap.insert('D');
    	letterHeap.insert('G'); // inserting again, will still both copies
    	letterHeap.insert('F');
    	letterHeap.insert('E');
    	letterHeap.insert('H');
    	letterHeap.insert('I');
    	System.out.println("Size: " + letterHeap.size());
    	System.out.println(letterHeap + "\n");
    	
    	System.out.println("Root: " + letterHeap.removeMax());
    	System.out.println("Size: " + letterHeap.size());
    	System.out.println(letterHeap + "\n");
    	
    	/*** Test 3 ***/
    	System.out.println("Test 3: ");
    	Integer[] arr = {-2, 3, 9, -7, 1, 2, 6, -3};
//    	Integer[] arr = {5, 1, 7, 2, 3, 8, 4, 6};
    	ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(arr));
    	ArrayHeap<Integer> heap = new ArrayHeap<Integer>(array);
    	System.out.println(heap);
    	heap.sort();
    	System.out.println(array);    	
    }
}
