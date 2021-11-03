package com.assignment.backtracking;

import java.util.Arrays;
import java.util.List;

//DP + Memoization
//Ref: https://www.youtube.com/watch?v=th4OnoGasMU Techdose

// 139. Word Break
public class WordBreak {

	static Boolean[] dp;
	
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println(wordBreak(s, wordDict));
	}
	
	
    public static boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return partition(s, 0, wordDict);
    }
    
    private static boolean partition(String s, int pos, List<String> wordDict){
        if(pos==s.length())   return true;
        if(dp[pos]!=null)  return dp[pos];
        
        for(int i=pos; i<s.length(); i++)
            if(wordDict.contains(s.substring(pos,i+1)) && partition(s, i+1, wordDict))
                return dp[pos] = true;
        return dp[pos] = false;
    }

}
