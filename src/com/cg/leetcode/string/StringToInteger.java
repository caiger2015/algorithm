package com.cg.leetcode.string;

/**
 * @author caiger
 *
 */
public class StringToInteger {

	public static void main(String[] args) {

		System.out.print(stoi("   010"));
	}

	public static int stoi(String s) {
		if (s == null)
			return 0;
		// 去空格,trim返回的是一个新的字符串
		s = s.trim();
		if (s.length() == 0)
			return 0;
		int i = 0, res = 0;
		boolean isNeg = false;
		// 处理开头的+-号
		if (s.charAt(i) == '+')
			i++;
		else if (s.charAt(i) == '-') {
			isNeg = true;
			i++;
		}
		// 判断每一位是否是数字
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			int digit = s.charAt(i) - '0';
			// 未计算res之前线比较是否越界
			if (isNeg && -res < (Integer.MIN_VALUE + digit) / 10)
				return Integer.MIN_VALUE;
			if (!isNeg && res > (Integer.MAX_VALUE - digit) / 10)
				return Integer.MAX_VALUE;
			res = res * 10 + digit;
			i++;
		}
		return isNeg ? -1 * res : res;
	}

	public int myAtoi(String s) {
		if (s == null)
			return 0;
		// 去空格
		s = s.trim();
		if (s.length() == 0)
			return 0;
		int i = 0, flag = 1, res = 0;
		// 判断开头的符号
		if (s.charAt(i) == '+') {
			flag = 1;
			i++;
		} else if (s.charAt(i) == '-') {
			i++;
			flag = -1;
		}
		// 没到头和是数字的情况计算res
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			// 这一位数字值为正
			int digit = s.charAt(i) - '0';
			// 处理越界的情况，如果先计算res则有可能计算越界(特殊情况：Integer.MAX_VALUE+1 =
			// Integer.MIN_VALUE)
			// 应该在少一位的情况下变换不等式比较
			if (flag == -1 && res < (Integer.MIN_VALUE + digit) / 10)
				return Integer.MIN_VALUE;
			if (flag == 1 && res > (Integer.MAX_VALUE - digit) / 10)
				return Integer.MAX_VALUE;
			res = res * 10 + digit * flag;
			i++;
		}
		return res;
	}
}
