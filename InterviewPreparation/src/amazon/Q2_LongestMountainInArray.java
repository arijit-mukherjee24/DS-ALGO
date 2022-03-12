package amazon;
// 845. Longest Mountain in Array

//Ref: https://www.youtube.com/watch?v=VXeukMTbxkw probability_coding_is_fun_is_1
public class Q2_LongestMountainInArray {

	public static void main(String[] args) {

	}

	public int longestMountain(int[] arr) {
		// Try to find the peak point and then try to find the longest array
		int ans = 0;
		int n = arr.length;
		for (int i = 1; i < n - 1;) {
			if ((arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1])) {
				int j = i;
				int count = 1;
				while (j > 0 && (arr[j] > arr[j - 1])) {
					count++;
					j--;
				}

				while (i < n - 1 && (arr[i] > arr[i + 1])) {
					count++;
					i++;
				}
				ans = Math.max(ans, count);
			} else {
				i++;
			}
		}
		return ans;
	}

}
