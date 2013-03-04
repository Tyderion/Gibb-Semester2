package editor.figures;

import java.awt.Graphics;


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
	
	public int getHeight() {
		return Math.abs(end1.y-end2.y);
	}
	
	public int getWidth() {
		return Math.abs(end1.x-end2.x);
	}


	@Override
	public void draw(Graphics g) {
		g.drawRect(end1.x, end1.y, getWidth() , getHeight() );
		
	}

}
