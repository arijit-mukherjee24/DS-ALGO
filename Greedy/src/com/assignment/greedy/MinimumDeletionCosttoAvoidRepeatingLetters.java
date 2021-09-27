package com.assignment.greedy;

// Leetcode 1578. Minimum Deletion Cost to Avoid Repeating Letters
// Ref: https://www.youtube.com/watch?v=3zMxJJxYph4 Naresh Gupta

public class MinimumDeletionCosttoAvoidRepeatingLetters {

	public static void main(String[] args) {

	}

	public int minCost(String s, int[] cost) {
		int res = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				res += Math.min(cost[i], cost[i - 1]); // Taking up the minimum cost b/w 2
				// Assigning the max cost b/w two so that the max cost gets
				// compared with the same element if they are same ex: "aaabbbbccc"
				cost[i] = Math.max(cost[i], cost[i - 1]);
			}
		}
		return res; // min cost of all the required deletion
	}

}
