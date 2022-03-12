package com.tree.assignments;

// RTE : https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1/?page=3&company[]=Walmart&category[]=Tree&sortBy=submissions
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalInSpiralForm {
	
	//Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(NodeL root) 
    {
       ArrayList<Integer> res = new ArrayList<Integer>();
	   Queue<NodeL> q = new LinkedList<>();
	   q.add(root);
	   
	   boolean l2r = true;
	   while(!q.isEmpty()) {
	       int size = q.size();
	       
	       ArrayList<Integer> sublist = new ArrayList<Integer>();
	       for(int i=0; i<size; i++) {
	           NodeL temp = q.poll();
	           if(temp.left != null)
	                q.add(temp.left);
                
                if(temp.right != null) 
                    q.add(temp.right);
                
                if(l2r) 
                    sublist.add(0,temp.data);
                else 
                    sublist.add(temp.data);
	       }
	       
	       for(int j = 0; j<sublist.size(); j++) {
	           res.add(sublist.get(j));
	       }
	       
	       l2r = !l2r;
	   }
	   return res;
    }
}

class NodeL
{
    int data;
    NodeL left, right;

    NodeL(int item)
    {
        data = item;
        left = right = null;
    }
}
