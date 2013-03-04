package editor.figures;

import java.awt.Graphics;


public class Circle extends Figure {
	
	public Circle (Point center, Point edge) {
		super(center, edge);
	}
	
	public Circle (Point center, int radius) {
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

	@Override
	public void draw(Graphics g) {
		g.drawOval((int)end1.x, (int) end2.y,(int)( 2*radius()),(int) (2*radius()));
	}
}
