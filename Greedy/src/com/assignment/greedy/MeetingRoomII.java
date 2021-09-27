package com.assignment.greedy;

// Ref: https://www.youtube.com/watch?v=PWgFnSygweI
// Lintcode 919: https://www.lintcode.com/problem/919/

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
================================================
919 · Meeting Rooms II (Lintcode 919) [Leetcode 253]
================================================

Description
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example
Example1

Input: intervals = [(0,30),(5,10),(15,20)]
Output: 2
Explanation:
We need two meeting rooms
room1: (0,30)
room2: (5,10),(15,20)
Example2

Input: intervals = [(2,7)]
Output: 1
Explanation: 
Only need one meeting room
Tags

====================================================================================
====================================================================================
*/

class Interval {
	int start, end;
	Interval(int start, int end) {
		 this.start = start;
		 this.end = end;
	}
}

public class MeetingRoomII {

	public static void main(String[] args) {
		
	}
	
	/**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
       if(intervals.size() == 0) {
           return 0;
       }
       Collections.sort(intervals, (a, b) -> a.start - b.start);

       PriorityQueue<Interval> pq = new PriorityQueue<Interval>( (a,b) -> a.end - b.end);
       pq.add(intervals.get(0));

       for(int i = 1; i < intervals.size(); i++) {
           Interval current = intervals.get(i);
           Interval earliest = pq.remove();

           if(current.start >= earliest.end) {
               earliest.end = current.end;
           }
           else {
               pq.add(current);
           }
           pq.add(earliest);
       }
        return pq.size();
    }

}
