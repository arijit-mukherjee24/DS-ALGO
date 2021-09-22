package com.assignment.linkedlist;

//Leetcode 83 : Remove Duplicates from Sorted List
// Ref: https://www.youtube.com/watch?v=dhLtP3UriEU Code Library
public class RemoveDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;

		ListNode curr = head;

		while (curr.next != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}

		}

		return head;
	}
}
