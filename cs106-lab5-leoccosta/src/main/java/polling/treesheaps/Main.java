package polling.treesheaps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReaderHeaderAware;

/**
 * Tests LinkedBinaryTree class and reads in the polling data to create a 
 * tree of candidates.
 * @author Leonardo Costa
 * @version April 01, 2020
 */
public class Main {
    public static void main(String[] args) {

    	testLinkedBinaryTree();
    	
    	// print out runtime arguments
    	System.out.println("Arguments given when running Main:");    	
    	for (int i = 0; i < args.length; i++) {
    		System.out.print(args[i] + " ");
    	}
    	System.out.println("\n");
    	
    	try {
    		
    		BinaryTree<Candidate> pollingData = new LinkedBinaryTree<Candidate>();
    		for (int i = 0; i < args.length; i++) {
        		CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader(args[i]));    			
        		String[] line;
    	        while ((line = reader.readNext()) != null) {    	        	
    	        	Candidate c = new Candidate(line[0], line[1], line[2]);
    	        	// line[0] ––> last name of the candidate
    	        	// line[1] ––> candidate’s full name
    	        	// line[2] ––> percent the candidate is polling at in this poll
    	        	
    	        	pollingData.insert(c);
    	        } 
    	        reader.close();
    	        System.out.println("\nAfter insertion of " + args[i] + ": \n" + pollingData.toString());
        	}
    		System.out.println("\nFinal size: " + pollingData.size());
    		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Tests the methods in the LinkedBinaryTree class.
     */
    public static void testLinkedBinaryTree() {
    	System.out.println("TESTING LinkedBinaryTree:\n");
    	
    	BinaryTree<Character> letterTree = new LinkedBinaryTree<Character>();
    	System.out.println(letterTree.isEmpty());
    	letterTree.insert('A');
    	letterTree.insert('C');
    	letterTree.insert('G');
    	letterTree.insert('B');
    	letterTree.insert('D');
    	letterTree.insert('G'); // inserting again, should replace
    	letterTree.insert('F');
    	letterTree.insert('E');
    	letterTree.insert('H');
    	letterTree.insert('I');
    	System.out.println(letterTree.isEmpty());
    	System.out.println(letterTree);
    	System.out.println("\nSize: " + letterTree.size());
    	System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    			+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    	
    	BinaryTree<Candidate> pollingData = new LinkedBinaryTree<Candidate>();
    	Candidate c = new Candidate("Warren", "Elizabeth Warren", "17.4");
    	pollingData.insert(c);
    	c = new Candidate("Sanders", "Bernie Sanders", "16.4");
    	pollingData.insert(c);
    	c = new Candidate("Sanders", "Bernie Sanders", "17.4");
    	pollingData.insert(c);
    	System.out.println(pollingData);
    	System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
    			+ "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}
