package adobe;
// https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1/ gfg practice

//https://www.techiedelight.com/pots-gold-game-dynamic-programming/ Memoization
public class Q7_PotsofGoldGame {

	public static void main(String[] args) {

	}

	public static int maxCoins(int coin[], int n) {

		// create a table to store solutions to subproblems
		int[][] lookup = new int[n][n];
		return findMaxCoins(coin, 0, coin.length - 1, lookup);
	}

	// Function to maximize the number of coins collected by a player,
	// assuming that the opponent also plays optimally
	public static int findMaxCoins(int[] coin, int i, int j, int[][] lookup) {
		// base case: one pot left, only one choice possible
		if (i == j) {
			return coin[i];
		}

		// if we are left with only two pots, choose one with maximum coins
		if (i + 1 == j) {
			return Integer.max(coin[i], coin[j]);
		}

		// if the subproblem is seen for the first time, solve it and
		// store its result in a lookup table
		if (lookup[i][j] == 0) {
			// if a player chooses the front pot `i`, the opponent is left to choose
			// from [i+1, j].
			// 1. If the opponent chooses front pot `i+1`, recur for [i+2, j]
			// 2. If the opponent chooses rear pot `j`, recur for [i+1, j-1]

			int start = coin[i]
					+ Integer.min(findMaxCoins(coin, i + 2, j, lookup), findMaxCoins(coin, i + 1, j - 1, lookup));

			// if a player chooses rear pot `j`, the opponent is left to choose
			// from [i, j-1].
			// 1. If the opponent chooses front pot `i`, recur for [i+1, j-1]
			// 2. If the opponent chooses rear pot `j-1`, recur for [i, j-2]

			int end = coin[j]
					+ Integer.min(findMaxCoins(coin, i + 1, j - 1, lookup), findMaxCoins(coin, i, j - 2, lookup));

			// assign a maximum of two choices
			lookup[i][j] = Integer.max(start, end);
		}

		// return the subproblem solution from the map
		return lookup[i][j];
	}

}
