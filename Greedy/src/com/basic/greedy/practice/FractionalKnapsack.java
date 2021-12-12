package com.basic.greedy.practice;

import java.util.Arrays;
import java.util.Comparator;

// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1#

class Item {
	int value, weight;

	Item(int x, int y) {
		this.value = x;
		this.weight = y;
	}
}

// https:// www.youtube.com/watch?v=F_DDzYnxO14&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
// Take u forward
// TC: O(nlogn + n)
// SC: O(1)

class ItemComparator implements Comparator<Item> {
	@Override
	public int compare(Item a, Item b) {
		double r1 = (double) a.value / (double) a.weight;
		double r2 = (double) b.value / (double) b.weight;

		// arrange in desc order of value/weight proportion
		if (r1 < r2)
			return 1;
		else if (r1 > r2)
			return -1;
		else
			return 0;
	}
}

public class FractionalKnapsack {

	public static void main(String[] args) {

	}

	// Function to get the maximum total value in the knapsack.
	double fractionalKnapsack(int W, Item arr[], int n) {
		Arrays.sort(arr, new ItemComparator());

		int curWeight = 0;
		double finalValue = 0.0;

		for (int i = 0; i < n; i++) {
			if (curWeight + arr[i].weight < W) {
				curWeight += arr[i].weight;
				finalValue += (double) arr[i].value;
			} else {
				int remainWeight = W - curWeight;
				finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remainWeight;
				break;
			}
		}
		return finalValue;
	}

}
