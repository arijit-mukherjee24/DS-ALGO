package com.tree.basics;

// 110. Balanced Binary Tree
public class BalancedBT {

	public static void main(String[] args) {

	}

	/*
	 * boolean balance = true; public boolean isBalanced(TreeNode root) {
	 * height(root); return balance; }
	 * 
	 * int height(TreeNode node){ if(node==null){ return 0; } int left =
	 * height(node.left); int right = height(node.right);
	 * 
	 * if(Math.abs(left-right)<=1 && balance){ balance = true; } else{ balance =
	 * false; }
	 * 
	 * return Math.max(left,right) + 1; }
	 */

	// Ref: https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
	// Take u forward
	public boolean isBalanced(TreeNode root) {
		return dfsHeight(root) != -1;
	}

	int dfsHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = dfsHeight(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = dfsHeight(root.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
