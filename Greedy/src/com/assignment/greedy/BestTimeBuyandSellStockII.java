package com.assignment.greedy;

// Leetcode 122. Best Time to Buy and Sell Stock II
// Ref: https://www.youtube.com/watch?v=K8iHi8AW1ls techdose
public class BestTimeBuyandSellStockII {

	public static void main(String[] args) {

	}

	public int maxProfit(int[] prices) {
		int n = prices.length;

		int diff = 0;

		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				diff += prices[i] - prices[i - 1];
			}
		}
		return diff;
	}
}
