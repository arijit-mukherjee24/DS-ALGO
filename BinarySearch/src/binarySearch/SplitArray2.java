package binarySearch;

// Same as Allocate Pages of Book Problem - https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
// Painter's Partition problem - https://www.geeksforgeeks.org/painters-partition-problem/



public class SplitArray2 {
	public static void main(String[] args) {
		int nums[] = { 7, 2, 5, 10, 8 };
		int m = 2;
		int ans = splitArray(nums, m);
		System.out.println(ans);
	}

	public static int splitArray(int[] nums, int m) {
		int start = 0;
		int end = 0;
		int res = -1;

		for (int i = 0; i < nums.length; i++) {
			start = Math.max(start, nums[i]); // maximum element in the array
			end += nums[i]; // sum of all elements
		}

		// binary search
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (isValid(nums, nums.length, m, mid) == true) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	private static boolean isValid(int[] nums, int l, int m, int mx) {
		int sum = 0;
		int pieces = 1;

		for (int i = 0; i < l; i++) {
			sum += nums[i];

			if (sum > mx) {
				sum = nums[i];
				pieces++;
			}
			if (pieces > m) {
				return false;
			}
		}
		return true;
	}

}
