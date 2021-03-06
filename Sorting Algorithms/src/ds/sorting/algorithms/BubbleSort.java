package ds.sorting.algorithms;
// https://www.geeksforgeeks.org/bubble-sort/
public class BubbleSort {

	public static void main(String[] args) {

		BubbleSort obj = new BubbleSort();
		int arr[] = { 44, 25, 12, 22, 11 };
		obj.sort(arr);
		System.out.println("Sorted array using bubble sort: ");
		obj.printArray(arr);
	}

	void sort(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			// Array is sorted from the end
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Prints the array
	void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

}
