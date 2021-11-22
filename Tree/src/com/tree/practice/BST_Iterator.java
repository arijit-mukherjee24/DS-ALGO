package com.tree.practice;

import java.util.Stack;

// 173. Binary Search Tree Iterator

//Ref: https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=51

//Take u forward  TC: avg O(1) SC: O(H) as mentioned in the question
public class BST_Iterator {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BST_Iterator(TreeNode root) {
        pushAll(root);
    }

	public int next() {
		TreeNode node = stack.pop();
		pushAll(node.right);
		return node.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void pushAll(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

}
