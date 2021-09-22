package com.assignment.linkedlist;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

// Ref: https://www.youtube.com/watch?v=EvjpRN9CpDI Code Library
// Leetcode 2. Add two numbers
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int c = 0; // carry
		int s = 0; // sum

		ListNode curr = null;
		ListNode res = null;
		ListNode temp;

		while (l1 != null || l2 != null) {
			s = c + ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0);
			c = (s >= 10) ? 1 : 0;
			s = s % 10;
			temp = new ListNode(s);
			if (res == null) {
				res = temp;
			} else {
				curr.next = temp;
			}
			curr = temp;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;

		}

		if (c > 0) {
			temp = new ListNode(c);
			curr.next = temp;
			curr = temp;
		}
		return res;

	}
}
