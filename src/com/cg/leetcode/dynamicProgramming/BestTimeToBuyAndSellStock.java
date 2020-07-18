package com.cg.leetcode.dynamicProgramming;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(maxProfit(new int[] { 5, 4, 3, 2, 1 }));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int profit = 0;
		int buy = prices[0];
		for (int i = 1; i < n; i++) {
			int sell = prices[i];
			if (buy >= sell) {
				buy = sell;
			} else {
				profit = Math.max(profit, sell - buy);
			}
		}
		return profit;
	}
}
