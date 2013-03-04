package editor.figures;

import java.awt.Graphics;


public class Line extends Figure {
	
	public Line (Point beginning, Point end) {
		super(beginning, end);
	}
	
	public String toString() {
		return "Line:"+super.toString();
	}
	
	public Line(String representation) {
		super(representation.split(":")[1]);
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine((int)end1.x, (int)end1.y,(int) end2.x, (int)end2.y);
	}

}
