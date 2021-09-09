package com.dsa.stack;
// https://www.youtube.com/watch?v=8UegNFCUQks Techdose
// https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
import java.util.Stack;

public class MinStackWithExtraSpace extends Stack<Integer> {

	private static final long serialVersionUID = 1L;
	Stack<Integer> min = new Stack<>();
	
	long[] m = new long[12];
	
	public static void main(String[] args) {
		MinStackWithExtraSpace s = new MinStackWithExtraSpace();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.getMin());
		s.push(5);
		System.out.println(s.getMin());
		s.push(12);
		System.out.println(s.top());
	}
	
	void push(int x) {
		if (isEmpty() == true) {
			super.push(x);
			min.push(x);
		} else {
			super.push(x);
			int y = min.pop();
			min.push(y);
			if (x < y) {
				min.push(x);
			} else {
				min.push(y);
			}
		}
	}

	public Integer pop() {
		int x = super.pop();
		min.pop();
		return x;

	}

	int top() {
		int x = super.pop();
		super.push(x);
		return x;
	}

	int getMin() {
		int x = min.pop();
		min.push(x);
		return x;
	}
}
