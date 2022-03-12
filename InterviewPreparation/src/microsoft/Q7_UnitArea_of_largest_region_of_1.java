package microsoft;

//695. Max Area of Island
public class Q7_UnitArea_of_largest_region_of_1 {

	public static void main(String[] args) {

	}

	// Function to find unit area of the largest region of 1s.
	public int findMaxArea(int[][] grid) {
		int max = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, dfs(i, j, grid));
				}
			}
		}
		return max;
	}

	public int dfs(int i, int j, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
			return 0;

		grid[i][j] = 0;
		int count = 1;

		// Horizonatl and Vertical direction
		count += dfs(i + 1, j, grid);
		count += dfs(i - 1, j, grid);
		count += dfs(i, j + 1, grid);
		count += dfs(i, j - 1, grid);

		// Diagonal direction
		count += dfs(i + 1, j + 1, grid);
		count += dfs(i + 1, j - 1, grid);
		count += dfs(i - 1, j - 1, grid);
		count += dfs(i - 1, j + 1, grid);

		return count;
	}

}
