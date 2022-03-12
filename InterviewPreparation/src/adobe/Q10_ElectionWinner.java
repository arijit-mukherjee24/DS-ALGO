package adobe;
// https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1/ gfg practice
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q10_ElectionWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Function to return the name of candidate that received maximum votes.
	public static String[] winner(String arr[], int n) {
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for (String s : arr) {
			map.put(s, map.getOrDefault(s, 0) + 1);
			if (map.get(s) > max)
				max = map.get(s);
		}

		String[] res = new String[2];
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (String s : map.keySet()) {
			if (map.get(s) == max) {
				pq.add(s);
			}
		}

		res[0] = pq.peek();
		res[1] = Integer.toString(max);
		return res;
	}

}
