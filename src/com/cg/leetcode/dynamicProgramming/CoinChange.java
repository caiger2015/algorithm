package com.cg.leetcode.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int c : coins) {
            if (c <= amount) {
                dp[c] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            int temp = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] != -1) {
                    temp = Math.min(temp, dp[i - c]);
                }
            }
            if (temp != Integer.MAX_VALUE) {
                dp[i] = temp + 1;
            } else {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
