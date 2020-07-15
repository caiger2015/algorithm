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
		// ȥ�ո�,trim���ص���һ���µ��ַ���
		s = s.trim();
		if (s.length() == 0)
			return 0;
		int i = 0, res = 0;
		boolean isNeg = false;
		// ����ͷ��+-��
		if (s.charAt(i) == '+')
			i++;
		else if (s.charAt(i) == '-') {
			isNeg = true;
			i++;
		}
		// �ж�ÿһλ�Ƿ�������
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			int digit = s.charAt(i) - '0';
			// δ����res֮ǰ�߱Ƚ��Ƿ�Խ��
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
		// ȥ�ո�
		s = s.trim();
		if (s.length() == 0)
			return 0;
		int i = 0, flag = 1, res = 0;
		// �жϿ�ͷ�ķ���
		if (s.charAt(i) == '+') {
			flag = 1;
			i++;
		} else if (s.charAt(i) == '-') {
			i++;
			flag = -1;
		}
		// û��ͷ�������ֵ��������res
		while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			// ��һλ����ֵΪ��
			int digit = s.charAt(i) - '0';
			// ����Խ������������ȼ���res���п��ܼ���Խ��(���������Integer.MAX_VALUE+1 =
			// Integer.MIN_VALUE)
			// Ӧ������һλ������±任����ʽ�Ƚ�
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
