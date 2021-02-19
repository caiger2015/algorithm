package com.cg.leetcode.dynamicProgramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        /**
         * 状态：比较word1.charAt(i)与word2.chatAt(j)时的最小距离
         * 选择：删除word1.charAt(i)、替换为word2.chatAt(j)、保留word1.charAt(i)插入word2.chatAt(j)
         * dp数组含义：比较word1中第i位与word2中第j位时的最小距离（word1.charAt(i-1)与word2.chatAt(j-1)）
         * 多一位存初始状态
         */
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始状态：与空串比较时最小距离为当前长度
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //索引比字符串中字符多一位
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //分别为对word1删除、插入、替换的操作
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
