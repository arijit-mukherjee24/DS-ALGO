package microsoft;

//116. Populating Next Right Pointers in Each Node (For Perfect Binary Tree)
//Ref: https://www.geeksforgeeks.org/connect-nodes-at-same-level/ Level Order

//Ref: https://www.youtube.com/watch?v=3MRPQFUpoA0 Pepcoding
public class Q8_ConnectNodes_at_Same_Level_Next_Right_Pointer {

	public static void main(String[] args) {

	}

	public Node connect(Node root) {
		Node black = root;

		while (black != null && black.left != null) {
			Node n = black;
			while (true) {
				n.left.next = n.right;
				if (n.next == null)
					break;
				n.right.next = n.next.left;

				n = n.next;
			}

			black = black.left;
		}
		return root;
	}

}

//Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};
