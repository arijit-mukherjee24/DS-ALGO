package com.graph.assignment;
// Leetcode 133. Clone Graph
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {

	public static void main(String[] args) {
		
	}
	
	public Nodec cloneGraph(Nodec start) {
		if(start == null) return null;
		HashMap<Nodec, Nodec> map = new HashMap<>();                      // for each Nodecc in graph we create a new Nodecc
		map.put(start, new Nodec(start.val, new ArrayList<Nodec>()));     // add starting Nodecc
		Queue<Nodec> q = new LinkedList<>();                             // queue for bfs
		q.offer(start);                                                 // add start Nodecc to queue
		while(!q.isEmpty()) {                                           // iterate until queue is empty
			Nodec curr = q.poll();                                       // get the first Nodecc in queue
			for(Nodec n : curr.neighbors) {                              // for every neighbor of first Nodecc
				if(!map.containsKey(n)) {                               // if neighbor not in map
					map.put(n, new Nodec(n.val, new ArrayList<Nodec>())); // create new Nodecc for neighbor
					q.offer(n);                                         // also add neighbor to queue
				}
				map.get(curr).neighbors.add(map.get(n));                // add neighbor to list of neighbors of first Nodecc  
			}
		} 
		return map.get(start);                                          // return the duplicate of start Nodecc

}

}

class Nodec{
	public int val;
	public List<Nodec> neighbors;

	public Nodec() {
		val = 0;
		neighbors = new ArrayList<Nodec>();
	}

	public Nodec(int _val) {
		val = _val;
		neighbors = new ArrayList<Nodec>();
	}

	public Nodec(int _val, ArrayList<Nodec> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

/*
Ref : https://www.youtube.com/watch?v=y5u74DCEnBc Naresh Gupta
// DFS Solution
class Solution {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap());
    }
    
    private Node cloneGraph(Node node, HashMap<Node, Node> map) {
        if(node == null)
            return null;
        
        if(map.containsKey(node))
            return map.get(node);
        
        Node root = new Node(node.val);
        map.put(node, root);
        
        for(Node ng: node.neighbors) {
            root.neighbors.add(cloneGraph(ng, map));
        }
        return root;
    }
}
*/
