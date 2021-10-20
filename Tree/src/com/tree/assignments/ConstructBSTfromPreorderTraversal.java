package com.tree.assignments;

import java.util.Stack;

// 1008. Construct Binary Search Tree from Preorder Traversal

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/252754/Java-Stack-Iterative-Solution

//look for the comment for the dry run in the comments
public class ConstructBSTfromPreorderTraversal {

	public static void main(String[] args) {

	}

	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);

		for (int i = 1; i < preorder.length; i++) {
			TreeNode node = new TreeNode(preorder[i]);
			if (preorder[i] < stack.peek().val) {
				stack.peek().left = node;
			} else {
				TreeNode parent = stack.peek();
				// check for the dry run
				while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
					parent = stack.pop();
				}
				parent.right = node;
			}
			stack.push(node);
		}
		return root;
	}

}
