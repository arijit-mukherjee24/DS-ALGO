package intuit;
// 1162. As Far from Land as Possible

import java.util.LinkedList;

//Manhattan Distance: https://www.youtube.com/watch?v=p3HbBlcXDTE
//https://www.youtube.com/watch?v=yV-b0amHNVM Pepcoding
//TC: O(V+E) Here V=n^2 and E=4n^2   Therefore, O(n^2 + 4*n^2) ~ O(n^2)
public class Q14_AsFarfromLandasPossible {

	public static void main(String[] args) {

	}

	public int maxDistance(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		LinkedList<Pair> queue = new LinkedList<Pair>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					queue.add(new Pair(i, j));
				}
			}
		}

		if ((queue.size() == 0) || queue.size() == row * col) {
			return -1;
		}

		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int level = -1;
		while (queue.size() > 0) {
			level++;
			int size = queue.size();
			while (size-- > 0) {
				Pair rem = queue.poll();
				for (int i = 0; i < 4; i++) {
					int rowdash = rem.row + dirs[i][0];
					int coldash = rem.col + dirs[i][1];

					if (rowdash < 0 || rowdash >= row || coldash < 0 || coldash >= col || grid[rowdash][coldash] == 1)
						continue;

					queue.add(new Pair(rowdash, coldash));
					grid[rowdash][coldash] = 1;
				}
			}
		}
		return level;
	}
}

class Pair {
	int row;
	int col;

	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
}