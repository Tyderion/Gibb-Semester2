package editor;

import editor.figures.*;
import utils.InputReader;

public class TestFigures {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle c = new Circle(new Point(0,0), 5);
		Rectangle r = new Rectangle(new Point(0,0), new Point(7,19));
		Line l = new Line(new Point(0,0), new Point(17,2));
		Figure s1 = r;
		Figure s2 = new Circle(new Point(0,0), 5);
		Figure s3 = l;
		FigureHandler handler = new FigureHandler("Figures.txt");
		handler.add(new Circle(new Point(0,0), 5));
		handler.add(new Rectangle(new Point(0,0), new Point(7,19)));
		handler.add(new Rectangle(new Point(150,150), new Point(300,300)));
		handler.add(new Rectangle(new Point(150,150), new Point(500,300)));
		handler.add(new Line(new Point(3,3), new Point(200,250)));
		handler.add(new Label(new Point(200, 380), "Labeltext"));
		handler.save();
		System.out.println(handler.toString());
		FigureHandler second = new FigureHandler("Figures.txt");
		second.load();
		System.out.println();
		System.out.println(second.toString());
		System.out.println(second.toString().equals(handler.toString()));
		
		Drawing d = new Drawing(handler.figures());
		
		DrawingBoard board = new DrawingBoard();
		board.draw(d);
		
	}
}
