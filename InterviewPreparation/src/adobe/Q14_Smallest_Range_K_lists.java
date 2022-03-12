package adobe;

import java.util.List;
import java.util.PriorityQueue;

//632. Smallest Range Covering Elements from K Lists
//Ref:  https://www.youtube.com/watch?v=aH-2Sig2H2Q Pepcoding
public class Q14_Smallest_Range_K_lists {

	public static void main(String[] args) {

	}

	public int[] smallestRange(List<List<Integer>> nums) {
		int[] res = { -100000, 100000 }; // For the constraints
		int k = nums.size();
		int max = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int i = 0; i < k; i++) {
			int element = nums.get(i).get(0);
			// 0th -> Element
			// 1th -> Index of the Element in the list
			// 2nd -> Index of the list where the element is present
			int[] arr = { element, 0, i };

			max = Math.max(max, element);
			pq.add(arr);
		}

		while (true) {
			int[] minPeekArr = pq.poll();
			// Updating the range to the min value
			if (res[1] - res[0] > max - minPeekArr[0]) {
				res[0] = minPeekArr[0];
				res[1] = max;
			}

			// New Index
			minPeekArr[1]++;
			// getting the entire list of the polled element
			List<Integer> list = nums.get(minPeekArr[2]);
			if (minPeekArr[1] == list.size()) {
				break;
			} else {
				minPeekArr[0] = list.get(minPeekArr[1]);
				max = Math.max(max, minPeekArr[0]);
				pq.add(minPeekArr);
			}

		}
		return res;
	}

}
