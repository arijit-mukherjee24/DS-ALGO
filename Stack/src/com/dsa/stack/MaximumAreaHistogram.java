package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.youtube.com/watch?v=J2X70jj_I1o&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=7 Aditya verma
public class MaximumAreaHistogram {

	public static void main(String[] args) {
		int[] arr = { 6, 2, 5, 4, 5, 1, 6 };
		//int[] arr = { 2, 4 };
		int max = getMaxArea(arr);
		System.out.println("The Maximum area is " + max);
	}

	private static int getMaxArea(int[] arr) {

		int n = arr.length;
		int max = 0;

		int[] width = new int[n];
		int[] area = new int[n];

		int[] right = findNextSmallerElements(arr);
		System.out.println("Right array "+ Arrays.toString(right));
		int[] left = findPrevSmallerElements(arr);
		System.out.println("Left array "+ Arrays.toString(left));

		for (int i = 0; i <= n - 1; i++) {
			width[i] = right[i] - left[i] - 1;
			area[i] = width[i] * arr[i];
			if (area[i] > max)
				max = area[i];
		}
		System.out.println("Width array "+ Arrays.toString(width));
		System.out.println("Area array "+ Arrays.toString(area));
		return max;
	}

	private static int[] findNextSmallerElements(int[] arr) {
		int[] res = new int[arr.length];
		int pseudo_index = arr.length;
		Arrays.fill(res, pseudo_index);

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();
		int n = arr.length;

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (stack.peek() >= arr[i]) {
					stack.pop();
					indexStack.pop();
				} else {
					res[i] = indexStack.peek();
					break;
				}
			}
			stack.push(arr[i]);
			indexStack.push(i);
		}

		return res;
	}

	private static int[] findPrevSmallerElements(int[] arr) {
		int[] res = new int[arr.length];
		int pseudo_index = -1;
		Arrays.fill(res, pseudo_index);

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();
		int n = arr.length;

		for (int i = 0; i <= n - 1; i++) {
			while (!stack.isEmpty()) {
				if (stack.peek() >= arr[i]) {
					stack.pop();
					indexStack.pop();
				} else {
					res[i] = indexStack.peek();
					break;
				}
			}
			stack.push(arr[i]);
			indexStack.push(i);
		}

		return res;
	}

}
