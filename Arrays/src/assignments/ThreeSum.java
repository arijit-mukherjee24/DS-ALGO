package assignments;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://www.youtube.com/watch?v=onLoX6Nhvmg (Take u forward)
// https://leetcode.com/submissions/detail/541797228/ leetcode 15
public class ThreeSum {

	public static void main(String[] args) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };

		List<List<Integer>> ans = threeSum(arr);
		System.out.println(ans);
	}

	private static List<List<Integer>> threeSum(int[] nums) {
		 // Two pointer approach
        // Ref: https://www.youtube.com/watch?v=onLoX6Nhvmg
		Arrays.sort(nums);

		List<List<Integer>> res = new LinkedList<>();
		if (nums.length < 3) {
			return res;
		}

		for (int i = 0; i < (nums.length - 2); i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1;
				int hi = nums.length - 1;
				int sum = 0 - nums[i];  // -a

				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;

						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum) {
						lo++;
					}
					else {
						hi--;
					}
				}
			}
		}
		return res;
	}

}
