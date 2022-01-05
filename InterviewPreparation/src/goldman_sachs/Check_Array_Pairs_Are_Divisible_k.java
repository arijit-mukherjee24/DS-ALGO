package goldman_sachs;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=BvKv-118twg Pepcoding
// https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1

//1497. Check If Array Pairs Are Divisible by k Leetcode (Test Case for -ve values also present)
public class Check_Array_Pairs_Are_Divisible_k {

	public static void main(String[] args) {

	}

	// will work for +ve values
	public boolean canPair(int[] arr, int k) {
		Map<Integer, Integer> rfMap = new HashMap<>();

		for (int i : arr) {
			/* if don't want to handle negative cases go with the below one
            int rem = i%k; 
            */
			int rem = ((i % k) + k) % k; // To handle the -ve numbers
            rfMap.put(rem, rfMap.getOrDefault(rem,0)+1);
		}

		for (int val : arr) {
			//int rem = val%k;  // not work with -ve numbers
			int rem = ((val % k) + k) % k;

			if (rem == 0) {
				int fq = rfMap.get(rem);
				if (fq % 2 != 0)
					return false;
			} else if (2 * rem == k) { // Not k/2 (wrong in case of k is odd )
				int fq = rfMap.get(rem);
				if (fq % 2 != 0)
					return false;
			} else {
				int fq = rfMap.get(rem);
				int ofq = rfMap.getOrDefault(k - rem, 0); // may be present or not

				if (fq != ofq)
					return false;
			}
		}
		return true;
	}

}


