package Deliverable3Tests.NotPitTestable.blackBoxTests;

import Deliverable3Tests.TestCheckEngine;
import TeamRebecca.HalsteadMetricsCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HalsteadEffortBlackBoxTest {
	// Halstead Effort is the difficulty multiplied by the volume.

	String filePath = System.getProperty("user.dir") + "\\BlackBoxTestCases\\HalsteadMaintainabilityIndex\\MaintainabilityIndex1.java";

	@Test
	public void test() {
		HalsteadMetricsCheck check = new HalsteadMetricsCheck();

		TestCheckEngine t = new TestCheckEngine(filePath, check);
		try {
			t.runTree(); // try to execute the check on the whole tree
		} catch (CheckstyleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		assertEquals(2795.9, check.getHalsteadEffort(), 0.5); //wrong vbecause other metrics are wrong
	}
}
