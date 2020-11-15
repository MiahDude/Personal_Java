/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac ReversePolish.java
 *  Execution:    java ReversePolish
 *
 *  Receives String of numbers and operator symbols in Reverse Polish Notation as input and uses a stack
 *  to compute the results
 *
 ************************************************************************************************************/

import java.util.*;

public class ReversePolish
{
	public static void main(String[] args)
	{
		Stack<Float> stack = new Stack<Float>();
		System.out.println("\nWelcome to the Reverse Polish Notation calculator!");
		System.out.println("Please enter a string of numbers and operator symbols: \n");
		Scanner kb = new Scanner(System.in);
		//In file = new In(kb.nextLine());
		try
		{
			while (kb.hasNext())
			{
				String token = kb.next();
				// use '+' as the addition symbol
				if (token.equals("+"))
					stack.push(stack.pop() + stack.pop());
				// use '-' as the subtraction symbol
				else if (token.equals("-"))
					stack.push(stack.pop() - stack.pop());
				// use '*' as the multiplication symbol
				else if (token.equals("*"))
					stack.push(stack.pop() * stack.pop());
				// use '/' as the division symbol
				else if (token.equals("/"))
					stack.push(stack.pop() / stack.pop());
				// use '%' as the modulus symbol (division operation that returns the remainder)
				else if (token.equals("%"))
					stack.push(stack.pop() % stack.pop());
				// use ',' to tell the program to remove a number from the stack
				else if (token.equals(","))
					stack.pop();
				// use '.' to tell the program to completely empty the stack
				else if (token.equals("."))
				{
					while (!stack.isEmpty())
						stack.pop();
				}
				// '#' to tell the program print the number at the top of the stack
				else if (token.equals("#"))
				{
					float top = stack.pop();
					System.out.println("\nTop of stack = " + top + "\n");
					stack.push(top);
				}
				// use '$' to tell the program to stop
				else if (token.equals("$"))
					break;
				
				else
					stack.push(Float.parseFloat(token));
			}
		}
		catch (IllegalArgumentException a)
		{
			System.out.println("\nError: Illegal Argument\nPlease input numbers and operators only\n");
		}
		catch (NoSuchElementException e) 
		{
			System.out.println("\nError: Less than 2 items in stack\nPlease put at least two numbers in the stack before using an operator\n");
		}
		System.out.println("Thanks for calculating with us!");
	}
}