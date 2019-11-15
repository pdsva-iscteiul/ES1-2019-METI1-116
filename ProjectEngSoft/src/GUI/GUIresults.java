package GUI;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GUIresults extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUIresults() {
		setLayout(null);
		setBounds(100, 100, 600, 500);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 102, 93, 23);
		add(comboBox);
		
		JButton button = new JButton("Start finding erros");
		button.setBounds(385, 102, 119, 23);
		add(button);

	}

}
