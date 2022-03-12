package com.tree.assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 103. Binary Tree Zigzag Level Order Traversal
// Ref: https://www.youtube.com/watch?v=3OXWEdlIGl4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=20 Take u Forward
public class ZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        boolean flag = true; 
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>(levelNum);
            for(int i=0; i<levelNum; i++) {
                // int index = i;
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(flag == true) subList.add(queue.poll().val);
                else subList.add(0, queue.poll().val);
            }
            flag = !flag; 
            wrapList.add(subList);
        }
        return wrapList;
        
       /*List<List<Integer>> result = new ArrayList();
        
        if(root==null){
            return result;
        }
        
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.add(root);
        int level=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                int x=node.val;
                
                if(level%2==0){
                    list.add(x);
                }
                else{
                    list.add(0,x);
                }
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            level++;
            result.add(list);
        }
        return result;*/
    
    }

}

/* GFG Soln https://practice.geeksforgeeks.org/viewSol.php?subId=51e7d9637bd22c868aa80868e0fd3005&pid=700688&user=arijitcode10
 
 //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	   ArrayList<Integer> res = new ArrayList<Integer>();
	   Queue<Node> q = new LinkedList<>();
	   q.add(root);
	   
	   boolean l2r = true;
	   while(!q.isEmpty()) {
	       int size = q.size();
	       
	       ArrayList<Integer> sublist = new ArrayList<Integer>();
	       for(int i=0; i<size; i++) {
	           Node temp = q.poll();
	           if(temp.left != null)
	                q.add(temp.left);
                
                if(temp.right != null) 
                    q.add(temp.right);
                
                if(l2r) 
                    sublist.add(temp.data);
                else 
                    sublist.add(0,temp.data);
	       }
	       
	       for(int j = 0; j<sublist.size(); j++) {
	           res.add(sublist.get(j));
	       }
	       
	       l2r = !l2r;
	   }
	   return res;
	}
	
	
*/
