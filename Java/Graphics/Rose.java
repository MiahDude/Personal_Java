/************************************************************************************************************
 *  Compilation:  javac Rose.java
 *  Execution:    java Rose n d
 *  Dependencies: stdlib.jar
 *
 *  A modified version of Rose.java, found at https://introcs.cs.princeton.edu/java/15inout/Rose.java.html.
 *  Changes were made so that more elaborate rose curves could be generated, 
 *  based on information found here: https://en.wikipedia.org/wiki/Rose_(mathematics).
 *
 *  Plots rose curves, r = cos(k*theta), where k = n/d, and n,d are doubles.
 *
 ************************************************************************************************************/

public class Rose
{
	public static void main(String[] args)
	{
        double n = Double.parseDouble(args[0]);
        double d = Double.parseDouble(args[1]);
		
        StdDraw.setCanvasSize(512, 512);
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setXscale(-1.005, +1.005); 
		StdDraw.setYscale(-1.005, +1.005);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.005);
		
		double x0 = 1.0, y0 = 0.0, k = n/d;
		for (double t = 0.0; t <= d*360.0; t += 0.1)
		{
			double theta = Math.toRadians(t);
			double r = Math.cos(k * theta);
			double x1 = r * Math.cos(theta);
			double y1 = r * Math.sin(theta);
			StdDraw.line(x0, y0, x1, y1);
			x0 = x1;
			y0 = y1;
		}
	}
}
