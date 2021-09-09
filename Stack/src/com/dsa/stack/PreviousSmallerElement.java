package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4 Aditya Verma
// https://www.techiedelight.com/next-greater-element/ 3rd approach
public class PreviousSmallerElement {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 5, 4, 6, 8 };

		int[] result = findPrevSmallerElements(arr);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findPrevSmallerElements(int[] arr) {
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);

		Stack<Integer> stack = new Stack<Integer>();
		int n = arr.length;

		for (int i = 0; i <= n - 1; i++) {
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
