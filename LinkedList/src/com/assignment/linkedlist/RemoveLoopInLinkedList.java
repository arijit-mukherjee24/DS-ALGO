package com.assignment.linkedlist;

//https://www.youtube.com/watch?v=aIR0s1tY2Vk Code Library

// https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1/?page=1&company[]=Walmart&category[]=Linked%20List&sortBy=submissions
public class RemoveLoopInLinkedList {

	public static void main(String[] args) {

	}

	// Function to remove a loop in the linked list.
	public static void removeLoop(Node head) {
		// code here
		// remove the loop without losing any nodes

		Node slow = head;
		Node fast = head;
		int flag = 0;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			slow = head;
			if (slow != fast) {
				while (slow.next != fast.next) {
					slow = slow.next;
					fast = fast.next;
				}

			} else {// when they meet at the head-- very very imp
				while (fast.next != slow) {
					fast = fast.next;
				}
			}
			fast.next = null;
		}
	}

}

class Node
{
    int data;
    Node next;
}
