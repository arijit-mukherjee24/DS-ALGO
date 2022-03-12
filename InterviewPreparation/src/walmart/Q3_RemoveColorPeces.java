package walmart;
// 2038. Remove Colored Pieces if Both Neighbors are the Same Color

/*
Ref: https://www.youtube.com/watch?v=kb9U0xizvUo Aditya Rajiv Understanding
Ref: https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/discuss/1524401/Java-solution.-O(n) Soln
Count Consecutive A: cntA
Count Consecutive B: cntB

AAAA-> cntA = count - 2;

cntA>cntB " Alice Wins" else "Bob Wins"
*/
public class Q3_RemoveColorPeces {

	public static void main(String[] args) {

	}

	public boolean winnerOfGame(String colors) {
		int countA = 0;
		int countB = 0;

		char[] mass = colors.toCharArray();

		for (int i = 1; i < mass.length - 1; i++) {
			if (mass[i - 1] == 'A' && mass[i] == 'A' && mass[i + 1] == 'A') {
				countA++;
			}
			if (mass[i - 1] == 'B' && mass[i] == 'B' && mass[i + 1] == 'B') {
				countB++;
			}
		}
		return countA > countB;
	}

}
