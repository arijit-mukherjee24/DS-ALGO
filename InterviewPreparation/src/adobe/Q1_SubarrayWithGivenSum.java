package adobe;

// Ref: https://www.youtube.com/watch?v=Ofl4KgFhLsM Techdose
// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1


import java.util.ArrayList;

public class Q1_SubarrayWithGivenSum {

	public static void main(String[] args) {
		
	}
	
	//Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        int curr_sum = arr[0], start = 0, i;
 
        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum > s && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }
 
            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum == s) {
                int p = i;
                res.add(start + 1);
                res.add(p);
                return res;
            }
 
            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];
        }
        
        res.add(-1);
        return res;
    }
    

}
