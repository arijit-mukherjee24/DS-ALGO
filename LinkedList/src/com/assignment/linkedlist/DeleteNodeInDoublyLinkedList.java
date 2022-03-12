package com.assignment.linkedlist;

// https://practice.geeksforgeeks.org/explore?page=1&company[]=Walmart&category[]=Linked%20List&sortBy=submissions
public class DeleteNodeInDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 // function returns the head of the linkedlist
    NodeD deleteNode(NodeD head,int x)
    {
	// Your code here	
	    if(head == null ) return head;
	    if(x==1) {
	        head = head.next;
	        return head;
	    }
	    
	    NodeD cur = head;
	    int c = 1;
	    while(cur != null) {
	        if(c == x) {
	            cur.prev.next = cur.next;
	            if(cur.next != null) {
	                cur.next.prev = cur.prev;
	            }
	        }
	        c++;
	        cur = cur.next;
	    }
	    return head;
    }

}

class NodeD
{
	int data;
	NodeD next;
	NodeD prev;
	NodeD(int d)
	{
		data = d;
		next = prev = null;
	}
}
