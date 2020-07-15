package com.cg.leetcode.math;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countPrimes(2) + "  " + (int) Math.sqrt(4));

	}

	/*
	 * Sieve of Eratosthenes:1.构建一个从2开始到n-1的数组；2.令p =
	 * 2；3.从p开始，每次标记以p为间隔直到n的所有数，p不标记， 4.令p等于下一个没有标记的数，重复步骤3，直到p*p>n
	 * Tips:所有的偶数都可以直接排除；p*因子，每次因子从p开始++；当p*p>n时，所有的数都经过了判断，剩下的没标记的数就是小于n的所有素数
	 * 这个方法可以用来判断一个数是不是素数：先判断奇偶，然后判断从3到(int)Math.sqrt(n)的所有奇数是否是n的因子
	 */
	public static int countPrimes(int n) {
		if (n <= 1)
			return 0;
		int res = 0;// 1不是prime，从2开始判断
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i;
		}
		int p = 2;
		while (p * p < n) {
			for (int j = p; j * p < n; j++) {
				nums[j * p] = 0;
			}
			p++;
			while (p <= n && nums[p] == 0) {
				p++;
			}
		}
		for (int j = n - 1; j >= 2; j--) {
			if (nums[j] != 0)
				res++;
		}
		return res;
	}
}
