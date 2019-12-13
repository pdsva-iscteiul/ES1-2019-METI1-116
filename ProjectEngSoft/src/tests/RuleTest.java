package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AuxPackage.Reader;
import AuxPackage.Rule;

class RuleTest {

	private String name1;
	private String name2;
	private String name3;
	private String TypeOfComparation1;
	private String TypeOfComparation2;
	private String subrule1;
	private String subrule2;
	private String subrule3;
	private String subrule4;
	private String subrule5;
	private String subrule6;
	private String subrule7;
	private String subrule8;
	private Rule rule1;
	private Rule rule2;
	private Rule rule3;
	private Rule rule4;
	private Rule rule5;
	private Rule rule6;
	private Rule rule7;
	private Row row1;
	private Row row2;
	private Row row3;
	private Reader reader;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {  
		
		TypeOfComparation1  = "is_long_method";
		TypeOfComparation2 = "is_feature_envy";
		
		name1 = "jesus";
		name2 = "joao";
		name3 = "dave";
		
		subrule1 = " ( LOC = 5 )";
		subrule2 = "( LOC < 20 )";
		subrule3 = " ( LOC > 1 )";
		
		subrule4 = " ( CYCLO = 1 )";
		subrule5 = "( CYCLO < 30 )";
		subrule6 = " ( CYCLO > 2 )";
		
		subrule7 = " ( LAA = 1 )"; 
		subrule8 = "( ATFD < 10 )";
		
		String [] cond1 = {subrule6," AND ",subrule2}; // CYCLO>1 AND LOC<20
		String [] cond2 = {subrule3," OR ",subrule5}; // LOC > 1 OR CYCLO<30
		
		String [] cond3 = {subrule7," AND ",subrule8}; // LAA > 0 AND ATFD<50
		
		rule1 = new Rule(name1,TypeOfComparation1,subrule1); // is_long_method
		rule3 = new Rule(name3,TypeOfComparation1,subrule3); // is_long_method
		rule4 = new Rule(name1,TypeOfComparation1,subrule4); // is_long_method
		rule6 = new Rule(name1,TypeOfComparation1,cond1); // is_long_method
		rule7 = new Rule(name2,TypeOfComparation1, cond2); // is_long_method
		
		rule2 = new Rule(name2,TypeOfComparation2,cond3); // feature_envy
		//rule5 = new Rule(name3,TypeOfComparation2,subrule8); // feature_envy

		// load the excel file
		reader = new Reader(new File("C:/Users/joao/Downloads/Long-Method.xlsx"));
		
		row1 = reader.getSh().getRow(3); //e.g, row number 3
		row2 = reader.getSh().getRow(25); // for testing cond1
		row3 = reader.getSh().getRow(21); // for testing cond2		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRule() {
		System.out.println("This test ran");
	}

	@Test
	void testGetRulecomponentes() {
		assertEquals(rule1.getRulecomponentes().toString(),"[( LOC = 5 )]");
		assertEquals(rule4.getRulecomponentes().toString(),"[( CYCLO = 1 )]");
		//assertEquals(rule2.getRulecomponentes().toString(),"[( LAA > 0 )]");
	}

	@Test
	void testGetName() {
		assertEquals(rule1.getName(),"jesus");
		assertEquals(rule7.getName(),"joao");
	
	}

	@Test
	void testGetType() {
		assertEquals(rule1.getType(),"is_long_method");
		assertEquals(rule3.getType(),"is_long_method");
	}

	@Test
	void testCompare() {
		
		boolean expected1 = rule1.compare(row1); // should return true, because LOC=5 in row 3
		assertTrue(expected1);
		assertFalse(rule1.compare(row2));
		
		boolean expected2 = rule3.compare(row1); // should return true
		assertTrue(expected2);
		
		boolean expected4 = rule4.compare(row1); //should return 1, because CYCLO=1
		assertTrue(expected4);
		assertFalse(rule4.compare(row2));
		
		boolean expected6 = rule6.compare(row2);
		assertTrue(expected6);
		assertFalse(rule6.compare(row1));
		
		boolean expected7 = rule7.compare(row3);
		assertTrue(expected7);
			
		boolean expected8 = rule2.compare(row3);
		assertTrue(expected8);
		
	}
	
	
}
