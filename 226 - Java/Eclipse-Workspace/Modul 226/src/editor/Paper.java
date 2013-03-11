package editor;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import editor.figures.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Papier ist eine von JPanel abgeleitete Swing-Komponente. - Sie dient als
 * "Zeichenblatt" für Zeichnungen. - Sie speichert die Zeichnung in einer
 * Instanzvariablen. - Sie überschreibt die Methode paintComponent der Klasse
 * JPanel so, dass bei ihrem Aufruf die Zeichnung auf das Papier gezeichnet
 * wird.
 * 
 * @author Andres Scheidegger
 */
public class Paper extends JPanel {

	/**
	 * Die Zeichnung.
	 */
	private Drawing drawing;
	private int x, y;
	private DrawingModes mode = DrawingModes.Rectangle;
	private Paper _this;
	
	
	public Paper() {
		_this = this;
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// Bestimmen Breite und Hoehe des neuen Rechtecks
				int breite = e.getX() - x;
				int hoehe = e.getY() - y;
				Figure figure = null;
				Point first = new Point(x,y);
				Point second = new Point(x+breite, y + hoehe);
				switch(mode) {
				case Rectangle:
					first = new Point(Math.min(x, x + breite), Math.min(y, y + hoehe));
					second = new Point(Math.max(x, x + breite),Math.max(y, y + hoehe));
					figure = new Rectangle(first, second);
					break;
				case Circle:
					figure = new Circle(first, (int)Math.sqrt(breite*breite + hoehe*hoehe) );
					break;
				case Line:
					figure = new Line(first, second);
					break;
				case Label:
					String info = JOptionPane.showInputDialog(_this,"Enter Label");
					if (info != null) figure = new Label(first, info);
					break;  
				}
				if (figure != null) drawing.add(figure);
				_this.repaint();
			}
		});
	}

	/**
	 * Die Methode paintComponent zeichnet die Zeichnung auf das Papier. Sie
	 * erhält dazu ein Graphics-Objekt, welches sie an die Zeichnung weitergibt.
	 * 
	 * @param g
	 *            Graphics-Objekt, welches zum zeichnen verwendet werden soll.
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		repaint();
		if (drawing != null) {
			drawing.draw(g);
		}
	}

	/**
	 * Setter für die Instanzvariable zeichnung.
	 * 
	 * @param zeichnung
	 *            Die zu zeichnende Zeichnung.
	 */
	public void setDrawing(Drawing zeichnung) {
		this.drawing = zeichnung;
	}
	
	
	public void setMode(DrawingModes mode) {
		this.mode = mode;
	}
}
