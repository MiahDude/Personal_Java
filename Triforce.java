import java.util.Scanner;

public class Triforce 
{
	public static void main(String[] args)
	{
		// Declare variables and array.
		int n,
			m;
		
		String asterisk = "* ",
			   space    = "  ";
		
		// Read in integer for n x [(n*2)-1] array.
		String[][] triForce;
		
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
		triForce = new String[n][m];
		
		// Create Triforce.
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if      (i+j == n-1)
					triForce[i][j] = asterisk;
				else if (j-i == n-1)
					triForce[i][j] = asterisk;
				else if (i == n-1)
					triForce[i][j] = asterisk;
				else if (i >= ((n-1)/2) && i == j)
					triForce[i][j] = asterisk;
				else if (i >= ((n-1)/2) && i+j == (m-1))
					triForce[i][j] = asterisk;
				else if (i == ((n-1)/2) && j > (0 + ((n-1)/2)) && j < (m - ((n-1)/2)))
					triForce[i][j] = asterisk;
				else
					triForce[i][j] = space;
			}
		}
		
		// Print Triforce.
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				System.out.print(triForce[i][j]);
			}
			System.out.println();
		}
	}
}