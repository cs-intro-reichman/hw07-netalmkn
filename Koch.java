/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
		snowFlake(Integer.parseInt(args[0]));

	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
    	if (n == 0) {
        	StdDraw.line(x1, y1, x2, y2);
        	return;
    	}

    	double dx = x2 - x1;
    	double dy = y2 - y1;

    	double ax = x1 + dx / 3.0;
    	double ay = y1 + dy / 3.0;

    	double bx = x1 + 2.0 * dx / 3.0;
    	double by = y1 + 2.0 * dy / 3.0;

    	double vx = bx - ax;
    	double vy = by - ay;

    	double cos60 = 0.5;
    	double sin60 = Math.sqrt(3) / 2.0;

    	double px = ax + (vx * cos60 - vy * sin60);
    	double py = ay + (vx * sin60 + vy * cos60);

    	curve(n - 1, x1, y1, ax, ay);
    	curve(n - 1, ax, ay, px, py);
    	curve(n - 1, px, py, bx, by);
    	curve(n - 1, bx, by, x2, y2);
	}


    public static void snowFlake(int n) {
    	StdDraw.setYscale(0, 1.1);
    	StdDraw.setXscale(0, 1.1);

    	double x1 = 0.1, y1 = 0.1;
    	double x2 = 1.0, y2 = 0.1;
    	double x3 = 0.55, y3 = 0.1 + (Math.sqrt(3) / 2.0) * 0.9;

    	curve(n, x1, y1, x2, y2);
    	curve(n, x2, y2, x3, y3);
    	curve(n, x3, y3, x1, y1);
}

}
