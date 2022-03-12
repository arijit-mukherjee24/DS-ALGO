package com.tree.assignments;

// 98. Validate Binary Search Tree
// Ref: https://www.youtube.com/watch?v=TKvbwPIOGCM Techdose
public class ValidateBST {

	public static void main(String[] args) {

	}

	// driver function - Techdose
	/*public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		if (checkBST(root.left, Long.MIN_VALUE, root.val) && checkBST(root.right, root.val, Long.MAX_VALUE))
			return true;

		return false;
	}

	public boolean checkBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;

		if (root.val > min && root.val < max) {
			return (checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max));
		}

		return false;
	}*/
	
	 //Function to check whether a Binary Tree is BST or not.
	// Striver TC: O(n)  SC: O(1)
	// https://www.youtube.com/watch?v=f-sj7I5oXEI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=47
    // driver fnc
    boolean isBST(TreeNode root)
    {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    static boolean isValid(TreeNode node, int min, int max) {
        if(node == null) return true;
        
        if(node.val >= max || node.val <=min) return false;
        
        return isValid(node.left, min, node.val)
                && isValid(node.right, node.val, max);
    }
	

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

