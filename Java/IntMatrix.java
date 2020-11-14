/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac IntMatrix.java
 *  Execution:    java IntMatrix a b c d z
 *
 *  An incopmlete implementation of an Integer Matrix data type. 
 *  a,b,c,d are integers used to form a 2 x 2 integer matrix, 
 *  and z is an integer specifying arithmetic modulo z
 *
 ************************************************************************************************************/

import java.util.Arrays;

public class IntMatrix
{
	private int[][] matrix;
	private int rnum; // number of rows
	private int cnum; // number of columns

	public IntMatrix(int[][] matrix)
	{
		this.matrix = matrix;
		rnum = matrix.length;
		cnum = matrix[0].length;
	}

	public IntMatrix(int i, int j)
	{
		matrix = new int[i][j];
		rnum = matrix.length;
		cnum = matrix[0].length;
	} 

	public int get(int i, int j)
	{
		return matrix[i][j];
	}

	public void set(int i, int j, int x)
	{
		matrix[i][j] = x;
	}

	public int getRNum()
	{
		return rnum;
	}

	public int getCNum()
	{
		return cnum;
	}

	public String toString()
	{
		return Arrays.deepToString(matrix);
	}

	public static IntMatrix multiply(Matrix A, Matrix B)
	{
		int m = A.getRNum();
		int n = A.getCNum();
		int p = B.getRNum();
		int q = B.getCNum();
		int[][] C = new int[m][q];
		if (n == p)
		{
			for (int i = 0; i < C.length; i++)
			{
				for (int j = 0; j < C[0].length; j++)
				{
					int product = 0;
					for (int l = 0; l < n; l++)
					{
						product += A.get(i,l) * B.get(l,j);
					}
					C[i][j] = product;
				}
			}
		}
		IntMatrix finalProduct = new IntMatrix(C);
		return finalProduct;
	}

	public static IntMatrix multiply(IntMatrix A, IntMatrix B, int z) // (A*B)modz
	{
		int m = A.getRNum();
		int n = A.getCNum();
		int p = B.getRNum();
		int q = B.getCNum();
		int[][] C = new int[m][q];
		if (n == p)
		{
			for (int i = 0; i < C.length; i++)
			{
				for (int j = 0; j < C[0].length; j++)
				{
					int product = 0;
					for (int l = 0; l < n; l++)
					{
						product += A.get(i,l) * B.get(l,j);
					}
					C[i][j] = product%z;
				}
			}
		}
		IntMatrix finalProduct = new IntMatrix(C);
		return finalProduct;
	}

	public IntMatrix inverse(int z) // only works for 2x2 matrices
	{
		int[][] inv = new int[2][2]; 
		int x, y, p, q;

		int a = this.get(0,0);
		int b = this.get(0,1);
		int c = this.get(1,0);
		int d = this.get(1,1);

		if ((a*d - c*b)%z == 1) // then we have SL(2,F)
		{
			inv[0][0] = d;
			inv[0][1] = -b;
			inv[1][0] = -c;
			inv[1][1] = a;
			IntMatrix inverse = new IntMatrix(inv);
			return inverse; 
		}
		else if ((a*d - c*b)%z == 0) // then the inverse does not exist
		{
			IntMatrix inverse = new IntMatrix(inv);
			return inverse;
		}

		for (int i = 1; i < z; i++)
		{
			x = i;
			y = i;
			for (int j = 1; j < z; j++)
			{
				if (i == j) continue;
				q = j;
				p = j;
				int axbqmodz = (a*x + b*q)%z;
				int cxdqmodz = (c*x + d*q)%z;
				int aybpmodz = (a*y + b*p)%z;
				int cydpmodz = (c*y + d*p)%z;
				if ((axbqmodz == 1) && (cxdqmodz == 0))
				{
					inv[0][0] = x;
					inv[1][0] = q;
				}
				if ((aybpmodz == 0) && (cydpmodz == 1))
				{
					inv[0][1] = y;
					inv[1][1] = p;
				} 
			}
		}
		IntMatrix inverse = new IntMatrix(inv);
		return inverse;
	}

	public IntMatrix identity(int z)
	{
		IntMatrix inverse = this.inverse(z);
		IntMatrix identity = IntMatrix.multiply(this,inverse,z);
		return identity;
	}

	public static void main(String[] args)
	{
		int[][] array = new int[2][2];
		array[0][0] = Integer.parseInt(args[0]);
		array[0][1] = Integer.parseInt(args[1]);
		array[1][0] = Integer.parseInt(args[2]);
		array[1][1] = Integer.parseInt(args[3]);
		int z = Integer.parseInt(args[4]);
		IntMatrix mat = new IntMatrix(array);
		IntMatrix matInv = mat.inverse(z);
		IntMatrix matId = mat.identity(z);
		System.out.println(mat);
		System.out.println(matInv);
		System.out.println(matId);
	}
}
