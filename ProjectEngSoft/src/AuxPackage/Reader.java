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

public class Reader {

	private Workbook wb;
	private Sheet sh;
	private FileInputStream excelFile;
	private int DCI;
	private int ADCI;
	private int DII;
	private int ADII;


	public Reader(File f) throws IOException {
		excelFile = new FileInputStream(f);
		wb = new XSSFWorkbook(excelFile);
		sh = wb.getSheetAt(0);
	}



	public  ArrayList<String> evaluate(String a) {
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



	public int getDCI() {
		return DCI;
	}


	public int getADCI() {
		return ADCI;
	}


	public int getDII() {
		return DII;
	}

	public int getADII() {
		return ADII;
	}

	
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
