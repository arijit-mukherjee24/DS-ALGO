package amazon;

import java.util.ArrayList;
import java.util.TreeMap;

//https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1/
//239. Sliding Window Maximum
public class Q6_Maximum_of_all_subarrays_of_size_k {

	public static void main(String[] args) {

	}

	// Function to find maximum of each subarray of size k.
	static ArrayList<Integer> max_of_subarrays(int nums[], int n, int k) {
		// the maxWindow to save the largest in sliding window with width k
		ArrayList<Integer> maxWindow = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return maxWindow;

		int idx = 0;
		int window_start = 0;
		TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();

		for (int window_end = 0; window_end < nums.length; window_end++) {
			tree.put(nums[window_end], window_end);

			if (window_end - window_start + 1 == k) {

				// get the last (largest) key of the tree and put it into the max array
				maxWindow.add(tree.lastKey());
				// this check is required
				/*
				 * Input nums -> [-7,-8,7,5,7,1,6,0] k -> 4 Output (if this check is not
				 * present) [7,7,7,6,6] Expected [7,7,7,7,7]
				 */
				if (tree.get(nums[window_start]) == window_start) {
					tree.remove(nums[window_start]);
				}
				window_start++; // Slide the window ahead
			}
		}
		return maxWindow;
	}

}
