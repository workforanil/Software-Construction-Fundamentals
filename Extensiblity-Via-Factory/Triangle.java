package extensibalFactory;

import java.time.LocalTime;
/**
 * Class creates instances of Right angle Triangle shapes on screen.
 * @author Anil
 *
 */
public class Triangle implements Shape {
	private LocalTime local = LocalTime.now(); // Local time.
	/*Coordinates of Right angle Triangle*/
	private int x1,y1;
	private int x2,y2;
	private int x3,y3;
	private int base; // Base 
	private int height; // height
	private Point origin; // Left bottom coordinate.
	/**
	 * Initialization of class members in constructor.
	 * @param p1 left bottom point type Point.
	 * @param height int
	 * @param base int
	 */
	public Triangle(Point p1,int height,int base) {
		this.origin = p1;
		this.base = base;
		this.height = height;
		/*Setting coordinates*/
		this.x1 = this.x3 = p1.getX();
		this.y1 = this.y2 = p1.getY();
		this.x2 = p1.getX() + base;
		this.y3 = p1.getY() + height;
		local = LocalTime.now(); // time of creation of triangle object on screen.
	}
	@Override
	public double getArea() {
		return 0.5*(this.base*this.height);
	}

	@Override
	public double getPerimeter() {
		return (this.base 
				+ this.height 
				+ Math.sqrt(Math.pow(this.base, 2) 
						+ Math.pow(this.height, 2)));
	}

	@Override
	public Point getOrigin() {
		return this.origin;
	}

	@Override
	public Boolean isPointEnclosed(Point p) {
		if(p.getX() < this.x2 && p.getX() < x3)
			if(p.getX() > this.x1)
				if(p.getY() > this.y1 && p.getY() > this.y2)
					if(p.getY() < this.y3)
						return true;
		return false;
					
	}
	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
	}
	@Override
	public double getTime() {
		return this.local.getSecond()*1000000000+this.local.getNano();
	}
	
}
