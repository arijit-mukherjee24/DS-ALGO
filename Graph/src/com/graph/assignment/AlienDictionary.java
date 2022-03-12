package com.graph.assignment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// Leetcode 269. Alien Dictionary
// Lintcode 892

// https://practice.geeksforgeeks.org/problems/alien-dictionary/1/?page=3&company[]=Walmart&sortBy=submissions

//https://www.youtube.com/watch?v=_u1Mn4_2hIo Pepcoding
//Topological Sort n Kahn Algo
public class AlienDictionary {

	public static void main(String[] args) {
		
	}
	
	public String findOrder(String [] dict, int N, int K)
    {
           HashMap<Character, HashSet<Character>> map = new HashMap<>();
           HashMap<Character, Integer> indegree = new HashMap<>();
           
           for(String st: dict) {
               for(char ch: st.toCharArray()) {
                   indegree.put(ch, 0);
               }
           }
           
           for(int i=0; i<N-1; i++) {
               String curr = dict[i];
               String next = dict[i+1];
               
               int len = Math.min(curr.length(), next.length());
               for(int j=0; j<len; j++) {
                   char ch1 = curr.charAt(j);
                   char ch2 = next.charAt(j);
                   
                   if(ch1 != ch2) {
                       HashSet<Character> set = new HashSet<>();
                       if(map.containsKey(ch1) == true) {
                           set = map.get(ch1);
                           if(set.contains(ch2) == false) {
                                set.add(ch2);
                                indegree.put(ch2, indegree.get(ch2)+1);
                                map.put(ch1, set);
                           }
                       } 
                       else {
                           set.add(ch2);
                           indegree.put(ch2, indegree.get(ch2)+1);
                           map.put(ch1, set);
                       }
                       break;
                   }
               }
           }
           
           LinkedList<Character> queue = new LinkedList<>();
           StringBuilder sb = new StringBuilder();
           
           for(char ch: indegree.keySet()) {
               if(indegree.get(ch) == 0) {
                   queue.addLast(ch);
               }
           }
           
           int count = 0;
           while(queue.size() > 0) {
               char rem = queue.removeFirst();
               sb.append(rem);
               count++;
               
               if(map.containsKey(rem)) {
                   HashSet<Character> nbrs = map.get(rem);
                   
                   for(char nbr: nbrs) {
                       indegree.put(nbr, indegree.get(nbr)-1);
                       if(indegree.get(nbr) == 0) {
                           queue.addLast(nbr);
                       }
                   }
               }
           }
           
           if(count == K){
               return sb.toString();
           }
           else {
               return "";
           }
        
    }
	

}
