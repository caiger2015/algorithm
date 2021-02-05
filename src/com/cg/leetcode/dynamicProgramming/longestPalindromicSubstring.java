package com.cg.leetcode.dynamicProgramming;

public class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int begin = 0;
        int max =1;
        int len = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        /*
        1.dp(i,j)表示i-j是否回文
        2.状态转移：dp[i][i]=true;dp[i][j]=dp[i+1][j-1]&&s(i)=s(j)
        3.状态更新以l为间隔，从0开始更新，因为回溯上一状态是收缩下标，所以先更新(i,i)，再更新01，12，23，34，然后是02，13，24
         */
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = l == 1 || dp[i + 1][j - 1];
                }
                if (dp[i][j] && l + 1 > max) {
                    max = l + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
