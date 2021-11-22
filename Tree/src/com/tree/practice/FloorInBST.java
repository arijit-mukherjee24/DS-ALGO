package com.tree.practice;

// Floor in BST:
// https://www.youtube.com/watch?v=xm_W1ub-K-w&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43	Take o forward

// https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=1
public class FloorInBST {

	public static void main(String[] args) {

	}

	public static int floorInBST(TreeNode root, int key) {
		int floor = -1;
		while (root != null) {
			if (root.val == key) {
				floor = root.val;
				return floor;
			}

			if (key > root.val) {
				floor = root.val;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return floor;
	}

}
