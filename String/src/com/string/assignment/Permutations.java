package com.string.assignment;

import java.util.ArrayList;
import java.util.List;

// Leetcode 46. Permutations
//Ref: https://www.youtube.com/watch?v=YK78FU5Ffjw Take u forward Approach 1

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

/* 
// Ref: https://www.youtube.com/watch?v=f2ic2Rsc9pU Take u forward Approach 2 
// TC: O(n*n!) where n=length of the array input
// https://www.youtube.com/watch?v=GuTPwotSdYw (Techdose video)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }
    
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        //copy the ds to ans
        if(index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++)
                ds.add(nums[i]);
        
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=index; i<nums.length; i++) {
            swap(i, index, nums);
            recurPermute(index+1, nums, ans);
            swap(i, index, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
*/
