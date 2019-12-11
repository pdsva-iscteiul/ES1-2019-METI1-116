package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.poi.ss.usermodel.Cell;

import AuxPackage.Reader;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class GUIresults extends JPanel {
	private GUIprojectPresentation frame;
	private JTable table;
	private Reader excel;
	private JTable table_1;
	private JComboBox comboBox;
	private String[] column;
	private String[][] row;
	private String[] column1;
	private String[][] row1;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JTable table_2;
	/**
	 * Create the panel.
	 */
	public GUIresults(GUIprojectPresentation frame) {
		setBackground(new Color(240, 248, 255));
		this.frame = frame;
		setLayout(null);
		setBounds(100, 100, 600, 500);

		try {
			excel = new Reader (new File ("C:/Users/lenovo 530S-14IKB/Desktop/Long-Method.xlsx"));
		}catch(Exception e ) {};


		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "PMD ", "iPlasma"}));
		comboBox.setBounds(118, 58, 122, 39);
		add(comboBox);


		table_1 = new JTable();
		column = new String [1];
		for (int i= 0; i!=column.length; i++) {
			column[0] = "METHODID";
		}

		for (int x=1; x!=excel.read().length; x++) {
			row = new String[x][1];
		}
		model = (new DefaultTableModel(row, column){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		});
		table_1.setModel(model);
		JScrollPane scroll = new JScrollPane(table_1);
		scroll.setBounds(41, 108,  491, 200);
		add(scroll);
		
		table_2 = new JTable();
		table_2.setBounds(82, 358, 456, 93);
		
		column1 = new String [1];
		column1[0] = "Quality indicators/Detection tools ";
			
		row1 = new String [4][1];
		row1[0][0] = "DCI";
		row1[1][0] = "DII";
		row1[2][0] = "ADCI";
		row1[3][0] = "ADII";
		
		
		model1 = (new DefaultTableModel(row1, column1){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		});
		table_2.setModel(model1);
		JScrollPane scroll1 = new JScrollPane(table_2);
		scroll1.setBounds(41, 344,  491, 102);
		add(scroll1);
		

		JButton btnStartFindingErrors = new JButton("Start finding errors");
		btnStartFindingErrors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doRows(comboBox.getSelectedItem().toString().replaceAll(" ",""));

			}
		});
		btnStartFindingErrors.setFont(new Font("Dubai", Font.BOLD, 15));
		btnStartFindingErrors.setBounds(310, 58, 167, 39);
		add(btnStartFindingErrors);
		
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
		
		JLabel lblResults = new JLabel("RESULTS");
		lblResults.setFont(new Font("Dubai", Font.BOLD, 30));
		lblResults.setBounds(235, 2, 134, 39);
		add(lblResults);
		
		
		JLabel lblErrorsCounters = new JLabel("Errors Counters:");
		lblErrorsCounters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblErrorsCounters.setBounds(41, 322, 157, 22);
		add(lblErrorsCounters);

		JLabel lblErrorCounter = new JLabel("Error counter:");
		lblErrorCounter.setFont(new Font("Dubai", Font.PLAIN, 25));
		lblErrorCounter.setBounds(140, 138, 220, 43);

	}

	public void doRows(String s) {
		if(model.getColumnCount() <= 2) {
			ArrayList<String> array = excel.evaluate(s);
			model.addColumn(s);
			model1.addColumn(s);
			model1.setValueAt(excel.getDCI(), 0, model1.findColumn(s));
			model1.setValueAt(excel.getDII(), 1, model1.findColumn(s));
			model1.setValueAt(excel.getADCI(), 2, model1.findColumn(s));
			model1.setValueAt(excel.getADII(), 3, model1.findColumn(s));
			
			for (int i = 0; i!= array.size(); i++ ) {
				model.setValueAt(i+1,i,0);
				model.setValueAt(array.get(i), i, model.findColumn(s));
				
			}
		}
	}
}
