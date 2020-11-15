/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac Temperature.java
 *  Execution:    java Temperature double char
 *
 *  Converts an input temperature in a specified scale (Fahrenheit or Celsius) to the other scale.
 *
 ************************************************************************************************************/

public class Temperature
{
	// input temperature celsius
	// output temperature fahrenheit 
	public static double fahrenheit(double celsius)
	{
		return ((celsius*(9.0/5.0)) + 32.0);
	}

	// input temperature fahrenhiet
	// output temperature celsius 
	public static double celsius(double fahrenheit)
	{
		return ((fahrenheit-32.0)*(5.0/9.0));
	}

	public static void main(String[] args)
	{
		// input temperature and temperature scale (C for Celsius or F for Fahrenheit) in command prompt
		// Example input: 32 C
		// Example output: 89.6 F
		try
		{
			String scale = args[1];
			double temp = Double.parseDouble(args[0]);
			
			if (scale.equals("C")) System.out.println(fahrenheit(temp) + " F");
			else if (scale.equals("F")) System.out.println(celsius(temp) + " C");
			else System.out.println("Invalid temperature scale");
		}
		catch (Exception e)
		{
			System.out.println("Invalid input");
		}
	}
}