package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;


public class GUIprojectPresentation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIprojectPresentation window = new GUIprojectPresentation();
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
	public GUIprojectPresentation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setForeground(new Color(105, 105, 105));
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 936, 589);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEvaluationOfDesign = new JLabel("EVALUATION OF DESIGN ");
		lblEvaluationOfDesign.setForeground(new Color(0, 0, 51));
		lblEvaluationOfDesign.setVerticalAlignment(SwingConstants.TOP);
		lblEvaluationOfDesign.setFont(new Font("Dubai", Font.BOLD, 50));
		lblEvaluationOfDesign.setBounds(151, 80, 640, 75);
		frame.getContentPane().add(lblEvaluationOfDesign);
		
		JLabel lblDeffect = new JLabel("DEFFECT DETECTION QUALITY \r\n");
		lblDeffect.setForeground(new Color(0, 0, 51));
		lblDeffect.setFont(new Font("Dubai", Font.BOLD, 50));
		lblDeffect.setBounds(107, 147, 805, 106);
		frame.getContentPane().add(lblDeffect);
		
		JLabel lblNewLabel = new JLabel("IN SOFTWARE PROJECTS");
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 50));
		lblNewLabel.setBounds(159, 228, 587, 106);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 16));
		btnNewButton.setBounds(379, 434, 140, 52);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//abre outra window
				frame.dispose();
				GUIexcelPage excel = new GUIexcelPage();
				excel.newWindow();
			}
		});
	}

}
