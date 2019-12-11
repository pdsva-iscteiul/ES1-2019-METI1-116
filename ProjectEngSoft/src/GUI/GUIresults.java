package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import AuxPackage.Reader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GUIresults extends JPanel {
	private GUIprojectPresentation frame;
	private JTable table;
	private Reader excel;
	private JTable table_1;
	private JComboBox comboBox;
	private String[] column;
	private String[][] row;
	private DefaultTableModel model;
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "PMD ", "IPlasma"}));
		comboBox.setBounds(122, 75, 122, 39);
		add(comboBox);


		table_1 = new JTable();
		column = new String [1];
		for (int i= 0; i!=column.length; i++) {
			column[0] = "METHODID";
		}
		row = new String [420][1];
		model = (new DefaultTableModel(row, column){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		});
		table_1.setModel(model);



		JScrollPane scroll = new JScrollPane(table_1);
		scroll.setBounds(69, 154,  450, 200);
		add(scroll);

		JButton btnStartFindingErrors = new JButton("Start finding errors");
		btnStartFindingErrors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluate(comboBox.getSelectedItem().toString());
				System.out.println(comboBox.getSelectedItem().toString());
				System.out.println(comboBox.getSelectedItem().toString());
			}
		});
		btnStartFindingErrors.setFont(new Font("Dubai", Font.BOLD, 15));
		btnStartFindingErrors.setBounds(304, 75, 167, 39);
		add(btnStartFindingErrors);

		JLabel lblErrorCounter = new JLabel("Error counter:");
		lblErrorCounter.setFont(new Font("Dubai", Font.PLAIN, 25));
		lblErrorCounter.setBounds(140, 138, 220, 43);




	}

	public void evaluate (String s) {

		if (s.contains("PMD")) {
			model.addColumn("PMD");
			for (int i = 1; i!= excel.read().length; i++ ) {
				model.setValueAt(excel.read()[i][0],i-1,0);
			}
		}
		else {
			if (s.contains("IPlasma")) {
				model.addColumn("IPlasma");
				for (int i = 1; i!= excel.read().length; i++ ) {
					model.setValueAt(excel.read()[i][0],i-1,0);

				}
			}
		}

	}

}
