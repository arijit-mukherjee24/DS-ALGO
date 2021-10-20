package com.tree.assignments;

// 236. Lowest Common Ancestor of a Binary Tree
//Ref: https://www.youtube.com/watch?v=_-QHfMDde90&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=28 Take u forward
//TC: O(n) AuxSpace: O(n)
public class LowestCommonAncestor {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// base case
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// result
		if (left == null) {
			return right;
		} else if (right == null) {
			return left;
		} else { // both left and right are not null, we found our result
			return root;
		}
	}

}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */