public class Random
{
	public static int randomInt(int min, int max)
	{
		// Taken from TJ_Fischer on StackOverflow.com: 
		//https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
		return (min + (int)(Math.random()*(max-min+1)));
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
			System.out.println(randomInt(0,10));
	}
}
