package assignments;

// Ref: https://www.youtube.com/watch?v=hVl2b3bLzBw  (Take u forward)
// https://www.techiedelight.com/inplace-merge-two-sorted-arrays/
public class MergeTwoSortedArrayWithoutExtraSpace2 {

	public static void main(String[] args) {
		int[] arr1 = { 1, 5, 9, 10, 15, 20 };
		// int[] arr1 = { 1, 2, 8 };
		int m = arr1.length;

		int[] arr2 = { 2, 3, 8, 13 };
		// int[] arr2 = { 3, 6 };
		int n = arr2.length;

		mergeWithoutExtraSpace(arr1, m, arr2, n);
		System.out.println("The sorted array's after merge are ");
		for (int i : arr1)
			System.out.print(i + " ");
		System.out.println();
		for (int i : arr2)
			System.out.print(i + " ");
	}

	private static void mergeWithoutExtraSpace(int[] arr1, int m, int[] arr2, int n) {
		for (int i = 0; i < m; i++) {
			if (arr1[i] > arr2[0]) {

				// swap arr[i] with arr2[0]
				int temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;

				int first = arr2[0];

				// move `Y[0]` to its correct position to maintain the sorted
				// order of `Y[]`. Note: `Y[1…n-1]` is already sorted
				int k;
				for (k = 1; k < n && arr2[k] < first; k++) {
					arr2[k - 1] = arr2[k];
				}

				arr2[k - 1] = first;
			}

		}
	}

}

// Gap method provides the best solution, but the code and intuition not clear.
