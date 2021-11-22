package com.tree.practice;

// 1008. Construct Binary Search Tree from Preorder Traversal

//https://www.youtube.com/watch?v=UmJT3j26t1I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=49 
//Take u forward (3rd Approach) TC: O(3n) ~ O(n)   Sc: O(1)
public class ConstructBSTFromPreorder {

	public static void main(String[] args) {

	}
	
	// start
	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
	}

	private TreeNode bstFromPreorder(int[] A, int bound, int[] i) {
		if (i[0] == A.length || A[i[0]] > bound)
			return null;

		TreeNode root = new TreeNode(A[i[0]++]);

		root.left = bstFromPreorder(A, root.val, i);
		root.right = bstFromPreorder(A, bound, i);

		return root;
	}

}
