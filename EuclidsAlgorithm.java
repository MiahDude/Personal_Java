public class EuclidsAlgorithm
{
	public static int euclid(int m, int n)
	{
		int divisions = 0;
		int min = -1;
		int max = -1;

		if(m < n)
		{
			min = m;
			max = n;
		}
		else 
		{
			min = n;
			max = m;
		}

		while(min != 0)
			{
				int remainder = max%min;
				max = min;
				min = remainder;
				divisions++;
			}
			return max;
	}

	public static void main(String[] args)
	{
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.println(euclid(m,n));
	}
}