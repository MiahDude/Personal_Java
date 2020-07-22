/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac DecimalToBinary.java
 *  Execution:    java DecimalToBinary n
 *
 *  Converts a decimal integer n to its binary representation.
 *
 ************************************************************************************************************/

import java.util.Stack;

public class DecimalToBinary
{
	public static String decimalToBinary(int decimal)
	{
		if (decimal < 0) return "negative";
		else if (decimal == 0) return "0";
		else
		{
			Stack<Integer> digits = new Stack<Integer>();
			String binary = "";

			while (decimal >= 1)
			{
				int r = decimal%2;
				int q = decimal/2;

				digits.push(r);
				decimal = q;
			}

			while (!digits.empty()) binary += Integer.toString(digits.pop());

			return binary;
		}

	}
	public static void main(String[] args)
	{
		int decimal = Integer.parseInt(args[0]);
		String binary = decimalToBinary(decimal);
		System.out.println(binary);
	}
}