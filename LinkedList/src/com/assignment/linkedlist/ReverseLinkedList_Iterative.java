package com.assignment.linkedlist;

// Leetcode 206. Reverse Linked List
// https://www.youtube.com/watch?v=iRtLEoL-r-g&list=PLgUwDviBIf0r47RKH7fdWN54AbWFgGuii&index=1 Take u forward
public class ReverseLinkedList_Iterative {
	
	static ListNode head;
	
	public static void main(String[] args) {
		ReverseLinkedList_Iterative list = new ReverseLinkedList_Iterative();
		list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        
        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverseList(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
	}
	
	public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        
        ListNode current = head;
        ListNode prev = null;
        
        while(current !=null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }  
        head = prev;
        return prev;
    }
	
	// prints content of double linked list
    void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}



class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
