package com.assignment.greedy;
// Ref: https://medium.com/algorithm-and-datastructure/employee-free-time-795c7682c973
// Leetcode 759 and Lintcode 850 - Employee Free Time

/*
 * We are given a list schedule of employees, which represents the working time for each employee.
	Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
	Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
	
	Example 1:
	Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
	Output: [[3,4]]
	Explanation:
	There are a total of three employees, and all common
	free time intervals would be [-inf, 1], [3, 4], [10, inf].
	We discard any intervals that contain inf as they aren't finite.
	
	Example 2:
	Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
	Output: [[5,6],[7,9]]
	(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined.)
	Also, we wouldn’t include intervals like [5, 5] in our answer, as they have zero length.
	
	Note:
	schedule and schedule[i] are lists with lengths in range [1, 50].
	0 <= schedule[i].start < schedule[i].end <= 10^8.
 */

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {
	private static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

	}
	
	public static void main(String[] args) {
		List<List<Interval>> schedule = buildInput();
		List<Interval> res = employeeFreeTime(schedule);
		for(Interval i : res) {
			System.out.println(" [" + i.start + ", " + i.end + "] ");
		}
	}

	private static List<List<Interval>> buildInput() {
		List<Interval> intervals1 = new ArrayList<>();
		intervals1.add(new Interval(1, 2));
		intervals1.add(new Interval(5, 6));

		List<Interval> intervals2 = new ArrayList<>();
		intervals2.add(new Interval(1, 3));

		List<Interval> intervals3 = new ArrayList<>();
		intervals3.add(new Interval(4, 10));
		intervals1.add(new Interval(5, 6));

		List<List<Interval>> lists = new ArrayList<>();
		lists.add(intervals1);
		lists.add(intervals2);
		lists.add(intervals3);
		return lists;
	}

	public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		if (schedule == null || schedule.size() == 0)
			return null;
		List<Interval> list = new ArrayList<>();
		for (List<Interval> l : schedule) {
			list.addAll(l);
		}
		List<Interval> merged = merge(list);
		if (merged.size() == 1)
			return null;
		List<Interval> result = new ArrayList<>();
		for (int i = 1; i < merged.size(); i++) {
			Interval prev = merged.get(i - 1);
			Interval cur = merged.get(i);

			if (prev.end < cur.start) {
				result.add(new Interval(prev.end, cur.start));
			}
		}
		return result;
	}

	private static List<Interval> merge(List<Interval> intervals) {
		//intervals.sort(Comparator.comparingInt(i -> i.start));
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		if (intervals.size() == 0)
			return intervals;
		if (intervals.size() == 1)
			return intervals;
		List<Interval> result = new ArrayList<>();
		for (Interval itvl : intervals) {
			if (result.size() == 0)
				result.add(itvl);
			else {
				Interval it = result.get(result.size() - 1);
				if (it.end >= itvl.start) {
					Interval interval = new Interval(Math.min(it.start, itvl.start), Math.max(it.end, itvl.end));
					result.add(interval);
					result.remove(result.size() - 2);
				} else
					result.add(itvl);
			}
		}
		return result;
	}
}
