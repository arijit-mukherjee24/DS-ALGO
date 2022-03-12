package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Ref: https://www.techiedelight.com/find-kth-largest-element-array/

// https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1/?page=1&company[]=Walmart&category[]=Arrays&sortBy=submissions

/*
 	int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.offer(arr[i]);
        }
        
        for(int i=k; i<n; i++) {
            if(arr[i] > pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        
        int[] res = new int[k];
        int i = k-1;
        while(!pq.isEmpty()) {
            res[i--] = pq.poll();
        }
        
        return res;
    }
 */

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
