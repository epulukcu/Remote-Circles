import java.util.Random;

public class RemoteCircle {

	private static int canvasSize = 500;
	private static int xScale =1;
	private static int yScale =1;
	private static double boldPenRadius = 0.010;

	public static void drawWorld() {
		// initialize graphics
		StdDraw.setCanvasSize(canvasSize, canvasSize);
	}
	
	public static void drawRedLine(double x1, double y1, double x2, double y2) {
		StdDraw.setPenRadius(boldPenRadius);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(x1, y1, x2, y2);
	}

	public static void main(String[] args) {
		
		drawWorld();
		
		Circle[] remoteCircles = new Circle[10];
		Random r = new Random();
		double x= 0.0, y= 0.0, rad = 0.0;
		
		for (int i = 0; i <remoteCircles.length;)
		{
			rad = r.nextDouble();
			x = r.nextDouble();
		    y = r.nextDouble(); 

		    // to keep random x y circle values in canvas
			if(x+rad <= xScale && 
			   y+rad <= yScale && 
			   x-rad >= 0 && 
			   y-rad >= 0)
			{
				remoteCircles[i] = new Circle(x,y,rad);
				remoteCircles[i].draw();
				i++;
			}
		}
		
		// Finding most far 2 circles between each other
		double distance = 0, buf = 0;
		int farthestcircle1 = 0, farthestcircle2 = 0, l = remoteCircles.length;
		
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				//comparing circles distances with the other circles
				buf = remoteCircles[i].distance(remoteCircles[j]);
				if (buf > distance) {
					farthestcircle1 = i;
					farthestcircle2 = j;
					distance = buf;
				}
			}
		}

		// Drawing Bold Circles
		StdDraw.setPenRadius(boldPenRadius);
		remoteCircles[farthestcircle1].draw();
		remoteCircles[farthestcircle2].draw();
		
		// Drawing Red Line
		drawRedLine(remoteCircles[farthestcircle1].getX(),
					remoteCircles[farthestcircle1].getY(), 
					remoteCircles[farthestcircle2].getX(), 
					remoteCircles[farthestcircle2].getY());

	}
}
