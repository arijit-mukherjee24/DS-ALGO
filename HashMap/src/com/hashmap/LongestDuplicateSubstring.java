package com.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//ref: https://www.youtube.com/watch?v=FQ8hcOOzQMU Techdose
// Leetcode 1044. Longest Duplicate Substring
public class LongestDuplicateSubstring {

	public static void main(String[] args) {
		String s = "banana";
		String ans = longestDupSubstring(s);
		System.out.println(ans);
	}

	public static String match(String s, int len, int size, long p, long[] roll) {
		Map<Long, List<Integer>> map = new HashMap<Long, List<Integer>>(); // Key->hashValue...Value->starting index of
																			// substring
		long hash = 0; // current window hash
		for (int i = 0; i < size; ++i)
			hash = (hash * 26 + (s.charAt(i) - 'a')) % p;

		// m[hash].push_back(0);
		map.put(hash, new ArrayList<>(Collections.singletonList(0)));

		// Rolling hash (sliding window)
		for (int j = size; j < len; ++j) {
			hash = ((hash - roll[size - 1] * (s.charAt(j - size) - 'a')) % p + p) % p;
			hash = (hash * 26 + (s.charAt(j) - 'a')) % p;
			if (map.containsKey(hash)) {
				for (Integer start : map.get(hash)) {
					String temp = s.substring(start, start + size);
					String curr = s.substring(j - size + 1, j + 1);
					if (temp.compareTo(curr) == 0) {
						return temp;
					}
				}
			}
			// m[hash].push_back(j-size+1);
			map.computeIfAbsent(hash, k -> new ArrayList<>()).add(j - size + 1);
		}
		return null;
	}

	public static String longestDupSubstring(String s) {
		int len = s.length();
		if (len == 0)
			return "";

		// Store all rolling hash values
		long[] roll = new long[len]; // Allocating fixed space to array
		roll[0] = 1L; // Since 26^0 = 1
		long p = (1 << 31) - 1;
		for (int i = 1; i < len; ++i)
			roll[i] = ((26 * roll[i - 1]) % p);

		int low = 1, high = len, mid;
		String ans = "";
		while (low <= high) {
			// tempAns = "";
			mid = low + (high - low) / 2;
			String tempAns = match(s, len, mid, p, roll);
			if (tempAns != null) {
				if (tempAns.length() > ans.length())
					ans = tempAns;
				low = mid + 1;
			} else
				high = mid - 1;
		}
		return ans;
	}

}
