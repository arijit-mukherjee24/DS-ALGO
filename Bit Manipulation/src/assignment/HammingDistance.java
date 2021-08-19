package assignment;

// Leetcode - 461
// Ref - https://www.youtube.com/watch?v=FalNJegwYkI
public class HammingDistance {

	public static void main(String[] args) {
		int x = 4;
		int y = 1;
		int ans = hammingDistance(x, y);
		System.out.println("The hamming distance is "+ans);
	}

	private static int hammingDistance(int x, int y) {
		if (x == y)
			return 0;

		int res = x ^ y;
		int count = 0;
		int shift = 1;
		while (res != 0) {
			if ((res & shift) > 0) {
				count++;
			}
			res >>= 1;
		}
		
		return count;
	}

}
