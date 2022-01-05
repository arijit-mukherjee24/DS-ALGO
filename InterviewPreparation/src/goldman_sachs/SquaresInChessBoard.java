package goldman_sachs;

// https://practice.geeksforgeeks.org/problems/squares-in-nn-chessboard1801/1 gfg practice

public class SquaresInChessBoard {

	public static void main(String[] args) {

	}

	static Long squaresInChessBoard(Long n) {
		// A better way to write n*(n+1)*(2n+1)/6
		return (n * (n + 1) / 2) * (2 * n + 1) / 3;
	}

}
