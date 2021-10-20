package com.graph.assignment;
// Ref: https://leetcode.com/problems/path-with-minimum-effort/discuss/1036518/Java-3-clean-codes%3A-Dijkstra's-algo-Union-Find-Binary-search
// Leetcode 1631. Path With Minimum Effort
//Binary search + DFS
//Ref: https://www.youtube.com/watch?v=pHfGapkUEw0 Naresh Gupta

public class PathWithMinimumEffort {

	public static void main(String[] args) {

	}

	int minimumEffortPath(int[][] heights) {
		int low = 0;
		int high = 1000000;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (dfs(heights, 0, 0, heights[0][0], mid, new boolean[heights.length][heights[0].length])) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private boolean dfs(int[][] h, int i, int j, int prev, int limit, boolean[][] visited) {
		if (i < 0 || i >= h.length || j < 0 || j >= h[0].length || visited[i][j] || Math.abs(h[i][j] - prev) > limit)

			return false;

		visited[i][j] = true;

		return (i == h.length - 1 && j == h[0].length - 1) || dfs(h, i - 1, j, h[i][j], limit, visited)
				|| dfs(h, i + 1, j, h[i][j], limit, visited) || dfs(h, i, j - 1, h[i][j], limit, visited)
				|| dfs(h, i, j + 1, h[i][j], limit, visited);
	}

}

/*
 // Ref : https://www.youtube.com/watch?v=gatxvipc5b8 Coding Decoded
// BFS + Dijkstra's
class Solution {
    // TC: O(n*m*log(n*m))
    // SC: O(m*n)
    int[] dir = new int[]{ 0, 1, 0, -1, 0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] efforts = new int[m][n];
        for(int[] effort: efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0]-b[0]));
        efforts[0][0] = 0;
        
        pq.offer(new int[]{0, 0, 0});   // {cost, row, col}
            
        while(!pq.isEmpty()) {
            int[] head = pq.poll();
            int x = head[1];
            int y = head[2];
            
            int currentEffort = head[0];
            
            if(x == m-1 && y == n-1)
                return currentEffort;
            
            for(int k = 0; k<4; k++) {
                int newX = x + dir[k];
                int newY = y + dir[k+1];
                
                // k=0 x y+1
                // k=1 x+1 y
                // k=2 x y-1
                // k=3 x-1 y
                
                if(newX >= 0 && newX<m && newY>=0 && newY<n) {
                    int nextEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));
                    
                    if(nextEffort < efforts[newX][newY]) {
                        efforts[newX][newY] = nextEffort;
                        pq.offer(new int[]{nextEffort, newX, newY});
                    }
                }
            }
            
        }
        return 0;
        
     }
}
*/
