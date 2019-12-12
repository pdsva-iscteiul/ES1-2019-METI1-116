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
		setBackground(new Color(240, 248, 255));
		this.frame = frame;
		setBounds(100, 100, 600, 500);
		JButton btnMakeNewRule = new JButton("Make a rule");
		btnMakeNewRule.setBounds(130, 146, 352, 67);
		btnMakeNewRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.swapTomakeRule();
			}
		});
		setLayout(null);
		btnMakeNewRule.setFont(new Font("Dubai", Font.PLAIN, 27));
		add(btnMakeNewRule);

		JLabel label = new JLabel("MENU");
		label.setBounds(217, 26, 157, 96);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dubai", Font.BOLD, 56));
		add(label);

		JButton btnShowResults = new JButton("Show results");
		btnShowResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.swapToResults();
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(frame,
						 	 "You dont have an excle file loaded, please chose a excle file first",
							  "Missing excle file",
						    JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnShowResults.setBounds(130, 338, 352, 67);
		btnShowResults.setFont(new Font("Dubai", Font.PLAIN, 27));
		add(btnShowResults);
		
		JButton btnChangeExcelFile = new JButton("Change excel file");
		btnChangeExcelFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.swapToexcel();
			}
		});
		btnChangeExcelFile.setFont(new Font("Dubai", Font.PLAIN, 27));
		btnChangeExcelFile.setBounds(130, 243, 352, 67);
		add(btnChangeExcelFile);

	}
}
