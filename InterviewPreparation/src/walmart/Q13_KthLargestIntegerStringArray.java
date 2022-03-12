package walmart;

import java.util.Arrays;
import java.util.Comparator;

//Ref: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/discuss/1432025/Java-Custom-Sorting-O(NlogN)

//The kth largest element is equivalent to the n-kth smallest element. Thus, lets sort the strings, first by their length, and break ties by the string comparator. Then, return the n-kth element.

//Time Complexity - O(NlogN)
//Space Complexity - O(1)

// 1985. Find the Kth Largest Integer in the Array
public class Q13_KthLargestIntegerStringArray {

	public static void main(String[] args) {
		
	}
	
	public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() != b.length()) return a.length()-b.length();
                return a.compareTo(b);
            }
        });
        
        return nums[nums.length - k];
    }
}

/*
     public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (s1.length() == s2.length()) 
                return s1.compareTo(s2);
            else
                return Integer.compare(s1.length(), s2.length());
        });
        Arrays.stream(nums)
            .forEach(num -> {
                minHeap.offer(num);
            if(minHeap.size() > k) minHeap.poll();
            });
        
        return minHeap.poll();
    }
*/


