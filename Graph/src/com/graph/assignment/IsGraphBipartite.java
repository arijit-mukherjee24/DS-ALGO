package com.graph.assignment;
// 785. Is Graph Bipartite?

// Ref: https://www.youtube.com/watch?v=-SpTh4AEZrk Algorithms Made Easy
// Graph Colouring : DFS 
// 0 -> Not coloured    1 -> Blue     -1 -> red 
public class IsGraphBipartite {

	public static void main(String[] args) {
		
	}
	
	public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        
        for(int i = 0; i< graph.length; i++) {
            if(color[i] == 0 && !validColor(graph, color, 1, i)) 
                return false;
        }
        
        return true;
    }
    
    private boolean validColor(int[][] g, int[] color, int c, int node) {
        if(color[node] != 0)
            return color[node] == c;
        
        color[node] = c;
        
        for(int n: g[node]) {
            if(!validColor(g, color, -c, n)) return false;
        }
        return true;
    }
    
 // TC: O(V + E)
 // TC: O(V)
}

/* BFS
 // Ref: https://www.youtube.com/watch?v=-SpTh4AEZrk Algorithms Made Easy
// Graph Colouring : BFS 
// 0 -> Not coloured    1 -> Blue     -1 -> red 
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        
        for(int i = 0; i< graph.length; i++) {
            if(color[i] == 0) {
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(i);
                color[i] = 1;
                
                while(!q.isEmpty()) {
                    int node = q.poll();
                    for(int ng : graph[node]) {
                        if(color[ng] == color[node]) 
                            return false;
                        else if(color[ng] == 0) {
                            q.add(ng);
                            color[ng] = -color[node];
                        }
                    }
                }
            }
        }
        
        return true;
    }
}

// TC: O(V + E)
// TC: O(V)
 */

/* DSUF - Union and find
 // Ref: https://www.youtube.com/watch?v=-SpTh4AEZrk Algorithms Made Easy
// Using Disjoint Set : Union and find
class Solution {
    int[] parent;
    public boolean isBipartite(int[][] graph) {
       parent = new int[graph.length];
       for(int i = 0; i<parent.length; i++) {
            parent[i] = i;
       }
        
       for(int i = 0; i< graph.length; i++) {
           int[] nodes = graph[i];
           for(int n: nodes) {
               if(find(n) == find(i))  // parent[i] == parent[i]
                   return false;
               
               union(n, nodes[0]);
           }
       }
     return true;
    }
    
    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX != parentY) {
            parent[parentX] = parentY;
        } 
    }
    
    private int find(int i) {
        if(parent[i] == i)  // Not attached to anything and referring to itself
            return i;
        
        return parent[i] = find(parent[i]);
    }
}

// TC: O(V + E)
// TC: O(V)
 */
