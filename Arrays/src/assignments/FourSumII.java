package assignments;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=XHlA0KdvQBc (Naresh Gupta)
// https://leetcode.com/submissions/detail/541912481/ leetcode 454
public class FourSumII {

	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int b[] = { -2, -1 };
		int c[] = { -1, 2 };
		int d[] = { 0, 2 };

		int ans = fourSumCount(a, b, c, d);
		System.out.println(ans);
	}

	private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num1 : nums1)
			for (int num2 : nums2)
				map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);

		int count = 0;
		for (int num3 : nums3)
			for (int num4 : nums4)
				count += map.getOrDefault(-(num3 + num4), 0);

		return count;
	}

}
