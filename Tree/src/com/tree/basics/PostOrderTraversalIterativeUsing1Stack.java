package com.tree.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 145. Binary Tree Postorder Traversal
// Ref: https://youtu.be/NzIGLLwZBS8		Take u forward
// TC:O(n)  SC: O(n)
public class PostOrderTraversalIterativeUsing1Stack {

	public static void main(String[] args) {

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		List<Integer> postOrder = new ArrayList<Integer>();

		if (root == null)
			return postOrder;

		TreeNode current = root;
		while (current != null || !st1.isEmpty()) {
			if (current != null) {
				st1.push(current);
				current = current.left;
			} else {
				TreeNode temp = st1.peek().right;
				if (temp == null) {
					temp = st1.pop();
					postOrder.add(temp.val);
					while (!st1.isEmpty() && temp == st1.peek().right) {
						temp = st1.pop();
						postOrder.add(temp.val);
					}
				} else {
					current = temp;
				}
			}
		}

		return postOrder;
	}

}
