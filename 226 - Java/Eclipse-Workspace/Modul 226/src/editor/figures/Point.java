package editor.figures;

public class Point {
	protected int x, y;
	
	
	public Point() {
		this.x = 0; 
		this.y = 0;
	}
	
	public Point(Point other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point move(int dx, int dy) {
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
		x = Integer.parseInt(values[0]);
		y = Integer.parseInt(values[1]);
	}
	
	
}
