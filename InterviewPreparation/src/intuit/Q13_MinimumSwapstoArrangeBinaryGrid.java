package intuit;

import java.util.LinkedList;
import java.util.List;

// 1536. Minimum Swaps to Arrange a Binary Grid

//Ref: https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/discuss/767912/Java-16-lines-bubble-sort-with-line-by-line-explanation-easy-to-understand

//Understanding: https://www.youtube.com/watch?v=C_EBmbe6ocM  Competitive Coding
public class Q13_MinimumSwapstoArrangeBinaryGrid {

	public static void main(String[] args) {

	}

	public int minSwaps(int[][] grid) {
		int n = grid.length, res = 0;
		List<Integer> row = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int trailingZeroCnt = 0;
			for (int j = n - 1; j > -1 && grid[i][j] == 0; j--)
				trailingZeroCnt++;
			row.add(trailingZeroCnt);
		}
		for (int curRowIdx = 0, minTrailingZeros = n - 1; curRowIdx < n; curRowIdx++, minTrailingZeros--) {
			int satisfiedRowIdx = curRowIdx;
			while (satisfiedRowIdx < n && row.get(satisfiedRowIdx) < minTrailingZeros)
				satisfiedRowIdx++;
			// There isn't a number in the list which satisfy the condition
			if (satisfiedRowIdx == n)
				return -1;
			int toRemove = row.remove(satisfiedRowIdx);
			// Add the number which satisfy the condition and push everything down
			row.add(curRowIdx, toRemove); // Also maintains the size of the
			res += satisfiedRowIdx - curRowIdx;
		}
		return res;
	}

}
