package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

public class ReaderTest {

	private Reader reader;
	private File file;
	private String [][] excel;
	private HashMap <Integer,Cell> hMapMetric; 
	private HashMap <Integer,Cell> hMapMethod; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("ReaderTest JUnit");
	}

	@Before
	public void setUp() throws Exception {
		
		file = new File("/Users/pedrov510/Desktop/Uni/ES/Long-Method.xlsx"); // only for Long-Method excel file
		reader = new Reader(file);
		excel = reader.read();	
		
		hMapMetric = reader.getValue("LOC"); // e.g, LOC method
		hMapMethod = reader.getValue("method");
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


}
