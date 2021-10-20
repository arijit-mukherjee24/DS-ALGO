package com.tree.basics;

// 124. Binary Tree Maximum Path Sum
// Ref: https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=18 Take u forward
public class BTMaximumPathSum {

	public static void main(String[] args) {

	}

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

}
