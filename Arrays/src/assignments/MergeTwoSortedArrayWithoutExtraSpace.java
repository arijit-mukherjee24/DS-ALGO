package assignments;

// Ref: https://www.youtube.com/watch?v=NWMcj5QFW74  (techdose)
// https://gist.github.com/SuryaPratapK/5a05ed7f0cf5cc409218dd89bc6ba51f
public class MergeTwoSortedArrayWithoutExtraSpace {

	public static void main(String[] args) {
		// int[] arr1 = { 1, 5, 9, 10, 15, 20 };
		int[] arr1 = { 1, 2, 8 };
		int m = arr1.length;

		// int[] arr2 = { 2, 3, 8, 13 };
		int[] arr2 = { 3, 6 };
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
		for (int i = n - 1; i >= 0; i--) {
			int last = arr1[m - 1];
			int j;

			for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
				arr1[j + 1] = arr1[j];
			}

			if (j != m - 2 || last > arr2[i]) {
				arr1[j + 1] = arr2[i];
				arr2[i] = last;
			}
		}
	}

}
