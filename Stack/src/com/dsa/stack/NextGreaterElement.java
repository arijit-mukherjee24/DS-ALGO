package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2 Aditya Verma
// https://www.techiedelight.com/next-greater-element/ 3rd approach
public class NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 5, 4, 6, 8 };

		int[] result = findNextGreaterElements(arr);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findNextGreaterElements(int[] arr) {
		int[] res = new int[arr.length];
		Arrays.fill(res, -1);

		Stack<Integer> stack = new Stack<Integer>();
		int n = arr.length;

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (stack.peek() <= arr[i]) {
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
