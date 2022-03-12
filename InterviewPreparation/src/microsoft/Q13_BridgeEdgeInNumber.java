package microsoft;

import java.util.ArrayList;

// Ref: GFG Discussion
// https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1 gfg
public class Q13_BridgeEdgeInNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Function to find if the given edge is a bridge in graph.
    @SuppressWarnings("deprecation")
	static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        adj.get(c).remove(new Integer(d));
        adj.get(d).remove(new Integer(c));
        
        boolean vis[] = new boolean[V];
        dfs(c, adj, vis);
        
        return vis[d] ? 0 : 1;
    }
    
    static void dfs(int  node,  ArrayList<ArrayList<Integer>> adj,  boolean[] vis) {
        vis[node] = true;
        for(int it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }
}
