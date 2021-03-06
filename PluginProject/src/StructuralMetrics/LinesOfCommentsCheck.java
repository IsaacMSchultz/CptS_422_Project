package StructuralMetrics;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class LinesOfCommentsCheck extends AbstractCheck {

	private int max = 5;
	int lineCount;

	public void beginTree(DetailAST rootAST) {
		lineCount = 0;
	}

	public void finishTree(DetailAST rootAST) {
		try {
			log(0, "Number of comment lines: {0}. Max number of comments lines exceeded", lineCount);
		} catch (NullPointerException e) {
			System.out.println("Can't run log unless called from treewalker!");
		}
	}

	@Override
	public int[] getAcceptableTokens() {
		return getRequiredTokens();
	}

	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[] { TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN, };
	}

	@Override
	public int[] getDefaultTokens() {
		return new int[] { TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN };
	}

	public int getCount() {
		return this.lineCount;
	}

	public void setMax(int limit) {
		max = limit;
	}

	@Override
	public void visitToken(DetailAST ast) {

		switch (ast.getType()) {
		case TokenTypes.SINGLE_LINE_COMMENT:
			lineCount++;
			break;

		case TokenTypes.BLOCK_COMMENT_BEGIN:
			lineCount++;
			lineCount += ast.getChildCount();
			break;
		}
	}
}