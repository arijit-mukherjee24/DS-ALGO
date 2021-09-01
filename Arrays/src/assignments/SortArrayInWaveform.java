package assignments;

// Ref: https://www.youtube.com/watch?v=8oR5OBW5buk
// https://www.geeksforgeeks.org/sort-array-wave-form-2/
public class SortArrayInWaveform {

	public static void main(String[] args) {
		int arr[] = { 10, 90, 49, 2, 1, 5, 23 };
		int n = arr.length;
		sortInWave(arr, n);
		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void sortInWave(int[] arr, int n) {
		// Only check the even indices, so i = i+2
		for (int i = 0; i < n; i += 2) {
			if (i > 0 && arr[i - 1] > arr[i]) {
				swap(arr, i - 1, i);
			}
			if (i < n - 1 && arr[i + 1] > arr[i]) {
				swap(arr, i + 1, i);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
