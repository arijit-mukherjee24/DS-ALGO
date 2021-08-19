package assignment;

import java.util.Arrays;

// Leetocde 137
public class SingleNumbeBitOperartion {

	public static void main(String[] args) {
		// int nums[] = {0, 1, 0, 1, 0, 1, 99}
		int nums[] = { 99, 0, 1, 0, 1, 0, 1, 45, 99, 99 };
		int ans = singleNumber2(nums);
		System.out.println("The single non-repeating number is " + ans);
	}

	/*
	 * Using the property of XOR xor of two number is 0, do xor of all the elements
	 * and at the end only the number which occured once will be left
	 */
	private static int singleNumber2(int[] nums) {
		long size = nums.length;
		long ans = 0, shift = 1;

		for (long i = 0; i <= 32; i++) {
			long count = 0;
			for (long ele : nums) {
				if ((ele & shift) > 0) {
					count += 1;
				}
			}

			if ((count % 3) != 0) {
				ans += shift;
			}
			shift *= 2;
		}

		return (int) ans;

	}

}
