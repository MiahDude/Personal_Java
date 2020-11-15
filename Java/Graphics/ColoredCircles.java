/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac ColoredCircles.java
 *  Execution:    java ColoredCircles
 *  Dependencies: StdDraw.java
 *
 *  Draws a recursive pattern of colored circles.
 *
 ************************************************************************************************************/

import java.util.Scanner;

public class ColoredCircles
{
	public static void DrawCircles(int num, double x, double y, double radius)
	{
		// Stop drawing when num = 0
		if (num == 0) return;
		
		// Draw a circle in the specified coordinates
		StdDraw.circle(x+radius, y+radius, radius);
		
		// Draw four half-size circles in the specified coordinates of a specified color
		StdDraw.setPenColor(StdDraw.RED);
		DrawCircles(num-1, x+radius/2, y+radius, radius/2);		// top circle
		StdDraw.setPenColor(StdDraw.BLUE);
		DrawCircles(num-1, x, y+radius/2, radius/2);			// left circle
		StdDraw.setPenColor(StdDraw.GREEN);
		DrawCircles(num-1, x+radius, y+radius/2, radius/2);		// right circle
		StdDraw.setPenColor(StdDraw.YELLOW);
		DrawCircles(num-1, x+radius/2, y, radius/2);			// bottom circle
	}
	public static void main(String args[])
	{
		// Use the scanner to read in the number of recursions to perform
		System.out.println("How many recursions do you want to perform?");
		Scanner kb = new Scanner(System.in);
		int number = kb.nextInt();
		kb.close();
		
		// Prepare canvas for drawing
		StdDraw.setCanvasSize(600, 600);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setXscale(-0.01, 1.01);
		StdDraw.setYscale(-0.01, 1.01);
		StdDraw.setPenRadius(0.005);
		
		// Set initial values of variables
		double ini_x = 0.0;
		double ini_y = 0.0;
		double ini_radius = 0.50;
		
		// Perform a specified number of recursions with circles
		StdDraw.setPenColor(StdDraw.WHITE);
		DrawCircles(number, ini_x, ini_y, ini_radius);
	}
}
