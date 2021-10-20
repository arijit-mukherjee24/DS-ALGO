package com.graph.assignment;

import java.util.ArrayList;
import java.util.List;

// Leetcode 797. All Paths From Source to Target
//Ref: https://www.youtube.com/watch?v=SZ3zpzQk2jg Knowledge Center
//DFS
public class AllPathsFromSourcetoTarget {

	public static void main(String[] args) {
		
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList<Integer>();
        
        dfs(result, graph, path, 0);
        return result;
    }
    
    private static void dfs(List<List<Integer>> result, int[][] graph, List<Integer> path, int u) {
        path.add(u);
        
        if( u == graph.length - 1)
            result.add(new ArrayList(path));
        
        for(int v : graph[u])
            dfs(result, graph, path, v);
            
        path.remove(path.size() - 1);
    }
}
