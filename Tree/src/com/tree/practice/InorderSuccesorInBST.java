package com.tree.practice;

// Lintcode 448 · Inorder Successor in BST 

//https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=50
//Take u forward TC: O(H)  SC: O(1)
public class InorderSuccesorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode successor = null;

		while (root != null) {
			if (p.val >= root.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}

	public static void main(String[] args) {

	}
}
