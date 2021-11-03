package com.string.assignment;

// Leetcode 49
// Ref: https://www.youtube.com/watch?v=0I6IL3TnIZs Techdose
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> list = groupAnagrams(strs);
		System.out.println(Arrays.toString(list.toArray()));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		// Inner hashmap counts frequency of characters in a string.
		// Outer hashmap for if same frequency characters are present in in a string
		// then it will add it to the arraylist.
		HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();

		for (String str : strs) {
			HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();

			// Counting the frequency of character in a string
			for (int i = 0; i < str.length(); i++) {
				tempMap.put(str.charAt(i), tempMap.getOrDefault(str.charAt(i), 0) + 1);
			}

			// If same frequency of characters are already present, then add that
			// string into that arraylist otherwise
			// created a new arraylist and add that string
			if (map.containsKey(tempMap)) {
				map.get(tempMap).add(str);
			} else {
				ArrayList<String> tempList = new ArrayList<String>();
				tempList.add(str);
				map.put(tempMap, tempList);
			}
		}

		// Stores the result in a arraylist
		List<List<String>> result = new ArrayList<>();
		for (HashMap<Character, Integer> temp : map.keySet()) {
			result.add(map.get(temp));
		}
		return result;
	}

}
