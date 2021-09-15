package com.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Leetcode 438. Find All Anagrams in a String

//Ref: https://www.youtube.com/watch?v=fYgU6Bi2fRg
//https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
public class AllAngrams {

	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> list = findAnagrams(s, p);
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	 public static List<Integer> findAnagrams(String s, String p) {
	        int n = s.length();
	        int k = p.length();
	        
	        List<Integer> list = new ArrayList<Integer>();
	        
	        if(n < k)
	            return list;
	       
	        int[] word = new int[26];
	        for(int i = 0; i < k; i++) {
	            char c = p.charAt(i);
	            word[c-'a']++;
	        }
	        
	        for(int i=0; i<=n-k; i++) {
	            int[] subText = new int[26];
	            
	            for(int j=i; j<i+k; j++) {
	                char c = s.charAt(j);
	                subText[c-'a']++;
	            }
	            
	            if(isAnagram(word, subText)) {
	                list.add(i);
	            }
	        }
	        return list;
	    }
	    
	    private static boolean isAnagram(int[] word, int[] subPart) {
	       for(int i = 0; i< word.length; i++) {
	           if(word[i] != subPart[i]) {
	               return false;
	           }
	       }
	        return true;
	    }

}
