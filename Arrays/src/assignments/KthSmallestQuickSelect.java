package assignments;

public class KthSmallestQuickSelect {

	public static void main(String[] args) {
		//int arr[] = { 3, 2, 1, 5, 6, 4 };
		//int k = 2;
		
		int arr[] = { 7, 4, 6, 3, 9, 1 };
		int k = 3;

		int ans = findKthSmallest(arr, k);
		System.out.println("k’th smallest array element is "+ans);
	}

	private static int findKthSmallest(int[] arr, int k) {
		return quickSelect(arr, 0, arr.length - 1, k);
	}

	private static int quickSelect(int[] arr, int low, int high, int k) {

		int pi = partition(arr, low, high);

		if (pi == k-1)       // only change in condition for smallest and largest
			return arr[pi];

		else if (pi < k-1) {
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
