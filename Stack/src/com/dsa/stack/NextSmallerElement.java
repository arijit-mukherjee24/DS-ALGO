package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=5 Aditya Verma
// https://www.techiedelight.com/next-greater-element/ 3rd approach
public class NextSmallerElement {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 2, 10, 8 };

		int[] result = findNextSmallerElements(arr);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findNextSmallerElements(int[] arr) {
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);

		Stack<Integer> stack = new Stack<Integer>();
		int n = arr.length;

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (stack.peek() >= arr[i]) {
					stack.pop();
				} else {
					res[i] = stack.peek();
					break;
				}
			}
			stack.push(arr[i]);
		}

		return res;
	}

}
