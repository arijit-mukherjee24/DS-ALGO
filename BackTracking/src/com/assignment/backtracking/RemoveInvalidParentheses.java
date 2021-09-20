package com.assignment.backtracking;

import java.util.ArrayList;
import java.util.List;

// Leetcode 301. Remove Invalid Parentheses
//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String s = "()())()";
		List<String> res = removeInvalidParentheses(s);
		System.out.println(res);
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		char[] check = new char[] { '(', ')' };
		dfs(s, res, check, 0, 0);
		return res;
	}

	public static void dfs(String s, List<String> res, char[] check, int last_i, int last_j) {
		int count = 0;
		int i = last_i;
		while (i < s.length() && count >= 0) {

			if (s.charAt(i) == check[0])
				count++;
			if (s.charAt(i) == check[1])
				count--;
			i++;
		}

		if (count >= 0) {
			// no extra ')' is detected. We now have to detect extra '(' by reversing the
			// string.
			String reversed = new StringBuffer(s).reverse().toString();
			if (check[0] == '(')
				dfs(reversed, res, new char[] { ')', '(' }, 0, 0);
			else
				res.add(reversed);

		}

		else { // extra ')' is detected and we have to do something
			i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
			for (int j = last_j; j <= i; j++) {
				if (s.charAt(j) == check[1] && (j == last_j || s.charAt(j - 1) != check[1])) {
					dfs(s.substring(0, j) + s.substring(j + 1, s.length()), res, check, i, j);
				}
			}
		}
	}

}

/* Time Limit Exceeded : Propcoding : // https://www.youtube.com/watch?v=Cbbf5qe5stw Pepcoding
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int mra = getMin(s);  // maximum removal allowed
        List<String> ans = new ArrayList<>();
        solve(s, mra, ans);
        return ans;
    }
    
    private static void solve(String str, int mra, List<String> ans) {
        
        if(mra == 0) {
            // to check the string is valid, therefore it's minimum removal will be 0
            int mrnow = getMin(str);   // minimum removal allowed now
            if(mrnow == 0) {
                if(!ans.contains(str)) {
                    ans.add(str);
                }
            }
            return;
        }
        
        for(int i = 0; i< str.length(); i++) {
            // Removing the i th index character from the string
              String left = str.substring(0, i); 
              String right = str.substring(i+1); 
              solve(left+right, mra - 1, ans);
          }
    }
    
    private static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i< str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == '(') {
                st.push(ch);
            }
            else if(ch == ')') 
                if(st.size() == 0) {
                    st.push(ch);
                }
                else if(st.peek() == ')') {
                    st.push(ch);
                }
                else if(st.peek() == '(') {
                    st.pop();
                }
            }
        return st.size();
    }
} 

*/
