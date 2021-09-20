package com.assignment.backtracking;

import java.util.ArrayList;
import java.util.List;

// Leetcode 46. Permutations
//Ref: https://www.youtube.com/watch?v=YK78FU5Ffjw Take u forward

public class Permutations {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = permute(nums);
		System.out.println(res);
	}

	public static List<List<Integer>> permute(int[] nums) {
		// For storing the answer
		List<List<Integer>> ans = new ArrayList<>();

		// For the data structure
		List<Integer> ds = new ArrayList<>();

		// Frequency array of the size of input array
		boolean freq[] = new boolean[nums.length];

		recurPermute(nums, ds, ans, freq);

		return ans;
	}

	private static void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
		if (ds.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!freq[i]) {
				freq[i] = true;
				ds.add(nums[i]);
				recurPermute(nums, ds, ans, freq);
				ds.remove(ds.size() - 1); // removing the last added element
				freq[i] = false;
			}
		}
	}

}
