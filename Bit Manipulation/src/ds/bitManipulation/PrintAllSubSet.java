package ds.bitManipulation;

public class PrintAllSubSet {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		printAllPossibleSubset(arr);
	}

	private static void printAllPossibleSubset(int[] arr) {
		// total possible sequence = 2^n ==> 0 to 2^n -1
		int n = arr.length;
		int temp = 1 << n;

		for (int k = 0; k < temp; k++) {
			for (int i = 0; i < n; i++) {
				if ((k & (1 << i)) > 0) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
	}

}
