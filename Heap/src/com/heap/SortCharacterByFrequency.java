package com.heap;
// // Ref: https://www.youtube.com/watch?v=vltY5jxqcco Techdose
// Leetcode 451. Sort Characters By Frequency
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFrequency {

	public static void main(String[] args) {
		String s = "tree";
		String ans = frequencySort(s);
		System.out.println(ans);
	}
	
	public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<Map.Entry<Character, Integer>> queue = 
            new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }
        
        while(!queue.isEmpty()) {
            Map.Entry<Character,Integer> entry = queue.poll();  
            String str =  (entry.getKey() + "").repeat(entry.getValue());
            sb.append(str);
        }
        return sb.toString();
    }

}
