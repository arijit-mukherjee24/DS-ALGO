package com.tree.assignments;

// 1534 · Convert Binary Search Tree to Sorted Doubly Linked List  [https://www.lintcode.com/problem/1534/]
// Ref:  https://www.youtube.com/watch?v=WBsNE_DWk9U Pepcoding (3rd Approach)
// TC: O(n)  SC: O(1)
// Primary Undersatnding: Code Library
public class BSTtoSortedCircularDoublyLinkedList {

	public static void main(String[] args) {

	}

	private static TreeNode prev = null;

	// helper function
	private static void bToDLLHelper(TreeNode root) {
		if (root == null)
			return;

		// Inplace traversal
		bToDLLHelper(root.left);

		prev.right = root;
		root.left = prev;
		prev = root;

		bToDLLHelper(root.right);

	}

	/**
	 * @param root: root of a tree
	 * @return: head node of a doubly linked list
	 */
	public TreeNode treeToDoublyList(TreeNode root) {
		TreeNode dummy = new TreeNode(-1);
		prev = dummy;
		bToDLLHelper(root);

		TreeNode head = dummy.right;

		// removing the dummyNode
		dummy.right = head.left = null;

		// circular
		head.left = prev;
		prev.right = head;

		return head;
	}

}

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
