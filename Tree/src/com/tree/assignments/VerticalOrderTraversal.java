package com.tree.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// 987. Vertical Order Traversal of a Binary Tree
// https://www.youtube.com/watch?v=q_a6lpbKJdw Take u forward
class Tuple {
	TreeNode node;
	int row;
	int col;

	public Tuple(TreeNode _node, int _row, int _col) {
		node = _node;
		row = _row;
		col = _col;
	}
}

public class VerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		List<List<Integer>> list =  verticalTraversal(node);
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        
        while(!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            
            if(!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            
            if(!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            map.get(x).get(y).offer(node.val);
            
             if(node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1)); 
            } 
            if(node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1)); 
            }
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodesPQ: ys.values()) {
                while(!nodesPQ.isEmpty()) {
                    list.get(list.size() - 1).add(nodesPQ.poll());
                }
            }
        }
        
        return list;
    }

}
