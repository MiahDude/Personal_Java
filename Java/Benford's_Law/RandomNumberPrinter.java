/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac RandomNumberPrinter.java
 *  Execution:    java RandomNumberPrinter string n
 *
 *  Takes in a string as input, interpreting it as the name of a text file, and an integer n
 *  and creates a list of n integers in random order and saves them in a text file.
 *
 ************************************************************************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomNumberPrinter
{
	public static void main(String[] args)
	{
		try
		{
			File file = new File(args[0]);
			FileWriter writer = new FileWriter(file);
			int min = 1;
			int max = 1000000;
			int number = Integer.parseInt(args[1]);
			writer.write(Integer.toString(number));
			for (int i = 1; i <= number; i++)
			{
				int random = min + (int)(Math.random() * ((max-min))+1);
				writer.write("\n	" + Integer.toString(random));
			}
			System.out.println("Success!");
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			System.out.println("Error");
		}
	}
}