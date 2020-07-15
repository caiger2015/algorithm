package com.cg.leetcode.math;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 slSolution = new Solution2();
		if (slSolution.isPalindrome(1000021))
			System.out.print("1");

	}
}

class Solution2 {
	public boolean isPalindrome(int x) {
		if (x == Integer.MIN_VALUE)
			return false;
		int res = Math.abs(x);
		int temp = 1;// 位数
		int left = 0;
		int right = 0;
		while (res / temp >= 10)// 要推敲终止条件的取值！！！
		{
			temp *= 10;
		}

		while (res != 0 && temp > 1)// 终止条件的选择尽量简单，选择while外部定义的变量
		{
			left = res / temp;
			right = res % 10;
			// 用if判断来实现跳出
			if (left != right)
				return false;
			res = (res - right - left * temp) / 10;
			temp /= 100;

		}
		return true;
	}
}
