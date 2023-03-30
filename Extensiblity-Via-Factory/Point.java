package extensibalFactory;
/**
 * Class for creating a point on screen.
 * @author Anil
 *
 */
public class Point {
	private int x; // x coordinate
	private int y; // y coordinate
	/**
	 * initializing class members.
	 * @param x int
	 * @param y int
	 */
	Point(int x,int y){
		this.x = x;
		this.y = x;
	}
	/*Getter for x coordinate*/
	int getX() {
		return this.x;
	}
	/*Getter for y coordinate*/
	int getY() {
		return this.y;
	}
}
