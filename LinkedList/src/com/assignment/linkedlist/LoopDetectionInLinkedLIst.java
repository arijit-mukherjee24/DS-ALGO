package com.assignment.linkedlist;

// Leetcode 141. Linked List Cycle
// GFG
// https://www.youtube.com/watch?v=C_bc2tfyM0M&t=496s Code Library
public class LoopDetectionInLinkedLIst {

	public boolean hasCycle(ListNode head) {
		ListNode slow_ptr = head;
		ListNode fast_ptr = head;

		while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;

			if (slow_ptr == fast_ptr) {
				return true;
			}
		}
		return false;
	}

}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
