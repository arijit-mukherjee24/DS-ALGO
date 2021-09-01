package assignments;
// https://www.youtube.com/watch?v=2bSS8rtFym4 (Techdose)
// https://leetcode.com/submissions/detail/542304883/ Leetcode 303
public class RangeSumQueryImmutable {

	private int[] sums;

	public RangeSumQueryImmutable(int[] nums) {
		if (nums.length != 0) {
			sums = new int[nums.length];
			sums[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				sums[i] = nums[i] + sums[i - 1];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);
		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
	}

	public int sumRange(int i, int j) {
		return i == 0 ? sums[j] : sums[j] - sums[i - 1];
	}

}
