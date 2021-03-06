package ds.sorting.algorithms;

import java.util.Arrays;

// https://www.geeksforgeeks.org/counting-sort/
// https://www.youtube.com/watch?v=pEJiGC-ObQE
public class CountingSort {

	public static void main(String[] args) {
	
		CountingSort obj = new CountingSort();
		int arr[] = { 2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9 };
		obj.countingSort(arr); 
		System.out.println("Sorted array using counting sort: ");
		obj.printArray(arr);
	}

	void countingSort(int[] arr) {
		int n = arr.length;
		int max = Arrays.stream(arr).max().getAsInt();
		int k = max; // range
		int count[] = new int[max + 1];
		int output[] = new int[n];

		for (int i = 0; i < n; i++) {
			++count[arr[i]];
		}

		for (int i = 1; i <=k; i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[--count[arr[i]]] = arr[i];
		}

		for (int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	// Prints the array
	void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

}

/* Note: To deal with -ve number's add the min -ve number to each element and find the range" */
