package ds.sorting.algorithms;

import java.util.Arrays;

// https://www.geeksforgeeks.org/radix-sort/
// https://www.youtube.com/watch?v=Il45xNUHGp0
public class RadixSort {

	public static void main(String[] args) {
	
		RadixSort obj = new RadixSort();
		int arr[] = { 432, 8, 530, 90, 88, 231, 11, 45, 677, 199 };
		obj.radixSort(arr); 
		System.out.println("Sorted array using radix sort: ");
		obj.printArray(arr);
	}
	
	void radixSort(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int n = arr.length;
		int base = 10;
		for(int pos = 1; max/pos > 0; pos = pos*base) {
			countingSort(arr, n, pos);
		}
	}

	void countingSort(int[] arr, int n, int pos) {
		int base = 10;
		int count[] = new int[base];
		int output[] = new int[n];

		for (int i = 0; i < n; i++) {
			++count[(arr[i]/pos)%base];
		}

		for (int i = 1; i <=(base-1); i++) {
			count[i] += count[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) {
			output[--count[(arr[i]/pos)%base]] = arr[i];
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
