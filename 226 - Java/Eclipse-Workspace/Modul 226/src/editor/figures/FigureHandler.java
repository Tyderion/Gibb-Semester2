package editor.figures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FigureHandler {
	
	private List<Figure> figures;
	private String path;
	
	
	public FigureHandler(String filepath) {
		this.figures = new ArrayList<Figure>();
		this.path = filepath;
	}
	
	public FigureHandler(List<Figure> figures, String filepath) {
		this.figures = figures;
		path = filepath;
	}
	
	public List<Figure> figures() {
		return this.figures;
	}
	
	public Figure getFigure(int index) {
		return figures.get(index);
	}
	public void add(Figure f) {
		figures.add(f);
	}
	
	public String toString() {
		String save = "";
		for (int i = 0; i< figures.size(); i++) {
			save += figures.get(i).toString()+"\n";
		}
		return save;
	}

	
	public void save() {
		try 
		 {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			out.write(toString());
			out.close();
		 }catch (IOException e) {
			 e.printStackTrace();
		 }
	};
	
	public void load() {
		figures = new ArrayList<Figure>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			String str = "";
			while ((str = in.readLine()) != null) {
				if (str.startsWith("Rectangle") ) {
					figures.add(new Rectangle(str));
				}
				else if (str.startsWith("Circle") ) {
					figures.add(new Circle(str));
				}
				else if (str.startsWith("Line") ) {
					figures.add(new Line(str));
				}	else if (str.startsWith("Label") ) {
					figures.add(new Label(str));
				} //else {
//					figures.add(new Figure(str));
//				}
			}
//			objs_list.add(in.readLine().split(","));
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	};

}
