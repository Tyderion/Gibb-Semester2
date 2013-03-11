package editor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * Die Klasse Zeichenbrett ermöglicht die Darstellung von Zeichnungen.
 * Sie öffnet ein Fenster auf dem Desktop, welches als einzige Komponente
 * ein Papierobjekt enthält.
 * 
 * @author Andres Scheidegger
 */
public class DrawingBoard extends JFrame{

	/**
	 * Das Papier, auf welchem gezeichnet wird.
	 */
	private Paper papier = new Paper();
	
	/**
	 * Konstruktor.
	 * Setzt den Titel, Ort, Grösse und Verhalten beim Schliessen
	 * des Zeichenbretts. Fügt das Papierobjekt in das Zeichnbrett ein. 
	 * Zeigt das Zeichenbrett auf dem Desktop an.
	 */
	public DrawingBoard() {
		super("Zeichenbrett für Figuren");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocation(200, 200);
		setContentPane(papier);
		setVisible(true);
//		addKeyListener(papier);
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) {
				case 'r':
					papier.setMode(DrawingModes.Rectangle);
					break;
				case 's':
					papier.setMode(DrawingModes.Label);
					break;
				case 'l':
					papier.setMode(DrawingModes.Line);

					break;
				case 'c':
				case 'k':
					papier.setMode(DrawingModes.Circle);
					break;
				}
			}
		});
	}
	
	/**
	 * Zeigt eine Zeichnung auf dem Zeichenbrett an, indem die Zeichnung
	 * auf das Papier "gesetzt" wird.
	 * 
	 * @param figur Das zu zeigende Figurobjekt.
	 */
	public void draw(Drawing drawing) {
		papier.setDrawing(drawing);
		// Aufruf von repaint() bewirkt, dass das Fenster des Zeichenbrett
		// auf dem Dektop neu aufgebaut wird.
		repaint();
	}
}
