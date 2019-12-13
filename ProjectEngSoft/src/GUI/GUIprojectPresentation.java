package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;

import AuxPackage.Rule;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


/**
 * @author Sofia Figueiredo
 * 
 * Main frame that let us run the program.
 * 
 */
public class GUIprojectPresentation extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ArrayList<Rule> listOfRules;
	private String excelPath;


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
		listOfRules = new ArrayList<Rule>();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setForeground(new Color(105, 105, 105));
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 600, 500);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		frame.getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 586, 463);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEvaluationOfDesign = new JLabel("EVALUATION OF DESIGN ");
		lblEvaluationOfDesign.setBounds(60, 88, 471, 85);
		panel.add(lblEvaluationOfDesign);
		lblEvaluationOfDesign.setForeground(new Color(0, 0, 51));
		lblEvaluationOfDesign.setVerticalAlignment(SwingConstants.TOP);
		lblEvaluationOfDesign.setFont(new Font("Dubai", Font.BOLD, 40));
		
		JLabel lblDeffect = new JLabel("DEFFECT DETECTION QUALITY \r\n");
		lblDeffect.setBounds(13, 142, 563, 85);
		panel.add(lblDeffect);
		lblDeffect.setForeground(new Color(0, 0, 51));
		lblDeffect.setFont(new Font("Dubai", Font.BOLD, 40));
		
		JLabel lblNewLabel = new JLabel("IN SOFTWARE PROJECTS");
		lblNewLabel.setBounds(64, 205, 477, 85);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 40));
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setBounds(224, 350, 131, 65);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Dubai", Font.BOLD, 20));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swapToexcel();
				
								
			}
		});

	}
	
	/**
	 * @return excelPath
	 * 
	 * Return the path to excel.
	 */
	public String getExcelPath() {
		return excelPath;
	}
	
	/**
	 * @param s -> path to excel
	 * 
	 * Changes the path to excel.
	 */
	public void setExcelPath(String s) {
		excelPath=s;
	}
	
	/**
	 * Changes the current panel to the excel panel.
	 */
	public void swapToexcel() {
		JPanel j = new GUIexcelPage(this);
		j.setBounds(0, 0, 586, 463);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(j);
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
	}
		
	
	/**
	 * Changes the current panel to the menu panel.
	 */
	public void swapToMenu() {
		JPanel j = new GUImenu(this);
		j.setBounds(0, 0, 586, 463);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(j);
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
	
	}
	
	/**
	 * Changes the current panel to the make rule panel.
	 */
	public void swapTomakeRule() {
		JPanel j = new GUImakeRule(this);
		j.setBounds(0, 0, 586, 463);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(j);
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
}
	
	/**
	 *Changes the current panel to the results panel. 
	 */
	public void swapToResults() {
		JPanel j = new GUIresults(this);
		j.setBounds(0, 0, 586, 463);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(j);
		frame.getContentPane().repaint();
		frame.getContentPane().revalidate();
}
	
	
	/**
	 * @param rule -> Rule to be added
	 * 
	 * Add rules into the listOfRules.
	 */
	public void AddRules(Rule rule) {
		listOfRules.add(rule);
	}
	
	/**
	 * @param rule -> Rule to be removed
	 * 
	 * Remove rules of the listOfRules.
	 */
	public void RemoveRules(Rule rule) {
		listOfRules.remove(rule);
	}
	
	
	/**
	 * @return listOfRules 
	 * 
	 * Return the listOfRules.
	 */
	public ArrayList<Rule> getListOfRules(){
		return this.listOfRules;
	}
}
