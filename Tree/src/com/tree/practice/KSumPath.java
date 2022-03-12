package com.tree.practice;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=_Ng486jJu80 Code library
//https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public class KSumPath {

	public static void main(String[] args) {
		
	}
	
static List<Integer> path = new ArrayList<Integer>();
    
    public int sumK(Node root,int k)
    {
        int[] c = new int[1];
        sumKPathUtil(root, k, c);
        return c[0];
    }
    
    // This function prints all paths that have sum k
    static void sumKPathUtil(Node root, int k, int[] c)
    {
        // empty node
        if (root == null)
            return;
 
        // add current node to the path
        path.add(root.data);
 
        // check if there's any k sum path
        // in the left sub-tree.
        sumKPathUtil(root.left, k, c);
 
        // check if there's any k sum path
        // in the right sub-tree.
        sumKPathUtil(root.right, k, c);
 
        // check if there's any k sum path that
        // terminates at this node
        // Traverse the entire path as
        // there can be negative elements too
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);
 
            // If path sum is k, increase the count
            if (f == k)
               c[0]++;
        }
 
        // Remove the current element from the path
        path.remove(path.size() - 1);
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
