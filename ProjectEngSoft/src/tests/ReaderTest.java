package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import AuxPackage.Reader;
import AuxPackage.Rule;

public class ReaderTest {

	private Reader reader;
	private File file;
	private String [][] excel;
	private HashMap <Integer,Cell> hMapMetric; 
	private HashMap <Integer,Cell> hMapMethod; 
	private Rule rule1;
	private Rule rule2;
	private Workbook wb;
	private Sheet sh;
	private FileInputStream excelFile;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("ReaderTest JUnit");
	}

	@Before
	public void setUp() throws Exception {
		
		file = new File("C:/Users/joao/Downloads/Long-Method.xlsx"); // only for Long-Method excel file
		reader = new Reader(file);
		excel = reader.read();	
		
		hMapMetric = reader.getValue("LOC"); // e.g, LOC method
		hMapMethod = reader.getValue("method");
		rule1 = new Rule("joao","is_long_method"," ( LOC = 40 ) ");
		rule2 = new Rule("jesus","is_feature_envy"," ( CYCLO > 3 ) ");
		excelFile = new FileInputStream(file);
		wb = new XSSFWorkbook(excelFile);
		sh = wb.getSheetAt(0);
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void readTest() {	
		String[][] matrix = new String [1][2];
		assertNotEquals(excel,matrix);
	}

	@Test
	public void getValueTest() {	
		assertNotEquals(hMapMetric.get(1).toString(),"5.0");
		assertEquals(hMapMetric.get(1).toString(),"3.0");
		assertEquals(hMapMethod.get(1).toString(),"Output()");
		assertNotEquals(hMapMethod.get(1).toString(),"Result()");
	}
	@Test
	public void evaluateTest() {
		ArrayList<String> s = reader.evaluate("iPlasma");
		ArrayList<String> m = reader.evaluate("PMD");
		assertEquals(s.get(0),"ADCI");
		assertNotEquals(s.get(0),"hello");
		assertEquals(m.get(0),"ADCI");
		assertNotEquals(m.get(0),"hello");
		boolean a = false;
		boolean b = false;
		for(int i = 0; i != s.size();i++) {
			if(s.get(i).equals("ADII")) 
				a = true;
				
			
			if(m.get(i).equals("ADII"))
				b=true;
			
		}
		assertFalse(a);
		assertFalse(b);
		
		
		
	}
	@Test
	public void evaluate1Test() {
		ArrayList<String> s = reader.evaluate1(rule1);
		ArrayList<String> m = reader.evaluate1(rule2);
		assertEquals(s.get(0),"ADCI");
		assertNotEquals(s.get(0),"hello");
		assertEquals(m.get(6),"ADII");
		assertNotEquals(m.get(6),"hello");
	
		
	}
	@Test
	public void getDCITest() {
		
		reader.evaluate("PMD");
		assertNotEquals(reader.getDCI(),2);
		assertEquals(reader.getADCI(),262);

		reader.evaluate("iPlasma");
		assertNotEquals(reader.getDCI(),2);
		assertEquals(reader.getADCI(),280);
	}

	@Test
	public void getADCITest() {
		reader.evaluate("PMD");
		assertNotEquals(reader.getADCI(),2);
		assertEquals(reader.getADCI(),262);
		
		reader.evaluate("iPlasma");
		assertNotEquals(reader.getADCI(),2);
		assertEquals(reader.getADCI(),280);
		}
	

	@Test
	public void getDIITest() {
		reader.evaluate("PMD");	
		assertNotEquals(reader.getDII(),2);
		assertEquals(reader.getDII(),18);
		
		reader.evaluate("iPlasma");
		assertNotEquals(reader.getDII(),2);
		assertEquals(reader.getDII(),0);
	}
	
	@Test
	public void getADIITest() {
		reader.evaluate("PMD");
		assertNotEquals(reader.getADII(),2);
		assertEquals(reader.getADII(),0);
		
		reader.evaluate("iPlasma");
		assertNotEquals(reader.getADII(),2);
		assertEquals(reader.getADII(),0);
	}


}
