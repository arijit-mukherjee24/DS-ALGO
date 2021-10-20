package com.tree.basics;

// 543. Diameter of Binary Tree
// Ref: https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17 Take u forward
public class DiameterofBT {

	public static void main(String[] args) {

	}

	int ans = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			height(root);
		}

		return ans;
	}

	int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftTree = height(node.left);
		int rightTree = height(node.right);

		ans = Math.max(ans, leftTree + rightTree);
		return Math.max(leftTree, rightTree) + 1;
	}

}
