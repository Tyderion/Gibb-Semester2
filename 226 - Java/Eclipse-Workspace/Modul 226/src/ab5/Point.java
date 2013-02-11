package ab5;

public class Point {
	protected double x, y;
	
	public Point(Point other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point move(double dx, double dy) {
		x += dx;
		y += dy;
		return this;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public Point (String representation) {
//		String test = representation.substring(1, representation.length()-2);
		String[] values = representation.substring(1, representation.length()-1).split(",");
		x = Double.parseDouble(values[0]);
		y = Double.parseDouble(values[1]);
	}
	
	
}
