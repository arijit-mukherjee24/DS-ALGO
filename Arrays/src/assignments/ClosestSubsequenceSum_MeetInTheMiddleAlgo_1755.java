package assignments;
// https://leetcode.com/problems/closest-subsequence-sum/
// https://leetcode.com/problems/closest-subsequence-sum/discuss/1223995/java-solution-with-complexity-explanation
// Techdose Class Video for Array : Meet in the Middle Algo 
import java.util.Arrays;

public class ClosestSubsequenceSum_MeetInTheMiddleAlgo_1755 {

	public static void main(String[] args) {
		int[] nums = { 5,-7,3,5 };
		int goal = 6;
		int ans = minAbsDifference(nums, goal);
		System.out.println("The minimum closest subsequence sum diff is "+ans);
	}

	private static void createSet(int[] set, int[] a, int n1) {
		int sum, ind = 0, n = a.length;
		for (int i = 0; i < n1; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0)
					sum += a[j];
			}
			set[ind++] = sum;
		}
	}

	public static int minAbsDifference(int[] a, int goal) {
		int n = a.length;
		int[] set1 = new int[1 << n / 2];
		int[] set2 = new int[1 << (n - n / 2)];
		// O(N/2*2^N/2)
		createSet(set1, Arrays.copyOfRange(a, 0, n / 2), 1 << n / 2);
		// O(N/2*2^N/2)
		createSet(set2, Arrays.copyOfRange(a, n / 2, n), 1 << (n - n / 2));
		// O(2^N/2 * log2^N/2) => N/2*2^N/2
		Arrays.sort(set2);
		int min = Integer.MAX_VALUE;
		for (int i : set1) {
			// log2^N/2 => N/2
			int posi = Arrays.binarySearch(set2, goal - i);
			if (posi >= 0)
				return 0;
			int pos = -1 * (posi + 1);
			int low = pos - 1;
			if (low >= 0)
				min = Math.min(min, Math.abs(i + set2[low] - goal));
			if (low != set2.length - 1)
				min = Math.min(min, Math.abs(i + set2[pos] - goal));
		}
		return min;
	}

}
