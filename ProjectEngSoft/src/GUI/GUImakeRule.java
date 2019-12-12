package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import AuxPackage.Rule;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;

public class GUImakeRule extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private GUIprojectPresentation frame;
	private Tracker tracker=Tracker.Metrics;
	private String selectedType = "is_long_method";
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
		lblLimits.setBounds(57, 258, 68, 34);
		add(lblLimits);

		JLabel lblLogicalOperator = new JLabel("Logical operator:");
		lblLogicalOperator.setFont(new Font("Dubai", Font.PLAIN, 24));
		lblLogicalOperator.setBounds(57, 194, 163, 34);
		add(lblLogicalOperator);

		textField_1 = new JTextField();
		textField_1.setBounds(258, 258, 68, 29);
		add(textField_1);
		textField_1.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"=", ">", "<"}));
		comboBox.setBounds(258, 198, 68, 31);
		add(comboBox);



		JButton btnDone = new JButton("Save");
		btnDone.setFont(new Font("Dubai", Font.BOLD, 18));
		btnDone.setBackground(new Color(211, 211, 211));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tracker == Tracker.Operators) {
					Pop_up p = new Pop_up();
					p.setVisible(true);
					p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					JOptionPane.showMessageDialog(frame,
							"Please finish your rule",
							"Invalid Rule",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDone.setBounds(379, 359, 96, 35);
		add(btnDone);

		JComboBox comboBox_1 = new JComboBox();
		String[] long_method={"LOC", "CYCLO"}; 
		String[] featureEnvy={"ATFD", "LAA"}; 
		comboBox_1.setModel(new DefaultComboBoxModel(long_method));
		comboBox_1.setBounds(258, 135, 68, 31);
		add(comboBox_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Long_method",true);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setModel(new DefaultComboBoxModel(long_method));
				selectedType = "is_long_method";
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(52, 84, 109, 27);
		add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(240, 248, 255));

		JRadioButton rdbtnFeatureEnvy = new JRadioButton("Feature envy");
		rdbtnFeatureEnvy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setModel(new DefaultComboBoxModel(featureEnvy));
				selectedType = "is_feature_envy";
			}
		});
		buttonGroup.add(rdbtnFeatureEnvy);
		rdbtnFeatureEnvy.setBounds(282, 84, 109, 27);
		add(rdbtnFeatureEnvy);
		rdbtnFeatureEnvy.setBackground(new Color(240, 248, 255));


		JButton btnKj = new JButton("<<<");
		btnKj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.swapToMenu();
			}
		});
		btnKj.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKj.setBackground(Color.LIGHT_GRAY);
		btnKj.setBounds(10, 11, 68, 31);
		add(btnKj);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(57, 361, 289, 33);
		add(textField);
		textField.setColumns(10);


		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tracker == Tracker.Metrics) {
					String newText = textField.getText() + " ( " + comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
					textField.setText(newText);
					comboBox_1.setEnabled(false);
					tracker=Tracker.Logical;
				}else {
					JOptionPane.showMessageDialog(frame,
							"you are expected to add a "+tracker.meaning,
							"Invalid command",
							JOptionPane.ERROR_MESSAGE);
				}
				rdbtnFeatureEnvy.setEnabled(false);
				rdbtnNewRadioButton.setEnabled(false);
			}
		});
		btnAdd.setFont(new Font("Dubai", Font.PLAIN, 14));
		btnAdd.setBounds(362, 135, 62, 34);
		add(btnAdd);

		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double.parseDouble(textField_1.getText());
				}catch(Exception exception) {
					JOptionPane.showMessageDialog(frame,
							"You have to insert an Double",
							"Invalid input",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Double.parseDouble(textField_1.getText())>=0) {
					if(tracker==Tracker.Limits) {
						String newText = textField.getText() + " " + textField_1.getText() + " ) ";
						System.out.println(comboBox_1.getSelectedItem().toString());
						System.out.println(Double.parseDouble(textField_1.getText()));
						System.out.println(comboBox_1.getSelectedItem().toString()=="LAA");
						System.out.println(Double.parseDouble(textField_1.getText())<=1.0);
						System.out.println(Double.parseDouble(textField_1.getText())>=0);
						if(!(comboBox_1.getSelectedItem().toString()=="LAA") || (Double.parseDouble(textField_1.getText())<=1.0 && Double.parseDouble(textField_1.getText())>=0)) {
							textField.setText(newText);
							comboBox_1.setEnabled(true);
							tracker=Tracker.Operators;
						}else {
							JOptionPane.showMessageDialog(frame,
									"You have to insert a Double between 0 and 1",
									"Invalid input",
									JOptionPane.ERROR_MESSAGE);

						}
					}else {
						JOptionPane.showMessageDialog(frame,
								"You are expected to add a "+tracker.meaning,
								"Invalid command",
								JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(frame,
							"You have to insert a positive value",
							"Invalid input",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		button.setFont(new Font("Dubai", Font.PLAIN, 14));
		button.setBounds(362, 256, 62, 32);
		add(button);

		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tracker==Tracker.Logical) {
					String newText = textField.getText() + " " + comboBox.getItemAt(comboBox.getSelectedIndex());
					textField.setText(newText);
					tracker=Tracker.Limits;
				}else {
					JOptionPane.showMessageDialog(frame,
							"you are expected to add a "+tracker.meaning,
							"Invalid command",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_1.setFont(new Font("Dubai", Font.PLAIN, 14));
		button_1.setBounds(362, 198, 62, 32);
		add(button_1);

		JLabel lblLogicalOperators = new JLabel("Logical operators:");
		lblLogicalOperators.setFont(new Font("Dubai", Font.PLAIN, 24));
		lblLogicalOperators.setBounds(57, 314, 191, 34);
		add(lblLogicalOperators);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"AND", "OR"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_2.setBounds(258, 313, 68, 31);
		add(comboBox_2);

		JButton button_2 = new JButton("Add");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tracker==Tracker.Operators) {
					String newText = textField.getText() + " " + comboBox_2.getItemAt(comboBox_2.getSelectedIndex())+ " ";
					textField.setText(newText);
					tracker=Tracker.Metrics;
				}else {
					JOptionPane.showMessageDialog(frame,
							"you are expected to add a "+tracker.meaning,
							"Invalid command",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		button_2.setFont(new Font("Dubai", Font.PLAIN, 14));
		button_2.setBounds(362, 312, 62, 32);
		add(button_2);


	}
	private class Pop_up extends JFrame {

		private JPanel contentPane;
		private JTextField textField;

		public Pop_up() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 456, 164);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			textField = new JTextField();
			textField.setBounds(212, 25, 206, 23);
			contentPane.add(textField);
			textField.setColumns(10);

			JButton btnOk = new JButton("OK");
			btnOk.setBounds(173, 91, 89, 23);
			contentPane.add(btnOk);

			JLabel lblRuleName = new JLabel("Rule name:");
			lblRuleName.setBounds(53, 25, 105, 23);
			contentPane.add(lblRuleName);

			btnOk.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					frame.swapToMenu();
					System.out.println();
					frame.AddRules(new Rule(textField.getText(),selectedType,GUImakeRule.this.textField.getText().split("  ")));

				}
			});

		}
	}
	private enum Tracker{
		Metrics("Metrics"),
		Logical("Logical operator"),
		Limits("String Limits"),
		Operators("Logical operators");

		private String meaning;

		Tracker(String s){
			this.meaning=s;
		}


	}
}
