package practice;
//334. Increasing Triplet Subsequence

//Ref: https://www.youtube.com/watch?v=yEFlGWOVH8g Algorithms Made Easy
//TC: O(n)
import java.util.ArrayList;

public class SortedSubsequenceOf3 {

	public static void main(String[] args) {

	}

	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3)
			return false;
		int i = Integer.MAX_VALUE;
		int j = Integer.MAX_VALUE;

		for (int n = 0; n < nums.length; n++) {
			if (nums[n] <= i) {
				i = nums[n];
			} else if (nums[n] <= j) {
				j = nums[n];
			} else {
				return true; // we find the 3rd variable
			}
		}
		return false;
	}

}

/*
Also: 
https://www.youtube.com/watch?v=xZ5FBqk-cFw Naresh Gupta
TC: O(n) SC: O(n)
https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/#
*/

/*
 * 
 * ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
 * ArrayList<Integer> list = new ArrayList<>(3); if(n < 3) return list;
 * 
 * int[] leftMin = new int[n]; leftMin[0] = arr.get(0); for(int i=1; i<n; i++) {
 * leftMin[i] = Math.min(leftMin[i-1], arr.get(i)); }
 * 
 * int[] rightMax = new int[n]; rightMax[n-1] = arr.get(n-1); for(int i=n-2;
 * i>0; i--) { rightMax[i] = Math.max(rightMax[i+1], arr.get(i)); }
 * 
 * for(int i=0; i<n; i++) { if(leftMin[i]<arr.get(i) && arr.get(i) <
 * rightMax[i]) { list.add(leftMin[i]); list.add(arr.get(i));
 * list.add(rightMax[i]); return list; } } return list; }
 * 
 */