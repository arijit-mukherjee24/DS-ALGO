package assignments;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=dRUpbt8vHpo (Take u forward)
// https://leetcode.com/submissions/detail/541774729/
public class TwoSum {

	public static void main(String[] args) {
		int arr[] = { 2, 7, 11, 15 };
		int target = 9;

		int[] ans = twoSum(arr, target);
		System.out.println("The indices are ");
		for (int i : ans)
			System.out.print(i + " ");
	}

	private static int[] twoSum(int[] arr, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i <= arr.length - 1; i++) {
			if (map.containsKey(target - arr[i])) {
				result[1] = i;
				result[0] = map.get(target - arr[i]);
				return result;
			}
			map.put(arr[i], i);
		}

		return result;
	}

}
