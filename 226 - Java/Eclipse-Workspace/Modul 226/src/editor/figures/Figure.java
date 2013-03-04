package editor.figures;

import java.awt.Graphics;


public abstract class Figure {

	protected Point end1, end2;

	public Figure(Point one, Point two) {
		this.end1 = one;
		this.end2 = two;
	}
	
	public Figure(String representation) {
		String[] values = representation.split(";");
		end1 = new Point(values[0]);
		end2 = new Point(values[1]);
	}
	
	public String toString() {
		return end1.toString()+";"+end2.toString();
	}
	
	
	
	public Figure move(int dx, int dy) {
		end1.move(dx, dy);
		end2.move(dx, dy);
		return this;
	}
	
	
	public abstract void draw(Graphics g);
	
	

}
