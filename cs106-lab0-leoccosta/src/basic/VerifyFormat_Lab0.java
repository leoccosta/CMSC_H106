/*
 * DO NOT MAKE CHANGES TO THIS FILE (press '+' on the line numbers to see the entire message)
 * Making changes to this file may not allow you to check your format for the autograder.
 * 
 * You should run this class before you commit/push your work to ensure your work is gradable.
 * 
 * If you are having compiling errors, check for the following:
 ***** The name of your file (the tab) and the name of your class are "Main.java" and "Main" respectively.
 ***** The name of the methods and the enum type are as instructed on the lab handout.
 ***** Your IDE does not warn you of any fatal errors before compiling.
 * 
 * Though in real life, you can name functions and variables anything,
 * please follow the instructions in the lab handout so that we can autograde your work.
 * 
 */

package basic;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
//import java.nio.charset.StandardCharsets;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class VerifyFormat_Lab0{
	
	private static String[] methodNames = new String[] {"power", "GCD", "isPrime", "round", "prerequisites"};
	
	public static void main(String[] args)
	{
		
		
		Method[] methods = Main.class.getDeclaredMethods();
		
		boolean[] methodExist = new boolean[] {false, false, false, false, false};
		
		for(int i = 0; i < methods.length; i++)
		//	System.out.println(methods[i].getName());
		{
			if(methods[i].getName().equals("power"))
			{
				methodExist[0] = true;
				checkNumParams(methods[i], 0, 2);
				checkStatic(methods[i], 0);
			}
			else if(methods[i].getName().equals("GCD"))
			{
				methodExist[1] = true;
				checkNumParams(methods[i], 1, 2);
				checkStatic(methods[i], 1);
			}
			else if(methods[i].getName().equals("isPrime"))
			{
				methodExist[2] = true;
				checkNumParams(methods[i], 2, 1);
				checkStatic(methods[i], 2);

			}
			else if(methods[i].getName().equals("round"))
			{
				methodExist[3] = true;
				checkNumParams(methods[i], 3, 1);
				checkStatic(methods[i], 3);
			}
			else if(methods[i].getName().equals("builtBefore1950"))
			{
				methodExist[4] = true;
				
				if(methods[i].getParameterCount() != 1) // check if only one input is required for the method
					checkNumParams(methods[i], 4, 1);
				else
				{
					if(!"basic.Main$FordDorms".equals(methods[i].getParameterTypes()[0].getName())) // check for presence of enum & correct parameter
					{
						System.out.println("\nPlease check and for following errors:" +
								" \n - The enum type is named according to the instructions." +
								" \n - The method's input is as specified in the instructions.");
					}
					else
					{
						//set up System.out.print capturing --> prints thru enumOutput and stores into baos
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						PrintStream printThru = new PrintStream(baos);
						PrintStream normalOut = System.out;
						System.setOut(printThru); // set the out to my enum Out
						
						// call the function with enum example given in handout
						Main.builtBefore1950(Main.FordDorms.IRA_DE_A_REID_HOUSE);
						
						// set the out back to the normal out
						System.out.flush(); // might not need because storing into a byte array? probably just a good practice
						System.setOut(normalOut);
						String myStr = "Ira de A. Reid House: 1900";
						
						if(!checkStringEquality(myStr, baos.toString()))
							System.out.println("\n**Make sure the output of the prerequisites function is formatted according to the instructions.**" +
												"\n - Call to builtBefore1950(FordDorms.IRA_DE_A_REID_HOUSE) should output:\t" + myStr +
												"\n - Your function output:\t\t\t\t\t\t\t" + baos.toString());
					}
				}
				checkStatic(methods[i], 4);
			}
		}
		
		for(int c = 0; c < methodExist.length; c++)
		{
			if(!methodExist[c]) // method does not exist
				noSuchFunction(c);
		}
	}
	
	public static void noSuchFunction(int index)
	{
		System.out.println("\n**There seems to be no method named " + methodNames[index] + " in your Main class.**"
							+ "\nMake sure the method exists and is named according to the instructions."
							+ "\nCapitalization is important! Check the lab instruction hand-out as needed.");
	}
	
	public static void checkNumParams(Method m, int nameIndex, int paramCount)
	{
		if(m.getParameterCount() != paramCount)
			System.out.println("\n**Your method " + methodNames[nameIndex] + " does not seem to have the required number of parameters.**" +
					"\nPlease make sure that the lab instructions were correctly followed!");
	}
	
	public static void checkStatic(Method m, int nI)
	{
		if(!Modifier.isStatic(m.getModifiers()))
			System.out.println("\n**Please make sure that your function " + methodNames[nI] + " has the static modifier**");
	}
	
	public static boolean checkStringEquality(String str1, String str2)
	{
		if(str1.charAt(str1.length()-1) == '\n' && str1.charAt(str1.length()-2) == '\r')
		{ // str1 is the console output
			if(str1.length() != str2.length()+2)
				return false;
			else if(str1.length() > str2.length())
			{
				for(int c = 0; c < str2.length(); c++)
					if(str1.charAt(c) != str2.charAt(c))
						return false;
			}
			else
				return false;
		}
		else if(str2.charAt(str2.length()-1) == '\n' && str2.charAt(str2.length()-2) == '\r')
		{ //str2 is the console output
			if(str1.length()+2 != str2.length())
				return false;
			else if(str2.length() > str1.length())
			{
				for(int c = 0; c < str1.length(); c++)
					if(str1.charAt(c) != str2.charAt(c))
						return false;
			}
			else
				return false;
		}
		else // neither are println statements
		{
			if (str1.length() != str2.length())
					return false;
			else
			{
				for(int c = 0; c < str1.length(); c++)
					if(str1.charAt(c) != str2.charAt(c))
						return false;
			}
		}
		return true;
	}
}