/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac OddMagicSquare.java
 *  Execution:    java OddMagicSquare
 *
 *  Prints an nxn magic square, where n is an odd postive integer, and proves that the printed result is correct
 *
 ************************************************************************************************************/

import java.util.Scanner;

public class OddMagicSquare
{
    public static void main(String[] args)
    {
        //Declare variables and array.
        int n,                  // n = length.
            row,                // row number.
            col,                // col number.
            rowPrev,            // rowPrev = previous row number.
            colPrev,            // colPrev = previous column nunber.
            num,            // num = current number.
            diagSum1,
            diagSum2,
            magicConstant;      // magicConstant = number that all rows and columns and diagonals must add up to.
        
        int[][] magicSquare;
        int[]   rowSums,
                colSums;
        
        // Read in an integer n for n x n magic square.
        System.out.println("Enter a positive, odd interger: ");
        
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        
        // Check to make sure user input is an odd, positive integer.
        if (n <= 0 || n%2 == 0)
        {
            System.out.println("\nInappropriate value entered.");
            System.out.println("Appropriate values = positive, odd integers only.");
            return;
        }
        
        // Initialize array and variables.
        magicConstant = n*((n*n + 1)/2);
        magicSquare   = new int [n][n];
        rowSums       = new int[n];
        colSums       = new int[n];
        diagSum1      = 0;
        diagSum2      = 0;
        // Set current square to middle of top row and set current number to 1.
        row = 0;
        col = (n-1)/2;
        num = 1;
        
        // Fill in magic square.
            while (num <= n*n)
            {
                // Fill current square with current number, increase current number by one, then move up one row and right one column.
                magicSquare[row][col] = num; 	// Place current number in current square.
                num++;         					// Increment the current number.
                rowPrev = row; 					// Save the number of the most recent square's row. 
                colPrev = col; 					// Save the number of the most recent square's column. 
                row--;         					// go up by one square.
                col++;         					// go right by one square.
                
                // If row goes above first row, go to the bottom row.
                if (row == -1)                  
                    row = n-1; 
                
                // If col goes past last column on the right, go to the first column on the left.               
                if (col == n)                   
                    col = 0; 

                // If a square is already filled in, go to the square below the most recently filled one.               
                if (magicSquare[row][col] != 0)
                {
                    row = rowPrev + 1;
                    col = colPrev;
                }
            }
            
            // Add up rows, columns, and diagonals.
            for (int i = 0; i < magicSquare.length; i++)
            {
                for (int j = 0; j < magicSquare.length; j++)
                    {
                       if (i == j)
                            diagSum1 += magicSquare[i][j];
                            
                       if (i+j == (n-1))
                            diagSum2 += magicSquare[i][j];
                            
                       for (int p = n; p > 0; p--)
                            {
                             if (n-p == i)
                                 rowSums[i] += magicSquare[i][j];
                             if (n-p == j)
                                 colSums[j] += magicSquare[i][j];
                            }
                     }
            }
        
		    System.out.println();
			// Check whether all rows, columns, and diagonals add up to the magic constant.
			// If not, print a warning to the user.
            if (diagSum1 != magicConstant || diagSum2 != magicConstant) 
            {
                System.out.println("WARNING: Cursed Magic Square!");
                System.out.println("Not all diagonals add up to Magic Constant.");
            }
            
            for (int i = 0; i < rowSums.length; i++) 
            { 
                if (rowSums[i] != magicConstant)
                {
                    System.out.println("WARNING: Cursed Magic Square!");
                    System.out.println("Not all rows add up to Magic Constant.");
                }
            }
            
            for (int j = 0; j < colSums.length; j++)
            {
                if (colSums[j] != magicConstant)
                {
                    System.out.println("WARNING: Cursed Magic Square!");
                    System.out.println("Not all columns add up to Magic Constant.");
                }
            }
        
        System.out.println();
        // Align and Print the completed magic square.
        for (int i = 0; i < magicSquare.length; i++)
        {
            for (int j = 0; j < magicSquare.length; j++)
            {
				if (magicSquare[i][j] < 10)  System.out.print(" ");
				if (magicSquare[i][j] < 100) System.out.print(" ");
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
        
        // Print the row, column, and diagonal sums.
        System.out.println("\nMagic Constant: " + magicConstant);
        System.out.println("\nDiagonal Sum from top-left to bottom-right: " + diagSum1);
        System.out.println("Diagonal Sum from top-right to bottom-left: " + diagSum2);
        System.out.println();
        for (int i = 0; i < rowSums.length; i++)
            System.out.println("Row " + (i+1) + " Sum: " + rowSums[i]);
        System.out.println();
        for (int j = 0; j < colSums.length; j++)
            System.out.println("Column " +  (j+1) + " Sum: " + colSums[j]);
    }
}