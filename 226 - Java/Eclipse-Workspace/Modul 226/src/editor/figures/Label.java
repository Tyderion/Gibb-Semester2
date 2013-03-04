package editor.figures;

import java.awt.Graphics;

public class Label extends Figure {
	
	private String text;
	
	public Label(Point pos,String text) {
		super(pos, new Point());
		this.text = text;
	}
	public Label(String representation) {
		super(representation.split(":")[1].split("_/")[0]);
		this.text = representation.split(":")[1].split("_/")[1];
	}

	@Override
	public void draw(Graphics g) {
		g.drawChars(text.toCharArray(), 0, text.length(), end1.x, end1.y);
	}
	
	
	public String toString() {
		return "Label:"+super.toString()+"_/"+this.text;
	}

}
