package com.cg.leetcode.dynamicProgramming;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(decodeWays("1001"));
	}

	/*
	 * 搞清楚递推公式的条件判定!还要注意初始条件的确定，用来递推！
	 */
	public static int decodeWays(String s) {
		if (s == null || s.length() == 0)
			return 0;
		// 第一个数字不能为0，否则无法decode
		if (s.charAt(0) == '0')
			return 0;
		int n = s.length();
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			int pre = s.charAt(i - 2) - '0';
			int cur = s.charAt(i - 1) - '0';
			int temp = pre * 10 + cur;
			// 判断当前数字是否可以decode（ != 0），如果可以，则res[i]至少为res[i-1];
			if (cur != 0)
				res[i] = res[i - 1];
			// 判断当前数字是否可以和前一个数字decode(前一个数字>0,且组合后<27),如果可以则res[i] += res[i-1];
			if (pre != 0) {
				if (temp > 0 && temp < 27)
					res[i] += res[i - 2];
			}
			// 如果pre和cur都为0，那么res[i] = 0,在下次循环中，对应的res[i-1] == 0，且pre ==
			// 0，res[i] = 0,依次递推直到最后全为0
		}
		return res[n];
	}
}
