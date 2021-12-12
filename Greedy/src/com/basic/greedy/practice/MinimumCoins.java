package com.basic.greedy.practice;

import java.util.Vector;

// Minimum Coins : Take u forward
// https://www.youtube.com/watch?v=mVg9CfJvayM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49
// TC: O(V)
// V - > Value in worst case when only 1 coin 
// Greedy Algo only when proper denomination are used
// If dynamic denomination are given, problem changes to [322. Coin Change] - Need to solve using DP ways	

// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
public class MinimumCoins {

	public static void main(String[] args) {
		
	}
	
	static void findMin(int V) {
		Vector<Integer> ans = new Vector<>();
		
		int[] deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int n = deno.length;
		
		for(int i=n-1; i>=0; i--) {
			while(V >= deno[i]) {
				V -= deno[i];
				ans.add(deno[i]);
			}
		}
		
		for(int i=0; i< ans.size(); i++) {
			System.out.print(" " +ans.elementAt(i));
		}
		
	}

}
