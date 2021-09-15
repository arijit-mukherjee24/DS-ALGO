package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://leetcode.com/submissions/detail/542288393/ Leetocde 295
// https://www.youtube.com/watch?v=1LkOrc-Le-Y (techdose)
public class MedianFromDataStream {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // For right half
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // For left half

	public static void main(String[] args) {
		MedianFromDataStream obj = new MedianFromDataStream();
		System.out.println("Median after insertion of each data: ");
		obj.addNum(5);
		double param_2 = obj.findMedian();
		System.out.println("5 -> " + param_2);

		obj.addNum(3);
		param_2 = obj.findMedian();
		System.out.println("3 -> " + param_2);

		obj.addNum(4);
		param_2 = obj.findMedian();
		System.out.println("4 -> " + param_2);

		obj.addNum(2);
		param_2 = obj.findMedian();
		System.out.println("2 -> " + param_2);

		obj.addNum(6);
		param_2 = obj.findMedian();
		System.out.println("6 -> " + param_2);
	}

	public void addNum(int num) {
		// In the maxHeap we are keeping the lower part and in the minheap we are
		// keeping higher part
		int leftSize = maxHeap.size();
		int rightSize = minHeap.size();

		if (leftSize == 0) { // Very first element
			maxHeap.offer(num);
		} else if (leftSize == rightSize) { // both heap sizes are same
			if (minHeap.peek() > num) {
				maxHeap.offer(num);
			} else {
				int temp = minHeap.poll();
				minHeap.offer(num);
				maxHeap.offer(temp);
			}
		} else { // maxHeap can be greater by 1 compare to minheap
			if (rightSize == 0) { // If minHeap size is 0
				if (maxHeap.peek() < num) {
					minHeap.offer(num);
				} else {
					int temp = maxHeap.poll();
					maxHeap.offer(num);
					minHeap.offer(temp);
				}
			} else if (minHeap.peek() <= num) {
				minHeap.offer(num);
			} else {
				if (maxHeap.peek() > num) {
					int temp = maxHeap.poll();
					maxHeap.offer(num);
					minHeap.offer(temp);
				} else { // in between any number
					minHeap.offer(num);
				}
			}
		}
	}

	public double findMedian() {
		int leftSize = maxHeap.size();
		int rightSize = minHeap.size();

		if (leftSize > rightSize) {
			return (double) maxHeap.peek();
		} else {
			return (double) ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
		}
	}

}
