package ab5;

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

}
