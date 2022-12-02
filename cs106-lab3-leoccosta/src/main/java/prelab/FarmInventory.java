package prelab;

import java.util.ArrayList;

public class FarmInventory {
	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<String>();
		ArrayList<String> veggies = new ArrayList<String>();
		double totalAssets = 0;
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-f")) {
				fruits.add(args[i + 1]);
			} else if (args[i].equals("-v")) {
				veggies.add(args[i + 1]);
			} else if (args[i].equals("-a")) {
				totalAssets += Double.parseDouble(args[i + 1]);
			}
			
		}
		
		String s = "hi";
		s.compareTo("h");
		
		System.out.println("The set of fruits are: " + fruits);
		System.out.println("The set of veggies are: " + veggies);	
		System.out.println("The total asset is " + totalAssets);	
	}
}
