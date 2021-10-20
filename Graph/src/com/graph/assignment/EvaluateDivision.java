package com.graph.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Leetcode 399. Evaluate Division
// Ref: https://www.youtube.com/watch?v=UcDZM6Ap5P4 Naresh Gupta

public class EvaluateDivision {

	public static void main(String[] args) {
		// leetcode
	}
	
	// dfs
    private double dfs(String src, String des, Set<String> visited, Map<String, List<Node>> g) {
        if(!(g.containsKey(src) && g.containsKey(des)))
            return -1.0;
        
        if(src.equals(des))
            return 1.0;
        
        visited.add(src);
        for(Node node: g.get(src)) {
            if(!visited.contains(node.key)) {
                double ans = dfs(node.key, des, visited, g);
                if(ans != -1.0) {
                    return ans*node.val;
                }
            }
        }
        return -1;
    }
    
    // driver method
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        
        for(int i = 0; i< queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g);
        }
        
        return result;      
    }
    
    // method for building the graph 
    private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {
        Map<String, List<Node>> g = new HashMap<>();
        
        for(int i = 0; i < values.length; i++) {
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            
            g.putIfAbsent(src, new ArrayList<Node>());
            g.putIfAbsent(des, new ArrayList<Node>());
            
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src, 1/values[i]));
        }
        
        return g;
    }

}

class Node {
    String key;
    double val;
    public Node(String k, double v) {
        key = k;
        val = v;
    }
}
