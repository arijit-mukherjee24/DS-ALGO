package com.tree.practice;

// https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos

// Ceil in a BST
// https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43 Take u forward
public class CeilinBST {

	public static void main(String[] args) {

	}

	public static int findCeil(TreeNode root, int key) {
		int ceil = -1;
		while (root != null) {
			if (root.val == key) {
				ceil = root.val;
				return ceil;
			}

			if (key > root.val) {
				root = root.right;
			} else {
				ceil = root.val;
				root = root.left;
			}
		}
		return ceil;
	}

}
