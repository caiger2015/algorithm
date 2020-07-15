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
	 * ĩβ�е�0��������5*2��ÿһ��5�����㹻��2�������ҳ�1~n�ж��ٸ�5���ɡ� ps:25������5,50������5
	 * �����ҳ����е�5^x�Լ����Ǳ����ĸ��� [n/k]����1~n���ܱ�k�����ĸ���
	 */
	//
	public static int trailingZeroes(int n) {
		if (n < 5)
			return 0;
		int res = 0;
		while (n > 1)// �ڼ����ʱ��Ӧ�ü�С��ֵ������
		{
			res += n / 5;
			n /= 5;
		}
		return res;
	}

	// �ҳ�n���м���5^x��ͬ����ʱ�ˡ�����
	// [n/k]����1~n���ܱ�k�����ĸ���
	public static int trailingZeroes2(int n) {
		int temp = 5;
		int res = 0;
		while (n >= temp)// ���ּ�����������ֵ�ܴ��ʱ���ٶȺ���
		{
			res += n / temp;
			temp *= 5;
		}
		return res;
	}

	// ʱ�临�Ӷ�O(nlog5(n)),��ʱ��
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
