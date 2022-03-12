package intuit;

import java.util.HashMap;
import java.util.Map;

// 447. Number of Boomerangs

//https://www.youtube.com/watch?v=TXOfMJCPTr0 Youtube

//https://leetcode.com/problems/number-of-boomerangs/discuss/92861/Clean-java-solution%3A-O(n2)-166ms

//Time complexity:  O(n^2)
//Space complexity: O(n)

/*
nPr = n!/(n-r)! where r = 2,
It comes down to N!/(N-2)! which is N * (N-1).

For every i, we capture the number of points equidistant from i. Now for this i, we have to calculate all possible permutations of (j,k) from these equidistant points.

Total number of permutations of size 2 from n different points is nP2 = n!/(n-2)! = n * (n-1).

*/
public class Q8_NumberofBoomerangs {

	public static void main(String[] args) {

	}
	
	public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i==j) // We are not considering the same points
                    continue;
                
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            
            for(int val: map.values()) {
                res += val*(val-1);
            }
            map.clear();
        }
        
        return res;
    }
    
    static int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        
        return (dx*dx + dy*dy);
    }
}


