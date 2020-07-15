package com.cg.leetcode.math;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countPrimes(2) + "  " + (int) Math.sqrt(4));

	}

	/*
	 * Sieve of Eratosthenes:1.����һ����2��ʼ��n-1�����飻2.��p =
	 * 2��3.��p��ʼ��ÿ�α����pΪ���ֱ��n����������p����ǣ� 4.��p������һ��û�б�ǵ������ظ�����3��ֱ��p*p>n
	 * Tips:���е�ż��������ֱ���ų���p*���ӣ�ÿ�����Ӵ�p��ʼ++����p*p>nʱ�����е������������жϣ�ʣ�µ�û��ǵ�������С��n����������
	 * ����������������ж�һ�����ǲ������������ж���ż��Ȼ���жϴ�3��(int)Math.sqrt(n)�����������Ƿ���n������
	 */
	public static int countPrimes(int n) {
		if (n <= 1)
			return 0;
		int res = 0;// 1����prime����2��ʼ�ж�
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
