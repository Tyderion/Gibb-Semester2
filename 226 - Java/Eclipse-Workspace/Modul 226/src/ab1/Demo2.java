package ab1;

import java.awt.*;
import javax.swing.*;


public class Demo2 extends JFrame {
	public Demo2() {
		super("Ein erstes Beispiel");
		Icon icon = new ImageIcon(getClass().getResource("duke.gif"));
		JLabel label = new JLabel("Viel Erfolg mit dem Grundkurs Java", icon,
				JLabel.CENTER);
		add(label);
		Font schrift = new Font("SansSerif", Font.BOLD, 20);
		label.setFont(schrift);
		label.setForeground(Color.red);
		label.setBackground(Color.white);
		label.setOpaque(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);	
		setVisible(true);
	}

	public static void main(String[] args) {
		new Demo2();
	}
}
