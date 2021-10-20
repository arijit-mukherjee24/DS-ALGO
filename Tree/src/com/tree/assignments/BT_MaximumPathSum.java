package com.tree.assignments;

// 124. Binary Tree Maximum Path Sum
//Ref: https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=18 Take u forward
public class BT_MaximumPathSum {

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPathDown(root);
		return maxSum;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null)
			return 0;

		int left = Math.max(0, maxPathDown(node.left)); // Avoiding the negative nodes
		int right = Math.max(0, maxPathDown(node.right)); // Avoiding the negative nodes

		maxSum = Math.max(maxSum, node.val + left + right); // calculating the max sum

		return node.val + Math.max(left, right);
	}

	public static void main(String[] args) {

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
