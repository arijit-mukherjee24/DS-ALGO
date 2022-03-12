package intuit;
// Leetcode 547. Number of Provinces

// number-of-connected-components-in-an-undirected-graph (same)
// GFG https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/

public class Q10_NumberofProvinces {

	public static void main(String[] args) {
		int[][] isConn = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(isConn));
	}

	public static int findCircleNum(int[][] isConnected) {
		// No of vertices
		int v = isConnected.length;

		// for storing the no of components
		int result = 0;
		boolean[] visited = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfsUtil(i, visited, isConnected);
				result++;
			}
		}
		return result;
	}

	private static void dfsUtil(int v, boolean[] visited, int[][] isConnected) {
		visited[v] = true; // making the visiting node as true
		for (int j = 0; j < isConnected.length; j++) { // v * v matrix
			// If the current node is not visited and there is node exist from v to j, then
			// only we further explore
			if (!visited[j] && isConnected[v][j] == 1) {
				dfsUtil(j, visited, isConnected);
			}
		}
	}

}

/*
// union find equivalent to finding number of connected components
class Solution {
    public int findCircleNum(int[][] M) {
        int count = M.length;
        int[] root = new int[M.length];   // Parent array
        for(int i=0;i<M.length;i++){
            root[i] = i;
        }
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    int rooti = findRoot(root,i);
                    int rootj = findRoot(root,j);
                    if(rooti!=rootj){
                        root[rooti] = rootj;
                        count--;
                    }
                }
            }
        }
        return count;
    }
    public int findRoot(int[] roots,int id){
        if(roots[id] == id) {
            return id;
        }
        else {
            return roots[id] = findRoot(roots,  roots[id]);  // Using path compression
        }
    }
}
*/
