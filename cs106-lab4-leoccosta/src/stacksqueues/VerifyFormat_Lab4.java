/*
 * * DO NOT MAKE CHANGES TO THIS FILE (press '+' on the line number to see the entire message)
 * Making changes to this file may not properly allow you to check your format for the autograder.
 * 
 * This class checks if your format is as specified in the lab instructions.
 * You should run this class before you commit/push your work to ensure your work is gradable.
 * 
 */

package stacksqueues;

import java.util.EmptyStackException;

public class VerifyFormat_Lab4 {

	public static void main(String[] args) {
		
		System.out.println("=====================\nChecking LinkedStack \n=====================\n");
		try
		{
			Stack<Integer> stackTest = new LinkedStack<Integer>();
			stackTest.push(5);
			stackTest.push(2);
			stackTest.push(3);
			checkOutputFormat(stackTest.toString(), "(5, 2, 3)");
			System.out.println("\n***************End of First Check***************\n");
			stackTest.pop();
			stackTest.pop();
			stackTest.push(0);
			stackTest.push(9);
			stackTest.push(-6);
			stackTest.push(14);
			checkOutputFormat(stackTest.toString(), "(5, 0, 9, -6, 14)");
			System.out.println("\n***************End of Second Check***************\n");
		}
		catch(FullStackException e) {System.out.println("FullStackException was thrown... It should not have been thrown!");}
		catch(EmptyStackException a) {System.out.println("EmptyStackException was thrown... It should not have been thrown!");}
		catch(Exception m) {System.out.println("An exception was thrown: " + m);}
		
		try
		{
			System.out.println("\n==============\nChecking Deque\n==============\n");
			Deque<String> dequeStr = new ArrayDeque<String>(9);
			dequeStr.addFirst("the");
			dequeStr.addFirst("quick");
			dequeStr.addLast("brown");
			dequeStr.addLast("fox");
			dequeStr.addFirst("jumps");
			checkOutputFormat(dequeStr.toString(), "(jumps, quick, the, brown, fox)");
			System.out.println("\n***************End of Third Check***************\n");
			dequeStr.addLast("over");
			dequeStr.addLast("the");
			dequeStr.addFirst("lazy");
			dequeStr.addLast("dog");
			checkOutputFormat(dequeStr.toString(), "(lazy, jumps, quick, the, brown, fox, over, the, dog)");
			System.out.println("\n***************End of Fourth Check***************\n");
		}
		catch(FullQueueException e) {System.out.println("FullQueueException was thrown... It should not have been thrown!");}
		catch(EmptyQueueException a) {System.out.println("EmptyQueueException was thrown... It should not have been thrown!");}
		catch(Exception m) {System.out.println("An exception was thrown: " + m.toString());}
	}
	
	public static void checkOutputFormat(String studentStr, String correctAns)
	{
		System.out.println("The output should be printed as \"" + correctAns + "\"\nYour stack printed: \t\t\"" + studentStr + "\"\n");
		
		if(studentStr.equals(correctAns))
			System.out.println("Your output format seems correct!");
		// check for commas and spaces
		else if(studentStr.indexOf(',')==-1)
			System.out.println("Your output seems to be missing commas.\nPlease fix this error and try again.");
		else if(studentStr.indexOf(' ')==-1)
			System.out.println("Your output seems to be missing spaces.\nPlease fix this error and try again.");
		else if(studentStr.indexOf(", ")==-1)
			System.out.println("Your output seems to be missing spaces right after commas.\nPlease fix this error and try again.");
		// check for parenthesis
		else if(studentStr.indexOf('(')==-1)
			System.out.println("Your output seems to be missing the left parenthesis: \"(\".\nPlease fix this error and try again.");
		else if(studentStr.indexOf(')')==-1)
			System.out.println("Your output seems to be missing the right parenthesis: \")\".\nPlease fix this error and try again.");
		else if(studentStr.indexOf(",)")!=-1 || studentStr.indexOf(", )")!=-1)
			System.out.println("There should not be a comma or a space right before closing the parenthesis!\nPlease fix this error and try again.");
		// all the grammatical structures in place... check the grammar
		else
		{
			// check for character length of the string?
			
			// check the parts of the string
			String[] parts = studentStr.split(", ");
			String[] correctParts = correctAns.split(", ");
			if(parts.length != correctParts.length) // this checks for correctness... although we already say if it was printed as it should be or not.
			{
				if(parts.length > correctParts.length)
					System.out.println("There seems to be more commas than there should be in your output.\nPlease fix this error and try again.");
				else if(parts.length < correctParts.length)
					System.out.println("There seems to be less commas than there should be in your output.\nPlease fix this error and try again.");
			}
			else
			{
				for(int index = 0; index < parts.length; index++)
				{
					if(!parts[index].equals(correctParts[index]))
						System.out.println("Your " + index + "th element seems to be.\n\tInstead of: " + correctParts[index]+  ",\n\twe found: " + parts[index] + "\nPlease fix this error and try again.");
				}
			}
		}
	}

}
