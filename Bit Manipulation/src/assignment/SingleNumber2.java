package assignment;

import java.util.Arrays;

// Leetocde 137
public class SingleNumber2 {

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
		int size = nums.length;
		if (size < 3) {
			return nums[0];
		}

		Arrays.sort(nums);
		for (int i = 1; i < size; i = i + 3) {
			if (nums[i] != nums[i - 1]) {
				return nums[i - 1];
			}
		}
		return nums[size - 1];
	}

}
