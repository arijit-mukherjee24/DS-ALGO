package com.assignment.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Leetcode 767. Reorganize String : https://leetcode.com/problems/reorganize-string/
// Ref: https://www.youtube.com/watch?v=zaM_GLLvysw Kevin Naughton Jr

public class ReorganizeString {

	public static void main(String[] args) {

	}

	public String reorganizeString(String s) {
		Map<Character, Integer> counts = new HashMap<>();
		for (char c : s.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
		maxHeap.addAll(counts.keySet());

		StringBuilder result = new StringBuilder();

		while (maxHeap.size() > 1) {
			char curr = maxHeap.remove();
			char next = maxHeap.remove();
			result.append(curr);
			result.append(next);

			counts.put(curr, counts.get(curr) - 1);
			counts.put(next, counts.get(next) - 1);

			if (counts.get(curr) > 0) {
				maxHeap.add(curr);
			}
			if (counts.get(next) > 0) {
				maxHeap.add(next);
			}
		}

		if (!maxHeap.isEmpty()) {
			char last = maxHeap.remove();
			if (counts.get(last) > 1) {
				return "";
			}
			result.append(last);
		}

		return result.toString();

	}

}
