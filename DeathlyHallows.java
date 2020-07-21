import java.util.Scanner;

public class DeathlyHallows 
{
	public static void main(String[] args)
	{
		// Declare variables and array.
		int n,
		m;
				
		String asterisk = "* ",
	    space           = "  ",
		period          = ". ";
				
		// Read in integer for n x [(n*2)-1] array.
		String[][] deathlyHallows;
				
		System.out.println("Enter a positive, odd integer: ");
				
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
				
		// Check to make sure user input is an odd number.
		if (n <= 0 || n%2 == 0)
			{
				System.out.println("\nInappropriate value entered.");
				System.out.println("Appropriate values = positive, odd integers only.");
				return;
			}
				
		// Initialize array and variables.
		m = (n*2) - 1;
		deathlyHallows = new String[n][m];
				
		// Create Deathly Hallows.
		for (int i = 0; i < n; i++)
			{
				for (int j = 0; j < m; j++)
				{
					// Create the Cloak of Invisibility.
					if      (i+j == n-1)
						deathlyHallows[i][j] = asterisk;
					else if (j-i == n-1)
						deathlyHallows[i][j] = asterisk;
					else if (i == n-1)
						deathlyHallows[i][j] = asterisk;
					
					// Create the Resurrection Stone. 
					else if (i > 1 && i <= ((n-1)/2) && i+j == n)
						deathlyHallows[i][j] = asterisk;
					else if (i > 1 && i <= ((n-1)/2) && j-i == n-2)
						deathlyHallows[i][j] = asterisk;
					else if (i > ((n-1)/2) && i <= n-2 && i-j == 0)
						deathlyHallows[i][j] = asterisk;
					else if (i > ((n-1)/2) && i <= n-2 && i+j == m-1)
						deathlyHallows[i][j] = asterisk;
					else
						deathlyHallows[i][j] = space;
					
					// Create the Elder Wand.
					for (int p = n; p > 0; p--)
					{
						if (n-p == i && j == (m-1)/2)
							deathlyHallows[i][j] = asterisk;
					}
				}
			}
				
		// Print Deathly Hallows.
		for (int i = 0; i < n; i++)
		{
				for (int j = 0; j < m; j++)
				{
					System.out.print(deathlyHallows[i][j]);
				}
				System.out.println();
		}
	}
}