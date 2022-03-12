package com.assignment.linkedlist;

// Leetcode 25. Reverse Nodes in k-Group
// GFG
// https://www.youtube.com/watch?v=znQ8wJxnRao Code Library
public class ReverseNodesInK_Grp {

	static ListNode head;

	public static void main(String[] args) {
		ReverseNodesInK_Grp list = new ReverseNodesInK_Grp();
		int k = 3;
		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(4);
		list.head.next.next.next.next = new ListNode(5);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverseKGroup(head, k);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode current = head;
		ListNode next = null;
		ListNode prev = null;

		int leftNodeCount = 0;
		// counting total left nodes;
		while (current != null) {
			current = current.next;
			leftNodeCount++;
		}
		current = head;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list starting
		 * from current. And make rest of the list as next of first node
		 */
		if (next != null && leftNodeCount - count >= k)
			head.next = reverseKGroup(next, k);
		else
			head.next = next;

		// prev is now head of input list
		return prev;
	}

	// prints content of double linked list
	void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

}
