package com.tree.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 863. All Nodes Distance K in Binary Tree
//Ref: https://www.youtube.com/watch?v=i9ORlEy6EsI Take u forward
//TC: O(n) + O(n)    SC: O(n) + O(n) + O(n)
public class AllNodesKdistace_BT {

	public static void main(String[] args) {

	}

	// for marking the parents of all nodes
	private void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current.left != null) {
				parent_track.put(current.left, current);
				queue.offer(current.left);
			}
			if (current.right != null) {
				parent_track.put(current.right, current);
				queue.offer(current.right);
			}
		}
	}

	// driver function
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, TreeNode> parent_track = new HashMap<>();
		markParents(root, parent_track, root);
		Map<TreeNode, Boolean> visited = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(target);
		visited.put(target, true);
		int curr_level = 0;
		while (!queue.isEmpty()) { /*
									 * Second BFS to go upto K level from target node and using our hashtable info
									 */
			int size = queue.size();
			if (curr_level == k)
				break;
			curr_level++;
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if (current.left != null && visited.get(current.left) == null) {
					queue.offer(current.left);
					visited.put(current.left, true);
				}
				if (current.right != null && visited.get(current.right) == null) {
					queue.offer(current.right);
					visited.put(current.right, true);
				}
				if (parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
					queue.offer(parent_track.get(current));
					visited.put(parent_track.get(current), true);
				}
			}
		}
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			result.add(current.val);
		}
		return result;
	}

}
