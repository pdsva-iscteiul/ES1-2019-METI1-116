package GUI;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUImenu extends JPanel {
	private GUIprojectPresentation frame; 
	/**
	 * Create the panel.
	 */
	public GUImenu(GUIprojectPresentation frame) {
		this.frame = frame;
		setBounds(100, 100, 600, 500);
		JButton btnMakeNewRule = new JButton("Make new rule");
		btnMakeNewRule.setBounds(196, 127, 193, 55);
		btnMakeNewRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		setLayout(null);
		btnMakeNewRule.setFont(new Font("Dubai", Font.PLAIN, 27));
		add(btnMakeNewRule);

		JLabel label = new JLabel("MENU");
		label.setBounds(219, 33, 157, 96);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dubai", Font.BOLD, 56));
		add(label);

		JButton button_3 = new JButton("Open excel file");
		button_3.setBounds(196, 259, 193, 55);
		button_3.setFont(new Font("Dubai", Font.PLAIN, 20));
		add(button_3);

		JButton button_4 = new JButton("Open excel in GUI");
		button_4.setBounds(196, 193, 193, 55);
		button_4.setFont(new Font("Dubai", Font.PLAIN, 20));
		add(button_4);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 340, 88, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PMD", "IPlasma"})); //TODO add the user rule to the list when it is created
		add(comboBox);

		JButton button = new JButton("Start finding erros");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String selectedRule = (String) comboBox.getSelectedItem();

				int n = 1; //TODO n = number of errors found, i set it to 1 just for testing 

				String[] options = {"Ok!", "Show me the erro list"};
				int result = JOptionPane.showOptionDialog(null, "With the rule "+ selectedRule +" were found " + n + " errors!", "Results",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (result == 0 ) {
					// TODO probably nothing 
				}
				if (result == 1 ) {
					//TODO open the excel file
				}

			}
		});
		button.setBounds(336, 339, 139, 23);
		add(button);

	}
}
