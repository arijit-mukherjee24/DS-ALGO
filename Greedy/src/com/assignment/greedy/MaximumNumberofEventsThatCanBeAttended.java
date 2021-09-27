package com.assignment.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

// Leetcode 1353. Maximum Number of Events That Can Be Attended
//Ref: https://costia.medium.com/leetcode-1353-maximum-number-of-events-that-can-be-attended-medium-7afca19b1292 3rd approach

//https://www.youtube.com/watch?v=47jGAjgvEtc Code with Med
// Also refer the oher TLE solution (another submit) & Mohammad Fraz video

public class MaximumNumberofEventsThatCanBeAttended {

	public static void main(String[] args) {

	}

	public int maxEvents(int[][] events) {

		// sorted the events based on start day, if start day's are same, sorted them
		// based on end day
		Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

		// To store all the events end day having the same start day,
		// so that we pick the event that is expiring soon ## Greedy approach
		PriorityQueue<Integer> q = new PriorityQueue<>();

		// count of events
		int attended = 0;

		int j = 0;

		// Events can range from 1 to 100000 days as per the constraints (1 <=
		// events.length <= 10^5)
		// else you can also calculate the max end day among all the events for more
		// efficiency
		for (int i = 1; i <= 100000; i++) {

			// Remove all the events end date that has already expired before the curr day
			while (!q.isEmpty() && q.peek() < i) {
				q.poll();
			}

			// add the end day for the events having the same start day with the curr day
			// (i)
			for (; j < events.length && events[j][0] == i; j++) {
				q.offer(events[j][1]); // adding the end day of all the event having the same start day
			}

			if (!q.isEmpty()) {
				q.poll();
				attended++;
			}
		}
		return attended;
	}

}
