package com.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

// https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6 Aditya Verma
// https://www.techiedelight.com/next-greater-element/ 3rd approach
public class StockSpanProblem {

	public static void main(String[] args) {
		int[] arr = { 100, 80, 60, 70, 60, 75, 85 };

		int[] result = calculateSpan(arr);
		System.out.println(Arrays.toString(result));
	}

	private static int[] calculateSpan(int[] arr) {
		int[] res = new int[arr.length];
		// Fills all the element with 1
		Arrays.fill(res, 1);

		Stack<Integer> stack = new Stack<Integer>();       // for the price of the stocks
		Stack<Integer> indexStack = new Stack<Integer>();  // for the index of the stocks
		
		int n = arr.length;

		for (int i = 0; i <= n - 1; i++) {
			while (!stack.isEmpty()) {
				if (stack.peek() <= arr[i]) {
					stack.pop(); // price
					indexStack.pop(); // index of price
				} else {
					res[i] = i - indexStack.peek();    // index - ngl_index
					break;
				}
			}
			stack.push(arr[i]); // price
			indexStack.push(i); // index of the price
		}

		return res;
	}

}
