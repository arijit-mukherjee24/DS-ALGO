package assignments;

public class KthLargestQuickSelect {

	public static void main(String[] args) {
		//int arr[] = { 3, 2, 1, 5, 6, 4 };
		//int k = 2;
		
		int arr[] = { 3,2,3,1,2,4,5,5,6 };
		int k = 4;

		int ans = findKthLargest(arr, k);
		System.out.println(ans);
	}

	private static int findKthLargest(int[] arr, int k) {
		return quickSelect(arr, 0, arr.length - 1, k);
	}

	private static int quickSelect(int[] arr, int low, int high, int k) {

		int n = arr.length;
		int pi = partition(arr, low, high);

		if (pi == n - k)
			return arr[pi];

		else if (pi < n - k) {
			return quickSelect(arr, pi + 1, high, k);
		} else {
			return quickSelect(arr, low, pi - 1, k);
		}

	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);

		return (i + 1);
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
