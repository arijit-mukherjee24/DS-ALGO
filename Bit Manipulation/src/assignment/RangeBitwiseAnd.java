package assignment;

public class RangeBitwiseAnd {

	public static void main(String[] args) {
		int left = 1;
		int right = 2147483647;
		int ans = rangeBitWiseAnd(left, right);
		System.out.println("The answer is " + ans);
	}

	private static int rangeBitWiseAnd(int left, int right) {
		int count = 0;
		while (left != right) {
			left >>= 1;
			right >>= 1;
			count++;
		}
		return left <<= count;
	}

}
