package walmart;

//https://www.youtube.com/watch?v=5crucASFoA4 Pepcoding Backtracking
//https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
/*
Time Complexity: O(n^k). 
For every recursive call n recursive calls is generated until
the value of k is 0. So total recursive calls are O((n)^k).

Space Complexity: O(n). 
The space required to store the output string.
*/
public class Q14_LargestNumber_K_swaps {

	public static void main(String[] args) {

	}

	static String max;

	// Function to find the largest number after k swaps.
	public static String findMaximumNum(String str, int k) {
		max = str;
		findMaximumNumUtil(str.toCharArray(), k, str.length());
		return max;
	}

	public static void findMaximumNumUtil(char[] arr, int k, int n) {
		if (k == 0)
			return;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				// if digit at position i is less than digit
				// at position j, we swap them and check for
				// maximum number so far.
				if (arr[j] > arr[i]) {
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					String s = new String(arr);

					// if current number is more than
					// maximum so far
					// If the first string is less than the second string lexicographically,
					// it returns a negative number
					if (max.compareTo(s) < 0) {
						max = s;
					}
					// calling recursive function to set the
					// next digit.
					findMaximumNumUtil(arr, k - 1, n);

					// backtracking
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

	}

}
