package ab5;

public class Rectangle extends Figure {

	public Rectangle(Point one, Point two) {
		super(one, two);
	}
	
	public Rectangle(String representation) {
		super(representation.split(":")[1]);
	}
	
	
	public String toString() {
		return "Rectangle:"+super.toString();
	}

}
