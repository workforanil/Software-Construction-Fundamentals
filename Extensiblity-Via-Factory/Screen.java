package extensibalFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Screen {
	/*Stores all shapes created on screen.*/
	private Map<Shape,List<Double>> shapesOnScreen = new HashMap<>();
	
	/*template list for passing dimensions while creating objects.*/
	private List<Integer> dimensions = new ArrayList<>(); 
	
	/*template map for stores shapes created on screen on sorting based*/
	private Map<Double,Shape> sortBasedOnAnything = new TreeMap<>(); 
	
	/**
	 * Method to get all shapes present on screen.
	 * @return List<Shape>
	 */
	public List<Shape> getShapesOnScreen(){
		List<Shape> screenShapes = new ArrayList<>(); // new List
		for(Map.Entry<Shape, List<Double>> e : shapesOnScreen.entrySet()) { // iterating on shapesOnScreen map.
			screenShapes.add(e.getKey()); // add Shape to new list
		}
		return screenShapes; // returning new list.
	}
	
	/**
	 * method to add square on screen.
	 * @param p Point of origin of square.
	 * @param length int
	 * @return boolean. is created or not.
	 */
	public boolean addSquare(Point p,int length) {
		ShapeType square = ShapeType.SQUARE; // initializing shape type with square
		
		dimensions.clear(); // clearing dimension list.
		dimensions.add(length); // add length to dimension list.
		
		Shape toBeAdd = Factory.createShape(square, p, dimensions); //creating square shape from factory class.
		
		shapesOnScreen.put(toBeAdd,addToMapList(toBeAdd,p)); // adding to the shapesOnScreen map.
		return true;
	}
	
	/**
	 * method to add rectangle on screen.
	 * @param p Point of origin of rectangle.
	 * @param length int
	 * @param breadth int
	 * @return boolean.
	 */
	public boolean addRectangle(Point p,int length, int breadth) {
		ShapeType rectangle = ShapeType.RECTANGLE; // initializing shape type with rectangle
		
		dimensions.clear(); // clearing dimension list.
		dimensions.addAll(Arrays.asList(length,breadth)); // add length and breadth to dimension list.
		
		Shape toBeAdd = Factory.createShape(rectangle, p, dimensions); //creating rectangle shape from factory class.
		
		shapesOnScreen.put(toBeAdd,addToMapList(toBeAdd,p)); // adding to the shapesOnScreen map.
		return true;
	}
	
	/**
	 * method to add triangle on screen.
	 * @param p Point of origin of triangle.
	 * @param height int
	 * @param base int
	 * @return boolean
	 */
	public boolean addTriangle(Point p,int height, int base) {
		ShapeType triangle = ShapeType.TRIANGLE; // initializing shape type with triangle
		
		dimensions.clear(); // clearing dimension list.
		dimensions.addAll(Arrays.asList(height,base)); //add height and base to dimension list.
		
		Shape toBeAdd = Factory.createShape(triangle, p, dimensions); //creating triangle shape from factory class.
		
		shapesOnScreen.put(toBeAdd,addToMapList(toBeAdd,p)); // adding to the shapesOnScreen map.
		return true;
	}
	
	/**
	 * method to add circle shape on screen.
	 * @param p Point of origin.
	 * @param radius int
	 * @return boolean.
	 */
	public boolean addCircle(Point p,int radius) {
		ShapeType circle = ShapeType.CIRCLE; // initializing shape type with circle
		
		dimensions.clear(); // clearing dimension list.
		dimensions.addAll(Arrays.asList(radius)); //add radius to dimension list.
		
		Shape toBeAdd = Factory.createShape(circle, p, dimensions); //creating Circle shape from factory class.
		
		shapesOnScreen.put(toBeAdd,addToMapList(toBeAdd,p)); // adding to the shapesOnScreen map.
		return true;
	}
	
	/**
	 * method sorts shape object according to their area.
	 * @return Map<Double,Shape>-key=area and value = shape.
	 */
	public Map<Double,Shape> sortBaseOnArea() {
		sortBasedOnAnything.clear(); // clearing sortBasedAnything.
		for(Map.Entry<Shape, List<Double>> e : shapesOnScreen.entrySet()) { // iterating shapesOnScreen.
			sortBasedOnAnything.put(e.getValue().get(0), e.getKey()); // putting area and shape in sortBasedOnAnything.
		}
		return sortBasedOnAnything;
	}
	
	/**
	 * method sorts shape object according to their perimeter.
	 * @return Map<Double,Shape>-key=perimeter and value = shape.
	 */
	public Map<Double, Shape> sortBaseOnPerimeter(){
		sortBasedOnAnything.clear(); // clearing sortBasedAnything.
		for(Map.Entry<Shape, List<Double>> e : shapesOnScreen.entrySet()) { // iterating shapesOnScreen.
			sortBasedOnAnything.put(e.getValue().get(1), e.getKey()); // putting perimeter and shape in sortBasedOnAnything.
		}
		return sortBasedOnAnything;
	}
	
	/**
	 * method sorts shape objects according to their origin distance.
	 * @returnMap<Double,Shape> - key=distance and value = shape.
	 */
	public Map<Double, Shape> sortBaseOnOrigin(){
		sortBasedOnAnything.clear(); // clearing sortBasedAnything.
		for(Map.Entry<Shape, List<Double>> e : shapesOnScreen.entrySet()) { // iterating shapesOnScreen.
			sortBasedOnAnything.put(e.getValue().get(2), e.getKey());// putting origin dist and shape in sortBasedOnAnything.
		}
		return sortBasedOnAnything;
	}
	
	/**
	 * method sorts shape object according to their creation time.
	 * @return Map<Double,Shape> - key=time and value = shape.
	 */
	public Map<Double, Shape> sortBaseOnTimestamp(){
		sortBasedOnAnything.clear(); // clearing sortBasedAnything.
		for(Map.Entry<Shape, List<Double>> e : shapesOnScreen.entrySet()) {// iterating shapesOnScreen.
			sortBasedOnAnything.put((e.getValue().get(3)), e.getKey());// putting time and shape in sortBasedOnAnything.
		}
		return sortBasedOnAnything;
	}
	
	/**
	 * method deletes first shape type object on screen.
	 * @param st ShapeType
	 * @return boolean.
	 */
	public boolean deleteSpecificShape(ShapeType st) {
		Iterator<Entry<Shape,List<Double>>> itMap = shapesOnScreen.entrySet().iterator(); // iterator for shapeOnScreen map.
		while(itMap.hasNext()) {
			Entry<Shape, List<Double>> entry = itMap.next(); // Type we are accessing is entry map.
			if(entry.getKey().getShapeType() == st) {
				itMap.remove(); // remove that entry map.
				break;
			}
		}
		return true;
	}
	
	/**
	 * method deletes all specific shape from the screen.
	 * @param st ShapeType
	 * @return boolean.
	 */
	public boolean deleteAllSpecificShape(ShapeType st) {
		Iterator<Entry<Shape,List<Double>>> itMap = shapesOnScreen.entrySet().iterator(); // iterator for shapeOnScreen map.
		while(itMap.hasNext()) {
			Entry<Shape, List<Double>> entry = itMap.next(); // Type we are accessing is entry map.
			if(entry.getKey().getShapeType() == st) {
				itMap.remove();
			}
		}
		return true;
	}
	
	/**
	 * method will find all shapes which enclosing a point.
	 * @param p Point 
	 * @return List<Shape>
	 */
	public List<Shape> getAllShapeEnclosingPoint(Point p){
		List<Shape> enclosingShape = new ArrayList<>(); // creating new list of shape.
		for(Map.Entry<Shape, List<Double>> e : shapesOnScreen.entrySet()) { // iterating on shapesOnScreen.
			if(e.getKey().isPointEnclosed(p)) { // checking point is enclosed by shape object.
				enclosingShape.add(e.getKey()); // adding to the list.
			}
		}
		return enclosingShape;
	}
	
	/**
	 * template method to make list of arguments.
	 * @param toBeAdd Shape
	 * @param p Point
	 * @return List<Double>
	 */
	public List<Double> addToMapList(Shape toBeAdd, Point p) {
		List<Double> mapList = new ArrayList<>(); // creating list.
		mapList.add(toBeAdd.getArea()); // adding area of object.
		mapList.add(toBeAdd.getPerimeter()); // adding perimeter of object.
		mapList.add(Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2))); // adding distance of object from screen origin.
		mapList.add(toBeAdd.getTime()); // adding time of creation of shape object.
		return mapList;
	}
}
