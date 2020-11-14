/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac NumIntegration.java
 *  Execution:    java NumIntegration
 *  Dependencies: 
 *
 *  This program was written to make my Calc II homework easier.
 *
 ************************************************************************************************************/
public class NumIntegration
{
	public static double x(double k, double a, double dx)
	{
		return a + k*dx;
	}

	public static double d_x(double a, double b, int n)
	{
		double dn = n;
		return (b-a)/dn;
	}

	public static double f(double x)
	{
		return Math.pow(x,2);
	}

	public static double m(double x1, double x2)
	{
		return (x1 + x2)/2.0;
	}

	public static double midpoint(double a, double b, int n)
	{
		double dx = d_x(a,b,n);
		double sum = 0.0;
		for (int k=1; k<=n; k++)
		{
			double x1 = x(k-1,a,dx);
			double x2 = x(k,a,dx);
			double mk = m(x1,x2);
			sum += f(mk)*dx;
		}
		return sum;
	}

	public static double trapezoid(double a, double b, int n)
	{
		double dx = d_x(a,b,n);
		double sum = 0.0;
		for (int k=1; k<=n-1; k++)
		{
			double xk = x(k,a,dx);
			sum += f(xk);
		}
		double dn = n;
		double f0 = f(x(0,a,dx))/2.0;
		double fn = f(x(dn,a,dx))/2.0;
		return (f0 + sum + fn)*dx;
	}

	public static double simpsontrap2(double a, double b, int n)
	{
		return (4.0*trapezoid(a,b,2*n)-trapezoid(a,b,n))/3.0;
	}

	public static double abs_error(double x, double c)
	{
		double error = c-x;
		if (error < 0.0) return error*-1.0;
		else 		   return error;
	}

	public static void main(String[] args)
	{
		double a = 3;
		double b = 12;
		double c = 567;
		int n = 12;

		System.out.println("Midpoint Rule: " + midpoint(a,b,n));
		System.out.println("Trapezoid Rule: " + trapezoid(a,b,n));
		System.out.println("Simpson Rule: " + simpsontrap2(a,b,n/2));

		System.out.println("Absolute Error in Midpoint: " + abs_error(midpoint(a,b,n),c));
		System.out.println("Absolute Error in Trapezoid: " + abs_error(trapezoid(a,b,n),c));
		System.out.println("Absolute Error in Simpson: " + abs_error(simpsontrap2(a,b,n/2),c));
	}
}
