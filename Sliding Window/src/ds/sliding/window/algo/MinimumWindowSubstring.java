package ds.sliding.window.algo;
// Leetcode 76 - https://leetcode.com/submissions/detail/549220476/
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static void main(String[] args) {
		String s = "babb";
		String t = "baba";
		String ans = minWindow(s, t);
		System.out.println("Output " + ans);

	}

	public static String minWindow(String s, String t) {
		int sl = s.length();
		int tl = t.length();

		if (sl < tl)
			return "";

		if (s.equals(t))
			return s;

		int minWinSubStart = 0;
		int minWinSubLen = Integer.MAX_VALUE;

		Map<Character, Integer> smap = new HashMap<>();
		Map<Character, Integer> tmap = new HashMap<>();

		for (int i = 0; i < tl; i++) {
			char c = t.charAt(i);
			tmap.put(c, tmap.getOrDefault(c, 0) + 1);
		}

		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < sl; windowEnd++) {
			char d = s.charAt(windowEnd);
			smap.put(d, smap.getOrDefault(d, 0) + 1);

			while (containsAll(smap, tmap)) {
				if (minWinSubLen > windowEnd - windowStart + 1) {
					minWinSubLen = windowEnd - windowStart + 1;
					minWinSubStart = windowStart;
				}

				char e = s.charAt(windowStart);
				smap.put(e, smap.get(e) - 1);

				if (smap.get(e) == 0)
					smap.remove(e);

				windowStart++;
			}
		}

		if (minWinSubLen == Integer.MAX_VALUE) {
			return "";
		}

		return s.substring(minWinSubStart, minWinSubStart + minWinSubLen);
	}

	private static boolean containsAll(Map<Character, Integer> windowCharMap, Map<Character, Integer> substrMap) {
		for (Map.Entry<Character, Integer> entry : substrMap.entrySet()) {
			char c = entry.getKey();
			int count = entry.getValue();

			if (!windowCharMap.containsKey(c)) {
				return false;
			}

			if (windowCharMap.get(c) < count) {
				return false;
			}
		}
		return true;
	}
}
