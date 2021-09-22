package com.assignment.linkedlist;

// Leetcode 234. Palindrome Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// https://www.youtube.com/watch?v=7zzWLuDu7M4 Code Library

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return false;

		// Finding the middle node
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Reverse the node from the middle to the end
		ListNode prev = null;
		ListNode next;
		ListNode curr = slow;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		// Traverse from both the ends
		fast = head;
		while (prev != null) {
			if (prev.val != fast.val)
				return false;
			prev = prev.next;
			fast = fast.next;
		}

		return true;
	}
}
