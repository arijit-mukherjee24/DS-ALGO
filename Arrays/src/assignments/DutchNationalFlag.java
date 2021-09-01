package assignments;

// Ref: https://www.youtube.com/watch?v=sEQk8xgjx64
public class DutchNationalFlag {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 0, 1, 2 };

		sort012(arr);
		System.out.println("The sorted array is :");
		for (int i : arr)
			System.out.print(i + " ");
	}

	private static void sort012(int[] arr) {
		int lo = 0;
		int mi = 0;
		int hi = arr.length - 1;

		while (mi <= hi) {
			if (arr[mi] == 0) {
				swap(arr, lo, mi);
				lo++;
				mi++;
			} else if (arr[mi] == 1) {
				mi++;
			} else {
				swap(arr, mi, hi);
				hi--;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
