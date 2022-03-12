package com.assignment.linkedlist;

// 138. Copy List with Random Pointer
public class CopyList_with_RandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * TC: O(n + n) SC: O(n) Using extra space HashMap
	 * 
	 * public NodeT copyRandomList(NodeT head) { // hashmap to store nodes and copies
	 * Map<NodeT,NodeT> map = new HashMap<>(); NodeT ptr = head; // iterate the
	 * original list and make copies of each NodeT while(ptr!=null) { NodeT copied =
	 * new NodeT(ptr.val); //add (original, copy) to hashmap map.put(ptr, copied);
	 * ptr = ptr.next; }
	 * 
	 * // iterate back through the list ptr = head; while(ptr!=null) { //update the
	 * next and ranom fields of copy NodeT copied = map.get(ptr); copied.next =
	 * map.get(ptr.next); copied.random = map.get(ptr.random); ptr = ptr.next; }
	 * //return head of copied list return map.get(head); }
	 */
	/*
	 * https://www.youtube.com/watch?v=VNf6VynfpdM Take u forward TC: O(n + n + n) ~
	 * O(n) SC: O(1)
	 */
	public NodeT copyRandomList(NodeT head) {
		NodeT iter = head;
		NodeT front = head;

		// First round: make copy of each NodeT,
		// and link them together side-by-side in a single list.
		while (iter != null) {
			front = iter.next;

			NodeT copy = new NodeT(iter.val);
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
		NodeT pseudoHead = new NodeT(0);
		NodeT copy = pseudoHead;

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

class NodeT {
	int val;
	NodeT next;
	NodeT random;

	public NodeT(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}