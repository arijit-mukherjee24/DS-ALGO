package assignments;

// Ref: https://www.youtube.com/watch?v=2JzRBPFYbKE
// code: Leetcode 56 - https://leetcode.com/submissions/detail/469676262/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		intervals = merge(intervals);

		System.out.print("Array after merging [");
		for (int[] arr : intervals) {
			System.out.print("[");
			for (int i : arr)
				System.out.print(i + " ");
			System.out.print("]");
		}
		System.out.print("]");

	}

	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<int[]>();
		int start = intervals[0][0], end = intervals[0][1];

		for (int[] i : intervals) {
			if (i[0] > end) {
				result.add(new int[] { start, end });
				start = i[0];
				end = i[1];
			} else {
				end = Math.max(end, i[1]);
			}
		}
		result.add(new int[] { start, end });
		return result.toArray(new int[result.size()][2]);

	}

}
