package blackBoxTests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import StructuralMetrics.NumberOfCastsCheck;

public class BlackBoxNumberOfCastsCheckTest {
	
	String filePath = System.getProperty("user.dir") + "\\BlackBoxTestCases\\NumberOfCastsCheck\\NumberOfCastsCheck";

	@Test
	public void test1() {
		NumberOfCastsCheck c = new NumberOfCastsCheck(); 
		TestCheckEngine t = new TestCheckEngine(filePath + "1.java", c); //create a tester with filepath, and the check c
		
		try {
			t.runTree(); //try to execute the check on the whole tree
		} catch (CheckstyleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(c.getCasts(), 2); //determine if execution created the correct value
	}
	
	@Test
	public void test2() {
		NumberOfCastsCheck c = new NumberOfCastsCheck(); 
		TestCheckEngine t = new TestCheckEngine(filePath + "2.java", c); //create a tester with filepath, and the check c
		
		try {
			t.runTree(); //try to execute the check on the whole tree
		} catch (CheckstyleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(c.getCasts(), 0); //determine if execution created the correct value
	}
	
	@Test
	public void test3() {
		NumberOfCastsCheck c = new NumberOfCastsCheck(); 
		TestCheckEngine t = new TestCheckEngine(filePath + "3.java", c); //create a tester with filepath, and the check c
		
		try {
			t.runTree(); //try to execute the check on the whole tree
		} catch (CheckstyleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(c.getCasts(), 3); //determine if execution created the correct value
	}
}