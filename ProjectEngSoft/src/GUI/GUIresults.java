package GUI;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIresults extends JPanel {
	private GUIprojectPresentation f; 
	/**
	 * Create the panel.
	 */
	public GUIresults(GUIprojectPresentation f1) {
		this.f = f1;
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(38, 136, 111, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PMD", "IPlasma"})); //TODO add the user rule to the list when it is created
		add(comboBox);
		
		JButton btnStartFindingErros = new JButton("Start finding erros");
		btnStartFindingErros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String selectedRule = (String) comboBox.getSelectedItem();
				
				int n = 1; //TODO n = number of errors found, i set it to 1 just for testing 
				
				String[] options = {"Ok!", "Show me the erro list"};
				int result = JOptionPane.showOptionDialog(null, "with the rule "+ selectedRule +" were found " + n + " errors!", "Results",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if (result == 0 ) {
				// TODO probably nothing 
				}
				if (result == 1 ) {
				//TODO open the excel file
					f.swapToexcel();
				}
				
			}
		});
		btnStartFindingErros.setBounds(250, 135, 149, 23);
		add(btnStartFindingErros);

	}
	
}
