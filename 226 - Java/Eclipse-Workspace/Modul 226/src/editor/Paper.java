package editor;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Papier ist eine von JPanel abgeleitete Swing-Komponente.
 * - Sie dient als "Zeichenblatt" für Zeichnungen.
 * - Sie speichert die Zeichnung in einer Instanzvariablen.
 * - Sie überschreibt die Methode paintComponent der Klasse JPanel
 *   so, dass bei ihrem Aufruf die Zeichnung auf das Papier gezeichnet
 *   wird.
 * 
 * @author Andres Scheidegger
 */
public class Paper extends JPanel {
	
	/**
	 * Die Zeichnung.
	 */
	private Drawing drawing;
	
	/**
	 * Die Methode paintComponent zeichnet die Zeichnung auf das Papier.
	 * Sie erhält dazu ein Graphics-Objekt, welches sie an die Zeichnung
	 * weitergibt.
	 * 
	 * @param g  Graphics-Objekt, welches zum zeichnen verwendet werden soll.
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		if (drawing != null) {
			drawing.draw(g);
		}
	}
	
	/**
	 * Setter für die Instanzvariable zeichnung.
	 * 
	 * @param zeichnung Die zu zeichnende Zeichnung.
	 */
	public void setDrawing(Drawing zeichnung) {
		this.drawing = zeichnung;
	}
}
