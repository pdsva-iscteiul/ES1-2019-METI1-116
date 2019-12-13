package AuxPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The class Reader is responsible for any type of excel reading in the project
 * @author Derick Piedade
 *
 */
public class Reader { 
	private Workbook wb;
	private Sheet sh;
	private FileInputStream excelFile;
	private int DCI;
	private int ADCI;
	private int DII;
	private int ADII;


	/**
	 * @param f the parameter f is the excel file to read 
	 * @throws IOException Exception for the case the excel file doesn't exist
	 */
	public Reader(File f) throws IOException {
		excelFile = new FileInputStream(f);
		wb = new XSSFWorkbook(excelFile);
		sh = wb.getSheetAt(0);
	}

	/**
	 * This function evaluates, according to the quality indicators, the tools existing in an excel file.
	 * @author Sofia Figueiredo
	 * @param a this parameter is the metric that this function is evaluating 
	 * @return s
	 * 
	 */
	public  ArrayList<String> evaluate(String a)  {
		ArrayList<String> s = new ArrayList<String>();
		DCI = 0;
		DII = 0;
		ADCI = 0;
		ADII = 0;
		for (int i = 1; i!= getValue(a).size()+1; i++ ) {
			if (getValue(a).get(i).toString().equals("TRUE") && getValue("is_long_method").get(i).toString().equals("TRUE")) {
				s.add("DCI");
				DCI++;
			}
			if (getValue(a).get(i).toString().equals("TRUE") && getValue("is_long_method").get(i).toString().equals("FALSE")) {
				s.add("DII");
				DII++;
			}
			if (getValue(a).get(i).toString().equals("FALSE") && getValue("is_long_method").get(i).toString().equals("FALSE")) {
				s.add("ADCI");
				ADCI++;
			}
			if (getValue(a).get(i).toString().equals("FALSE") && getValue("is_long_method").get(i).toString().equals("TRUE")) {
				s.add("ADII");
				ADII++;
			}
		}
		return s;
	}



	/**
	 * @return DCI returns the counter of DCI for evaluation 
	 * 
	 */
	public int getDCI() {
		return DCI;
	}


	/**
	 * @return ADCI returns the counter of ADCI for evaluation 
	 * Returns the ADCI value.
	 */
	public int getADCI() {
		return ADCI;
	}


	/**
	 * @return DII returns the counter of DII for evaluation 
	 */
	public int getDII() {
		return DII;
	}

	/**
	 * @return ADII returns the counter of ADII for evaluation 
	 */
	public int getADII() {
		return ADII;
	}

	
	/**
	 * Function that read all the excel file and saves it on an array
	 * @return the static array with the data of de excel
	 */
	public String [][] read(){
		DataFormatter formatter= new DataFormatter();
		String [][] aux = null;
		Row row= sh.getRow(sh.getFirstRowNum());
		int max, col=0;
		for(int i = 0;i != sh.getLastRowNum(); i++) {
			row = sh.getRow(i);
			if(row != null) {
				max = sh.getRow(i).getPhysicalNumberOfCells();
				if(max > col) col = max;
			}
		}

		aux= new String[sh.getPhysicalNumberOfRows()][col];
		for(int i=0; i!=aux.length; i++) {
			for(int j=0;j!=aux[i].length;j++) {
				aux[i][j]= formatter.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		return aux;
	}


	/**
	 *  the function makes the evaluation of the rules made by the users, comparing with is_long_method or is_feature_envy 
	 * @param r the rule that is going to be compared with is_long_method or _is_feature_envy
	 * @return ArrayList with all the result for each line of the excel file (DCI, DII, ADCI or ADII)
	 */
	public ArrayList<String> evaluateUserRule(Rule r){
		DCI = 0;
		DII = 0;
		ADCI = 0;
		ADII = 0;
		ArrayList<String> result= new ArrayList<>();
		for(int i=1;i!=getValue(r.getType()).size()+1; i++) {
			if(r.compare(sh.getRow(i)) && getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("DCI");
				DCI++;
			}
			if(r.compare(sh.getRow(i)) && !getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("DII");
				DII++;
			}
			if(!r.compare(sh.getRow(i)) && !getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("ADCI");
				ADCI++;
			}
			if(!r.compare(sh.getRow(i)) && getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("ADII");
				ADII++;
			}
		}
		return result;
	}
	
	/**
	 * @return the sheet of the excel file
	 */
	public Sheet getSh() {
		return sh;
	}

	/**
	 * function that receives a metric and shows all the values in each row for the metric chosen  
	 * @param metric string to search on the excel file
	 * @return an hashMap that contains all the values for a metric specified, related to their method_id 
	 */
	public HashMap<Integer, Cell> getValue(String metric){
		HashMap<Integer, Cell> aux= new HashMap<Integer, Cell>();
		Row row= sh.getRow(sh.getFirstRowNum());
		for(int i=0; i!=row.getLastCellNum(); i++) {
			if(metric.equals(row.getCell(i).getStringCellValue())) {
				for(int j=1;j!=sh.getLastRowNum()+1;j++) {
					aux.put((int)sh.getRow(j).getCell(0).getNumericCellValue(), sh.getRow(j).getCell(i));
				}
			}
		}
		return aux;
	}
	
}
