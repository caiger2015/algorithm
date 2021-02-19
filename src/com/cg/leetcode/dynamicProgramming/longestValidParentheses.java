package com.cg.leetcode.dynamicProgramming;

import java.util.LinkedList;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        //存最后一个没有被匹配的括号下标，匹配时长度为当前下标减去栈顶下标
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                //stack为空时，存入右括号下标，用于下次计算
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            //遇到右括号事处理匹配
            if (s.charAt(i) == ')') {
                //...dp[i-2]()情况
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i == 1 ? 2 : dp[i - 2] + 2;
                    //...i-dp[i-1]-2,i-dp[i-1]-1,(...i-1)i)情况
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
