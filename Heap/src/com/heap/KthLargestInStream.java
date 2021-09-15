package com.heap;
// Leetcode : 703. Kth Largest Element in a Stream
import java.util.PriorityQueue;

//ref: https://www.youtube.com/watch?v=G5CVOjWDAmY Coding Simplified
//https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/1459107/Java-solution-with-explanation-clean-concise-easy-to-understand-minHeap
class KthLargestInStream {
	private int maxElements;
	private PriorityQueue<Integer> minHeap; // min heap; smallest will be always the first element in the minHeap

	public KthLargestInStream(int k, int[] nums) {
		this.maxElements = k; // how many elements can we keep in minHeap
		this.minHeap = new PriorityQueue<Integer>(maxElements); // initialCapacity
		for (int num : nums) {
			minHeap.add(num); // add all numbers
			if (minHeap.size() > maxElements) // while adding numbers check if the queue has more than k elements remove
												// the smallest
				minHeap.remove();
		}
	}

	public int add(int val) {
		if (minHeap.size() < maxElements) {
			minHeap.add(val);
			return minHeap.size() == maxElements ? minHeap.peek() : -1;
		}

		if (val > minHeap.peek()) {
			minHeap.poll();
			minHeap.add(val);
		}

		return minHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums =  { 4, 5, 8, 2 };
		KthLargestInStream kthLargest = new KthLargestInStream(3, nums);
		System.out.println(kthLargest.add(3));   // return 4
		System.out.println(kthLargest.add(5));  // return 5
		System.out.println(kthLargest.add(10));  // return 5
		System.out.println(kthLargest.add(9));   // return 8
		System.out.println(kthLargest.add(4));   // return 8

	}
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
