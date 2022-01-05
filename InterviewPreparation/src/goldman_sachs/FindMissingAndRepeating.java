package goldman_sachs;

//https://www.youtube.com/watch?v=5nMGY4VUoRY Striver
//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/ GFG
//https://www.techiedelight.com/find-missing-number-duplicate-elements-array/ Techdelight

//https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1/
public class FindMissingAndRepeating {
	
	public static void main(String[] args) {

	}
	
	int[] findTwoElement(int arr[], int n) {
		int[] ans = new int[2];

		int xor1, x, y, set_bit_no;
		x = 0;
		y = 0;
		xor1 = arr[0];

		for (int i = 1; i < n; i++)
			xor1 = xor1 ^ arr[i];

		for (int i = 1; i <= n; i++)
			xor1 = xor1 ^ i;
         
        /* Get the rightmost set bit in set_bit_no (Finding the lowest significant bit number) )
        set_bit_no = xor1 & ~(xor1-1); */
        
        // Get the msb set bit in set_bit_no (Finding the most significant bit number)
		int k = (int) (Math.log(xor1) / Math.log(2));
		set_bit_no = 1 << k;

		for (int i = 0; i < n; i++) {
			if ((arr[i] & set_bit_no) != 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((i & set_bit_no) != 0) {
				x = x ^ i;
			} else {
				y = y ^ i;
			}
		}
        
        
        // Repeating Number and Missing Number identification
        /*import java.util.stream.Collectors;
        if(Arrays.stream(arr).boxed().collect(Collectors.toList()).contains(x)) {
            ans[0] = x; // repeating number
            ans[1] = y; // missing number
        }
        else {
            ans[0] = y; // repeating number
            ans[1] = x; // missing number
        }*/
		for (int i = 0; i < n; i++) {
			if (x == arr[i]) {
				ans[0] = x; // repeating number
				ans[1] = y; // missing number
				break;
			} else if (y == arr[i]) {
				ans[0] = y; // repeating number
				ans[1] = x; // missing number
				break;
			}
		}

		return ans;
    }
}
