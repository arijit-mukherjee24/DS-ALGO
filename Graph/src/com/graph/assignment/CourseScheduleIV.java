package com.graph.assignment;
//Leetcode 1462. Course Schedule IV

import java.util.ArrayList;
import java.util.List;

//Ref: Floyd Warshall Algo
//https://leetcode.com/problems/course-schedule-iv/discuss/660509/JavaPython-FloydWarshall-Algorithm-Clean-code-O(n3)

/*
Idea

This problem is to check if 2 vertices are connected in directed graph.
Floyd-Warshall O(n^3) is an algorithm that will output the minium distance of any vertices. We can modified it to output if any vertices is connected or not.

Complexity:

Time: O(n^3)
Space: O(n^2)

*/
public class CourseScheduleIV {

	public static void main(String[] args) {

	}

	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		List<Boolean> ans = new ArrayList<>(queries.length);
		int n = numCourses;
		boolean[][] connected = new boolean[n][n];

		for (int[] p : prerequisites) {
			connected[p[0]][p[1]] = true;
		}

		// Floyd Warshall Shotest Path Algo
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];

		for (int[] q : queries)
			ans.add(connected[q[0]][q[1]]);

		return ans;
	}

}
