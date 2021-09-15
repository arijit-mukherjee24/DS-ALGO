package com.heap;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/merge-k-sorted-lists/discuss/609906/Java-oror-Heap-oror-PriorityQueue-oror-n-log-k
//ref: https://www.youtube.com/watch?v=kpCesr9VXDA Techdose

// https://leetcode.com/problems/merge-k-sorted-lists/ Leetcode 23

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeKSortedList {

	public static ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
		// 2, 3
		for (ListNode head : lists) {
			if (head != null)
				heap.add(head);
		}
		if (heap.isEmpty())
			return null;
		ListNode t = heap.poll();
		if (t.next != null)
			heap.add(t.next);

		ListNode head = new ListNode(t.val);
		ListNode temp = head;

		while (!heap.isEmpty()) {
			ListNode curr = heap.poll();
			if (curr.next != null)
				heap.add(curr.next);

			ListNode node = new ListNode(curr.val);
			temp.next = node;
			temp = temp.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode[] arr = new ListNode[3];

		arr[0] = new ListNode(1);
		arr[0].next = new ListNode(4);
		arr[0].next.next = new ListNode(5);

		arr[1] = new ListNode(1);
		arr[1].next = new ListNode(3);
		arr[1].next.next = new ListNode(4);

		arr[2] = new ListNode(2);
		arr[2].next = new ListNode(6);

		ListNode head = mergeKLists(arr);
		while (head != null) {
			System.out.print(head.val + "->");

			head = head.next;
		}
		System.out.println();
	}


}
