package assignment;

// Leetocde 169 
// Refer Techdose videos
public class MajorityElement {

	public static void main(String[] args) {
		int nums[] = { 2, 2, 1, 1, 1, 2, 2 };
	//	int nums[] = { 3, 2, 3 };
	//	int nums[] = {1};
		majorityElement(nums);
 	}
	
	 public static int majorityElement(int[] nums) {
	        long size = nums.length;
			// variable to calculate the majority element
			long ans = 0;
			long shift = 1;

			// loop to iterate through all the bits of a number
			for (long i = 0; i <= 32; i++) {
				long count = 0;

				// loop to iterate through all elements in array to count
				// the total number of set bits at position i from right
				for (long ele : nums) { // Here we are converting the int to long using implicit type casting(
										// automatically done by the compiler)
					if ((ele & shift) > 0) {
						count += 1;
					}
				}
				// if the total sets bits exceeds n/2,
				// this bits should be present in majority element
				if ((count > (size / 2))) {
					ans += shift;
				}
				shift *= 2;
			}

			int count = 0;
			// Iterate through the array to get the count of the candidate majority element
			for (long ele : nums) {
				if (ele == ans) {
					count++;
				}
			}
			
			// verify if the count exceeds n/2
			if ((count > (size / 2))) {
				System.out.println("The majority element is "+ ans);
	        } else {
	        	System.out.println("There is no majority element of size greater than length2");
	        }

			return (int) ans;
	    }

}
