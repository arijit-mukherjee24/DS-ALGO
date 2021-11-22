package com.tree.practice;

// 230. Kth Smallest Element in a BST

//Ref: https://www.youtube.com/watch?v=KqMm81Y7j9M Techdose (2nd Approach)
//Here, we need to pass K as a reference, so used val
public class KthSmallestInBST {

	public static void main(String[] args) {

	}

	int val;

	public int kthSmallest(TreeNode root, int k) {
		val = k;
		return solve(root);
	}

	private int solve(TreeNode root) {
		if (root == null)
			return 0;

		int left = solve(root.left);
		if (left > 0)
			return left;
		val -= 1;
		if (val == 0)
			return root.val;
		int right = solve(root.right);
		return right;
	}

}
