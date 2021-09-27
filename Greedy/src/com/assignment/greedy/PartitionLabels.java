package com.assignment.greedy;

import java.util.ArrayList;
import java.util.List;

// Leetcode 763. Partition Labels
//Ref: https://www.youtube.com/watch?v=kS4P0vXbGmc Knowledge Center

public class PartitionLabels {

	public static void main(String[] args) {

	}

	public List<Integer> partitionLabels(String s) {

		int[] lst_occ_indx = new int[26];

		for (int i = 0; i < s.length(); i++) {
			lst_occ_indx[s.charAt(i) - 'a'] = i;
		}

		List<Integer> res = new ArrayList<>();

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			end = Math.max(end, lst_occ_indx[s.charAt(i) - 'a']);

			if (end == i) { // means all the occurence of all the character are included in the partitions
				res.add(end - start + 1);
				start = end + 1;
			}
		}
		return res;
	}

}
