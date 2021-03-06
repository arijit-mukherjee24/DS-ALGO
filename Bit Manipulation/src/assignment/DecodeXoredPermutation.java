package assignment;

// Leetcode 1734
// https://www.youtube.com/watch?v=I5-uDlbwbOA
public class DecodeXoredPermutation {

	public static void main(String[] args) {
		int[] encoded = { 6, 5, 4, 6 };
		int[] ans = decode(encoded);
		System.out.println("The perm array is ");
		for (int i : ans)
			System.out.print(i + " ");
	}

	private static int[] decode(int[] encoded) {
		// Reference - https://www.youtube.com/watch?v=I5-uDlbwbOA
		int tot = 0;

		// size of the perm array is one more than the encoded array
		int size = encoded.length + 1;

		// XOR of first n numbers
		for (int i = 1; i <= size; i++)
			tot = tot ^ i;

		// XOR of alternate number starting
		int x = 0;
		for (int i = 1; i < encoded.length; i = i + 2)
			x ^= encoded[i];

		// to get the first value of perm array
		int f = x ^ tot;

		int[] res = new int[size];
		res[0] = f;

		for (int i = 1; i < size; i++)
			res[i] = res[i - 1] ^ encoded[i - 1];

		return res;
	}

}
