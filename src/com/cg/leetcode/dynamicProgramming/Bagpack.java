/**
 * 背包问题：n件（唯一）不同价值不同重量的物品放入容量c的背包，求出最大价值
 * @caiger
 */
package com.cg.leetcode.dynamicProgramming;

public class Bagpack {

	public static void main(String[] args) {
		int x = new Bagpack().bagPack2(2, 2, new int[]{3, 2}, new int[]{1, 2});
		System.out.print(x + "");
	}

	/**
	 * @param n 物品数量
	 * @param c 背包容量
	 * @param w 物品重量数组
	 * @param v 物品价值数组
	 * @return
	 */
	public int bagPack(int n, int c, int[] w, int[] v) {
		int[][] res = new int[n][c + 1];
		for (int i = 1; i <= c; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					// if(w[j]>i+1)//这里i+1是容量
					if (w[j] > i) {
						res[j][i] = 0;
					} else {
						res[j][i] = v[j];
					}
				} else {
					/*
					 * if(w[j]>i)//这里是判断序号的，但是遗漏了一种情况w[j] = i+1 { if(w[j] ==
					 * i+1&&res[j-1][i] == 0) res[j][i] = v[j]; else{ res[j][i]
					 * = res[j-1][i]; } }
					 */
					if (w[j] > i) {
						res[j][i] = res[j - 1][i];
					} else {
						res[j][i] = Math.max(res[j - 1][i], (res[j - 1][i - w[j]] + v[j]));
					}
				}
			}
		}
		return res[n - 1][c];
	}

	public int bagPack2(int n, int c, int[] w, int[] v) {
		//dp[i][j]的含义是当决定完第i个物品且背包重量为j时的最大价值
		int[][] dp = new int[n][c + 1];
		//处理第0个物品的状态
		for (int i = 0; i < n; i++) {
			if (w[i] <= c) {
				dp[0][w[i]] = v[i];
			}
		}
		for (int i = 1; i < n; i++) {
			//j是当前背包容量
			for (int j = 1; j <= c; j++) {
				//当前物品重量大于背包容量时不放入背包，继承上一状态结果
				if (w[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {//当前物品重量小于背包容量时，比较是否放入i时的最大价值
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
			}
		}
		return dp[n - 1][c];
	}
}
