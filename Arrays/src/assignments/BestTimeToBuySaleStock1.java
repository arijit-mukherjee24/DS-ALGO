package assignments;

public class BestTimeToBuySaleStock1 {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		// int[] prices = { 7, 6, 4, 3, 1 };

		int maxProfit = maxProfit(prices);
		System.out.println("The maximum profit is " + maxProfit);
	}

	private static int maxProfit(int[] prices) {

		int maxProfit = 0;
		int minPriceSoFar = prices[0];

		for (int i = 0; i < prices.length; i++) {
			minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
			int profit = prices[i] - minPriceSoFar;
			maxProfit = Math.max(maxProfit, profit);
		}
		return maxProfit;
	}

}
