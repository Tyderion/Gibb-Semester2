package ab5;

public class Circle extends Figure {
	
	public Circle (Point center, Point edge) {
		super(center, edge);
	}
	
	public Circle (Point center, double radius) {
		this(center, new Point(center).move(radius, 0));
	}
	public Circle(String representation) {
		super(representation.split(":")[1]);
	}
	
	
	public String toString() {
		return "Circle:"+super.toString();
	}
	
	public Point center() {
		return end1;
	}
	
	public Point edge() {
		return end2;
	}
	
	public double radius() {
		return Math.abs(end1.x - end2.x);
	}
//	public Figure move(double dx, double dy) {
//		center().move(dx, dy);
//		edge().move(dx, 0);
//		return this;
//	}
}
