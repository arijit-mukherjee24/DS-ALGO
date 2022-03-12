package com.assignment.linkedlist;

public class ReverseAlternateNodesInLinkedList {

	public static void main(String[] args) {
		
	}
	
	/*    Approach: 

	1.The idea is to maintain two linked lists, one list of all odd positioned nodes and other list of all even positioned nodes .
	2.Traverse the given linked list which is considered as an odd list or oddly positioned nodes.
	3.If the node is even node, remove it from the odd list and add it to the front of even node list. 
	  Nodes are added at front to keep the reverse order.
	4.Append the even node list at the end of odd node list.

	*/
	    public static void rearrange(NodeR odd)
	    {
	        if (odd == null || odd.next == null || odd.next.next == null)
	                   return;
	                   
	        NodeR even = odd.next;
	        odd.next = odd.next.next;
	        odd = odd.next;
	        even.next = null;
	        while (odd != null && odd.next != null)
	        {  
	        	NodeR temp = odd.next.next;
	            odd.next.next = even;
	            even = odd.next;
	            odd.next = temp;
	            
	            if (temp != null)
	                odd = temp;
	        }
	        odd.next = even;
	    }

	
}

class NodeR
{
    int data;
    NodeR next;
    NodeR(int key)
    {
        data = key;
        next = null;
    }
}
