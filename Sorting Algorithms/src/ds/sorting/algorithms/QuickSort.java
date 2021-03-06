package ds.sorting.algorithms;

// https://www.geeksforgeeks.org/quick-sort/
// https://www.youtube.com/watch?v=UA_Rmjfj4bw
public class QuickSort {

	public static void main(String[] args) {

		// int arr[] = { 10, 7, 8, 9, 1, 5 };
		int arr[] = { 23, 13, 45, 67, 89, 2, 10, 86 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println("Sorted array using quick sort: ");
		printArray(arr);
	}

	private static void quickSort(int[] arr, int l, int h) {
		if (l < h) {
			int pivot = partition(arr, l, h);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, h);
		}
	}

	private static int partition(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l;
		int j = h;
		while (i < j) {
			while (arr[i] <= pivot &&  i < h) {
				i++;
			}
			while (arr[j] > pivot && j >= l) {
				j--;
			}
			if( i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, l, j);
		return j;
	}

	// A utility function to swap two elements
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// Prints the array
	private static void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

}
