package ds.sliding.window.algo;

import java.util.Scanner;

// https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
// https://www.callicoder.com/maximum-sum-subarray-of-size-k/
public class MaxSumSubarrayOfSizeK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[n];
		for(int i = 0; i<n; i++)
			a[i] = sc.nextInt();
		
		sc.close();
		
		 System.out.printf("Max sum subarray of size %d = %d%n", k, findSumMaxSubarrayOfSizeK(a, k));
	}

	private static int  findSumMaxSubarrayOfSizeK(int[] a, int k) {
		
		if(k == 0 || a.length == 0)
			return 0;
		
		int max_sum = Integer.MIN_VALUE;
		
		int window_start = 0;
		int window_sum = 0;
		
		for(int window_end = 0; window_end < a.length; window_end++) {
			window_sum += a[window_end]; // Add the next element in the window
			
			if(window_end - window_start + 1 == k) {
				max_sum = Math.max(max_sum, window_sum); // Upadate the maximum sum
				window_sum -= a[window_start]; // substract the element which is moving out of the window
				window_start++; // slide the start point of the window
			}
		}

		return max_sum;
	}

}

/*
Example 1

Input: [3, 5, 2, 1, 7], k=2 
Output: 8
Explanation: Subarray with maximum sum is [1, 7].

Example 2

Input: a[] = {4, 2, 3, 5, 1, 2}, k = 3
Output: 10
Explanation: Subarray with maximum sum is [2, 3, 5]
*/
