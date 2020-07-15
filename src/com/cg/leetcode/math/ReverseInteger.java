/**
 * 
 */
package com.cg.leetcode.math;

import java.util.Stack;

public class ReverseInteger {

	public static void main(String[] args) {
		Solution sl = new Solution();
		System.out.println(sl.reverse3(Integer.MIN_VALUE));
	}
}

class Solution {
	private Stack<Character> stack = new Stack<Character>();
	private StringBuffer result;

	// ��ջ����̫�����ӣ�ջ�������������ȼ���
	public int reverse(int x) {

		String str = Integer.toString(x);
		int i = 0, sim = 0;
		if (str.charAt(0) == '-') {
			sim = -1;
			i++;
		}
		if (str.charAt(0) == '+') {
			sim = 1;
			i++;
		}
		// �����������Ϊelse��Ӧ������һ��if�����������һ����������
		// ���sim���¸�ֵ
		// else {
		// sim = 1;
		// }
		// StringBufferʹ��ʱҪ��ʼ����С
		result = new StringBuffer(str.length() - i);
		for (; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		while (!stack.isEmpty())
			result.append(stack.pop());
		double db = Double.valueOf(result.toString());
		if (db * sim > Integer.MAX_VALUE || db * sim < Integer.MIN_VALUE)
			return 0;
		return (int) db * sim;
	}

	// ת����StringBuffer������������Դ̫��
	public int reverse2(int x) {
		int sim = 0;
		if (x < 0)
			sim = -1;
		else
			sim = 1;
		// double result = x*sim;
		// ����double��˫���ȸ�������ת����String��"xxx.0"
		// ����reverse����֮���ǡ�0.xxx��
		long result = (long) x * sim;// ��Ҫ��ʾת���������ǻ����
		StringBuffer str = new StringBuffer(result + "");
		// StringBuffer str = new StringBuffer(x*sim+"");
		// tip����x = int��Сֵʱ�����ľ���ֵ��int���ֵ+1������ˣ�
		StringBuffer str1 = str.reverse();
		result = Long.valueOf(str1.toString());
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		return (int) result * sim;

	}

	// ��������ѧ������������Ϊ���ֱ����������ģ�
	// ����ֻ��Ҫ���Ǻ÷��ź��������Ϳ�����
	// ��ѭ�����������
	public int reverse3(int x) {
		long res = 0;
		if (x == Integer.MIN_VALUE)
			return 0;
		int temp = Math.abs(x);
		while (temp > 0) {
			res = res * 10 + temp % 10;// ȡ�෽ʽȡ���һλ
			temp /= 10;// ��ȥ���һλ
		}
		if (res > Integer.MAX_VALUE)
			return 0;

		if (x > 0)
			return (int) res;
		return (int) res * -1;

	}

}