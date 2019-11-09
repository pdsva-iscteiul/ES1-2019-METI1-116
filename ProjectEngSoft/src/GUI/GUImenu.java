package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUImenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUImenu window = new GUImenu();
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
	public GUImenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 705, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Rule maker");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//GUImakeRule rule = new GUImakeRule();
				//rule.newWindow();
			}
		});
		btnNewButton.setFont(new Font("Dubai", Font.PLAIN, 27));
		btnNewButton.setBounds(119, 166, 454, 89);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEvaluateRule = new JButton("Evaluate Rule");
		btnEvaluateRule.setFont(new Font("Dubai", Font.PLAIN, 27));
		btnEvaluateRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//GUIresults results = new GUIresults();
				//results.newWindow();
			}
		});
		btnEvaluateRule.setBounds(119, 266, 454, 89);
		frame.getContentPane().add(btnEvaluateRule);
		
		JButton btnSeeRules = new JButton("See rules");
		btnSeeRules.setFont(new Font("Dubai", Font.PLAIN, 27));
		btnSeeRules.setBounds(119, 366, 454, 89);
		frame.getContentPane().add(btnSeeRules);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(Color.BLACK);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Dubai", Font.BOLD, 56));
		lblMenu.setBounds(40, 28, 615, 127);
		frame.getContentPane().add(lblMenu);
		
		
	}
}
