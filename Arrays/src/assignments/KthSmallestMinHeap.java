package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Ref: https://www.techiedelight.com/find-kth-smallest-element-array/

/*
 * Using Min Heap
We can easily solve this problem in O(n + k.log(n)) by using a min-heap. 
The idea is to construct a min-heap of size n and insert all the array elements A[0…n-1] into it. 
Then pop first k-1 elements from it. 
Now k'th smallest element will reside at the root of the min-heap.
 */
public class KthSmallestMinHeap {

	public static void main(String[] args) {
		//int arr[] = { 3, 2, 1, 5, 6, 4 };
		//int k = 2;
		
		int arr[] = { 7, 4, 6, 3, 9, 1 };
		int k = 3;
		
		int ans = findKthSmallest(arr, k);
		System.out.println(ans);
	}

	private static int findKthSmallest(int[] arr, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i : arr)
			list.add(i);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(list);
		
		// pop from max-heap exactly `k-1` times
		while(--k > 0) {
			pq.poll();
		}
		
		return pq.peek();
	}

}
