package goldman_sachs;

//https://www.youtube.com/watch?v=wx0nyomRS_U GFG
//TC: O(1)  Geometric
// https://practice.geeksforgeeks.org/problems/overlapping-rectangles1924/1/
public class Overlapping_rectangles {

	public static void main(String[] args) {

	}

	static int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
		if (L2[0] > R1[0] || L1[0] > R2[0]) {
			return 0;
		}

		if (L2[1] < R1[1] || L1[1] < R2[1]) {
			return 0;
		}

		return 1;
	}
}
