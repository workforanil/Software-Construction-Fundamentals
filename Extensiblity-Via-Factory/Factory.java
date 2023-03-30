package extensibalFactory;

import java.util.List;

public class Factory {
	/**
	 * Method for create different types of shapes.
	 * @param st ShapeType(Square,Rectangle,Triangle,Circle)
	 * @param p Point of shape origin.
	 * @param list list of dimensions (length and breadth, radius)
	 * @return Shape object-Type Shape.
	 */
	public static Shape createShape(ShapeType st,Point p,List<Integer> list) {
		/*creating and returning shapes according ShapeType*/
		if(st == ShapeType.SQUARE) {
			return new Square(p,list.get(0));
		}else if(st == ShapeType.RECTANGLE) {
			return new Rectangle(p,list.get(0),list.get(1));
		}else if(st == ShapeType.TRIANGLE) {
			return new Triangle(p,list.get(0),list.get(1));
		}else if(st == ShapeType.CIRCLE) {
			return new Circle(p,list.get(0));
		}
		return null;
	}
}
