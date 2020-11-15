/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac PowersOfTwo.java
 *  Execution:    java PowersOfTwo string n
 *
 *  Takes in a string as input, interpreting it as the name of a text file, and an integer n
 *  and creates a list of the firs n powers of 2 in sequential order and saves them in a text file.
 *
 ************************************************************************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PowersOfTwo
{
	public static void main(String[] args)
	{
		try
		{
			File file = new File(args[0]);
			FileWriter writer = new FileWriter(file);
			int number = Integer.parseInt(args[1]);
			writer.write(Integer.toString(number));
			for (int i = 1; i <= number; i++)
				writer.write("\n	" + Long.toString((long)Math.pow(2,i)));
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