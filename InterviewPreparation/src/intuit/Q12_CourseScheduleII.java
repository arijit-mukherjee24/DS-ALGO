package intuit;

import java.util.ArrayList;
import java.util.Stack;

// Leetcode 210. Course Schedule II
//Ref: Techdose 

public class Q12_CourseScheduleII {

	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = { { 1,0 }, { 2,0 }, { 3,1 }, { 3,2 } };
		int[] ans = findOrder(numCourses, prerequisites);
		System.out.println("The result");
		for(int i: ans)
			System.out.print(i + " ");
	}

	// Cycle detection
	private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int n) {
		// this will maintain the state of every node/vertice
		/*
		 * 0 -> unvisited (default) 1 -> processed 2 -> processing sequence -> 0 2 1
		 */
		int[] visited = new int[n];
		for (int i = 0; i < n; i++)
			if (visited[i] == 0)
				if (isCycleExist(i, adj, visited))
					return true;

		return false;
	}

	// check if the given graph has cycle of not
	// (Refer techdose video : course schedule graph colouring cycle detection)
	private static boolean isCycleExist(int currNode, ArrayList<ArrayList<Integer>> adj, int[] visited) {

		// check if the current node was already in processing state
		if (visited[currNode] == 2) {
			return true; // cycle is present
		}

		// change state of current node to processing (i.e. 2)
		visited[currNode] = 2;

		// traverse all neighbours of current node
		for (int neighbour : adj.get(currNode)) {
			// check if the neigbour is already processed or not
			if (visited[neighbour] != 1) {
				// if it's not processed
				if (isCycleExist(neighbour, adj, visited)) {
					return true;// cycle is present
				}
			}
		}

		// update the state of current node from processing(2) -> processed(1)
		visited[currNode] = 1;
		return false;// no cycle exists

	}

	// Topological sort
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, Stack<Integer> mystack) {
		visited[v] = true;
		for (int i = 0; i < adj.get(v).size(); i++)
			if (!visited[adj.get(v).get(i)])
				dfs(adj, adj.get(v).get(i), visited, mystack);

		// added in the stack while backtracking
		mystack.push(v);
	}

	// driver function
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(numCourses);

		// add empty array list for every node/vertices
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// add edges to adjacency list
		for (int i = 0; i < prerequisites.length; i++) {
			adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		int[] ans = new int[numCourses];

		// Detect CYCLE...If present then return empty array
		if (detectCycle(adj, numCourses))
			return new int[0];

		// Find toposort and store it in stack
		Stack<Integer> mystack = new Stack<>();
		boolean[] visited = new boolean[numCourses]; // by default all values are initialized with false

		// Apply DFS and find topological sort
		for (int i = 0; i < numCourses; i++)
			if (!visited[i])
				dfs(adj, i, visited, mystack);

		int index = ans.length - 1;
		while (!mystack.empty()) {
			ans[index--] = mystack.pop();
		}
		return ans;

	}
}
