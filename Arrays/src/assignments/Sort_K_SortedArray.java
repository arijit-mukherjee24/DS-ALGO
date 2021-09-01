package assignments;

import java.util.Iterator;
import java.util.PriorityQueue;

// nlogk - Tc
// https://www.geeksforgeeks.org/nearly-sorted-algorithm/
// https://www.youtube.com/watch?v=dYfM6J1y0mU (Aditya Verma)
public class Sort_K_SortedArray {

	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 12, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	private static void kSort(int[] arr, int n, int k) {
		// minHeap
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		for (int i = 0; i < k + 1; i++) {
			priorityQueue.offer(arr[i]);
		}
		
		int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.offer(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
	}

}
