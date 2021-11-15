package com.trie.leetcode;

//Ref: https://www.youtube.com/watch?v=I7sUjln2Fjw
//Ref: https://github.com/hellgeekarena/leetcode/blob/master/421.java

// 421. Maximum XOR of Two Numbers in an Array
public class MaximumXORofTwoNumbers {

	public static void main(String[] args) {

	}

	public int findMaximumXOR(int[] nums) {
		int max = 0;
		TriNode root = new TriNode();

		for (int i = 0; i < nums.length; i++) {
			TriNode curr = root;
			for (int j = 31; j >= 0; j--) {
				// using bit masking to identify the bit
				int l = (nums[i] & (1 << j)) > 0 ? 1 : 0;
				if (curr.children[l] == null) {
					curr.children[l] = new TriNode();
				}
				curr = curr.children[l];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			TriNode curr = root;
			int val = 0;
			for (int j = 31; j >= 0; j--) {
				int bit = (nums[i] & (1 << j)) > 0 ? 1 : 0;
				if (bit == 0) {
					if (curr.children[1] != null) {
						// left shift the existing val by 1 (i.e multiplying by 2)
						// & add 1 as the 0th place is 1 (as two different bits XOR, gives 1)
						val = val * 2 + 1;
						curr = curr.children[1];
					} else {
						// left shift the existing val by 1 (i.e multiplying by 2)
						// & add 0 as the 0th place is 0 (as two same bits XOR, gives 0)
						val = val * 2;
						curr = curr.children[0];
					}
				} else {
					if (curr.children[0] != null) {
						val = val * 2 + 1;
						curr = curr.children[0];
					} else {
						val = val * 2;
						curr = curr.children[1];
					}
				}
			}
			max = Math.max(max, val);
		}
		return max;
	}

}

class TriNode {
	boolean isEnd;
	TriNode children[];

	public TriNode() {
		children = new TriNode[2];
	}
}
