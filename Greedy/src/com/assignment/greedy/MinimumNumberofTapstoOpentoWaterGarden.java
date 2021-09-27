package com.assignment.greedy;

// Leetcode 1326. Minimum Number of Taps to Open to Water a Garden 
// Ref : https://www.youtube.com/watch?v=Pk128gC_sdw Prakash Shukla

public class MinimumNumberofTapstoOpentoWaterGarden {

	public static void main(String[] args) {

	}

	public int minTaps(int n, int[] ranges) {
		int min = 0; // initial min is 0
		int max = 0; // we will continue till mex = n
		int open = 0; // no of taps to open
		int pos = 0;

		while (max < n) { // While will break once we reach the end i.e n

			// starting i = pos, so that it starts with pos till it has reached
			for (int i = pos; i < ranges.length; i++) {
				if ((i - ranges[i]) <= min && (i + ranges[i]) > max) {
					max = i + ranges[i];
					pos = i;
				}
			}

			if (min == max)
				return -1;
			open++;
			min = max; // Again starts to find the max from the reach point we reach
		}
		return open;
	}

}
