package adobe;
// https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1/

/* Similar
556. Next Greater Element III
564. Find the Closest Palindrome
https://practice.geeksforgeeks.org/problems/next-smallest-palindrome4740/1# 
*/

// REF: https://www.geeksforgeeks.org/next-higher-palindromic-number-using-set-digits/?ref=lbp
// String str = "4697557964"; (Try dry run with this example)
// Time Complexity: O(n)
public class Q9_NextHigherPalindromeUsingSameDigit {

	public static void main(String[] args) {

	}

	public String nextPalin(String str) {
		char num[] = str.toCharArray();
		int n = str.length();

		// if length of number is less than '3'
		// then no higher palindromic number
		// can be formed
		if (n <= 3) {
			return "-1";
		}
		char temp;

		// find the index of last digit
		// in the 1st half of 'num'
		int mid = n / 2 - 1;
		int i, j;

		// Start from the (mid-1)th digit and
		// find the first digit that is
		// smaller than the digit next to it.
		for (i = mid - 1; i >= 0; i--)
			if (num[i] < num[i + 1])
				break;

		// If no such digit is found, then all
		// digits are in descending order which
		// means there cannot be a greater
		// palindromic number with same set of
		// digits
		if (i < 0) {
			return "-1";
		}

		// Find the smallest digit on right
		// side of ith digit which is greater
		// than num[i] up to index 'mid'
		int smallest = i + 1;
		for (j = i + 2; j <= mid; j++)
			if (num[j] > num[i] && num[j] <= num[smallest])
				smallest = j;

		// swap num[i] with num[smallest]
		temp = num[i];
		num[i] = num[smallest];
		num[smallest] = temp;

		// as the number is a palindrome,
		// the same swap of digits should
		// be performed in the 2nd half of
		// 'num'
		temp = num[n - i - 1];
		num[n - i - 1] = num[n - smallest - 1];
		num[n - smallest - 1] = temp; // [4, 7, 9, 6, 5, 5, 6, 9, 7, 4]

		// reverse digits in the range (i+1)
		// to mid
		reverse(num, i + 1, mid); // [4, 7, 5, 6, 9, 5, 6, 9, 7, 4]

		// if n is even, then reverse
		// digits in the range mid+1 to
		// n-i-2
		if (n % 2 == 0)
			reverse(num, mid + 1, n - i - 2); // [4, 7, 5, 6, 9, 9, 6, 5, 7, 4]

		// else if n is odd, then reverse
		// digits in the range mid+2 to n-i-2
		else
			reverse(num, mid + 2, n - i - 2);

		// required next higher palindromic
		// number
		String result = String.valueOf(num);
		return result;

	}

	// function to reverse the digits in the
	// range i to j in 'num'
	public static void reverse(char num[], int i, int j) {
		while (i < j) {
			char temp = num[i];
			num[i] = num[j];
			num[j] = temp;
			i++;
			j--;
		}
	}

}
