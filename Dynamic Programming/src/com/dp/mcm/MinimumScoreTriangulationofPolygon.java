package com.dp.mcm;

import java.util.Arrays;

//Ref: https://www.youtube.com/watch?v=h6MxKmDimhg Tony Teaches  Look for the approach at the end

/* n vertex polygon to n-2 triangles
we will fix the first and last vertex, and try to triangulate at each possible k
And find the min cost of among all of them
Leetcode discuss : https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/363482/Intuitive-Java-Solution-With-Explanation */

/* No of possible ways of triangulation is find using catalan of (n-2) 
Ref: https://www.youtube.com/watch?v=jSGW3YKkyHQ Pepcoding : Ways of Polygon Triangulation */

// 1039. Minimum Score Triangulation of Polygon
public class MinimumScoreTriangulationofPolygon {

	public static void main(String[] args) {
		
	}
	
static int[][] dp;
    
    public int minScoreTriangulation(int[] a) {
        dp = new int[a.length][a.length];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return helper(a, 0, a.length-1);
    }
    private int helper(int[] a, int i, int j){
        if( (j-i+1) < 3) return 0;   // triangulation not possible
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i+1; k < j; k++)  // triangle is possible b/w all vertex between i and j
            dp[i][j] = Math.min(dp[i][j], 
                                            helper(a, i, k)     // left part
                                            + a[i]*a[k]*a[j]    // actual value at that i, k, j triangle
                                            + helper(a, k, j)); // right part
        return dp[i][j];
    }

}
