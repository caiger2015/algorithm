package com.cg.leetcode.dynamicProgramming;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
//        for (int i = 1; i < n; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (s.charAt(j) == s.charAt(i)) {
//                    dp[j][i] = dp[j + 1][i - 1] + 2;
//                } else {
//                    dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
//                }
//            }
//        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
