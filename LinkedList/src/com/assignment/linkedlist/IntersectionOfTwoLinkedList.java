package com.assignment.linkedlist;

import java.util.HashSet;

public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {

	}

	public static NodeS findIntersection(NodeS head1, NodeS head2) {
		// add your code here
		// return the head of intersection list
		HashSet<Integer> st = new HashSet<Integer>();
		while (head2 != null) {
			st.add(head2.data);
			head2 = head2.next;
		}

		NodeS newHead = null, newTail = null;

		while (head1 != null) {
			if (st.contains(head1.data)) {
				if (newHead == null)
					newHead = newTail = new NodeS(head1.data);
				else {
					newTail.next = new NodeS(head1.data);
					newTail = newTail.next;
				}
			}
			head1 = head1.next;
		}

		return newHead;
	}

}

class NodeS 
{
    int data;
    NodeS next;
    
    NodeS(int a)
        {
            data = a;
            next = null;
        }
}