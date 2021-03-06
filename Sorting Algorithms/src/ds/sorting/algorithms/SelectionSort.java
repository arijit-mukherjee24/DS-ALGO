package ds.sorting.algorithms;
// https://www.geeksforgeeks.org/selection-sort/
public class SelectionSort {

	public static void main(String[] args) {
	
		SelectionSort obj = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		obj.sort(arr);
		System.out.println("Sorted array using selection sort: ");
		obj.printArray(arr);
	}

	void sort(int[] arr) {
		int n = arr.length;
		 // One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
		   // Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}
			// Swap the found minimum element with the first element
			int temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;
		}
	}

	// Prints the array
	void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

}
