package com.hashmap;

// Leetcode 138. Copy List with Random Pointer
class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		Node node = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node.next = node2;
		node.next.next = node3;
		node.next.next.next = node4;
		node.next.next.next.next = node5;

		node2.random = node;
		node.random = null;
		node3.random = node5;
		node4.random = node3;
		node5.random = node;
		Node randomCopyNode = copyRandomList(node);

		while (randomCopyNode != null) {
			System.out.println("Node: " + randomCopyNode.val);
			randomCopyNode = randomCopyNode.next;
			System.out.println();
		}

	}

	/*
	 * TC: O(n + n) SC: O(n) Using extra space HashMap
	 * 
	 * public Node copyRandomList(Node head) { // hashmap to store nodes and copies
	 * Map<Node,Node> map = new HashMap<>(); Node ptr = head; // iterate the
	 * original list and make copies of each node while(ptr!=null) { Node copied =
	 * new Node(ptr.val); //add (original, copy) to hashmap map.put(ptr, copied);
	 * ptr = ptr.next; }
	 * 
	 * // iterate back through the list ptr = head; while(ptr!=null) { //update the
	 * next and ranom fields of copy Node copied = map.get(ptr); copied.next =
	 * map.get(ptr.next); copied.random = map.get(ptr.random); ptr = ptr.next; }
	 * //return head of copied list return map.get(head); }
	 */
	/*
	 * https://www.youtube.com/watch?v=VNf6VynfpdM Take u forward TC: O(n + n + n) ~
	 * O(n) SC: O(1)
	 */
	public static Node copyRandomList(Node head) {
		Node iter = head;
		Node front = head;

		// First round: make copy of each node,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			front = iter.next;

			Node copy = new Node(iter.val);
			iter.next = copy;
			copy.next = front;

			iter = front;
		}

		// Second round: assign random pointers for the copy nodes.
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}

		// Third round: restore the original list, and extract the copy list.
		iter = head;
		Node pseudoHead = new Node(0);
		Node copy = pseudoHead;

		while (iter != null) {
			front = iter.next.next;

			// extract the copy
			copy.next = iter.next;
			copy = copy.next;

			// restore the original list
			iter.next = front;

			iter = front;
		}

		return pseudoHead.next;
	}

}
