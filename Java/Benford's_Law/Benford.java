/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac Benford.java
 *  Execution:    java Benford string
 *
 *  Takes in a string as input and interprets it as the name of a text file full of numbers,
 *  Then analyzes the numbers to determine whether they obey Benford's Law.
 *
 ************************************************************************************************************/

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

// a simple program for studying Benford's Law
public class Benford
{
	// method for calculating the percentage of times an integer appears in a data set
	public static double percent(int freq, int total)
	{
		return ((double)freq/(double)total)*100;
	}
		
	// method for calculating Benford's Law formula for a given digit
	public static double benfordsLaw(int digit)
	{
		return Math.log10(1.0 + (1.0/((double)digit)))*100.00;
	}
		
	// method for determining whether a digit follows Benford's Law in a data set given a level of significance alpha
	public static boolean followsLaw(double ben, double prob, double alpha)
	{
		if (prob >= ben-alpha && prob <= ben+alpha) return true;
		else										return false;
	}
	
	public static void main(String[] args)
	{
		// read in the name of a text file from the command line
		String txt = args[0];
		// read in a squence of digits
		// loop through the sequence of decimal digits and:
		// 1. read in a file
		// 2. get the total number of numbers in the data file
		// 3. loop through the file
		// 4. print results
		int digit = 1;
		while (digit < 10)
		{
			try
			{
				File file = new File(txt);
				Scanner sc = new Scanner(file);
				int total = Integer.parseInt(sc.nextLine());
				int freq = 0;
				// loop through a given text file and:
				// 1. read file numbers as Strings
				// 2. grab the first digit of each number
				// 3. compare the first digit of each number to the current digit we are looking at in the squence
				// 4. track how many times the digit appears in the file
				while (sc.hasNextLine())
				{
					String number = sc.next();
					int dgt = Character.getNumericValue(number.charAt(0));
					if (dgt == digit) freq++;
				}
				// prepare, format, and then print results
				double percent = Benford.percent(freq, total);
				double benford = Benford.benfordsLaw(digit);
				DecimalFormat df = new DecimalFormat("#####0.000");
				System.out.println("\nDigit: " + digit);
				System.out.println("   Appears as the first digit of a number " + NumberFormat.getIntegerInstance().format(freq) + 
								   " times out of " + NumberFormat.getIntegerInstance().format(total) + " numbers total");
				System.out.println("   According to Benford's Law, it should appear " + df.format(benford) + "% of the time");
				System.out.println("   Percentage in the data set: " + df.format(percent) + "%");
				if (Benford.followsLaw(benford, percent, 5.0)) 
					System.out.println("   Follows Benford's Law in this data set at a 5% level of significance\n");
				else System.out.println("   Does not follow Benford's Law in this data set at a 5% level of significance\n");
				digit++;
			}
			catch (IOException e)
			{
				System.out.println("IOException");
			}
		}
	}
}