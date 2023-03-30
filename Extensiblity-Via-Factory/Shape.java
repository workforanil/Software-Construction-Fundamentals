package extensibalFactory;
/**
 * Shape interface class for getting area, perimeter, origin,
 * point inclusion, shape type, date of creation. 
 * @author Anil
 *
 */
public interface Shape {
	/**
	 * Method to find area of shape a object on screen.
	 * @return Double.
	 */
	double getArea(); 
	
	/**
	 * Method to find Perimeter of a shape object on screen.
	 * @return boolean.
	 */
	double getPerimeter();
	
	/**
	 * Method to get origin of a shape object on screen.
	 * @return
	 */
	Point getOrigin(); 
	
	/**
	 * Method checks wheather the point is enclosed in shape object on screen.
	 * @param p Point on screen
	 * @return boolean
	 */
	Boolean isPointEnclosed(Point p); 
	
	/**
	 * Method to get Shape type
	 * @return ShapeType
	 */
	ShapeType getShapeType(); 
	
	/**
	 * Method to get date of creation of shape object.
	 * @return nano seconds.
	 */
	double getTime(); 
}
