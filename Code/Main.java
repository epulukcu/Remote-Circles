import java.util.Random;
/**
 * @author Elif Pulukçu
 * @since March 18, 2019
 * Program Explanation: This program generates N (n=10, n=100) circles
 * with random coordinates and radiuses.Draws without going beyond the
 * limits of the canvas.
 */

public class Main {
	
	public static void main(String[] args) { 
		// Draws the canvas
		drawWorld();

		//Keeps circles in an array
		Circle[] remoteCircles = new Circle[100];
		Random r = new Random();
		double rad, x, y ;
		int l = remoteCircles.length;

		//radiuses under control
		for (int i = 0; i <l; i++)
		{
			//System.outs are not necessary to see circles. So I make comment them.
			//System.out.println("i is :" + i);
			rad = r.nextInt(20);
			//System.out.println("rad is :" + rad); 

			x = r.nextInt(150)+rad; // to keep all circle in canvas i added radius to x
			//System.out.println("x is :" + x);

			y = r.nextInt(150)+rad; // to keep all circle in canvas i added radius to y
			//System.out.println("y is :" + y);

			remoteCircles[i] = new Circle(x,y,rad);
			remoteCircles[i].draw();
			StdDraw.pause(20); //Sets the speed of drawing circles
		}
		//System.out.println("End of loop");

		// Finding most far 2 circles between each other
		double distance = 0, buf = 0;
		int farthestcircle1 = 0, farthestcircle2 = 0;

		//Drawing bold circles
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				//Comparing circles distances with the other circles
				buf = remoteCircles[i].distance(remoteCircles[j]);
				if (buf > distance) {
					distance = buf;
					farthestcircle1 = i;
					farthestcircle2 = j;
				}
			}
		}

		remoteCircles[farthestcircle1].drawBold();
		remoteCircles[farthestcircle2].drawBold();

		// Drawing a red Line
		drawRedLine(remoteCircles[farthestcircle1].getX(),
				remoteCircles[farthestcircle1].getY(), 
				remoteCircles[farthestcircle2].getX(), 
				remoteCircles[farthestcircle2].getY());
	}
	//Creating a world
	public static void drawWorld() {
		int worldSize = 200;
		// initialize graphics 
		StdDraw.enableDoubleBuffering();
		StdDraw.setXscale(0, worldSize);
		StdDraw.setYscale(0, worldSize);
		StdDraw.show();
	}

	public static void drawRedLine(double x1, double y1, double x2, double y2) {
		StdDraw.setPenRadius(0.009);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.save("Output_figure.png"); //To save the figure to a file
		StdDraw.show();
	}
}
