package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class GUImakeRule extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public GUImakeRule() {
		setLayout(null);
		
		JLabel lblMakeYourRule = new JLabel("Make your rule by fiiling the following fields according:");
		lblMakeYourRule.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMakeYourRule.setBounds(10, 23, 430, 66);
		add(lblMakeYourRule);
		
		JLabel lblMetrics = new JLabel("Metrics:");
		lblMetrics.setBounds(57, 111, 49, 14);
		add(lblMetrics);
		
		JLabel lblLimits = new JLabel("Limits:");
		lblLimits.setBounds(57, 155, 49, 14);
		add(lblLimits);
		
		JLabel lblLogicalOperator = new JLabel("Logical operator:");
		lblLogicalOperator.setBounds(42, 217, 107, 14);
		add(lblLogicalOperator);
		
		textField = new JTextField();
		textField.setBounds(119, 108, 49, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 152, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 213, 68, 22);
		add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(178, 108, 49, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(243, 108, 49, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(306, 108, 49, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(332, 266, 89, 23);
		add(btnDone);

	}
}
