package adobe;
// https://practice.geeksforgeeks.org/problems/next-smallest-palindrome4740/1# gfg practice
import java.util.Vector;

//Code Ref: https://www.codechef.com/viewsolution/57982404
//Video Ref:  https://www.youtube.com/watch?v=hZcindWcYI4
public class NextSmallestPalindrome {

	public static void main(String[] args) {

	}

	Vector<Integer> generateNextPalindrome(int arr[], int n) {
		if (n == 1) {
			arr[0] += 1;
			if (arr[0] == 10)
				arr[0] += 1;
			return display(arr, n);
		}

		int mid = 0, left, right, odd = 0;
		left = n / 2 - 1;
		if (n % 2 != 0) {
			mid = n / 2;
			right = n / 2 + 1;
			odd = 1;
		} else {
			right = n / 2;
		}
		int i = left, j = right;
		while (i >= 0 && arr[i] == arr[j]) {
			i--;
			j++;
		}
		if (i == -1) {
			i = left;
			j = right;
		}
		if (arr[i] > arr[j]) {
			swap(arr, left, right);
		} else {
			if (odd == 0) // even digits
			{
				if (arr[left] == 9) {
					carryadd(arr, left);
				} else {
					arr[left] = arr[left] + 1;
				}
				swap(arr, left, right);

			} else {
				if (arr[mid] == 9) {
					carryadd(arr, mid);
				} else {
					arr[mid] = arr[mid] + 1;
				}
				swap(arr, left, right);
			}

		}
		return display(arr, n);

	}

	public static void carryadd(int[] arr, int left) {
		int carry = 1;
		while (left > 0 && carry == 1) {
			arr[left]++;
			if (arr[left] == 10)
				arr[left--] = 0;
			else
				carry = 0;
		}
		if (carry == 1)
			arr[left]++;
	}

	public static void swap(int[] arr, int left, int right) {
		while (left >= 0) {
			arr[right] = arr[left];
			left--;
			right++;
		}
		if (arr[right - 1] == 10) {
			arr[right - 1] = 1;
		}
	}

	public static Vector<Integer> display(int[] arr, int n) {
		Vector<Integer> res = new Vector<Integer>();
		for (int i = 0; i < n; i++)
			if (arr[i] == 10) {
				res.add(1);
				res.add(0);
			} else if (arr[i] == 11) {
				res.add(1);
				res.add(1);
			} else {
				res.add(arr[i]);
			}

		return res;
	}

}
