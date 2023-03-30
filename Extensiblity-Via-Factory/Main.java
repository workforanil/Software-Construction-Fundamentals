package extensibalFactory;

import java.util.Iterator;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		/*Creating a screen*/
		Screen newScreen = new Screen();
		/* Adding shapes to the screen*/
		newScreen.addCircle(new Point(1,2), 1);
		newScreen.addRectangle(new Point(2,1), 1, 2);
		newScreen.addSquare(new Point(4,2), 4);
		newScreen.addTriangle(new Point(4,3), 3, 3);
		newScreen.addTriangle(new Point(5,2), 4, 2);
		newScreen.addCircle(new Point(3,2), 4);
		
		Iterator<Shape> itList = newScreen.getShapesOnScreen().iterator(); // resusable iterator on newScreen shape.
		/* Display all shapes on screen with there area, perimeter, origin distance.*/
		while(itList.hasNext()) {
			Shape s = itList.next();
			System.out.println(s.getShapeType() 
					+ " Area:" + s.getArea() 
					+ " Perimeter:" + s.getPerimeter()
					+ " Origin: (" + s.getOrigin().getX() + "," + s.getOrigin().getY() + ")");
		}
		/* Displaying all shapes sorted based on area.*/
		System.out.println("\nSort Based on Area: \n");
		for(Map.Entry<Double, Shape> e : newScreen.sortBaseOnArea().entrySet()) {
			System.out.println(e.getValue().getShapeType() + " " + e.getKey());
		}
		/* Displaying all shapes sorted based on Perimeter.*/
		System.out.println("\nSort Based on Perimeter: \n");
		for(Map.Entry<Double, Shape> e : newScreen.sortBaseOnPerimeter().entrySet()) {
			System.out.println(e.getValue().getShapeType() + " " + e.getKey());
		}
		/* Displaying all shapes sorted based on Origin.*/
		System.out.println("\nSort Based on Origin: \n");
		for(Map.Entry<Double, Shape> e : newScreen.sortBaseOnOrigin().entrySet()) {
			System.out.println(e.getValue().getShapeType() + " " + e.getKey());
		}
		/* Displaying all shapes sorted based on Timestamp.*/
		System.out.println("\nSort Based on Timestamp: \n");
		for(Map.Entry<Double, Shape> e : newScreen.sortBaseOnTimestamp().entrySet()) {
			System.out.println(e.getValue().getShapeType() + " " + e.getKey());
		}
		
		/*Displaying all shapes after deleting a specfic type of shape*/
		System.out.println("\nShapes After deleting a specific type of Shape: \n");
		System.out.println("Circle: "+newScreen.deleteSpecificShape(ShapeType.CIRCLE));
		itList = newScreen.getShapesOnScreen().iterator();
		while(itList.hasNext()) {
			System.out.println(itList.next().getShapeType());
		}
		/*Displaying all shapes after deleting all specfic type of shape*/
		System.out.println("\nShapes After deleting all specific type of Shape: \n");
		System.out.println("Triangles: "+newScreen.deleteAllSpecificShape(ShapeType.TRIANGLE));
		itList = newScreen.getShapesOnScreen().iterator();
		while(itList.hasNext()) {
			System.out.println(itList.next().getShapeType());
		}
		/*Displaying which shapes enclosing a point*/
		System.out.println("\nShapes which enclosing a point: \n");
		itList = newScreen.getAllShapeEnclosingPoint(new Point(5,3)).iterator();
		while(itList.hasNext()) {
			System.out.println(itList.next().getShapeType());
		}
	}

}
