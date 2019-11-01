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

		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		NumberOfCastsCheck c = new NumberOfCastsCheck(); 
		TestCheckEngine t = new TestCheckEngine(filePath + "1.java", c); //create a tester with filepath, and the check c
		try {
			t.runTree(); //try to execute the check on the whole tree
		} catch (CheckstyleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(c.getCasts()); //print the result (debug)
		assertEquals(c.getCasts(), 2); //determine if execution created the correct value
	}
}