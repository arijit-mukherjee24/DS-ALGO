package com.string.rabinkarp;

// Ref: https://www.youtube.com/watch?v=qQ8vS2btsxI Abdul Bari
// Ref: https://www.youtube.com/watch?v=BQ9E-2umSWc Techdose

// GFG: https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
// Programiz: https://www.programiz.com/dsa/rabin-karp-algorithm
public class RabinKarpAlgo {

	// d is the number of characters in the input alphabet
	public final static int d = 256;

	public static void main(String[] args) {
		String txt = "GEEKS FOR GEEKS";
		String pat = "GEEK";

		// A prime number
		int q = 101;

		// Function Call
		search(pat, txt, q);
	}

	/*
	 * pat -> pattern txt -> text q -> A prime number
	 */
	static void search(String pat, String txt, int q) {
		int M = pat.length();
		int N = txt.length();
		int i, j;
		int p = 0; // hash value for pattern
		int t = 0; // hash value for txt
		int h = 1;

		// The value of h would be "pow(d, M-1)%q"
		for (i = 0; i < M - 1; i++)
			h = (h * d) % q;

		// Calculate the hash value of pattern and first
		// window of text
		for (i = 0; i < M; i++) {
			p = (d * p + pat.charAt(i)) % q;
			t = (d * t + txt.charAt(i)) % q;
		}

		// Slide the pattern over text one by one
		for (i = 0; i <= N - M; i++) {

			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if (p == t) {
				/* Check for characters one by one */
				for (j = 0; j < M; j++) {
					if (txt.charAt(i + j) != pat.charAt(j))
						break;
				}

				// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				if (j == M)
					System.out.println("Pattern found at index " + i);
			}

			// Calculate hash value for next window of text: Remove
			// leading digit, add trailing digit
			if (i < N - M) {
				t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

				// We might get negative value of t, converting it
				// to positive
				if (t < 0)
					t = (t + q);
			}
		}
	}

}

/*
 * Rabin-Karp Algorithm Complexity
The average case and best case complexity of Rabin-Karp algorithm is O(m + n) and the worst case complexity is O(mn).

The worst-case complexity occurs when spurious hits occur a number for all the windows.
*/

/*
 * Limitations of Rabin-Karp Algorithm
Spurious Hit
When the hash value of the pattern matches with the hash value of a window of the text but the window is not the actual pattern then it is called a spurious hit.

Spurious hit increases the time complexity of the algorithm. In order to minimize spurious hit, we use modulus. It greatly reduces the spurious hit.

*/
