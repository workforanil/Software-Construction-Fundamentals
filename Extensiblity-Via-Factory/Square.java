package extensibalFactory;

import java.time.LocalTime;
/**
 * Class creates instances of square on screen.
 * @author Anil
 *
 */
public class Square implements Shape{

	private LocalTime local = LocalTime.now(); // Local time
	/*Coordinates of Square corners*/
	private int x1,y1;
	private int x2,y2;
	private int x3,y3;
	private int x4,y4;
	
	private int dimension; // Square dimension
	
	private Point origin; // Square object origin
	/**
	 * Initializing class members in constructor.
	 * @param p Point of origin.
	 * @param length dimension of square. type int
	 */
	public Square(Point p, int length) {
		this.origin = p; // set object's origin
		this.dimension = length; // set object's dimension.
		/*Setting Coordinates*/
		this.x1 = this.x4 = p.getX();
		this.y1 = this.y2 = p.getY();
		this.x2 = this.x3 = p.getX() + length;
		this.y3 = this.y4 = p.getY() + length;
		
		local = LocalTime.now(); // date of object creation.
	}

	@Override
	public double getArea() {
		return dimension*dimension;
	}

	@Override
	public double getPerimeter() {
		return 4*dimension;
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
		return ShapeType.SQUARE;
	}

	@Override
	public double getTime() {
		return (double)(this.local.getSecond()*1000000000+this.local.getNano());
	}

}
