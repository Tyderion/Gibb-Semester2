package editor;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import editor.figures.Figure;

public class Drawing {
	
	List<Figure> figures;
	
	public Drawing(List<Figure> figures) {
		this.figures = figures;
	}
	
	public void draw(Graphics g) {
		for (Figure f : figures) {
			f.draw(g);
		}
	}
	
	public void move(int dx, int dy) {
		for (Figure f : figures) {
			f.move(dx, dy);
		}
	}
	
}
