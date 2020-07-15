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
		int temp = 1;// λ��
		int left = 0;
		int right = 0;
		while (res / temp >= 10)// Ҫ������ֹ������ȡֵ������
		{
			temp *= 10;
		}

		while (res != 0 && temp > 1)// ��ֹ������ѡ�����򵥣�ѡ��while�ⲿ����ı���
		{
			left = res / temp;
			right = res % 10;
			// ��if�ж���ʵ������
			if (left != right)
				return false;
			res = (res - right - left * temp) / 10;
			temp /= 100;

		}
		return true;
	}
}
