package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RuleTest {

	private ArrayList<String> rulecomponentes;
	private String name;
	private String TypeOfComparation1;
	private String TypeOfComparation2;

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
		name = "jesus";


	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRule() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRulecomponentes() {
		fail("Not yet implemented");
	}

	@Test
	void testGetName() {
	//	assertEquals();
		
	}

	@Test
	void testGetType() {
		fail("Not yet implemented");
	}

	@Test
	void testCompare() {
		fail("Not yet implemented");
	}

}
