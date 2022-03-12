package com.assignment.linkedlist;

// Leetcode 142. Linked List Cycle II
// https://www.youtube.com/watch?v=JA0btO100c0 Code Library

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class StartingNodeinLoopLinkedList {
	public ListNode detectCycle(ListNode head) {
		ListNode low = head;
		ListNode high = head;
		if (head == null || head.next == null)
			return null;

		while (low != null && high != null && high.next != null) {
			low = low.next;
			high = high.next.next;
			if (low == high)
				break;
		}

		if (low != high)
			return null;

		low = head;
		while (low != high) {
			low = low.next;
			high = high.next;
		}

		return high;

	}
}
