package com.tree.assignments;

// 114. Flatten Binary Tree to Linked List

//Ref: https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39 Take u forward
//Recursive Approach

//TC - O(N) 
//SC - O(N)
public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {

	}

	TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}

}
