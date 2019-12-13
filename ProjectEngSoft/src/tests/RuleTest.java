package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import AuxPackage.Reader;
import AuxPackage.Rule;

/** 
 * 
 * @author Pedro Venda
 * @author João Figueiredo
 *
 */

/**
 * 
 * The main objective here on making JavaDoc documentation is to make the test
 * understandable for those who will be reading the following code.
 *
 * This JUnit test case was created for make unit testing for Rule class.
 */

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

	/**
	 * Initialize the variables that will make the JUnit test for Rule class
	 * possible. For example, the initialization of the rules with the corresponding
	 * metrics, thresholds and logic operators.
	 * 
	 * @throws Exception
	 * @result The rules and her components will be initialize. The "Long_method"
	 *         excel file will be loaded and will be created three rows related with
	 *         certain excel file rows.
	 */

	@BeforeEach
	void setUp() throws Exception {

		TypeOfComparation1 = "is_long_method";
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

		String[] cond1 = { subrule6, " AND ", subrule2 }; // CYCLO>2 AND LOC<20
		String[] cond2 = { subrule3, " OR ", subrule5 }; // LOC > 1 OR CYCLO<30
		String[] cond3 = { subrule7, " AND ", subrule8 }; // LAA = 1 AND ATFD<10

		rule1 = new Rule(name1, TypeOfComparation1, subrule1); // is_long_method
		rule3 = new Rule(name3, TypeOfComparation1, subrule3); // is_long_method
		rule4 = new Rule(name1, TypeOfComparation1, subrule4); // is_long_method
		rule6 = new Rule(name1, TypeOfComparation1, cond1); // is_long_method
		rule7 = new Rule(name2, TypeOfComparation1, cond2); // is_long_method

		rule2 = new Rule(name2, TypeOfComparation2, cond3); // is_feature_envy

		// load the excel file
		reader = new Reader(new File("C:/Users/joao/Downloads/Long-Method.xlsx"));

		row1 = reader.getSh().getRow(3); // e.g, row number 3
		row2 = reader.getSh().getRow(25); // for testing cond1
		row3 = reader.getSh().getRow(21); // for testing cond2
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * 
	 * Check if the rules components are the supposed ones.
	 * 
	 * @result This will be tested without failures, because the components expected
	 *         are the same as those obtained.
	 * 
	 */

	@Test
	void testGetRulecomponentes() {
		assertEquals(rule1.getRulecomponentes().toString(), "[( LOC = 5 )]");
		assertEquals(rule4.getRulecomponentes().toString(), "[( CYCLO = 1 )]");
	}

	/**
	 * 
	 * Check if the name of the rules are the supposed ones.
	 * 
	 * @result This will be tested without failures, because the names expected are
	 *         the same as those obtained.
	 * 
	 */

	@Test
	void testGetName() {
		assertEquals(rule1.getName(), "jesus");
		assertEquals(rule7.getName(), "joao");

	}

	/**
	 * Check if the rules type are the supposed ones.
	 * 
	 * @result This will be tested without failures, because the types expected are
	 *         the same as those obtained.
	 **/

	@Test
	void testGetType() {
		assertEquals(rule1.getType(), "is_long_method");
		assertEquals(rule3.getType(), "is_long_method");
	}

	/**
	 * 
	 * Check if the method "compare" in Rule class works properly.
	 * 
	 * @result This will be tested without failures, because the boolean values
	 *         expected are the same as those obtained.
	 * 
	 */

	@Test
	void testCompare() {

		boolean expected1 = rule1.compare(row1); // should return true, because LOC=5 in row 3
		assertTrue(expected1);
		assertFalse(rule1.compare(row2));

		boolean expected2 = rule3.compare(row1); // should return true
		assertTrue(expected2);

		boolean expected4 = rule4.compare(row1); // should return 1, because CYCLO=1
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
