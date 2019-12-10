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
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class GUImakeRule extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private GUIprojectPresentation frame;
	/**
	 * Create the panel.
	 */
	public GUImakeRule(GUIprojectPresentation frame) {
		setBackground(new Color(240, 248, 255));
		this.frame= frame;
		
		setLayout(null);
		JLabel lblMakeYourRule = new JLabel("Make your rule by fiiling the following fields according:");
		lblMakeYourRule.setFont(new Font("Dubai", Font.BOLD, 20));
		lblMakeYourRule.setBounds(32, 26, 528, 66);
		add(lblMakeYourRule);
		
		JLabel lblMetrics = new JLabel("Metrics:");
		lblMetrics.setFont(new Font("Dubai", Font.PLAIN, 24));
		lblMetrics.setBounds(57, 132, 86, 34);
		add(lblMetrics);
		
		JLabel lblLimits = new JLabel("Limits:");
		lblLimits.setFont(new Font("Dubai", Font.PLAIN, 24));
		lblLimits.setBounds(54, 195, 68, 34);
		add(lblLimits);
		
		JLabel lblLogicalOperator = new JLabel("Logical operator:");
		lblLogicalOperator.setFont(new Font("Dubai", Font.PLAIN, 24));
		lblLogicalOperator.setBounds(57, 258, 163, 34);
		add(lblLogicalOperator);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 200, 68, 29);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"=", ">", "<"}));
		comboBox.setBounds(258, 258, 68, 31);
		add(comboBox);
		
		JButton btnDone = new JButton("Save");
		btnDone.setFont(new Font("Dubai", Font.BOLD, 18));
		btnDone.setBackground(new Color(211, 211, 211));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pop_up p = new Pop_up();
				p.setVisible(true);
				p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnDone.setBounds(377, 342, 96, 35);
		add(btnDone);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"LOC", "CYCLO", "ATFD", "LAA"}));
		comboBox_1.setBounds(258, 135, 68, 31);
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(57, 343, 289, 33);
		add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newText = textField.getText() + " " + comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
				textField.setText(newText);
			}
		});
		btnAdd.setFont(new Font("Dubai", Font.PLAIN, 14));
		btnAdd.setBounds(362, 135, 62, 34);
		add(btnAdd);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newText = textField.getText() + " " + textField_1.getText();
				textField.setText(newText);
			}
		});
		button.setFont(new Font("Dubai", Font.PLAIN, 14));
		button.setBounds(362, 195, 62, 32);
		add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newText = textField.getText() + " " + comboBox.getItemAt(comboBox.getSelectedIndex());
				textField.setText(newText);
			}
		});
		button_1.setFont(new Font("Dubai", Font.PLAIN, 14));
		button_1.setBounds(362, 258, 62, 32);
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
					frame.swapToMenu();
					//TODO dispose makerule
				}
			});
			
			JLabel lblRuleName = new JLabel("Rule name:");
			lblRuleName.setBounds(53, 25, 60, 23);
			contentPane.add(lblRuleName);
		}

	}
}
