package ab5;

import utils.InputReader;

public class TestFigures {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Circle c = new Circle(new Point(0,0), 5);
		Rectangle r = new Rectangle(new Point(0,0), new Point(7,19));
		Line l = new Line(new Point(0,0), new Point(17,2.5));
		Figure s1 = r;
		Figure s2 = new Circle(new Point(0,0), 5);
		Figure s3 = l;
		FigureHandler handler = new FigureHandler("Figures.txt");
		handler.add(new Circle(new Point(0,0), 5));
		handler.add(new Rectangle(new Point(0,0), new Point(7,19)));
		handler.add(new Line(new Point(0,0), new Point(17,2.5)));
		handler.add(new Figure(new Point(0,-5), new Point(10,2.5)));
		handler.save();
		
		FigureHandler second = new FigureHandler("Figures.txt");
		second.load();
		System.out.println(second.toString().equals(handler.toString()));
	}
}
