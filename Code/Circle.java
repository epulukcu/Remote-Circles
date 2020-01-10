import java.util.Random;

public class Circle {
	
	private double x; //Circle center x coordinate
	private double y; //Circle center y coordinate
	private double r; //Circle radius
	
	/**
	 * A constructor creates objects.
	 * @param x
	 * @param y
	 * @param r
	 */
	
	Circle(double x, double y, double r) {
		this.x = x; //This keyword returns the reference of the object on which it is currently being processed.
		this.y = y;
		this.r = r;
	}
	
	//setter and getter methods--begin
	public double getX() {
		return x;
	}
	
	/*The set methods has no return.
	 *NOT NEEDED FOR THIS ASSIGNMENT 
	public void setX(double x) {
		this.x = x;
	}
	*/

	public double getY() {
		return y;
	}

	/* NOT NEEDED
	 * public void setY(double y) {
		this.y = y;
		}
	*/
	
	public double getR() {
		return r;
	}
	//setter and getter methods--end

	//draw method draws black circles with pen radius 0.0001
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.001);
		StdDraw.circle(x, y, r);
		StdDraw.show();
	}
	
	 //distance method calculate the distance between two circles with a mathematical formula
	public double distance(Circle c) {
		
		return Math.sqrt(Math.abs((c.x - x) * (c.x - x)) + Math.abs((c.y - y) * (c.y - y)));
	}

	 //drawBold method, draws out circles more thicker
	public void drawBold() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.circle(x, y, r);
		StdDraw.show();
	}
	
}
