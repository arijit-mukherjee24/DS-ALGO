package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8
public class MaxAreaRectangleinBinaryMatrix {

	public static void main(String[] args) {
		int[][] arr = { 
				{ 0, 1, 1, 0 }, 
				{ 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1 }, 
				{ 1, 1, 0, 0 } 
				};
		int maxArea = getMaxAreaBinaryMatrix(arr);
		System.out.println("The Max area is " + maxArea);
	}

	private static int getMaxAreaBinaryMatrix(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int[] res = new int[col];
		int max = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0) {
					res[j] = 0;
				} else {
					res[j] = res[j] + arr[i][j];
				}
			}
			max = Math.max(max, getMaxArea(res));
		}
		return max;
	}

	private static int getMaxArea(int[] arr) {
		int n = arr.length;
		System.out.println("Incoming array " + Arrays.toString(arr));
		int max = 0;

		int[] width = new int[n];
		int[] area = new int[n];

		int[] right = findNextSmallerElements(arr);
		// System.out.println("Right array " + Arrays.toString(right));
		int[] left = findPrevSmallerElements(arr);
		// System.out.println("Left array " + Arrays.toString(left));

		for (int i = 0; i <= n - 1; i++) {
			width[i] = right[i] - left[i] - 1;
			area[i] = width[i] * arr[i];
			if (area[i] > max)
				max = area[i];
		}
		// System.out.println("Width array " + Arrays.toString(width));
		System.out.println("Max Area array " + Arrays.toString(area) + "\n");
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
