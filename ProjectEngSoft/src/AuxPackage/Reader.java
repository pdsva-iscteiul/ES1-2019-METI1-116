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


	public Reader(File f) throws IOException {
		excelFile = new FileInputStream(f);
		wb = new XSSFWorkbook(excelFile);
		sh = wb.getSheetAt(0);
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

	public ArrayList<String> evaluate1(Rule r){
		ArrayList<String> result= new ArrayList<>();
		for(int i=1;i!=getValue(r.getType()).size()+1; i++) {
			if(r.compare(sh.getRow(i)) && getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("DCI");
			}
			if(r.compare(sh.getRow(i)) && !getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("DII");
			}
			if(!r.compare(sh.getRow(i)) && !getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("ADCI");
			}
			if(!r.compare(sh.getRow(i)) && getValue(r.getType()).get(i).getBooleanCellValue()) {
				result.add("ADII");
			}
		}
		return result;
	}

	public HashMap<Integer, Cell> getValue(String metric){
		HashMap<Integer, Cell> aux= new HashMap<Integer, Cell>();
		Row row= sh.getRow(sh.getFirstRowNum());
		for(int i=1; i!=row.getLastCellNum(); i++) {
			if(metric.equals(row.getCell(i).getStringCellValue())) {
				for(int j=1;j!=sh.getLastRowNum()+1;j++) {
					aux.put((int)sh.getRow(j).getCell(0).getNumericCellValue(), sh.getRow(j).getCell(i));
				}
			}
		}
		return aux;
	}
	
	public static void main(String[] args) throws IOException {
		Reader r=  new Reader(new File("C:/Users/Derick/Desktop/Long-Method.xlsx"));
		Rule rule= new Rule("asd", "is_feature_envy", " ( LOC = 1 ), AND, ( LOC = 3 ) ");
		System.out.println(r.evaluate1( rule));
	}


}
