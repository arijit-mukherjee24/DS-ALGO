package com.tree.practice;

// 700. Search in a Binary Search Tree

//Ref: https://www.youtube.com/watch?v=KcNt6v_56cc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=41 Take u forward
//TC: log2(N)
public class SearchInBST {

	public static void main(String[] args) {

	}

	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null && root.val != val) {
			if (root.val > val)
				root = root.left;
			else
				root = root.right;
		}
		return root;
	}

}
