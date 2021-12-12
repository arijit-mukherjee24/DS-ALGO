package com.basic.greedy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1
// Same as N meetings In One Room : reference
// https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

class Activity {
	int start, end;

	public Activity(int _start, int _end) {
		start = _start;
		end = _end;
	}
}

public class ActivitySelection {

	public static void main(String[] args) {

	}

	// Function to find the maximum number of activities that can
	// be performed by a single person.
	public static int activitySelection(int start[], int end[], int n) {
		List<Activity> ls = new ArrayList<>();

		for (int i = 0; i < n; i++)
			ls.add(new Activity(start[i], end[i]));

		// Sorting the activity in desc based on end day
		// Bcoz the sonner the activity ends,
		// more is the chances to perform more activity
		Collections.sort(ls, ((a, b) -> (a.end - b.end)));

		int limit = ls.get(0).end;
		int count = 1;

		for (int i = 1; i < n; i++) {
			if (limit < ls.get(i).start) {
				count++;
				limit = ls.get(i).end;
			}
		}

		return count;
	}

}
