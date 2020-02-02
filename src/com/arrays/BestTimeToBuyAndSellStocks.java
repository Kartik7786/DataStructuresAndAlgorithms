package com.arrays;

public class BestTimeToBuyAndSellStocks {

	public int maxProfit(int[] prices) {

		int minprice = Integer.MAX_VALUE;
		int maxprofit = 0;

		for (int i = 0; i < prices.length - 1; i++) {

			minprice = Math.min(prices[i], minprice);
			maxprofit = Math.max(prices[i + 1] - minprice, maxprofit);
		}
		return maxprofit;
	}

}
