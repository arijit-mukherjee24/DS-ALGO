package amazon;

// https://practice.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter1322/1/

//https://www.youtube.com/watch?v=A6mOASLl2Dg Pepcoding
//https://www.youtube.com/watch?v=uHAToNgAPaM Kevin Naughton
//Leetcode 70

//Ref: https://www.youtube.com/watch?v=edjuC6TkXI4 Yash
public class Q8_Count_Ways_To_Nth_Stair {

	public static void main(String[] args) {
		
	}
	
	//Function to count number of ways to reach the nth stair 
    //when order does not matter.
    Long countWays(int m)
    {
        long[] dp = new long[m+1];
        dp[0] = 1L;
        dp[1] = 1L;
        
        for(int i=2; i<=m; i++) {
            dp[i] = dp[i-2] + 1;
        }
        
        return dp[m];
    } 

}
