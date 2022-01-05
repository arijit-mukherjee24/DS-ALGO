package goldman_sachs;

// 713. Subarray Product Less Than K
// https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/ gfg practice

//Brute Forche: Naresh
//https://www.youtube.com/watch?v=SxtxCSfSGlo Nick White
public class SubarrayProductLessThanK {

	public static void main(String[] args) {

	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int count = 0, prod = 1;
		int left = 0, right = 0;

		while (right < nums.length) {
			prod *= nums[right];

			while (prod >= k && left <= right) {
				prod /= nums[left];
				left++;
			}

			count += right - left + 1;
			right++;
		}
		return count;
	}

}
