package assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.youtube.com/watch?v=4ggF3tXIAp0 (Take u forward)
// https://leetcode.com/submissions/detail/541912481/ leetcode 18
public class FourSum {

	public static void main(String[] args) {
		int arr[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;

		List<List<Integer>> ans = fourSum(arr, target);
		System.out.println(ans);
	}

	private static List<List<Integer>> fourSum(int[] nums, int target) {
		// ref :
		// https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=21
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0)
			return res;

		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int target_2 = target - nums[j] - nums[i];

				int front = j + 1;
				int back = n - 1;

				while (front < back) {
					int two_sum = nums[front] + nums[back];

					if (two_sum < target_2)
						front++;

					else if (two_sum > target_2)
						back--;

					else {
						List<Integer> quad = new ArrayList<>();
						quad.add(nums[i]);
						quad.add(nums[j]);
						quad.add(nums[front]);
						quad.add(nums[back]);
						res.add(quad);

						// processing the duplicates of number 3
						while (front < back && nums[front] == quad.get(2))
							front++;

						// processing the duplicates of number 4
						while (front < back && nums[back] == quad.get(3))
							back--;
					}
				}
				// processing the duplicates of number 2
				while (j + 1 < n && nums[j + 1] == nums[j])
					j++;

			}
			// processing the duplicates of number 1
			while (i + 1 < n && nums[i + 1] == nums[i])
				i++;
		}
		return res;
	}

}
