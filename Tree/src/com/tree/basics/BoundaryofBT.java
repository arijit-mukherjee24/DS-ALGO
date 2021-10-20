package com.tree.basics;

import java.util.ArrayList;
import java.util.List;

// 878 · Boundary of Binary Tree Lintcode

//Ref: https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21
// Take u forward
public class BoundaryofBT {

	public static void main(String[] args) {

	}

	Boolean isLeaf(TreeNode root) {
		return (root.left == null) && (root.right == null);
	}

	void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
		TreeNode cur = root.left;
		while (cur != null) {
			if (isLeaf(cur) == false)
				res.add(cur.val);
			if (cur.left != null)
				cur = cur.left;
			else
				cur = cur.right;
		}
	}

	void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
		TreeNode cur = root.right;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while (cur != null) {
			if (isLeaf(cur) == false)
				tmp.add(cur.val);
			if (cur.right != null)
				cur = cur.right;
			else
				cur = cur.left;
		}
		int i;
		for (i = tmp.size() - 1; i >= 0; --i) {
			res.add(tmp.get(i));
		}
	}

	void addLeaves(TreeNode root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.val);
			return;
		}
		if (root.left != null)
			addLeaves(root.left, res);
		if (root.right != null)
			addLeaves(root.right, res);
	}

	/**
	 * @param root: a TreeNode
	 * @return: a list of integer
	 */
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		if (!isLeaf(root))
			ans.add(root.val);

		addLeftBoundary(root, ans);
		addLeaves(root, ans);
		addRightBoundary(root, ans);
		return ans;
	}

}
