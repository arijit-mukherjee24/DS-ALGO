package com.tree.practice;

import java.util.Stack;

//653. Two Sum IV - Input is a BST

//Ref: https://www.youtube.com/watch?v=ssL3sHwPeb4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=52

//Take u forward (Solution based on BST Iterator)

//TC: O(n)   SC: O(H)*2

class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	boolean reverse = true;

	public BSTIterator(TreeNode root, boolean isReverse) {
		reverse = isReverse;
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		if (reverse == false)
			pushAll(tmpNode.right);
		else
			pushAll(tmpNode.left);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		while (node != null) {
			stack.push(node);
			if (reverse == true) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
	}
}

public class TwoSumIV_BSTIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		BSTIterator l = new BSTIterator(root, false);
		BSTIterator r = new BSTIterator(root, true);

		int i = l.next();
		int j = r.next();
		while (i < j) {
			if (i + j == k)
				return true;
			else if (i + j < k)
				i = l.next();
			else
				j = r.next();
		}
		return false;
	}

}
