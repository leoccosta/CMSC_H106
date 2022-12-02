/*
 * IMPORTANT: Press the + button in the line number to see the entire message if it's present
 * 
 * This class is for you guarantee that your output format will be acceptable for use in the autograder.
 * To ensure that you will be able to check for the correct format, please do not make changes to this class.
 * 
 * You do not have to understand this code.
 * 
 * Running this class will produce an output in the console with relevant messages for you to check your output.
 * Good luck!
 */

package babynames.linkedlist;

import java.io.*;
import java.util.Arrays;

public class VerifyFormat_Lab3 {
	
	public static void main(String[] args)
	{
		String[] mainInput = new String[] {"-f", "Mary", // not a call from shell, must be hard-coded instead of using the wildcard *
				"names1990.csv", "names1991.csv", "names1992.csv", "names1993.csv", "names1994.csv", "names1995.csv", "names1996.csv", "names1997.csv", "names1998.csv", "names1999.csv", "names2000.csv", "names2001.csv", "names2002.csv", "names2003.csv", "names2004.csv", "names2005.csv", "names2006.csv", "names2007.csv", "names2008.csv", "names2009.csv", "names2010.csv", "names2011.csv", "names2012.csv", "names2013.csv", "names2014.csv", "names2015.csv", "names2016.csv", "names2017.csv"};
		
		String correctOutput = "Position of Mary in the Linked List: 1423\n" + 
				"\n" + 
				"1990\n" + 
				"Mary: 35, 8666, 0.005432\n" + 
				"\n" + 
				"1991\n" + 
				"Mary: 38, 8760, 0.005596\n" + 
				"\n" + 
				"1992\n" + 
				"Mary: 36, 8458, 0.005530\n" + 
				"\n" + 
				"1993\n" + 
				"Mary: 37, 8119, 0.005435\n" + 
				"\n" + 
				"1994\n" + 
				"Mary: 37, 7751, 0.005274\n" + 
				"\n" + 
				"1995\n" + 
				"Mary: 40, 7452, 0.005158\n" + 
				"\n" + 
				"1996\n" + 
				"Mary: 44, 6956, 0.004857\n" + 
				"\n" + 
				"1997\n" + 
				"Mary: 46, 6636, 0.004700\n" + 
				"\n" + 
				"1998\n" + 
				"Mary: 45, 6443, 0.004528\n" + 
				"\n" + 
				"1999\n" + 
				"Mary: 45, 6372, 0.004493\n" + 
				"\n" + 
				"2000\n" + 
				"Mary: 46, 6192, 0.004310\n" + 
				"\n" + 
				"2001\n" + 
				"Mary: 49, 5729, 0.004060\n" + 
				"\n" + 
				"2002\n" + 
				"Mary: 51, 5460, 0.003896\n" + 
				"\n" + 
				"2003\n" + 
				"Mary: 59, 5016, 0.003545\n" + 
				"\n" + 
				"2004\n" + 
				"Mary: 62, 4809, 0.003416\n" + 
				"\n" + 
				"2005\n" + 
				"Mary: 72, 4454, 0.003164\n" + 
				"\n" + 
				"2006\n" + 
				"Mary: 80, 4090, 0.002859\n" + 
				"\n" + 
				"2007\n" + 
				"Mary: 93, 3679, 0.002568\n" + 
				"\n" + 
				"2008\n" + 
				"Mary: 96, 3497, 0.002499\n" + 
				"\n" + 
				"2009\n" + 
				"Mary: 102, 3160, 0.002337\n" + 
				"\n" + 
				"2010\n" + 
				"Mary: 109, 2866, 0.002193\n" + 
				"\n" + 
				"2011\n" + 
				"Mary: 112, 2706, 0.002091\n" + 
				"\n" + 
				"2012\n" + 
				"Mary: 121, 2574, 0.001990\n" + 
				"\n" + 
				"2013\n" + 
				"Mary: 120, 2646, 0.002043\n" + 
				"\n" + 
				"2014\n" + 
				"Mary: 120, 2630, 0.001986\n" + 
				"\n" + 
				"2015\n" + 
				"Mary: 123, 2624, 0.001987\n" + 
				"\n" + 
				"2016\n" + 
				"Mary: 127, 2504, 0.001913\n" + 
				"\n" + 
				"2017\n" + 
				"Mary: 126, 2381, 0.001877\n" + 
				"\n" + 
				"Total\n" + 
				"Mary: 51, 142630, 0.003630";
		
		boolean exceptionThrown = false;
		
	// set up acquiring output
		ByteArrayOutputStream babyStats = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		PrintStream babyStatsPrinter = new PrintStream(babyStats);
		System.setOut(babyStatsPrinter);
		
	// do the baby stats printing here from the student's main method	 
		try {Main.main(mainInput);} // probably need a try catch block with this statement
		catch (Exception e)
		{
			System.out.print(e); // store the exception instead of output to show later
			exceptionThrown = true;
		}
		
	// set the PrintStream back to normal
		System.out.flush();
		System.setOut(originalOut);
		
		String studentOutput = babyStats.toString();
		String cleanOutput = "We were unable to get your output for some reason."; // default message, used for printing out student's output at the end for them
		
		//get rid of \r\n at the end
		while(studentOutput.length() > 0 && (studentOutput.charAt(studentOutput.length()-1) == '\n' || studentOutput.charAt(studentOutput.length()-1) == '\r'))
		{
//				System.out.println("hehe");
			String newString = "";
			for(int i = 0; i < studentOutput.length()-1; i++)
				newString = newString + studentOutput.charAt(i);
			studentOutput = newString;
		}		
		
	// start of format checker messages
		System.out.println(	"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
                			"┃                    Format Checker Messages                    ┃\n" + 
                			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n" +
                			"Your output is printed after the messages for your reference.\n" +
                			"This class does not check for correctness; it only checks for format of your output for the autograder.\n" +
                			"The autograder and format checker will ignore the messge starting with \"Arguments given while running main\"\n");
		
		if(exceptionThrown)
		{
			System.out.println("Your main method threw this exception: " + studentOutput);
			cleanOutput = "Exception was thrown. Please check the message above.";
		}
		else // exception was not thrown
		{
			try {	
				cleanOutput = studentOutput;
				
				if(studentOutput.contains(correctOutput))
					System.out.println("Your program output seems to be in the correct format!");
				else
				{
					//check for presence of "Position of Mary in Linked List: "
					System.out.println("Checking for presence of \"Position of Mary in the Linked List: \"");
					int positionOfMary = studentOutput.indexOf("Position of Mary in the Linked List: ");
					if(positionOfMary == -1) // "Position of Mary: " did not exist
						System.out.println("\t\"Position of Mary in the Linked List: \"   was not found\n\tPlease make sure it is printed in the correct format and run the checker again.");
					
					else
					{
						System.out.println("\t\"Position of Mary in Linked List: \" was found in correct format!\n");
						
						// ignore all characters preceding "Position of Mary..."
						studentOutput = studentOutput.substring(positionOfMary);
						
						// split output based on \n to count the number of lines
						String[] outputArray = studentOutput.split("\n");
						
						//check the number of lines
			//			System.out.println("length is: " + outputArray.length);
						if(outputArray.length > 88)
							System.out.println("It seems that your output printed more lines that it should have.\nEnsure that number of linebreaks is correct for your output.\n");
						else if(outputArray.length < 88)
							System.out.println("It seems that your output printed fewer lines that it should have.\nEnsure that number of linebreaks is correct for your output.\n");
						
						int lineNumber; 
						int numLineBreaks = countSpaces(Arrays.copyOfRange(outputArray, 1, outputArray.length));
						if(numLineBreaks != 1)
							System.out.println("There should be one line break after \"" + outputArray[0] + "\" but your function has " + numLineBreaks);
						
						lineNumber = 1 + numLineBreaks;
						int year = 1990; //start at 1990
						boolean endReached = false;
						
						while(lineNumber < outputArray.length)
						{
							if(year < 2018)
							{
								System.out.println("Looking for year: " + year);
								if(outputArray[lineNumber].length() < 4 || !outputArray[lineNumber].equals(""+year))
								{
									System.out.println("\tERROR:\tYear \"" + year + "\" should have been printed here but your output printed \"" + outputArray[lineNumber] + "\" here");
									System.out.println("\t\tPlease fix this output format and try running the program again.");
									break;
								}
								else
								{
									System.out.println("\t" + year + " was found!\n");
									lineNumber++;
									if(outputArray[lineNumber].length() > 23 && outputArray[lineNumber].length() < 26)
										System.out.println("\tThe length for the statistics for the year " + year + " seems to be reasonable");
									else
									{
										System.out.println("\tERROR:\tThe statistics length should correspond to that of the lab handout");
										if(outputArray[lineNumber].length() < 24)
											System.out.println("\t\tThe statistics for the year " + year + " seems to be too short.\n\t\tThe stats printed were " + outputArray[lineNumber] + "\n\t\tPerhaps you're missing spaces or decimal format is incorrect.\n\t\tPlease correct the output format and try again");
										else if(outputArray[lineNumber].length() > 25)
											System.out.println("\t\tThe statistics for the year " + year + " seems to be too long.\n\t\tThe stats printed were "+ outputArray[lineNumber] + "\n\t\tPerhaps your decimal format is incorrect or another error is present.\n\t\tPlease correct the output format and try again.");
									}
								}
								year++;
								
								
								if(lineNumber < outputArray.length-1)
								{
									numLineBreaks = countSpaces(Arrays.copyOfRange(outputArray, lineNumber+1, outputArray.length));
									if(numLineBreaks == 1)
										lineNumber += 2;
									else if (numLineBreaks < 1)
									{
										System.out.println("\nInstead of finding a linebreak after the stats, we found " + outputArray[lineNumber+1] + "\n\tPlease fix this output format and try running again.");
										break;
									}
									else if (numLineBreaks > 1)
									{
										System.out.println("\nThere were more than one linebreak after \"" + outputArray[lineNumber] + "\"\nPlease correct the number of line breaks.");
										lineNumber = lineNumber + 1 + numLineBreaks;
									}
								}
								System.out.println();
							}
							else
							{
								System.out.println("Looking for \"Total\"");
								if(outputArray[lineNumber].length() < 5 || !outputArray[lineNumber].equals("Total"))
								{
									System.out.println("\tERROR: \"Total\" was not found. Instead, we found " + outputArray[lineNumber] + "\n\tPlease correct this error and run the output format again.");
									lineNumber++;
									break;
								}
								else
								{
									System.out.println("\t\"Total\" was found!");
									lineNumber++;
									if(outputArray[lineNumber].length() == 26)
										System.out.println("\tThe length for the statistics of the total seems to be reasonable");
									else
									{
										System.out.println("\tERROR: The statistics length should correspond to that of the lab handout");
										if(outputArray[lineNumber].length() < 26)
											System.out.println("\t\tThe statistics for the total seems to be too short.");
										else if(outputArray[lineNumber].length() > 26)
											System.out.println("\t\tThe statistics for the total seems to be too long.");
										System.out.println("\t\tThe stats printed were " + outputArray[lineNumber] + "\n\t\tPlease correct this format and try again.");
										break;
									}
										
								}
								endReached = true;
								lineNumber++;
							}
						}
						
						if(!endReached)
							System.out.println("\nThe program terminated without printing all the necessary information.\nPlease make sure errors are fixed so that the program will print everything.");
					}
				}
			}
			catch(Exception e) {System.out.println("Format checker broke with the following error:\n" + e);}
		}
		// show the student's output
		System.out.println( "\n\n" +
							"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
							"┃                  The output of your function                  ┃\n" +
		                  	"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println(cleanOutput);
		System.out.println( "\n\n" +
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
				"┃         Scroll to the top for format checker messages         ┃\n" +
              	"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	/*
	 * Counts the number of empty lines (each element in the string is a line; empty line = empty string).
	 * @param subarray of the output array whose first element would ideally be the empty string; if not empty string, returns 0.
	 * @return integer corresponding to the number of empty lines after the printout.
	 */
	public static int countSpaces(String[] subArr)
	{
		if(subArr.length == 0)
			return -1;
		else
		{
			int numberOfSpaces = 0;
			for(int c = 0; c < subArr.length; c++)
			{
				if(subArr[c].equals(""))
					numberOfSpaces++;
				else
					break;
			}
			return numberOfSpaces;
		}
	}
}
