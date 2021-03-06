package ds.sorting.algorithms;

// https://www.geeksforgeeks.org/merge-sort/
// https://www.youtube.com/watch?v=aDX3MFL0tYs
public class MergeSort {

	public static void main(String[] args) {

		int arr[] = { 44, 25, 12, 22, 11 };
		MergeSort obj = new MergeSort();
		System.out.println("Given Array");
		obj.printArray(arr);

		obj.sort(arr, 0, arr.length-1);
		System.out.println("\nSorted array using merge sort: ");
		obj.printArray(arr);
	}

	void sort(int[] arr, int l, int r) {
		if(l < r) {
			// Finding the Middle point
			int m = l + (r - l)/2;
			
			sort(arr, l, m);
			sort(arr, m+1, r);
			
			merge(arr, l, m, r);
		}
	}

	void merge(int[] arr, int l, int m, int r) {
		// size of the new array
		int b[] = new int[arr.length];

		int i = l;
		int j = m + 1;
		int k = l;

		while (i <= m && j <= r) {
			if (arr[i] < arr[j]) {
				b[k] = arr[i];
				i++;
			} else {
				b[k] = arr[j];
				j++;
			}
			k++;
		}

		if (i > m) {
			while (j <= r) {
				b[k] = arr[j];
				j++;
				k++;
			}
		} else {
			while (i <= m) {
				b[k] = arr[i];
				i++;
				k++;
			}
		}
		
		for(int x=l; x<=r; x++) {
			arr[x] = b[x];
		}

	}

	// Prints the array
	void printArray(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");
	}

}
