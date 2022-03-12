package com.assignment.linkedlist;

// Leetcode 206. Reverse Linked List
// https://www.youtube.com/watch?v=ugQ2DVJJroc Anuj Bhaiya Recursion 
public class ReverseLinkedList_Recursive {

	static ListNode head;

	public static void main(String[] args) {
		ReverseLinkedList_Recursive list = new ReverseLinkedList_Recursive();
		list.head = new ListNode(1);
		list.head.next = new ListNode(2);
		list.head.next.next = new ListNode(3);
		list.head.next.next.next = new ListNode(5);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverseList(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = reverseList(head.next);

		ListNode headNext = head.next;
		headNext.next = head;
		head.next = null;

		return newHead;
	}

	// prints content of double linked list
	void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

}
