package ds.sliding.window.algo;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
	// Variant of Longest Substring with K unique characters
	// Here it is Longest substring with ALL unique characters
	// (So compare against the whole window length windowEnd-windowStart+1 instead
	// of k)
	private static int findLengthOfLongestSubstringWithoutRepeatingCharacters(String s) {
		int n = s.length();

		int maxLen = -1; // Stores the length of the longest substring without repeating characters found
							// so far.
		Map<Character, Integer> windowCharCount = new HashMap<>(); // Stores the character count for each character in
																	// the current window
		int windowStart = 0;

		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			char c = s.charAt(windowEnd);
			windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);

			// Shrink the window until all the characters in the window are unique
			while (windowCharCount.size() < windowEnd - windowStart + 1) {
				char leftChar = s.charAt(windowStart);

				// Discard the character at windowStart since we're gonna move it out of the
				// window now.
				windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
				if (windowCharCount.get(leftChar) == 0) {
					windowCharCount.remove(leftChar);
				}

				windowStart++; // Shrink the window
			}

			// We have a window where all the characters are unique. Update the max length
			if (windowCharCount.size() == windowEnd - windowStart + 1) {
				maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
			}
		}

		return maxLen;
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String s = keyboard.next();
		keyboard.close();

		System.out.printf("Longest substring without repeating characters = %d%n",
				findLengthOfLongestSubstringWithoutRepeatingCharacters(s));
	}
}