package com.heap;
/* 
239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/
Maximum of all subarray of size k
*/

import java.util.TreeMap;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] ans = maxSlidingWindow(nums, k);
		for(int i: ans)
			System.out.print(i + " ");
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};
        
        int idx = 0;
        int window_start = 0;
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
        int n = nums.length;
        	
        // the maxWindow to save the largest in sliding window with width k
        int[] maxWindow = new int[n - k + 1];
        
        for (int window_end = 0; window_end < nums.length; window_end++) {
        	tree.put(nums[window_end], window_end);

        	if (window_end - window_start + 1 == k) {
                
        		// get the last (largest) key of the tree and put it into the max array
        		maxWindow[idx++] = tree.lastKey();
        		
           		if (tree.get(nums[window_start])==window_start) { 
                    tree.remove(nums[window_start]);
                }
           		window_start++; // Slide the window ahead
            }
         }
        return maxWindow;
    }

}
