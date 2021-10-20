package com.tree.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10 Take u forward
// 144. Binary Tree Preorder Traversal
public class PreOrderTraversalIterative {

	public static void main(String[] args) {
		
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if(root == null) return preorder; 
        Stack<TreeNode> q = new Stack<TreeNode>(); 
        q.push(root);
        while(!q.isEmpty()){
            root = q.pop();
            preorder.add(root.val); 
            if(root.right != null){
                q.push(root.right);
            }
            if(root.left!= null){
                q.push(root.left);
            }
        }
        return preorder; 
    }

}
