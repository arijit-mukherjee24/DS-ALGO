package walmart;

// https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/ gfg practice

public class Q5_TransformToSumTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void toSumTree(Node root) {
		sumTreeUtil(root);
	}

	static int sumTreeUtil(Node node) {
		if (node == null)
			return 0;

		int old_val = node.data;

		node.data = sumTreeUtil(node.left) + sumTreeUtil(node.right);

		return (old_val + node.data);
	}

}


class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}