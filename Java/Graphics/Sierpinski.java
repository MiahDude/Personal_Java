/*************************************************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *  Dependencies: StdDraw.java
 *  			  StdAudio.java
 *  
 *  Draw a Sierpinski Triangle that resembles the triforce from the Legend of Zelda video game series.
 *  Play a Legend of Zelda sound effect after drawing the triangle.
 *  
 ************************************************************************************************************/
import java.util.Scanner;

public class Sierpinski
{
	// Create a function that draws a black, upside-down triangle.
	public static void triangle(double x, double y, double size)
	{
		// Compute coordinates for the three points of the triangle.
		double x1 = x + size/4; 
		double x2 = x + (size - size/4);
        double x3 = x + size/2;
	    double y1 = y + size/2;      
	    double y2 = y + size/2;
	    double y3 = y;
		
		// Place the x- and y- coordinates into respective arrays.
		double[] xa = {x1, x2, x3};
		double[] ya = {y1, y2, y3};
		
		// Use coordinate arrays to draw the triangle.
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledPolygon(xa, ya);
	}

	// Create a function that draws recursive triangles.
	public static void RecursiveTriangles(int n, double x, double y, double size)
	{
		// Stop drawing when n = 0.
		if (n == 0) return;
		
		// Draw upside-down triangle.
		triangle(x, y, size);

		// Compute coordinates for the center of each recursive triangle.
		double x1 = x + size/4;
		double x2 = x;
		double x3 = x + size/2;
		double y1 = y + size/2;      
	    double y2 = y;
	    double y3 = y;

		// Draw three, half-size recursive triangles of order n-1.
	    RecursiveTriangles(n-1, x1, y1, size/2);	// Draw upper triangle.
	    RecursiveTriangles(n-1, x2, y2, size/2);	// Draw left triangle.
	    RecursiveTriangles(n-1, x3, y3, size/2);	// Draw right triangle.
	}

	// Receive input from user and draw a Sierpinski triangle that is reminiscent of the triforce from the Legend of Zelda.
	public static void main(String[] args)
	{
		// Read in an integer from the user and check to make sure that it is positive.
		System.out.println("Enter a positive integer: ");
		Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.close();
		
		if (n < 0)
		{
			System.out.println("Inapropriate value: integer cannot be negative!");
			return;
		}
				
		// Set up canvas size and color. 
		StdDraw.setCanvasSize(512, 512);
		StdDraw.clear(StdDraw.BLACK);
		
		// Create arrays with the x- and y-coordinates of the yellow triangle.
		double[] X = {0.0, 1.0, 0.5},
				 Y = {0.0, 0.0, 1.0};
		
		// Draw yellow triangle.
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledPolygon(X, Y);
		
		// Set starting points for x, y, and size.
		double x    = 0.0;
		double y    = 0.0;
		double size = 1.0;
		
		// Recursively draw the Sierpinski triangle.
		RecursiveTriangles(n, x, y, size);
		// Play a sound effect from the Legend of Zelda.
		// TP_Secret.wav taken from http://noproblo.dayjo.org/ZeldaSounds/
		StdAudio.play("TP_Secret.wav");
	}
}