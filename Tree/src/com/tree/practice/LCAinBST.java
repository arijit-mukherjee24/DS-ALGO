package com.tree.practice;

// 235. Lowest Common Ancestor of a Binary Search Tree

// Ref: https://www.youtube.com/watch?v=cX_kPV_foZc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=48 Take u forward
public class LCAinBST {

	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);

		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);

		return root;
	}

}
