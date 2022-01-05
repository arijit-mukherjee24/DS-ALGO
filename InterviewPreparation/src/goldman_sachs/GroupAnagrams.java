package goldman_sachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Same as 49. Group Anagrams
//Techdose: https://www.youtube.com/watch?v=0I6IL3TnIZs (Sorted Approach)
// https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/ GFG Practice
public class GroupAnagrams {

	public static void main(String[] args) {

	}

	public static List<List<String>> Anagrams(String[] string_list) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String str : string_list) {
			char[] tempArr = str.toCharArray();
			Arrays.sort(tempArr);
			String temp = new String(tempArr);

			if (map.containsKey(temp)) {
				map.get(temp).add(str);
			} else {
				ArrayList<String> ls = new ArrayList<String>();
				ls.add(str);
				map.put(temp, ls);
			}
		}

		List<List<String>> res = new ArrayList<>();
		for (String t : map.keySet()) {
			res.add(map.get(t));
		}
		return res;
	}

}
