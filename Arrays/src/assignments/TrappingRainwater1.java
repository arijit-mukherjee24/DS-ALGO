package assignments;
// https://www.youtube.com/watch?v=UZG3-vZlFM4 (Anuj Bhaiya)

// https://www.youtube.com/watch?v=UZG3-vZlFM4 (techdose)

public class TrappingRainwater1 {

	public static void main(String[] args) {
		// int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] height = { 4, 2, 0, 3, 2, 5 };

		int ans = trap(height);
		System.out.println("The maximum profit is " + ans);
	}

	private static int trap(int[] height) {
		// Ref: https://www.youtube.com/watch?v=UZG3-vZlFM4
		int n = height.length;

		int left[] = new int[n];
		int right[] = new int[n];

		left[0] = height[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}

		right[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}

		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			ans += (Math.min(left[i], right[i]) - height[i]);
		}
		return ans;
	}

}
