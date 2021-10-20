package com.tree.assignments;

// 1448. Count Good Nodes in Binary Tree
//Ref: https://www.youtube.com/watch?v=Ho22p_2JBWA Naresh 
//https://leetcode.com/problems/count-good-nodes-in-binary-tree/discuss/635259/JavaC%2B%2BPython-One-line For the recursive diagram

//TC = O(N);
// Call stack
public class CountGoodNodes {

	public static void main(String[] args) {

	}

	// driver function
	public int goodNodes(TreeNode root) {
		if (root == null)
			return 0;
		return dfs(root, root.val);
	}

	private int dfs(TreeNode root, int max) {
		if (root == null)
			return 0;

		max = Math.max(max, root.val);
		if (root.val >= max)
			return 1 + dfs(root.left, max) + dfs(root.right, max);
		else
			return dfs(root.left, max) + dfs(root.right, max);
	}

}
