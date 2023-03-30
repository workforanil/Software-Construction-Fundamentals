package extensibalFactory;

import java.time.LocalTime;
/**
 * Class will create instances of Rectangle shape on Screen.
 * @author Anil
 *
 */
class Rectangle implements Shape {
	private LocalTime local = LocalTime.now(); // Local time
	/*Coordinates of Rectangle corners*/
	private int x1,y1;
	private int x2,y2;
	private int x3,y3;
	private int x4,y4;
	
	private int breadth; // Breadth of Rectangle.
	private int length; // Length of Rectangle.
	
	private Point origin; // left bottom point od rectangle
	/**
	 * initializing class members in constructor.
	 * @param p type Point.-Point of origin.
	 * @param length type int.-Length of rectangle.
	 * @param breadth type int.-Breadth of rectangle.
	 */
	public Rectangle(Point p, int length, int breadth) {
		this.origin = p; // initializing shape origin.
		this.breadth = breadth; // breadth
		this.length = length; // length
		/*Setting Coordinates*/
		this.x1 = this.x4 = p.getX();
		this.y1 = this.y2 = p.getY();
		this.x2 = this.x3 = p.getX() + breadth;
		this.y3 = this.y4 = p.getY() + length;
		
		local = LocalTime.now(); // Setting creation time.
	}
	
	@Override
	public double getArea() {
		return this.length*this.breadth;
	}
	
	@Override
	public double getPerimeter() {
		return 2*this.length*this.breadth;
	}
	
	@Override
	public Point getOrigin() {
		return this.origin;
	}
	
	@Override
	public Boolean isPointEnclosed(Point p) {
		if(p.getX() < this.x3 && p.getX() < this.x2)
			if(p.getX() > this.x4 && p.getX() > this.x1)
				if(p.getY() < y4 && p.getY() < y3)
					if(p.getY() > y1 && p.getY() > this.y2)
						return true;
		return false;
	}
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}

	@Override
	public double getTime() {
		return (double)(this.local.getSecond()*1000000000+this.local.getNano());
	}

}
