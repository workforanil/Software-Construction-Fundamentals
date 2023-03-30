package extensibalFactory;

import java.time.LocalTime;
/**
 * Class creates instances of circle shape on screen
 * @author Anil
 *
 */
public class Circle implements Shape {
	private LocalTime local = LocalTime.now(); // Local Time.
	/*Coordinates of circle's center*/
	private int x; 
	private int y;
	
	private int radius; // radius of circle
	private Point origin; // center of circle
	/**
	 * Initializing class members in constructor
	 * @param p Point of origin
	 * @param radius type int
	 */
	public Circle(Point p, int radius) {
		this.origin = p;
		this.x = p.getX();
		this.y = p.getY();
		this.radius = radius;
		local = LocalTime.now(); // Circle Shape creation time.
	}
	@Override
	public double getArea() {
		return (Math.PI*Math.pow(this.radius, 2));
	}

	@Override
	public double getPerimeter() {
		return (Math.PI*this.radius*2);
	}

	@Override
	public Point getOrigin() {
		return this.origin;
	}

	@Override
	public Boolean isPointEnclosed(Point p) {
		double distance = Math
				.sqrt(Math.pow(p.getX() - this.x, 2) 
						+ Math.pow(p.getY() - this.y, 2));
		if(distance < this.radius) {
			return true;
		}else {
			return true;
		}
	}
	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
	}
	@Override
	public double getTime() {
		return (this.local.getSecond()*1000000000+this.local.getNano());
	}

}
