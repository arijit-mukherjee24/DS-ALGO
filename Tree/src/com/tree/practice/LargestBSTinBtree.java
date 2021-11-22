package com.tree.practice;

// https://www.youtube.com/watch?v=X0oXMdtUDwo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=54 Take u Forward
// Largest BST in Binary Tree
public class LargestBSTinBtree {

	public static void main(String[] args) {

	}

	private NodeValue largestBSTSubtreeHelper(TreeNode root) {
		// An empty tree is a BST of size 0.
		if (root == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		// Get values from left and right subtree of current tree.
		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		// Current node is greater than max in left AND smaller than min in right, it is
		// a BST.
		if (left.maxNode < root.val && root.val < right.minNode) {
			// It is a BST.
			return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
					left.maxSize + right.maxSize + 1);
		}

		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}

	public int largestBSTSubtree(TreeNode root) {
		return largestBSTSubtreeHelper(root).maxSize;
	}

}

class NodeValue {
	public int maxNode, minNode, maxSize;

	NodeValue(int minNode, int maxNode, int maxSize) {
		this.maxNode = maxNode;
		this.minNode = minNode;
		this.maxSize = maxSize;
	}
};
