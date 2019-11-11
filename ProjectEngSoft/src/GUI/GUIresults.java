package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class GUIresults extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUIresults() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblPopjiogy = new JLabel("popjiogy");
		
		lblPopjiogy.setBounds(85, 185, 49, 14);
		add(lblPopjiogy);

	}
}
