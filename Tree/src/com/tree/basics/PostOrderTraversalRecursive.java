package com.tree.basics;

import java.util.ArrayList;
import java.util.List;

// 145. Binary Tree Postorder Traversal
//https://www.youtube.com/watch?v=COQOU6klsBg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=8 Take u forward
public class PostOrderTraversalRecursive {

	public static void main(String[] args) {
		
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        dfs(root, postOrder);
        return postOrder;
    }
    
    private void dfs(TreeNode node, List<Integer> postOrder) {
        if(node == null) {
            return;
        }
        
        dfs(node.left, postOrder);
        dfs(node.right, postOrder);
        postOrder.add(node.val);
    }

}
