package ds.sorting.algorithms;

import java.util.Collections;
import java.util.Vector;

// https://www.geeksforgeeks.org/bucket-sort-2/
// https://www.youtube.com/watch?v=VuXbEb5ywrU
public class BucketSort {

	public static void main(String[] args) {

		float arr[] = { (float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665, (float) 0.3434 };
		int n = arr.length;
		bucketSort(arr, n);
		System.out.println("Sorted array using bucket sort: ");
		printArray(arr);
	}

	static void bucketSort(float[] arr, int n) {
		if (n < 0)
			return;

		// 1) Create n empty buckets
		@SuppressWarnings("unchecked")
		Vector<Float>[] bucket = new Vector[n];
		for (int i = 0; i < n; i++) {
			bucket[i] = new Vector<Float>();
		}

		// 2) Put array elements in different buckets
		for (int i = 0; i < n; i++) {
			float index = arr[i] * n;
			bucket[(int) index].add(arr[i]);
		}
		
		// 3) Sort individual buckets
		for (int i = 0; i < n; i++) {
			Collections.sort(bucket[i]);
		}
		
		// 4) Concatenate all buckets into arr
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < bucket[i].size(); j++) {
				arr[idx++] = bucket[i].get(j);
			}
		}

	}

	// Prints the array
	static void printArray(float[] arr) {
		for (float i : arr)
			System.out.print(i + " ");
	}

}
