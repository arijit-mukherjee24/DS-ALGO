package intuit;
// 875. Koko Eating Bananas

//Binary Search: https://www.youtube.com/watch?v=yBU4tsVg7-c Naresh Gupta
//TC: O(nlogD) D=Range; Here D = 1 to 10^9
public class Q15_KokoEatingBananas {

	public static void main(String[] args) {

	}

	public int minEatingSpeed(int[] piles, int h) {
		int low = 1, high = 1000000000;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (isPossible(piles, h, mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private boolean isPossible(int[] piles, int h, int k) {
		int time = 0;
		for (int p : piles) {
			time += (p - 1) / k + 1;
			if (time > h)
				break;
		}
		return (time <= h);
	}

}


/*
//Brute Force (TLE)
class Solution {
 public int minEatingSpeed(int[] piles, int h) {
     int k=1;
     for(; k<1000000001; k++) {
         int time = 0;
         for(int p: piles) {
             time += (p-1)/k + 1;
             if(time > h) 
                 break;
         }
         
         if(time <= h) break;
     }
     return k;
 }
}
*/