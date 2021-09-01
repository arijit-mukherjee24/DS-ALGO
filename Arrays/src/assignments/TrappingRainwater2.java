package assignments;
// https://www.youtube.com/watch?v=UZG3-vZlFM4 (Anuj Bhaiya)

// https://www.youtube.com/watch?v=UZG3-vZlFM4 (techdose)

public class TrappingRainwater2 {

	public static void main(String[] args) {
		// int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 4, 2, 0, 3, 2, 5 };

		int ans = trap(height);
		System.out.println("The maximum profit is " + ans);
	}

	// GFG and Techdose
	private static int trap(int[] height) {
		 int n = height.length;
	        
	        int left = 0;
	        int right = n-1;
	        
	        int left_max = 0;
	        int right_max = 0;
	        int ans = 0;
	        
	        while(left <= right) {
	            if(right_max <= left_max) {
	                ans += Math.max(0, right_max - height[right]);
	                right_max = Math.max(right_max, height[right]);
	                
	                right--;
	            }
	            else {
	                ans += Math.max(0, left_max - height[left]);
	                left_max = Math.max(left_max, height[left]);
	                
	                left++;
	            }
	        }
	        
	        return ans;
	}

}
