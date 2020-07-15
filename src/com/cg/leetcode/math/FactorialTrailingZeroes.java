package com.cg.leetcode.math;

/*
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(trailingZeroes(2147483647) + "");
	}

	/*
	 * 末尾有的0，来自于5*2，每一个5都有足够的2，所以找出1~n有多少个5即可。 ps:25算两个5,50算两个5
	 * 就是找出所有的5^x以及它们倍数的个数 [n/k]代表1~n中能被k整除的个数
	 */
	//
	public static int trailingZeroes(int n) {
		if (n < 5)
			return 0;
		int res = 0;
		while (n > 1)// 在计算的时候应该减小数值来计算
		{
			res += n / 5;
			n /= 5;
		}
		return res;
	}

	// 找出n中有几个5^x，同样超时了。。。
	// [n/k]代表1~n中能被k整除的个数
	public static int trailingZeroes2(int n) {
		int temp = 5;
		int res = 0;
		while (n >= temp)// 这种计数法计算数值很大的时候速度很慢
		{
			res += n / temp;
			temp *= 5;
		}
		return res;
	}

	// 时间复杂度O(nlog5(n)),超时了
	public static int trailingZeroes1(int n) {
		int res = 0;
		n = n - (n % 5);
		for (; n > 0; n -= 5) {
			res++;
			int temp = n / 5;
			while (temp % 5 == 0 && temp > 1) {
				res++;
				temp /= 5;
			}
		}
		return res;
	}
}
