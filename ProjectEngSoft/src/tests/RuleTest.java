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

	private ArrayList<String> rulecomponentes;
	private String name1;
	private String name2;
	private String TypeOfComparation1;
	private String TypeOfComparation2;
	private String subrule1;
	private String subrule2;
	private String subrule3;
	private Rule rule1;
	private Rule rule2;
	private Row row;
	private Reader reader;
	private String[][] matriz;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		TypeOfComparation1  = "OR";
		TypeOfComparation2 = "AND";
		name1 = "jesus";
		name2 = "joao";
		subrule1 = "LOC = 40";
		subrule2 = "CYCLO > 40";
		rule1 = new Rule(name1,TypeOfComparation1,subrule1);
		rule2 = new Rule(name2,TypeOfComparation2,subrule2);
		reader = new Reader(new File("C:/Users/joao/Downloads/Long-Method.xlsx"));
		matriz=reader.read();
		// row = (Row) (matriz[1][0]).;


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
		System.out.println(rule1.getRulecomponentes());
		assertEquals(rule1.getRulecomponentes().toString(),"[LOC= 40]");
		assertEquals(rule2.getRulecomponentes().toString(),"[CYCLO> 40]");
	}

	@Test
	void testGetName() {
		assertEquals(rule1.getName(),"jesus");
		assertEquals(rule2.getName(),"joao");
	
	}

	@Test
	void testGetType() {
		assertEquals(rule1.getType(),"OR");
		assertEquals(rule2.getType(),"AND");
	}

	@Test
	void testCompare() {
		
	}

}
