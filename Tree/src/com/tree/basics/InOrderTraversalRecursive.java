package com.tree.basics;

import java.util.ArrayList;
import java.util.List;

// 94. Binary Tree Inorder Traversal
//https://www.youtube.com/watch?v=Z_NEgBgbRVI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=7 Take u forward
public class InOrderTraversalRecursive {

	public static void main(String[] args) {

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        dfs(root, inorder);
        return inorder;       
    }
    
    private void dfs(TreeNode node, List<Integer> inOrder) {
        if(node == null)
            return;
        
        dfs(node.left, inOrder);
        inOrder.add(node.val);
        dfs(node.right, inOrder);
    }

}
