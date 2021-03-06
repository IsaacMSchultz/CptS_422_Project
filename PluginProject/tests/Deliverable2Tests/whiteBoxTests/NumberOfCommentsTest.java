package Deliverable2Tests.whiteBoxTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import StructuralMetrics.NumberOfCommentsCheck;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DetailAST.class)
public class NumberOfCommentsTest {
	int[] expectedTokens = { TokenTypes.COMMENT_CONTENT };

	@Test
	public void testBeginTree() {
		NumberOfCommentsCheck test = new NumberOfCommentsCheck();
		DetailAST ast = PowerMockito.mock(DetailAST.class);

		test.beginTree(ast);
		assertEquals(0, test.getCount());
	}

	@Test
	public void testGetDefaultTokens() {
		NumberOfCommentsCheck test = new NumberOfCommentsCheck();

		assertArrayEquals(expectedTokens, test.getDefaultTokens());
	}

	@Test
	public void testGetAcceptableTokens() {
		NumberOfCommentsCheck test = new NumberOfCommentsCheck();

		assertArrayEquals(expectedTokens, test.getAcceptableTokens());
	}

	@Test
	public void testGetRequiredTokens() {
		NumberOfCommentsCheck test = new NumberOfCommentsCheck();

		assertArrayEquals(expectedTokens, test.getRequiredTokens());
	}

	// This is the function that we will be doing all of our tests from, since all
	// the others require mocking private fields thta we have not yet learned how to
	// do.
	// AAA = Arrange, Act, Assert
	@Test
	public void testCountCommentsCount() {
		NumberOfCommentsCheck test = new NumberOfCommentsCheck();
		DetailAST ast = PowerMockito.mock(DetailAST.class);

		test.beginTree(ast); // begin the tree

		doReturn(TokenTypes.COMMENT_CONTENT).when(ast).getType();
		test.visitToken(ast);

		doReturn(TokenTypes.COMMENT_CONTENT).when(ast).getType();
		test.visitToken(ast);

		assertEquals(2, test.getCount());
	}
}
