package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Ref: https://www.techiedelight.com/find-kth-largest-element-array/

/*
 * Using Max Heap
	We can easily solve this problem in O(n + k.log(n)) by using a max-heap. 
	The idea is to simply construct a max-heap of size n and insert all the array elements A[0…n-1] into it. 
	Then pop first k-1 elements from it. 
	Now k'th largest element will reside at the root of the max-heap.
 */
public class KthLargestMaxHeap {

	public static void main(String[] args) {
		//int arr[] = { 3, 2, 1, 5, 6, 4 };
		//int k = 2;
		
		int arr[] = { 3,2,3,1,2,4,5,5,6 };
		int k = 4;

		int ans = findKthLargest(arr, k);
		System.out.println(ans);
	}

	private static int findKthLargest(int[] arr, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i : arr)
			list.add(i);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b -a);
		pq.addAll(list);
		
		// pop from max-heap exactly `k-1` times
		while(--k > 0) {
			pq.poll();
		}
		
		return pq.peek();
	}

}
