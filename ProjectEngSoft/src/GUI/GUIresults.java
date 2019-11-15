package GUI;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;

public class GUIresults extends JPanel {
	private GUIprojectPresentation frame;
	/**
	 * Create the panel.
	 */
	public GUIresults(GUIprojectPresentation frame) {
		setBackground(new Color(240, 248, 255));
		this.frame = frame;
		setLayout(null);
		setBounds(100, 100, 600, 500);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(122, 75, 122, 39);
		add(comboBox);
		
		JButton btnStartFindingErrors = new JButton("Start finding errors");
		btnStartFindingErrors.setFont(new Font("Dubai", Font.BOLD, 15));
		btnStartFindingErrors.setBounds(304, 75, 159, 39);
		add(btnStartFindingErrors);
		
		JLabel lblErrorCounter = new JLabel("Error counter:");
		lblErrorCounter.setFont(new Font("Dubai", Font.PLAIN, 25));
		lblErrorCounter.setBounds(140, 138, 220, 43);
		add(lblErrorCounter);
		
		JList list = new JList();
		list.setBounds(74, 220, 457, 191);
		add(list);

	}
}
