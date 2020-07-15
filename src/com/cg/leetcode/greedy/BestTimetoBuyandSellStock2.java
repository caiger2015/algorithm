package com.cg.leetcode.greedy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i. Design an algorithm to find the maximum profit. You may complete as
 * many transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author caiger
 */
public class BestTimetoBuyandSellStock2 {

	public static void main(String[] args) {
		System.out.print(maxProfit(new int[] { 1, 2, 2, 5, 3, 4, 1, 2, 1 }));
	}

	/*
	 * 每一段单调递增的段都是profit
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int n = prices.length;
		int i = 1;
		int profit = 0;
		int buy = prices[0];
		while (i < n) {
			int pre = prices[i - 1];
			int cur = prices[i];
			if (pre > cur) {
				profit += (pre - buy);
				buy = cur;
			}
			i++;
		}
		if (prices[n - 1] > buy)
			profit += (prices[n - 1] - buy);
		return profit;
	}

	/*
	 * 所有增加的部分都是profit，sum = sum+a[i]-a[i-1](if a[i]>a[i-1])
	 */
	public static int maxPro(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int i = 1;
		int profit = 0;
		while (i < prices.length) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0)
				profit += diff;
			i++;
		}
		return profit;
	}
}
