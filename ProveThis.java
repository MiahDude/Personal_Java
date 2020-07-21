// This program was written to help me prove a conjecture for an Abstract Algebra homework assignment
public class ProveThis
{
	public static void main(String[] args)
	{
		int a, b, c, d;
		boolean proven = true;
		int permutations = 0;
		for (int i = 1; i < 11; i++)
		{
			a = i;
			for (int l = 1; l < 11; l++)
			{
				if (i == l) continue;
				c = l;
				for (int j = 0; j < 10; j++)
				{
					b = j;
					for (int k = 0; k < 10; k++)
					{
						if (j == k) continue;
						permutations++;
						d = k;
						int ab = a*b;
						int cd = c*d;
						int ad = a*d;
						int cb = c*b;
						int abcd = ab + cd;
						int adcb = ad + cb;
						int diff = Math.abs(abcd-adcb);
						int reduce = diff%11;
						System.out.println("If a = " + a + ", b = " + b + ", c = " + c + ", and d = " + d + ",");
						System.out.println("Then ab = " + ab + ", cd = " + cd + ", so ab + cd = " + abcd);
						System.out.println("And ad = " + ad + ", cb = " + cb + ", so ad + cb = " + adcb);
						if (reduce == 0)
						{
							proven = false;
							System.out.println(reduce + " = 0, your conjecture is false");
						}
						else
						{
							System.out.println(reduce + " != 0");
						}
						System.out.println();
					}
				}
			}
		}
		System.out.println("Conjecture: Let a,b,c,d be integers.");
		System.out.println("a,c are in {1,2,3,4,5,6,7,8,9,10} and a != c.");
		System.out.println("b,d are in {0,1,2,3,4,5,6,7,8,9} and b != d.");
		System.out.println("For all permutations of a,b,c,and d,");
		System.out.println("|(a*b + c*d) - (a*d + c*b)| != 11*k, where k is an integer.\n");
		System.out.println("Computed permutations of a,b,c,d: " + permutations);
		System.out.println("Your conjecture was proven " + proven);
	}
}