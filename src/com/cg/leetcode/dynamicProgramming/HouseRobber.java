package com.cg.leetcode.dynamicProgramming;

/*
 * 动态规划问题，转化为若干个递推的子问题，
 * 找出递推公式，确定初始条件，逐步退出各阶段的结果直到最后
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob(int[] num) {
		int len = num.length;
		int[] res = new int[len];
		// 数字长度为零，是一个包含零个元素的对象，返回时不需要判断
		// int[] A = null; 表示A的引用为空，返回时要判断是否为空
		if (len == 0)
			return 0;
		if (len == 1)
			return num[0];
		if (len == 2)
			return Math.max(num[0], num[1]);
		res[0] = num[0];
		res[1] = Math.max(num[1], num[0]);

		for (int i = 2; i < len; i++) {
			res[i] = Math.max(res[i - 1], res[i - 2] + num[i]);
		}
		return res[len - 1];
	}
}
