import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*1. 	Given an array, for each element find the value of the nearest element to the right which is having a frequency greater than as that of the current element. If there does not exist an answer for a position, then make the value ‘-1’.
Input : a[] = [1, 1, 2, 3, 4, 2, 1]
Output : 	[-1, -1, 1, 2, 2, 1, -1]*/

// 	 1 -> 3
//   2 -> 2
//   3 -> 1
//   4 -> 1

public class NextGreaterElementByFreq {

	public static void main(String[] args) {
		int[] a = {1, 1, 2, 3, 4, 2, 1};
		int n = a.length;
		
		int[] res = new int[n];
		Arrays.fill(res, -1);
		
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		
		for(int i: a) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}
		
		//System.out.println("Freq count");
		
		Stack<Pair> st = new Stack<>();
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty()) {
				Pair p = st.peek();
				if(p.freq <= freqMap.get(a[i])) {
					st.pop();
				}
				else {
					res[i] = p.element;
					break;
				}
			}
				
			st.push(new Pair(a[i], freqMap.get(a[i])));
		}
		
		for(int i: res) {
			System.out.print(i+" ");
		}
	}

}

class Pair {
	int element;
	int freq;
	public Pair(int element, int freq) {
		super();
		this.element = element;
		this.freq = freq;
	}
}
