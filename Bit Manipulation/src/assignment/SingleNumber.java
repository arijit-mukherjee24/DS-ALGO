package assignment;

// Leetocde 136
public class SingleNumber {

	public static void main(String[] args) {
		int nums[] = { 4, 1, 2, 1, 2 };
		int ans = singleNumber(nums);
		System.out.println("The single non-repeating number is " + ans);
	}

	/*
	 * Using the property of XOR xor of two number is 0, do xor of all the elements
	 * and at the end only the number which occured once will be left
	 */
	private static int singleNumber(int[] nums) {
		int ans = 0;
		for (int i : nums) {
			ans = ans ^ i;
		}
		return ans;
	}

}
