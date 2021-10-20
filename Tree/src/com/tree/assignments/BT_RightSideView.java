package com.tree.assignments;

import java.util.ArrayList;
import java.util.List;


// 199. Binary Tree Right Side View
//Ref: https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25 Take u forward
public class BT_RightSideView {

	public static void main(String[] args) {

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

}


/*class Solution {
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<Integer>();
    
    if(root == null) {
        return ans;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty()) {
        ans.add(queue.peek().val);
        int size = queue.size();
        
        for(int i = 0; i < size; i++) {
            TreeNode x = queue.poll();
            
            if(x.right != null) {
                queue.add(x.right);
            }
            
            if(x.left != null) {
                queue.add(x.left);
            }
            
        }
    }
    return ans;
}
}*/