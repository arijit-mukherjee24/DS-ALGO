package adobe;
// 1027. Longest Arithmetic Subsequence
//Ref : https://www.youtube.com/watch?v=Y3sZ2bsresI Rahul Manghnani
//[3, 6, 9, 12]

//[[:], [3: 1], [6:1, 3:2], [9:1, 6:1, 3:4]]
//TC: O(n^2)
import java.util.HashMap;

public class Q2_LongestArithmeticProgression {

	public static void main(String[] args) {

	}

	public int longestArithSeqLength(int[] nums) {
		int length = nums.length;

		HashMap<Integer, Integer>[] dp = new HashMap[length];
		int maxValue = 0;

		for (int i = 0; i < length; i++) {
			int currentElement = nums[i];
			dp[i] = new HashMap<>();
			HashMap<Integer, Integer> currentMap = dp[i];
			// Empty hashMap of the current element that we are going to construct now
			for (int j = 0; j < i; j++) {
				int currentDiff = currentElement - nums[j];
				HashMap<Integer, Integer> prevMap = dp[j];

				int newValue = prevMap.getOrDefault(currentDiff, 0) + 1;
				currentMap.put(currentDiff, newValue);
				dp[i] = currentMap;
				maxValue = Math.max(maxValue, newValue);
			}

		}

		return (maxValue + 1);
	}

}
