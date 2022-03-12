package intuit;
// 1011. Capacity To Ship Packages Within D Days

//https://www.youtube.com/watch?v=1w4-rZhP7BM Pepcoding Problem Reference

//410. Split Array Largest Sum (Same solution)
//Binary Search (Kunal)
public class Q7_CapacityToShipPackagesWithin_D_Days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        int res = -1;
        
        for(int i=0; i<weights.length; i++) {
            start = Math.max(start, weights[i]); // maximum element in the array
            end += weights[i]; // sum of all elements
        }
        
        // binary search
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if(isValid(weights, weights.length, days, mid) == true) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }
        
    private static boolean isValid(int[] weights, int l, int days, int mx) {
            int sum = 0;
            int count_days = 1;
            
            for(int i=0; i<l; i++) {
                sum += weights[i];
                
                if(sum > mx) {
                    sum = weights[i];
                    count_days++;
                }
                if(count_days > days){
                    return false;
                }
            }
            return true;
    }
}


