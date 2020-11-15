/******************************************************************************
 *  Author: Jeremiah Herr
 *  Compilation:  javac DiamondTile.java
 *  Execution:    java DiamondTile n
 *  Dependencies: StdDraw.java
 *
 *  Draws an n-by-n diamond tile.
 *
 ******************************************************************************/

public class DiamondTile 
{

    // draw a diamond outline, center at (x, y), diagonals = 2*size 
    public static void diamond(double x, double y, double size) {
        double[] px = { x + size, x, x - size, x };
        double[] py = { y, y + size, y, y - size };
        StdDraw.polygon(px, py);
    }

    // draw a filled diamond, center at (x, y), diagonals = 2*size
    public static void filledDiamond(double x, double y, double size) {
        double[] px = { x + size, x, x - size, x };
        double[] py = { y, y + size, y, y - size };
        StdDraw.filledPolygon(px, py);
    }

    // Write a static method (function) to draw a circle inside the diamond;
	// circle is centered at (x, y), diameter = 2 * size
	// Circle can be filled or outline
    public static void circle(double x, double y, double size)
    {
    	StdDraw.filledCircle(x, y, size/2);
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // for easy computation, set scale to match pattern
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // black diamond
                StdDraw.setPenRadius();
                StdDraw.setPenColor(StdDraw.BLACK);
                filledDiamond(i + 0.5, j + 0.5, 0.5);

				// set pen color to your choice;
                StdDraw.setPenColor(StdDraw.RED);
				// call the method that draws the circle;
                circle(i + 0.5, j + 0.5, 0.5);
				
                // red outline
                StdDraw.setPenRadius(0.005);
                StdDraw.setPenColor(StdDraw.RED);
                diamond(i + 0.5, j + 0.5, 0.5);
            }
        }
    }                
}