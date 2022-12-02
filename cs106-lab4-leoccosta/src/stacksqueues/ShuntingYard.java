package stacksqueues;

import java.io.StringReader;
import java.util.Scanner;

/**
 *  Implements the shunting yard algorithm.
 *  See http://en.wikipedia.org/wiki/Shunting-yard_algorithm
 *  @author Nick Howe, Sara Mathieson, Leonardo Costa
 *  @version March 29, 2020
 */
public class ShuntingYard {
	
	/** Pattern that matches on words */
    public static final String WORD = "[a-zA-Z]*\\b";

    /** Pattern that matches on arithmetic operators */
    public static final String OPERATOR = "[^\\w]";

    /** Main method to evaluate expression */
    public static void main(String[] args) {

    	// tell the user how to run the program
    	if (args.length == 0) {
    		System.err.println("Usage: java ShuntingYard <expr>");

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

			String finalResult = shuntingYard(input);
			System.out.println("Result: " + finalResult);
			
			Scanner in = new Scanner(new StringReader(finalResult));
			double pf = Postfix.postfix(in);
			System.out.println("After Postfix Calculation: " + pf);
    	}
    }	
	
	/**
	 * Implements the shunting yard algorithm.
	 * @param input an expression in infix notation
	 * @return the input in postfix notation, surrounded by ""
	 */
	public static String shuntingYard(Scanner input) {
		
		ArrayDeque<Object> output = new ArrayDeque<Object>();
		LinkedStack<Object> operators = new LinkedStack<Object>();
		
		while (input.hasNext()) {
			if (input.hasNextDouble()) {
				double number = input.nextDouble();
				System.out.println("Number: " + number);
				
				output.addLast(number);
				
				System.out.println("Output Queue: " + output.toString());
				System.out.println("Operators Stack: " + operators.toString());
				System.out.println();
				
			} else if (input.hasNext(WORD)) { 
				System.out.println("Word: " + input.next(WORD));
			} else if (input.hasNext(OPERATOR)) {
				String operator = input.next(OPERATOR);
				System.out.println("Operator: " + operator);
				
				if (operator.equals("(")) {
					operators.push(operator);
					System.out.println("Output Queue: " + output.toString());
					System.out.println("Operators Stack: " + operators.toString());
					System.out.println();
				}
				
				else if (operator.equals(")")) {
					// while the operator at the top of the operator stack is not a left paren:
					while(!operators.peek().equals("(") && !operators.isEmpty()) {
						// pop the operator from the operator stack onto the output queue
						output.addLast(operators.pop());
						System.out.println("Output Queue: " + output.toString());
						System.out.println("Operators Stack: " + operators.toString());
					}
					if (operators.isEmpty()) {
						throw new IllegalArgumentException("Mismatched parenthesis");
					}
					else if (operators.peek().equals("(")) {
						operators.pop();
					}
				}
				
				else {
					
					if (getPrecedence(operator) == -1) {
						throw new IllegalArgumentException("Invalid operator");
					}
					
					while((!operators.isEmpty()) &&
							((getPrecedence(operators.peek().toString()) > getPrecedence(operator)) ||
							(getPrecedence(operators.peek().toString()) == getPrecedence(operator) && !operator.equals("^"))
							&& (!operator.equals("(")))) {
						// pop operators from the operator stack onto the output queue
						output.addLast(operators.pop());
					}
					
					operators.push(operator);
					
					System.out.println("Output Queue: " + output.toString());
					System.out.println("Operators Stack: " + operators.toString());
					System.out.println();
				}

			} else {
				System.out.println("Unknown: " + input.next());
			}
		}
		
		while (!operators.isEmpty()) {
			output.addLast(operators.pop());
		}
		
		return output.toStringNoCommas();
	}
	
	/**
	 * Calculates the precedence of the inputted operator.
	 * @param operator the operator to get the precedence of
	 * @return the precedence of the inputted operator; -1 if the 
	 * input is not +, -, *, /, or ^
	 */
	public static int getPrecedence(String operator) {
		switch (operator) {
			case "+":
				return 2;
			case "-":
				return 2;
			case "*":
				return 3;
			case "/":
				return 3;
			case "^":
				return 4;
			default:
				return -1;
		}
	}
}
