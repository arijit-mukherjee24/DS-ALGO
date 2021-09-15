package com.heap;
//Ref: https://www.youtube.com/watch?v=Wh3A29psE_Y Techdose
//https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Leetcode 347: Top K Frequent Elements
public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { 1,1,1,2,2,3 };
		int k = 2;
		int[] res = topKFrequent(nums, k);
		for(int i: res)
			System.out.print(i + " ");
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i: nums) {
             map.put( i, map.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
        (a,b) ->  a.getValue().equals(b.getValue())
        ? Integer.compare(b.getKey(), a.getKey())
        : Integer.compare(b.getValue(), a.getValue()));
        
        
            
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

}
