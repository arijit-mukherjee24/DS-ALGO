package goldman_sachs;

//https://www.youtube.com/watch?v=Lj68VJ1wu84 Pepcoding (For better understanding)
//Techdose: https://www.youtube.com/watch?v=78Yx7oLA43s DP Approach Only
//TC: O(n) SC: O(n)

// 264. Ugly Number II
// https://practice.geeksforgeeks.org/problems/ugly-numbers2254/1/ gfg practice
public class UglyNumberII {

	public static void main(String[] args) {

	}

	static int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;

		int i2 = 0, i3 = 0, i5 = 0;
		int nm2 = 2, nm3 = 3, nm5 = 5;

		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(nm2, nm3), nm5);
			ugly[i] = min;

			if (min == nm2) {
				i2 = i2 + 1;
				nm2 = ugly[i2] * 2;
			}
			if (min == nm3) {
				i3 = i3 + 1;
				nm3 = ugly[i3] * 3;
			}
			if (min == nm5) {
				i5 = i5 + 1;
				nm5 = ugly[i5] * 5;
			}
		}
		return ugly[n - 1];
	}

}
