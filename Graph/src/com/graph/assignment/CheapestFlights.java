package com.graph.assignment;
// Leetcode 787. Cheapest Flights Within K Stops
import java.util.Arrays;

//Bellman Ford Algo Modification
//Ref: https://www.youtube.com/watch?v=5eIK3zUdYmE Neetcode
//https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
public class CheapestFlights {

	public static void main(String[] args) {

	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;

		for (int i = 0; i <= k; i++) // we will relax k+1 times
		{
			int[] temp = Arrays.copyOf(cost, n);
			for (int[] f : flights) {
				int curr = f[0], next = f[1], price = f[2];
				if (cost[curr] == Integer.MAX_VALUE)
					continue;
				temp[next] = Math.min(temp[next], cost[curr] + price);
			}
			cost = temp;
		}
		return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
	}

}

/* TLE in Leetcode
 * // Dijkstra's Algo Modification
// Ref: https://www.youtube.com/watch?v=IQOG3w4abAg Knowledge Center
// https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        // If K = x, then edges between them = x + 1 (maxlimit) : reducing limit one by one
        // [distance, currentNode u, edges remaining of the max limit]
        q.offer(new int[]{0,src,k+1});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int cost=c[0];
            int curr=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop>0)
            {
                if(!map.containsKey(curr))
                    continue;
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{cost+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }
}
 */
