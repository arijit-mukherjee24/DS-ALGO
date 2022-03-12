package microsoft;

//Ref: https://www.youtube.com/watch?v=xHv5NiTUdQo Binary Tree
//Pass By Reference in Java
//https://www.educative.io/edpresso/how-to-pass-by-reference-in-java Pass
public class Q9_CountNumber_of_SubTrees_having_given_Sum {

	public static void main(String[] args) {

	}

	int count;

	// Function to count number of subtrees having sum equal to given sum.
	int countSubtreesWithSumX(Nod root, int X) {
		count = 0;
		countSumUtil(root, X);
		return count;
	}

	int countSumUtil(Nod root, int X) {
		if (root == null)
			return 0;

		int sum = root.data + countSumUtil(root.left, X) + countSumUtil(root.right, X);

		if (sum == X)
			count++;

		return sum;
	}

}

class Nod
{
    int data;
    Nod left,right;
    Nod(int d)
    {
        data=d;
        left=right=null;
    }
}