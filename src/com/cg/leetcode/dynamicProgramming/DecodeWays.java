package com.cg.leetcode.dynamicProgramming;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(decodeWays("1001"));
	}

	/*
	 * ��������ƹ�ʽ�������ж�!��Ҫע���ʼ������ȷ�����������ƣ�
	 */
	public static int decodeWays(String s) {
		if (s == null || s.length() == 0)
			return 0;
		// ��һ�����ֲ���Ϊ0�������޷�decode
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
			// �жϵ�ǰ�����Ƿ����decode�� != 0����������ԣ���res[i]����Ϊres[i-1];
			if (cur != 0)
				res[i] = res[i - 1];
			// �жϵ�ǰ�����Ƿ���Ժ�ǰһ������decode(ǰһ������>0,����Ϻ�<27),���������res[i] += res[i-1];
			if (pre != 0) {
				if (temp > 0 && temp < 27)
					res[i] += res[i - 2];
			}
			// ���pre��cur��Ϊ0����ôres[i] = 0,���´�ѭ���У���Ӧ��res[i-1] == 0����pre ==
			// 0��res[i] = 0,���ε���ֱ�����ȫΪ0
		}
		return res[n];
	}
}
