package com.geometric.algo;

import java.util.Comparator;
import java.util.Vector;

//https://www.geeksforgeeks.org/klees-algorithm-length-union-segments-line/
//Use concept of merge intervals instead
//https://leetcode.com/problems/merge-intervals/
//https://leetcode.com/problems/teemo-attacking/ To Do
//https://www.youtube.com/watch?v=m13Omjv43eM Tech Dose
public class LengthUnionSegment_KleesAlgo {

	public static void main(String[] args) {
		Vector<Pair> segments = new Vector<Pair>();
		segments.add(new Pair(2,5));
		segments.add(new Pair(4, 8));
		segments.add(new Pair(9, 12));
		
	}

}

class Pair {
	int start;
	int end;
	
	Pair(int st, int e) {
		this.start = st;
		this.end = e;
	}
}

/*
class Sort implements Comparator<Pair> {
    // Used for sorting in ascending order of
    // start, if start = end, 
    public int compare(Pair a, Pair b)
    {
        return a.start - b.start;
    }
}
*/