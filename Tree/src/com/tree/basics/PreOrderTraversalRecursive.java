package com.tree.basics;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=RlUu72JrOCQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=6 Take u forward
// 144. Binary Tree Preorder Traversal
public class PreOrderTraversalRecursive {

	public static void main(String[] args) {
		
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>(); 
        dfs(root, preorder);
        return preorder;
    }
    
    private void dfs(TreeNode node, List<Integer> preorder) {
        if(node == null) return; 
        
        preorder.add(node.val); 
        dfs(node.left, preorder);
        dfs(node.right, preorder); 
    }

}
