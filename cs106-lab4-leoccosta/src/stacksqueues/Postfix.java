package stacksqueues;

import java.io.StringReader;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 *  Computes arithmetic expressions in post-fix notation.
 *
 *  @author Nick Howe, Sara Mathieson, Leonardo Costa
 *  @version March 28, 2020
 */
public class Postfix {

    /** Pattern that matches on words */
    public static final String WORD = "[a-zA-Z]*\\b";

    /** Pattern that matches on arithmetic operators */
    public static final String OPERATOR = "[^\\w]";

    /** Main method to evaluate expression */
    public static void main(String[] args) {

    	// tell the user how to run the program
    	if (args.length == 0) {
    		System.err.println("Usage: java Postfix <expr>");

    	} else {
    		System.out.println("input: " + args[0]);
    		Scanner input = new Scanner(new StringReader(args[0]));

			// Below is a complicated regular expression that will split the
			// input string at various boundaries.
			input.useDelimiter("(\\s+"                  // whitespace
					+"|(?<=[a-zA-Z])(?=[^a-zA-Z])"      // word->non-word
					+"|(?<=[^a-zA-Z])(?=[a-zA-Z])"      // non-word->word
					+"|(?<=[^0-9\\056])(?=[0-9\\056])"  // non-number->number
					+"|(?<=[0-9\\056])(?=[^0-9\\056])"  // number->non-number
					+"|(?<=[^\\w])(?=[^\\w]))");        // symbol->symbol

			double finalResult = postfix(input);
			System.out.println("Result: " + finalResult);
    	}
    }

    /**
     * Parses input for numbers, words, operators, and unknown inputs and 
     * computes the result of the input as a postfix expression.
     * @param input postfix expression surrounded by ""
     * @return result of the postfix expression
     */
    public static double postfix(Scanner input) {
    	LinkedStack<Object> stack = new LinkedStack<Object>();
    	
    	while (input.hasNext()) {
			if (input.hasNextDouble()) {
				double number = input.nextDouble();
				System.out.println("Number: " + number);
				stack.push(number);
//				System.out.println(stack + "\n");
			} else if (input.hasNext(WORD)) { 
				System.out.println("Word: " + input.next(WORD));
			} else if (input.hasNext(OPERATOR)) {
				String operator = input.next(OPERATOR);
				System.out.println("Operator: " + operator);
				
				// perform operation:
				try {
//					System.out.println(stack + "\n");
					switch (operator) {
						case "+":
							double num2 = (double) stack.pop();
							double num1 = (double) stack.pop();
							stack.push(num1 + num2);
							break;
						case "-":
							num2 = (double) stack.pop();
							num1 = (double) stack.pop();
							stack.push(num1 - num2);
							break;
						case "*":
							num2 = (double) stack.pop();
							num1 = (double) stack.pop();
							stack.push(num1 * num2);
							break;
						case "/":
							num2 = (double) stack.pop();
							num1 = (double) stack.pop();
							stack.push(num1 / num2);
							break;
						case "%":
							num2 = (double) stack.pop();
							num1 = (double) stack.pop();
							stack.push(num1 % num2);
							break;
						case "^":
							num2 = (double) stack.pop();
							num1 = (double) stack.pop();
							stack.push(Math.pow(num1, num2));
							break;
						default:
							throw new IllegalArgumentException("Illegal operator.");
					}
					
				} catch (EmptyStackException e) {
					throw new IllegalArgumentException("Insufficient operands.");
				} catch (IllegalArgumentException e) {
					// skip over illegal operator
				}
				
			} else {
				System.out.println("Unknown: " + input.next());
			}
		}
    	
    	if (stack.size() != 1) {
    		throw new IllegalArgumentException("Insufficient operators."); 
    	}
    	
		return (double) stack.pop();
	}
}
