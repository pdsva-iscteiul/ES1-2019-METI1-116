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

public class GUIexcelPage {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

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
		frame.setBounds(100, 100, 495, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("true");
			}
		});
		btnNewButton.setBounds(343, 272, 109, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Search");
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
		textField.setBounds(132, 58, 320, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(20);

		btnNewButton_1.setBounds(30, 57, 92, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Path of the file:");
		lblNewLabel.setBounds(132, 33, 122, 14);
		frame.getContentPane().add(lblNewLabel);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(30, 247, 422, 14);
		frame.getContentPane().add(progressBar);

		JLabel lblPmd = new JLabel("PMD:");
		lblPmd.setBounds(46, 148, 61, 14);
		frame.getContentPane().add(lblPmd);

		JLabel lblPlasma = new JLabel("iPlasma:");
		lblPlasma.setBounds(46, 173, 61, 14);
		frame.getContentPane().add(lblPlasma);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(208, 215, 174, -67);
		frame.getContentPane().add(layeredPane);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBounds(31, 104, 422, 90);
		frame.getContentPane().add(table);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(30, 133, 422, 62);
		frame.getContentPane().add(rigidArea);
		
	}

}
