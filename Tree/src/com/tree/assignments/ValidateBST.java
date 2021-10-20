package com.tree.assignments;

// 98. Validate Binary Search Tree
// Ref: https://www.youtube.com/watch?v=TKvbwPIOGCM Techdose
public class ValidateBST {

	public static void main(String[] args) {

	}

	// driver function
	public boolean isValidBST(TreeNode root) {
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

