package com.tree.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// 94. Binary Tree Inorder Traversal
//https://www.youtube.com/watch?v=lxTGsVXjwvM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=11 Take u forward
//TC: O(n) SC: O(n)
public class InOrderTraversalIterative {

	public static void main(String[] args) {
		
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder; 
    }

}

/*https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=38 Take u forward
TC: O(n)  SC: O(1)
--> Morris Traveral
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>(); 
        
        TreeNode cur = root; 
        while(cur != null) {
            if(cur.left == null) {
                inorder.add(cur.val); 
                cur = cur.right; 
            }
            else {
                TreeNode prev = cur.left; 
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right; 
                }
                
                if(prev.right == null) {
                    prev.right = cur;  
                    // inorder.add(cur.val);  Add here for preorder traversal
                    cur = cur.left; 
                }
                else {
                    prev.right = null; 
                    inorder.add(cur.val); // remove  this for preorder taversal
                    cur = cur.right; 
                }
            }
        }
        return inorder; 
    }
}
*/
