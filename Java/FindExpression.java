/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac FindExpression.java
 *  Execution:    java FindExpression
 *
 *  Determines whether a set of Strings in an input text file are valid expressions according to 
 *  a predefined grammar. The following are examples of valid expressions in this grammar: A, a, (a+b), (A*(d+c))
 *
 ************************************************************************************************************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FindExpression
{	
	// determine whether a string is an <Expr>
	public static boolean isExpr(String s)
	{
		try // may get out of bound errors
		{
			// if the first character is '(', look for an <Expr>
			if (s.charAt(0) == '(')
			{
				s = s.substring(1); // move up the string
				// if there is '()', then it is not an <Expr>
				if (s.charAt(0) == ')') return false;
				while (s.length() > 0) // loop through a parenthesized <Expr>
				{
					// if the next character is an <Id>, continue
					if (isId(s.charAt(0)))
					{
						s = s.substring(1); // move up the string
						// if the next character is an <Op>, continue
						if (isOp(s.charAt(0)))
						{	
							s = s.substring(1); // move up the string
							// if the next character is an <Id>, continue
							if (isId(s.charAt(0)))
							{
								s = s.substring(1); // move up the string
								// if the next character is ')', continue
								if (s.charAt(0) == ')') 
								{
									// if this is the last character, then it is an <Expr>
									if (s.length() == 1) return true;
									else continue; // otherwise, iterate loop again
								}
								// otherwise, it is not an <Expr>
								else return false;
							}
							// otherwise, look for an <Expr>
							else return isExpr(s);
						}
						// otherwise, it is not an <Expr>
						else return false;
					}
					// if this is the last character, continue
					else if (s.length() == 1)
					{
						// if ')' is the last character, then it is an <Expr>
						if (s.charAt(0) == ')') return true;
						// if the last character is not ')', then it is not an <Expr
						else return false;
					}
					// if the next character is ')' follwed by an <Op>, continue
					else if (s.charAt(0) == ')' && isOp(s.charAt(1))) 
					{
						s = s.substring(2); // move up the string
						// if the next character is '(', look for an <Expr>
						if (s.charAt(0) == '(') return isExpr(s);
						// if the next character is an <Id> followed by a ')', continue
						else if (isId(s.charAt(0)) && s.charAt(1) == ')')
						{
							// if these are the last characters, then it is an <Expr>
							if (s.length() == 2) return true;
							s = s.substring(1); // move up the string
							continue; // iterate loop again
						}
					}
					// if the next character is an ')', continue
					else if (s.charAt(0) == ')')
					{
						s = s.substring(1); // move up the string
						continue; // iterate loop again
					} 
					// else, look for an <Expr>
					else return isExpr(s);
				}
			}
			// if the string is an <Id>, then it is an <Expr>
			else if (isId(s)) return true;
			// if all else fails, then the string is not an <Expr>
			return false;
		}
		catch (StringIndexOutOfBoundsException e)
		{
			// if such an error is caught, then an expected character is missing
			// hence, the string is not an <Expr>
			return false;
		}
	}

	// determine whether a character is an <Id>
	public static boolean isId(char c)
	{
		if (Character.isLetter(c))
			return true;
		return false;
	}

	// determine whether a string is an <Id>
	public static boolean isId(String s)
	{
		if (Character.isLetter(s.charAt(0)) && s.length() == 1)
			return true;
		return false;
	}

	// determine whether a character is an <Op>
	public static boolean isOp(char c)
	{
		if (c == '+' || c == '-' || c == '*' || c == '/')
			return true;
		return false;
	}

	// main body of program
	public static void main(String[] args)
	{
		try // may get file not found error
		{
			// grab and prepare input
			File file = new File("express.txt");
			Scanner sc = new Scanner(file);
			String string = "";
			while (sc.hasNextLine()) string += sc.nextLine();
			sc.close();
			// split input into individual tokens
			String[] tokens = string.split(" ");
			// determin whether each input token is a valid expression and print results
			for (int i = 0; i < tokens.length; i++)
			{
				boolean expression = FindExpression.isExpr(tokens[i]);
				if (expression) System.out.println(tokens[i] + "   ** Is a valid expression **\n");
				else System.out.println(tokens[i] + "   ** Is NOT a valid expression **\n");
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: File not found");
		}
	}
}