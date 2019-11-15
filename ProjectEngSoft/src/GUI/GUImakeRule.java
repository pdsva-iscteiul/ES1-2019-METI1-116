package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUImakeRule extends JPanel {
	private JTextField textField_1;
	private JTextField textField;

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
		lblLogicalOperator.setBounds(42, 195, 107, 14);
		add(lblLogicalOperator);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 152, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 191, 68, 22);
		add(comboBox);
		
		JButton btnDone = new JButton("Save");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pop_up p = new Pop_up();
				p.setVisible(true);
				p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDone.setBounds(328, 252, 89, 23);
		add(btnDone);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(116, 108, 68, 22);
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(33, 253, 285, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(220, 107, 62, 23);
		add(btnAdd);
		
		JButton button = new JButton("Add");
		button.setBounds(230, 151, 62, 23);
		add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.setBounds(240, 191, 62, 23);
		add(button_1);

	}
	private class Pop_up extends JFrame {

		private JPanel contentPane;
		private JTextField textField;

		public Pop_up() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 423, 128);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(147, 25, 206, 23);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JButton btnOk = new JButton("OK");
			btnOk.setBounds(147, 55, 89, 23);
			contentPane.add(btnOk);
			btnOk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					//TODO dispose makerule
				}
			});
			
			JLabel lblRuleName = new JLabel("Rule name:");
			lblRuleName.setBounds(53, 25, 60, 23);
			contentPane.add(lblRuleName);
		}

	}
}
