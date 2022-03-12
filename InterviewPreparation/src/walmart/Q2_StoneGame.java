package walmart;
//877. Stone Game

//DP Approach : https://www.youtube.com/watch?v=ww4V7vRIzSk Pepcoding
public class Q2_StoneGame {

	public static void main(String[] args) {
		
	}
	
	public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        
        for(int g=0; g<dp.length; g++) {
            for(int i=0, j=g; j<dp.length; i++, j++) {
                if(g==0) {
                    dp[i][j] = piles[i];
                }
                else if(g==1) {
                    dp[i][j] = Math.max(piles[i], piles[j]);
                }
                else  {
                    int val1 = piles[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);
                    int val2 = piles[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
            
        return dp[0][piles.length-1]>0;
    }

}

/*
Alice is first to pick pile.
piles.length is even, and this lead to an interesting fact:
Alice can always pick odd piles or always pick even piles!

For example,
If Alice wants to pick even indexed piles piles[0], piles[2], ....., piles[n-2],
he picks first piles[0], then Bob can pick either piles[1] or piles[n - 1].
Every turn, Alice can always pick even indexed piles and Bob can only pick odd indexed piles.

In the description, we know that sum(piles) is odd.
If sum(piles[even]) > sum(piles[odd]), Alice just picks all evens and wins.
If sum(piles[even]) < sum(piles[odd]), Alice just picks all odds and wins.

So, Alice always defeats Bob in this game.

    public boolean stoneGame(int[] piles) {
        return true;
    }
*/