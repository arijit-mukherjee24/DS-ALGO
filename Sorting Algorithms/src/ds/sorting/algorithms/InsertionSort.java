package ds.sorting.algorithms;
// https://www.geeksforgeeks.org/insertion-sort/
// https://www.youtube.com/watch?v=wWhAhp6PIuQ
public class InsertionSort {

	public static void main(String[] args) {
	
		InsertionSort obj = new InsertionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		obj.sort(arr);
		System.out.println("Sorted array using insertion sort: ");
		obj.printArray(arr);
	}

	void sort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	// Prints the array
	void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

}
