package assignments;

// Ref: https://www.youtube.com/watch?v=6qXO72FkqwM (techdose)
// Leetcode 31 - 
public class NextPermutation {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		System.out.println("The next permutation is");
		nextPermutation(arr);
	}

	private static void nextPermutation(int[] arr) {
		int lst_peek_idx = -1;
		int n = arr.length;

		for (int i = n - 1; i > 0; i++) {
			if (arr[i] > arr[i - 1]) {
				lst_peek_idx = i;
				break;
			}
		}

		if (lst_peek_idx == -1) {
			reverse(arr, 0);
		} else {
			int prev = lst_peek_idx;
			for (int i = lst_peek_idx + 1; i < n; i++) {
				if (arr[i] > arr[lst_peek_idx - 1] && arr[i] <= arr[prev]) {
					prev = i;
				}
			}
			swap(arr, lst_peek_idx - 1, prev);
			reverse(arr, lst_peek_idx);

		}

		for (int i : arr)
			System.out.print(i + " ");

	}

	private static void reverse(int[] arr, int start) {
		int i = start;
		int j = arr.length - 1;

		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
