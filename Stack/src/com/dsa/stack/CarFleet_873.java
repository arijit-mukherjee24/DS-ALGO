package com.dsa.stack;

import java.util.PriorityQueue;

// Leetcode 873
//Ref: https://leetcode.com/problems/car-fleet/discuss/180287/Java-Priority-Queue-Explained
public class CarFleet_873 {

	public static void main(String[] args) {
		int[] position = { 10, 8, 0, 5, 3 };
		int[] speed = { 2, 4, 1, 1, 3 };
		int target = 12;
		int count = carFleet(target, position, speed);
		System.out.println("No of car fleets = " + count);
	}

	public static int carFleet(int target, int[] position, int[] speed) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return b[1] - a[1];
		});
		for (int i = 0; i < position.length; i++) {
			pq.offer(new int[] { i, position[i] });
		}
		double time = 0;
		int count = 0;
		while (!pq.isEmpty()) {
			int[] next = pq.poll();
			int index = next[0];
			int pos = next[1];
			int spd = speed[index];
			double needTime = (double) (target - pos) / spd;
			if (needTime > time) {
				count++;
				time = needTime;
			}
		}
		return count;
	}

}
