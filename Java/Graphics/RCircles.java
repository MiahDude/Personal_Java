/************************************************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac RCircles.java
 *  Execution:    java RCircles
 *  Dependencies: StdDraw.java
 *
 *  Draws a recursive pattern of circles.
 *
 ************************************************************************************************************/

import java.util.Scanner;

public class RCircles
{
	public static void DrawCircles(int num, double x, double y, double radius)
	{
		// Stop drawing when num = 0
		if (num == 0) return;
		
		// Draw a circle in the specified coordinates
		StdDraw.circle(x+radius, y+radius, radius);
		
		// Draw four half-size circles in the specified coordinates
		DrawCircles(num-1, x+radius/2, y+radius, radius/2);		// top circle
		DrawCircles(num-1, x, y+radius/2, radius/2);			// left circle
		DrawCircles(num-1, x+radius, y+radius/2, radius/2);		// right circle
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
		StdDraw.setXscale(-0.01, 1.01);
		StdDraw.setYscale(-0.01, 1.01);
		StdDraw.setPenRadius(0.005);
		
		// Set initial values of variables
		double ini_x = 0.0;
		double ini_y = 0.0;
		double ini_radius = 0.50;
		
		// Perform a specified number of recursions with circles
		DrawCircles(number, ini_x, ini_y, ini_radius);
	}
}
