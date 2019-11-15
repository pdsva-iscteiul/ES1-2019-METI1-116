package GUI;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class GUIresults extends JPanel {
	private GUIprojectPresentation frame;
	/**
	 * Create the panel.
	 */
	public GUIresults(GUIprojectPresentation frame) {
		this.frame = frame;
		setLayout(null);
		setBounds(100, 100, 600, 500);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(112, 102, 93, 23);
		add(comboBox);
		
		JButton button = new JButton("Start finding erros");
		button.setBounds(385, 102, 119, 23);
		add(button);
		
		JLabel lblErrorCounter = new JLabel("Error counter:");
		lblErrorCounter.setBounds(211, 166, 119, 43);
		add(lblErrorCounter);
		
		JList list = new JList();
		list.setBounds(74, 220, 457, 235);
		add(list);

	}
}
