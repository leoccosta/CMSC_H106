package deduplication.sqf;

import java.util.ArrayList;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;

/**
 * Class containing methods that help with the analysis of the runtime 
 * of different algorithms relevant to the lab. 
 * @author Leonardo Costa
 * @version May 07, 2020
 */
public class Util {
	public static void main(String args[]) {
//		prelab();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Util.plot(args[0]);
//    	part3_1(args[0]);
	}
	
	/**
	 * Part 3.1: Complexity Analysis – Comparing Algorithms
	 */
	public static void part3_1(String fileName) {
		VoterDirectory directory = new VoterDirectory(fileName);
		
		/** All Pairs **/
		double start = Util.startTimer();
		directory.allPairsDeduplication();
    	double end = Util.endTimer();
    	System.out.println("all pairs runtime: "
    			+ Util.secondsElapsed(start, end));
    	
    	/** Hash Table **/
    	start = Util.startTimer();
		directory.hashLinearDeduplication();
    	end = Util.endTimer();
    	System.out.println("hash table runtime: "
    			+ Util.secondsElapsed(start, end));
    	
    	/** Quicksort **/
    	start = Util.startTimer();
		directory.quicksortDeduplication();
    	end = Util.endTimer();
    	System.out.println("quicksort runtime: "
    			+ Util.secondsElapsed(start, end));
    	
    	/** Built-in Sort **/
    	directory = new VoterDirectory(fileName);
    	start = Util.startTimer();
    	directory.builtinSortDeduplication();
		end = Util.endTimer();
    	System.out.println("build-in sort runtime: "
    			+ Util.secondsElapsed(start, end));
	}
	
	/**
	 * Plots the runtimes for the four deduplication algorithms for 
	 * different sizes data against each other. 
	 * @param fileName the name of the file containing the data.
	 */
	public static void plot(String fileName) {		
		ArrayList<Double> runtimes = new ArrayList<Double>();
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<String> categories = new ArrayList<String>();
		
		VoterDirectory directory = new VoterDirectory(fileName);
		
		/** All Pairs Runtimes **/
		double allpairsStart = Util.startTimer();
		for (int i = 0; i < directory.size() && i <= 100000; i += 500) {
			VoterDirectory subDirectory = new VoterDirectory(fileName, i);
			double start = Util.startTimer();
			subDirectory.allPairsDeduplication();
	    	double end = Util.endTimer();
	    	double runtime = Util.secondsElapsed(start, end);
	    	runtimes.add(runtime);
	    	categories.add("all pairs");
	    	rows.add(i);
	    	System.out.println(i);
		} 
		System.out.println("runtime for getting all pairs: "
				+ Util.secondsElapsed(allpairsStart, Util.endTimer())); 
		// i <= 25000 (i += 500) should take ~4-5m (monitor off)
		// i <= 100000 (i += 500) (monitor off) took 18252.51s ––> 5h 4.21m
		
		/** Hash Table Runtimes **/
		double hashStart = Util.startTimer();		
		for (int i = 0; i < directory.size(); i += 500) {
			VoterDirectory subDirectory = new VoterDirectory(fileName, i);
			double start = Util.startTimer();
			subDirectory.hashLinearDeduplication();
	    	double end = Util.endTimer();
	    	double runtime = Util.secondsElapsed(start, end);
	    	runtimes.add(runtime);
	    	categories.add("hash table");
	    	rows.add(i);
		}	
		System.out.println("runtime for getting hash table: "
				+ Util.secondsElapsed(hashStart, Util.endTimer()));
		// i < 100000 (i += 500) (monitor off) took 81.002s (~1.35m)
		
		/** Quicksort Runtimes **/
		double quicksortStart = Util.startTimer();
		for (int i = 0; i < directory.size(); i += 500) {
			VoterDirectory subDirectory = new VoterDirectory(fileName, i);
			double start = Util.startTimer();
			subDirectory.quicksortDeduplication();
	    	double end = Util.endTimer();
	    	double runtime = Util.secondsElapsed(start, end);
	    	runtimes.add(runtime);
	    	categories.add("quicksort");
	    	rows.add(i);
		}
		System.out.println("runtime for getting quicksort: "
				+ Util.secondsElapsed(quicksortStart, Util.endTimer())); 
		// i < 100000 (i += 500) (monitor off) took 81.323s (~1.36m)
		
		/** Built-in Sort Runtimes **/
		double builtinStart = Util.startTimer();
		for (int i = 0; i < directory.size(); i += 500) {
			VoterDirectory subDirectory = new VoterDirectory(fileName, i);
			double start = Util.startTimer();
			subDirectory.builtinSortDeduplication();
	    	double end = Util.endTimer();
	    	double runtime = Util.secondsElapsed(start, end);
	    	runtimes.add(runtime);
	    	categories.add("build-in sort");
	    	rows.add(i);
		}
		System.out.println("runtime for getting build-in sort: "
				+ Util.secondsElapsed(builtinStart, Util.endTimer())); 
		// i < 100000 (i += 500) (monitor off) took 88.451s (~1.47m)
		
		/** Plot Runtimes **/		
		DoubleColumn column1 = DoubleColumn.create("rows deduplicated", rows);
		DoubleColumn column2 = DoubleColumn.create("runtime (seconds)", runtimes);
		StringColumn catcolumn = StringColumn.create("algorithm", categories);
		
		Table table = Table.create();
		table.addColumns(column1, column2, catcolumn);
		Plot.show(LinePlot.create("runtimes (project)", table, "rows deduplicated",
				"runtime (seconds)", "algorithm"));
	}
		
	/**
	 * Code that was in main for my pre-lab.
	 */
	public static void prelab() {
		final int SIZE = 20;
		
		double start = startTimer();
		int result = fib(45);
		System.out.println(result);
		
		double end = endTimer();
		double timeSec = secondsElapsed(start, end);
		System.out.println(timeSec);
		
		double[] xvals = new double[SIZE];
		double[] yvals = new double[SIZE];
		
		for (int i = 0; i < xvals.length; i++) {
			xvals[i] = i;
			yvals[i] = fib(i);
		}

		DoubleColumn column1 = DoubleColumn.create("n", xvals);
		DoubleColumn column2 = DoubleColumn.create("nth fibonacci number", yvals);

		Table table = Table.create("for plot");
		table.addColumns(column1, column2);
		Plot.show(LinePlot.create("fibonacci", table, "n", "nth fibonacci number"));
	}
	
	/**
	 * Returns the current time in milliseconds.
	 * @return the difference, measured in milliseconds, between the current time 
	 * and midnight, January 1, 1970 UTC
	 */
	public static double startTimer() {
		return System.currentTimeMillis();
	}
	
	/**
	 * Returns the current time in milliseconds.
	 * @return the difference, measured in milliseconds, between the current time 
	 * and midnight, January 1, 1970 UTC
	 */
	public static double endTimer() {
		return System.currentTimeMillis();
	}
	
	/**
	 * Returns the time elapsed between the two inputted times.
	 * @param start start time
	 * @param end end time
	 * @return the difference between the two times / 1000 (such that if the input 
	 * was in milliseconds, the output is in seconds)
	 */
	public static double secondsElapsed(double start, double end) {
		return (end - start) / 1000;
	}
	
	/**
	 * Computes and returns the nth number in the Fibonacci sequence. 
	 * @param n the index of the number on the Fibonacci sequence to be returned
	 * @return the nth number in the Fibonacci sequence
	 */
	public static int fib(int n) {
		int result = 0;
		if (n == 0) 
			return 0;
		else if (n == 1 || n == 2) 
			return 1;
		result = fib(n-1) + fib(n-2);
		return result;
	}
}
