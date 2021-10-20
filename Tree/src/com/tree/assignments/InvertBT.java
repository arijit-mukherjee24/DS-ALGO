package com.tree.assignments;

// 226. Invert Binary Tree
// Ref: https://www.youtube.com/watch?v=_i0jqdVkObU Techdose
public class InvertBT {

	public static void main(String[] args) {
		
	}
	
	public TreeNode invertTree(TreeNode root) {
        swap(root);  // creates mirror image
        return root;
    }
    
    private static void swap(TreeNode curr) {
        if(curr == null)
            return;
        
        swap(curr.left);
        swap(curr.right);
        
        // swap the child pointers
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;
    }

}
