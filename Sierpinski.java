/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	public static void sierpinski(int n) {
    	double x1 = 0.0, y1 = 0.0;
    	double x2 = 1.0, y2 = 0.0;
    	double x3 = 0.5, y3 = Math.sqrt(3) / 2.0;

    	StdDraw.setPenColor(StdDraw.BLACK);
    	double[] xs = { x1, x2, x3 };
    	double[] ys = { y1, y2, y3 };
    	StdDraw.filledPolygon(xs, ys);

    	sierpinski(n, x1, x2, x3, y1, y2, y3);
	}


	private static void sierpinski(int n,
                               double x1, double x2, double x3,
                               double y1, double y2, double y3) {
    	if (n == 0) return;

    	double mx12 = (x1 + x2) / 2.0, my12 = (y1 + y2) / 2.0;
    	double mx23 = (x2 + x3) / 2.0, my23 = (y2 + y3) / 2.0;
    	double mx31 = (x3 + x1) / 2.0, my31 = (y3 + y1) / 2.0;

    	StdDraw.setPenColor(StdDraw.WHITE);
    	double[] xs = { mx12, mx23, mx31 };
    	double[] ys = { my12, my23, my31 };
    	StdDraw.filledPolygon(xs, ys);

    	StdDraw.setPenColor(StdDraw.BLACK);

    	sierpinski(n - 1, x1, mx12, mx31, y1, my12, my31);
    	sierpinski(n - 1, mx12, x2, mx23, my12, y2, my23);
    	sierpinski(n - 1, mx31, mx23, x3, my31, my23, y3);
	}


}
