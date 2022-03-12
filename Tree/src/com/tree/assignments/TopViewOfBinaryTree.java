package com.tree.assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

	public static void main(String[] args) {
		
	}
	
	//Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        Map<Integer, Integer> map = new TreeMap<>();
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int hd = p.hd;
            Node node = p.node;
            
            if(!map.containsKey(hd)) {
                map.put(hd, node.data);
            }
            
            if(node.left != null) {
                q.add(new Pair(node.left, hd-1));
            }
            
             if(node.right != null) {
                q.add(new Pair(node.right, hd+1));
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }

}

//https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=23
//STriver TC: O(n) SC: O(n)
class Pair {
 int hd;
 Node node;
 
 public Pair() {}
 
 public Pair(Node node, int hd) {
     this.node = node;
     this.hd = hd;
 }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
