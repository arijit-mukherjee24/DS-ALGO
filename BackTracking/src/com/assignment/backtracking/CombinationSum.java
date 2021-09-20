package com.assignment.backtracking;

import java.util.ArrayList;
import java.util.List;

// leetcode 39. Combination Sum
//Ref: https://www.youtube.com/watch?v=OyZFFqQtu98 Take u forward

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
		System.out.println(res);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();

		List<Integer> ds = new ArrayList<>();
		int idx = 0;

		findCombinations(idx, candidates, target, ans, ds);
		return ans;
	}

	private static void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> ans,
			List<Integer> ds) {
		if (idx == candidates.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (candidates[idx] <= target) {
			ds.add(candidates[idx]);
			findCombinations(idx, candidates, target - candidates[idx], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(idx + 1, candidates, target, ans, ds);

	}

}
