package com.assignment.greedy;

import java.util.Arrays;

// Leetcode 621. Task Scheduler : https://leetcode.com/problems/task-scheduler/

// Ref: https://www.youtube.com/watch?v=l6-y7MrHLB8 Algorithms made easy

public class TaskScheduler {

	public static void main(String[] args) {

	}

	public int leastInterval(char[] tasks, int n) {
		// frequencies of task
		int[] frequencies = new int[26];

		for (int t : tasks) {
			frequencies[t - 'A']++;
		}

		Arrays.sort(frequencies);

		// mac frequency
		int f_max = frequencies[25];

		int idle_time = (f_max - 1) * n;

		for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; i--) {
			idle_time = idle_time - Math.min(f_max - 1, frequencies[i]);
		}

		idle_time = Math.max(0, idle_time);

		return tasks.length + idle_time;

	}

}
