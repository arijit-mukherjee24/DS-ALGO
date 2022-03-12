package com.tree.assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// Refer Top View Soln
public class BottomViewofBinaryTree {

	public static void main(String[] args) {
		
	}
	//Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(NodeB root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        Queue<PairB> q = new LinkedList<>();
        q.add(new PairB(root, 0));
        
        Map<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty()) {
            PairB p = q.poll();
            int hd = p.hd;
            NodeB node = p.node;
            
            //if(!map.containsKey(hd)) {
                map.put(hd, node.data);
            // }
            
            if(node.left != null) {
                q.add(new PairB(node.left, hd-1));
            }
            
             if(node.right != null) {
                q.add(new PairB(node.right, hd+1));
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;

    }
}

class PairB {
    int hd;
    NodeB node;
    
    public PairB() {}
    
    public PairB(NodeB node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class NodeB
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    NodeB left, right; //left and right references
 
    // Constructor of tree node
    public NodeB(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}


