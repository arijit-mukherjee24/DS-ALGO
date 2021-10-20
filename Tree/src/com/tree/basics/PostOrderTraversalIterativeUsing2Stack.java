package com.tree.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 145. Binary Tree Postorder Traversal
//https://www.youtube.com/watch?v=2YBhNLodD8Q&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=12 Take u forward
//Using 2 stack - TC: O(n) SC: O(2n)
public class PostOrderTraversalIterativeUsing2Stack {

	public static void main(String[] args) {

	}

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();
		List<Integer> postOrder = new ArrayList<Integer>();

		if (root == null)
			return postOrder;

		st1.push(root);
		while (!st1.isEmpty()) {
			root = st1.pop();
			st2.add(root);
			if (root.left != null)
				st1.push(root.left);
			if (root.right != null)
				st1.push(root.right);
		}
		while (!st2.isEmpty()) {
			postOrder.add(st2.pop().val);
		}
		return postOrder;
	}

}
