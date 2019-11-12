package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIexcel extends JPanel {
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public GUIexcel() {
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBounds(187, 210, 57, 29);
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("true");
			//	frame.dispose();
			//GUImenu menu = new GUImenu();
			//menu.newWindow();
				
				GUIresults g = new GUIresults();
				g.show();
			}
		});
		setLayout(null);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search file");
		btnNewButton_1.setBounds(271, 88, 87, 29);
		btnNewButton_1.setFont(new Font("Dubai", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "xlsx", "xlsm", "xlsb");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
					textField.setText(chooser.getSelectedFile().getAbsolutePath());

				}
			}
		});

		textField = new JTextField();
		textField.setBounds(73, 92, 186, 20);
		add(textField);
		textField.setColumns(20);
		add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Path of the file:");
		lblNewLabel.setBounds(72, 66, 79, 21);
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 12));
		add(lblNewLabel);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(439, 19, 1, 1);
	add(layeredPane);
		
		JLabel lblFirst = new JLabel("First,choose your excel file.");
		lblFirst.setBounds(98, 31, 171, 24);
		lblFirst.setFont(new Font("Dubai", Font.BOLD, 14));
	add(lblFirst);
		
	}

}
