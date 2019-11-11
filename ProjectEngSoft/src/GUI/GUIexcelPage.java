package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTable;
import java.awt.Font;

public class GUIexcelPage {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIexcelPage window = new GUIexcelPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIexcelPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 459, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Load");
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("true");
			//	frame.dispose();
			//GUImenu menu = new GUImenu();
			//menu.newWindow();
			}
		});
		btnNewButton.setBounds(175, 201, 109, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search file");
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
		textField.setBounds(83, 138, 320, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(20);

		btnNewButton_1.setBounds(175, 72, 109, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Path of the file:");
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 12));
		lblNewLabel.setBounds(83, 123, 122, 14);
		frame.getContentPane().add(lblNewLabel);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(208, 215, 174, -67);
		frame.getContentPane().add(layeredPane);
		
		JLabel lblFirst = new JLabel("First,choose your excel file.");
		lblFirst.setFont(new Font("Dubai", Font.BOLD, 14));
		lblFirst.setBounds(142, 21, 174, 14);
		frame.getContentPane().add(lblFirst);
		
	}
}
