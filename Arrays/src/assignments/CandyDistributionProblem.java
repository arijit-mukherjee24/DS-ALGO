package assignments;
// https://www.youtube.com/watch?v=h6_lIwZYHQw (Techdose)
// Leetcode 135 - https://leetcode.com/problems/candy/submissions/
// GFG - https://www.geeksforgeeks.org/chocolate-distribution-problem-set-2/
import java.util.Arrays;

public class CandyDistributionProblem {

	public static void main(String[] args) {
		int arr[] = { 23, 14, 15, 14, 56, 29, 14 };
		int n = arr.length;
		int ans = minChocolates(arr, n);
		System.out.println("The minimum no of choclates are " + ans);
	}

	private static int minChocolates(int[] arr, int n) {
		int b[] = new int[n];

		Arrays.fill(b, 1);
		
		// Moving from left to right
		for (int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1]) {
				b[i] = b[i-1] + 1;
			}
		}
		
		// Moving from right to left
		for(int i=n-2; i>=0; i--) {
			if(arr[i] > arr[i+1]) {
				b[i] = Math.max(b[i+1] + 1, b[i]);
			}
		}
		int sum = 0;
		for(int i: b)
			sum += i;
		
		return sum;
	}

}
